package com.example.faceitclient.modules.login

import android.annotation.SuppressLint
import android.util.Log
import com.example.faceitclient.base.FaceitApplication
import com.example.faceitclient.di.module.Api
import com.example.faceitclient.models.FaceitResponse
import com.example.faceitclient.modules.base.Presenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginPresenter internal constructor() : Presenter<ILoginView?>(), ILoginPresenter {
    @Inject
    lateinit var api: Api

    init {
        FaceitApplication.component.inject(this)
    }

    override fun onViewAttached() {}
    override fun onViewDetached() {}

    @SuppressLint("CheckResult")
    override fun authUser() {
        Log.i("FaceitApp", "Faceit auth.")
        api.getService().authUser(
            "code",
            "d3cf0b77-e138-492f-bcff-832b656279a7",
            true
        )
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { faceitResponse: FaceitResponse?, _: Throwable? ->

            }
    }
}