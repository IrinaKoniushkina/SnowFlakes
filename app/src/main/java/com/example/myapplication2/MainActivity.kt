package com.example.myapplication2

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication2.SnowFlakes

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // заменим разметку на нашу View
        //setContentView(R.layout.activity_main)
        setContentView(SnowFlakes(this))
    }
}