package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Ads

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin



open class ApplicationClass: Application() {

    override fun onCreate() {
        super.onCreate()


        startKoin{
            androidContext(this@ApplicationClass )
            modules(listOf(
                AppModule.getModel(
                this@ApplicationClass)))
        }
       appOpen(this@ApplicationClass)
    }
}