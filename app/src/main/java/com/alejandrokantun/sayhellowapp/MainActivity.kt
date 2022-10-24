package com.alejandrokantun.sayhellowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.alejandrokantun.sayhellowapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding//This code call the main layout into this kt code

    override fun onCreate(savedInstanceState: Bundle?) {
        //var etName:EditText = binding.edName

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShowName.setOnClickListener {
            checkValue(binding.edName.getText().toString())
        }

        //this is the old way, the trouble is when you have a huge layout, you have to add many dots

    }

    fun checkValue(editText:String){
        if(editText.isNotEmpty()){
            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("INTENT_NAME",editText)
            startActivity(intent) //startActivity con s minúscula

        }
        else{
            showErrorMessage()
        }

    }
    fun showErrorMessage(){
        val toast = Toast.makeText(this, "El nombre de usuario no puede ser vacío", Toast.LENGTH_LONG)
        toast.show()
    }


}