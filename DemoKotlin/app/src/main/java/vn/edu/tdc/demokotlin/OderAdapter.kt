package vn.edu.tdc.demokotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OderAdapter(private val ordersList: List<CartItem>) : RecyclerView.Adapter<OderAdapter.OrderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.doanhthu, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = ordersList[position]
        holder.foodNameTextView.text = order.tenmon
        holder.quantityTextView.text = "Số lượng: ${order.quantity}"
        holder.priceTextView.text ="Giá: ${String.format("%,.0f VNĐ",order.giatien)}"
        holder.totalPrice.text= "Tổng: ${String.format("%,.0f VNĐ",order.giatien*order.quantity)}"

    }

    override fun getItemCount(): Int = ordersList.size
    fun tongdoanhthu(): Double {
        return ordersList.sumOf { it.giatien * it.quantity }
    }

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodNameTextView: TextView = itemView.findViewById(R.id.foodNameTextView)
        val quantityTextView: TextView = itemView.findViewById(R.id.quantityTextView)
        val priceTextView: TextView = itemView.findViewById(R.id.priceTextView)
        val totalPrice :TextView = itemView.findViewById(R.id.totalPriceTextView)
    }
}
