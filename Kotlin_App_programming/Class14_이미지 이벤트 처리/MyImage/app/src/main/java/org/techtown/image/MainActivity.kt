package org.techtown.image

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coffeeImageView.setOnTouchListener{v, event ->
            when(event.action){
                MotionEvent.ACTION_DOWN -> {
                    println("손가락 눌림.")
                }
                MotionEvent.ACTION_MOVE -> {
                    println("손가락 움직임.")
                }
                MotionEvent.ACTION_UP -> {
                    println("손가락 뗌.")
                }
            }
            return@setOnTouchListener true   //터치 모션으로 발생하는 모션이벤트 처리
        }
    }
}