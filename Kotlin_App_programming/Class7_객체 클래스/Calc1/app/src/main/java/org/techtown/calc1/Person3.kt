package org.techtown.calc1

class Person3(var name:String?) {

    var age:Int? = null
    lateinit var address:String

    constructor(name:String?, age:Int?):this(name){  //처음에 기본생성자를 가지고 있는 class에서 constructor를 가질때는 :this(생성자변수) 를 붙여주어야함.

    }
}