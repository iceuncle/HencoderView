package com.hencoder.view.widget.xfermode

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.view.dp


class XfermodeView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val XFERMODE = PorterDuffXfermode(PorterDuff.Mode.DST_OVER)
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bounds = RectF(150.dp, 50.dp, 300.dp, 200.dp)
    private val circleBitmap = Bitmap.createBitmap(150.dp.toInt(), 150.dp.toInt(), Bitmap.Config.ARGB_8888)
    private val squareBitmap = Bitmap.createBitmap(150.dp.toInt(), 150.dp.toInt(), Bitmap.Config.ARGB_8888)

    init {
        val canvas = Canvas(circleBitmap)
        paint.color = Color.parseColor("#D81B60")
        canvas.drawOval(50.dp, 0.dp, 150.dp, 100.dp, paint)
        paint.color = Color.parseColor("#2196F3")
        canvas.setBitmap(squareBitmap)
        canvas.drawRect(0.dp, 50.dp, 100.dp, 150.dp, paint)
    }

    override fun onDraw(canvas: Canvas) {
        val count = canvas.saveLayer(bounds, null)
        canvas.drawBitmap(circleBitmap, 150.dp, 50.dp, paint)
        paint.xfermode = XFERMODE
        canvas.drawBitmap(squareBitmap, 150.dp, 50.dp, paint)
        paint.xfermode = null
        canvas.restoreToCount(count)
    }
}