package vn.edu.tdc.demokotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.mail.*
import javax.mail.internet.*

class quenmatkhau : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var guiyeucauButton: Button
    private lateinit var nhoquatkhauTextView: TextView

    private var otpCode: String = ""
    private var recipientEmail: String? = null // Biến lưu email người nhận

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quenmatkhau)

        SetControl()
        SetEvent()

        // Lấy email từ intent
        val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
        recipientEmail = sharedPreferences.getString("email", null)

    }

    fun SetControl() {
        emailEditText = findViewById(R.id.emailEditText)
        guiyeucauButton = findViewById(R.id.guiyeucau)
        nhoquatkhauTextView = findViewById(R.id.nhoquatkhau)
    }

    fun SetEvent() {
        guiyeucauButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
            val storedPassword = sharedPreferences.getString(email, null)
            if (storedPassword != null) {
                if (email.isNotEmpty()) {
                    // Sinh mã OTP
                    otpCode = generateOtp()

                    // Gửi email OTP
                    CoroutineScope(Dispatchers.IO).launch {
                        try {
                            // Kiểm tra nếu email có trong biến recipientEmail
                            recipientEmail?.let {
                                sendEmailOtp(it, otpCode) // Gửi OTP tới email đã lấy từ intent
                                runOnUiThread {
                                    Toast.makeText(
                                        this@quenmatkhau,
                                        "Mã OTP đã được gửi đến email của bạn!",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    // Chuyển sang màn hình nhập OTP
                                    val intent = Intent(this@quenmatkhau, nhapotp::class.java)
                                    intent.putExtra("email", it)
                                    intent.putExtra("otpCode", otpCode)
                                    startActivity(intent)
                                }
                            } ?: run {
                                runOnUiThread {
                                    Toast.makeText(
                                        this@quenmatkhau,
                                        "Email không hợp lệ!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        } catch (e: Exception) {
                            runOnUiThread {
                                Toast.makeText(
                                    this@quenmatkhau,
                                    "Lỗi khi gửi email: ${e.message}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                } else {
                    Toast.makeText(this, "Vui lòng nhập email!", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Email không hợp lệ!", Toast.LENGTH_SHORT).show()
            }

        }
        nhoquatkhauTextView.setOnClickListener {
            val intent = Intent(this, dangnhapscreen::class.java)
            startActivity(intent)
        }
    }

    // Hàm gửi email OTP
    private fun sendEmailOtp(recipientEmail: String, otp: String) {
        val props = Properties()
        props["mail.smtp.auth"] = "true"
        props["mail.smtp.starttls.enable"] = "true"
        props["mail.smtp.host"] = "smtp.gmail.com"
        props["mail.smtp.port"] = "587"

        val session = Session.getInstance(props, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication("nooobao86@gmail.com", "mluc jlzf bgpt ybzb")
            }
        })

        val message = MimeMessage(session)
        message.setFrom(InternetAddress("nooobao86@gmail.com"))
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail))
        message.subject = "Mã OTP của bạn"
        message.setText("Mã OTP để khôi phục mật khẩu của bạn là: $otp")

        Transport.send(message)
    }

    // Hàm sinh mã OTP
    private fun generateOtp(): String {
        return (100000..999999).random().toString()
    }
}
