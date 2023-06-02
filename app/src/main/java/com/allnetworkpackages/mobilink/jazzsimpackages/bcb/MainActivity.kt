package com.allnetworkpackages.mobilink.jazzsimpackages.bcb
import android.app.Activity
import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Ads.InterstitialClass
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Ads.NetworkCheck
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Ads.NewNativeAdClass
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.CallPackages
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.databinding.ActivityMainBinding

import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.R
import com.google.android.material.navigation.NavigationView
import kotlin.Boolean

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        NewNativeAdClass.adNativeAd(
            this, true, binding.nativeAdContainerAd,
            true
        ) {
            if (NetworkCheck.isNetworkAvailable(this)) {
                binding.tvLoadingAdLabel.visibility = View.GONE
            } else {
                binding.tvLoadingAdLabel.visibility = View.VISIBLE
            }
            null
        }

        val database=DataDatabase.invoke(this)
        database.getCodeDao()


        val data:ArrayList<CallPackages>



//        val database = DataDatabase.getDatabase(this)
//        database.DataDao().getCallDetails()

//        val db = DataDatabase.getDatabase(this)

//      db.openHelper.writableDatabase
//       val data: ArrayList<com.example.jazzpackages.Entities.CallPackages> =
//            ArrayList(db.DataDao().getCallPackages())
    //    db.DataDao().getCallPackages()


//        val repository=DataRepository(DataDao = )

        val drawerLayout: DrawerLayout = binding.DrawerLayoutMain
        val navView: NavigationView = binding.navigation
        toggle =
            ActionBarDrawerToggle(this@MainActivity, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navShareApp -> {
                    val sendIntent = Intent()
                    sendIntent.setAction(Intent.ACTION_SEND)
                    sendIntent.putExtra(
                        Intent.EXTRA_TEXT,
                        "https://play.google.com/store/apps/details?id=$packageName"
                    )
                    sendIntent.setType("text/plain")
                    sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Try New App")
                    startActivity(Intent.createChooser(sendIntent, "Share via"))
                }
                R.id.navRateApp -> try {
                    val marketUri =
                        Uri.parse("https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID)
                    val marketIntent = Intent(Intent.ACTION_VIEW, marketUri)
                    startActivity(marketIntent)
                } catch (e: ActivityNotFoundException) {
                    val marketUri =
                        Uri.parse("market://details?id=" + BuildConfig.APPLICATION_ID)
                    val marketIntent = Intent(Intent.ACTION_VIEW, marketUri)
                    startActivity(marketIntent)
                }
                R.id.navFeedback ->  composeEmail("coolbrainstech@gmail.com", "Feed Back")

                R.id.navPrivacyPoilicy -> {

                    val url = "https://sites.google.com/site/grandracingmaster/privacy-policy"
                    val customIntent = CustomTabsIntent.Builder()
                    customIntent.setToolbarColor(
                        ContextCompat.getColor(
                            this@MainActivity,
                            R.color.Red
                        )
                    );
                    openCustomTab(this@MainActivity, customIntent.build(), Uri.parse(url));

                }
                R.id.navMoreApps ->
                {
                    try {
                        val marketUri =
                            Uri.parse("https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID)
                        val marketIntent = Intent(Intent.ACTION_VIEW, marketUri)
                        startActivity(marketIntent)
                    } catch (e: ActivityNotFoundException) {
                        val marketUri =
                            Uri.parse("market://details?id=" + BuildConfig.APPLICATION_ID)
                        val marketIntent = Intent(Intent.ACTION_VIEW, marketUri)
                        startActivity(marketIntent)
                    }

                }
                R.id.navExit -> exitDialog()
            }
            true
        }
        val intent = Intent(this@MainActivity, Packages::class.java)
        binding.SmsCard.setOnClickListener {
            InterstitialClass.show_interstitial(this){}
            intent.putExtra("SmsBox",0)
            startActivity(intent)
        }
        binding.CallCard.setOnClickListener {
            InterstitialClass.show_interstitial(this){}
            intent.putExtra("SmsBox",1)
            startActivity(intent)
        }
        binding.DataCard.setOnClickListener {
            InterstitialClass.show_interstitial(this){}
            intent.putExtra("SmsBox",2)
            startActivity(intent)
        }
        binding.threeGCard.setOnClickListener {
            InterstitialClass.show_interstitial(this){}
            intent.putExtra("SmsBox",3)
            startActivity(intent)
        }
        binding.OfferCard.setOnClickListener {
            InterstitialClass.show_interstitial(this){}
            intent.putExtra("SmsBox",4)
            startActivity(intent)
        }
        binding.CodesCard.setOnClickListener {
            InterstitialClass.show_interstitial(this){}
            val intent = Intent(this@MainActivity, CodesModel::class.java)
            startActivity(intent)
        }

    }
    fun composeEmail(address: String, subject: String) {
        val emailIntent = Intent(Intent.ACTION_SENDTO)
        emailIntent.setData(Uri.parse("mailto:" + address))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        try {
            startActivity(Intent.createChooser(emailIntent, "Send email using..."));
        } catch (e: Exception) {
            Toast.makeText(
                this@MainActivity,
                "No email clients installed.",
                Toast.LENGTH_SHORT
            ).show()
        }

    }


    private fun exitDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.exit_diolog)
        dialog.setCancelable(false)

        val exitTxt: TextView = dialog.findViewById(R.id.ExitexitApp)
        val rateusTxt: TextView = dialog.findViewById(R.id.rateusExit)
        val cancelTxt: TextView = dialog.findViewById(R.id.cancelExit)

        exitTxt.setOnClickListener {
            finishAffinity()

        }
        rateusTxt.setOnClickListener {
            try {
                val marketUri =
                    Uri.parse("https://play.google.com/store/apps/details?id=" + "${"com.allnetworkpackages.mobilink.jazzsimpackages.bcb"}")
                val marketIntent = Intent(Intent.ACTION_VIEW, marketUri)
                startActivity(marketIntent)
            } catch (e: ActivityNotFoundException) {
                val marketUri =
                    Uri.parse("market://details?id=" + "${"com.allnetworkpackages.mobilink.jazzsimpackages.bcb"}")
                val marketIntent = Intent(Intent.ACTION_VIEW, marketUri)
                startActivity(marketIntent)
            }

            dialog.dismiss()
        }
        cancelTxt.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    override fun onBackPressed() {
        exitDialog()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    fun openCustomTab(activity: Activity, customTabsIntent: CustomTabsIntent, uri: Uri?) {
        val packageName = "com.android.chrome"
        customTabsIntent.intent.setPackage(packageName)
        if (uri != null) {
            customTabsIntent.launchUrl(activity, uri)
        }
    }


}