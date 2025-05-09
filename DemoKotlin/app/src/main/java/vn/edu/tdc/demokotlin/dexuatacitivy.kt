package vn.edu.tdc.demokotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var rvdexuat:RecyclerView
class dexuatacitivy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    fun SetControl(){
        rvdexuat=findViewById(R.id.rvdexuat)
    }
    fun SetEvent(){
//        val ds = mutableListOf<outData>()
//        ds.add(outData(R.drawable.mamchungrau,"Măm Chưng Rau Sống",30000))
//        ds.add(outData(R.drawable.longgasuhao,"Lòng Gà Su Hào",30000))
//        ds.add(outData(R.drawable.trasuaphuclong,"Trà Sữa Phúc Long",30000))
//        ds.add(outData(R.drawable.traolongmangcau,"Trà Ô Long Mãng Cầu",30000))
//        ds.add(outData(R.drawable.travailai,"Trà Vải Lài",30000))
//        ds.add(outData(R.drawable.tradaocamsa,"Trà Đào Cam Sả",30000))
//
//
//
//        val adapter = adapterdexuat(ds)
//        rvdexuat.adapter=adapter
//        rvdexuat.layoutManager= LinearLayoutManager(
//            this,
//
//            LinearLayoutManager.HORIZONTAL,
//            false
//        )
    }
}