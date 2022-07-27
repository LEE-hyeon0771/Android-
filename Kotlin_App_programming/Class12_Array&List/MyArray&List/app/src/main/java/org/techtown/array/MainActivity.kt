package org.techtown.array

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val names = arrayOf("홍길동1","홍길동2","홍길동3")   //배열함수 arrayOf
            val names2 = Array<String>(3, {index -> "홍길동${index+1}"})    //Array클래스 생성자 이용한 배열 객체
            val names3 = arrayOfNulls<String>(3)    //크기3의 비어 있는 null을 가지는 배열함수
            val names4 = emptyArray<String>()     //비어있는 크기 지정하지 않은 배열함수

            output1.append("\nnames : ${Arrays.toString(names)}")
            output1.append("\nnames2 : ${Arrays.toString(names2)}")
            output1.append("\nnames3 : ${Arrays.toString(names3)}")
            output1.append("\nnames4 : ${Arrays.toString(names4)}")

            val digits = intArrayOf(1,2,3)
            //digits.set(2,4)  //인덱스2를 4로 바꾼다(3->4), set->셋팅
            digits[2] = 4  //set(2,4)와 같은 작업(권장)
            //val aDigit = digits.get(2)   //get->가져오기
            val aDigit = digits[2]  //digits.get(2)와 같은 작업(권장)
            val digitCount = digits.count()
            val digitSize = digits.size
            output1.append("\ndigitCount 배열 크기 : $digitCount")
            output1.append("\ndigitSize 배열 크기 : $digitSize")

            val digits2 = digits.plus(5)  //5를 digits 배열에 추가
            val aIndex = digits2.indexOf(5)  //5라는 숫자가 들어있는 index 위치
            val digits3 = digits2.sliceArray(1..aIndex)  //인덱스 1~aIndex까지를 다시 배열로 만들어줌
            output1.append("\n슬라이스 한 digits3 : ${digits3.contentToString()}")  //digits2 = [1,2,4,5]인데 sliceArray되어서 index 1부터 aIndex인 5까지이므로 [2,4,5]

            digits.forEachIndexed{index, i->
                output1.append("\n#${index} : ${i}")  //각각의 원소를 넘겨 받기 digits = [1,2,4]
            }
            var index = 0
            for(i in digits){      //forEachIndexed와 같은 작업
                output1.append("\n#${index} : ${i}")
                index += 1
            }

            val iter = digits.iterator()
            index = 0
            while(iter.hasNext()){      //iterator 사용해서 순회
                val i = iter.next()
                output1.append("\n#${index} : ${i}")
                index += 1
            }

            val sortedArray = digits.sortedArray()  // 오름차순 정렬
            val sortedArray2 = digits.sortedArrayDescending()   //내림차순 정렬

            digits.filter{ elem -> elem > 1 }.forEach { //filtering된 원소를 보여준다.  여기서는 원소가 1보다 클 때만 보여줌.
                output1.append("\n원소 : ${it}")
            }

            button2.setOnClickListener {
                val names = listOf("홍길동1","홍길동2","홍길동3")  //기본 리스트는 immutable이므로 수정이 안됨.
                val names2 = List<String>(3) {index -> "홍길동${index+1}"}  //배열 형태와 살짝 차이가 있음.
                //names.add("홍길동4") -> 이런식으로 붙여지지가 않음.
                val names3 = mutableListOf<String>("홍길동1","홍길동2","홍길동3")
                names3.add("홍길동4")  //List 맨 뒤에 추가
                names3[1] = "홍길동5"  //index 1자리 수정
                output1.append("\n${names3.joinToString()}")

                val names4 = emptyList<String>()
                val names5 = arrayListOf<String>()   //JAVA의 arrayList와 같은 기능
                val names6 = ArrayList<String>()

                if(names3.contains("홍길동5")){
                    val aIndex = names3.indexOf("홍길동5")   //홍길동5를 꺼내와서 aIndex에 담기
                    val names4 = names3.slice(0..aIndex)  //names4를 names3 리스트의 0~홍길동5까지 slice
                    output1.append("\n${names4.joinToString()}")
                }
            }
        }
    }
}