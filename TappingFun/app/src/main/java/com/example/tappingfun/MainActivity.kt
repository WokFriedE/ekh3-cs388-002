package com.example.tappingfun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addBtn = findViewById<Button>(R.id.incButton)
        val textView = findViewById<TextView>(R.id.counterText)
        val upgradeBtn = findViewById<Button>(R.id.upgradeBtn)
        var counter = 0
        var increment = 1

        addBtn.setOnClickListener(){
            counter +=increment
            textView.text= counter.toString()

            if (counter >= 100*increment ){
                upgradeBtn.visibility = View.VISIBLE
            }

        }

        upgradeBtn.setOnClickListener(){
            increment+=1
            addBtn.text= "Add $increment"
            upgradeBtn.visibility=View.INVISIBLE
            upgradeBtn.text="Upgrade to Add " + (increment+1).toString()
        }
    }
}