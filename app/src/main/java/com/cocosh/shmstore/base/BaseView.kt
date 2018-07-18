package com.cocosh.shmstore.base



/**
 * MVP架构View层的base接口
 * Created by lmg on 2017/10/20.
 */
interface BaseView<in T>{
    fun setPresenter(presenter: T)
}