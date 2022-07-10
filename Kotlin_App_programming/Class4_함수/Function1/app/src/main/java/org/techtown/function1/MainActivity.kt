package org.techtown.function1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            show("안녕") //message: 안녕
        }
        button2.setOnClickListener {
            val firstStr = input1.text.toString()
            val secondStr = input2.text.toString()

            val first = firstStr.toInt()
            val second = secondStr.toInt()

            val result = add(first, second)
            textView.text = "더하기 결과 : $result"
        }

        button3.setOnClickListener {
            val result = add(getFirst(), getSecond())
            textView.text = "더하기 결과 : $result"
            val result3 = sum(10,20,30)
            showToast("결과 : ${result3}")
        }
    }
    fun sum(vararg inputs:Int):Int{   //가변 파라미터
        var output = 0
        for(num in inputs){
            output += num
        }
        return output
    }
    fun showToast(message:String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }
    fun getFirst():Int{
        val firstStr = input1.text.toString()
        return firstStr.toInt()
    }
    fun getSecond():Int{
        val secondStr = input2.text.toString()
        return secondStr.toInt()
    }

    fun add(a:Int, b:Int):Int{
        return a+b
    }

    fun add2(a:Int, b:Int):Int = a+b   //함수 축약 - 한 줄 일 경우 가능
    fun add3(a:Int, b:Int) = a+b //결과 타입 추론 가능해서 Int 생략 가능

    fun show(message:String){  //이름: show, 데이터: message
        println("버튼이 눌렸어요 : ${message}")
    }
}