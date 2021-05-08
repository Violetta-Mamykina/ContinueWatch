package com.example.continuewatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isStop: Boolean = false
    private var STATE_KEY: String = "STATE_KEY"
    private var secondsElapsed: Int = 0
    var backgroundThread = Thread {
        while (true) {
            Thread.sleep(1000)
            if (!isStop) {
                textSecondsElapsed.post {
                    textSecondsElapsed.text = secondsElapsed++.toString()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        backgroundThread.start()
    }

    override fun onPause() {
        super.onPause()
        isStop = true
    }

    override fun onResume() {
        super.onResume()
        isStop = false
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(STATE_KEY, secondsElapsed)
    }

    public override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        secondsElapsed = savedInstanceState.getInt(STATE_KEY)
    }
}

