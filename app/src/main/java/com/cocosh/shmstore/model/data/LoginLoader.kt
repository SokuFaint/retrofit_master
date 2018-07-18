package com.cocosh.shmstore.model.data

import com.cocosh.shmstore.base.BaseActivity
import com.cocosh.shmstore.base.BaseModel
import com.cocosh.shmstore.http.ApiManager
import com.cocosh.shmstore.http.Constant
import com.cocosh.shmstore.login.LoginContract
import com.cocosh.shmstore.model.UserModel
import com.cocosh.shmstore.model.source.UserModelSource
import java.util.*

/**
 * 登录网络请求
 * Created by lmg on 2017/10/20.
 */
class LoginLoader(var activity: BaseActivity) : UserModelSource {

    override fun saveUser(user: UserModel) {

    }


    /**
     * 登录请求
     */
    override fun login(phone: String, password: String, loginView: LoginContract.View) {
        val map = HashMap<String, String>()
        map.put("cMob", phone.trim())
        map.put("cPass", password.trim())
        map.put("cLongitude", "")
        map.put("cLatitude", "")
        map.put("deviceId", "10010")
        map.put("deviceType", "0")

        ApiManager.post(activity, map, Constant.LOGIN, object : ApiManager.OnResult<UserModel> {
            override fun onSuccess(data: BaseModel<UserModel>) {

                loginView.onMessage(data.information)

                if (data.isSuccess()) {
                    /**
                     * 保存用户信息
                     */
                    saveUser(data.datas!!)
                    activity.finish()
                }
            }

            override fun onFailed(e: Throwable) {
                loginView.onMessage(e.localizedMessage)
            }

            override fun onCatch(data: BaseModel<UserModel>) {

            }

        })
    }
}