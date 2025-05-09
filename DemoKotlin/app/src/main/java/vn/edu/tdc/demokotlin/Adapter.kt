package vn.edu.tdc.demokotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private var ds: MutableList<outDatacomota>) : RecyclerView.Adapter<Adapter.danhsachmonanholder>() {
    private var onItemClickListener: ((Int, outDatacomota) -> Unit)? = null
    private var onItemLongClickListener: ((Int) -> Unit)? = null
    private var originalList = ds.toMutableList()
    private var filteredList: MutableList<outDatacomota> = ds.toMutableList()

    // ViewHolder đại diện cho một item trong danh sách
    inner class danhsachmonanholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtfoodname: TextView = itemView.findViewById(R.id.txtFoodName)
        val foodimage: ImageView = itemView.findViewById(R.id.imgFood)
        val txtprice: TextView = itemView.findViewById(R.id.txtFoodPrice)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): danhsachmonanholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return danhsachmonanholder(view)
    }



    override fun onBindViewHolder(holder: danhsachmonanholder, position: Int) {
        val foodItem = ds[position]
        holder.apply {
            txtfoodname.text = foodItem.tenmon
            txtprice.text = String.format("%,.0f VNĐ", foodItem.giatien)
            foodimage.setImageResource(foodItem.image)
        }


        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, chitietactivity::class.java).apply {
                putExtra("tenmon", foodItem.tenmon)
                putExtra("giatien", foodItem.giatien)
                putExtra("imageResId", foodItem.image)
                putExtra("mota", foodItem.mota)
            }
            it.context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int = ds.size

    fun setOnItemClickListener(listener: (Int, outDatacomota) -> Unit) {
        onItemClickListener = listener
    }


    fun setOnItemLongClickListener(listener: (Int) -> Unit) {
        onItemLongClickListener = listener
    }





    fun filter(query: String) {
        val filteredList = if (query.isEmpty()) {
            originalList  // Nếu không có từ khóa tìm kiếm, hiển thị tất cả món ăn
        } else {
            originalList.filter {
                it.tenmon.contains(query, ignoreCase = true)  // Lọc theo tên món ăn
            }
        }

        // Cập nhật lại danh sách trong RecyclerView
        ds.clear()
        ds.addAll(filteredList)
        notifyDataSetChanged()
    }
    fun updateData(newList: List<outDatacomota>) {
        ds.clear()
        ds.addAll(newList)
        notifyDataSetChanged() // Cập nhật lại giao diện khi danh sách thay đổi
    }




}

