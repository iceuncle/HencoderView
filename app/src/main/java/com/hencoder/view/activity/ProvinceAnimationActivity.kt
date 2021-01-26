package com.hencoder.view.activity

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hencoder.view.R
import com.hencoder.view.widget.draw.animation.ProvinceEvaluator
import kotlinx.android.synthetic.main.activity_animation_province.*


class ProvinceAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_province)

        val animator = ObjectAnimator.ofObject(view, "province", ProvinceEvaluator(), "澳门特别行政区")
        animator.startDelay = 1000
        animator.duration = 10000
        animator.start()
    }
}