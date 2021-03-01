package com.example.faceitclient

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.faceitclient.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.webView.apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView,
                    request: WebResourceRequest
                ): Boolean {
                    return false
                }

                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    if (url != null) {
                        if (url.contains("yandex.ru", true)) {
                            finish()
                            // navigateToFragment()
                        }
                    }
                }
            }
        }
        binding.webView.loadUrl("https://accounts.faceit.com/?response_type=code&client_id=5104183e-4cec-4db9-b663-4c123f0d28fb&redirect_popup=true")
    }

    /*  private fun navigateToFragment() {
          (supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment).navController.setGraph(
              R.navigation.nav_graph
          )
          val navController = findNavController(R.id.navHostFragment)
          navController.navigate(R.id.listFragment)
      }*/

    companion object {
        const val RESPONSE_TYPE = "code"
    }
}