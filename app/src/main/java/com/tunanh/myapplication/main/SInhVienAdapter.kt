package com.tunanh.myapplication.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tunanh.myapplication.R


class SInhVienAdapter(private val sinhVien: MutableList<SinhVien>,context: MainActivity) :
    RecyclerView.Adapter<SInhVienAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView= itemView.findViewById(R.id.names)
        var address: TextView= itemView.findViewById(R.id.addresss)
        var phone: TextView= itemView.findViewById(R.id.phones)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.sinhvien,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemsinhVien = sinhVien[position]
        holder.name.text=itemsinhVien.name
        holder.address.text=itemsinhVien.address
        holder.phone.text=itemsinhVien.phone

    }

    override fun getItemCount(): Int {

             return sinhVien.size

    }

}
