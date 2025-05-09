package vn.edu.tdc.demokotlin

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class thongtinnguoidung : AppCompatActivity() {
    private lateinit var imgbutton:ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.diachi)
        SetControl()
        SetEvent()

    }
        fun SetControl(){
            imgbutton=findViewById(R.id.btnBack)
        }
    fun SetEvent(){
        imgbutton.setOnClickListener {
            finish()
        }
    }

    }
