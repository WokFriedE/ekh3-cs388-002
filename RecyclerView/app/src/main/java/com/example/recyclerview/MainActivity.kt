package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
// this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)
// ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()
        val heroNames = resources.getStringArray(R.array.superheroes)
        val heroImgs = arrayOf(R.drawable.captain_america, R.drawable.spiderman,
            R.drawable.ms_marvel, R.drawable.black_panther, R.drawable.ironman,
            R.drawable.thor)
// This loop will create 6 Views containing
// the image with the count of view
        for (i in 0..5){
            data.add(ItemsViewModel(heroImgs[i], heroNames[i]))
        }
// This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)
// Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
    }
}

}