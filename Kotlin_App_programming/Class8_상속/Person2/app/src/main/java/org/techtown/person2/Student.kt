package org.techtown.person2

import android.widget.TextView

class Student(override var name:String?):Person(name){  //상속 1번째 방법 : Person class를 상속 받고 alias는 Person class의 name이 됨.
              //속성도 overriding 가능
    constructor(name:String?, age:Int?, address:String?):this(name){     //상속시 Person(alias)로 적어줬기 때문에 this로 alias를 받을 수 있음
        println("Student 생성자 호출됨")
        this.age = age
        this.address = address
    }
    override fun walk(output: TextView){    //메서드 오버라이딩
        super.walk(output)
        println("걷는다.")
        output.text = "사람이 걷는다."
    }
}