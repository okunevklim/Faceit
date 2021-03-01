package com.example.faceitclient.modules.base

interface IPresenter<V> {
    fun attachView(view: V)
    fun detachView()
}