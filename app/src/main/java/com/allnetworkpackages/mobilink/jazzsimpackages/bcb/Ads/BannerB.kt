package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Ads

import android.util.Log
import android.view.View
import android.widget.TextView

import com.google.android.gms.ads.*

object BannerB {
    fun bannerAdmob(mAdView: AdView, txtView: TextView) {

        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mAdView.adListener = object : AdListener() {
            override fun onAdClicked() {}
            override fun onAdClosed() {}
            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.d("BannerFailed", "Admob")
                txtView.visibility = View.VISIBLE
                mAdView.visibility = View.GONE
            }

            override fun onAdImpression() {}

            override fun onAdLoaded() {
                Log.d("BannerLoaded", "Admob")
                txtView.visibility = View.GONE
                mAdView.visibility = View.VISIBLE


            }

            override fun onAdOpened() {}
        }
    }
}