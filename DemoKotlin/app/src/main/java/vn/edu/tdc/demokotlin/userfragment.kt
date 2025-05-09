package vn.edu.tdc.demokotlin

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.app.Activity


class userfragment : Fragment() {
private lateinit var btndangxuat:Button
private lateinit var btnsuathongtin:Button
private lateinit var btndoimatkhau:Button
private lateinit var tvName:TextView
private lateinit var tvEmail:TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.thongtinnguoidung, container, false)
        btndangxuat = view.findViewById(R.id.btnLogout)
        btnsuathongtin=view.findViewById(R.id.btnEditInfo)
        tvName=view.findViewById(R.id.tvName)
        tvEmail=view.findViewById(R.id.tvEmail)

        btndangxuat.setOnClickListener {
            AlertDialog.Builder(activity)
                .setTitle("Đăng xuất")
                .setMessage("Bạn có chắc chắn muốn đăng xuất?")
                .setPositiveButton("Đồng ý") { _, _ ->
                    Toast.makeText(activity, "Đã đăng xuất!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(activity,dangnhapscreen::class.java)
                    startActivity(intent)
                }
                .setNegativeButton("Hủy bỏ", null)
                .show()
        }
        btnsuathongtin.setOnClickListener {
            val intent = Intent(activity, suathongtin::class.java)
            intent.putExtra("userName", tvName.text.toString())
            intent.putExtra("userEmail", tvEmail.text.toString())
            startActivityForResult(intent, 1)

        }
//        btndoimatkhau.setOnClickListener {
//            val intent=Intent(activity,doimatkhau::class.java)
//            startActivity(intent)
//        }
    return view
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val updatedName = data?.getStringExtra("updatedName")
            val updatedEmail = data?.getStringExtra("updatedEmail")
            tvName.text = updatedName
            tvEmail.text = updatedEmail
        }
    }

}