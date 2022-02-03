package com.example.hyeonipractice

fun main(){
    helloWorld()
    println(add(4,5))

    //3. String Template
    val name = "Joyce"
    val lastName = "Hong"
    println("my name is ${name + lastName} I'm 30")
    println("Is this true? ${1==0}")
    println("this is 2\$a")    //$표시를 직접 적고 싶을 떄

    checkNum(1)

    forAndWhile()

    nullcheck()


}

//1.함수
fun helloWorld() {
    println("Hello World!")
}

fun add(a: Int, b: Int) : Int{       //:Int 는 return type : 리턴 해줄 때 반드시 type 지정
    return a+b
}

//2. val vs var
//val = value : 안 바뀜(상수)
//var = variable : 바뀜(변수)
fun hi() {
    val a: Int = 10
    var b: Int = 9
    val c = 100        //타입 안써도 크게 문제 없음
    var d = 100

    var name = "hyeoni"
    var e: String  //초기화 없이 선언만 할 때는 type 필요


}

//4. 조건식
fun maxBy(a:Int, b:Int) : Int{
    if(a>b){
        return a
    }
    else{
        return b
    }
}

fun maxBy2(a:Int, b:Int) = if(a>b) a else b

fun checkNum(score : Int){
    when(score){                          //when => switch case문
        0-> println("this is 0")          //이 경우에는 else를 써도 되고 안 써도 됨
        1-> println("this is 1")
        2,3-> println("this is 2 or 3")
        else -> println("nothing")
    }

    var b = when(score){      //이렇게 쓸 때는 else가 반드시 필요 Expression
        1->1
        2->2
        else -> 3
    }

    println("b: ${b}")

    when(score){
        in 90..100 -> println("You ar genius")         //A~B까지는 in 사용
        in 10..80 -> println("not bad")
        else -> println("Okay")
    }
}

//Expression vs Statement
//Kotlin은 모든 함수가 type이 지정되므로 Expression
//Expression : 뭔가를 해서 값을 return 하는 경우
//Statement : 이렇게 하라는 명령을 나타내는 경우

//5. Array and List
//Array
//List 1. List(읽기 전용,수정 불가), 2. MutableList(읽기, 쓰기 모두 가능)-arrayList

fun array(){
    val array = arrayOf(1,2,3)
    val list = listOf(1,2,3)

    val array2 = arrayOf(1,"d",3.4f)
    val list2 = listOf(1,"d",11L)

    array[0] = 3
    var result = list.get(0) //list는 읽기 전용이므로 get으로 불러오기만 가능
    val arrayList = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)
    arrayList[0] = 20
}

//6. 반복문
//for / while

fun forAndWhile(){
    val students = arrayListOf("joyce","james","jenny","jennifer")

    for(name in students){
        println("${name}")
    }

    for((index,name) in students.withIndex()){   //index를 함께 출력
        println("${index+1}번째 학생 : ${name}")
    }
    var sum = 0
    for(i in 1..10){   //1~10 오름차순
        sum += i
    }
    println(sum)

    var sum1 = 0
    for(i in 1..10 step 2){    //2 간격으로
        sum1 += i
    }
    println(sum1)

    var sum2 = 0
    for(i in 1 until 100){   //1~99까지
        sum2 += i
    }
    println(sum2)

    var sum3 = 0
    for(i in 10 downTo 1){   //10~1 내림차순
        sum3 += i
    }
    println(sum3)

    var index = 0
    while(index < 10){
        println("current Index : ${index}")
        index++
    }
}

//7. Nullable / NonNull

fun nullcheck(){
    //NPE : NUll Pointer Exception

    var name = "joyce"

    var nullName : String? = null  //null을 입력해 주기 위해서는 ?를 넣어주어야함

    var nameInUpperCase = name.toUpperCase()

    var nullNameInUpperCase = nullName?.toUpperCase()  //nullName이 null이 아니면 toUpperCase, null이면 null을 반환

    // ? :

    val lastName : String? = null

    val fullName = name +" "+ (lastName?: "NO lastName")
    println(fullName)

    //!!
}
//!! : 확실히 null이 아닐때만 사용
fun ignoreNulls(str:String?){
    val mNotNull : String = str!! //절대 null일리 없으니까 null이 아니라고 판단해라는 뜻
    val upper = mNotNull.toUpperCase()  //?없이도 !!때문에 가능

//let함수 : receiver 객체를 let 안으로 옮겨줌
    val email : String? = "joycehongXXXX@nana.vom"
    email?.let{
        println("my email is ${email}")

    }
}