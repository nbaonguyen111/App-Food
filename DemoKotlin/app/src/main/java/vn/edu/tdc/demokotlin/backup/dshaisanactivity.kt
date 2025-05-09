package vn.edu.tdc.demokotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var rvmonan :RecyclerView
private lateinit var toolbar:Toolbar
class dshaisanactivitybk : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.danhsachhaisan)
        SetControl()
        SetEvent()
    }
    fun SetControl(){
        rvmonan = findViewById(R.id.rvmonan)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }
    fun SetEvent(){
        val ds = mutableListOf<outDatacomota>()
        ds.add(outDatacomota(R.drawable.haumohanh, "Hàu Mỡ Hành", 35000.0, "Hàu tươi được nướng với mỡ hành thơm lừng, ngon miệng.","Hải Sản"))
        ds.add(outDatacomota(R.drawable.haonuongphomai, "Hàu Phô Mai", 45000.0, "Hàu nướng phô mai béo ngậy, hấp dẫn vị giác.","Hải Sản"))
        ds.add(outDatacomota(R.drawable.ocbu, "Ốc Bưu", 28000.0, "Ốc bưu được chế biến đậm đà, tươi ngon với gia vị đặc trưng.","Hải Sản"))
        ds.add(outDatacomota(R.drawable.ochuong, "Ốc Hương", 32000.0, "Ốc hương tươi sống xào gia vị, giòn ngọt, hấp dẫn.","Hải Sản"))
        ds.add(outDatacomota(R.drawable.ocmongtay, "Ốc Móng Tay", 29000.0, "Ốc móng tay xào tỏi thơm, vị ngọt tự nhiên của hải sản.","Hải Sản"))
        ds.add(outDatacomota(R.drawable.sodiep, "Sò Điệp", 48000.0, "Sò điệp nướng bơ tỏi hoặc xào, ngọt thịt, hấp dẫn.","Hải Sản"))
        ds.add(outDatacomota(R.drawable.tomhumbotoi, "Tôm Hùm Bơ Tỏi", 180000.0, "Tôm hùm nướng bơ tỏi, vị ngọt thanh, béo ngậy.","Hải Sản"))
        ds.add(outDatacomota(R.drawable.tomxaothapcam, "Tôm Xào Thập Cẩm", 35000.0, "Tôm xào với rau củ thập cẩm, thơm ngon, đầy đủ dưỡng chất.","Hải Sản"))
        ds.add(outDatacomota(R.drawable.kingcrabbotoi, "KingCrab Bơ Tỏi", 250000.0, "Càng cua hoàng đế nướng bơ tỏi, giòn ngọt đậm đà.","Hải Sản"))
        ds.add(outDatacomota(R.drawable.ghengamtuong, "Ghẹ Ngâm Tương", 40000.0, "Ghẹ ngâm tương, vị đậm đà, thơm ngon, rất đặc biệt.","Hải Sản"))

//        val adapter = Adapter(ds)
        rvmonan.layoutManager= LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        rvmonan.adapter=Adapter(ds)
        (this as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {

            finish()
        }
    }
}