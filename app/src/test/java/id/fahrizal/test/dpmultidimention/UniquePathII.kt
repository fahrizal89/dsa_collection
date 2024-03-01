package id.fahrizal.test.dpmultidimention

import org.junit.Assert
import org.junit.Test

class UniquePathII {

    @Test
    fun test1(){
        val path = arrayOf(
            intArrayOf(0,0,0),
            intArrayOf(0,1,0),
            intArrayOf(0,0,0),
        )
        val result = uniquePathsWithObstacles(path)
        Assert.assertEquals(2,result)
    }

    @Test
    fun test2(){
        val path = arrayOf(
            intArrayOf(0,1),
            intArrayOf(0,0),
        )
        val result = uniquePathsWithObstacles(path)
        Assert.assertEquals(1,result)
    }

    @Test
    fun test3(){
        val path = arrayOf(
            intArrayOf(0,0,0,0),
            intArrayOf(0,1,0,0),
            intArrayOf(0,0,0,0),
        )
        val result = uniquePathsWithObstacles(path)
        Assert.assertEquals(4,result)
    }
    /*
    0 0 0
    0 1 0
    0 0 0

    goals max way to visit dp(max_x, max_y)

    approach
    DP bottomUp

    solution: visit every field, cek left and top
    dp[0,0] = 1
    dp[0,1] = 2 -> 1+ top = 0, left = 1
    dp[0,2] = 3 -> 1+ top = 0, left = 2
    dp[1,0] = 2 -> 1+top = 1, left = 0
    dp[1,1] = 0 -> skip
    dp[1,2] = 3 -> 1+ top = 2, left =0
    dp[2.0] = 2 -> 1+ top =2 left = 0
    dp[2,1] = 3 -> 1+top =0, left = 2
    dp[2,2] = 4 = 1+ min(top=3, left=3)

     */
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val dp = Array(obstacleGrid.size) { IntArray(obstacleGrid[0].size)}


        for(y in 0 until obstacleGrid.size){
            val line = obstacleGrid[y]

            for(x in 0 until line.size){
                if(y==0 && x == 0) {
                    dp[0][0] = 1
                    continue
                }

                if(obstacleGrid[y][x] == 1) {
                    dp[y][x] = 0
                    continue
                }

                val left = if(x-1 <0) 0 else dp[y][x-1]
                val top = if(y-1 < 0) 0 else dp[y-1][x]

                dp[y][x] = left+ top
            }
        }

        return dp.last().last()
    }
}