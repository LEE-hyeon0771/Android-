package com.example.hyeonipractice

//Companion클래스
class Book private constructor(val id : Int, val name : String){
    companion object BookFactory : IdProvider{       //companion = java의 static 역할
        override fun getId() : Int{
            return 444
        }

        val myBook = "new book"

        fun create() = Book(getId(), myBook)
    }
}


interface  IdProvider {
    fun getId() : Int
}

fun main(){
    val book = Book.create()

    val bookId = Book.BookFactory.getId()
    println("${book.id} ${book.name}")
}