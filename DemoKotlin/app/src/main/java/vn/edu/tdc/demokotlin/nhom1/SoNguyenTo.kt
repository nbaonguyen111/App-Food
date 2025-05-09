package vn.edu.tdc.demokotlin.nhom1

fun main() {
    println("Nhóm 1 - Chiều T3")
    println("Nhập Số")
    val n = readLine()?.toIntOrNull() ?: return println("Giá trị không hợp lệ")
if(isprime(n)){
    println("$n là số nguyên tố")
}else{
    println("$n không phải số nguyên tố")
}
}

fun isprime(n:Int):Boolean
{
if(n<=1){
    return false
}else{
    for (i in 2..Math.sqrt(n.toDouble()).toInt())
    {
        if(n%i==0){
            return false
        }

    }
    return  false
}
}

