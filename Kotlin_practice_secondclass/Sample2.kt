package com.example.hyeonipractice

//1.Lamda
//람다식은 우리가 마치 value 처럼 다룰 수 있는 익명함수이다.
//1) 메소드의 파라미터로 넘겨줄 수 가 잇따. fun maxBy(a: Int) -> 파라미터 안에 람다함수를 넣어줄 수 있음
//2) return 값으로 사용할 수가 있다.

//람다의 기본 정의
//val lamdaName : (Type) -> (Type) = {argumentList -> codeBody}

val square : (Int) -> (Int) = {number -> number*number}
//(Int)를 input해서 (Int)로 return 하라는 뜻 : type을 가르쳐줌

val nameAge = {name : String, age: Int ->
    "my name is ${name} I'm ${age}"
}
fun main(){
    println(square(12))
    println(nameAge("joyce",99))
    val a = "joyce said"
    val b = "android said"
    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())
    println(extendString("ariana",27))
    println(calculateGrade(97))
    println(calculateGrade(971))

    val lamda = {number : Double ->
        number == 4.3213
    }
    println(invokeLamda(lamda))
    println(invokeLamda({it > 3.22}))        //it은 파라미터 1개
    println(invokeLamda{it > 3.22})       //마지막 파라미터가 람다식일 때 32줄 처럼 안쓰고 () 지우고 33줄 처럼 사용한다. -> 빈출
}

// 확장함수

val pizzaIsGreat : String.() -> String = {
    this + " Pizza is the best!"
}

fun extendString(name : String, age : Int) : String{
    val introduceMyself : String.(Int) -> String = { "I am ${this} and ${it} years old"}     //this는 String을 가리키고, (Int)처럼 하나 들어가는 파라미터인 경우 it 사용가능
    return name.introduceMyself(age)
}

//람다의 Return

val calculateGrade : (Int) -> String = {
    when(it){
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

//람다를 표현하는 여러가지 방법
//1. 함수 파라미터 안에 람다식 표현
fun invokeLamda(lamda : (Double) -> (Boolean)) : Boolean{      //Double을 input해서 Boolean을 return하는 파라미터에 invokeLamda함수는 Boolean을 return한다.
    return lamda(5.2343)
}

