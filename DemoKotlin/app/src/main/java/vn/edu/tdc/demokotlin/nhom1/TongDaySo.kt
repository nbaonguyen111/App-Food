package vn.edu.tdc.demokotlin.nhom1

fun main()
{
    println("Nhóm 1 - Chiều T3")
    println("Nhập số")
    val n = readLine()?.toIntOrNull()?:return println("Giá trị không hợp lệ")
    var sum = 0
    var x =" "
    for (i in 1 ..n){

        sum +=i
        if(i==n){
            x+="$i"
        }else{
            x+="$i +"
        }

    }
    println("Tổng các số từ 1 đến $n là: $x = $sum ")


}