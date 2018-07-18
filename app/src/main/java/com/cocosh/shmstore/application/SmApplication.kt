package com.cocosh.shmstore.application

import android.app.Application
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.content.pm.PackageManager.NameNotFoundException
import com.cocosh.shmstore.model.UserModel
import com.zhy.autolayout.config.AutoLayoutConifg
import java.util.*

/**
 * 首媒APP
 * Created by lmg on 2017/10/12.
 */
class SmApplication : Application() {
    private val storeMap = HashMap<String, Any>() //数据存储
    private val sharedPreferences: SharedPreferences? = null
    private var userModel: UserModel? = null
    var isShow = false
    //    private var location: AMapLocation? = null
//    private var weatherLive: LocalWeatherLive? = null
//    private var mLocationClient: AMapLocationClient? = null
//    private var mLocationOption: AMapLocationClientOption? = null
    val EXT_TYPE_READ_DEL_TIME_COUNT = "extReaddelCountDown"

    companion object {
        private lateinit var instance:SmApplication

        fun getApp():SmApplication = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        //使用物理高度进行适配优化
        AutoLayoutConifg.getInstance().useDeviceSize()

//        LitePal.initialize(this)

//        SpeechUtility.createUtility(this, SpeechConstant.APPID + "=5881c171")
    }

        /**
         * @return 应用版本号
         */
        fun getVersionName(): String {
            try {
//                 获取packageManager的实例
                val packageManager = this.packageManager
                // getPackageName()是你当前类的包名，0代表是获取版本信息
                val packInfo = packageManager.getPackageInfo(this.packageName, 0)
                return packInfo.versionName
            } catch (e: NameNotFoundException) {
                e.printStackTrace()
            }

            return ""
        }
}
