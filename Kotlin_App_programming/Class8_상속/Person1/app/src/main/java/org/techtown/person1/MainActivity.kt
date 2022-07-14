package org.techtown.person1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            val name = input1.text.toString()
            val age = input2.text.toString().toInt()
            val address = input3.text.toString()

            val person = Person(name, age, address)
            output.text = "사람 객체 만들어짐 : ${person.name}"

        }

        button2.setOnClickListener {
            val name = input1.text.toString()
            val age = input2.text.toString().toInt()
            val address = input3.text.toString()

            val student1 = Student(name, age, address)
            output.text = "학생 객체 만들어짐 : ${student1.name}"
        }
    }
}