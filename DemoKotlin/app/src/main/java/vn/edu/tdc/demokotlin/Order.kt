package vn.edu.tdc.demokotlin

data class Order(
    val id: String,
    val foodname: List<String?>,
    val customerName: String,
    val phone: String,
    val address: String,
    val note: String?,
    val items: List<CartItem>, // Danh sách sản phẩm trong đơn hàng
    val totalPrice: Double,
    var status: String // Trạng thái đơn hàng (VD: Đang xử lý, Hoàn thành)
)
