package vn.edu.tdc.demokotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
private lateinit var tvOrderDetails:TextView
private lateinit var btnGoToHome:Button
private lateinit var tvtotal:TextView
class xacnhandonhang : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.xacnhandonhang)
        SetControl()
        SetEvent()
    }
    fun SetControl(){
        tvOrderDetails=findViewById(R.id.tvOrderDetails)
        btnGoToHome=findViewById(R.id.btnGoToHome)
    }
    fun SetEvent(){
        val data =intent.getStringExtra("name")
        val total = intent.getDoubleExtra("tongtien",0.0)
        tvOrderDetails.text=data
        tvtotal.text=total.toString()
        btnGoToHome.setOnClickListener {
            finish()
        }
    }
}