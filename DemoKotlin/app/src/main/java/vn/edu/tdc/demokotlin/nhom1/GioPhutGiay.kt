package vn.edu.tdc.demokotlin.nhom1

fun main()
{
    println("Nhóm 1 - Chiều T3")
    println("Nhập Số Giây:")
    val second = readLine()?.toLongOrNull()?:0
    val gio = second/3600
    val phut = (second%3600)/60
    val giay = second%60
    val timeformat = String.format("%02d:%02d:%02d",gio,phut,giay)
    println(timeformat)
}