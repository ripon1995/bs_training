package com.example.bkashintegrationtest

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.net.http.SslError
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.SslErrorHandler
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.bkashintegrationtest.model.Checkout
import com.example.bkashintegrationtest.model.PaymentRequest
import com.example.bkashintegrationtest.utility.JavaScriptInterface
import com.google.gson.Gson

class WebViewCheckoutActivity : AppCompatActivity() {
    private val TAG: String = "WebViewActivity"
    private lateinit var mWebView: WebView
    private lateinit var progressBar: ProgressBar
    private var request: String = " "
    private var paymentIDFromInterface:String?=null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_checkout)
        mWebView = findViewById(R.id.activity_checkout_webview)
        progressBar = findViewById(R.id.progressBar)
        val checkout: Checkout = intent.getSerializableExtra("values") as Checkout

        val paymentRequest = PaymentRequest()
        paymentRequest.setAmount(checkout.getAmount())
        paymentRequest.setIntent(checkout.getIntent())

        Log.d("PaymentRequest: ", "onCreate: ${paymentRequest.getAmount()}")
        Log.d("PaymentRequest: ", "onCreate: ${paymentRequest.getIntent()}")

        val gson: Gson = Gson()
        request = gson.toJson(paymentRequest)
        Log.i(TAG, "onCreate: $request")

        val webSettings: WebSettings = mWebView.settings
        webSettings.javaScriptEnabled = true


        mWebView.isClickable = true
        mWebView.settings.domStorageEnabled = true
        mWebView.settings.setAppCacheEnabled(false)
        mWebView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        mWebView.clearCache(true)
        mWebView.settings.allowUniversalAccessFromFileURLs = true
        mWebView.settings.allowUniversalAccessFromFileURLs = true

        mWebView.addJavascriptInterface(JavaScriptInterface(), "Android")
        mWebView.loadUrl("file:///android_asset/www/checkout_120.html")
        mWebView.webViewClient = object : WebViewClient() {
            override fun onReceivedSslError(
                view: WebView?,
                handler: SslErrorHandler?,
                error: SslError?
            ) {
                handler?.proceed()
            }

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                Log.d("External URL", "shouldOverrideUrlLoading: " + url)
                if (url?.equals("https://www.bkash.com/terms-and-conditions") == true) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intent)
                    return true
                }
                return super.shouldOverrideUrlLoading(view, url)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                progressBar.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                val request = "{paymentRequest:$request}"
                mWebView.loadUrl("javascript:callReconfigure(" + request + " )");
                mWebView.loadUrl("javascript:clickPayButton()");
                progressBar.visibility = View.GONE
                val data = JavaScriptInterface().switchActivity()
                Log.d("PAYMENTID: ", "onPageFinished: ====>"+data)
            }

        }
    }

    interface Test{
        fun getPaymentId(paymentId:String){}
    }
}