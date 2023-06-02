package com.allnetworkpackages.mobilink.jazzsimpackages.bcb


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Ads.InterstitialClass
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Ads.NetworkCheck
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Ads.NewNativeAdClass.adNativeAd
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.databinding.ActivitySplashScreenBinding



class SplashScreen : AppCompatActivity() {
    lateinit var binding: ActivitySplashScreenBinding
    lateinit var viewModel: MainView
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val progressBar=findViewById<ProgressBar>(R.id.progressBar)
        progressBar.progress=50
        adNativeAd(
            this, true, binding.nativeAdContainerAd,
            true
        ) {
            if (NetworkCheck.isNetworkAvailable(this))
            {
                binding.tvLoadingAdLabel.visibility=View.GONE
            }
            else{
                binding.tvLoadingAdLabel.visibility=View.VISIBLE
            }
            null
        }
        var handler=Handler()

        runOnUiThread{
            handler.postDelayed({
                binding.startbtn.visibility=View.VISIBLE
                binding.progressBar.visibility=View.GONE
            },6500)
        }

        InterstitialClass.load_interstitial(this)

        binding.startbtn.setOnClickListener {
            InterstitialClass.show_interstitial(this){}
            viewModel = ViewModelProvider(
                this,
                viewmodelview(this.application)
            )[MainView::class.java]

            viewModel.allCallDet.observe(this) { list ->
                list?.let {
                    if (it.isNullOrEmpty()) {
                        Log.d("dataa", "it.toString()")
                    } else {
                        Log.d("dataa", it.toString())
                        //   adapter.gethistorylist(it)
                    }
                }
            }
            val intent = Intent(this@SplashScreen, MainActivity::class.java)
                startActivity(intent)
                finish()
        }
    }
}