package com.ashen.firebase.ui

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.ashen.firebase.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd

/**
 * Created by Jungle on 2019/3/22 0022.
 * @version 1.0.0
 * @author JungleZhang
 * @Description
 */
class InterstitialActivity : FragmentActivity() {

    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_interstitial)

        mInterstitialAd  = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        mInterstitialAd.loadAd(AdRequest.Builder().build())
        mInterstitialAd.show()
    }
}