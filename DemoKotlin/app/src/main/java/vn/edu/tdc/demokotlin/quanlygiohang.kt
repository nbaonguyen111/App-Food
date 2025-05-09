package vn.edu.tdc.demokotlin

object quanlygiohang {
    private val cartItems = mutableListOf<CartItem>()

    fun addToCart(item: CartItem) {
        val itemhientai = cartItems.find { it.tenmon == item.tenmon }
        if (itemhientai != null) {
            itemhientai.quantity += 1 // Nếu món đã có trong giỏ thì tăng số lượng
        } else {
            cartItems.add(item)
        }
    }

    // Lấy giỏ hàng
    fun getCartItems(): MutableList<CartItem> {
        return cartItems
    }

    // Xóa món khỏi giỏ
    fun removeFromCart(item: CartItem) {
        cartItems.remove(item)
    }

    // Cập nhật số lượng món trong giỏ
    fun updateQuantity(item: CartItem, quantity: Int) {
        val cartItem = cartItems.find { it.tenmon == item.tenmon }
        cartItem?.quantity = quantity
    }

    fun getTotalQuantity(): Int {
        var total = 0
        for (item in cartItems) {
            total += item.quantity
        }
        return total
    }

    fun clearCart() {
        cartItems.clear()
    }

    fun getTotalPrice(): Double {
        var totalPrice = 0.0
        for (item in cartItems) {
            totalPrice += item.giatien * item.quantity
        }
        return totalPrice
    }



}

