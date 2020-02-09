package com.example.firstgame

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list_options.*
import kotlinx.android.synthetic.main.list_row.*
import java.io.File
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener

class List_Options : AppCompatActivity() {
    // GLOBALS
    val FILE = "locations.txt"
    // on Create
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_options)

        // Set variables
        val listview = findViewById<ListView>(R.id.main_listview)
        val  newColor = Color.parseColor("#FFFF00")
        listview.setBackgroundColor(newColor)



        //------------------------------------------------------------------------------------------


        btn_addR.setOnClickListener {

            var newRestaurant: String = txt_NewR.text.toString()

            if(newRestaurant.trim().isEmpty()) {
                Log.d("Add Clicked", "new restaurant to added")
                // outputs to user on screen
                Toast.makeText(applicationContext, "Empty entry, LIST NOT UPDATED", Toast.LENGTH_SHORT).show()
            } // end if
            else {
                // change visuals
                txt_NewR.text.clear()
                newRestaurant = newRestaurant + "\n"

                // Logs and does File I/O
                Log.d("not empty", "write to file")
                val path = applicationContext.getFilesDir()
                val letDirectory = File(path, "LET")
                letDirectory.mkdirs()
                val file = File(letDirectory, "test.txt")

                file.appendText(newRestaurant)

                val filetext: MutableList<String>  = file.bufferedReader().readLines().toMutableList()
                println("Adding size: ${filetext.size}")
                //  my custom adapter telling my list what to restaurants show
                listview.adapter = MyAdapter(this, filetext)


                for (line in filetext) {
                    println("$line" )
                    val pos = filetext.indexOf(line)
                    println("$pos")
                }
                finish();
                overridePendingTransition(0, 0)
                startActivity(intent)
                overridePendingTransition(0, 0)
            } // end else
        } // end button add restaurant

        //------------------------------------------------------------------------------------------



        //------------------------------------------------------------------------------------------

        Log.d("Created", "List page was created")

        val path = applicationContext.getFilesDir()
        val letDirectory = File(path, "LET")
        letDirectory.mkdirs()
        val file = File(letDirectory, "test.txt")
        if(!file.exists()) {
            file.createNewFile()
        }

       // file.delete()
        val filetext: MutableList<String>  = file.bufferedReader().readLines().toMutableList()
        println("Intial size: ${filetext.size}")
        listview.adapter = MyAdapter(this, filetext)  //  my custom adapter telling my list what to restaurants show
        val listView:ListView = findViewById(R.id.main_listview)


       // val listEdit:ListView = findViewById(R.id.main_listview)
       // listEdit.adapter = listview.adapter
        listview.onItemClickListener = object : AdapterView.OnItemClickListener {

            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long ) {
                Log.d("del", "write to file")

                println(position)
                val itemName = listview.getItemAtPosition(position)
                Toast.makeText(applicationContext,
                    "Item Value : $itemName has been removed", Toast.LENGTH_LONG)
                    .show()

            //    val filetext: MutableList<String>  = file.bufferedReader().readLines().toMutableList()

                Log.d("not empty", "write to file")
                val path = applicationContext.getFilesDir()
                val letDirectory = File(path, "LET")
                letDirectory.mkdirs()
                val file = File(letDirectory, "test.txt")
                filetext.removeAt(position)
                file.delete()
                file.createNewFile()
                var restaurant=""
                for (line in filetext) {
                    restaurant = line + "\n"
                    file.appendText(restaurant)
                }


                val filetext: MutableList<String>  = file.bufferedReader().readLines().toMutableList()
                println("Del Size: ${filetext.size}")
                //  my custom adapter telling my list what to restaurants show
                listview.adapter = MyAdapter(this@List_Options, filetext)
              //  finish()
               // startActivity(intent)
            }



        }

    } // end oncreate

    //------------------------------------------------------------------------------------------

     private class MyAdapter(context: Context, theData: MutableList<String>): BaseAdapter() {

        // PDMs
        private val myContext: Context
        private var locations = theData

        //------------------------------------------------------------------------------------------

        init{
            this.myContext = context
        } // end init

        //------------------------------------------------------------------------------------------


        // creates each row
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val inflator = LayoutInflater.from(myContext)
            val listRow = inflator.inflate(R.layout.list_row, viewGroup, false)

            val textViewIndex = listRow.findViewById<TextView>(R.id.txtvindex)
            val roulettePos = (position % 10) + 1
            textViewIndex.text = "ROULETTE # $roulettePos"

            val textViewNames = listRow.findViewById<TextView>(R.id.txtvlocation)
            textViewNames.text = locations.get(position)

            return listRow
        } // end getView



        //------------------------------------------------------------------------------------------

        // needed because of ABC class
        override fun getItem(position: Int): Any {
            return locations[position]
        }

        //------------------------------------------------------------------------------------------

        // needed because of ABC class
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        //------------------------------------------------------------------------------------------

        // rows in list
        override fun getCount(): Int {
            return locations.size
        }


         override fun notifyDataSetChanged() {
             super.notifyDataSetChanged()
         }
        //------------------------------------------------------------------------------------------
    } // end adapter class
} // end list options class