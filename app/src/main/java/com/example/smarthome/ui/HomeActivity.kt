package com.example.smarthome.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthome.R
import com.example.smarthome.databinding.ActivityHomeBinding
import com.example.smarthome.databinding.ActivityMainBinding
import com.example.smarthome.utils.HomeAdapter
import com.example.smarthome.utils.RoomData
import com.example.smarthome.utils.SharePrefManager
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    private var dataList = listOf(

        RoomData(R.drawable.livingroom, "Living Room", "4 Devices"),
        RoomData(R.drawable.mediaroom, "Media Room", "6 Devices"),
        RoomData(R.drawable.bathroom, "Bathroom", "1 Devices"),
        RoomData(R.drawable.bedroom, "Bedroom", "3 Devices")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameUser = SharePrefManager.getInstance(this).nameUser
        val date: LocalDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy")
        val currentDate = date.format(formatter)

        binding.textViewDate.text = currentDate
        binding.textViewName.text = "Welcome,$nameUser!"
        homeAdapter = HomeAdapter(dataList)
        binding.listRoom.adapter = homeAdapter
        homeAdapter.notifyDataSetChanged()
    }
}