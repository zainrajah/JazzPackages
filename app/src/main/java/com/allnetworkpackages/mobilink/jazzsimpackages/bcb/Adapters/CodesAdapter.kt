package  com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Adapters

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.Codes
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.databinding.CodesitemBinding

class CodesAdapter:RecyclerView.Adapter<CodesAdapter.CodesViewHolder>() {

    lateinit var context:Context
    var codeData=ArrayList<Codes>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CodesViewHolder {
        context=parent.context
        val binding= CodesitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CodesViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return codeData.size
    }

    override fun onBindViewHolder(holder: CodesViewHolder, position: Int) {
        val currentItem=codeData[position]

        with(holder){
            with(codeData)
            {
                binding.CodeHeading.text=currentItem.Code
                binding.DescriptionHeading.text=currentItem.Description

                binding.CallBtn.setOnClickListener {
                    val dialIntent = Intent(Intent.ACTION_DIAL)
                    dialIntent.data =Uri.fromParts("tel", binding.CodeHeading.text.toString(), null)
                    context.startActivity(dialIntent)
                }

                binding.copyBtn.setOnClickListener {
                    val clipboardManager =
                        context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
                    val clip: ClipData = ClipData.newPlainText("quote", binding.CodeHeading.text)
                    clipboardManager!!.setPrimaryClip(clip)
                    Toast.makeText(context, "Code copied to clipboard", Toast.LENGTH_SHORT).show()
                }
                binding.ShareBtn.setOnClickListener {
                    val sentIntent:Intent= Intent().apply{
                        action=Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT,"Dial ${binding.CodeHeading.text} for ${binding.DescriptionHeading.text}")

                        type="text/plain"
                    }
                    val shareIntent=Intent.createChooser(sentIntent,null)
                    context.startActivity(shareIntent)
                }
            }
        }
    }

    fun getCodeItemCount(list: List<Codes>)
    {
        codeData.clear()
        codeData.addAll(list)
        notifyDataSetChanged()
    }
    inner class CodesViewHolder(val binding: CodesitemBinding): ViewHolder(binding.root)
}