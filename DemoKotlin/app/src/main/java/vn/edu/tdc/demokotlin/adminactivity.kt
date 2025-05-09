package vn.edu.tdc.demokotlin

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class adminactivity : AppCompatActivity(), AdminAdapter.OnItemClickListener {

    private lateinit var rvFoodList: RecyclerView
    private lateinit var adapter: AdminAdapter
    private lateinit var foodList: MutableList<outDatacomota>
    private lateinit var editTextTenMon: EditText
    private lateinit var editTextLoaiMon: EditText
    private lateinit var editTextGiaTien: EditText
    private lateinit var editTextMoTa: EditText
    private lateinit var btnAddFood: Button
    private lateinit var btncapnhat: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        SetControl()
        SetEvent()

        // Lấy danh sách món ăn từ quanlymonan
        loadFoodList()
    }


    private fun SetControl() {
        rvFoodList = findViewById(R.id.rvFoodList)
        rvFoodList.layoutManager = LinearLayoutManager(this)
        btncapnhat = findViewById(R.id.btnupdatefood)
        editTextTenMon = findViewById(R.id.editTextTenMon)
        editTextLoaiMon=findViewById(R.id.editTextLoaiMon)
        editTextGiaTien = findViewById(R.id.editTextGiaTien)
        editTextMoTa = findViewById(R.id.editTextMoTa)
        btnAddFood = findViewById(R.id.btnAddFood)

        foodList = mutableListOf()
        adapter = AdminAdapter(foodList, this)
        rvFoodList.adapter = adapter
    }


    private fun SetEvent() {

        btnAddFood.setOnClickListener {
            addFood()
            adapter.notifyDataSetChanged()
        }


    }

    private fun addFood() {
        val tenMon = editTextTenMon.text.toString()
        val loaiMon = editTextLoaiMon.text.toString()
        val giaTien = editTextGiaTien.text.toString().toDoubleOrNull() ?: 0.0
        val moTa = editTextMoTa.text.toString()

        if (tenMon.isNotEmpty() && loaiMon.isNotEmpty() && giaTien > 0) {
            val newFood = outDatacomota(R.drawable.icvittiem, tenMon, giaTien, moTa, loaiMon)
            quanlymonan.foodList.add(newFood)
            foodList.add(newFood)
            adapter.notifyDataSetChanged()


            editTextTenMon.text.clear()
            editTextLoaiMon.text.clear()
            editTextGiaTien.text.clear()
            editTextMoTa.text.clear()

            Toast.makeText(this, "Thêm món ăn thành công!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadFoodList() {

        val listFromQuanlymonan = quanlymonan.getDSFood()

        // Cập nhật foodList với danh sách lấy từ quanlymonan
        foodList.clear()
        foodList.addAll(listFromQuanlymonan)
        adapter.notifyDataSetChanged()
    }

    override fun onEdit(food: outDatacomota) {

        editTextTenMon.setText(food.tenmon)
        editTextLoaiMon.setText(food.loaiMon)
        editTextGiaTien.setText(food.giatien.toString())
        editTextMoTa.setText(food.mota)

        // Cập nhật món ăn
        btncapnhat.setOnClickListener {
            food.tenmon = editTextTenMon.text.toString()
            food.loaiMon = editTextLoaiMon.text.toString()
            food.giatien = editTextGiaTien.text.toString().toDouble()
            food.mota = editTextMoTa.text.toString()
                adapter.notifyDataSetChanged()
                cleardulieu()
                Toast.makeText(this, "Cập nhật món ăn thành công!", Toast.LENGTH_SHORT).show()
            }

    }

    override fun onDelete(food: outDatacomota) {
        quanlymonan.foodList.remove(food)
        foodList.remove(food)
        adapter.notifyDataSetChanged()
        Toast.makeText(this, "Xóa món ăn thành công!", Toast.LENGTH_SHORT).show()
    }

    private fun cleardulieu() {
        editTextTenMon.text.clear()
        editTextLoaiMon.text.clear()
        editTextGiaTien.text.clear()
        editTextMoTa.text.clear()
    }

}
