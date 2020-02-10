package com.example.firstgame

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_top3.*
import kotlinx.android.synthetic.main.content_main.*

class Top3 : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top3)

        //------------------------------------------------------------------------------------------

        btnBack.setOnClickListener {
            Log.d("random", "random button was selected")
            startActivity(Intent(this,  MainActivity::class.java))
        } // end roulette

        //------------------------------------------------------------------------------------------
    } // end on create




}