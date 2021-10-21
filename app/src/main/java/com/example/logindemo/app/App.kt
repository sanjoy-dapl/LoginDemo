package com.example.logindemo.app

import android.app.Application
import android.content.Context
import android.os.StrictMode
import com.example.logindemo.app.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application(){

    private val TAG = App::class.java.simpleName

    companion object {
        private val sInstance: App? = null

        @Synchronized
        fun getInstance(): App? {
            return sInstance
        }

        @JvmStatic
        fun getAppContext(): Context? {
            return sInstance?.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()

        //firebaseRemoteConUpdateCheck()

        startKoin {
            androidContext(this@App)
            androidLogger(Level.DEBUG)
            modules(listOf(viewModelModule))
        }

        val builder = StrictMode.VmPolicy.Builder()
        StrictMode.setVmPolicy(builder.build())

    }



    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)


    }



}