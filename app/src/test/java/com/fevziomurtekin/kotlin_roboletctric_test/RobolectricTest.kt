package com.fevziomurtekin.kotlin_roboletctric_test

import android.widget.Button
import android.widget.TextView
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)

class RobolectricTest{

    var activity:MainActivity?=null
    var secondary:SecondActivity?=null
    var textview:TextView?=null
    var button:Button?=null

    @Before
    fun init(){ /*Test activityimizi oluşturuduk.*/
        activity = Robolectric.setupActivity(MainActivity::class.java)
        textview = activity?.findViewById(R.id.text)
        button = activity?.findViewById(R.id.btnClick)
    }

    @Test
    fun checkActivity(){ /*activity nin null olup olmadığını kontrol ediyoruz.*/
        Assert.assertNotNull(activity)
    }

    @Test
    fun checkTextView(){
        Assert.assertNotNull(textview)
    }

    @Test
    fun checkButton(){
        Assert.assertNotNull(button)
    }

    @Test
    fun checkTextView_text(){ /*Textview içerisindeki yazıyı kontrol ediyoruz.*/
        val text = textview?.text.toString()
        Assert.assertThat(text, CoreMatchers.equalTo("Merhaba"))
    }


    @Test
    fun checkTextView_width(){ /*Textview genişliğini kontrol ediyoruz.*/
        val width=textview?.width
        Assert.assertTrue("Genişliği daha fazladır.", width!! >70)
    }

    @Test
    fun checkButtonClick_text(){ /*Buttona tıklandığında değişecek texti kontrol ediyoruz.*/
        button?.performClick()
        val text = textview?.text.toString()
        Assert.assertThat(text,CoreMatchers.equalTo("Text"))
    }

    @Test
    fun checkChangeActivity(){ //actiivity değişti mi diye kontrol ediyor.
        button?.performClick()
        secondary=Robolectric.setupActivity(SecondActivity::class.java)
        Assert.assertNotNull(secondary)
    }

    @Test
    fun checkAccesRequestPermission(){ //Location izni aldı mı diye kontrol edildi.
        if(secondary!=null)
            Assert.assertTrue(secondary!!.isAcces)
        else {
            button?.performClick()
            secondary=Robolectric.setupActivity(SecondActivity::class.java)
            Assert.assertTrue(secondary!!.isAcces)
        }
    }



}
