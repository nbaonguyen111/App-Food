package vn.edu.tdc.demokotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Dangkyscreen : AppCompatActivity() {
    private lateinit var btndangky: Button
    private lateinit var tvdacotaikhoan: TextView
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var emailEditText: EditText

    companion object {
        val userList = mutableListOf<user>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dangkyscreen)

        SetControl()
        SetEvent()
    }

    fun SetControl() {
        btndangky = findViewById(R.id.registerButton)
        tvdacotaikhoan = findViewById(R.id.dacotaikhoan)
        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        emailEditText = findViewById(R.id.emailEditText)
    }

    fun SetEvent() {
        btndangky.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val email = emailEditText.text.toString()
//            if (username.isNotEmpty() && password.isNotEmpty() && email.isNotEmpty()) {
//                val newUser = user(username, password, email)
//                userList.add(newUser)
            if ( password.isNotEmpty()) {
                val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("email", email)
                editor.putString(email, password)

                editor.apply()

                Toast.makeText(this, "Đăng ký thành công! Vui Lòng Đăng Nhập", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, dangnhapscreen::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show()
            }
        }

        tvdacotaikhoan.setOnClickListener {
            val intent = Intent(this, dangnhapscreen::class.java)
            startActivity(intent)
        }
    }


}
