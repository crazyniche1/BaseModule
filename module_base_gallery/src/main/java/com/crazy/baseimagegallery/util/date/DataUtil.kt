package com.crazy.baseimagegallery.util.date

import com.beyondsoft.smarthome.utils.logs.LogTag
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: DataUtil
 * Author: zy
 * Date: 2021/8/6 15:05
 * Description: 日期工具类
 * ps:
 * val calendar = DataUtil.getWeekEndDay()
        viewBing.tvTest.text = DataUtil.calToString(calendar,DataUtil.dateF1)
 * History:

 */
class DataUtil {

    companion object {

        const val dateF1= "yyyy.MM.dd"

        /**
         * day:基于今天的前几天
         */
        private fun calendarBeforeDay(day :Int): Calendar {
            val calendar = getToDay()
            calendar.add(Calendar.DATE,day)
            return calendar
        }

        /**
         * 是否是今天之后
         */
         fun getAfterToday(date: Long): Boolean {
            val calendar = Calendar.getInstance()
            val calendarC = calendar.clone() as Calendar
            calendarC.timeInMillis = date
            return calendar.before(calendarC)
        }



        /**
         *  get 昨天
         */
        fun getYesterday(): Calendar = DataUtil.calendarBeforeDay(-1)

        /**
         * get  今天
         */
        fun getToDay(): Calendar = Calendar.getInstance()

        /**
         * get  当前的年份
         */

        fun getThisYear(): Int = getToDay().get(Calendar.YEAR)
        /**
         * get  当前的月份
         */

        fun getThisMonth(): Int = getToDay().get(Calendar.MONTH)

        /**
         * 获取获取上周第一天
         */
        fun getLastWeekFirstDay(): Calendar {
            val calendar = Calendar.getInstance()
            //设置每周第一天为周日
            calendar[Calendar.DAY_OF_WEEK] = Calendar.SUNDAY
            //上周
            calendar.add(Calendar.DATE, -7)
            return calendar
        }

        /**
         * 获取获取上周最后一天
         */

        fun getLastWeekEndDay(): Calendar {
            val calendar = Calendar.getInstance()
            //设置每周第一天为周日
            calendar[Calendar.DAY_OF_WEEK] = Calendar.SUNDAY
            calendar.add(Calendar.DATE, -1)
            return calendar
        }

        /**
         * 获取获取本周第一天
         */
        fun getWeekFirstDay(): Calendar {
            val calendar = Calendar.getInstance()
            calendar[Calendar.DAY_OF_WEEK] = Calendar.SUNDAY
            return calendar
        }
        /**
         * 获取获取本周最后一天
         */
        fun getWeekEndDay(): Calendar {
            val calendar = Calendar.getInstance()
            calendar[Calendar.DAY_OF_WEEK] = Calendar.SUNDAY
            calendar.add(Calendar.DATE, 6)
            return calendar
        }



        /**
         * 获取获取本月第一天
         */
        fun getMonthFirstDay(): Calendar = getMonthFirstDay(Calendar.getInstance())

        fun getMonthFirstDay(calendar :Calendar): Calendar {
            calendar[Calendar.DAY_OF_MONTH] = 1
            return calendar
        }

        /**
         * 获取获取本月最后一天
         */
        fun getMonthEndDay(): Calendar = getMonthEndDay(Calendar.getInstance())

        fun getMonthEndDay(calendar :Calendar): Calendar {
            calendar[Calendar.DAY_OF_MONTH] = 0
            calendar.add(Calendar.MONTH, 1)
            return calendar
        }

        /**
         * 获取获取上月最后一天
         */
        fun getLastMonthEndDay(): Calendar {
            val calendar = Calendar.getInstance()
            calendar[Calendar.DAY_OF_MONTH] = 0
            return calendar
        }

        /**
         * 获取获取上月第一天
         */
        fun getLastMonthFirstDay(): Calendar {
            val calendar = Calendar.getInstance()
            calendar[Calendar.DAY_OF_MONTH] = 1
            calendar.add(Calendar.MONTH,-1)
            return calendar
        }

        /**
         * Calendar 转 string
         */
        open fun calToString(mCalendar :Calendar, pattern :String):String {
            if (mCalendar==null || pattern.isNullOrBlank()) {
                NullPointerException("请初始化时间")
            }

            val sdf = SimpleDateFormat(pattern)
            return sdf.format(mCalendar.time)
        }

        /**
         * date 转 calender
         */
        open fun dateToCalendar(data :Date):Calendar{
            if (data==null ) {
                NullPointerException("请初始化时间")
            }
            val mCalendar = Calendar.getInstance()
            mCalendar.time = data
            return mCalendar
        }

        /**
         * Long 转 calender
         */
        open fun longToCalendar(time :Long):Calendar{
            if (time==null ) {
                NullPointerException("请初始化时间")
            }
            val mCalendar = Calendar.getInstance()
            mCalendar.timeInMillis = time
            return mCalendar
        }

        /**
         * string 格式的日期转calender
         */
        open fun stringToCalendar(dataStr :String):Calendar{
            val mCalendar = Calendar.getInstance()
            val sdf = SimpleDateFormat(dateF1)

            var mDate: Date
            try {
                mDate = sdf.parse(dataStr)
            } catch (e: ParseException) {
                LogTag.e("DataUtil_stringToCalendar:$e")
                return mCalendar
            }
            mCalendar.time = mDate
            return mCalendar
        }

        /**
         * 如果需要转Long，直接使用calender.timeInMillis
         */
    }
}