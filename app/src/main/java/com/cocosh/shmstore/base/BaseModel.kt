package com.cocosh.shmstore.base

import com.google.gson.Gson

/**
 * 公共实体类
 * Created by lmg on 2017/9/14.
 */
class BaseModel<T> {
    var information: String = "成功"
    var error: String = "0000"
    var datas: T? = null
    var string: String = ""

    fun isSuccess(): Boolean {
        if (error == "0000") {
            information = "成功"
            return true
        }

        if (error == "-9999") {
            information = "系统异常"
        }

        if (error == "0011") {
            information = "您的账号在另一台设备上登录，若非本人操作请注意账号安全！"
        }
        return false
    }

    override fun toString(): String =
            "BaseModel(information='$information', error='$error', datas=$datas, string='$string')"


    fun <O> parser(clazz: Class<O>): Class<O>? {
        val gson = Gson()
        return gson.fromJson(string, clazz.javaClass)
    }
}