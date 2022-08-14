package org.techtown.tab

import android.icu.number.NumberFormatter.with
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, FirstFragment()).commit()
        //tab 1,2,3을 누르면 각 Fragment로 이동시키기
        bottomNavigationView.setOnItemReselectedListener {
            when(it.itemId){
                R.id.tab1 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container, FirstFragment()).commit()

                }
                R.id.tab2 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container, SecondFragment()).commit()

                }
                R.id.tab3 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container, ThirdFragment()).commit()

                }
            }
        }
    }
}