package org.techtown.hello

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //버튼 클릭시 동작시키는 부분
        button.setOnClickListener {
            Toast.makeText(applicationContext, "버튼이 눌렸어요.", Toast.LENGTH_LONG).show()
        }
        //버튼2 클릭시 동작시키는 부분
        button2.setOnClickListener {
            val input1 = input1.text.toString()  //id : input1의 text를 불러와서 input1 변수상자에 입력
            output1.text = "결과 : $input1" //변수 input1내용을 id : output1의 text에 그대로 넣어서 결과 출력
        }
    }
}