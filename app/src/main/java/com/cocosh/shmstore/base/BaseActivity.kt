package com.cocosh.shmstore.base

import android.content.pm.ActivityInfo
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.cocosh.shmstore.R
import com.cocosh.shmstore.utils.TitleManager
import com.zhy.autolayout.AutoLayoutActivity
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_base.*

/**
 * 父类
 * Created by lmg on 2017/10/12.
 */
abstract class BaseActivity : AutoLayoutActivity(), View.OnClickListener {
    val composites = CompositeDisposable()
    lateinit var titleManager: TitleManager
    private var viewDataBinding: ViewDataBinding? = null
    /**
     * 设置布局
     *
     * @return 资源ID
     */
    abstract fun setLayout(): Int


    /**
     * 初始化View组件
     */
    abstract fun initView()


    internal abstract fun onListener(view: View)


    override fun onClick(view: View) {
        onListener(view)
    }

    /**
     * 以下为生命周期
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT //强制屏幕
        setContentView(R.layout.activity_base)
        titleManager = TitleManager(this, frame_title)
        viewDataBinding = DataBindingUtil.inflate(layoutInflater, setLayout(), frame_body, false)
        if (viewDataBinding != null) {
            frame_body.addView(viewDataBinding?.root)
        } else {
            val bodyView = LayoutInflater.from(this).inflate(setLayout(), null, false)
            frame_body.addView(bodyView)
        }

        initView()
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : ViewDataBinding> getDataBinding(): T = viewDataBinding as T


    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onRestart() {
        super.onRestart()
    }


    override fun onDestroy() {
        super.onDestroy()
        composites.dispose()
    }

}