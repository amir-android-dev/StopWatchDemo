package com.amir.stopwatchdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amir.stopwatchdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isStarted = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            startOrStop()
        }
        binding.btnReset.setOnClickListener {
            reset()
        }

    }

    private fun startOrStop() {
        if (isStarted) {
            stop()
        } else {
            start()
        }
    }

    private fun start() {
        binding.btnStart.text = "STOP"
        isStarted = true
    }

    private fun stop() {
        binding.btnStart.text = "START"
        isStarted = false
    }

    private fun reset() {

    }
}