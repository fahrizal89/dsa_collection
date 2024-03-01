package id.fahrizal.test

import org.junit.Test

class Test2 {

    @Test
    fun abc(args: Array<String?>?) {
        // keep this function call here
        val s = IntArray(7)
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
        println(res)
    }

    fun arrayChallenge(arr: IntArray): Int {
        // code goes here
        var maximum = 0
        val dp = IntArray(arr.size + 1)
        dp[0] = 0
        maximum = 0
        for (i in 1 until arr.size) {
            val curr = arr[i]
            val prev = arr[i - 1]
            if (curr > dp[i - 1]) {
                dp[i] = curr - prev + dp[i - 1]
            } else {
                dp[i] = dp[i - 1]
            }
        }
        return dp[arr.size]
    }

    fun ArrayChallenge(arr: IntArray): Int {
        // code goes here
        var maximum = 0
        val dp = IntArray(arr.size + 1)
        dp[0] = 0
        maximum = 0
        for (i in 1 until arr.size) {
            val curr = arr[i]
            val prev = arr[i - 1]
            if (curr > dp[i - 1]) {
                dp[i] = curr - prev + dp[i - 1]
            } else {
                dp[i] = dp[i - 1]
            }
        }
        return dp[arr.size]
    }
}