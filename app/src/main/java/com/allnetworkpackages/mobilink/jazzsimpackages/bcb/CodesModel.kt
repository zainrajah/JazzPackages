package com.allnetworkpackages.mobilink.jazzsimpackages.bcb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Adapters.CodesAdapter
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Ads.BannerB
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Ads.InterstitialClass
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.Codes
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.databinding.ActivityCodesBinding


class CodesModel : AppCompatActivity() {
    lateinit var binding: ActivityCodesBinding
    lateinit var adapter: CodesAdapter
    var codesData=ArrayList<Codes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityCodesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        BannerB.bannerAdmob(binding.adViewE,binding.tvAdE)
         codesData=ArrayList()
        val codeDataDatabase= DataDatabase.invoke(this).getCodeDao().getCodes()


        adapter= CodesAdapter()

        binding.codeRecyclerView.layoutManager=GridLayoutManager(this,1)
        binding.codeRecyclerView.adapter=adapter

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        codeDataDatabase.observe(this){
            it.forEach {
                codesData.add(it)
                adapter.getCodeItemCount(codesData)

            }

        }



    }

    override fun onBackPressed() {
            InterstitialClass.show_interstitial(this){}
            super.onBackPressed()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        InterstitialClass.show_interstitial(this){}
        androidx.appcompat.R.id.home
        this.finish()
        return super.onOptionsItemSelected(item)
    }
}