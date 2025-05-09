package vn.edu.tdc.demokotlin.nhom1

fun main()
{
    println("Nhóm 1 - Chiều T3")
    println("Nhap kich thuoc mang")
    val size = readLine()?.toIntOrNull()?:return
    val n = IntArray(size)
    for (i in 0 until size) {
    println("Nhap phan tu thu [$i]")
        n[i]= readLine()?.toIntOrNull()?:return
    }
    println("Mang da nhap la ${n.joinToString(",")}")
    val tong = n.sum()
    val trungbinh=n.average()
    println("tong cac phan tu trong mang $tong")
    println("trung binh cac phan tu trong mang $trungbinh")
}