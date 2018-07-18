package com.cocosh.shmstore.http

import com.cocosh.shmstore.base.BaseModel
import com.cocosh.shmstore.base.BaseActivity
import com.cocosh.shmstore.http.Constant.UPDATE_IMAGE
import com.cocosh.shmstore.utils.LogUtil
import com.google.gson.Gson
import com.rxjava2.android.samples.utils.ApiService
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.io.File
import java.lang.reflect.ParameterizedType
import java.util.concurrent.TimeUnit


/**
 *
 * Created by lmg on 2017/9/28.
 */
object ApiManager {
    private lateinit var apiService: ApiService
    private lateinit var retrofit: Retrofit
    private lateinit var okHttpClient: OkHttpClient
    private val host = if (Constant.DEBUG) "http://10.10.0.90/" else "http://app.sm1168.com"

    init {
        init()
    }

    private fun init() {
        /*
        * 初始化OkHttpClient
        */
        okHttpClient = OkHttpClient.Builder()
                .addInterceptor(LoggerInterceptor("网络请求"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build()

        /*
         * 初始化Retrofit
         */
        retrofit = Retrofit.Builder()
                .baseUrl(host)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
        apiService = retrofit.create(ApiService::class.java)
    }


    /**
     * 发起一个网络请求并解析成实体类
     */
    private fun <T> request(baseActivity: BaseActivity, observable: Observable<ResponseBody>, onResult: OnResult<T>) {

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ResponseBody> {

                    override fun onNext(data: ResponseBody) {
                        val body = data.string()
                        val baseModel: BaseModel<T>
                        LogUtil.e("Body:$body")
                        val t = (onResult.javaClass.genericInterfaces[0] as ParameterizedType).actualTypeArguments[0]
                        val stringType = String::class.java.simpleName
                        baseModel = if (!t.toString().contains(stringType)) {
                            val jsonParser = Gson()
                            jsonParser.fromJson(body, BaseModel<T>().javaClass)
                        } else {
                            BaseModel()
                        }
                        baseModel.string = body
                        onResult.onSuccess(baseModel)
                    }

                    override fun onError(e: Throwable) {
                        onResult.onFailed(e)
                    }

                    override fun onComplete() {

                    }

                    override fun onSubscribe(disposable: Disposable) {
                        baseActivity.composites.add(disposable)
                    }

                })
    }


    /**
     * GET请求
     */
    fun <T> get(baseActivity: BaseActivity, params: Map<String, String>?, url: String, onResult: OnResult<T>) {
        if (params != null) {
            request(baseActivity, apiService.get(params, url), onResult)
        } else {
            request(baseActivity, apiService.get(url), onResult)
        }
    }


    /**
     *  Post请求
     */
    fun <T> post(baseActivity: BaseActivity, params: Map<String, String>, url: String, onResult: OnResult<T>) {
        request(baseActivity, apiService.post(params, url), onResult)
    }

    /**
     * Post一个JSON
     */
    fun <T> postJson(baseActivity: BaseActivity, params: String, url: String, onResult: OnResult<T>) {
        val requestBody = RequestBody.create(MediaType.parse("application/json"), params)
        request(baseActivity, apiService.post(requestBody, url), onResult)
    }


    /**
     * Post一张图片
     */
    fun <T> postImage(baseActivity: BaseActivity, path: String, onResult: OnResult<T>) {

        val requestBodyBuilder = MultipartBody.Builder().setType(MultipartBody.FORM)
        val file = File(path)
        requestBodyBuilder.addFormDataPart("file", path,
                RequestBody.create(MediaType.parse("image/jpeg"), file))
        requestBodyBuilder.addFormDataPart("picturetype", "jpg")
        request(baseActivity, apiService.post(requestBodyBuilder.build(), UPDATE_IMAGE), onResult)
    }


    /**
     * 结果回调
     */
    interface OnResult<T> {
        fun onSuccess(data: BaseModel<T>)
        fun onFailed(e: Throwable)
        fun onCatch(data: BaseModel<T>)
    }

    fun getHttpClient(): OkHttpClient = okHttpClient
}