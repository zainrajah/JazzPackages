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
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Ads.InterstitialClass
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.DetailPage
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.DataPackages
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.databinding.PackageitemBinding



import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class DataPackageAdapter:RecyclerView.Adapter<DataPackageAdapter.DataPackageViewHolder>() {



    lateinit var context: Context
    var DataPackagearray = ArrayList<DataPackages>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataPackageViewHolder {
        context=parent.context
        val binding= PackageitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataPackageViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return DataPackagearray.size
    }

    override fun onBindViewHolder(holder: DataPackageViewHolder, position: Int) {
        val currentItems=DataPackagearray[position]


        with(holder)
        {
            with(DataPackagearray)
            {
                binding.mainheadingText.text=currentItems.Heading
                binding.subHeadingText.text=currentItems.Validity
                binding.MinutesText.text=currentItems.OnnetMinutes
                binding.SmsText.text=currentItems.Sms
                binding.MbsText.text=currentItems.Mbs
                binding.RsText.text=currentItems.Rupees
                binding.btnViewDetails.setOnClickListener {
                    InterstitialClass.show_interstitial(context){}
                    val intent= Intent(context, DetailPage::class.java)
                    intent.putExtra("Packages",adapterPosition+1)
                    intent.putExtra("PackagesDetails",12)
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
    fun getDetailsData(list: List<DataPackages>) {

        DataPackagearray.clear()
        DataPackagearray.addAll(list)
        notifyDataSetChanged()

    }

    inner class DataPackageViewHolder (val binding: PackageitemBinding):ViewHolder(binding.root)
}