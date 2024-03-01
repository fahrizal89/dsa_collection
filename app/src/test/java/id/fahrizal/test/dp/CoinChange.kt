package id.fahrizal.test.dp

import org.junit.Assert
import org.junit.Test
import java.util.Arrays


class CoinChange {

    @Test
    fun test1(){
        val result = coinChange(intArrayOf(1,2), 2)
        Assert.assertEquals(1, result)
    }

    @Test
    fun test2(){
        val result = coinChange(intArrayOf(1,2), 3)
        Assert.assertEquals(2, result)
    }

    @Test
    fun test3(){
        val result = coinChange(intArrayOf(1,3,4,5), 7)
        Assert.assertEquals(2, result)
    }

    @Test
    fun test4(){
        val result = coinChange(intArrayOf(1), 3)
        Assert.assertEquals(3, result)
    }

    @Test
    fun test5(){
        val result = coinChange(intArrayOf(1,2,5), 11)
        Assert.assertEquals(3, result)
    }

    @Test
    fun test6(){
        val result = coinChange(intArrayOf(2), 3)
        Assert.assertEquals(-1, result)
    }

    @Test
    fun test7(){
        val result = coinChange(intArrayOf(1), 0)
        Assert.assertEquals(0, result)
    }

    @Test
    fun test8(){
        val result = coinChange(intArrayOf(1,2,4), 6)
        Assert.assertEquals(2, result)
    }

    @Test
    fun test9(){
        val result = coinChange(intArrayOf(3,4), 7)
        Assert.assertEquals(2, result)
    }


    lateinit var cache : IntArray
    fun coinChange(coins: IntArray, amount: Int): Int {
        cache = IntArray(amount+1)
        Arrays.fill(cache, -1)
        val result = cc(coins, amount)

        return if(result == Int.MAX_VALUE) -1 else result
    }
    fun cc(coins: IntArray, amount: Int): Int {
        if(amount == 0) return 0

        if(amount < 0) return Int.MAX_VALUE

        if (cache[amount] >= 0) return cache[amount]

        var minCoin = Int.MAX_VALUE
        for(coin in coins){
            val left = amount - coin
            val sum = cc(coins, left)
            if(left >= 0 && sum != Int.MAX_VALUE) {
                minCoin = Math.min(minCoin, 1 + sum)
                cache[amount] = minCoin
            }

        }

        return minCoin
    }

    //top down
    /*lateinit var cache: IntArray

    fun coinChange(coins: IntArray, amount: Int): Int {
        cache = IntArray(amount + 1)
        Arrays.fill(cache, -1)
        val ans: Int = rec(coins, amount)
        return if (ans == Int.MAX_VALUE) -1 else ans
    }

    fun rec(coins: IntArray, amount: Int): Int {
        if (amount == 0) {
            return 0
        }
        if (amount < 0) {
            return Int.MAX_VALUE
        }
        if (cache.get(amount) != -1) {
            return cache.get(amount)
        }
        var minCoins = Int.MAX_VALUE
        for (coin  in coins) {
            val sum = rec(coins, amount - coin)
            if (sum != Int.MAX_VALUE) {

                //+1 because we already do calculation of amount minus coin, it means we already spend 1 coin
                minCoins = Math.min(minCoins, 1 + sum)
            }
        }
        cache[amount] = minCoins
        return minCoins
    }
    */


    //bottom up
//    fun coinChange(coins: IntArray, amount: Int): Int {
//        val arr = IntArray(amount +1)
//        arr[0] = 0
//
//        for(i in 1 .. amount){
//            arr[i] = Int.MAX_VALUE
//
//            for(coin in coins){
//                if(coin <= i && arr[i - coin] != Int.MAX_VALUE){
//                    arr[i] = Math.min(arr[i], 1+ arr[i-coin])
//                }
//            }
//        }
//
//        if(arr[amount] == Int.MAX_VALUE)
//            return -1
//
//        return arr[amount]
//    }

//    val cache = HashMap<Int, HashMap<Int, Int>>()
//
//    fun coinChange(coins: IntArray, amount: Int): Int {
//        if(amount ==0) return 0
//        return cc(coins, amount,0)
//    }
//
//    fun cc(coins: IntArray, amount: Int, count:Int): Int {
//        if(amount == 0) {
//            return count
//        }
//        if(amount < 0) return -1
//
//        var totaldeep = 999999999
//        for(coin in coins) {
//            val left = amount - coin
//
//
//            val sum = cc(coins, left, count+1)
//
//            if(sum < 0)  continue
//
//            if(sum >0) {
//                totaldeep = Math.min(totaldeep, sum)
//            }
//
//        }
//
//        val result = if(totaldeep == 999999999) -1 else totaldeep
//        return result
//    }


}