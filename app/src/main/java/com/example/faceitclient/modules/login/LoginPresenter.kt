package com.example.faceitclient.modules.login

import android.annotation.SuppressLint
import android.util.Log
import com.example.faceitclient.models.FaceitResponse
import com.example.faceitclient.modules.base.Presenter
import com.example.faceitclient.network.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginPresenter internal constructor() : Presenter<ILoginView?>(), ILoginPresenter {

    override fun onViewAttached() {}
    override fun onViewDetached() {}

}