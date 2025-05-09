package vn.edu.tdc.demokotlin.nhom1

fun main()
{
    println("Nhóm 1 - Chiều T3")
    println("Nhap doan van")
    val doanvan = readLine()?:return
    val tu = doanvan.trim().split("\\s+".toRegex())
    val demtu =tu.count{it.isNotEmpty()}
    println("So tu trong doan van la $demtu")
}