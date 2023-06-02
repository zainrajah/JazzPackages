package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Adapters

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.FileProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Ads.InterstitialClass
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.DetailPage
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.RangePackages
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.databinding.PackageitemBinding

import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class RangePackageAdapter:RecyclerView.Adapter<RangePackageAdapter.RangePackageViewHolder>() {

    lateinit var context: Context

    var RangePackagearray=ArrayList<RangePackages>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RangePackageViewHolder {
        context=parent.context
        val binding= PackageitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RangePackageViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return RangePackagearray.size
    }

    override fun onBindViewHolder(holder: RangePackageViewHolder, position: Int) {
        val currentItems=RangePackagearray[position]
        with(holder)
        {
            with(RangePackagearray)
            {
                binding.mainheadingText.text=currentItems.Heading
                binding.subHeadingText.text=currentItems.Validity
                binding.MinutesText.text=currentItems.OnNetMinutes
                binding.SmsText.text=currentItems.Sms
                binding.MbsText.text=currentItems.MBs
                binding.RsText.text=currentItems.Rupees
                binding.btnViewDetails.setOnClickListener {
                    InterstitialClass.show_interstitial(context){}
                    val intent= Intent(context, DetailPage::class.java )
                    intent.putExtra("Packages",adapterPosition+1)
                    intent.putExtra("PackagesDetails",13)
                    context.startActivity(intent)
                }
                binding.ShareBtn.setOnClickListener {
                    val view = binding.CardLayout
                    val bitmap: Bitmap =
                        Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
                    val canvas = Canvas(bitmap)
                    view.draw(canvas)
                    getBitmapUri(bitmap)
                    shareImage(bitmap)
                }

            }
        }
    }
    private fun getBitmapUri(bitmap: Bitmap): Uri? {

        val cachePath = File(context.externalCacheDir, "${System.currentTimeMillis()}.jpg")
        try {
            val outputStream = FileOutputStream(cachePath)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
            outputStream.flush()
            outputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return FileProvider.getUriForFile(
            context,
            "${"com.allnetworkpackages.mobilink.jazzsimpackages.bcb"}.provider", cachePath
        )
    }
    private fun shareImage(bitmap: Bitmap) {
        val imageUri = getBitmapUri(bitmap)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "image/*"
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri)
        context.startActivity(Intent.createChooser(shareIntent, "Share Image"))
    }

    fun getDetailsRange(list: List<RangePackages>) {
        RangePackagearray.clear()
        RangePackagearray.addAll(list)
        notifyDataSetChanged()

    }

    inner class RangePackageViewHolder(val binding: PackageitemBinding):ViewHolder(binding.root)
}