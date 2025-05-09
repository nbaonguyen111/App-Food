package vn.edu.tdc.demokotlin.nhom1

import kotlin.math.sinh

// khai bao class
data class SinhVien(val name:String,val diem:Double)

fun main(){
    println("Nhóm 1 - Chiều T3")
    println("Nhap so luong sinh vien")
    val slsv = readLine()?.toIntOrNull()?:return
    //tao list sv
    val sinhvienlsit = mutableListOf<SinhVien>()
    for (i in 1..slsv){
        println("Thong tin sinh vien")
        println("Ten: ")
        val name = readLine()?:continue
        println("Diem: ")
        val diem = readLine()?.toDoubleOrNull()?:continue
        sinhvienlsit.add(SinhVien(name,diem))
    }
    val SapXepHocSinh= SapXepTheoDiem(sinhvienlsit)
    println("Danh sach sinh vien tu cao den thap")
    for (sinhVien in SapXepHocSinh){
        println("${sinhVien.name}:${sinhVien.diem}")
    }
}
fun SapXepTheoDiem(sinhVien:List<SinhVien>):List<SinhVien>{
    return sinhVien.sortedByDescending { it.diem }
}