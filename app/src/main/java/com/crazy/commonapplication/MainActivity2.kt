package com.crazy.commonapplication

import android.view.MotionEvent
import android.view.ViewConfiguration
import android.widget.TextView
import com.beyondsoft.smarthome.utils.logs.LogTag
import com.crazy.baseimagegallery.base.ui.activity.BaseActivity
import com.crazy.commonapplication.databinding.ActivityMain2Binding

class MainActivity2 : BaseActivity<ActivityMain2Binding>() {

    private var index :Int = 0
    override fun getViewBinding(): ActivityMain2Binding {
        return ActivityMain2Binding.inflate(layoutInflater)
    }

    override fun initData() {

        val TV2 :TextView = findViewById(R.id.textView2)
        viewBing.textView2.setOnClickListener {
            index += 50
            viewBing.textView2.translationX = index.toFloat()
        }


    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

         val sts =ViewConfiguration.get(this).scaledTouchSlop
//        getActionMasked
        var startPositionX :Float = 0f
        var startPositionY :Float = 0f
        var spendbase  :Int = 5
        var swipbase  :Int = 50
        when (event?.actionMasked){
            MotionEvent.ACTION_DOWN->{
                startPositionX = event.rawX
                startPositionY = event.rawY
            }

            MotionEvent.ACTION_UP->{
//                startPositionX = 0f
//                index = 0
            }

            MotionEvent.ACTION_CANCEL->{
//                startPositionX = 0f
//                index = 0
            }

            MotionEvent.ACTION_MOVE->{
                var mStartPositionX = event.rawX
                var mStartPositionY = event.rawY
                viewBing.textView2.scrollBy(mStartPositionX.toInt(),mStartPositionY.toInt())

            }
        }

        return super.onTouchEvent(event)
    }

}