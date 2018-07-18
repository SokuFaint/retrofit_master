package com.cocosh.shmstore.activity

import android.content.Intent
import android.view.View
import com.cocosh.shmstore.R
import com.cocosh.shmstore.base.BaseActivity
import com.cocosh.shmstore.base.BaseModel
import com.cocosh.shmstore.http.ApiManager
import com.cocosh.shmstore.login.LoginActivity
import com.cocosh.shmstore.utils.LogUtil
import com.cocosh.shmstore.utils.ToastUtil
import com.cocosh.shmstore.widget.HomeNav
import kotlinx.android.synthetic.main.activity_main.*

/**
 * main
 * Created by lmg on 2017/10/12.
 */
class MainActivity : BaseActivity() {
    override fun setLayout(): Int = R.layout.activity_main

    override fun initView() {
        titleManager.homeTitle()

        /**
         * 首页导航切换事件
         */
        home_nav.setOnItemListener(object : HomeNav.OnNavListener {
            override fun onNavItem(viewId: Int) {
                when (viewId) {
                    R.id.nav_home -> {
                        ToastUtil.show("首页")
                    }
                    R.id.nav_chat -> {
                        ToastUtil.show("聊聊")
                    }

                    R.id.nav_group -> {
                        ToastUtil.show("社区")
                    }

                    R.id.nav_message -> {
                        ToastUtil.show("消息")
                    }

                    R.id.nav_my -> {
                        ToastUtil.show("我的")
                        startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                    }
                }
            }

        })

        ApiManager.get(this,null,"http://www.baidu.com",object : ApiManager.OnResult<String>{
            override fun onSuccess(data: BaseModel<String>) {
                LogUtil.i("成功："+data)
            }

            override fun onFailed(e: Throwable) {
                LogUtil.i("失败："+e.localizedMessage)
            }

            override fun onCatch(data: BaseModel<String>) {
                LogUtil.i("缓存："+data)
            }

        })
    }

    override fun onListener(view: View) {
    }

}
