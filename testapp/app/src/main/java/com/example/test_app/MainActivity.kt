package com.example.test_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtV = findViewById<TextView>(R.id.textV)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val imgView = findViewById<ImageView>(R.id.imageView)

        // get array from values
        val superheroes = resources.getStringArray(R.array.superhero_names)
        //make a list of the images
        val  heroNames = arrayOf(R.drawable.black_panther,R.drawable.ironman,R.drawable.captain_america,R.drawable.ms_marvel,R.drawable.thor)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // position gives the array index selected
                val selectedItem = superheroes[position] //looks at the array --> since the spinner is based off of it
                Toast.makeText(this@MainActivity, "Selected item: $selectedItem", Toast.LENGTH_SHORT).show()
                imgView.setImageResource(heroNames[position]) //change the image source
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
// Do nothing --> when nothing is selected
            }
        }

        // if there are a lot of items in each definition, a class would be better
        // adaptars are important to go between activities and data

    }
}