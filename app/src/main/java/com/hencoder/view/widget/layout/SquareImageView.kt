package com.hencoder.view.widget.layout

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import kotlin.math.min

class SquareImageView(context: Context?, attrs: AttributeSet?) : AppCompatImageView(context, attrs) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = min(measuredWidth, measuredHeight)
        setMeasuredDimension(size, size)
    }

    //不能只改layout方法，只改layout的话，父View不知道你改变了
//    override fun layout(l: Int, t: Int, r: Int, b: Int) {
//        val width = r - l;
//        val height = b - t;
//        val size = min(width, height);
//        super.layout(l, t, l + size, t + size)
//    }

}