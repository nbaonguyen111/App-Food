package vn.edu.tdc.demokotlin.nhom1

import kotlin.math.sqrt

fun main()
{
    println("Nhóm 1 - Chiều T3")
    println("Nhập a")
    val a = readLine()?.toDoubleOrNull()?: return println("Giá trị không hợp lệ")
    println("Nhập b")
    val b = readLine()?.toDoubleOrNull()?:return println("Giá trị không hợp lệ")
    println("Nhập c")
    val c = readLine()?.toDoubleOrNull()?:return println("Giá trị không hợp lệ")
    val delta = b*b-4*a*c
    when{
        a==0.0 ->{
            if(b==0.0){
                println("Phương trình vô nghiệm")
            }else {
                val x = -c/b
                println("phương trình có một nghiệm: x = $x")
            }
        }
        delta >0 -> {
            val x1=(-b + sqrt(delta))/(2*a)
            val x2 =(-b -sqrt(delta))/(2*a)
            println("Phương trình có hai nghiệm phân biệt x1 = $x1,x2 = $x2")
        }
        delta ==0.0 ->{
            val x =-b/(2*a)
            println("Phương trình có nghiệm kép: x = $x")
        }
        else ->{
            println("Phương trình không có nghiệm thực")
        }
    }

}