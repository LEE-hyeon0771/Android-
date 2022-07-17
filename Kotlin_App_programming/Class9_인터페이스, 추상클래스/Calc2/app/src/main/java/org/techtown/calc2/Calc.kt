package org.techtown.calc2

class Calc : Calculator {
    override fun add(a:Int, b:Int) = a+b     //인터페이스 상속시 override 붙여줘야함
    fun subtract(a:Int, b:Int) = a-b
    fun multiply(a:Int, b:Int) = a*b
    fun divide(a:Int, b:Int) = a/b
}