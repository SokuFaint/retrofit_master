package com.cocosh.shmstore.base

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View


/**
 * Fragment父类
 * Created by lmg on 2017/10/13.
 */
abstract class BaseFragment : Fragment(),View.OnClickListener {
    private lateinit var mView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        mView = inflater.inflate(setLayout(), container, false)

        initView()

        return mView
    }

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


    /**
     * 组件点击事件
     */
    abstract fun onListener(view: View)


    abstract fun close()



    override fun onDestroy() {
        super.onDestroy()
        close()
    }

    override fun onClick(view: View) {
        onListener(view)
    }

     fun getLayoutView():View = mView
}