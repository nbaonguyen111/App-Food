package vn.edu.tdc.demokotlin

import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.compose.ui.layout.Layout
import androidx.recyclerview.widget.RecyclerView
class adapterdexuat(var ds: List<outDatacomota>) : RecyclerView.Adapter<adapterdexuat.danhsachdexuatholder>() {

    inner class danhsachdexuatholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtfoodname: TextView = itemView.findViewById(R.id.txtFoodNamedexuat)
        val foodimage: ImageView = itemView.findViewById(R.id.imgFooddexuat)
        val txtprice: TextView = itemView.findViewById(R.id.txtFoodPricedexuat)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): danhsachdexuatholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_dexuat, parent, false)
        return danhsachdexuatholder(view)
    }



    override fun onBindViewHolder(holder: danhsachdexuatholder, position: Int) {
        val item = ds[position]
        holder.apply {
            txtfoodname.text = item.tenmon
            txtprice.text = String.format("%,.0f VNĐ",item.giatien)
            foodimage.setImageResource(item.image)

        }
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, chitietactivity::class.java)
            intent.putExtra("tenmon", item.tenmon)
            intent.putExtra("giatien", item.giatien)
            intent.putExtra("imageResId", item.image)
            intent.putExtra("mota",item.mota)
            it.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return ds.size
    }
}
