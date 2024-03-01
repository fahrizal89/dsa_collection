package id.fahrizal.test.dpmultidimention

import org.junit.Assert
import org.junit.Test

class LongestPalindrome {

    @Test
    fun test1(){
        val s = "cbbd"
        val result = longestPalindrome(s)
        Assert.assertEquals("bb", result)
    }

    @Test
    fun test2(){
        val s = "babad"
        val result = longestPalindrome(s)
        Assert.assertEquals("bab", result)
    }

    @Test
    fun test3(){
        val s = "a"
        val result = longestPalindrome(s)
        Assert.assertEquals("a", result)
    }

    @Test
    fun test4(){
        val s = "bb"
        val result = longestPalindrome(s)
        Assert.assertEquals("bb", result)
    }
    /*
    cbbd
    dp[0] = c
     */
    fun longestPalindrome(s: String): String {
        var max = -1
        var longpal = s
        for(i in 1 .. s.length){
            for(j in 0 until i){
                val chr = s.substring(j,i)
                val pal= maxPalindrome(chr)
                if(pal > max){
                    longpal = chr
                    max = pal
                }

            }
        }

        return longpal
    }

    private fun maxPalindrome(s:String):Int {
        for(i in 0 until  s.length/2){
            val f= s[i]
            val e = s[s.length-1 - i]

            if(f != e) return -1
        }
        return s.length
    }
}