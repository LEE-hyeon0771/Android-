package com.example.hyeonipractice

open class Human constructor(val name: String = "Annoymous"){

    //val name = "joyce"

    constructor(name: String, age:Int) : this(name){  //부생성자 오버로딩 (주생성자 매개변수를 상속)
        println("my name is ${name}, ${age}years old")
    }

    init {        //initialize 초기화(주생성자의 일부)
        println("New human has been born!!")
    }

    fun eatingCake(){
        println("This is so YUMMMMMY~~~~")
    }
    open fun singASong(){
        println("lalala")
    }
}

class Korean : Human(){      //같은 파일 안이더라도 코틀린 class는 모두 final 클래스 이므로 open 시키지 않으면 상속 X
    override fun singASong(){      //final 메소드 이므로 open 시켜줘야 오버라이딩 됨
        super.singASong()
        println("라라라")
        println("my name is : ${name}")
    }
}

fun main(){
    val human = Human("minsu")

    val stranger = Human()
    human.eatingCake()

    val mom = Human("Kuri", 52)
    println("this human's name is ${human.name}")
    println("this human's name is ${stranger.name}")

    val korean = Korean()
    korean.singASong()
}