package vn.edu.tdc.demokotlin

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class xoadulieu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.remove("email").apply()

        Toast.makeText(this, "Dữ liệu đã được xóa khi mở ứng dụng!", Toast.LENGTH_SHORT).show()
    }
    }
