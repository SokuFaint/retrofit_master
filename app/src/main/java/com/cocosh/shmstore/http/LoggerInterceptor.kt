package com.cocosh.shmstore.http

import android.text.TextUtils
import android.util.Log
import okhttp3.*
import okio.Buffer
import java.io.IOException

/**
 * OKHttp日志拦截
 * Created by lmg on 2017/10/12.
 */
class LoggerInterceptor @JvmOverloads constructor(tag: String, private val showResponse: Boolean = false) : Interceptor {
    private val tag: String

    init {
        var tag = tag
        if (TextUtils.isEmpty(tag)) {
            tag = TAG



        }
        this.tag = tag
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        logForRequest(request)
        val response = chain.proceed(request)
        return logForResponse(response)
    }

    private fun logForResponse(response: Response): Response {
        try {
            //===>response log
            Log.e(tag, "========response'log=======")
            val builder = response.newBuilder()
            val clone = builder.build()
            Log.e(tag, "url : " + clone.request().url())
            Log.e(tag, "code : " + clone.code())
            Log.e(tag, "protocol : " + clone.protocol())
            if (!TextUtils.isEmpty(clone.message()))
                Log.e(tag, "message : " + clone.message())

            if (showResponse) {
                var body = clone.body()
                if (body != null) {
                    val mediaType = body.contentType()
                    if (mediaType != null) {
                        Log.e(tag, "responseBody's contentType : " + mediaType.toString())
                        if (isText(mediaType)) {
                            val resp = body.string()
                            Log.e(tag, "responseBody's content : " + resp)

                            body = ResponseBody.create(mediaType, resp)
                            return response.newBuilder().body(body).build()
                        } else {
                            Log.e(tag, "responseBody's content : " + " maybe [file part] , too large too print , ignored!")
                        }
                    }
                }
            }

            Log.e(tag, "========response'log=======end")
        } catch (e: Exception) {
            //            e.printStackTrace();
        }

        return response
    }

    private fun logForRequest(request: Request) {
        try {
            val url = request.url().toString()
            val headers = request.headers()

            Log.e(tag, "========request'log=======")
            Log.e(tag, "method : " + request.method())
            Log.e(tag, "url : " + url)
            if (headers != null && headers.size() > 0) {
                Log.e(tag, "headers : " + headers.toString())
            }
            val requestBody = request.body()
            if (requestBody != null) {
                val mediaType = requestBody.contentType()
                if (mediaType != null) {
                    Log.e(tag, "requestBody's contentType : " + mediaType.toString())
                    if (isText(mediaType)) {
                        Log.e(tag, "requestBody's content : " + bodyToString(request))
                    } else {
                        Log.e(tag, "requestBody's content : " + " maybe [file part] , too large too print , ignored!")
                    }
                }
            }
            Log.e(tag, "========request'log=======end")
        } catch (e: Exception) {
            //            e.printStackTrace();
        }

    }

    private fun isText(mediaType: MediaType): Boolean {
        if (mediaType.type() != null && mediaType.type() == "text") {
            return true
        }
        if (mediaType.subtype() != null) {
            if (mediaType.subtype() == "json" ||
                    mediaType.subtype() == "xml" ||
                    mediaType.subtype() == "html" ||
                    mediaType.subtype() == "webviewhtml")
                return true
        }
        return false
    }

    private fun bodyToString(request: Request): String {
        try {
            val copy = request.newBuilder().build()
            val buffer = Buffer()
            copy.body()!!.writeTo(buffer)
            return buffer.readUtf8()
        } catch (e: IOException) {
            return "something error when show requestBody."
        }

    }

    companion object {
        val TAG = "HttpUtil"
    }
}