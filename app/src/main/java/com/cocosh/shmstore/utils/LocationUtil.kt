package com.cocosh.shmstore.utils

import com.amap.api.location.AMapLocation
import com.amap.api.location.AMapLocationListener
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.cocosh.shmstore.application.SmApplication


/**
 * 高德定位
 * Created by lmg on 2017/10/18.
 */
object LocationUtil : AMapLocationListener {
    lateinit var listener: AMapLocationListener
    private var mLocationClient: AMapLocationClient = AMapLocationClient(SmApplication.getApp())//初始化mLocationClient

    init {

        //初AMapLocationClientOption对象
        val mOptions = AMapLocationClientOption()
        //获取最近3s内精度最高的一次定位结果
        mOptions.isOnceLocationLatest = true
        mLocationClient.setLocationOption(mOptions)
        //
        //设置定位回调监听
        mLocationClient.setLocationListener(this)

    }

    override fun onLocationChanged(location: AMapLocation) {
        listener.onLocationChanged(location)
        ToastUtil.show(location.locationDetail)
        LogUtil.i("定位结果" + location.toStr())
    }


    fun getLoaction(listener: AMapLocationListener) {
        this.listener = listener
        //启动定位
        mLocationClient.startLocation()
    }
}