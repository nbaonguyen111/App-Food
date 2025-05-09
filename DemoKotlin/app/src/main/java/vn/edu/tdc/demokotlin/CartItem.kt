package vn.edu.tdc.demokotlin

data class CartItem(

    val tenmon: String?,
    var giatien: Double,
    val image: Int,
    var quantity: Int = 1 // Số lượng món trong giỏ

)

