package com.cocosh.shmstore.login

import android.view.View
import com.cocosh.shmstore.R
import com.cocosh.shmstore.base.BaseActivity
import com.cocosh.shmstore.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_login.*

/**
 *
 * Created by lmg on 2017/10/20.
 */
class LoginActivity : BaseActivity(), LoginContract.View {

    var mPresenter: LoginContract.Presenter = LoginPresenter(this, this)


    override fun setLayout(): Int = R.layout.activity_login


    override fun initView() {
        titleManager.goneTitle()

        btn_login.setOnClickListener(this)

        tv_reg.setOnClickListener(this)

        tv_help.setOnClickListener(this)

    }

    //点击事件
    override fun onListener(view: View) {
        when (view.id) {
            btn_login.id -> {
                //登录方法
                mPresenter.login(edt_phone.text.toString(), edt_password.text.toString())
            }

            tv_reg.id -> {
                ToastUtil.show("注册")
            }

            tv_help.id -> {
                ToastUtil.show("帮助")
            }

        }
    }

    //登录信息回调
    override fun onMessage(msg: String) {
        ToastUtil.show("Activity打印：$msg")
    }

}