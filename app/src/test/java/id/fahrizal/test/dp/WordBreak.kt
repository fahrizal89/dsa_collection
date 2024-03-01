package id.fahrizal.test.dp

import org.junit.Assert
import org.junit.Test

class WordBreak {

    @Test
    fun run1(){
        val result = wordBreak("aaaaaaaaaaaaab",
            listOf("a","aa","aaa"))
        Assert.assertEquals(false, result)
    }

    @Test
    fun run2(){
        val result = wordBreak("leetcode", listOf("leet","code"))
        Assert.assertEquals(true, result)
    }

    @Test
    fun run3(){
        val result = wordBreak("aaaaaaa", listOf("aaaa","aaa"))
        Assert.assertEquals(true, result)
    }

    @Test
    fun run4(){
        val result = wordBreak("goalspecial", listOf("go","goal","goals","special"))
        Assert.assertEquals(true, result)
    }

    @Test
    fun run5(){
        val result = wordBreak("abcd", listOf("a","abc","b","cd"))
        Assert.assertEquals(true, result)
    }

    @Test
    fun run6(){
        val result = wordBreak("catsandog", listOf("cats","dog","sand","and","cat"))
        Assert.assertEquals(false, result)
    }

    @Test
    fun run7(){
        val result = wordBreak("sanddog", listOf("cats","dog","sand","and","cat"))
        Assert.assertEquals(true, result)
    }


    /*
    fun wordBreak(s: String, wordDict: List<String>) : Boolean {
        return dfs(s, wordDict.toSet())
    }

    val cache = HashMap<String, Boolean>()

    fun dfs(s:String, set: Set<String>): Boolean {
        if(s == "") return true

        if(cache.containsKey(s)){
            return cache[s] ?: false
        }

        for (i in 1..s.length) {
            val word = s.substring(0,i)
            if(set.contains(word)) {
                val wr = s.substring(i,s.length)
                if (dfs(wr, set)){
                    cache[wr] = true
                    return true
                }
            }
        }
        cache[s] = false
        return false
    }
     */

    fun wordBreak(s: String, wordDict: List<String>) : Boolean {
        val n = s.length
        val arr = BooleanArray(n+1)
        arr[0] = true

        for (i in 1..n){ //length
            for (j in 0 until i){ //pointer
                val str = s.substring(j, i)
                if(arr[j]){
                    if(wordDict.contains(str)) {
                        arr[i] = true
                        break
                    }
                }
            }
        }

        return arr[n]
    }
}