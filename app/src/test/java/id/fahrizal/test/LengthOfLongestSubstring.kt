package id.fahrizal.test

import org.junit.Test

class LengthOfLongestSubstring {

    @Test
    fun init() {
        println(lengthOfLongestSubstring(" "))
    }


    fun lengthOfLongestSubstring(s: String): Int {
        val mapChars = HashMap<String, Boolean>()
        var max = 0
        var tempMax = 0

        for(i:Int in 0..s.length-1){
            for(j:Int in (i)..s.length -1){
                // println("s:"+s.get(j))
                // println("mapChars:"+mapChars[s.get(j)])
                if(mapChars[s.get(j).toString()] ?: false){
                    mapChars.clear()
                    if(tempMax>max){
                        max = tempMax
                    }
                    tempMax=0
                }
                else {
                    tempMax += 1
                    mapChars.put(s.get(j).toString(), true)
                }
            }
        }

        return max
    }
}