package com.example.faceitclient.modules.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.faceitclient.AuthActivity
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
            openAuthActivity()
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

    override fun openAuthActivity() {
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
    }
}