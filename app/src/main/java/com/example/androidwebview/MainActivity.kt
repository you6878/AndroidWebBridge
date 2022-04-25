package com.example.androidwebview


import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.Toast


class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val webView = findViewById<WebView>(R.id.myWebview)
        webView.loadUrl("file:///android_asset/web.html")
        webView.settings.javaScriptEnabled = true
        webView.addJavascriptInterface(WebViewJavaScriptInterface(), "Hancom")
    }

    /*
     * JavaScript Interface. Web code can access methods in here
     * (as long as they have the @JavascriptInterface annotation)
     */
    inner class WebViewJavaScriptInterface() {


        /*
         * This method can be called from Android. @JavascriptInterface
         * required after SDK version 17.
         */
        @JavascriptInterface
        fun InicisClose() {
            Toast.makeText(
                this@MainActivity, "기능 작동",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}