package id.fahrizal.test

import org.junit.Test

class RansomeNote {

    @Test
    fun init(){
        println(solution("aa", "aab"))
    }

    fun solution(ransomNote: String, magazine:String):Boolean{
        val map = HashMap<Char,Int>()

        for(i in 0..magazine.length-1){
            val chr = magazine[i]
            val count = map[chr] ?: 0
            map[chr] =count +1
        }

        for(i in 0..ransomNote.length-1){
            val chr = ransomNote[i]
            val count = map[chr] ?: 0

            if(count > 0){
                map[chr] = count -1
            }
            else {
                return false
            }
        }
        return true
    }




}