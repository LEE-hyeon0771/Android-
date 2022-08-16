package org.techtown.pager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //뷰페이저는 껍데기고 뷰페이저의 각 아이템들을 adapter를 만들어서 관리해야함.
        pager.adapter = PagerAdapter(this)
        pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL  //방향
        pager.offscreenPageLimit = 3 //페이지가 3개 이므로 페이지 수를 고정


        pager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            //원타임 객체로 object를 이용하여 만듦.
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                showToast("페이지 선택 : ${position}")
            }
        })   //페이지가 변경될 때 마다 알 수 있도록 설정

        button.setOnClickListener {
            pager.currentItem = 0   //position이 0인 Firstfragment
        }
        button2.setOnClickListener {
            pager.currentItem = 1
        }
        button3.setOnClickListener {
            pager.currentItem = 2
        }
    }

    fun showToast(message: String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    //어댑터 설정하기(클래스로 만들어서 그 객체를 뷰페이저에 설정한다.)
    inner class PagerAdapter:FragmentStateAdapter{
        //Adapter는 생성자의 파라미터로 FragmentActivity를 상속받음
        constructor(activity: FragmentActivity):super(activity)

        override fun getItemCount(): Int = 3   //fragment 아이템 갯수

        override fun createFragment(position: Int): Fragment {   //fragment 만들기 -> 경우의 수로 나누어줌
            return when(position){
                0 -> {
                     FirstFragment()
                }
                1 -> {
                     SecondFragment()
                }
                2 -> {
                     ThirdFragment()
                }
                else -> {
                     FirstFragment()
                }
            }
        }
    }
}
