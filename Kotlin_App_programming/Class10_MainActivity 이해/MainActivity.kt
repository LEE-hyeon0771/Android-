package org.techtown.calc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {     //AppCompatActivity 클래스를 상속받음
    override fun onCreate(savedInstanceState: Bundle?) {   //onCreate라는 함수는 AppCompatActivity에 이미 정의되어 있으므로 override
        super.onCreate(savedInstanceState)          //super로 부모클래스의 onCreate를 참조
        setContentView(R.layout.activity_main)      //setContentView는 activity_main.xml과 MainActivity.kt를 연결하는 역할

        button.setOnClickListener {
            val calc1 = Calc()
            val result1 = calc1.add(10,10)
            val result2 = calc1.subtract(20,10)
            output1.text = "더하기 결과 : ${result1}, 빼기 결과 : ${result2}"
        }

        button2.setOnClickListener {
            val calc1 = object : Calculator{    //인터페이스 내부 메서드를 일회성으로 직접 구현 - 원타임 객체
                override fun add(a:Int, b:Int):Int{       //implements 대신에 kotlin에서는 : 로 인터페이스 상속
                    return a + b
                }
            }
            val calc2 = object : CalcAdapter(){  //추상클래스 내부 메서드를 일회성으로 직접 구현 - 원타임 객체
                override fun add(a:Int, b:Int):Int{        //extends 대신에 kotlin에서는 : 로 추상클래스 상속
                    return a + b
                }
            }
            val result1 = calc1.add(10,30)
            output1.text = "더하기 결과 : ${result1}"
            val result2 = calc2.add(10,20)
            output1.text = "더하기 결과 : ${result2}"
        }

        button3.setOnClickListener(object: View.OnClickListener {    //원래 setOnClickListener 구현 방법
            override fun onClick(v: View?) {        //원타임 객체 사용
                println("버튼 클릭됨")
            }
        })

        button3.setOnClickListener({ v ->  println("버튼 클릭됨") })   //setOnClickListener 람다식으로 적기

        button3.setOnClickListener() { v -> println("버튼 클릭됨") }
        button3.setOnClickListener { v -> println("버튼 클릭됨") }
        button3.setOnClickListener {         //람다식 축약 최종 버전 -> 우리가 사용하던 코드
            println("버튼 클릭됨")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}