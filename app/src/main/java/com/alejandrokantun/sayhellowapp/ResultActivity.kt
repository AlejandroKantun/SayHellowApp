package com.alejandrokantun.sayhellowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.alejandrokantun.sayhellowapp.databinding.ActivityMainBinding
import com.alejandrokantun.sayhellowapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding//This code call the main layout into this kt code

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        val name = getName()
        binding.tvGreeting.text="Bienvenido $name"

    }

    fun getName():String{
        val bundle =intent.extras
        val name=  bundle?.get("INTENT_NAME").toString()
        val toast = Toast.makeText(this, "El nombre es $name", Toast.LENGTH_LONG)
        toast.show()
        return name.toString()
    }
}