package com.cocosh.shmstore.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager
import com.cocosh.shmstore.application.SmApplication

/**
 * 屏幕工具类,获取屏幕宽度和高度，以及单位转换
 * Created by lmg on 17/1/22 17:13
 */
object DimensUtil {

    /**
     * 获取屏幕宽度
     *
     * @return 屏幕宽度
     */
    // 获取屏幕的参数
    //创建系统服务对象
    val screenWidth: Int
        get() {
            val metric = DisplayMetrics()
            val wm = SmApplication.getApp().getSystemService(Context.WINDOW_SERVICE) as WindowManager
            wm.defaultDisplay.getMetrics(metric)
            return metric.widthPixels

        }

    /**
     * 获取屏幕高度
     *
     * @return 屏幕高度
     */
    val screenHeight: Int
        get() {
            val metric = DisplayMetrics()
            val wm = SmApplication.getApp().getSystemService(Context.WINDOW_SERVICE) as WindowManager
            wm.defaultDisplay.getMetrics(metric)
            return metric.heightPixels

        }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     *
     * @param dpValue dp
     * @return px
     */
    fun dip2px(dpValue: Float): Int {
        val scale = SmApplication.getApp().resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }


    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     *
     * @param pxValue px
     * @return dp
     */
    fun px2dip(pxValue: Float): Int {
        val scale = SmApplication.getApp().resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }
}
