package com.example.firstgame

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_about_me.*


class AboutMe : AppCompatActivity(){

     private var roulNum: Int=7
    private var numClick: Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)



        btnBack.setOnClickListener {
            Log.d("list", "list button was pressed")
            startActivity(Intent(this, MainActivity::class.java))
        }

        btn_redo.setOnClickListener {
            numClick += 1

            Log.d("redo", "redo button was pressed")
            //  roulNum = 7
            //    roul.setImageResource(R.drawable.roul7)

            //val randomSeconds = (1000L..5000L).shuffled().first()
            var rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate)
            roul.startAnimation(rotateAnimation)

            if(numClick > 1) {


                val randRotate = (1..22).shuffled().last()


                when (randRotate) {

                    //     1 ->  rotateAnimation =  AnimationUtils.loadAnimation(this,R.anim.rotate)
                    2 -> rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate2)
                    3 -> rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate3)
                    4 -> rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate4)
                    5 -> rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate5)
                    6 -> rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate6)
                    7 -> rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate7)
                    8 -> rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate8)
                    9 -> rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate9)
                    10 -> rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate10)
                    11 -> rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate11)
                    12 -> rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate12)
                    13 -> rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate13)
                    14 -> rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate14)
                    15 -> rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate15)
                    16 -> rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate16)
                    17 -> rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate17)
                    18 -> rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate18)
                    19 -> rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate19)
                    20 -> rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate20)
                    21 -> rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate21)
                    22 -> rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate22)

                    else -> {
                        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate23)
                    }
                }
                roul.startAnimation(rotateAnimation)
                numClick=0
            }




           //  timer(randomSeconds.toLong(), countDownInterval).start()



          //  val handler = Handler()
        //    handler.postDelayed(randomSeconds.toLong(), {})

        //    var x =0
          //  while(x < randomDegrees) {

         //       x += 1
        //    }
          ///  roul.rotate(randomDegrees)
       //    RotateDra


/*
            rotateAnimation = RotateAnimation(0f, 359f, .50f, .50f )
            rotateAnimation.duration = 5000
            rotateAnimation.repeatCount = 0


            //Either way you can add Listener like this
            rotateAnimation.setAnimationListener(object : Animation.AnimationListener {

                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {

                  //  val rand = Random()
                 //   val ballHit = rand.nextInt(50) + 1
                   // Toast.makeText(context, "ballHit : " + ballHit, Toast.LENGTH_SHORT).show()
                }
            })

            roul.startAnimation(rotateAnimation)

*/
        }

        //--------------------------------------------------------------------

        btn_addRoul.setOnClickListener {
            Log.d("roul", "add button was pressed")
            roulNum += 1
            btn_delRoul.isVisible = true
            when (roulNum) {

                3 ->  roul.setImageResource(R.drawable.roul3)
                4 ->  roul.setImageResource(R.drawable.roul4)
                5 ->  roul.setImageResource(R.drawable.roul5)
                6 ->  roul.setImageResource(R.drawable.roul6)
                7 ->  roul.setImageResource(R.drawable.roul7)
                8 ->  roul.setImageResource(R.drawable.roul8)
                9 ->  roul.setImageResource(R.drawable.roul9)
                10 -> { roul.setImageResource(R.drawable.roul10)
                btn_addRoul.isVisible = false }
                else -> {
                    roulNum -= 1
                } // end else path
            } // end switch
        } // end add roul

        //--------------------------------------------------------------------

        btn_delRoul.setOnClickListener {
            Log.d("roul", "minus button was pressed")
            roulNum -= 1
            btn_addRoul.isVisible = true
            when (roulNum) {
                2 -> {  roul.setImageResource(R.drawable.roul2)
                    btn_delRoul.isVisible = false
                }
                3 ->  roul.setImageResource(R.drawable.roul3)
                4 ->  roul.setImageResource(R.drawable.roul4)
                5 ->  roul.setImageResource(R.drawable.roul5)
                6 ->  roul.setImageResource(R.drawable.roul6)
                7 ->  roul.setImageResource(R.drawable.roul7)
                8 ->  roul.setImageResource(R.drawable.roul8)
                9 ->  roul.setImageResource(R.drawable.roul9)
                else -> {
                    roulNum += 1
                } // end else path
            } // end switch
        } // end delRoul

        //--------------------------------------------------------------------



    }


}
