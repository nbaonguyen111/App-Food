package vn.edu.tdc.demokotlin.nhom1

fun main()
{
    println("Nhóm 1 - Chiều T3")
    println("Nhap kich thuoc mang")
    val size = 5
    val n = IntArray(size)
    for (i in n.indices){
        println("Nhap phan tu thu [$i]")
        n[i]= readLine()?.toIntOrNull()?:return
    }
    val min = n.min()
    val max = n.max()
    val sochan = n.filter { it%2==0 }
    val sapxep = n.sortedArray()
    println("Cac mang vua nhap ${n.joinToString(",")}")
    println("So lon nhat la $max")
    println("so nho nhat la $min")
    println("Cac so chan trong mang la ${sochan.joinToString(  "," )}")
    println("Cac so sau khi sap xep lai ${sapxep.joinToString(",")}")

}