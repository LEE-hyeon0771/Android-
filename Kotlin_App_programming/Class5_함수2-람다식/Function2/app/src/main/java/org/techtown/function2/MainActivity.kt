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

            var show1 = {println("show 함수 호출됨")}   //fun show()와 같은 기능을 하는 람다식
            var show2:()->Unit = {println("show 함수 호출됨")}  //들어오는 값 X, 나가는 값 Unit

            val sum = fun(a:Int, b:Int):Int{       //람다식의 변수상자 sum을 함수로 바로 사용 가능
                return a + b
            }
            sum(10,10)
            doAction(fun():Int{             //숫자 반환일 때
                println("전달된 함수 호출됨.")
                return 10
            })

            doAction{
                println("전달된 함수 호출됨.")
                10   //바로 호출될 때 return 안적음
            }

            doAction{
                println("전달된 함수 호출됨.")
                return@doAction 10    //return 적으려면 라벨을 이용해서 범위 결정해 주어야함.
            }
        }
    }

    fun doAction(action:()->Int){     //파라미터를 함수 형태로 람다식 표현
        println("doAction 호출됨.")
        val result = action()
    }
    fun show():Unit{    //Unit : void의 의미 -> 생략도 가능
        println("show 함수 호출됨.")
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