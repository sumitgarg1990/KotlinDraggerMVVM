package com.example.sumit.doubtnutassignment

import android.app.Application
import com.example.sumit.doubtnutassignment.di.DIComponent
import com.example.sumit.doubtnutassignment.di.DaggerDIComponent

class MyApplication : Application() {


    companion object {
        lateinit var diComponent: DIComponent
    }
    override fun onCreate() {
        super.onCreate()
        diComponent = initDaggerComponent()

    }

    public fun getMyComponent(): DIComponent {
        return diComponent
    }

    fun initDaggerComponent():DIComponent{
        diComponent =   DaggerDIComponent
                .builder()
                .build()
        return  diComponent

    }
}