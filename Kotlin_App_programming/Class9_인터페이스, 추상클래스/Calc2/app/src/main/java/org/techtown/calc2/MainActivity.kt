package org.techtown.calc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val calc1 = Calc()
            val result1 = calc1.add(10,10)
            val result2 = calc1.subtract(20,10)
            output1.text = "더하기 결과 : ${result1}, 빼기 결과 : ${result2}"
        }

        button2.setOnClickListener {
            val calc1 = object:Calculator{    //인터페이스 내부 메서드를 일회성으로 직접 구현 - 원타임 객체
                override fun add(a:Int, b:Int):Int{
                    return a + b
                }
            }
            val result = calc1.add(10,20)
            output1.text = "더하기 결과 : ${result}"
        }
        button3.setOnClickListener {
            val calc1 = object : CalcAdapter(){  //추상클래스 내부 메서드를 일회성으로 직접 구현 - 원타임 객체
                override fun add(a:Int, b:Int):Int{
                    return a + b
                }
            }
            val result = calc1.add(10,30)
            output1.text = "더하기 결과 : ${result}"
        }
    }
}