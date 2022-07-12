package org.techtown.controlflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val a = 10
            val b = 20
            var max:Int

            if(a>b){
                max = a
            }
            else{
                max = b
            }

            max = if(a>b) a else b

            when(max){    //switch case와 같은 형태
                10, 20 -> {  //10과 20을 한번에 표현 가능
                    println("max가 10 or 20입니다.")
                }
                in 10..20 ->{   //10~20인 경우
                   println("max가 10~20까지 중의 하나입니다.")
                }
                else -> {  //그 외의 경우
                    println("max가 10도 아니고 20도 아닙니다.")
                }
            }
        }
    }
}