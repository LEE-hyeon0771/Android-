package org.techtown.fragment

import android.icu.number.NumberFormatter.with
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var loginFragment: LoginFragment = LoginFragment()
    var menuFragment: MenuFragment = MenuFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showLoginButton.setOnClickListener {
            //supportFragmentManager.beginTransaction().replace(R.id.container, LoginFragment())
                //.commit()
            //commit() -> 앞의 함수들을 한번에 실행시킴
            onFragmentChanged(0)

        }
        showMenuButton.setOnClickListener {
            //supportFragmentManager.beginTransaction().replace(R.id.container, MenuFragment())
                //.commit()
            onFragmentChanged(1)
        }
    }

    fun onFragmentChanged(index: Int){
        when(index){
            0 -> {
                supportFragmentManager.beginTransaction().replace(R.id.container, LoginFragment())
                    .commit()     //액티비티에 프래그먼트 추가(동작 가능)
            }

            1 -> {
                supportFragmentManager.beginTransaction().replace(R.id.container, MenuFragment())
                    .commit()     //액티비티에 프래그먼트 추가(동작 가능)
            }
        }
    }
}