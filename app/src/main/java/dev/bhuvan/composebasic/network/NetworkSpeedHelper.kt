package dev.bhuvan.composebasic.network

import android.content.Context
import android.net.TrafficStats
import android.os.Handler
import android.os.Looper
import dev.bhuvan.composebasic.constants.Constants
import dev.bhuvan.composebasic.helper.isFalse
import java.util.*

class NetworkSpeedHelper(context: Context, listener: OnNetworkUpdate) {
    private var mLastRxBytes: Long = 0
    private var mLastTxBytes: Long = 0
    private var mLastTime: Long = 0

    private var speed = Speed(context)

    private val handler = Handler(Looper.getMainLooper())

    private val runnable: Runnable by lazy {
        Runnable {
            val currentRxBytes = TrafficStats.getTotalRxBytes()
            val currentTxBytes = TrafficStats.getTotalTxBytes()
            val usedRxBytes = currentRxBytes - mLastRxBytes
            val usedTxBytes = currentTxBytes - mLastTxBytes
            val currentTime = System.currentTimeMillis()
            val usedTime = currentTime - mLastTime

            mLastRxBytes = currentRxBytes
            mLastTxBytes = currentTxBytes
            mLastTime = currentTime

            speed.calcSpeed(usedTime, usedRxBytes, usedTxBytes)

            if (speed.total.isPoorConnection(5).isFalse()) {
                Constants.lastTimeFromBeingPoor = null
            } else {
                if (Constants.lastTimeFromBeingPoor == null) {
                    Constants.lastTimeFromBeingPoor = Date()
                }
            }
            listener.onUpdate(speed)

            handler.postDelayed(runnable, 500)
        }
    }

    fun initNetworkSpeedListener() {
        Constants.lastTimeFromBeingPoor = Date()
        handler.post(runnable)
    }

    fun removeSpeedListener() {
        handler.removeCallbacks(runnable)
    }

    interface OnNetworkUpdate {
        fun onUpdate(speed: Speed?)
    }
}