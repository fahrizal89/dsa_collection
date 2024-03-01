package id.fahrizal.test.dpmultidimention

import org.junit.Assert
import org.junit.Test
import java.lang.StringBuilder

class InterleavingString {
    /*
        val s1="aabc"
        val s2="abad"
        val s3="aabadabc"
     */
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val result = find(s1,s2,s3,s1.length-1,s2.length-1, s3.length-1)

        return result
    }
    val map = HashMap<String, Boolean>()

    fun find(s1: String, s2: String, s3: String, p1:Int, p2:Int, p3:Int): Boolean {
        if(p3 <0) {
            return p1<0 && p2<0
        }

        if(map.containsKey("$p1,$p2")){
            return map["$p1,$p2"] ?: false
        }

        val chr1= if(p1<0) '-' else s1[p1]
        val chr2= if(p2<0) '-' else s2[p2]
        val chr3=s3[p3]

        val r1 = chr1 == chr3 && find(s1,s2,s3,p1-1,p2,p3-1)
        val r2 = !r1 && chr2 == chr3 && find(s1,s2,s3,p1,p2-1,p3-1)

        map["$p1,$p2"] = r1||r2

        return r1 || r2
    }

    @Test
    fun test1(){
        val s1="aabc"
        val s2="abad"
        val s3="aabadabc"
        val result = isInterleave(s1,s2,s3)
        /*
        c-s1 aab, abad
        b-s1 aa, abad
        a-s1 a, abad
        d-s2 a, aba
        a-s1 a, ab
        b-s2 a, a
        a-s1  , a
        a-s2  ,
         */
        Assert.assertEquals(true, result)
    }

    @Test
    fun test2(){
        val s1="a"
        val s2="b"
        val s3="a"
        val result = isInterleave(s1,s2,s3)

        Assert.assertEquals(false, result)
    }

    @Test
    fun test3(){
        val s1=""
        val s2=""
        val s3="a"
        val result = isInterleave(s1,s2,s3)

        Assert.assertEquals(false, result)
    }

    @Test
    fun test4(){
        val s1="a"
        val s2=""
        val s3="a"
        val result = isInterleave(s1,s2,s3)

        Assert.assertEquals(true, result)
    }

    @Test
    fun test5(){
        val s1="aabc"
        val s2="abad"
        val s3="aabcabad"
        val result = isInterleave(s1,s2,s3)
        /*
        d->s2
        a->s2
        b-s2
        a->s2
        c->s1
        b->s1
        a->s1
        a->s1
        */
        Assert.assertEquals(true, result)
    }

    @Test
    fun test6(){
        val s1="a"
        val s2="b"
        val s3="ba"
        val result = isInterleave(s1,s2,s3)

        Assert.assertEquals(true, result)
    }

    @Test
    fun test7(){
        val s1="aabcc"
        val s2="dbbca"
        val s3="aadbbcbcac"
        val result = isInterleave(s1,s2,s3)
        /*
        c->s1
        a->s2
        c->s1
        b->s1
        c->s2
        b->s2
        b->s2
        d->s2
        a->s1
        a->s1
         */
        Assert.assertEquals(true, result)
    }
    @Test
    fun test8(){
        val s1="ab"
        val s2="bc"
        val s3="bbac"
        val result = isInterleave(s1,s2,s3)
        /*
        b-s1 a,bc
        a-s1  ,bc
        b-??
         */
        Assert.assertEquals(false, result)
    }

    @Test
    fun test9(){
        val s1="aa"
        val s2="bb"
        val s3="abab"
        val result = isInterleave(s1,s2,s3)
        /*
        b-s2 aa,b
        a-s1 a,b
        b-s2 a,
        a-s1  ,
         */

        Assert.assertEquals(true, result)
    }

    @Test
    fun test10(){
        val s1="a"
        val s2="b"
        val s3="aba"
        val result = isInterleave(s1,s2,s3)

        Assert.assertEquals(false, result)
    }

    @Test
    fun test11(){
        val s1="a"
        val s2="b"
        val s3="ab"
        val result = isInterleave(s1,s2,s3)

        Assert.assertEquals(true, result)
    }

    @Test
    fun test12(){
        val s1="aa"
        val s2="ab"
        val s3="abaa"
        val result = isInterleave(s1,s2,s3)
    /*
    a-s1
    a-s1
    b-s2
    a-s2
     */
        Assert.assertEquals(true, result)
    }

    @Test
    fun test13(){
        val s1="aaaaaaaaaaaaaaaaaaaaaaaaaaa"
        val s2="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        val s3="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        val result = isInterleave(s1,s2,s3)
        Assert.assertEquals(false, result)
    }



}