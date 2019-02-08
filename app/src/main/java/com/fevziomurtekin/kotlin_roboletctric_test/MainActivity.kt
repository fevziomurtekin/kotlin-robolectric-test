package com.fevziomurtekin.kotlin_roboletctric_test

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnClick.setOnClickListener(this::changeText)
    }


    fun changeText(view:View){
        text.text="Text"
        startActivity(Intent(this,SecondActivity::class.java))
    }

}
