package id.fahrizal.test

import org.junit.Test

class Sorting {

    @Test
    fun init() {
        val arr: ArrayList<Int> = arrayListOf(2,2,1,4,5,10,1,9)
//        val arr: ArrayList<Int> = arrayListOf(5,10,1,9)
        println()
        val arrB = arr.toIntArray()
        sort(arrB).forEach {
            print(","+it )
        }
        println()
    }

    fun sort(nums: IntArray): IntArray {
        for(i:Int in 0..nums.size -2){
            for(j in i+1..nums.size-1){
                val chr1 = nums[i]
                val chr2 = nums[j]
                if(chr1 > chr2) {
                    swap(nums, i, j)
                }
            }
        }
        
        return nums
    }

    private fun swap(arr:IntArray, a:Int, b:Int){
        val temp = arr[a]
        arr[a] = arr[b]
        arr[b] = temp
    }

}