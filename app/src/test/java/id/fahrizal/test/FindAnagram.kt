package id.fahrizal.test

import org.junit.Test

class FindAnagram {

    @Test
    fun init(){
        val str = "cba".split("").sorted().joinToString(separator = "")
        val map = HashMap<String,List<String>>()
        val dels = HashSet<Int>()

        dels.add(1)


        map.put("a", arrayListOf())

        dels.contains(1)
        println(str)
    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val result = ArrayList<List<String>>()
        val map = HashMap<String, ArrayList<String>>()

        for(i in 0..strs.size-1){
            val str = strs[i]
            val sortStr = sort(str)

            val list :ArrayList<String> = map[sortStr] ?: ArrayList<String>()
            list.add(str)

            map.put(sortStr, list)
        }

        map.forEach{ key, list ->
            result.add(list)
        }

        return result
    }

    private fun sort(str:String):String{
        return str.split("").sorted().joinToString(separator="")
    }


}