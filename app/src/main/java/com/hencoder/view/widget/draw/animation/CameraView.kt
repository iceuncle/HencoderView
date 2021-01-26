package com.hencoder.view.widget.draw.animation

import android.content.Context
import android.graphics.Camera
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.withSave
import com.hencoder.view.dp
import com.hencoder.view.getAvatar


class CameraView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val BITMAP_SIZE = 200.dp
    private val BITMAP_PADDING = 100.dp
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = getAvatar(resources, BITMAP_SIZE.toInt())
    private val camera = Camera()

    var topFlip = 0f
        set(value) {
            field = value
            invalidate()
        }
    var bottomFlip = 30f
        set(value) {
            field = value
            invalidate()
        }
    var flipRotation = 0f
        set(value) {
            field = value
            invalidate()
        }

    init {
        camera.setLocation(0f, 0f, -6 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas) {

        // 上半部分
        canvas.withSave {
            canvas.translate(BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2)
            canvas.rotate(-flipRotation)
            camera.save()
            camera.rotateX(topFlip)
            camera.applyToCanvas(canvas)
            camera.restore()
            canvas.clipRect(-BITMAP_SIZE, -BITMAP_SIZE,
                    BITMAP_SIZE, 0f)
            canvas.rotate(flipRotation)
            canvas.translate(-(BITMAP_PADDING + BITMAP_SIZE / 2), -(BITMAP_PADDING + BITMAP_SIZE / 2))
            canvas.drawBitmap(bitmap,
                    BITMAP_PADDING,
                    BITMAP_PADDING, paint)
        }

        // 下半部分
        canvas.withSave {
            canvas.translate(BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2)
            canvas.rotate(-flipRotation)
            camera.save()
            camera.rotateX(bottomFlip)
            camera.applyToCanvas(canvas)
            camera.restore()
            canvas.clipRect(-BITMAP_SIZE, 0f,
                    BITMAP_SIZE,
                    BITMAP_SIZE
            )
            canvas.rotate(flipRotation)
            canvas.translate(-(BITMAP_PADDING + BITMAP_SIZE / 2), -(BITMAP_PADDING + BITMAP_SIZE / 2))
            canvas.drawBitmap(bitmap,
                    BITMAP_PADDING,
                    BITMAP_PADDING, paint)
        }
    }

}