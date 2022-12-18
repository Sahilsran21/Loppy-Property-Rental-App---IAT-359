package com.example.loppy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.create_a_listing_page.*
import org.w3c.dom.Text

class CreateListingPage : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
     super.onCreate(savedInstanceState)
        setContentView(R.layout.create_a_listing_page)


        //Activity Elements
        val propertyNameUserInput = findViewById<TextView>(R.id.propertyNameUserInput)
        val addressUserInput = findViewById<TextView>(R.id.addressUserInput)
        val postalCodeUserInput = findViewById<TextView>(R.id.postalCodeUserInput)
        val propertyDescriptionUserInput = findViewById<TextView>(R.id.propertyDescriptionUserInput)
        val emailUserInput = findViewById<TextView>(R.id.emailUserInput)
        val phoneNumberUserInput = findViewById<TextView>(R.id.phoneNumberUserInput)

        val finishListingButton = findViewById<ImageButton>(R.id.finishListingButton)

        val profileButtonListingPage = findViewById<ImageButton>(R.id.profileButtonListingPage)
        val homeButtonListingPage = findViewById<ImageButton>(R.id.homeButtonListingPage)




        finishListingButton.setOnClickListener {
            writeNewPropertyObject()                            //Creates the new property
            val intent = Intent(this,              //Sends us back to the map screen
                                 MainActivity::class.java)

            startActivity(intent)
        }



        homeButtonListingPage.setOnClickListener{               //Goes back to map screen
            val intent = Intent(this,
                                 MainActivity::class.java)

            startActivity(intent)
        }



        profileButtonListingPage.setOnClickListener{
            val intent = Intent(this,
                                 ProfilePage::class.java)

            startActivity(intent)
        }



    }




    private fun writeNewPropertyObject()
    {
        //Values we are writing into the new object
        val newPropertyName = propertyNameUserInput.toString()
        val newAddress = addressUserInput.toString()
        val newPostalCode = postalCodeUserInput.toString()
        val newPropertyDescription = propertyDescriptionUserInput.toString()
        val newEmail = emailUserInput.toString()
        val newPhoneNumber = phoneNumberUserInput.toString()
        val newBookingRate = bookingRateUserInput.toString()

        //Creating the new Object
        val newProperty = Property (newPropertyName, newAddress, newPostalCode, newPropertyDescription, newEmail, newPhoneNumber, newBookingRate)

        val completionListener =
            DatabaseReference.CompletionListener { err, ref ->
                if (err == null)
                {
                    Message("Object written successfully.")
                }
                else
                {
                    Message("Error Occurred")
                }
            }

        MainActivity.database.getReference("iat359firebasetest-default-rtdb")    //Location of where this object will be stored
            .setValue(newProperty, completionListener)          //Sets the object into the Database, connets to the listener to tell us if it was successfull
    }



    private fun Message (message: String)
    {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }



}