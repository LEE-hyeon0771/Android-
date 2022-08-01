package org.techtown.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.person_item.view.*


class PersonAdapter : RecyclerView.Adapter<PersonAdapter.ViewHolder>(){
    //리스트 모양 위젯 : RecyclerView, Adapter : RecyclerView의 데이터 관리, 화면에 나오는 각각의 아이템 만들기
    var items = ArrayList<Person>()

    lateinit var listener : OnPersonItemClickListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent, false)
        return ViewHolder(itemView)

    }    //뷰홀더 객체 만들어질 때 호출

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }    //뷰홀더 객체 재사용될 때 호출

    override fun getItemCount() = items.size
         //어댑터에서 관리하는 아이템의 개수를 반환

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener{
                listener?.onItemClick(this, itemView, adapterPosition)
                //onItemClick으로 다시 던져줌

            }
        }
        fun setItem(item:Person){
            itemView.output1.text = item.name
            itemView.output2.text = item.mobile
        }
    }
}