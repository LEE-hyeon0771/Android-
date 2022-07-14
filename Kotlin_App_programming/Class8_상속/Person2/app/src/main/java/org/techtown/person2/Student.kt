package org.techtown.person2

class Student(val alias:String?):Person(alias){  //상속 1번째 방법 : Person class를 상속 받고 alias는 Person class의 name이 됨.

    constructor(alias:String?, age:Int?, address:String?):this(alias){     //상속시 Person(alias)로 적어줬기 때문에 this로 alias를 받을 수 있음
        println("Student 생성자 호출됨")
        this.age = age
        this.address = address
    }
}