package org.techtown.calc2

class Calc2 : CalcAdapter() {     //추상클래스 상속 -> 자연스럽게 subtract까지 Calc2로 오게됨

    override fun add(a:Int, b:Int):Int {       //추상클래스의 추상메서드의 return값을 설정
        return a + b
    }
}