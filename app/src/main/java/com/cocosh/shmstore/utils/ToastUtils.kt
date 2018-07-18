package com.cocosh.shmstore.utils

import android.widget.Toast
import com.cocosh.shmstore.application.SmApplication

/**
 * 功能:单例Toast
 * 创建时间: 2016/9/12/03:18
 * Created by lmg on 2017/10/12.
 */
object ToastUtil {

    private var toast = Toast.makeText(SmApplication.getApp(), "", Toast.LENGTH_SHORT)

    /**
     * 显示Toast
     * @param content Toast信息
     */
    fun show(content: String, type: Int) {
        toast.setText(content)
        toast.duration = type
        toast.show()
    }

    fun show(content: String) {
        toast.setText(content)
        toast.duration = Toast.LENGTH_SHORT
        toast.show()
    }
}