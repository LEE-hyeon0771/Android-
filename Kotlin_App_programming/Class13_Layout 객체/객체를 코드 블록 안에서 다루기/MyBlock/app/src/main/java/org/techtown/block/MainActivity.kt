package org.techtown.block

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            val person1 = Person()
            person1?.name = "홍길동1"
            person1?.age = 20
            person1?.mobile = "010-1000-1000"

            //위의 코드 간결하게 줄이기 -> apply
            val person2:Person? = Person().apply{      //새로운 객체 속성 만들기(apply) -> this 또는 아무것도 안해도 됨.
                this.name = "홍길동1"  //this로 명시도 가능
                age = 20
                mobile = "010-1000-1000"
            }

            showToast("이름 : ${person2?.name}")
            showToast("나이 : ${person2?.age}")
            showToast("전화번호 : ${person2?.mobile}")

            with(person2!!){     //이때만 unwrapping, with 이용해서 person2 속성을 한번에 지정가능능
                showToast("이름 : ${name}")
                showToast("나이 : ${age}")
                showToast("전화번호 : ${mobile}")
            }

            if(person2 != null){   //person2 객체를 null이 아닐 때 이므로 ? 다 떼도 가능
                showToast("이름 : ${person2.name}")
                showToast("나이 : ${person2.age}")
                showToast("전화번호 : ${person2.mobile}")
            }
            else {
                showToast("사람 객체가 null 입니다.")
            }

            person2?.let{          //위 if문과 동일한 코드인데 ?.let을 이용하면 it으로 객체를 받아서 간결하게 표현 가능
                showToast("이름 : ${it.name}")
                showToast("나이 : ${it.age}")
                showToast("전화번호 : ${it.mobile}")
            } ?:run{          //위의 else문과 같은 동작방식 ?:run
                showToast("사람 객체가 null 입니다.")
            }

            person2?.run{          //위 let문과 동일한 코드인데 ?.run이 this로 name, age, mobile 객체를 받아서 더 간결하게 표현 가능
                showToast("이름 : ${name}")     //this.name의 형태로 자동적으로 치환됨.
                showToast("나이 : ${age}")      //this.age의 형태로 자동적으로 치환됨.
                showToast("전화번호 : ${mobile}")      //this.mobile의 형태로 자동적으로 치환됨.
            } ?:run{          //위의 else문과 같은 동작방식 ?:run
                showToast("사람 객체가 null 입니다.")
            }

            val person3 = Person()
            if(person3.name == null){
                showToast("사람 객체의 name 속성이 null 입니다.")
            }
            if(person3.age == null){
                showToast("사람 객체의 age 속성이 null 입니다.")
            }
            if(person3.mobile == null){
                showToast("사람 객체의 mobile 속성이 null 입니다.")
            }

            val person4 = Person()
            person4.also {        //이미 지정된 객체의 속성을 임시로 변경(also) -> it으로
                if (it.name == null) {
                    showToast("사람 객체의 name 속성이 null입니다.")
                }
                it.name = "홍길동4"   //새로운 객체 속성으로 접근
                if (it.age == null) {
                    showToast("사람 객체의 age 속성이 null입니다.")
                }
                it.age = 21
                if (it.mobile == null) {
                    showToast("사람 객체의 mobile 속성이 null입니다.")
                }
            }
        }
    }
    fun showToast(message:String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}