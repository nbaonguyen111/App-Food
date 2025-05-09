package vn.edu.tdc.demokotlin

object quanlydoanhthu {
    val doanhThuList = mutableListOf<CartItem>()
    var tongDoanhThu: Double = 0.0


    fun addToCart(cartItem: CartItem) {
        // Kiểm tra nếu món đã tồn tại trong danh sách
        val monhientai = doanhThuList.find { it.tenmon == cartItem.tenmon }
        if (monhientai != null) {
            // Nếu đã tồn tại, cộng dồn giá tiền
            return
        } else {
            // Nếu chưa tồn tại, thêm mới vào danh sách
            doanhThuList.add(cartItem)
        }
    }


    // Cập nhật doanh thu
    fun TongDoanhThus(): Double {
        return doanhThuList.sumOf { it.giatien }
    }
}

