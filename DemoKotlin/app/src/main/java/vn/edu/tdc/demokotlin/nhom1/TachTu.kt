package vn.edu.tdc.demokotlin.nhom1

fun main()
{
    println("Nhóm 1 - Chều T3")
    println("Nhap ten")
    val name = readLine()?:return
    val tachten = name.split(" ")
    if(tachten.isNotEmpty()){
        println("${tachten.last()}")

    }else{
        println("Khong hop le")
    }
}