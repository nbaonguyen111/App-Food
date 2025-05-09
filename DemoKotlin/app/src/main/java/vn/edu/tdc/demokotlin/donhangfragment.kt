package vn.edu.tdc.demokotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class donhangfragment : Fragment() {
    private lateinit var rvOrders: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.order_list, container, false)
        rvOrders = view.findViewById(R.id.recyclerViewOrders)
        setupRecyclerView()
        return view
    }

    private fun setupRecyclerView() {
        val orders = quanlydonhang.getOrders()
        val adapter = OrderAdapter(orders)
        rvOrders.layoutManager = LinearLayoutManager(activity)
        rvOrders.adapter = adapter
    }
}

