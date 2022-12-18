package com.example.loppy

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.google.android.material.internal.ContextUtils.getActivity

class RoomPage : AppCompatActivity()
{
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.room_page)


        //Activity Elements
        val emailButton = findViewById<ImageButton>(R.id.emailButton)
        val phoneButton = findViewById<ImageButton>(R.id.phoneButton)
        val bookButton = findViewById<ImageButton>(R.id.bookButton)

        val homeButtonRoomPage = findViewById<ImageButton>(R.id.homeButtonRoomPage)
        val profileButtonRoomPage = findViewById<ImageButton>(R.id.profileButtonRoomPage)



                //Asks user to send them to the email app on their phone. with the respective email address
        emailButton.setOnClickListener {
            val intent = Intent (Intent.ACTION_SEND)   //Sends multitude of things (email message, text)
            intent.type = "plain/text"
            startActivity(intent)
        }



                //Sends user to the phone app on their phone, with the respective phone number
        phoneButton.setOnClickListener {
            val intent = Intent (Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:123456789")   //Input Phone Number for User
            startActivity(intent)
        }



        bookButton.setOnClickListener {
            val intent = Intent (this,
                                  MainActivity::class.java)

            Toast.makeText(getActivity(this),
                        "You are now booked for this listing!",
                            Toast.LENGTH_LONG).show()

            startActivity(intent)
        }



        homeButtonRoomPage.setOnClickListener {
            val intent = Intent(this,
                                 MainActivity::class.java)

            startActivity(intent)
        }



        profileButtonRoomPage.setOnClickListener {
            val intent = Intent(this,
                                 ProfilePage::class.java)

            startActivity(intent)
        }








    }
}