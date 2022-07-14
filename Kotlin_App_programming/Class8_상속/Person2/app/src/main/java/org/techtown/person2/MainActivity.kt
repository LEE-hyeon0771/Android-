package org.techtown.person2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var person:Person? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            makePerson(1)

        }

        button2.setOnClickListener {
            makePerson(2)
        }
    }

    fun makePerson(type:Int){
        val name = input1.text.toString()
        val age = input2.text.toString().toInt()
        val address = input3.text.toString()

        when(type){
            1->{
                person = Person(name, age, address)
                output.text = "사람 객체 만들어짐 : ${person?.name}"
                output2.setImageResource(R.drawable.original)   //이미지 파일 넣기
            }
            2->{
                person = Student(name, age, address)
                    output.text = "학생 객체 만들어짐 : ${person?.name}"
                output2.setImageResource(R.drawable.student)    //이미지 파일 넣기
                }
            }
        }
    }
