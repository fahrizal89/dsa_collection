package id.fahrizal.test.dpmultidimention

import org.junit.Assert
import org.junit.Test
import java.util.Arrays

class MinPathSum {
    @Test
    fun test1(){
        val grid = arrayOf(
            intArrayOf(1,3,1),
            intArrayOf(1,5,1),
            intArrayOf(4,2,1)
        )
        val result = minPathSum(grid)
        Assert.assertEquals(7, result)
    }

    @Test
    fun test2(){
        val grid = arrayOf(
            intArrayOf(1,2,3),
            intArrayOf(4,5,6),
        )
        val result = minPathSum(grid)
        Assert.assertEquals(12, result)
    }

    fun minPathSum(grid: Array<IntArray>): Int {
        //create array 2D
        val dp: ArrayList<IntArray> = ArrayList()
        val maxLine = grid[0].size
        for(i in 0 until grid.size) {
            val line = IntArray(grid[i].size)
            Arrays.fill(line,Int.MAX_VALUE)
            dp.add(line)
        }
        dp[0][0] = grid[0][0]

        //start finding
        for(y in 0 until grid.size){
            for(x in 0 until maxLine){
                val curr = grid[y][x]
                val dpc = dp[y][x]
                if(x+1 < maxLine){
                    val right =grid[y][x+1]
                    val dpr = dp[y][x+1]
                    dp[y][x+1] = Math.min(dpc+right, dpr)
                }

                if(y+1 < grid.size){
                    val bottom = grid[y+1][x]
                    val dpb = dp[y+1][x]
                    dp[y+1][x] = Math.min(dpc+bottom, dpb)
                }
            }
        }


        return dp[grid.size-1][maxLine-1]
    }


    /*fun minPathSum(grid: Array<IntArray>): Int {
        var p = 0
        val maxLine = grid[0].size-1
        var maxX = maxLine


        for (i in 0 until maxLine * grid[0].size ){
            var x = 0
            var y = 0

            while (y < grid.size){
                val curr = grid[y][x]
                println(curr)
                if(x >= maxX ) {
                    y++
                    maxX = maxLine
                }
                else {
                    x++
                }

                //when landing into end od destination
                if(x >= maxLine && y >= grid.size){
                    maxX -= 1
                }
            }
        }
        return 0
    }*/
}