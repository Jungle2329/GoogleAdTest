package com.ashen.firebase.ui

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.util.Log
import com.ashen.firebase.R
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import kotlinx.android.synthetic.main.activity_banner.*

/**
 * Created by Jungle on 2019/3/22 0022.
 * @version 1.0.0
 * @author JungleZhang
 * @Description
 */
class BannerActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banner)
        adView1.loadAd(AdRequest.Builder().build())
        adView2.loadAd(AdRequest.Builder().build())
        adView3.loadAd(AdRequest.Builder().build())
        adView1.adListener = object : AdListener() {
            override fun onAdImpression() {
                super.onAdImpression()
                Log.i("zhangyi", "onAdImpression")
            }

            override fun onAdLeftApplication() {
                super.onAdLeftApplication()
                Log.i("zhangyi", "onAdLeftApplication")
            }

            override fun onAdClicked() {
                super.onAdClicked()
                Log.i("zhangyi", "onAdClicked")
            }

            override fun onAdFailedToLoad(p0: Int) {
                super.onAdFailedToLoad(p0)
                Log.i("zhangyi", "onAdFailedToLoad: p0 = $p0")
            }

            override fun onAdClosed() {
                super.onAdClosed()
                Log.i("zhangyi", "onAdClosed")
            }

            override fun onAdOpened() {
                super.onAdOpened()
                Log.i("zhangyi", "onAdOpened")
            }

            override fun onAdLoaded() {
                super.onAdLoaded()
                Log.i("zhangyi", "onAdLoaded")
            }
        }
    }
}