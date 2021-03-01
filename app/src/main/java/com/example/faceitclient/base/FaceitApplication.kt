package com.example.faceitclient.base

import android.app.Application
import android.content.Context
import com.example.faceitclient.di.component.ApiComponent
import com.example.faceitclient.di.component.DaggerApiComponent

class FaceitApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this.applicationContext
        component = buildComponent()
    }

    private fun buildComponent(): ApiComponent {
        return DaggerApiComponent.builder().build()
    }

    companion object {
        lateinit var context: Context
        lateinit var component: ApiComponent
    }
}