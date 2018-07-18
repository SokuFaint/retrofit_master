package com.cocosh.shmstore.utils

import android.view.View
import android.widget.FrameLayout
import com.cocosh.shmstore.base.BaseActivity
import com.cocosh.shmstore.fragment.HomeTitleFragment

/**
 * 标题管理类
 * Created by lmg on 2017/10/13.
 */
class TitleManager(private var activity: BaseActivity, private var frame: FrameLayout) {

    fun goneTitle() {
        frame.visibility = View.GONE
    }

    fun homeTitle() {
        activity.supportFragmentManager.beginTransaction().replace(frame.id, HomeTitleFragment()).commit()

    }

}