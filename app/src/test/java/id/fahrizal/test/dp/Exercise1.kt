package id.fahrizal.test.dp

import org.junit.Assert
import org.junit.Test

class Exercise1 {

    @Test
    fun init(){
        val result = sum(5)
        println(result)
        Assert.assertEquals(15, result)
    }

    fun sum(n:Int) : Int{
        val list = ArrayList<Int>()
        list.add(0)

        for (i in 1..n) {
            list.add(list[i-1] + i)
        }

        return list[n]
    }
}