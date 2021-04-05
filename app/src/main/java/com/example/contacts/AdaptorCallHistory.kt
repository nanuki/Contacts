package com.example.contacts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptorCallHistory(val context: Context, val  data: List<RowDataHistoryCall>): RecyclerView.Adapter<AdaptorCallHistory.HolderCallHIstory> ()
{




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderCallHIstory {
        val view = LayoutInflater.from(context).inflate(R.layout.call_history,parent,false)
        return HolderCallHIstory(view)
    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(holder: HolderCallHIstory, position: Int) {
        val currentdata = data[position]
        holder.phonenumber.text = currentdata.phonenumber
        holder.time.text = currentdata.time
        holder.description.text = currentdata.description
    }



    class HolderCallHIstory(view: View): RecyclerView.ViewHolder(view)
    {
        val phonenumber: TextView
        val time: TextView
        val description: TextView

        init {
            phonenumber = view.findViewById<TextView>(R.id.call_number)
            time = view.findViewById<TextView>(R.id.call_time)
            description = view.findViewById<TextView>(R.id.in_out)

        }
    }

    }