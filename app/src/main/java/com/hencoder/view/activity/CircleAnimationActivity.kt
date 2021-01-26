package com.hencoder.view.activity

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hencoder.view.R
import com.hencoder.view.dp
import kotlinx.android.synthetic.main.activity_animation_circle.*


class CircleAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_circle)

        /* view.animate()
                 .translationX(200.dp) // setTranslationX(10) setTranslationX(20) setTranslationX(40)
                 .translationY(100.dp)
                 .alpha(0.5f)
                 .scaleX(2f)
                 .scaleY(2f)
                 .rotation(90f)
                 .setStartDelay(1000)*/

        val animator = ObjectAnimator.ofFloat(view, "radius", 150.dp)
        animator.startDelay = 1000
        animator.start()

        /*view.animate()
                .translationY(200.dp)
                .withLayer()*/
    }
}