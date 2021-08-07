package com.example.countdown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val startTime:Long = 50 * 1000
    private val interval:Long = 1 * 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_CountDown)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtTimer = findViewById<TextView>(R.id.txt_timer)
        val txtTimeElapsed = findViewById<TextView>(R.id.txt_time_elapsed)
        val resetBtn = findViewById<Button>(R.id.btn_reset)

        val countDownTimer = object : CountDownTimer(startTime, interval) {

            override fun onTick(millisUntilFinished: Long) {
                txtTimer.text = "Time: ${(millisUntilFinished + 1000)/1000}"
                txtTimeElapsed.text = "Time elapsed: ${(startTime - millisUntilFinished)/1000}"
            }

            override fun onFinish() {
                txtTimer.text = "TIMER FINISHED"
            }
        }.start()

        resetBtn.setOnClickListener{
            countDownTimer.cancel()
            Toast.makeText(this,"Timer reset",Toast.LENGTH_SHORT).show()
            countDownTimer.start()
        }

    }
}