package vn.edu.tdc.demokotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class suathongtin : AppCompatActivity() {
    private lateinit var btnback: ImageButton
    private lateinit var etEditName: EditText
    private lateinit var etEditEmail: EditText
    private lateinit var btnSaveEdit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.suathongtin)
        SetControl()
        SetEvent()
    }

    fun SetControl() {
        btnback = findViewById(R.id.btnBack)
        etEditEmail = findViewById(R.id.etEditEmail)
        etEditName = findViewById(R.id.etEditName)
        btnSaveEdit = findViewById(R.id.btnSaveEdit)
    }

    fun SetEvent() {
        btnback.setOnClickListener {
            finish() // Quay lại trang trước
        }

        // Nhận dữ liệu từ Intent (từ userfragment)
        val userName = intent.getStringExtra("userName")
        val userEmail = intent.getStringExtra("userEmail")
        etEditName.setText(userName)
        etEditEmail.setText(userEmail)

        btnSaveEdit.setOnClickListener {
            val updatedName = etEditName.text.toString()
            val updatedEmail = etEditEmail.text.toString()

            // Trả kết quả về cho userfragment
            val resultIntent = Intent()
            resultIntent.putExtra("updatedName", updatedName)
            resultIntent.putExtra("updatedEmail", updatedEmail)
            setResult(RESULT_OK, resultIntent) // Trả kết quả về với mã RESULT_OK
            finish() // Đóng Activity và quay lại userfragment
        }
    }
}
