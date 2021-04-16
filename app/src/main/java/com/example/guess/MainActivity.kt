package com.example.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatViewInflater
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    val secreNumber = SecreNumber()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity","secret:" + secreNumber.secret)
    }
    fun check(view:View){
        val n:Int = number.text.toString().toInt()
        println("number: $n")
        Log.d("MainActivity", "number:" + n)

        val diff:Int = secreNumber.validate(n)
        var message = "Yes, you got it"

        if(secreNumber.validate(n) < 0){
           // Toast.makeText(this, "Bigger", Toast.LENGTH_LONG).show()
            message = "Bigger"
        }else if(diff > 0){
           // Toast.makeText(this, "Smaller", Toast.LENGTH_LONG).show()
            message = "Smaller"
        }
        // Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
            .setTitle("Message")
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()

    }
}