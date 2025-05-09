package vn.edu.tdc.demokotlin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var rvcart :RecyclerView
private lateinit var btndathang:Button
private lateinit var total:TextView




class giohangfragment : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.giohang, container, false)
        SetControl(view)
        SetEvent()

        return view
    }

    fun SetControl(view: View) {
        rvcart = view.findViewById(R.id.recyclerViewCart)
        btndathang = view.findViewById(R.id.btnCheckout)
        total = view.findViewById(R.id.tvTotalPrice)

    }

    fun SetEvent() {
        val cartItems = quanlygiohang.getCartItems()
        val adapter = CartAdapter(cartItems) {

            updateTotalPrice()
        }
        updateTotalPrice()
        rvcart.layoutManager = LinearLayoutManager(activity)
        rvcart.adapter = adapter
        if (cartItems.isEmpty()) {
            btndathang.isEnabled = false
            btndathang.alpha = 0.5f // Làm mờ nút để cho biết nút không khả dụng
            Toast.makeText(
                activity,
                "Giỏ hàng đang trống, hãy thêm sản phẩm trước!",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            btndathang.isEnabled = true
            btndathang.alpha = 1f
        }
        val orders = mutableListOf<CartItem>()
        btndathang.setOnClickListener {
            val dialogview = LayoutInflater.from(activity).inflate(R.layout.formdathang, null)
            val dialog = androidx.appcompat.app.AlertDialog.Builder(requireContext())
                .setView(dialogview)
                .create()
            val etName: EditText = dialogview.findViewById(R.id.etName)
            val etPhone: EditText = dialogview.findViewById(R.id.etPhone)
            val etAddress: EditText = dialogview.findViewById(R.id.etAddress)
            val etNote: EditText = dialogview.findViewById(R.id.etNote)
            val btnsubmit: Button = dialogview.findViewById(R.id.btnSubmit)

            btnsubmit.setOnClickListener {
                val name = etName.text.toString()
                val phone = etPhone.text.toString()
                val address = etAddress.text.toString()
                val note = etNote.text.toString()
                if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                    Toast.makeText(activity, "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show()
                } else {
                    for (item in cartItems) {
                        quanlydoanhthu.addToCart(item)
                    }
                    val orderId = generateRandomUUID()// Tạo ID duy nhất cho đơn hàng
                    val tenmon =cartItems.map { it.tenmon }
                    val order = Order(
                        id = orderId,
                        foodname =tenmon,
                        customerName = name,
                        phone = phone,
                        address = address,
                        note = note,
                        items = cartItems.toList(), // Lưu danh sách sản phẩm trong giỏ
                        totalPrice = quanlygiohang.getTotalPrice(),
                        status = "Đang xử lý" // Trạng thái mặc định
                    )

                    quanlydonhang.addOrder(order) // Lưu đơn hàng vào danh sách quản lý
                    quanlygiohang.clearCart() // Xóa giỏ hàng
                    Toast.makeText(activity, "Đặt hàng thành công!", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                    val intent = Intent(activity,Mainscreen::class.java)
                    startActivity(intent)


                }
            }
//            cartItems.clear()
//                    dialog.dismiss()

            dialog.show()
                }
            }




    private fun updateTotalPrice() {
        val tong = quanlygiohang.getTotalPrice()
        val formatvnd = String.format("%,.0f VNĐ", tong)
        total.text = "Tổng Tiền: ${formatvnd}"
    }
    fun generateRandomUUID(): String {
        val chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        return (1..12)
            .map { chars.random() }
            .joinToString("")
    }


}


