package id.fahrizal.test.dp

import org.junit.Assert
import org.junit.Test
import kotlin.math.max

class HouseRobber {

    @Test
    fun start(){
        val result1 = rob(intArrayOf(1,2,3,1))
        println(result1)
        Assert.assertEquals(4, result1)

        val result2 = rob(intArrayOf(2,7,9,3,1))
        println(result2)
        Assert.assertEquals(12, result2)

        val result3 = rob(intArrayOf(2,1,1,2))
        println(result3)
        Assert.assertEquals(4, result3)
    }

    /*
    goals: f(n)
    base case:
    f(0) = 1
    f(1) = 1
    f(2) = 2 + max(1) = 3
    f(3) = 3 + f(n-2) = 3 + 1 = 4
    f(4) = 1 + 2 = 4


    f(0) = 1
    f(1) = 2
    f(2) = 7
    f(3) = 9 + 2
    f(4) = 3 + 7
    f(5) = 1 + 9 + 2 = 12

    2,1,1,2
    f(0) = 0
    f(1) = 2
    f(2) = 1
    f(3) = 1+ 2
    f(4) = 2+2 -> f(n) + max(f(n-2),f(n-3))

    formula:
    f(n) = f(n) + max(f(n-2),f(n-3))

    iteration bottomUp

    result: max(f)
     */
//    private fun rob(nums: IntArray): Int {
//        val arr = IntArray(nums.size+1)
//
//        arr[0] = 0
//        arr[1] = nums[0]
//
//        for(i in 2..nums.size){
//            val sum = nums[i-1] + arr[i-2]
//            arr[i] = max(sum, arr[i-1])
//        }
//
//        return arr.last()
//    }

    private fun rob(nums: IntArray): Int {
        var prev2 = 0
        var prev1 = nums[0]

        for(i in 2..nums.size){
            val sum = nums[i-1] + prev2
            prev2 = prev1
            prev1 = max(sum, prev1)
        }

        return prev1
    }
}