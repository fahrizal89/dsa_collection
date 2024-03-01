package id.fahrizal.test.dp

import org.junit.Assert
import org.junit.Test

class Fibonacci {

    @Test
    fun init(){
        val result = fib(9)
        println(result)
        Assert.assertEquals(34, result)
    }

    fun fib(n: Int): Int {
        val list = ArrayList<Int>()
        list.add(0)
        list.add(1)

        if(n < 2 )return  list[n]


        for(i in 2..n){
            val result = list[i-1] + list[i-2]
            list.add(result)
        }


        return list[n]
    }
}