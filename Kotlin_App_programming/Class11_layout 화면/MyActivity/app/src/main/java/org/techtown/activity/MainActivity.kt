package org.techtown.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showbutton.setOnClickListener {
            //새로운 화면을 띄우고 싶을 때 Intent 객체를 사용
            val showIntent = Intent(this, MenuActivity::class.java)
            showIntent.putExtra("mobile","010-4734-0787")   //key-value
            startActivityForResult(showIntent, 101)     //응답을 받아서 화면을 띄울거면 ForResult 붙여줘야함
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            101 ->{
                showToast("메뉴 액티비티로부터 응답 받았음, ${requestCode}, ${resultCode}")
            if(data != null){
                processIntent(data)
            }
            }
        }
    }
    fun processIntent(passedIntent:Intent){
        val name = passedIntent.getStringExtra("name")
        if(name != null){
            showToast("메뉴 액티비티로부터 전달받은 데이터 : $name")
        }
    }
    fun showToast(message:String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}