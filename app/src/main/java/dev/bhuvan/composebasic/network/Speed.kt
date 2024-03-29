package dev.bhuvan.composebasic.network

import android.content.Context
import dev.bhuvan.composebasic.R
import java.util.*

class Speed(private val mContext: Context) {

    private var mTotalSpeed: Long = 0
    private var mDownSpeed: Long = 0
    private var mUpSpeed: Long = 0

    var total = HumanSpeed()
    var down = HumanSpeed()
    var up = HumanSpeed()

    private fun updateHumanSpeeds() {
        total.setSpeed(mTotalSpeed)
        down.setSpeed(mDownSpeed)
        up.setSpeed(mUpSpeed)
    }

    fun calcSpeed(timeTaken: Long, downBytes: Long, upBytes: Long) {
        var totalSpeed: Long = 0
        var downSpeed: Long = 0
        var upSpeed: Long = 0
        val totalBytes = downBytes + upBytes
        if (timeTaken > 0) {
            totalSpeed = totalBytes * 1000 / timeTaken
            downSpeed = downBytes * 1000 / timeTaken
            upSpeed = upBytes * 1000 / timeTaken
        }
        mTotalSpeed = totalSpeed
        mDownSpeed = downSpeed
        mUpSpeed = upSpeed
        updateHumanSpeeds()
    }

    inner class HumanSpeed {
        var speedValue: String? = null
        var speedUnit: String? = null
        var isUnitInKb = false
        var speedValueInKb: Long = 0

        fun isPoorConnection(speedToCheck: Long): Boolean {
            return isUnitInKb && speedValueInKb <= speedToCheck
        }

        fun setSpeed(speed: Long) {
            when {
                speed < 1000000 -> {
                    isUnitInKb = true
                    speedUnit = mContext.getString(R.string.kbps)
                    speedValueInKb = (speed / 1000)
                    speedValue = (speed / 1000).toString()
                }
                speed >= 1000000 -> {
                    isUnitInKb = false
                    speedUnit = mContext.getString(R.string.Mbps)
                    speedValue = when {
                        speed < 10000000 -> {
                            String.format(Locale.ENGLISH, "%.1f", speed / 1000000.0)
                        }
                        speed < 100000000 -> {
                            (speed / 1000000).toString()
                        }
                        else -> {
                            mContext.getString(R.string.plus99)
                        }
                    }
                }
                else -> {
                    isUnitInKb = false
                    speedValue = mContext.getString(R.string.dash)
                    speedUnit = mContext.getString(R.string.dash)
                }
            }
        }
    }

    init {
        updateHumanSpeeds()
    }
}