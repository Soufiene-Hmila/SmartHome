package com.example.smarthome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.smarthome.R
import com.example.smarthome.databinding.ActivityMainBinding
import com.example.smarthome.ui.HomeActivity
import com.example.smarthome.utils.HomeAdapter
import com.example.smarthome.utils.SharePrefManager

class MainActivity : AppCompatActivity() {

    private lateinit var  name : String
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun continueToHome(view: View) {

        name = binding.textFieldName.text.toString().trim()

        if (name.isEmpty()){
            Toast.makeText(this, "You must set your name", Toast.LENGTH_SHORT).show()
        } else {

            SharePrefManager.getInstance(this).saveUser(name,true)
            startActivity(Intent(this@MainActivity, HomeActivity::class.java))
            finish()

        }
    }

    override fun onStart() {
        super.onStart()
        if(SharePrefManager.getInstance(this@MainActivity).isLoggedIn){
            startActivity(Intent(this@MainActivity, HomeActivity::class.java))
        }
    }
}