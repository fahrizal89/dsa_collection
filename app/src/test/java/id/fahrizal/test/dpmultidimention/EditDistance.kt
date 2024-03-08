package id.fahrizal.test.dpmultidimention

import org.junit.Assert
import org.junit.Test

class EditDistance {
    /*
      _ F L O A T
    _ 1 2 3 4 5 6
    B 2
    O 3
    A 4
    T 5
    S 6
    
     */
    fun minDistance(word1: String, word2: String): Int {
        val dp = ArrayList<IntArray>()
        val w1 = " "+word1
        val w2 = " "+word2
        for(i in 0 until w1.length){
            val x = IntArray(w2.length)
            x[0]=i
            dp.add(x)
        }

        for(i in 0 until w2.length){
            dp[0][i] = i
        }

        for(y in 1 until w1.length){
            val chr1 = w1[y]

            for (x in 1 until w2.length){
                val chr2 = w2[x]
                val corner = dp[y-1][x-1]
                val top = dp[y-1][x]
                val left= dp[y][x-1]

                val minimum = Math.min(Math.min(top, left), corner)
                if(chr1 != chr2){
                    dp[y][x]= 1+ minimum
                }
                else{
                    dp[y][x]= corner
                }
            }
        }

        return dp.last().last()
    }

    @Test
    fun test1(){
        val word1="boats"
        val word2="float"
        val result = minDistance(word1, word2)

        Assert.assertEquals(3, result)
    }

    @Test
    fun test2(){
        val word1="horse"
        val word2="ros"
        val result = minDistance(word1, word2)

        Assert.assertEquals(3, result)
    }
    @Test
    fun test3(){
        val word1="zoologicoarchaeologist"
        val word2="zoogeologist"
        val result = minDistance(word1, word2)

        Assert.assertEquals(10, result)
    }

    @Test
    fun test4(){
        val word1="zologieo"
        val word2="zogeo"
        val result = minDistance(word1, word2)

        Assert.assertEquals(3, result)
    }

    @Test
    fun test5(){
        val word1="cabbages"
        val word2="rabbit"
        val result = minDistance(word1, word2)

        Assert.assertEquals(5, result)
    }
}