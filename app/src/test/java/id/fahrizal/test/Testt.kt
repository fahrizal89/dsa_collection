package id.fahrizal.test

import org.junit.Test

class Testt {

    @Test
    fun init() {
        val arr: ArrayList<Int> = arrayListOf(2,2,1)
        singleNumber(arr.toIntArray())


    }

    fun singleNumber(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        val single = HashMap<Int, Int>()

        for(i:Int in 0..nums.size -1){
            val num = nums[i]
            val curr = map[num] ?: 0

            if(curr == 0) {
                map.put(num, 1)
                single.put(num, 1)
            }
            else {
                map.put(num , curr + 1)
                single.remove(num)
            }
        }

        single.forEach{ (key, value) ->
            return key
        }

        return 0
    }


}