package id.fahrizal.test.dp

import org.junit.Assert
import org.junit.Test

class MaximumBuyStock {

    @Test
    fun test1(){
        //find max gain stock from 10,12,4,5,9
        //answer = 5 , since 4 -> 9  is the best buy and sell

        val s = IntArray(9)
        s[0] = 10
        s[1] = 12
        s[2] = 4
        s[3] = 5
        s[4] = 9
        val res = arrayChallenge(s)
        Assert.assertEquals(res, 5)
    }

    @Test
    fun test2(){
        val s = IntArray(9)
        s[0] = 44
        s[1] = 30
        s[2] = 24
        s[3] = 32
        s[4] = 35
        s[5] = 30
        s[6] = 40
        s[7] = 38
        s[8] = 15
        val res = arrayChallenge(s)
        Assert.assertEquals(res, 16)
    }

    fun arrayChallenge(arr: IntArray): Int {
        var minimum = arr[0]
        val dp = IntArray(arr.size)
        dp[0] = 0

        for (i in 1 until arr.size) {
            val curr = arr[i]

            minimum = Math.min(minimum, curr)

            if (curr > minimum) {
                dp[i] = Math.max(curr-minimum,  dp[i-1] )
            } else {
                dp[i] = dp[i - 1]
            }
        }

        return dp[arr.size-1]
    }
}