package com.crazy.baseimagegallery

import com.tencent.bugly.proguard.x
import com.tencent.bugly.proguard.y
import org.junit.Test

import org.junit.Assert.*
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {

        assertEquals(4, 2 + 2)
    }

    private fun  <T, R> Collection<T>.folds(initial:R,
                                            combine:(acc:R,nextElement:T) ->R ): R {
        var v = initial
        for ( el:T in this){
            v = combine(v,el)
        }
        return v
    }

    private fun String.adds(pam :(x:String,y:Int) -> String): String {

        return pam("2",1)
    }

    @Test
     fun test() {
        val list = listOf(1,2,3,4)

//        var tes = list.folds("Elements",{acc,i -> acc+""+i})
//       tes@ var tes = list.folds("Elements",
//            {acc,i ->
//            val xx =  acc+""+i
//                xx
//            })

        val xx = {x:String,y:Int -> x+y+""}
        val xxx = "xx".adds(xx)
        println(xxx)


        val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }

        fun runTransformation(f: (String, Int) -> String): String {
            return f("hello", 3)
        }
        val result = runTransformation(repeatFun) // OK

        println(result)
//
//        print("\\d+".toRegex() .matches("29"))


    }
}

class Foo (val p:Int)

