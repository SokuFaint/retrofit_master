package com.cocosh.shmstore.fragment

import android.view.View
import com.amap.api.location.AMapLocationListener
import com.cocosh.shmstore.R
import com.cocosh.shmstore.base.BaseFragment
import com.cocosh.shmstore.http.Constant
import com.cocosh.shmstore.utils.LocationUtil
import com.cocosh.shmstore.utils.ToastUtil
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.PermissionListener
import kotlinx.android.synthetic.main.layout_home_title.*
import kotlinx.android.synthetic.main.layout_home_title.view.*

/**
 * 首页导航Fragment
 * Created by lmg on 2017/10/13.
 */
class HomeTitleFragment : BaseFragment() {

    override fun setLayout(): Int = R.layout.layout_home_title

    override fun initView() {

        getLayoutView().rl_local.setOnClickListener(this)
        getLayoutView().rl_scan.setOnClickListener(this)
        getLayoutView().rl_share.setOnClickListener(this)

        if (Constant.DEBUG) {
            getLayoutView().tv_title.text = "开发版本"
        } else {
            getLayoutView().tv_title.text = "首媒中国"
        }

        //获取位置
        LocationUtil.getLoaction(AMapLocationListener {
            if (it.city != "") {
                getLayoutView().tv_left.text = it.city
            }
        })

    }

    override fun onListener(view: View) {
        when (view.id) {
            rl_local.id -> {
                AndPermission.with(this).requestCode(Constant.PERMISSION_REQUEST_CAMERA)
                        .rationale { requestCode, rationale ->
                            if (requestCode == Constant.PERMISSION_REQUEST_CAMERA) {
                                rationale.resume()
                            }
                        }
                        .permission(android.Manifest.permission.ACCESS_COARSE_LOCATION)
                        .callback(object : PermissionListener {
                            override fun onSucceed(requestCode: Int, grantPermissions: MutableList<String>) {
                                ToastUtil.show("授权成功")
                            }

                            override fun onFailed(requestCode: Int, deniedPermissions: MutableList<String>) {
                                ToastUtil.show("授权失败")
                            }

                        }).start()
            }

            rl_scan.id -> {
                ToastUtil.show("点击扫描")

            }

            rl_share.id -> {
                ToastUtil.show("点击分享")
            }

        }
    }

    override fun close() {

    }

    fun setTitle(title: String) {
        tv_title.text = title
    }

}