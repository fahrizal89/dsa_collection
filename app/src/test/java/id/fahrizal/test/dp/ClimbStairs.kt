package id.fahrizal.test.dp

import org.junit.Assert
import org.junit.Test
import kotlin.math.*

class ClimbStairs {

    @Test
    fun run(){
//        val result = climb(5, 3)
        val result = climbStairs(4)
        println(result)
        Assert.assertEquals(5, result)
    }

    @Test
    fun runWithRedStep(){
        val redStep = listOf<Boolean>(false, true, false, true, true, false, false)
        val result = climbWithRedStep(7, 3, redStep)
        println(result)
        Assert.assertEquals(2, result)
    }

    @Test
    fun runWithMinimumCost(){
        val cost = listOf(3,2,4)
        val result = climbWithMinCost(3, cost)
        println(result)
        Assert.assertEquals(6, result)
    }

    @Test
    fun runWithMinimumCost2(){
        val cost = listOf(3,2,4)
        val result = climbWithMinCost2(3, 2, cost)
        println(result)
        Assert.assertEquals(6, result)
    }



    /*
    1. Define Problem:
        what the number of ways to get the n stairs
        k = max step
    2. Identify Base Cases & example cases:
        f[0] = 1
        f[1] = 1
        f[2] = 2
        f[3] = 3
        f[4] = 5
        f[5] = 8
    3. Write down recurrence relation or formula
        f(n) = f(n-1) + f(n-2)

    4. Whats order execution
        bottom-up
    5. Result expectation
        f(n)

     */

    fun climbStairs(n: Int): Int {
        val arr = IntArray(n+1)
        arr[0] = 1
        arr[1] = 1

        for(i in 2..n){
            arr[i] = arr[i-1]+arr[i-2]
        }

        return arr[n]
    }

    fun climb(n:Int, k :Int) : Int{
        val list = ArrayList<Int>()
        list.add(1)
        list.add(1)

        for (i in 2..n) {
            //formula: list.add(list[i-1] + list[i-2] + list[i-3])
            var ways = 0
            //iterate by k (max step)
            for(j in 1..k){
                if(i-j < 0) continue

                ways += list[i-j]
            }
            list.add(ways)
        }

        return list[n]
    }


    fun climbWithRedStep(n:Int, k :Int, rs: List<Boolean>) : Int{
        val list = ArrayList<Int>()
        list.add(1)
        list.add(1)

        for (i in 2..n) {
            var ways = 0
            for(j in 1..k){
                // i-j < 0 <-- check if step is < 0 (not valid step), because there is possibility k is greater then i
                // rs[i-j] <-- check if step is on the red step? if yes it will ignored and continue to next step
                if(i-j < 0 || rs[i-j]) continue

                ways += list[i - j]
            }
            list.add(ways)
        }

        return list[n]
    }

    /*
        1. Goals: get top stairs with minimum cost
            f(n)
        2. Cases:
        f(0) = 0
        f(1) = 3
        f(2) = 2
        f(3) = 6 <-- 0,2,4 = 6, if 0,1,3 -> 7. and 6 < 7

        3. formula:
            f(n) = P(n-1) + Min(f(n-1) , f(n-2))
           explanation:
           for calculate f(n), we need to get f(n-1) , f(n-2), because the question is find the minimum, we need to compare both of
           previous values. Not sum of 2 previous step,, but choose the 2 previous step

       4. iteration bottomUp
       5. result f(n)
     */
    private fun climbWithMinCost(n:Int, p: List<Int>) : Int{
        val arr = IntArray(n+1)
        arr[0] = 0
        arr[1] = p[0]

        for(i in 2..n){
            arr[i] = p[i-1] + min(arr[i-1], arr[i-2])
        }

        return arr[n]
    }

    private fun climbWithMinCost2(n:Int, k:Int, p: List<Int>) : Int{
        val arr = IntArray(n+1)
        arr[0] = 0
        arr[1] = p[0]

        for(i in 2..n){
            var value = 0
            for(j in 1..k){
                if(i-j< 0) continue

                value += arr[i-j]
            }

            arr[i] = value
        }

        return arr[n]
    }
}