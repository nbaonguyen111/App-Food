package vn.edu.tdc.demokotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class foodviewmodel : ViewModel() {
    private val _foodList = MutableLiveData<MutableList<outDatacomota>>()
    val foodList: LiveData<MutableList<outDatacomota>> get() = _foodList

    init {
        // Khởi tạo danh sách món ăn (có thể lấy từ database hoặc SharedPreferences nếu cần)
        _foodList.value = mutableListOf()
    }

    // Thêm món ăn vào danh sách
    fun addFood(food: outDatacomota) {
        _foodList.value?.add(food)
        _foodList.value = _foodList.value // Cập nhật LiveData để thông báo thay đổi
    }

    // Cập nhật món ăn trong danh sách
    fun updateFood(index: Int, food: outDatacomota) {
        _foodList.value?.set(index, food)
        _foodList.value = _foodList.value // Cập nhật LiveData để thông báo thay đổi
    }

    // Xóa món ăn khỏi danh sách
    fun deleteFood(index: Int) {
        _foodList.value?.removeAt(index)
        _foodList.value = _foodList.value // Cập nhật LiveData để thông báo thay đổi
    }
}
