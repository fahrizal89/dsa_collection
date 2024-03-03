package id.fahrizal.test.twopointers

import org.junit.Assert
import org.junit.Test

class ContainerWithMostWater {

    fun maxArea(height: IntArray): Int {
        var maximum = 0
        var maxRight = 0

        for (i in height.size-1 downTo 1){
            val right = height[i]
            if(right < maxRight) continue
            maxRight = Math.max(maxRight,right)

            for(j in 0 until i){
                val left = height[j]

                val width = i-j

                val water = Math.min(left, right)
                //maximum = Math.max(maximum, water* width)
                if(water* width > maximum){
                    maximum = water * width
                }
            }
        }

        return maximum
    }

    @Test
    fun test1(){
        val param = intArrayOf(1,8,6,2,5,4,8,3,7)
        val result = maxArea(param)

        Assert.assertEquals(49, result)
    }

    @Test
    fun test2(){
        val param = intArrayOf(1,1)
        val result = maxArea(param)

        Assert.assertEquals(1, result)
    }

    @Test
    fun test3(){
        val param = intArrayOf(4,3,2,1,4)
        val result = maxArea(param)

        Assert.assertEquals(16, result)
    }
    @Test
    fun test4(){
        val param = intArrayOf(2,1)
        val result = maxArea(param)

        Assert.assertEquals(1, result)
    }

    @Test
    fun test5(){
        val param = intArrayOf(1,2,1)
        val result = maxArea(param)

        Assert.assertEquals(2, result)
    }

    @Test
    fun test6(){
        val param = intArrayOf(1,2)
        val result = maxArea(param)

        Assert.assertEquals(1, result)
    }

    @Test
    fun test7(){
        val param = intArrayOf(2,3,10,5,7,8,9)
        val result = maxArea(param)

        Assert.assertEquals(36, result)
    }
    @Test
    fun test8(){
        val param = intArrayOf(2,3,4,5,18,17,6)
        val result = maxArea(param)

        Assert.assertEquals(17, result)
    }

    /*
    11,0,11,5,11,13,8 -> 8*6  = 48
    11,0,11,5,11,13,8 -> 11*5 = 55
     */
    @Test
    fun test9(){
        val param = intArrayOf(4,4,2,11,0,11,5,11,13,8)
        val result = maxArea(param)

        Assert.assertEquals(55, result)
    }
}