package org.techtown.basic3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.techtown.basic3.constants.mBonus

//데이터 문자 -> 숫자 & 동반객체 & 패키지 변수
class MainActivity : AppCompatActivity() {

    var firstStr:String = ""
    var secondStr:String = ""
    var first:Int = 0
    var second:Int = 0

    companion object{  // 동반객체 : 이걸 사용할 때는 classname.변수로 함수 내에서 사용 가능
        const val BONUS = 100 //const val -> 상수
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton.setOnClickListener {
            firstStr = input1.text.toString()
            secondStr = input2.text.toString()

            first = firstStr.toInt() //데이터를 문자 -> 숫자
            second = secondStr.toInt()

            val result = first + second + MainActivity.BONUS + mBonus //문자를 붙여서 표현(숫자도 문자로 인식)
            //mBonus : import 후 패키지 변수로 사용 가능
            output1.text = "결과 : $result"
        }

    }
}