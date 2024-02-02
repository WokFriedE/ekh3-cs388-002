package com.example.codepathmail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var emails: List<Email>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val recycler = findViewById<RecyclerView>(R.id.emailsRv)
        // Fetch the list of emails
        var emails = EmailFetcher.getEmails()
        // Create adapter passing in the list of emails
        val adapter = EmailAdapter(emails)
        // Attach the adapter to the RecyclerView to populate items
        recycler.adapter = adapter
        // Set layout manager to position the items
        recycler.layoutManager = LinearLayoutManager(this)

        val loadBtn = findViewById<Button>(R.id.loadMoreBtn)

        loadBtn.setOnClickListener(){
            val newEmails = EmailFetcher.getNext5Emails()
            emails.addAll(newEmails)
            adapter.notifyDataSetChanged()
        }
    }
}