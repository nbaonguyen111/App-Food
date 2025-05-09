package vn.edu.tdc.demokotlin.nhom1

fun main(){

    println("Nhom 1 - Chiều Thứ 3")
    println("Nhập Số Thứ Nhất : ")
    val a = readLine()?.toIntOrNull()?:0
    println("Nhập Số Thứ Hai : ")
    val b = readLine()?.toIntOrNull()?:0
    val tong=a+b
    println(" Tổng ($a + $b) bằng : $tong")

}