package com.mukesh.killervalidator

import android.app.Application
import com.killervalidator.killerValidator.KillerValidator

class ApplicationClass: Application() {

    override fun onCreate() {
        super.onCreate()
        KillerValidator.initialize(context = applicationContext)
    }

}