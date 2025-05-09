package vn.edu.tdc.demokotlin.nhom1

import android.provider.Telephony.Mms.Part

open class NhanVien (val id:Int,val name:String,val vitri:String){
    open fun XuatThongTin(){
        println("ID $id - Name $name - Vi Tri $vitri")
    }
}
// lop ke thua
class FullTime(id: Int,name: String,vitri: String,private val LuongThang:Double): NhanVien(id,name,vitri)
{
    override fun XuatThongTin() {
        super.XuatThongTin()
        println("Luong Thang: $LuongThang Luong ${TinhLuong()}")
    }
    fun TinhLuong():Double{
        return LuongThang*12
    }
}
class PartTime(id: Int,name: String,vitri: String,private val TyLe:Double,private val GioLam:Int):NhanVien(id,name,vitri){
    override fun XuatThongTin() {
        super.XuatThongTin()
        println("Ty Le $TyLe - Gio Lam $GioLam - Luong ${TinhLuong()}")
    }
    fun TinhLuong():Double{
        return TyLe*GioLam
    }
}

fun main()
{
    println("Nhóm 1 - Chiều T3")
    val nhanvien = mutableListOf<NhanVien>()
    while(true){
        println("----------------Menu--------------")
        println("1. Them Nhan Vien Full Time")
        println("2. Them Nhan Vien Part Time")
        println("3. Xuat")
        println("4. Thoat")
        println("Chon chuc nang (1-4)")
        when(readLine()){
            "1"->{
                println("Nhap ID: ")
                val id = readLine()?.toIntOrNull()?:return
                println("Nhap Ten: ")
                val name = readLine()?:return
                println("Nhap vi tri: ")
                val vitri= readLine()?:return
                println("Nhap Luong Thang: ")
                val luongthang = readLine()?.toDoubleOrNull()?:return
                nhanvien.add(FullTime(id,name,vitri,luongthang))
            }
            "2"->{
                println("Nhap ID: ")
                val id = readLine()?.toIntOrNull()?:return
                println("Nhap Ten: ")
                val name = readLine()?:return
                println("Nhap vi tri: ")
                val vitri= readLine()?:return
                println("Nhap Ty Le")
                val tyle = readLine()?.toDoubleOrNull()?:return
                println("Nhap gio lam")
                val giolam = readLine()?.toIntOrNull()?:return
                nhanvien.add(PartTime(id,name,vitri,tyle,giolam))
            }
            "3"->{
                println("Thong Tin Nhan Vien")
                for (nv in nhanvien){
                    nv.XuatThongTin()
                }
            }
            "4"->{
                println("Thoat")
                return
            }
        }
    }
}