package com.example.loppy

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class ProfilePage : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_page)


        //Activity Elements
        val name = findViewById<TextView>(R.id.name)

        val editProfileButton = findViewById<ImageButton>(R.id.editProfileButton)
        val createListingButton = findViewById<ImageButton>(R.id.createListingButton)
        val myListingsButton = findViewById<ImageButton>(R.id.myListingsButton)

        val homeButtonProfilePage = findViewById<ImageButton>(R.id.homeButtonProfilePage)
        val profileButtonProfilePage = findViewById<ImageButton>(R.id.profileButtonProfilePage)

        val testButton = findViewById<Button>(R.id.fbtest)


        testButton.setOnClickListener {
            val intent = Intent(this,
                         MainActivity::class.java)

            startActivity(intent)
        }


        editProfileButton.setOnClickListener {
            val intent = Intent(this,
                         EditProfilePage::class.java)

            startActivity(intent)
        }



        createListingButton.setOnClickListener {
            val intent = Intent(this,
                                 CreateListingPage::class.java)

            startActivity(intent)
        }



        myListingsButton.setOnClickListener {
            val intent = Intent(this,
                                MyListingsPage::class.java)

            startActivity(intent)
        }









        homeButtonProfilePage.setOnClickListener {
            val intent = Intent(this,
                                 MainActivity::class.java)

            startActivity(intent)
        }


        profileButtonProfilePage.setOnClickListener {
            val intent = Intent(this,
                                 ProfilePage::class.java)

            startActivity(intent)
        }







    }
}

