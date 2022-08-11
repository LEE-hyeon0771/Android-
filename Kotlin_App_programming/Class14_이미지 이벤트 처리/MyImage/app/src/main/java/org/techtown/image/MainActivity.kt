package org.techtown.image

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_main.*

var startX = 0.0f
var startY = 0.0f
var leftMargin = 0
var topMargin = 0

var coffeeWidth = 0.0f
var coffeeHeight = 0.0f

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //dimens.xml에 resource값 불러옴
        coffeeWidth = resources.getDimension(R.dimen.coffee_width)
        coffeeHeight = resources.getDimension(R.dimen.coffee_height)

        //터치 - setOnTouchListener, Motion event
        coffeeImageView.setOnTouchListener{v, event ->
            when(event.action){
                MotionEvent.ACTION_DOWN -> {
                    println("손가락 눌림.")

                    startX = event.x    //터치한 위치 좌표
                    startY = event.y
                }

                //터치하고 있으면 이미지가 따라오게 하는 작업
                MotionEvent.ACTION_MOVE -> {
                    println("손가락 움직임.")

                    val diffX = event.x - startX
                    val diffY = event.y - startY

                    leftMargin += diffX.toInt()
                    topMargin += diffY.toInt()

                    val layoutParams = FrameLayout.LayoutParams(
                        coffeeWidth.toInt(),     //dimens 값 설정해준 변수로
                        coffeeHeight.toInt()
                    )
                    layoutParams.leftMargin = leftMargin   //leftMargin, topMargin은 읽기 전용변수이므로, layoutParmas를 위 처럼 설정해야만 설정 가능
                    layoutParams.topMargin = topMargin
                    coffeeImageView.layoutParams = layoutParams
                }
                MotionEvent.ACTION_UP -> {
                    println("손가락 뗌.")
                }
            }
            return@setOnTouchListener true   //터치 모션으로 발생하는 모션이벤트 처리
        }
    }
}