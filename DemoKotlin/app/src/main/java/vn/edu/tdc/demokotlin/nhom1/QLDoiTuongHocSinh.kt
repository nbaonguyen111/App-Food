package vn.edu.tdc.demokotlin.nhom1

open class Person(val name :String,val age:Int){
    open fun Printinfo(){
        println("Name $name - Tuoi $age")
    }
}
class Student(name: String,age: Int,private val id:String,private val grade:Double):Person(name,age){
    override fun Printinfo() {
        super.Printinfo()
        println("ID Student $id - Lop $grade ")
    }

}
fun main(){
    val hs = mutableListOf<Person>()
    while(true) {
        println("Nhóm 1 - Chiều T3")
        println("1.Them Hoc Sinh")
        println("2.Xuat")
        println("3.Thoat")
        when(readLine()){
            "1"->{
                println("Ten: ")
                val name = readLine()?:return
                println("Tuoi: ")
                val age = readLine()?.toIntOrNull()?:return
                println("ID: ")
                val id = readLine()?:return
                println("Lop: ")
                val grade = readLine()?.toDoubleOrNull()?:return
                hs.add(Student(name,age,id,grade))
            }
            "2"->{
                for (student in hs){
                    student.Printinfo()
                }
            }
            "3"->{
                println("Thoat")
                return
            }
        }
    }
}