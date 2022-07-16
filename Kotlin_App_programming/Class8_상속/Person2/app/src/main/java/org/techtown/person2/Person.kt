package org.techtown.person2

import android.widget.TextView

open class Person(open var name:String?) {    //open을 적어줘야 상속이 됨
    var age:Int? = null
    var address:String? = null

    constructor(name:String?, age:Int?, address:String?):this(name){
        println("Person의 생성자 호출됨")

        this.age = age
        this.address = address
    }

    open fun walk(output: TextView){
        println("걷는다.")
        output.text = "사람이 걷는다."
    }
}