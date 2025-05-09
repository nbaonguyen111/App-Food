package vn.edu.tdc.demokotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class admin : AppCompatActivity() {
    private lateinit var btncrud:Button
    private lateinit var btndoanhthu:Button
    private lateinit var btndangxuat:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.manhinhadmin)
        SetControl()
        SetEvent()
    }
    fun SetControl(){
        btncrud = findViewById(R.id.crudButton)
        btndoanhthu = findViewById(R.id.doanhThuButton)
        btndangxuat = findViewById(R.id.dangXuatButton)

    }
    fun SetEvent(){
        btncrud.setOnClickListener {
            val intent = Intent(this,adminactivity::class.java)
            startActivity(intent)
        }
        btndoanhthu.setOnClickListener {
            val intent = Intent(this,manhinhdoanhthu::class.java)
            startActivity(intent)
        }
        btndangxuat.setOnClickListener {
            val intent = Intent(this,dangnhapscreen::class.java)
            startActivity(intent)
        }
    }
}