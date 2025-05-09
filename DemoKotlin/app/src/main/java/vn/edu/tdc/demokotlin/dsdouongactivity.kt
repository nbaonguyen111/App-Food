package vn.edu.tdc.demokotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var rvdouong:RecyclerView
private lateinit var toolbar:Toolbar
private lateinit var searchview:SearchView
class dsdouongactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.danhsachdouong)
        SetControl()
        quanlymonan.initFoodList()
        SetEvent()
    }
    fun SetControl(){
        rvdouong = findViewById(R.id.rvdouong)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        searchview=findViewById(R.id.searchView)
    }
    fun SetEvent(){

        val ds = quanlymonan.getDSFood().toMutableList()
        val filteredList = ds.filter { it.loaiMon =="Đồ Uống" }.toMutableList()
        val adapter = Adapter(filteredList)
        rvdouong.adapter=adapter
        rvdouong.layoutManager= LinearLayoutManager(
            this,

            LinearLayoutManager.VERTICAL,
            false
        )
        (this as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {

            finish()
        }
        searchview.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
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

