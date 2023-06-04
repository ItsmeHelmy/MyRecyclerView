package com.example.myrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(
    private val context: Context,
    private val dataList: ArrayList<UserModel>
): RecyclerView.Adapter<RVAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val tvId = view.findViewById<TextView>(R.id.tv_id)
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvUsername = view.findViewById<TextView>(R.id.tv_username)
        val tvEmail = view.findViewById<TextView>(R.id.tv_email)
        val cvMain = view.findViewById<CardView>(R.id.cv_main)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.items_main, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvId.text = dataList.get(position).id.toString()
        holder.tvName.text = dataList.get(position).name
        holder.tvUsername.text = dataList.get(position).username
        holder.tvEmail.text = dataList.get(position).email
        holder.cvMain.setOnClickListener {
            Toast.makeText(context, "" + dataList.get(position).username, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = dataList.size

    fun setData(data: ArrayList<UserModel>){
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }
}