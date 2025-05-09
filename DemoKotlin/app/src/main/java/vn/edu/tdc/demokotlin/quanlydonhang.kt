package vn.edu.tdc.demokotlin

object quanlydonhang {
    private val orders = mutableListOf<Order>() // Danh sách đơn hàng

    fun addOrder(order: Order) {
        orders.add(order)
    }

    fun getOrders(): List<Order> {
        return orders
    }

    fun getOrderById(id: String): Order? {
        return orders.find { it.id == id }
    }

    fun updateOrderStatus(id: String, newStatus: String) {
        val order = getOrderById(id)
        order?.status = newStatus
    }
}
