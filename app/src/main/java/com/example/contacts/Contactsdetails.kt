package com.example.contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Contactsdetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactsdetails)
        val name = findViewById<TextView>(R.id. name_details)
        val phone = findViewById<TextView>(R.id. phone_details)
        val image= findViewById<ImageView>(R.id. image_details)
        val delete= findViewById<ImageView>(R.id. removecontact)
        val intent: Intent = getIntent()
        val getphone = intent.getStringExtra("phone")
        val getname = intent.getStringExtra("name")
        val getimage = intent.getIntExtra("image", -1)
        val position = intent.getIntExtra("position", -1)
        name.text = getname
        phone.text = getphone
        image.setImageResource(getimage )

        val recycler_history = findViewById<RecyclerView>(R.id.recycler_history)
        val list_history = listOf(
            RowDataHistoryCall(getphone, "10:15", "Outgoing"),
            RowDataHistoryCall(getphone, "10:18", "Incoming"),
            RowDataHistoryCall(getphone, "10:15", "Outgoing"),
            RowDataHistoryCall(getphone, "10:18", "Incoming")
        )
        val customadapter = AdaptorCallHistory(this,  list_history)
        recycler_history.adapter = customadapter
        recycler_history.layoutManager = LinearLayoutManager(this)
        
        delete.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
//            intent.putExtra("remove", true)
//            intent.putExtra("position", position)
            startActivity(intent)
        })
    }
}