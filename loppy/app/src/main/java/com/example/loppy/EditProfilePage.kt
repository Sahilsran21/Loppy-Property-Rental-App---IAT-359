package com.example.loppy

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loppy.MainActivity.Companion.auth
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.android.synthetic.main.firebasetest.*
import kotlinx.android.synthetic.main.profile_page.*
import org.w3c.dom.Text

class EditProfilePage : AppCompatActivity()
{





    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_profile_page)

        //Activity Elements
        val usernameUserInput = findViewById<TextView>(R.id.usernameUserInput)
        val passwordUserInput = findViewById<TextView>(R.id.passwordUserInput)

        val saveButton = findViewById<ImageButton>(R.id.saveButton)

        val homeButtonEditProfilePage = findViewById<ImageButton>(R.id.homeButtonEditProfilePage)
        val profileButtonEditProfilePage = findViewById<ImageButton>(R.id.profileButtonEditProfilePage)


        val sharedPref = this.getPreferences(Context.MODE_PRIVATE)


        saveButton.setOnClickListener {

            //Save Preferences
                val newUserName = usernameUserInput.text.toString()
                with(sharedPref.edit()) {
                    putString("newUserName", newUserName)

                    commit()

            //Read Preferences
                val userName = sharedPref.getString("newUserName", "no name")
                name.text = userName

            }
        }


        homeButtonEditProfilePage.setOnClickListener {
            val intent = Intent(this,
                                 MainActivity::class.java)

            startActivity(intent)
        }


        profileButtonEditProfilePage.setOnClickListener {
            val intent = Intent(this,
                                 ProfilePage::class.java)

            startActivity(intent)
        }
    }


}