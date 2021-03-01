package com.example.faceitclient.modules.login

import com.example.faceitclient.modules.base.IPresenter
import com.example.faceitclient.modules.base.IView

interface ILoginView : IView<ILoginPresenter?> {
    fun openAuthActivity()
}

interface ILoginPresenter : IPresenter<ILoginView?> {
}
