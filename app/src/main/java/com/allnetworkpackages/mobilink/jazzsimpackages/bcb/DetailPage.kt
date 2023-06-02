package com.allnetworkpackages.mobilink.jazzsimpackages.bcb

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Ads.BannerB
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Ads.InterstitialClass
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.databinding.ActivityDetailPageBinding


class DetailPage : AppCompatActivity() {
    lateinit var binding: ActivityDetailPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        BannerB.bannerAdmob(binding.adViewE,binding.tvAdE)

        val d = intent.getIntExtra("PackagesDetails", 10)


        if (d == 10) {
            val i = intent.getIntExtra("Packages", 0)
            val data = DataDatabase.invoke(this).getSmsDetails().getSmsById(i)
            data.observe(this) {
                it.forEach {
                    binding.DetailsDescription.text = it.Details
                    binding.ValidForDescription.text = it.ValidFor
                    binding.VolumeDescription.text = it.Volume
                    binding.PriceDescription.text = it.Price
                    binding.CodeDescription.text = it.Code
                }
//                binding.ShareBtn.setOnClickListener {
//                    val sentintent: Intent = Intent().apply {
//                        action = Intent.ACTION_SEND
//                        putExtra(Intent.EXTRA_TEXT, "${binding.DetailsDescription.text}")
//                        type = "text/plain"
//                    }
//                    val shareIntent = Intent.createChooser(sentintent, null)
//                    startActivity(shareIntent)
//                }
                binding.ActivateBtn.setOnClickListener {


                    val intent = Intent(Intent.ACTION_DIAL,
                        Uri.fromParts("tel", binding.CodeDescription.text.toString(), null))
                    startActivity(intent)


                }
            }
        }
        if (d == 11) {
            val i = intent.getIntExtra("Packages", 0)
            val data = DataDatabase.invoke(this).getCallDetail().getCallById(i)
            data.observe(this) {
                it.forEach {
                    binding.DetailsDescription.text = it.Details
                    binding.ValidForDescription.text = it.ValidFor
                    binding.VolumeDescription.text = it.Volume
                    binding.PriceDescription.text = it.Price
                    binding.CodeDescription.text = it.Code
                }
//                binding.ShareBtn.setOnClickListener {
//                    val sentintent: Intent = Intent().apply {
//                        action = Intent.ACTION_SEND
//                        putExtra(Intent.EXTRA_TEXT, "${binding.DetailsDescription.text}")
//                        type = "text/plain"
//                    }
//                    val shareIntent = Intent.createChooser(sentintent, null)
//                    startActivity(shareIntent)
//                }
                binding.ActivateBtn.setOnClickListener {


                    val intent = Intent(Intent.ACTION_DIAL,
                        Uri.fromParts("tel", binding.CodeDescription.text.toString(), null))
                    startActivity(intent)


                }

            }

        }
        if (d == 12) {
            val i = intent.getIntExtra("Packages", 0)
            val data = DataDatabase.invoke(this).getDataDetailsDao().getDataByID(i)
            data.observe(this) {
                it.forEach {
                    binding.DetailsDescription.text = it.Details
                    binding.ValidForDescription.text = it.validFor
                    binding.VolumeDescription.text = it.Volume
                    binding.PriceDescription.text = it.Price
                    binding.CodeDescription.text = it.Code
                }
//                binding.ShareBtn.setOnClickListener {
//                    val sentIntent: Intent = Intent().apply {
//                        action = Intent.ACTION_SEND
//                        putExtra(Intent.EXTRA_TEXT, "${binding.DetailsDescription.text}")
//                        type = "text/plain"
//                    }
//                    val shareIntent = Intent.createChooser(sentIntent, null)
//                    startActivity(shareIntent)
//                }
                binding.ActivateBtn.setOnClickListener {


                    val intent = Intent(Intent.ACTION_DIAL,
                        Uri.fromParts("tel", binding.CodeDescription.text.toString(), null))
                    startActivity(intent)



                }

            }
        }
        if (d == 13) {
            val i = intent.getIntExtra("Packages", 0)
            val data = DataDatabase.invoke(this).getRangeDetails().getRangeById(i)

            data.observe(this) {
                it.forEach {
                    binding.DetailsDescription.text = it.Details
                    binding.ValidForDescription.text = it.ValidFor
                    binding.VolumeDescription.text = it.Volume
                    binding.PriceDescription.text = it.Price
                    binding.CodeDescription.text = it.Code
                }
//                binding.ShareBtn.setOnClickListener {
//                    val sentIntent: Intent = Intent().apply {
//                        action = Intent.ACTION_SEND
//                        putExtra(Intent.EXTRA_TEXT, "${binding.DetailsDescription.text}")
//                        type = "text/plain"
//                    }
//                    val shareIntent = Intent.createChooser(sentIntent, null)
//                    startActivity(shareIntent)
//                }
                binding.ActivateBtn.setOnClickListener {

                    val intent = Intent(Intent.ACTION_DIAL,
                        Uri.fromParts("tel", binding.CodeDescription.text.toString(), null))
                    startActivity(intent)


                }

            }
        }




        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


    }

    override fun onBackPressed() {
        InterstitialClass.show_interstitial(this) {}
        super.onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        InterstitialClass.show_interstitial(this) {}
        androidx.appcompat.R.id.home
        this.finish()
        return super.onOptionsItemSelected(item)
    }

}