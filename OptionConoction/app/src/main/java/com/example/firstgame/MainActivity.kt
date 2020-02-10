package com.example.firstgame

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //------------------------------------------------------------------------------------------

        btn_toRoul.setOnClickListener {
           d("random", "random button was selected")
            startActivity(Intent(this, AboutMe::class.java))
        } // end roulette

        //------------------------------------------------------------------------------------------

        btn_toTop3.setOnClickListener {
            d("top3", "top3 button was selected")
            startActivity(Intent(this, Top3::class.java))
        } // end top3

        //------------------------------------------------------------------------------------------

        btn_GoToList.setOnClickListener {
            d("top3", "top3 button was selected")
            startActivity(Intent(this, List_Options::class.java))
        } // end go to list

        //------------------------------------------------------------------------------------------
    } // end on create
} // end activity