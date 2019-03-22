package com.ashen.firebase.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.ashen.firebase.R
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.reward.RewardItem
import com.google.android.gms.ads.reward.RewardedVideoAd
import com.google.android.gms.ads.reward.RewardedVideoAdListener
import kotlinx.android.synthetic.main.activity_main.*

/**
 * https://developers.google.com/admob/android/rewarded-video
 */
class MainActivity : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd
    private lateinit var mRewardedVideoAd: RewardedVideoAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initInterstitialAd()
        initRewardedVideo()

        tv_banner.setOnClickListener {
            startActivity(Intent(this, BannerActivity::class.java))
        }
        tv_interstitial.setOnClickListener {
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
            } else {
                Toast.makeText(this, "Ad is loading", Toast.LENGTH_SHORT).show()
            }
        }
        tv_rewarded_video.setOnClickListener {
            if (mRewardedVideoAd.isLoaded) {
                mRewardedVideoAd.show()
            } else {
                Toast.makeText(this, "Ad is loading", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun initInterstitialAd() {
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        mInterstitialAd.adListener = object : AdListener() {
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
                //加载完广告后重新加载一个新的广告
                mInterstitialAd.loadAd(AdRequest.Builder().build())
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

    private fun initRewardedVideo() {
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this)
        loadRewardedVideoAd()
        mRewardedVideoAd.rewardedVideoAdListener = object : RewardedVideoAdListener {
            override fun onRewardedVideoAdClosed() {
                loadRewardedVideoAd()
            }

            override fun onRewardedVideoAdLeftApplication() {
            }

            override fun onRewardedVideoAdLoaded() {
            }

            override fun onRewardedVideoAdOpened() {
            }

            override fun onRewardedVideoCompleted() {
            }

            override fun onRewarded(p0: RewardItem?) {
            }

            override fun onRewardedVideoStarted() {
            }

            override fun onRewardedVideoAdFailedToLoad(p0: Int) {
            }

        }
    }

    private fun loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917",
                AdRequest.Builder().build())
    }

    override fun onPause() {
        super.onPause()
        mRewardedVideoAd.pause(this)
    }

    override fun onResume() {
        super.onResume()
        mRewardedVideoAd.resume(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mRewardedVideoAd.destroy(this)
    }
}
