package vn.edu.tdc.demokotlin

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class manhinhdoanhthu : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var revenueTextView: TextView
    private lateinit var ordersAdapter: OderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.doanhthu_layout)

        setControl()
        setEvent()
    }

    private fun setControl() {
        recyclerView = findViewById(R.id.ordersRecyclerView)
        revenueTextView = findViewById(R.id.revenueTextView)
    }

    private fun setEvent() {
        // Lấy danh sách đơn hàng từ QuanLyDoanhThu
        val ordersList = quanlydoanhthu.doanhThuList
        val adapter = OderAdapter(ordersList)
        val tongdoanhthu = adapter.tongdoanhthu()

        ordersAdapter = OderAdapter(ordersList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ordersAdapter


        revenueTextView.text = "Tổng Doanh Thu: ${String.format("%,.0f VNĐ",tongdoanhthu)}"
    }
}

