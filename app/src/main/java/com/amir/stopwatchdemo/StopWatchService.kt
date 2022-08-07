package com.amir.stopwatchdemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import java.util.*


class StopWatchService : Service() {

    override fun onBind(intent: Intent?): IBinder? = null

    //2
    private val timer = Timer()

    //5
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        /*here we recieve the last time passed from the mainActivity
        //send it to StopWatch timerTask inner class
        */
        val time = intent?.getDoubleExtra(CURRENT_TIME, 0.0)
        //0: delay     period is 1 second. we write it in milisecond
        timer.scheduleAtFixedRate(StopWatchTimerTask(time!!), 0, 1000)
        //system will not restart the service automatical
        return START_NOT_STICKY
    }

    //3
    override fun onDestroy() {
        timer.cancel()
        super.onDestroy()
    }

    //1
    companion object {
        const val CURRENT_TIME = "current time"
        const val UPDATED_TIME = "updated time"
    }

    //4
    private inner class StopWatchTimerTask(private var time: Double) : TimerTask() {
        override fun run() {
            //intent for updated value
            val intent = Intent(UPDATED_TIME)
            //increasing the time by one
            time++
            //save current time to intent
            intent.putExtra(CURRENT_TIME, time)
            //invoke send broadcast to send data to activity
            sendBroadcast(intent)
        }



    }
}