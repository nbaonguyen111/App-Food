package vn.edu.tdc.demokotlin

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class chitietdonhang : AppCompatActivity() {
    private lateinit var btndathang:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chitietdonhang)
    SetControl()
        SetEvent()
    }
    fun SetControl(){

    }
    fun SetEvent(){

    }
}