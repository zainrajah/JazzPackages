package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Ads

import android.content.Context
import android.preference.PreferenceManager

object Purchased {
    fun checkPurchased(context: Context): Boolean {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val purchased = sharedPreferences.getBoolean("purchased", false)
        if (purchased) {
            return true
        } else {
            return false
        }

    }
}