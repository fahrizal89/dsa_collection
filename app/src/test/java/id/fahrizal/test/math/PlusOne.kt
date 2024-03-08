package id.fahrizal.test.math

import org.junit.Assert
import org.junit.Test

class PlusOne {

    fun plusOne(digits: IntArray): IntArray {
        digits[digits.size-1] = digits[digits.size-1] +1

        for(i in digits.size -1 downTo 0){
            if(digits[i] >= 10){
                digits[i] = 0
                if(i>0){
                    digits[i-1] = digits[i-1] + 1
                }
            }
            else {
                digits[i] = digits[i]
                return digits
            }
        }

        if(digits.first() == 0){
            val arr = IntArray(digits.size+1)
            arr[0] = 1
            for(i in 1 until digits.size){
                arr[i] = digits[i]
            }
            return arr
        }

        return digits
    }

    @Test
    fun test1(){
        val result = plusOne(intArrayOf(9,9))
        Assert.assertEquals("[1,0,0]", result.toList().toString().replace(" ",""))
    }
    @Test
    fun test2(){
        val result = plusOne(intArrayOf(8,9,9,9))
        Assert.assertEquals("[9,0,0,0]", result.toList().toString().replace(" ",""))
    }
}