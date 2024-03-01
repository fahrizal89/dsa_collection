package id.fahrizal.test.dp

import org.junit.Assert
import org.junit.Test

class MinCostClimbingStairs {
    /*
    10,15,20
    dp[3]=0,0+20 =20
    dp[2]=20,0->0+15=15
    dp[1]=15,20->15+10=25
    dp[0]=15,25->15

    0  1  2 3 4  5  6 7  8  9
    1,100,1,1,1,100,1,1,100,1
    0,2,4,5,7,9

    dp[9]=0,0+1=1
    dp[8]=0,1 -> 1+100=101
    dp[7]=101,1->1+1 =2
    dp[6]=2,100->2+1=3
    dp[5]=3,2=>2+1=3
    dp[4]=3,3->3+1=4
    dp[3]=4,3=>3+1=4
    dp[2]=4,4->4+1=5
    dp[1]=5,4->4+100=104
    dp[0]=104,5->5+1=6


     */
    fun minCostClimbingStairs(cost: IntArray): Int {
        val dp = IntArray(cost.size+3)
        dp[cost.size+2] = 0
        dp[cost.size+1] = 0

        for(i in cost.size-1 downTo 0){
            dp[i]= Math.min(dp[i+1], dp[i+2]) + cost[i]
        }

        return Math.min(dp[0],dp[1])
    }

    @Test
    fun test1(){
        val result = minCostClimbingStairs(intArrayOf(10,15,20))
        Assert.assertEquals(15,result)
    }

    @Test
    fun test2(){
        val result = minCostClimbingStairs(intArrayOf(1,100,1,1,1,100,1,1,100,1))
        Assert.assertEquals(6,result)
    }
}