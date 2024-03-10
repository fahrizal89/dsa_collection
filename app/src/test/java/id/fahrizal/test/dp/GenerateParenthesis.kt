package id.fahrizal.test.dp

import org.junit.Assert
import org.junit.Test
import java.util.Stack

class GenerateParenthesis {
    /*
    n=3
    Output:
    "((()))"
    "(()())"
    "(())()"
    "()(())"
    "()()()"

     */
    val result = ArrayList<String>()

    fun generateParenthesis(n: Int): List<String> {
        recursive(n, "(")
        return result
    }


    fun recursive(n: Int, prev:String): String {
        println(prev)
        if(isBracketMax(n, prev )) return ""

        val r1 = prev + recursive(n, prev + "(")
        if(isValid(r1) && r1.length == n*2){
            if( r1.length == n*2)
                result.add(r1)

            return r1
        }

        val r2 = prev + recursive(n, prev +")")
         if(isValid(r2)){
             if(r2.length == n*2)
                result.add(r2)

             return r2
         }


        return ""
    }

    private fun isBracketMax(n:Int, str: String):Boolean{
        var ca = 0
        var cb = 0

        for(i in 0 until str.length){
            if(str[i] == '(') ca ++
            if(str[i] == ')') cb ++

            if(ca > n || cb > n) return true
        }

        return false
    }

    private fun isValid(str: String) : Boolean{
        val stack = Stack<Char>()
        for(i in 0 until str.length){
            if(str[i] == '(') {
                stack.add('(')
                continue
            }

            if(str[i] == ')'){
                if(stack.isEmpty()) return false

                if(stack.peek() != '(') return false

                stack.pop()
            }
        }

        return stack.isEmpty()
    }

    @Test
    fun test1(){
//        val valid1 = isValid("((()))")
//        val valid2 = isValid("((())(")

        val result = generateParenthesis(3)
        Assert.assertEquals("[((())),(()()),(())(),()(()),()()()]", result.toString().replace(" ",""))
    }
}