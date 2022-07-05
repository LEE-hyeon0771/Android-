package org.techtown.basic2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // ? : 널허용자료형(wrapping)
    var name:String? = null  //변수상자를 만들때 wrapping
    //var name:String = "" //속성에 추가하는 변수는 반드시 초기화!! 강제
    lateinit var mobile:String //lateinit으로 나중에 초깃값 넣어주겠다는 뜻 명시 가능 but 기본자료형 ex)int, float 등에서는 사용 X (String은 기본자료형이 아니므로 사용 가능)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            //val nameLength = name!!.length //!! 필요시 unwrapping
            val nameLength = name?.length ?: 0//변수 상자의 값이 null이 아니라면 unwrapping -> error 안생김
            //null이라면 ?: 콜론 뒤의 0을 실행
            name = nameinput.text.toString()   //val 읽기 전용(값 변경 X)
            mobile = mobileinput.text.toString()
            //name, mobile은 자료형 명시 안해도 toString() 때문에 String형인지 유츄가 가능


            Toast.makeText(applicationContext, "이름 : $name, 전화번호 : $mobile", Toast.LENGTH_LONG).show()

        }
    }
}