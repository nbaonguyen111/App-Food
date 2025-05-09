package vn.edu.tdc.demokotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import org.w3c.dom.Text


class dathang : DialogFragment() {
  private lateinit var tvOrderDetails:TextView
  private lateinit var tvTotalPrice:TextView
  private lateinit var spPaymentMethod:Spinner
  private lateinit var etFullName:EditText
  private lateinit var etPhoneNumber:EditText
  private lateinit var etAddress:EditText
  private lateinit var btnCancel:Button
  private lateinit var btnConfirmOrder:Button



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_chitietdonhang, container, false)
        SetControl(view)
        SetEvent()
        return view
    }
    fun SetControl(view: View){
        tvOrderDetails = view.findViewById(R.id.tvOrderDetails)
        tvTotalPrice = view.findViewById(R.id.tvTotalPrice)
        spPaymentMethod = view.findViewById(R.id.spPaymentMethod)
        etFullName = view.findViewById(R.id.etFullName)
        etPhoneNumber = view.findViewById(R.id.etPhoneNumber)
        etAddress = view.findViewById(R.id.etAddress)
        btnCancel = view.findViewById(R.id.btnCancel)
        btnConfirmOrder = view.findViewById(R.id.btnConfirmOrder)
    }
    fun SetEvent(){
        btnConfirmOrder.setOnClickListener {
            Toast.makeText(activity, "Đặt Hàng Thành Công", Toast.LENGTH_SHORT).show()
        }
    }


}