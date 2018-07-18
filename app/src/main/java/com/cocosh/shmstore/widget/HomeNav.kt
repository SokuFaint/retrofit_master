package com.cocosh.shmstore.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.cocosh.shmstore.R
import kotlinx.android.synthetic.main.layout_home_nav.view.*

/**
 * 首页底部导航
 * Created by lmg on 2017/10/16.
 */
class HomeNav(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs), View.OnClickListener {
    private lateinit var lastView: NavItemView
    private val resArray = HashMap<Int, Int>()
    private var changeListener: OnNavListener? = null

    init {
        if(!isInEditMode){
            LayoutInflater.from(context).inflate(R.layout.layout_home_nav, this)
            nav_home.setOnClickListener(this)
            resArray.put(nav_home.id, R.mipmap.icon_home_off)

            nav_chat.setOnClickListener(this)
            resArray.put(nav_chat.id, R.mipmap.icon_chat_off)

            nav_group.setOnClickListener(this)
            resArray.put(nav_group.id, R.mipmap.icon_group_off)

            nav_message.setOnClickListener(this)
            resArray.put(nav_message.id, R.mipmap.icon_message_off)

            nav_my.setOnClickListener(this)
            resArray.put(nav_my.id, R.mipmap.icon_my_off)

            lastView = nav_home
        }

    }


    override fun onClick(view: View) {

        if (lastView.id == view.id) {
            return
        }

        lastView.setIcon(resArray[lastView.id]!!)
        lastView.setTextColor(R.color.text_gray)


        when (view.id) {
            nav_home.id -> {
                nav_home.setIcon(R.mipmap.icon_home_on)
            }

            nav_chat.id -> {
                nav_chat.setIcon(R.mipmap.icon_chat_on)
            }

            nav_group.id -> {
                nav_group.setIcon(R.mipmap.icon_group_on)
            }

            nav_message.id -> {
                nav_message.setIcon(R.mipmap.icon_message_on)
            }

            nav_my.id -> {
                nav_my.setIcon(R.mipmap.icon_my_on)
            }
        }
        lastView = view as NavItemView
        lastView.setTextColor(R.color.black)

        changeListener?.onNavItem(lastView.id)
    }

    fun setOnItemListener(listener: OnNavListener) {
        changeListener = listener
    }

    interface OnNavListener {
        fun onNavItem(viewId: Int)
    }
}