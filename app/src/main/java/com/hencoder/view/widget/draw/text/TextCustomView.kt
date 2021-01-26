package com.hencoder.view.widget.draw.text


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.hencoder.view.R
import com.hencoder.view.dp


class TextCustomView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private val CIRCLE_COLOR = Color.parseColor("#90A4AE")
    private val HIGHLIGHT_COLOR = Color.parseColor("#FF4081")
    private val RING_WIDTH = 20.dp
    private val RADIUS = 150.dp

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 100.dp
        typeface = ResourcesCompat.getFont(context, R.font.font)
        textAlign = Paint.Align.CENTER
    }
    private val bounds = Rect()
    private val fontMetrics = Paint.FontMetrics()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 绘制环
        paint.style = Paint.Style.STROKE
        paint.color = CIRCLE_COLOR
        paint.strokeWidth = RING_WIDTH
        canvas.drawCircle(width / 2f, height / 2f, RADIUS, paint)

        // 绘制进度条
        paint.color = HIGHLIGHT_COLOR
        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawArc(width / 2f - RADIUS, height / 2f - RADIUS, width / 2f + RADIUS, height / 2f + RADIUS, -90f, 225f, false, paint)

        // 绘制文字
        paint.textSize = 100.dp
        paint.style = Paint.Style.FILL
        paint.getFontMetrics(fontMetrics)
//        canvas.drawText("aaaa", width / 2f, height / 2f - (fontMetrics.ascent + fontMetrics.descent) / 2f, paint)
        paint.getTextBounds("aaaa", 0, "aaaa".length, bounds)
        canvas.drawText("aaaa", width / 2f, height / 2f - (bounds.top + bounds.bottom) / 2f, paint)

//        println(height / 2f)
//        println(bounds.top)
//        println(bounds.bottom)
//        println(bounds.top + bounds.bottom)
//        println(height / 2f - (bounds.top + bounds.bottom) / 2f)

        // 绘制文字2r
        paint.textSize = 80.dp
        paint.textAlign = Paint.Align.LEFT
        paint.getFontMetrics(fontMetrics)
        paint.getTextBounds("abab", 0, "abab".length, bounds)
//        canvas.drawText("abab", -bounds.left.toFloat(), -bounds.top.toFloat(), paint)
        canvas.drawText("abab", 0f, -fontMetrics.top, paint)

        // 绘制文字3
        paint.textSize = 15.dp
        paint.getTextBounds("abab", 0, "abab".length, bounds)
        canvas.drawText("abab", -bounds.left.toFloat(), -bounds.top.toFloat(), paint)
    }
}