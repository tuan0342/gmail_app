package com.example.listemailapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = arrayListOf<ItemModel>()
        repeat(16) {
            val index = it + 1;
            items.add(
                ItemModel("Tuan Ngo", "Help make Campaign Monitor better Let us know your thought! No images..",
                "12:34 PM")
            )
        }

        findViewById<ListView>(R.id.list_view).adapter = ItemAdapter(items)
    }
}