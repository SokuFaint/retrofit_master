package com.cocosh.shmstore.login

import com.cocosh.shmstore.base.BaseActivity
import com.cocosh.shmstore.model.data.LoginLoader

/**
 * 登录业务处理
 * Created by lmg on 2017/10/20.
 */
class LoginPresenter(activity: BaseActivity, var loginView: LoginContract.View) : LoginContract.Presenter {

    var loginLoader = LoginLoader(activity)


    override fun start() {

    }


    override fun login(phone: String, password: String) {
        loginLoader.login(phone, password, loginView)
    }


}