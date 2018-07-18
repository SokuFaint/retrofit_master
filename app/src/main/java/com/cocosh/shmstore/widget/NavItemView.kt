package com.cocosh.shmstore.widget

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.Gravity
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.cocosh.shmstore.R
import com.cocosh.shmstore.utils.ViewUtil

/**
 * 首页导航子元素
 * Created by lmg on 2017/10/16.
 */
class NavItemView(context: Context, attr: AttributeSet) : RelativeLayout(context, attr) {
    private var textView = TextView(context)
    private var imageView = ImageView(context)

    init {
        if(!isInEditMode){
            val ta = context.obtainStyledAttributes(attr, R.styleable.NavItemView)

            val src = ta.getResourceId(R.styleable.NavItemView_src, 0)

            gravity = Gravity.CENTER_VERTICAL

            val imageParams = LayoutParams(ViewUtil.getWidth(70), ViewUtil.getHeight(70))
            imageParams.addRule(RelativeLayout.CENTER_HORIZONTAL)
            imageView.setImageResource(src)
            imageView.id = R.id.iv_icon
            addView(imageView, imageParams)

            ViewUtil.setTextSize(textView, 28)
            val name = ta.getString(R.styleable.NavItemView_text)
            val textParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            textParams.addRule(RelativeLayout.BELOW, imageView.id)
            textParams.addRule(RelativeLayout.CENTER_HORIZONTAL)
            textView.text = name

            val color = ta.getColor(R.styleable.NavItemView_android_textColor, R.color.black)
            textView.setTextColor(color)
            addView(textView, textParams)

            ta.recycle()
        }

    }

    fun setName(name: String) {
        textView.text = name
    }

    fun setIcon(res: Int) {
        imageView.setImageResource(res)
    }

    fun setTextColor(res: Int) {
        textView.setTextColor(ContextCompat.getColor(context, res))
    }
}