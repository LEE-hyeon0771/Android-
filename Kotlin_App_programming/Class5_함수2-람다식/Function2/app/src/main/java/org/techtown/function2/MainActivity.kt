package org.techtown.function2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            //val result = add(10,20) -> 함수식
            val addFunc = { a:Int, b:Int -> a + b }  //람다식 -> 바로 변수에 함수를 할당
            //val result = addFunc(10,20)   //람다식을 이용한 변수를 함수처럼럼 동일하게 사용능
            val result = calc(10,20, addFunc)   //addFunc이 oper 함수 이름으로 들어감

            val addFunc2 = getOperator("add")
            val result2 = calc(20,20, addFunc2!!)   //oper을 unwrapping

            output.text = "더하기 결과 : $result"
            output2.text = "계산 결과 : $result2"
            val multiply = {a:Int, b:Int -> a * b}
            val multiply2:(Int, Int)->Int = {a, b -> a * b}
        }
    }

    fun getOperator(name:String): ((Int, Int) -> Int)? {   //null 값 전달을 위해 자료형에 ? 입력
        var oper:((Int,Int)->Int)? = null //wrapping해서 null 입력
        if(name == "add") {
            oper = { a, b -> a + b }
        }
        else if(name == "subtract"){
            oper = {a, b -> a - b}
        }
        return oper
    }
    fun calc(first:Int, second:Int, oper:(Int,Int)->Int):Int{
        return oper(first, second)   //계산하는 oper 함수를 받음
    }
    fun add(a:Int, b:Int):Int{
        return a + b
    }
}