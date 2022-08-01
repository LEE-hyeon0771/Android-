package org.techtown.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        val adapter = PersonAdapter()
        adapter.items.add(Person("홍길동1", "010-4734-0787"))
        adapter.items.add(Person("홍길동2", "010-3734-0787"))
        recyclerView.adapter = adapter

        adapter.listener = object : OnPersonItemClickListener {
            override fun onItemClick(
                holder: PersonAdapter.ViewHolder?,
                view: View?,
                position: Int
            ) {
                println("아이템 클릭됨 : ${position}")
                showToast("아이템 클릭됨 : ${position}")
            }
        }
    }
        fun showToast(message:String){
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }

}