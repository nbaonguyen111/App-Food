package vn.edu.tdc.demokotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class nhapotp : AppCompatActivity() {
    private lateinit var otpBox1: EditText
    private lateinit var otpBox2: EditText
    private lateinit var otpBox3: EditText
    private lateinit var otpBox4: EditText
    private lateinit var otpBox5: EditText
    private lateinit var otpBox6: EditText
    private lateinit var xacThucButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nhapotp)
          SetControl()
         SetEvent()



    }
    fun SetControl(){
        otpBox1 = findViewById(R.id.otpBox1)
        otpBox2 = findViewById(R.id.otpBox2)
        otpBox3 = findViewById(R.id.otpBox3)
        otpBox4 = findViewById(R.id.otpBox4)
        otpBox5 = findViewById(R.id.otpBox5)
        otpBox6 = findViewById(R.id.otpBox6)
        xacThucButton = findViewById(R.id.btnVerify)
    }
    fun SetEvent(){
        val receivedOtp = intent.getStringExtra("otpCode")
        val email = intent.getStringExtra("email")

        xacThucButton.setOnClickListener {
            val enteredOtp = getOtpFromBoxes()

            if (enteredOtp == receivedOtp) {
                Toast.makeText(this, "Xác thực thành công!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, doimatkhau::class.java)
                intent.putExtra("userEmail", email)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Mã OTP không chính xác!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getOtpFromBoxes(): String {
        return otpBox1.text.toString() +
                otpBox2.text.toString() +
                otpBox3.text.toString() +
                otpBox4.text.toString() +
                otpBox5.text.toString() +
                otpBox6.text.toString()
    }
}
