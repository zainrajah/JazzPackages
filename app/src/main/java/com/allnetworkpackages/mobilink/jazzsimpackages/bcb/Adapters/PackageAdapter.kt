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
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Ads.InterstitialClass
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.DetailPage
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.SmsPackages
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.databinding.PackageitemBinding

import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class PackageAdapter : RecyclerView.Adapter<PackageAdapter.PackageViewHolder>() {

    lateinit var context: Context
    var SmsPackages = ArrayList<SmsPackages>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackageViewHolder {
        context = parent.context
        val binding = PackageitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PackageViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return SmsPackages.size
    }

    override fun onBindViewHolder(holder: PackageViewHolder, position: Int) {
        val currentItems = SmsPackages[position]
        with(holder)
        {
            with(SmsPackages)
            {
                binding.mainheadingText.text = currentItems.Heading
                binding.subHeadingText.text = currentItems.Validity
                binding.MinutesText.text = currentItems.OnNetMinutes
                binding.SmsText.text = currentItems.Sms
                binding.MbsText.text = currentItems.MBs
                binding.RsText.text = currentItems.Rupees
                binding.btnViewDetails.setOnClickListener {
                    InterstitialClass.show_interstitial(context){}
                    val intent = Intent(context, DetailPage::class.java)
                    intent.putExtra("Packages", adapterPosition + 1)
                    intent.putExtra("PackagesDetails",10)
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

    fun getDetails(list: List<SmsPackages>) {
        SmsPackages.clear()
        SmsPackages.addAll(list)
        notifyDataSetChanged()

    }

    inner class PackageViewHolder(val binding: PackageitemBinding) :
        RecyclerView.ViewHolder(binding.root)
}