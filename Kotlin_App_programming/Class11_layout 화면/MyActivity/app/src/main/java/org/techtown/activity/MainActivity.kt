package org.techtown.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showbutton.setOnClickListener {
            //새로운 화면을 띄우고 싶을 때 Intent 객체를 사용
            val showIntent = Intent(this, MenuActivity::class.java)
            startActivityForResult(showIntent, 101)     //응답을 받아서 화면을 띄울거면 ForResult 붙여줘야함
        }
    }
}