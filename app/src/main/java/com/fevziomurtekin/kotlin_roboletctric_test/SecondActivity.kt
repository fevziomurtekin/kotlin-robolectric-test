package com.fevziomurtekin.kotlin_roboletctric_test

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.util.jar.Manifest

const val ACCES_LOCATION=1001

class SecondActivity:AppCompatActivity(){

    var isAcces :Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), ACCES_LOCATION)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode== ACCES_LOCATION && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            isAcces=true
    }

}