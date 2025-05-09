package vn.edu.tdc.demokotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class thongbao : AppCompatActivity() {
    private lateinit var bottomnagivattion: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.thongbao)
        SetControl()
        SetEvent()

    }


    fun SetControl() {
        bottomnagivattion = findViewById(R.id.bottom_navigation)
    }

    fun SetEvent() {
        bottomnagivattion.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    val intent = Intent(this, Mainscreen::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_notifications -> {
                    // Đặt trạng thái là thông báo
                    bottomnagivattion.selectedItemId = R.id.menu_notifications
                    true
                }
                R.id.menu_user_info -> {
                    val intent = Intent(this, thongtinnguoidung::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }


}