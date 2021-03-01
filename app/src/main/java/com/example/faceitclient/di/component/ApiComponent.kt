package com.example.faceitclient.di.component

import com.example.faceitclient.di.module.Api
import com.example.faceitclient.modules.login.LoginPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [Api::class])
interface ApiComponent {
    fun inject(loginPresenter: LoginPresenter)
}