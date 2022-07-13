package org.techtown.calc1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            var name = input.text.toString()

            val calc1 = Calc()
            calc1.name = name

            show("계산기 객체 만들어짐 : ${calc1.name}")

            val result = calc1.add(10,20)
            show("더하기 결과 : $result")

            val person1 = Person(name)
            show("사람 객체 만들어짐 : ${person1.name}")

            val person2 = Person2("홍길동", 20, "종로구")

            val person3 = Person3("홍길동", 20)
        }
    }

    fun show(message:String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }
}