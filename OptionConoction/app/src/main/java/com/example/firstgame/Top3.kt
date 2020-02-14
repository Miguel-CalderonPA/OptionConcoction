package com.example.firstgame

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_top3.*
import kotlinx.android.synthetic.main.activity_top3.btnBack
import java.io.File
// Constants
const val TIME: Long=1000
class Top3 : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top3)
        Log.d("Created", "top3 page was created")
        // set text boxes to invisible
        txtChoice1.isVisible=false
        txtChoice2.isVisible=false
        txtChoice3.isVisible=false

        //------------------------------------------------------------------------------------------

        Log.d("Reading...", "Attempt to read from files")
        // open file and/or create
        val path = applicationContext.getFilesDir()
        val letDirectory = File(path, "LET")
        letDirectory.mkdirs()
        val file = File(letDirectory, "test.txt")
        if(!file.exists()) {
            file.createNewFile()
        } // end if file exists

        // reads data from file then sends this to filetext
        val filetext: MutableList<String>  = file.bufferedReader().readLines().toMutableList()
        val numLocations = filetext.size
        val maxIndex = numLocations - 1 // index starts at 0

        var isDupe =false // set flag for later
        if (numLocations > 2) {     // if at least 3
            do {
                // get 3 random values
                val randRotate = (0..maxIndex).shuffled().last()
                val randRotate2 = (0..maxIndex).shuffled().last()
                val randRotate3 = (0..maxIndex).shuffled().last()

                // if any two are the same we want to refresh, we only want 3 unique items
                if (randRotate == randRotate2 || randRotate == randRotate3 || randRotate2 == randRotate3){
                    isDupe = true // continue loop
                }
                else {
                    // if 3 unique than set them
                    txtChoice1.text  = filetext[randRotate]
                    txtChoice2.text  = filetext[randRotate2]
                    txtChoice3.text  = filetext[randRotate3]
                    isDupe = false // end loop
                }

            }while (isDupe)
        } // end if at least 3
        else if (numLocations == 2) {
            txtChoice1.text  = filetext[numLocations-2]
            txtChoice2.text  = filetext[numLocations-1]
        } // end if 2
        else if (numLocations == 1) {
            txtChoice1.text  = filetext[numLocations - 1]
        } // end if 1
        else {
            // if no values in list let user know
            Toast.makeText(applicationContext, "Empty List, PLEASE ADD VALUES TO 'List'", Toast.LENGTH_LONG).show()
        } // end if empty
        //------------------------------------------------------------------------------------------

        Log.d("goTop3", "btnTop3 button was pressed")
        val fadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.fadeout)
        imgTop3.startAnimation(fadeOutAnimation)
        Handler().postDelayed({imgTop3.visibility = View.GONE}, TIME)
        Handler().postDelayed({txtChoice1.visibility = View.VISIBLE}, TIME)
        Handler().postDelayed({txtChoice2.visibility = View.VISIBLE}, TIME)
        Handler().postDelayed({txtChoice3.visibility = View.VISIBLE}, TIME)

        //------------------------------------------------------------------------------------------

        btnBack.setOnClickListener {
            Log.d("random", "random button was selected")
            startActivity(Intent(this,  MainActivity::class.java))
        } // end top 3



    } // end on create




}