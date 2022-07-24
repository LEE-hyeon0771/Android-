package org.techtown.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        backbutton.setOnClickListener {
            val backIntent = Intent()
            backIntent.putExtra("name","홍길동")
            setResult(Activity.RESULT_OK, backIntent)
            finish()
        }

        if(intent != null){
            processIntent(intent)
        }
    }

    fun processIntent(passedIntent: Intent){   //Intent 타입으로 MainActivity의 putExtra 값이 들어옴
        val mobile = passedIntent.getStringExtra("mobile")
        if(mobile != null){
            showToast("전달받은 값 : $mobile")
        }
        /*mobile?.run{
            showToast("전달받은 값 : $mobile")
        }*/  // -> if(mobile != null) 대신 mobile?.run을 사용할 수 있음.
    }

    fun showToast(message:String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}