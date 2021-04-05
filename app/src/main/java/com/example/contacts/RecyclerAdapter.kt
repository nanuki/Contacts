package com.example.contacts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

public class RecyclerAdapter(val context: Context, val data: MutableList<RowData>) : RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_contacts, parent,false)
        return CustomViewHolder(view)

    }

    override fun getItemCount(): Int {
       // return Int.MAX_VALUE
        return data.size
    }
    fun getIndexByPosition(position: Int): Int{
        return position % data.size

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val curentdata = data[getIndexByPosition(position)]
       // val curentdata = data[position]
        holder.image.setImageResource(curentdata.image)
        holder.name.text = curentdata.name
        holder.phone.text = curentdata.phone
        holder.delete.setOnClickListener(View.OnClickListener { removeItem(getIndexByPosition(position)) })
        holder.image.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, Contactsdetails::class.java)
            intent.putExtra("image", curentdata.image)
            intent.putExtra("name", curentdata .name)
            intent.putExtra("phone", curentdata .phone)
            intent.putExtra("position", position)
            context.startActivity(intent)
        })
    }


    class CustomViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image: ImageView
        val name: TextView
        val phone: TextView
        val delete: ImageView


        init {
             image = view.findViewById<ImageView>(R.id.image_contact)
             delete = view.findViewById<ImageView>(R.id.delete)
             name = view.findViewById<TextView>(R.id.name_contact)
             phone = view.findViewById<TextView>(R.id.phone_contact)

        }

    }


    fun addItem(item: RowData){
        data.add(item)
        notifyDataSetChanged()
    }

    fun removeItem(pos: Int){
        data.removeAt(pos)
        notifyDataSetChanged()
       // notifyItemRemoved(pos)
    }
}
