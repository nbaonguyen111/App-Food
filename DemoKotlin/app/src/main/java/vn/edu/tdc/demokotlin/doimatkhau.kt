package vn.edu.tdc.demokotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class doimatkhau : AppCompatActivity() {
    private lateinit var newPasswordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var doiMatKhauButton: Button

    companion object {
        val userList = mutableListOf<user>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.doimatkhau)

        SetControl()
        SetEvent()
    }

    private fun SetControl() {
        newPasswordEditText = findViewById(R.id.newPasswordEditText)
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText)
        doiMatKhauButton = findViewById(R.id.doimatkhauButton)
    }

    private fun SetEvent() {
        val userEmail = intent.getStringExtra("userEmail") ?: return

        doiMatKhauButton.setOnClickListener {
            val newPassword = newPasswordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()


//                val user = userList.find { it.email == userEmail }
//                user?.password = newPassword

            if (newPassword == confirmPassword && newPassword.isNotEmpty()) {
                // Cập nhật mật khẩu mới vào SharedPreferences
                val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString(userEmail, newPassword)  // Cập nhật mật khẩu mới cho email đã đăng nhập
                editor.apply()
                Toast.makeText(this, "Mật khẩu đã được thay đổi!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, dangnhapscreen::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Mật khẩu không khớp hoặc trống!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
