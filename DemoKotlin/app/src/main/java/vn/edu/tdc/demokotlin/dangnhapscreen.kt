package vn.edu.tdc.demokotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class dangnhapscreen : AppCompatActivity() {
    private lateinit var btnDangNhap: Button
    private lateinit var btnadmin:Button
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var tvquenmatkhau:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.manhinhdangnhap)

        SetControl()
        SetEvent()
    }
    fun SetControl() {
        btnDangNhap = findViewById(R.id.loginButton)
        usernameEditText = findViewById(R.id.emaildangnhap)
        passwordEditText = findViewById(R.id.passowrdangnhap)
        btnadmin = findViewById(R.id.loginadmin)
        tvquenmatkhau=findViewById(R.id.quenmatkhau)
    }

    fun SetEvent() {
        btnDangNhap.setOnClickListener {
            val email = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
//
            val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
            val savedPassword = sharedPreferences.getString(email, null)

            if (savedPassword != null && savedPassword == password) {
                Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Mainscreen::class.java)
                startActivity(intent)
            } else {

                Toast.makeText(this, "Sai tài khoản hoặc mật khẩu!", Toast.LENGTH_SHORT).show()
            }
            if(email=="nguyen@gmail.com"&&password=="123123"){
                Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, Mainscreen::class.java)
                startActivity(intent)
            }
        }
        btnadmin.setOnClickListener {
            val admail = usernameEditText.text.toString()
            val psadmin = passwordEditText.text.toString()
           if(admail=="admin"&&psadmin=="admin"){
               Toast.makeText(this, "Chào Mừng Admin", Toast.LENGTH_SHORT).show()
               val intent = Intent(this,admin::class.java)
               startActivity(intent)
           }
        }
        tvquenmatkhau.setOnClickListener {
            val intent = Intent(this,quenmatkhau::class.java)
            startActivity(intent)
        }
    }
}
