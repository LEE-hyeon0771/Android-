package org.techtown.person1

open class Person(var name:String?) {    //open을 적어줘야 상속이 됨
    var age:Int? = null
    var address:String? = null

    constructor(name:String?, age:Int?, address:String?):this(name){
        println("Person의 생성자 호출됨")

        this.age = age
        this.address = address
    }
}