package com.example.loppy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.example.loppy.MainActivity.Companion.PASSWORD
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.create_a_listing_page.*
import kotlinx.android.synthetic.main.firebasetest.*

class MainActivity : AppCompatActivity(), OnMapReadyCallback
{

    companion object
    {
        lateinit var auth: FirebaseAuth

        const val EMAIL = "359group2@sfu.ca"
        const val USERNAME = "Group Two"  //put user input in these ones
        const val PASSWORD = "LoppyPass1234@"

        val database = Firebase.database
    }


    lateinit var myMap:GoogleMap

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        auth = FirebaseAuth.getInstance()






        //Activity Elements
        var profileButtonHomePage = findViewById<ImageButton>(R.id.profileButtonHomePage)
        var homeButtonHomePage = findViewById<ImageButton>(R.id.homeButtonHomePage)
        var button = findViewById<Button>(R.id.button)







        val mapFragment = supportFragmentManager            //Initialize the Map Fragment
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        button.setOnClickListener{
//            var latLng = LatLng(49.1867659,-122.8515055)

//            val markerOptions:MarkerOptions =
//                MarkerOptions().position(latLng).title("SFU Surrey")
//
//            myMap.addMarker(markerOptions)
//
//            myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,16.0f))
            val start = LatLng(49.2606087,-123.2481825)
//            val apt1 = LatLng(49.2537563,-123.2368733)
//            var apt2 = LatLng(49.2650519,-123.2384833)
//            var apt3 = LatLng(49.2601874,-123.1438958)
//            var apt4 = LatLng(49.2632699,-123.1868057)
//            var apt5 = LatLng(49.2631888,-123.1868029)
//            var apt6 = LatLng(49.2652019,-123.2380042)
//            var apt7 = LatLng(49.2656324,-123.2398511)
//            var apt8 = LatLng(49.2652019,-123.2380042)
//            var apt9 = LatLng(49.2620025,-123.2113959)
//            var apt10 = LatLng(49.2565295,-123.1987487)
//            var apt11 = LatLng(49.2299111,-123.2052242)
//            var apt12 = LatLng(49.2354617,-123.1812468)
//            var apt13 = LatLng(49.2412166,-123.1881924)
//            var apt14 = LatLng(49.2573013,-123.1978916)
//            var apt15 = LatLng(49.2555675,-123.1840221)
            val markerOptions:MarkerOptions =
                MarkerOptions().position(start).title("Begin at UBC")
//                MarkerOptions().position(apt1).title("UBC Campus 1 Bedroom/1 Bath Semi Furnished Apartment")
////            MarkerOptions().position(apt2).title("Brand New UBC 2 Bed/2 Bath Condo In The Campus")
//            MarkerOptions().position(apt3).title("Blue Crest Apartments - 2 Bed/2 Bath Studio Suite")
//            MarkerOptions().position(apt4).title("Kitsilano Furnished Private Room w/Utilities on 1st Floor, 1 Bed/1 Bath, Near Public Transit")
//            MarkerOptions().position(apt5).title("Private Furnished Room w/ Utilities +WiFi @Kitsilano, Near Buses")
//            MarkerOptions().position(apt6).title("2 bedroom, 2 bathroom unit on the 13th floor with views!")
//            MarkerOptions().position(apt7).title("Lelem Village highrise apartment with 3 bedroom - 2 bath")
//            MarkerOptions().position(apt8).title("Cedar Walk single bed/bath apartment \n")
//            MarkerOptions().position(apt9).title("Single bed/half bath apartment at West Point Grey")
//            MarkerOptions().position(apt10).title("Single bed/bath laneway house")
//            MarkerOptions().position(apt11).title("Single bed/bath basement Suite for individuals")
//            MarkerOptions().position(apt12).title("2nd Floor single bed/bath suite in suburban house")
//            MarkerOptions().position(apt13).title("Luxurious 2 bed/2 bath household on West 34th Avenue")
//            MarkerOptions().position(apt14).title("Single bed/bath laneway house on West 17th Ave")
//            MarkerOptions().position(apt15).title("Single bed/bath basement suite in Dunbar Neighborhood")



//            myMap.addMarker(markerOptions)
            myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(start,12f))

//            val markerOptions1:MarkerOptions =
//                MarkerOptions().position(apt2).title("Brand New UBC 2 Bed/2 Bath Condo In The Campus")
//            myMap.addMarker(
//                markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
//            )
//            myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(apt2,13f))


        }








        homeButtonHomePage.setOnClickListener()       //*Normally non-functional on current main activity, but used strictly for testing purposes
        {
            val Intent = Intent(this,
                                 RoomPage::class.java)

            startActivity(Intent)
        }



        profileButtonHomePage.setOnClickListener()      //Going straight to profile page
        {
            val Intent = Intent(this,
                                 ProfilePage::class.java)

            startActivity(Intent)
        }

    }


    override fun onMapReady(gMap: GoogleMap)
    {
        myMap = gMap  //Assign myMap to Google Maps

        val m1: Marker? = myMap.addMarker(
            MarkerOptions()
                .position(LatLng(49.2606087,-123.2481825))
                .anchor(0.5f, 0.5f)
                .title("Begin at UBC")
                .snippet("The Campus")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
        )
        val start = LatLng(49.2573013,-123.1978916)
        val markerOptions:MarkerOptions =
            MarkerOptions().position(start)
//        myMap.addMarker(markerOptions)
        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(start,15f))


        val m2: Marker? = myMap.addMarker(
            MarkerOptions()
                .position(LatLng(49.2537563,-123.2368733))
                .anchor(0.5f, 0.5f)
                .title("UBC Campus 1 Bedroom/1 Bath Semi Furnished Apartment")
                .snippet("$2200/Month")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
        )

        val m3: Marker? = myMap.addMarker(
            MarkerOptions()
                .position(LatLng(49.2650519,-123.2384833))
                .anchor(0.5f, 0.5f)
                .title("Brand New UBC 2 Bed/2 Bath Condo In The Campus")
                .snippet("$3700/month")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
        )

        val m4: Marker? = myMap.addMarker(
            MarkerOptions()
                .position(LatLng(49.2601874,-123.1438958))
                .anchor(0.5f, 0.5f)
                .title("Blue Crest Apartments - 2 Bed/2 Bath Studio Suite")
                .snippet("$2300/Month")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
        )


        val m5: Marker? = myMap.addMarker(
            MarkerOptions()
                .position(LatLng(49.2632699,-123.1868057))
                .anchor(0.5f, 0.5f)
                .title("Kitsilano Furnished Private Room w/Utilities on 1st Floor, 1 Bed/1 Bath, Near Public Transit ")
                .snippet("$1190/Month")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
        )

        val m6: Marker? = myMap.addMarker(
            MarkerOptions()
                .position(LatLng(49.2631888,-123.1868029))
                .anchor(0.5f, 0.5f)
                .title("Private Furnished Room w/ Utilities +WiFi @Kitsilano, Near Buses")
                .snippet("$940/Month")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
        )
        val m7: Marker? = myMap.addMarker(
            MarkerOptions()
                .position(LatLng(49.2652019,-123.2380042))
                .anchor(0.5f, 0.5f)
                .title("2 bedroom, 2 bathroom unit on the 13th floor with views!")
                .snippet("$3500/Month")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
        )


        val m8: Marker? = myMap.addMarker(
            MarkerOptions()
                .position(LatLng(49.2656324,-123.2398511))
                .anchor(0.5f, 0.5f)
                .title("Lelem Village highrise apartment with 3 bedroom - 2 bath")
                .snippet("$3575/Month")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
        )

        val m9: Marker? = myMap.addMarker(
            MarkerOptions()
                .position(LatLng(49.2652021,-123.2380048))
                .anchor(0.5f, 0.5f)
                .title("Cedar Walk single bed/bath apartment ")
                .snippet("$2650/Month")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
        )
        val m10: Marker? = myMap.addMarker(
            MarkerOptions()
                .position(LatLng(49.2620025,-123.2113959))
                .anchor(0.5f, 0.5f)
                .title("Single bed/half bath apartment at West Point Grey")
                .snippet("$2500/Month")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
        )


        val m11: Marker? = myMap.addMarker(
            MarkerOptions()
                .position(LatLng(49.2565295,-123.1987487))
                .anchor(0.5f, 0.5f)
                .title("Single bed/bath laneway house")
                .snippet("$2200/Month")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
        )

        val m12: Marker? = myMap.addMarker(
            MarkerOptions()
                .position(LatLng(49.2299111,-123.2052242))
                .anchor(0.5f, 0.5f)
                .title("Single bed/bath basement Suite for individuals")
                .snippet("$1600/Month")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
        )
        val m13: Marker? = myMap.addMarker(
            MarkerOptions()
                .position(LatLng(49.2354617,-123.1812468))
                .anchor(0.5f, 0.5f)
                .title("2nd Floor single bed/bath suite in suburban house")
                .snippet("$2380/Month")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
        )


        val m14: Marker? = myMap.addMarker(
            MarkerOptions()
                .position(LatLng(49.2412166,-123.1881924))
                .anchor(0.5f, 0.5f)
                .title("Luxurious 2 bed/2 bath household on West 34th Avenue")
                .snippet("$2600/Month")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
        )

        val m15: Marker? = myMap.addMarker(
            MarkerOptions()
                .position(LatLng(49.2573013,-123.1978916))
                .anchor(0.5f, 0.5f)
                .title("Single bed/bath laneway house on West 17th Ave")
                .snippet("$2000/Month")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
        )
        val m16: Marker? = myMap.addMarker(
            MarkerOptions()
                .position(LatLng(49.2555675,-123.1840221))
                .anchor(0.5f, 0.5f)
                .title("Single bed/bath basement suite in Dunbar Neighborhood")
                .snippet("$1750/Month")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
        )





    }












private fun readPropertyObjects(){

    val myUid = MainActivity.auth.currentUser!!.uid

    val myListener = object : ValueEventListener
    {
        override fun onDataChange(mySnapshot: DataSnapshot) {

            Log.d("TAG", mySnapshot.value.toString())

            val readValue = mySnapshot.value as Map<String,Any>//the error

            val property_name: Any? = readValue["Property Name"]
            val house_address: Any? = readValue["Address"]
            val postal_code: Any? = readValue["Postal Code"]
            val e_mail: Any? = readValue["Email"]
            val property_description: Any? = readValue["Property Description"]
            val phone_number: Any? = readValue["Phone Number"]
            val booking_rate: Any?= readValue["Booking Rate"]

            val fetchedUser = Property(property_name.toString() ,house_address.toString(), postal_code.toString()
                , booking_rate.toString(), e_mail.toString(), property_description.toString(), phone_number.toString() )

            Message("We found ${fetchedUser.booking_rate}")
        }

        override fun onCancelled(p0: DatabaseError) {

        }

    }

    MainActivity.database.reference.child("Property 1").child(myUid)
        .addListenerForSingleValueEvent(myListener)
}


private fun registerFB(){
    MainActivity.auth.createUserWithEmailAndPassword(MainActivity.EMAIL, PASSWORD)
        .addOnCompleteListener(this) {task ->
            if(task.isSuccessful){

                val profileUpdates = UserProfileChangeRequest.Builder()
                    .setDisplayName(USERNAME).build()
                MainActivity.auth.currentUser!!.updateProfile(profileUpdates)

                Message("Registeration Succeeded")
            }
            else{
                Message("Registeration Failed")

                Log.i("TAG",task.exception.toString())
            }
        }
}


private fun loginFB(){
    MainActivity.auth.signInWithEmailAndPassword(MainActivity.EMAIL, PASSWORD)
        .addOnCompleteListener(this){ task ->
            if(task.isSuccessful)
            {
                val userName = MainActivity.auth.currentUser!!.displayName
                Message("Welcome back $userName")
            }
            else
            {
                Message("Login Failed")
                Log.i("TAG",task.exception.toString())
            }
        }
}


fun MainActivity.Message (message: String)
{
    Toast.makeText(this,message, Toast.LENGTH_LONG).show()
}

}

