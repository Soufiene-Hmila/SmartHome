package com.example.smarthome.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smarthome.R

class HomeAdapter (private var dataList: List<RoomData>):
    RecyclerView.Adapter<HomeAdapter.RoomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        return RoomViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        )
    }


    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {

        val model = dataList[position]

        holder.room.text = model.nDevices
        holder.roomType.text = model.typeRoom
        holder.image.setImageResource(model.image)

    }

    class RoomViewHolder(itemViewHolder: View) : RecyclerView.ViewHolder(itemViewHolder) {

        var image = itemViewHolder.findViewById<ImageView>(R.id.imageViewRoom)!!
        var roomType = itemViewHolder.findViewById<TextView>(R.id.textViewTypeRoom)!!
        var room = itemViewHolder.findViewById<TextView>(R.id.textViewRoom)!!
    }
}