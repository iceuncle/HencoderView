package com.hencoder.view.widget.layout

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.hencoder.view.dp


class CircleView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val RADIUS = 80.dp
    private val PADDING = 80.dp
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val size = ((PADDING + RADIUS) * 2).toInt()
//        val width = resolveSize(size, widthMeasureSpec)
        val height = resolveSize(size, heightMeasureSpec)

        val specWidthMode = MeasureSpec.getMode(widthMeasureSpec)
        val specWidthSize = MeasureSpec.getSize(widthMeasureSpec)
        val width = when (specWidthMode) {
            //给定了具体值 一般是子view设置了具体值或者撑满屏幕
            MeasureSpec.EXACTLY -> specWidthSize
            //父view强加给子view一个最大的值 一般是父view或者子View设置为wrap_content
            MeasureSpec.AT_MOST -> if (size > specWidthSize) specWidthSize else size
            //当父布局为ListView、ScrollView等 不限制
            MeasureSpec.UNSPECIFIED -> size
            else -> size
        }
        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(PADDING + RADIUS, PADDING + RADIUS, RADIUS, paint)
    }
}