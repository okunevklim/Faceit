package com.example.faceitclient.modules.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.faceitclient.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), ILoginView {
    private lateinit var presenter: ILoginPresenter
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = LoginPresenter()
        binding.loginButton.setOnClickListener {
            presenter.authUser()
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView()
    }
}