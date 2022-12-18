package com.example.loppy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MyListingsPage : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_listings_page)


        //Activity Elements
        val homeButtonMyListingsPage = findViewById<ImageButton>(R.id.homeButtonMyListingsPage)
        val profileButtonMyListingsPage = findViewById<ImageButton>(R.id.profileButtonMyListingsPage)




        homeButtonMyListingsPage.setOnClickListener{
            val intent = Intent(this,
                                 MainActivity::class.java)

            startActivity(intent)
        }



        profileButtonMyListingsPage.setOnClickListener {
            val intent = Intent(this,
                                 ProfilePage::class.java)

            startActivity(intent)
        }


    }
}