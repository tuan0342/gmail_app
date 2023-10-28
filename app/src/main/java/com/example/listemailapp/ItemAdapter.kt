package com.example.listemailapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ItemAdapter(val items: ArrayList<ItemModel>): BaseAdapter() {
    override fun getCount(): Int {
        return items.size;
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val itemView: View
        val viewHolder: ViewHolder

        if(convertView == null) {
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.email_item, parent, false)
            viewHolder = ViewHolder(itemView)
            itemView.tag = viewHolder
        } else {
            itemView = convertView
            viewHolder = itemView.tag as ViewHolder
        }

        viewHolder.title.text = items[position].title
        viewHolder.time.text = items[position].time
        viewHolder.body.text = items[position].body
        viewHolder.check.isChecked = items[position].selected

        viewHolder.check.setOnClickListener {
            items[position].selected = (it as CheckBox).isChecked
            notifyDataSetChanged()
        }

        return itemView
    }

    class ViewHolder(itemView: View) {
        val title: TextView
        val time: TextView
        val body: TextView
        val check: CheckBox
        init {
            title = itemView.findViewById(R.id.title)
            time = itemView.findViewById(R.id.time)
            body = itemView.findViewById(R.id.body)
            check = itemView.findViewById(R.id.checkBox)
        }
    }

}