package com.cocosh.shmstore.login

import com.cocosh.shmstore.base.BasePresenter

/**
 * 登录的presente和view接口
 * Created by lmg on 2017/10/20.
 */
interface LoginContract {

    interface View{
        fun onMessage(msg:String)
    }


    interface Presenter : BasePresenter {
        //登录方法
        fun login(phone:String,password:String)
    }
}