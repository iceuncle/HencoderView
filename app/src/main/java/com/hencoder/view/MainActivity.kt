package com.hencoder.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hencoder.view.activity.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 绘制
        dashboardBtn.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }
        pieBtn.setOnClickListener {
            startActivity(Intent(this, PieActivity::class.java))
        }
        xfermodeBtn.setOnClickListener {
            startActivity(Intent(this, XfermodeActivity::class.java))
        }
        textCustomBtn.setOnClickListener {
            startActivity(Intent(this, TextCustomActivity::class.java))
        }
        cameraViewBtn.setOnClickListener {
            startActivity(Intent(this, CameraActivity::class.java))
        }
        cirCleAnimationBtn.setOnClickListener {
            startActivity(Intent(this, CircleAnimationActivity::class.java))
        }
        pointFAnimationBtn.setOnClickListener {
            startActivity(Intent(this, PointFAnimationActivity::class.java))
        }
        cameraAnimationBtn.setOnClickListener {
            startActivity(Intent(this, CameraAnimationActivity::class.java))
        }
        provinceAnimationBtn.setOnClickListener {
            startActivity(Intent(this, ProvinceAnimationActivity::class.java))
        }
        drawableBtn.setOnClickListener {
            startActivity(Intent(this, DrawableActivity::class.java))
        }
        materialEtBtn.setOnClickListener {
            startActivity(Intent(this, MaterialEditTextActivity::class.java))
        }

        // 布局
        squareImageBtn.setOnClickListener {
            startActivity(Intent(this, SquareImageActivity::class.java))
        }
        circleBtn.setOnClickListener {
            startActivity(Intent(this, CircleActivity::class.java))
        }
        tagLayoutBtn.setOnClickListener {
            startActivity(Intent(this, TagLayoutActivity::class.java))
        }

        //触摸反馈
        scalableBtn.setOnClickListener {
            startActivity(Intent(this, ScalableActivity::class.java))
        }
        multiTouchBtn1.setOnClickListener {
            startActivity(Intent(this, MultiTouchActivity1::class.java))
        }
        multiTouchBtn2.setOnClickListener {
            startActivity(Intent(this, MultiTouchActivity2::class.java))
        }
        multiTouchBtn3.setOnClickListener {
            startActivity(Intent(this, MultiTouchActivity3::class.java))
        }
    }
}