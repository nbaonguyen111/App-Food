package vn.edu.tdc.demokotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(private val cartItems: List<CartItem>,
    private val onquantitychanged:() -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtFoodName: TextView = itemView.findViewById(R.id.tvfoodcart)
        val txtFoodPrice: TextView = itemView.findViewById(R.id.tvpricecart)
        val txtQuantity: TextView = itemView.findViewById(R.id.tvquantity)
        val imgfood :ImageView =itemView.findViewById(R.id.imgFoodcart)
        val btntang: Button = itemView.findViewById(R.id.btntang)
        val btngiam: Button = itemView.findViewById(R.id.btngiam)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartItem = cartItems[position]
        holder.txtFoodName.text = cartItem.tenmon
        holder.txtFoodPrice.text = String.format("%,.0f VNĐ",cartItem.giatien)
        holder.imgfood.setImageResource(cartItem.image)
        holder.txtQuantity.text = "${cartItem.quantity}"

        holder.btntang.setOnClickListener {
            cartItem.quantity++
            holder.txtQuantity.text ="${cartItem.quantity}"
            notifyItemChanged(position)
            onquantitychanged()

        }
        holder.btngiam.setOnClickListener {
            if (cartItem.quantity > 1) {
                cartItem.quantity--
                holder.txtQuantity.text = "${cartItem.quantity}"
                notifyItemChanged(position)
                onquantitychanged()
            }

        }
        holder.itemView.setOnLongClickListener {
            val builder = android.app.AlertDialog.Builder(holder.itemView.context)
            builder.setTitle("Xóa món ăn")
            builder.setMessage("Bạn có chắc muốn xóa món ${cartItem.tenmon} khỏi giỏ hàng?")
            builder.setPositiveButton("Đồng ý") { _, _ ->
                (cartItems as MutableList).removeAt(position) // Xóa item khỏi danh sách
                notifyItemRemoved(position) // Cập nhật RecyclerView
                notifyItemRangeChanged(position, cartItems.size) // Cập nhật các vị trí còn lại
                onquantitychanged()
            }
            builder.setNegativeButton("Hủy") { dialog, _ ->
                dialog.dismiss()
            }
            builder.create().show()
            true // Trả về true để ngăn sự kiện click thông thường
        }
    }

    override fun getItemCount(): Int = cartItems.size
}
