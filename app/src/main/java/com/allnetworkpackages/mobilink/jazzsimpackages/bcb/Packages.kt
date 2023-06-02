package com.allnetworkpackages.mobilink.jazzsimpackages.bcb


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Adapters.CallPackageAdapter
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Adapters.DataPackageAdapter
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Adapters.PackageAdapter
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Adapters.RangePackageAdapter
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Ads.BannerB
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.CallPackages
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.DataPackages
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.RangePackages
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.SmsPackages
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.databinding.ActivityPackagesBinding


class Packages : AppCompatActivity() {
    lateinit var binding: ActivityPackagesBinding
    lateinit var viewModel: MainView
    lateinit var adapterSmsPackage: PackageAdapter
    lateinit var adapterCallPackage: CallPackageAdapter
    lateinit var adapterDataPackage : DataPackageAdapter
    lateinit var adapterRangePackage: RangePackageAdapter

    var SmspackageData = ArrayList<SmsPackages>()
    var CallPackageData =ArrayList<CallPackages>()
    var RangePackageData =ArrayList<RangePackages>()
    var DataPackagesData =ArrayList<DataPackages>()


    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityPackagesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        BannerB.bannerAdmob(binding.adViewE,binding.tvAdE)
        val d=intent.getIntExtra("SmsBox",0)
        if(d==0)
        {
            SmspackageData=ArrayList()
            val SmsPackageDataDatabase=DataDatabase.invoke(this).getSmsPackages().getSmsPackages()
            adapterSmsPackage= PackageAdapter()
            binding.PackageRecyclerView.adapter=adapterSmsPackage
            adapterSmsPackage.getDetails(SmspackageData)
            binding.PackageRecyclerView.layoutManager=GridLayoutManager(this,1)


            SmsPackageDataDatabase.observe(this){

                it.forEach {
                    SmspackageData.add(it)
                    adapterSmsPackage.getDetails(SmspackageData)
                }
            }
        }

        else if(d==1) {
            CallPackageData = ArrayList()
            val CallPackageDatabase = DataDatabase.invoke(this).getCallPackages().getCallPackages()
            adapterCallPackage =CallPackageAdapter()
            binding.PackageRecyclerView.adapter = adapterCallPackage
            adapterCallPackage.getDetailsCall(CallPackageData)
            binding.PackageRecyclerView.layoutManager=GridLayoutManager(this,1)
            CallPackageDatabase.observe(this){

                it.forEach {
                    CallPackageData.add(it)
                    Log.d("CallPack", it.MBs.toString())
                    adapterCallPackage.getDetailsCall(CallPackageData)

                }
            }
        }

        else if (d==2)
        {
            DataPackagesData= ArrayList()
            val DataPackageDatabase=DataDatabase.invoke(this).getDataPackages().getDataPackages()
            adapterDataPackage= DataPackageAdapter()
            binding.PackageRecyclerView.adapter=adapterDataPackage
       //     adapterDataPackage.getDetailsData(DataPackagesData)
            binding.PackageRecyclerView.layoutManager=GridLayoutManager(this,1)
            DataPackageDatabase.observe(this){
                it.forEach {
                    DataPackagesData.add(it)
                    adapterDataPackage.getDetailsData(DataPackagesData)
                }
            }
        }

        else if(d==3)
        {
            RangePackageData= ArrayList()
            val RangePackageDataBase=DataDatabase.invoke(this).getRangePackages().getRangePackages()
            adapterRangePackage= RangePackageAdapter()
            binding.PackageRecyclerView.adapter=adapterRangePackage
            adapterRangePackage.getDetailsRange(RangePackageData)
            binding.PackageRecyclerView.layoutManager=GridLayoutManager(this,1)
            RangePackageDataBase.observe(this){
                it.forEach {
                    RangePackageData.add(it)
                    adapterRangePackage.getDetailsRange(RangePackageData)
                }
            }

        }

        else if(d==4)
        {
            RangePackageData= ArrayList()
            val RangePackageDataBase=DataDatabase.invoke(this).getRangePackages().getRangePackages()
            adapterRangePackage= RangePackageAdapter()
            binding.PackageRecyclerView.adapter=adapterRangePackage
            adapterRangePackage.getDetailsRange(RangePackageData)
            binding.PackageRecyclerView.layoutManager=GridLayoutManager(this,1)

            RangePackageDataBase.observe(this){
                it.forEach {
                    RangePackageData.add(it)
                    adapterRangePackage.getDetailsRange(RangePackageData)
                }
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        androidx.appcompat.R.id.home
        this.finish()
        return super.onOptionsItemSelected(item)
    }
}