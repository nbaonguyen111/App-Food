package vn.edu.tdc.demokotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.SearchView
import vn.edu.tdc.demokotlin.quanlymonan.foodList

class dshaisanactivity : AppCompatActivity() {
    private lateinit var rvmonan: RecyclerView
    private lateinit var toolbar: Toolbar
    private lateinit var adapter: Adapter
    private lateinit var searchview: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.danhsachhaisan)
        SetControl()
        quanlymonan.initFoodList()
        SetEvent()



    }

    fun SetControl() {
        rvmonan = findViewById(R.id.rvmonan)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        searchview = findViewById(R.id.searchView)



    }

    fun SetEvent() {

        val ds = quanlymonan.getDSFood().toMutableList()
        val filteredList = ds.filter { it.loaiMon =="Hải Sản" }.toMutableList()
        val adapter = Adapter(filteredList)
        rvmonan.adapter=adapter
        rvmonan.layoutManager= LinearLayoutManager(
            this,

            LinearLayoutManager.VERTICAL,
            false
        )
        (this as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {

            finish()
        }

        searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter(newText ?: "")
                return true
            }
        })
    }
}
