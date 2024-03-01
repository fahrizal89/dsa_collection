package id.fahrizal.test

import org.junit.Test

class TwoSum {

    @Test
    fun init() {
        val arr = arrayListOf(3,2,4)
        val target = 6
        val result = twoSum(arr.toIntArray(), target)

        println()
        result.forEach {
            print("$it,")
        }
        println()
    }


    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        val result = ArrayList<Int>()


        for(i:Int in 0..nums.size -1) {
            map.put(nums[i], i)
        }

        for(i:Int in 0..nums.size -2) {
            val rest = target - nums[i]
            if (map[rest] != null){
                result.add(i)
                result.add(map[rest] ?: 0)
                return result.toIntArray()
            }
        }

        return result.toIntArray()
    }
}