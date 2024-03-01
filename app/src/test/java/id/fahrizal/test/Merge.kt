package id.fahrizal.test

import org.junit.Test

class Merge {

    @Test
    fun test(){
        val s = intArrayOf(4,5,6,0,0,0)
        merge(s,3, intArrayOf(1,2,3),3)

        println()
        s.forEach {
            print(","+it)
        }
        println()
    }

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var idx=0
        //add nums2 to nums1
        for(i in m..nums1.size-1){
            nums1[i] = nums2[idx]
            idx++
        }

        //sorting
        for(i in 0..nums1.size-1){
            val chr1 = nums1[i] //4

            for(j in i+1..nums1.size-1){
                val chr2 = nums1[j] //1
                if(chr1 > chr2){
                    swap(nums1, i, j)
                }
            }
        }
    }

    fun swap(nums:IntArray,i:Int, j:Int){
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}