package com.example.contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val add = findViewById<ImageView>(R.id.addcontact)
        val recycler =  findViewById<RecyclerView>(R.id.recycler)
        val list = mutableListOf(RowData(R.drawable.ic_baseline_person_1,"Garik","5555555"),
            RowData(R.drawable.ic_baseline_person_2,"Arsen","6666666"),
            RowData(R.drawable.ic_baseline_person_3,"Vardan","7777777"),
            RowData(R.drawable.ic_baseline_person_4,"Aram","8888888"),
            RowData(R.drawable.ic_baseline_person_5,"Karen","9999999"),
            RowData(R.drawable.ic_baseline_person_6,"Vigen","1111111"),
            RowData(R.drawable.ic_baseline_person_1,"Arsen","3333333"),
            RowData(R.drawable.ic_baseline_person_2,"Vardan","4444444")
        )
        val customadapter = RecyclerAdapter(this,  list)
        recycler.adapter = customadapter
        recycler.layoutManager = LinearLayoutManager(this)
       // recycler.layoutManager?.scrollToPosition(2)



        add.setOnClickListener(View.OnClickListener {
            customadapter.addItem(RowData(R.drawable.ic_outline_person_24,"Valodia","2222222"))

        })

    }
}