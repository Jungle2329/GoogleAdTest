package com.ashen.firebase.base

import android.app.Application
import com.google.android.gms.ads.MobileAds

/**
 * Created by Jungle on 2019/3/22 0022.
 * @version 1.0.0
 * @author JungleZhang
 * @Description
 */
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713")
    }
}