package vn.edu.tdc.demokotlin.nhom1

fun main()
{
    println("Nhóm 1 - Chiều 3")
    println("Nhập Chiều Dài: ")
    val cd = readLine()?.toDoubleOrNull()?:0.0
    println("Nhập Chiều Rộng: ")
    val cr = readLine()?.toDoubleOrNull()?:0.0
    val chuvi = 2*(cd+cr)
    val dientich=cd*cr
    println("Chu Vi HCN ($cd,$cr) Bằng: $chuvi")
    println("Diện Tích HCN ($cd,$cr Bằng: $dientich")
}