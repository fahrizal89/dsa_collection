package id.fahrizal.test

import org.junit.Test

class IntToRomanTest {
    var result = ""
    val symb = ArrayList<Pair<Int, String>>().apply {
        add(Pair(1000, "M"))
        add(Pair(500, "D"))
        add(Pair(100, "C"))
        add(Pair(50, "L"))
        add(Pair(10, "X"))
        add(Pair(5, "V"))
        add(Pair(1, "I"))
    }


    @Test
    fun start(){
        println("result: "+intToRoman(58))
        result =""
        println("result: "+intToRoman(3))
        result =""
        println("result: "+intToRoman(1994))

//        println(modzero(900))
//        println(modzero(4))
    }


    fun intToRoman(num: Int): String {



        val arr = getLitSimpleNum(num)

        for(i:Int in 0..arr.size-1){
            val n = arr[i]
            println("n:"+n)

            for (j:Int in 0..symb.size-1){
                if(n >= symb[j].first){
                    if(n ==  symb[j].first) {
                        result += symb[j].second
                        break
                    }
                    val res = modzero(n)

                    if(res.isNotEmpty()){
                        result += modzero(n)
                        break
                    }

                    val vn = symb[j].first


                    result += symb[j].second
                    arr[i] = n-vn
                    intToRoman(n-vn)
                    break
                }
            }
        }

        return result
    }

    private fun getLitSimpleNum(num: Int):ArrayList<Int>{
        val arr = ArrayList<Int>()
        var numStr = num.toString()

        for(i:Int in 0..numStr.length -1){
            val chr = numStr[i].toString()
            var calc = ((numStr.length - i) -1)
            if(calc == 0) 1 else calc

            val newNum = chr.toInt() * Math.pow(10.0, calc.toDouble())
            arr.add(newNum.toInt())
        }

        return arr
    }

    private fun modzero(num:Int) : String{
        for(i:Int in 0..symb.size-1){

            if (num <  symb[i].first){
                for(j:Int in i+1..symb.size -1){
                    if(symb[i].first - symb[j].first == num){
                        println(symb[j].second + symb[i].second)
                        return symb[j].second + symb[i].second
                    }
                }

            }
        }

        return ""
    }
}