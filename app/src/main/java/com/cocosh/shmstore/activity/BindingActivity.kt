package com.cocosh.shmstore.activity

import android.view.View
import com.cocosh.shmstore.R
import com.cocosh.shmstore.base.BaseActivity
import com.cocosh.shmstore.base.BaseModel
import com.cocosh.shmstore.databinding.ActivityBindingBinding

/**
 * 测试DataBinding
 * Created by lmg on 2017/10/20.
 */
class BindingActivity : BaseActivity() {
    override fun setLayout():Int = R.layout.activity_binding

    override fun initView() {
        getDataBinding<ActivityBindingBinding>().base = BaseModel<String>()
    }

    override fun onListener(view: View) {
    }

}
