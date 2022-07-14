package org.techtown.person2

class Student2 : Person {   //상속 2번째 방법

    constructor(alias:String?, age:Int?, address:String?):super(alias){    //상위 객체 받을때 super적어주는 방법
        println("Student2의 생성자 호출됨")

        this.age = age
        this.address = address
    }
}