package org.techtown.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.edit
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
        showToast("onCreate함수 호출됨")

        savebutton.setOnClickListener {
            val input1 = input1.text.toString()
            val pref = getSharedPreferences("pref", MODE_PRIVATE)
            //pref.edit().putString("userName", input1).commit()
            pref.edit {
                //SharedPreferences함수를 조작하는 것 - edit
                putString("userName", input1)        //input1에 입력한 userName을 저장함
                commit()          //이런식으로 더 많이 사용함 - 람다식 형태로
            }
        }

        loadbutton.setOnClickListener {
            val pref = getSharedPreferences("pref", MODE_PRIVATE)
            val userName = pref.getString("userName","")           //userName의 데이터를 가져옴
            input1.setText(userName)          //input1에 저장되어 있는 userName을 input1에 다시 불러옴
        }
    }

    override fun onStart() {
        super.onStart()
        showToast("onStart함수 호출됨")
    }

    override fun onRestart() {
        super.onRestart()
        showToast("onRestart함수 호출됨")
    }

    override fun onPause() {
        super.onPause()
        showToast("onPause함수 호출됨")
    }

    override fun onStop() {
        super.onStop()
        showToast("onStop함수 호출됨")
    }

    override fun onDestroy() {
        super.onDestroy()
        showToast("onDestroy함수 호출됨")
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