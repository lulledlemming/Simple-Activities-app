package com.dandy.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class WebActivity : AppCompatActivity() {
    lateinit var webView:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        webView=findViewById(R.id.webView)

        webView.webViewClient= WebViewClient()

        webView.loadUrl("https://www.emobilis.ac.ke/")
        webView.settings.javaScriptEnabled=true
        webView.settings.setSupportZoom(true)

    }

    override fun onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack()
        } else
        super.onBackPressed()
    }
}