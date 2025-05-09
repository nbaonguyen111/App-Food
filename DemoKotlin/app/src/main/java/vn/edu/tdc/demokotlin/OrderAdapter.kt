package vn.edu.tdc.demokotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrderAdapter(private val orders: List<Order>) :
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    inner class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val customerName: TextView = itemView.findViewById(R.id.tvCustomerName)
        val totalPrice: TextView = itemView.findViewById(R.id.tvTotalPrice)
        val status: TextView = itemView.findViewById(R.id.tvStatus)
        val phone: TextView = itemView.findViewById(R.id.tvnumberphone)
        val address: TextView = itemView.findViewById(R.id.tvdiachikhachhang)
        val madonhang: TextView = itemView.findViewById(R.id.tvMaDonHang)
        val tenmon: TextView = itemView.findViewById(R.id.tvTenMon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.order_layout, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orders[position]
        holder.madonhang.text ="Mã Đơn Hàng:${order.id}"
        holder.tenmon.text ="Tên Món:${order.foodname}"
        holder.customerName.text ="Tên Khách Hàng:${order.customerName}"
        holder.phone.text ="Số Điện Thoại: ${order.phone}"
        holder.address.text ="Địa Chỉ: ${order.address}"
        holder.totalPrice.text = "Tổng Tiền:${String.format("%,.0f VNĐ", order.totalPrice)} "
        holder.status.text ="Trạng Thái: ${order.status}"

    }

    override fun getItemCount(): Int = orders.size
}
