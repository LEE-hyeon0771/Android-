package org.techtown.calc1

class Person(var name:String?) {

    //var name:String? = null
    var age:Int? = null
    lateinit var address:String

    init{
        println("생성자 호출됨")
    }
}