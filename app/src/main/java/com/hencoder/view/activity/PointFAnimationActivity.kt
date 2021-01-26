package com.hencoder.view.activity

import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.graphics.PointF
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hencoder.view.R
import com.hencoder.view.dp
import kotlinx.android.synthetic.main.activity_animation_pointf.*


class PointFAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_pointf)

        //起点为初始值也可以不写
        val animator = ObjectAnimator.ofObject(view, "point", PointFEvaluator(), PointF(0f, 0f), PointF(100.dp, 200.dp))
        animator.startDelay = 1000
        animator.duration = 2000
        animator.start()
    }

    inner class PointFEvaluator : TypeEvaluator<PointF> {
        override fun evaluate(fraction: Float, startValue: PointF, endValue: PointF): PointF {
            val startX = startValue.x
            val endX = endValue.x
            val currentX = startX + (endX - startX) * fraction
            val startY = startValue.y
            val endY = endValue.y
            val currentY = startY + (endY - startY) * fraction
            return PointF(currentX, currentY)
        }
    }
}