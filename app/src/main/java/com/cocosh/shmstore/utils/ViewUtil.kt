package com.cocosh.shmstore.utils

import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.*

/**
 * 功能说明： 百分百设置组件大小（以苹果5C的屏幕比例进行设置大小）
 * 日期：	2015年10月11日
 * 开发者：lmg
 * （半成品）
 */
@SuppressWarnings("unchecked")
object ViewUtil {

    /*
     * 常量
     */
    val RELATIVELAYOUT = 100 // 相对布局
    val LINEARLAYOUT = 200 // 线性布局

    /*
     * 设计稿的尺寸：Iphone6的屏幕
     */
    val WEIGHT = 1080
    val HEIGHT = 1920

    /*
     * 华为手机虚拟键适配
	 */

    // 1280*720
    val HEIGHT_1280 = 1280
    val WIDTH_720 = 720

    // 1920*1080
    val HEIGHT_1920 = 1920
    val WIDTH_1080 = 1080

    /**
     * <pre>
     * 功能说明：获取上下边距百分比高度
     * 日期：	2015年11月23日
     *
     * @param px
     * @return
    </pre> *
     */
    fun getHeight(px: Int): Int {
        val screenWidth = DimensUtil.screenWidth
        var screenHeight = DimensUtil.screenHeight

        if (screenWidth == WIDTH_1080 && screenHeight != HEIGHT_1920) {
            screenHeight = HEIGHT_1920
        }

        if (screenWidth == WIDTH_720 && screenHeight != HEIGHT_1280) {
            screenHeight = HEIGHT_1280
        }

        // 将屏幕分成100份，判断输入的像素占屏幕的几份
        val iPhoneProportion = px / (HEIGHT / 100.toDouble()).toDouble()
        return (screenHeight / 100.toDouble() * iPhoneProportion).toInt()

    }

    /**
     * <pre>
     * 功能说明：获取左右边距百分比长度
     * 日期：	2015年11月23日
    </pre> *
     */
    fun getWidth(px: Int): Int {
        val iPhoneProportion = px / (WEIGHT / 100.toDouble()).toDouble()
        return (DimensUtil.screenWidth / 100.toDouble() * iPhoneProportion).toInt()
    }

    /**
     * 功能说明： 转换成百分比px 有时候会有一点误差的 ,该方法用来减少误差
     * 据你当前的 宽高 计算 等比例的 长度
     * 日期：	2015年11月23日
     *
     */
    fun getWidth(height: Int, width: Int): Int {

        val proportion = height / width.toFloat()

        return (height / proportion).toInt()

    }

    /**
     * 功能说明：设置TextView文字的大小
     * 日期：	2015年11月23日
     */
    fun setTextSize(view: TextView, px: Int) {
        view.setTextSize(TypedValue.COMPLEX_UNIT_PX, getWidth(px).toFloat())
    }

    /**
     * 功能说明：设置EditText文字大小
     * 日期：	2015年11月23日
     */
    fun setTextSize(view: EditText, px: Int) {
        view.setTextSize(TypedValue.COMPLEX_UNIT_PX, getWidth(px).toFloat())
    }

    /**
     * 功能说明：设置Button文字大小
     * 日期：	2015年11月23日
     */
    fun setTextSize(view: Button, px: Int) {
        view.setTextSize(TypedValue.COMPLEX_UNIT_PX, getWidth(px).toFloat())
    }

    /**
     * 功能说明：设置RadioButton文字大小
     * 日期：	2015年11月23日
     */
    fun setTextSize(view: RadioButton, px: Int) {
        view.setTextSize(TypedValue.COMPLEX_UNIT_PX, getWidth(px).toFloat())
    }

    /**
     * 功能说明：设置组件大小方法
     * 日期：	2015年11月23日
     */
    fun setViewSize(view: View?, height: Int, width: Int) {
        if (view != null) {
            if (view.layoutParams != null) {
                if (height != 0) {
                    view.layoutParams.height = getHeight(height)
                }

                if (width != 0) {
                    view.layoutParams.width = getWidth(width)
                }

            } else {

                val params = ViewGroup.LayoutParams(getWidth(width),
                        getHeight(height))
                view.layoutParams = params

            }

        }
    }

    /**
     * 功能说明：设置布局大小方法
     * 日期：	2015年11月23日
     */
    fun setViewSize(view: View?, height: Int, width: Int, type: Int) {
        if (view != null) {
            if (view.layoutParams != null) {
                if (height != 0) {
                    view.layoutParams.height = getHeight(height)
                }

                if (width != 0) {
                    view.layoutParams.width = getWidth(width)
                }

            } else {

                if (type == LINEARLAYOUT) {
                    val params = LinearLayout.LayoutParams(
                            getWidth(width), getHeight(height))
                    view.layoutParams = params
                }

                if (type == RELATIVELAYOUT) {
                    val params = RelativeLayout.LayoutParams(
                            getWidth(width), getHeight(height))
                    view.layoutParams = params
                }

                //				LogUtil.e("LayoutParams对象为空，创建新的布局参数");
            }

        } else {
            //			LogUtil.e("View对象为空，无法获取布局参数");
        }
    }

    /**
     * 功能说明：按比例设置组件左边距
     * 日期：	2015年11月23日
     */
    fun setMarginLeft(view: View, margin: Int, type: Int) {
        if (type == RELATIVELAYOUT) {

            if (view.layoutParams == null) {
                val params = RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                params.leftMargin = getWidth(margin)
                view.layoutParams = params
            } else {
                val params = view
                        .layoutParams as RelativeLayout.LayoutParams
                params.leftMargin = getWidth(margin)
            }

        }
        if (type == LINEARLAYOUT) {

            if (view.layoutParams == null) {
                val params = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                params.leftMargin = getWidth(margin)
                view.layoutParams = params
            } else {
                val params = view
                        .layoutParams as LinearLayout.LayoutParams
                params.leftMargin = getWidth(margin)
            }

        }
    }

    /**
     * 功能说明：按比例设置组件右边距
     * 日期：	2015年11月23日
     */
    fun setMarginRight(view: View, margin: Int, type: Int) {
        if (type == RELATIVELAYOUT) {
            if (view.layoutParams == null) {
                val params = RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                params.rightMargin = getWidth(margin)
                view.layoutParams = params
            } else {
                val params = view
                        .layoutParams as RelativeLayout.LayoutParams
                params.rightMargin = getWidth(margin)
            }
        }
        if (type == LINEARLAYOUT) {

            if (view.layoutParams == null) {
                val params = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                params.rightMargin = getWidth(margin)
                view.layoutParams = params
            } else {
                val params = view
                        .layoutParams as LinearLayout.LayoutParams
                params.rightMargin = getWidth(margin)
            }

        }
    }

    /**
     * 功能说明：按比例设置组件的四个边距(相同)
     * 日期：	2015年11月23日
     */
    fun setMargin(view: View, margin: Int, type: Int) {
        setMarginTop(view, margin, type)
        setMarginBottom(view, margin, type)
        setMarginLeft(view, margin, type)
        setMarginRight(view, margin, type)
    }

    /**
     * 功能说明：按比例设置组件的四个边距(不同)
     * 日期：	2015年11月23日
     */
    fun setMargin(view: View, marginTB: Int, marginLR: Int, type: Int) {

        if (marginTB != 0) {
            setMarginTop(view, marginTB, type)
            setMarginBottom(view, marginTB, type)
        }

        if (marginLR != 0) {
            setMarginLeft(view, marginLR, type)
            setMarginRight(view, marginLR, type)
        }
    }

    /**
     * 功能说明：按比例设置组件的四个边距(不同)
     * 日期：	2015年11月23日
     */
    fun setMargin(view: View, marginT: Int, marginR: Int,
                  marginB: Int, marginL: Int, type: Int) {
        if (marginT != 0) {
            setMarginTop(view, marginT, type)
        }

        if (marginR != 0) {
            setMarginRight(view, marginR, type)
        }

        if (marginB != 0) {
            setMarginBottom(view, marginB, type)
        }

        if (marginL != 0) {
            setMarginLeft(view, marginL, type)
        }
    }

    /**
     * 功能说明：按比例设置组件的上边距
     * 日期：	2015年11月23日
     */
    fun setMarginTop(view: View, margin: Int, type: Int) {
        if (type == RELATIVELAYOUT) {
            val params = view
                    .layoutParams as RelativeLayout.LayoutParams
            params.topMargin = getHeight(margin)
        }
        if (type == LINEARLAYOUT) {
            val params = view
                    .layoutParams as LinearLayout.LayoutParams
            params.topMargin = getHeight(margin)
        }
    }

    /**
     * 功能说明：按比例设置组件的四个填充值(不同)
     * 日期：	2015年11月23日
     */
    fun setPadding(view: View, paddingTB: Int, paddingLR: Int) {

        if (paddingTB != 0) {
            setPaddingTop(view, paddingTB)
            setPaddingBottom(view, paddingTB)
        }

        if (paddingLR != 0) {
            setPaddingLeft(view, paddingLR)
            setPaddingRight(view, paddingLR)
        }
    }

    /**
     * 功能说明：按比例设置组件的下边距
     * 日期：	2015年11月23日
     */
    fun setMarginBottom(view: View, margin: Int, type: Int) {
        if (type == RELATIVELAYOUT) {
            val params = view
                    .layoutParams as RelativeLayout.LayoutParams
            params.bottomMargin = getHeight(margin)
        }
        if (type == LINEARLAYOUT) {
            val params = view
                    .layoutParams as LinearLayout.LayoutParams
            params.bottomMargin = getHeight(margin)
        }
    }

    /**
     * 功能说明：按比例设置组件四边填充值(不同)
     * 日期：2015年11月23日
     */
    fun setPadding(view: View, paddingTop: Int, paddingRight: Int,
                   paddingBottom: Int, paddingLeft: Int) {

        if (paddingTop != 0) {
            setPaddingTop(view, paddingTop)
        }

        if (paddingRight != 0) {
            setPaddingRight(view, paddingRight)
        }

        if (paddingBottom != 0) {
            setPaddingBottom(view, paddingBottom)
        }

        if (paddingLeft != 0) {
            setPaddingLeft(view, paddingLeft)
        }
    }

    /**
     * 功能说明：按比例设置组件四边填充值(相同)
     * 日期：	2015年11月23日
     */
    fun setPadding(view: View, padding: Int) {
        setPaddingTop(view, padding)
        setPaddingBottom(view, padding)
        setPaddingLeft(view, padding)
        setPaddingRight(view, padding)
    }

    /**
     * 功能说明：按比例设置组件左填充值
     * 日期：	2015年11月23日
     */
    fun setPaddingLeft(view: View, padding: Int) {
        view.setPadding(getWidth(padding), view.paddingTop,
                view.paddingRight, view.paddingBottom)
    }

    /**
     * 功能说明：按比例设置组件右填充值
     * 日期：	2015年11月23日
     */
    fun setPaddingRight(view: View, padding: Int) {
        view.setPadding(view.paddingLeft, view.paddingTop,
                getWidth(padding), view.paddingBottom)
    }

    /**
     * 功能说明：按比例设置组件上填充值
     * 日期：	2015年11月23日
     */
    fun setPaddingTop(view: View, padding: Int) {
        view.setPadding(view.paddingLeft, getWidth(padding),
                view.paddingRight, view.paddingBottom)
    }

    /**
     * 功能说明：按比例设置组件下填充值
     * 日期：	2015年11月23日
     */
    fun setPaddingBottom(view: View, padding: Int) {
        view.setPadding(view.paddingLeft, view.paddingTop,
                view.paddingRight, getWidth(padding))
    }

    /**
     * 功能说明：设置组件DrawablePadding属性
     * 日期：	2015年11月23日
     */
    fun setDrawablePadding(view: TextView, padding: Int) {
        view.compoundDrawablePadding = getWidth(padding)
    }

}