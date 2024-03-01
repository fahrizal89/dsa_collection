package id.fahrizal.test.dp

import org.junit.Assert
import org.junit.Test
import java.util.Arrays

class LongestIncreasingSubsequence {

    @Test
    fun run1(){
        val param = intArrayOf(0,1,0,3,2,3)
        val result = lengthOfLIS(param)
        Assert.assertEquals(4, result)
    }

    @Test
    fun run2(){
        val param = intArrayOf(10,9,2,5,3,7,101,18)
        val result = lengthOfLIS(param)
        Assert.assertEquals(4, result)
    }

    @Test
    fun run3(){
        val param = intArrayOf(4,10,4,3,8,9)
        val result = lengthOfLIS(param)
        Assert.assertEquals(3, result)
    }

    @Test
    fun run4(){
        val param = intArrayOf(0,1,0,7,8,3,4,5,6)
        val result = lengthOfLIS(param)
        Assert.assertEquals(6, result)
    }

    @Test
    fun run5(){
        val param = intArrayOf(1,3,6,7,9,4,10,5,6)
        val result = lengthOfLIS(param)
        Assert.assertEquals(6, result)
        //expectation: 1,3,6,7,9,10
    }

    @Test
    fun run6(){
        val param = intArrayOf(0)
        val result = lengthOfLIS(param)
        Assert.assertEquals(1, result)
        //expectation: 1,3,6,7,9,10

    }

    /*
    0 1 2 3 4
    5,8,7,1,9

    dp[0] = 1
    dp[1] = 2 --> 8> 5? true, dp[1] ++
    dp[2] = 2 --> 7> 5? true, dp[2] ++, 7> 8? false
    dp[3] = 1 --> 1> 5? false. 1> 8? false, 1> 7? false
    dp[4] = 3 --> 9> 5? true, dp[4] (1) <= dp[0] (1)? true, dp[4] ++
                  9> 8? true, dp[4] (2) <= dp[1] (2)? true, dp[4] ++
                  9> 7? true, dp[4] (3) <= dp[2] (2)? false
                  9> 1? true, dp[4] (3) <= dp[3] (1)? false

    result
    dp[n]
     */
    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        Arrays.fill(dp, 1)
        var maxNum = 1
        for(i in 1 until nums.size){
            for(j in 0 until i){
                val a = nums[i]
                val b = nums[j]

                if(nums[i] > nums[j]){
                    if(dp[i] <= dp[j]){
                        dp[i]++
                    }
                }
            }
            maxNum = Math.max(dp[i], maxNum)
        }

        return maxNum
    }
}