package com.jiaopeng.motionlayout2use

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart?.setOnClickListener {
            motionLayout?.transitionToEnd()
        }

        motionLayout?.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                Log.e("TAG", "Completed: ")
                val v = button?.text
                button?.text = button1?.text
                button1?.text = v
                val i = button?.id!!
                button?.id = button1?.id!!
                button1?.id = i
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                Log.e("TAG", "Started: ")
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                Log.e("TAG", "Change: ")
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
                Log.e("TAG", "Trigger: ")
            }
        })

        btnEnd?.setOnClickListener {
            motionLayout?.transitionToStart()
        }

        btnText?.setOnClickListener {
            Log.e("TAG", "Text = ${button.text} == ${button1.text}")
        }

        button?.setOnClickListener {
            Toast.makeText(this, "前面的", Toast.LENGTH_SHORT).show()
        }

        button1?.setOnClickListener {
            Toast.makeText(this, "后面的", Toast.LENGTH_SHORT).show()
        }
    }
}