package com.example.calculatorhybid

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import net.pubnative.lite.sdk.HyBid
import net.pubnative.lite.sdk.interstitial.HyBidInterstitialAd
import net.pubnative.lite.sdk.models.AdSize
import net.pubnative.lite.sdk.views.HyBidAdView

class MainActivity : AppCompatActivity() {

    private lateinit var resultView: TextView
    private var interstitial: HyBidInterstitialAd? = null
    private var banner: HyBidAdView? = null

    private val appToken = "dde3c298b47648459f8ada4a982fa92d"
    // Using "1" because case study provided ZoneId = 1 in the assignment instructions.
    // Normally these values come from the HyBid publisher dashboard when we create zones.
    private val bannerZoneId = "1"
    private val interstitialZoneId = "1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultView = findViewById(R.id.result)
        val btnCalc: Button = findViewById(R.id.calculateBtn)
        val input1: EditText = findViewById(R.id.input1)
        val input2: EditText = findViewById(R.id.input2)
        val operator: Spinner = findViewById(R.id.operatorSpinner)

        ArrayAdapter.createFromResource(
            this,
            R.array.operators,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            operator.adapter = adapter
        }
        HyBid.initialize(appToken, application, object : HyBid.InitialisationListener {
            override fun onInitialisationFinished(success: Boolean) {
                if (success) {
                    Toast.makeText(this@MainActivity, "HyBid initialized", Toast.LENGTH_SHORT).show()
                    loadBanner()
                    loadInterstitial()
                } else {
                    Toast.makeText(this@MainActivity, "HyBid initialization failed", Toast.LENGTH_SHORT).show()
                }
            }
        })
        btnCalc.setOnClickListener {
            val n1 = input1.text.toString().toDoubleOrNull()
            val n2 = input2.text.toString().toDoubleOrNull()

            if (n1 == null || n2 == null) {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val op = operator.selectedItem.toString()
            val res = when (op) {
                "+" -> n1 + n2
                "-" -> n1 - n2
                "×" -> n1 * n2
                "÷" -> if (n2 != 0.0) n1 / n2 else Double.NaN
                else -> Double.NaN
            }
            resultView.text = res.toString()
            if (interstitial?.isReady() == true) {
                interstitial?.show()
            } else {
                Toast.makeText(this, "Interstitial not ready yet", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun loadBanner() {
        val bannerContainer: FrameLayout = findViewById(R.id.banner_container)
        banner = HyBidAdView(this, AdSize.SIZE_320x50)
        bannerContainer.addView(banner)

        banner?.load(bannerZoneId, object : HyBidAdView.Listener {
            override fun onAdLoaded() {
                Toast.makeText(this@MainActivity, "Banner loaded", Toast.LENGTH_SHORT).show()
            }
            override fun onAdLoadFailed(error: Throwable?) {
                Toast.makeText(this@MainActivity, "Banner failed: ${error?.message}", Toast.LENGTH_SHORT).show()
            }
            override fun onAdClick() {}
            override fun onAdImpression() {}
        })
    }

    private fun loadInterstitial() {
        interstitial = HyBidInterstitialAd(this, interstitialZoneId, object : HyBidInterstitialAd.Listener {
            override fun onInterstitialLoaded() {
                Toast.makeText(this@MainActivity, "Interstitial loaded", Toast.LENGTH_SHORT).show()
            }

            override fun onInterstitialLoadFailed(error: Throwable?) {
                Toast.makeText(this@MainActivity, "Interstitial failed: ${error?.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onInterstitialImpression() {}
            override fun onInterstitialDismissed() {
                interstitial?.load()
            }

            override fun onInterstitialClick() {}
        })
        interstitial?.load()
    }

    override fun onDestroy() {
        banner?.destroy()
        interstitial?.destroy()
        super.onDestroy()
    }
}
