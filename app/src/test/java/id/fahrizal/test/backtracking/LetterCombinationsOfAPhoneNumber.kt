package id.fahrizal.test.backtracking

import org.junit.Assert
import org.junit.Test

class LetterCombinationsOfAPhoneNumber {

    val letters = HashMap<Char, String>().apply {
        put('2',"abc")
        put('3',"def")
        put('4',"ghi")
        put('5',"jkl")
        put('6',"mno")
        put('7',"pqrs")
        put('8',"tuv")
        put('9',"wxyz")
    }
    //"ad","ae","af","bd","be","bf","cd","ce","cf"

    fun letterCombinations(digits: String): List<String> {
        if(digits.isEmpty()) return emptyList()

        return find(digits,0, listOf( letters[digits.first()] ?: ""))
    }
    val memo = HashMap<Char, List<String>>()
    fun find(digits: String, idx:Int, arr:List<String>): List<String> {
        if(arr.isEmpty()) return emptyList()

        val key = digits[idx]
        if(memo.containsKey(key)) {
            return memo[key] ?: emptyList()
        }


        val node = ArrayList<String>()
        val lett = letters[key] ?: ""
        for(i in 0 until lett.length){
            if(idx +1 == digits.length){
                node.add(""+lett[i])
            }
            else {
                val nextArr = find(digits,idx + 1, arr)
                for (str in nextArr) {
                    node.add(lett[i].toString() + str)
                }
            }
        }

        memo[key] = node
        return node
    }

    @Test
    fun run1(){
        val digit = "23"
        val result = letterCombinations(digit)

        Assert.assertEquals(result.toString(), arrayListOf("ad","ae","af","bd","be","bf","cd","ce","cf").toString())
    }

    @Test
    fun run2(){
        val digit = ""
        val result = letterCombinations(digit)

        Assert.assertEquals(result.toString(), arrayListOf("").toString())
    }

    @Test
    fun run3(){
        val digit = "2"
        val result = letterCombinations(digit)

        Assert.assertEquals(result.toString(), arrayListOf("a","b","c").toString())
    }
}