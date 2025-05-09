package vn.edu.tdc.demokotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
private lateinit var txtfoodname:TextView
private lateinit var txtprice:TextView
private lateinit var foodimage:ImageView
private lateinit var txtmota:TextView
private lateinit var toolbar:Toolbar
private lateinit var btndathang:Button


class chitietactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chitietmonan)
        SetContorl()
        SetEvent()

    }
fun SetContorl(){
txtfoodname = findViewById(R.id.txtTenMonChiTiet)
txtprice = findViewById(R.id.txtGiaMonChiTiet)
foodimage = findViewById(R.id.imgMonChiTiet)
    txtmota=findViewById(R.id.txtmotachitiet)
    btndathang=findViewById(R.id.dathang)
    toolbar=findViewById(R.id.toolbar)
    setSupportActionBar(toolbar)


}
    fun SetEvent(){
    val tenmon = intent.getStringExtra("tenmon")
        val giaTien = intent.getDoubleExtra("giatien", 0.0)
        val imageResId = intent.getIntExtra("imageResId", 0)
        val mota = intent.getStringExtra("mota")


        txtfoodname.text = tenmon
        txtprice.text = String.format("%,.0f VNĐ",giaTien)
        foodimage.setImageResource(imageResId)
        txtmota.text=mota

        btndathang.setOnClickListener {
            val giatiendouble =giaTien.toDouble()
           val cartitem = CartItem(tenmon,giatiendouble,imageResId)
            quanlygiohang.addToCart(cartitem)

//            quanlydoanhthu.addToCart(cartitem)

            Toast.makeText(this, "Đã Thêm $tenmon Vào Giỏ Hàng", Toast.LENGTH_SHORT).show()

        }

        (this as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {

            finish()
        }
    }

}