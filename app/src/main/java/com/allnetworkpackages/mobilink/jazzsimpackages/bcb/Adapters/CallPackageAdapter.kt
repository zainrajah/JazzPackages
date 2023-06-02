package  com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Adapters

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
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.CallPackages

import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.databinding.PackageitemBinding



import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class CallPackageAdapter:RecyclerView.Adapter<com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Adapters.CallPackageAdapter.CallPackageViewHolder>() {

    lateinit var context: Context
    var CallPackageArray = ArrayList<CallPackages>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):CallPackageAdapter.CallPackageViewHolder {
       context=parent.context
        val binding= PackageitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CallPackageViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return CallPackageArray.size

    }

    override fun onBindViewHolder(holder:CallPackageAdapter.CallPackageViewHolder, position: Int) {
        val currentItems=CallPackageArray[position]
        with(holder)
        {
            with(CallPackageArray)
            {
                binding.mainheadingText.text=currentItems.Heading
                binding.subHeadingText.text=currentItems.Validity
                binding.MinutesText.text=currentItems.OnnetMinutes
                binding.SmsText.text=currentItems.Sms
                binding.MbsText.text=currentItems.MBs
                binding.RsText.text=currentItems.Rupees
                binding.btnViewDetails.setOnClickListener {
                    InterstitialClass.show_interstitial(context){}
                    val intent= Intent(context, DetailPage::class.java )
                    intent.putExtra("Packages",adapterPosition+1)
                    intent.putExtra("PackagesDetails",11)
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

    fun getDetailsCall(list: List<CallPackages>) {
        CallPackageArray.clear()
        CallPackageArray.addAll(list)
        notifyDataSetChanged()

    }
    inner class CallPackageViewHolder(val binding: PackageitemBinding): RecyclerView.ViewHolder(binding.root)
}