package com.crazy.baseimagegallery

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.beyondsoft.smarthome.utils.logs.LogTag

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
//        assertEquals("com.crazy.baseimagegallery", appContext.packageName)
    }

    @Test
    fun test (){
        val envMap = System.getenv()
        for ((k,v) in envMap){

            LogTag.d("this is the test:${k+v}")
        }


    }
}