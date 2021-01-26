package com.hencoder.view.activity

import android.animation.AnimatorSet
import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hencoder.view.R
import com.hencoder.view.dp
import kotlinx.android.synthetic.main.activity_animation_camera.*


class CameraAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_camera)

        val bottomFlipAnimator = ObjectAnimator.ofFloat(view, "bottomFlip", 60f)
        bottomFlipAnimator.startDelay = 1000
        bottomFlipAnimator.duration = 1000

        val flipRotationAnimator = ObjectAnimator.ofFloat(view, "flipRotation", 270f)
        flipRotationAnimator.startDelay = 200
        flipRotationAnimator.duration = 1000

        val topFlipAnimator = ObjectAnimator.ofFloat(view, "topFlip", -60f)
        topFlipAnimator.startDelay = 200
        topFlipAnimator.duration = 1000

        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(bottomFlipAnimator, flipRotationAnimator, topFlipAnimator)
        animatorSet.start()


        /*val bottomFlipHolder = PropertyValuesHolder.ofFloat("bottomFlip", 60f)
        val flipRotationHolder = PropertyValuesHolder.ofFloat("flipRotation", 270f)
        val topFlipHolder = PropertyValuesHolder.ofFloat("topFlip", -60f)
        val holderAnimator = ObjectAnimator.ofPropertyValuesHolder(view, bottomFlipHolder, flipRotationHolder, topFlipHolder)
        holderAnimator.startDelay = 1000
        holderAnimator.duration = 2000
        holderAnimator.start()*/

//        val length = 200.dp
//        val keyframe1 = Keyframe.ofFloat(0f, 0f)
//        val keyframe2 = Keyframe.ofFloat(0.2f, 1.5f * length)
//        val keyframe3 = Keyframe.ofFloat(0.8f, 0.6f * length)
//        val keyframe4 = Keyframe.ofFloat(1f, 1f * length)
//        val keyframeHolder = PropertyValuesHolder.ofKeyframe("translationX", keyframe1, keyframe2, keyframe3, keyframe4)
//        val animator = ObjectAnimator.ofPropertyValuesHolder(view, keyframeHolder)
//        animator.startDelay = 1000
//        animator.duration = 2000
//        animator.start()
    }
}