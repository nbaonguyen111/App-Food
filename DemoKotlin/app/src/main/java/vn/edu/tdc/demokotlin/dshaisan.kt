package vn.edu.tdc.demokotlin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class dshaisan : Fragment() {
    private lateinit var layout4:LinearLayout
    private lateinit var rvmonan:RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.danhsachhaisan, container, false)

        // Lấy Toolbar từ layout của Fragment
        val toolbar: Toolbar = view.findViewById(R.id.toolbar)

        // Thiết lập Toolbar làm ActionBar của Activity
        (activity as? AppCompatActivity)?.setSupportActionBar(toolbar)

        // Cài đặt tiêu đề cho ActionBar (nếu cần)
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Danh Sách Hải Sản"


        // Nếu muốn thêm nút back (mũi tên quay lại)
        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            // Xử lý quay lại (đóng Fragment hiện tại)
            activity?.supportFragmentManager?.popBackStack()

        }
        return view



    }


}