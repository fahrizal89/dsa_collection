package id.fahrizal.test

import org.junit.Test
import java.util.Stack
import kotlin.math.pow

class Bracket {

    @Test
    fun init() {
        val stacks = Stack<Char>()
        val set = HashSet<Int>()
        set.add(1)
        set.contains(1)
        set.elementAt(0)

        val pair = Pair<Int,String>(1,"a")

        val b = Math.pow(60.0, 10.0)
        println(b)

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