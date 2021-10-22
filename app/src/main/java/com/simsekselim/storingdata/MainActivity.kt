package com.simsekselim.storingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.prefs.AbstractPreferences

val text = "Saved!"
val text2 = "Deleted!"
val duration = Toast.LENGTH_SHORT

lateinit var sharedPreferences: SharedPreferences
var ageFromPreferences : Int? = null
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()

        sharedPreferences = this.getSharedPreferences("com.simsekselim.storingdata", Context.MODE_PRIVATE)

        ageFromPreferences = sharedPreferences.getInt("age",-1)
        if(ageFromPreferences == -1){

            textView.text = "Your Age:"

        }else{

            textView.text = "Your Age: $ageFromPreferences"

        }




    }

    fun save(view : View){

        val myAge = editTextTextPersonName.text.toString().toIntOrNull()

        if(myAge != null){

            textView.text = "Your age:"+ " " +myAge
            sharedPreferences.edit().putInt("age",myAge).apply()




            Toast.makeText(applicationContext,text,duration).show()
        }


    }
    fun delete(view : View){

        ageFromPreferences = sharedPreferences.getInt("age",-1)

        if(ageFromPreferences != -1){
            sharedPreferences.edit().remove("age").apply()
            textView.text = "Your Age:"

            Toast.makeText(applicationContext, text2,duration).show()
        }


    }

}