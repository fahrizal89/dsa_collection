package id.fahrizal.test.dpmultidimention

import org.junit.Assert
import org.junit.Test

class Triangle {

    @Test
    fun test1(){
        val arr = arrayListOf<List<Int>>()
        arr.add(listOf(2))
        arr.add(listOf(3,4))
        arr.add(listOf(6,5,7))
        arr.add(listOf(4,1,8,3))

        val result = minimumTotal(arr)

        Assert.assertEquals(11, result)
    }

    @Test
    fun test2(){
        val arr = arrayListOf<List<Int>>()
        arr.add(listOf(-10))

        val result = minimumTotal(arr)

        Assert.assertEquals(-10, result)
    }
    @Test
    fun test3(){
        //[[-1],[2,3],[1,-1,-3]]
        val arr = arrayListOf<List<Int>>()
        arr.add(listOf(-1))
        arr.add(listOf(2,3))
        arr.add(listOf(1,-1,-3))

        val result = minimumTotal(arr)

        Assert.assertEquals(-1, result)
    }
    private fun minimumTotal(triangle: List<List<Int>>): Int {
        val first = triangle[0][0]

        return first + minimum(triangle, 1, 0)
    }

    private val map = HashMap<String, Int>()
    /*
    [[-1],[2,3],[1,-1,-3]]
      -1
      2 3
    1 -1 -3

    -1 ->2 -> 1 ->-1 -> 3-> -1 -> -3
     */
    private fun minimum(triangle: List<List<Int>>, lv:Int, idx:Int): Int {
        if(lv >= triangle.size) return 0

        if(map.containsKey("$lv,$idx")) {
            return map["$lv,$idx"] ?: 0
        }

        val line = triangle[lv]

        var result = Int.MAX_VALUE
        for(i in idx..idx+1){
            if(i>= line.size) break

            val num = line[i]
            val find = minimum(triangle, lv+1, i)
            val count = num + find
            result = Math.min(result, count)
        }

        map["$lv,$idx"] = result

        return result
    }
}