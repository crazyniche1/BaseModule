package com.crazy.baseimagegallery.util.date;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author xzk
 * @data 2019/9/25
 * @email xiezhengkun@beyondsoft.com
 * @remark  日历组件
 */
public class BasisTimesUtils {
    private static DatePickerDialog mDatePickerDialog;//日期选择器

    /**
     * 今天以后
     */

    public static boolean getAfterToday(long date1){
        Calendar calendar = Calendar.getInstance();
        long aa = calendar.getTime().getTime();

        return aa<date1;
    }
    /**
     * 获取昨天
     */

    public static String getYesterday(){
         Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,-24);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(calendar.getTime());
            return date;
        } catch (Exception e) {
        }
        return "";
    }
    /**
     * 获取今天
     * @return
     */
    public static boolean getCurrentDayIsSa(){
        Calendar calendar = Calendar.getInstance();
        return  calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY;
    }


    public static String getCurrentDay(){
        Calendar calendar = Calendar.getInstance();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(calendar.getTime());
            return date;
        } catch (Exception e) {
        }
        return "";
    }

    public static String getCurrentYear(){
        Calendar calendar = Calendar.getInstance();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            String date = sdf.format(calendar.getTime());
            return date;
        } catch (Exception e) {
        }
        return "";
    }

    public static String getCurrentMonth(){
        Calendar calendar = Calendar.getInstance();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM");
            String date = sdf.format(calendar.getTime());
            return date;
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * 获取获取上周第一天
     */
    public static String getLastWeekFirstDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        calendar.add(Calendar.DAY_OF_WEEK, -7);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(calendar.getTime());
            return date;
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * 获取获取上周第一天
     */
    public static String getWeekFirstDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        calendar.add(Calendar.DAY_OF_WEEK, 0);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(calendar.getTime());
            return date;
        } catch (Exception e) {
        }
        return "";
    }
    /**
     * 获取获取上周最后一天
     */
    public static String getWeekEndDay( ){
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.add(Calendar.DAY_OF_WEEK, 6);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(calendar.getTime());
            return date;
        } catch (Exception e) {
        }
        return "";
    } /**
     * 获取获取上周最后一天
     */
    public static String getLastWeekEndDay( ){
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        calendar.add(Calendar.DAY_OF_WEEK, -7);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.add(Calendar.DAY_OF_WEEK, 6);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(calendar.getTime());
            return date;
        } catch (Exception e) {
        }
        return "";
    }
    /**
     * 获取获取上月第一天
     */
    public static String getLastMonthFirstDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(calendar.getTime());
            return date;
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * 获取获取本月第一天
     */
    public static String getCurrentMonthFirstDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(calendar.getTime());
            return date;
        } catch (Exception e) {
        }
        return "";
    }
    /**
     * 获取获取上月最後一天
     */
    public static String getLastMonthEndDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
//        condition.put("startTime", calendar.getTime());
        calendar.add(Calendar.DAY_OF_WEEK, 7);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        //calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(calendar.getTime());
            return date;
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * 获取某天所属月的第一天和最后一天
     */

    public static String[] getFirstDayAndLastDayByDay (String day){

        String[] days = new String[2];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date thisDate = null;
        try {
            thisDate = sdf.parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cld = Calendar.getInstance();
        cld.setTime(thisDate);

        //月份+1，天设置为0。下个月第0天，就是这个月最后一天
        cld.add(Calendar.MONTH, 1);
        cld.set(Calendar.DAY_OF_MONTH, 0);
        String lastDay = sdf.format(cld.getTime());
        System.out.println("本月最后一天："+lastDay); //2019-09-30

        cld.set(Calendar.DAY_OF_MONTH,1);
        System.out.println("本月第一天："+ sdf.format(cld.getTime()) ); //2019-09-01

        days[0] = sdf.format(cld.getTime());
        days[1] = lastDay;
        return days;

    }

    /**
     * 获取获取上月最後一天
     */
    public static String getCurrentMonthEndDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
//        condition.put("startTime", calendar.getTime());
        calendar.add(Calendar.DAY_OF_WEEK, 7);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        //calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(calendar.getTime());
            return date;
        } catch (Exception e) {
        }
        return "";
    }


    /**
     * 将字符串时间转为Long时间
     *
     * @param time yyyy-MM-dd HH:mm:ss:SSS
     */
    public static Long getLongTimeOfSSS(String time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
            Date date = sdf.parse(time);
            return date.getTime();
        } catch (Exception e) {
        }
        return 0L;
    }

    /**
     * 将字符串时间转为Long时间
     *
     * @param time yyyy-MM-dd HH:mm:ss
     */
    public static Long getLongTime(String time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(time);
            return date.getTime();
        } catch (Exception e) {
        }
        return 0L;
    }

    /**
     * 将字符串时间转为Long时间
     *
     * @param time yyyy-MM-dd
     */
    public static Long getLongTimeOfYMD(String time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(time);
            return date.getTime();
        } catch (Exception e) {
        }
        return 0L;
    }

    public static String getNumTimeOfYMD(String time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(time);
            Calendar canlendar = sdf.getCalendar();
            String str = canlendar.get(Calendar.MONTH) + 1 +"."+ canlendar.get(Calendar.DATE);
            return str;
        } catch (Exception e) {
        }
        return "";
    }
    public static String getNumTimeOfYMD(Date time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(time);
            return date;
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * 将Long时间转成String时间
     *
     * @return yyyy-MM-dd HH:mm:ss:SSS
     */
    public static String getStringTimeOfSSS(Long time) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        return sdf.format(date);
    }


    /**
     * 将Long时间转成String时间
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getStringTime(Long time) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * 任何一个日期，选择周日时间
     * @param date
     * @return
     */
    public static long getStringTimeArrSUNDAY(Long date) {

        Calendar cld = Calendar.getInstance(Locale.CHINA);
        cld.setFirstDayOfWeek(Calendar.SUNDAY);//以周一为首日
        cld.setTimeInMillis(date);//当前时间

        cld.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date data1 = cld.getTime();

        return data1.getTime();
    }
    public static String getStringCurrentTimeArrSUNDAY( ) {

        Calendar cld = Calendar.getInstance(Locale.CHINA);
        cld.setFirstDayOfWeek(Calendar.SUNDAY);//以周一为首日
        cld.setTimeInMillis(System.currentTimeMillis());//当前时间
        cld.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date data1 = cld.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(data1);
    }


    public static String getStringTimeArrZongJiEndDate(Long date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cld = Calendar.getInstance(Locale.CHINA);
        cld.setFirstDayOfWeek(Calendar.SUNDAY);//以周一为首日
        cld.setTimeInMillis(date);//当前时间

        cld.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);//周六
        String saturday = df.format(cld.getTime());

        return saturday;
    }
    public static String getStringHMTime(Long time) {
        if (time==null)return 0+"h"+0+"min";
        Date date = new Date(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int h = calendar.get(Calendar.HOUR_OF_DAY);
        int m = calendar.get(Calendar.MINUTE);

        return h+"h"+m+"min";
    }

    /**
     * 获取("yyyy-MM-dd")日期的   年月日
     * @param time
     * @param type 123
     * @return
     */
    public static int getYorMorD(String time,int type) {
        int h;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dfs = df.parse(time);
            calendar.setTime(dfs);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (type==1 ){
             h = calendar.get(Calendar.YEAR);
        }else if (type==2){
             h = calendar.get(Calendar.MONTH)+1;
        }else {
             h = calendar.get(Calendar.DATE);
        }
        return h;
    }

    // 年月日  123
    public enum typeByYMD {


        YEAR("1"), MONTH("2"), DATE("3");

        typeByYMD(String s) {

        }

    }


    /**
     * 将Long时间转成String时间
     *
     * @return yyyy-MM-dd
     */
    public static String getStringTimeOfYMD(Long time) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
    public static String getStringTimeOfYM(Long time) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        return sdf.format(date);
    }
    public static String getStringTimeOfY(Long time) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(date);
    }

    /**
     * 当前的时间(设备)
     *
     * @return yyyy-MM-dd HH:mm:ss:SSS
     */
    public static String getDeviceTimeOfSSS() {
        String date = "";
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
            date = df.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
            date = new Date().getTime() + "";//当前时间的long字符串
        }
        return date;
    }

    /**
     * 当前的时间(设备)
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getDeviceTime() {
        String date = "";
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = df.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
            date = new Date().getTime() + "";//当前时间的long字符串
        }
        return date;
    }

    /**
     * 当前的时间(年月日)
     *
     * @return yyyy-MM-dd
     */
    public static String getDeviceTimeOfYMD() {
        String date = "";
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            date = df.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取当前时间前七天时间
     */
    public static String [] beforeOf7daysTime (){
        String[] strs = new String[7];
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            int index = -7;
            for (int i = 0; i < 7; i++) {
                Calendar c = Calendar.getInstance();
                c.setTime(new Date());
                c.add(Calendar.DATE, index);
                Date d = c.getTime();
                String day = format.format(d);
                strs[i] = day;
                index++;
            }
        }catch (Exception e ){

        }
        return strs;
    }
    /**
     * 当前的时间(年月)
     *
     * @return yyyy-MM
     */
    public static String getDeviceTimeOfYM() {
        String date = "";
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
            date = df.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取某月最后一天(年月日)
     *
     * @return yyyy-MM
     */
    public static String getLastDayOfMonthOfYMD(int year, int month) {
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        cal.set(Calendar.MONTH, month - 1);
        // 获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        // 设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());

        return lastDayOfMonth;
    }

    public static String stampToDate(long time ){

        long hours = time / (1000 * 60 * 60);
        long minutes = (time-hours*(1000 * 60 * 60 ))/(1000* 60);

        return hours+"h"+minutes+"min";
    }

    public static String getStringTimeOfYM(int year, int month) {
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        cal.set(Calendar.MONTH, month - 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String lastDayOfMonth = sdf.format(cal.getTime());

        return lastDayOfMonth;
    }

    public static String getStringTimeOfY(int year, int month) {
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        cal.set(Calendar.MONTH, month - 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String lastDayOfMonth = sdf.format(cal.getTime());
        return lastDayOfMonth;
    }

    /**
     *  获取某天是今年的第几周
     */
    public static int getWeekOfYear1(String dateTime)  {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.setTime(date);

        int aa = calendar.get(Calendar.WEEK_OF_YEAR);
        return aa;
    }
    public static String getWeekOfYear(String dateTime)  {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormatter.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dateFormatter.applyPattern("w");
        String dataStr = dateFormatter.format(date);
        return dataStr;
    }



    /**
     * 获取某月最后一天(日)
     */
    public static int getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        cal.set(Calendar.MONTH, month - 1);
        // 获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        return lastDay;
    }

    /**
     * 显示日期选择器
     *
     * @param themeLight true 白色背景; false 黑色背景
     */
    public static BasisTimesUtils showDatePickerDialog(Context context, boolean themeLight, String title, int year, int month, int day, OnDatePickerListener onDateTimePickerListener) {
        int themeId = AlertDialog.THEME_HOLO_LIGHT;//默认白色背景
        if (!themeLight) {
            themeId = AlertDialog.THEME_HOLO_DARK;//黑色背景
        }
        return showDatePickerDialog(context, themeId, title, year, month, day, onDateTimePickerListener);
    }

    /**
     * 显示日期选择器, 默认白色背景
     */
    public static BasisTimesUtils showDatePickerDialog(Context context, String title, int year, int month, int day, OnDatePickerListener onDateTimePickerListener) {
        return showDatePickerDialog(context, AlertDialog.THEME_HOLO_LIGHT, title, year, month, day, onDateTimePickerListener);
    }

    //        BasisTimesUtils.showTimerPickerDialog(context, true, getString(R.string.str_option_date), 21, 33, true, new BasisTimesUtils.OnTimerPickerListener() {
    //            @Override
    //            public void onConfirm(int hourOfDay, int minute) {
    ////                toast(hourOfDay + ":" + minute);
    //            }
    //
    //            @Override
    //            public void onCancel() {
    ////                toast("cancle");
    //            }
    //        });
    /**
     * 显示日期选择器
     */
    public static BasisTimesUtils showDatePickerDialog(Context context, int themeId, String title, int year, int month, int day,
                                                       final OnDatePickerListener onDateTimePickerListener) {
        mDatePickerDialog = new DatePickerDialog(context, themeId, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;//月份加一
                if (onDateTimePickerListener != null) {
                    onDateTimePickerListener.onConfirm(year, month, dayOfMonth);
                }
            }

        }, year, month - 1, day);//月份减一

        mDatePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                if (onDateTimePickerListener != null) {
                    onDateTimePickerListener.onCancel();
                }
            }
        });

        if (!TextUtils.isEmpty(title)) {
            mDatePickerDialog.setTitle(title);
        }
        mDatePickerDialog.show();
        return new BasisTimesUtils();
    }

    /**
     * 隐藏年, 只显示月和日
     */
    public void setYearGone() {
        setSpecialDatePicker(1);
    }

    /**
     * 隐藏日, 只显示年和月
     */
    public void setDayGone() {
        setSpecialDatePicker(2);
    }

    private void setSpecialDatePicker(int state) {
        try {
            DatePicker dp = mDatePickerDialog.getDatePicker();

            NumberPicker view0 = (NumberPicker) ((ViewGroup) ((ViewGroup) dp.getChildAt(0)).getChildAt(0)).getChildAt(0); //获取最前一位的宽度
            NumberPicker view1 = (NumberPicker) ((ViewGroup) ((ViewGroup) dp.getChildAt(0)).getChildAt(0)).getChildAt(1); //获取中间一位的宽度
            NumberPicker view2 = (NumberPicker) ((ViewGroup) ((ViewGroup) dp.getChildAt(0)).getChildAt(0)).getChildAt(2);//获取最后一位的宽度

            //年的最大值为2100
            //月的最大值为11
            //日的最大值为28,29,30,31
            int value0 = view0.getMaxValue();//获取第一个View的最大值
            int value1 = view1.getMaxValue();//获取第二个View的最大值
            int value2 = view2.getMaxValue();//获取第三个View的最大值

            if (state == 1) {//隐藏年, 只显示月和日
                if (value0 > 252) {
                    view0.setVisibility(View.GONE);
                } else if (value1 > 252) {
                    view1.setVisibility(View.GONE);
                } else if (value2 > 252) {
                    view2.setVisibility(View.GONE);
                }
            } else if (state == 2) {//隐藏日, 只显示年和月
                if (value0 > 25 && value0 < 252) {
                    view0.setVisibility(View.GONE);
                } else if (value1 > 25 && value1 < 252) {
                    view1.setVisibility(View.GONE);
                } else if (value2 > 25 && value2 < 252) {
                    view2.setVisibility(View.GONE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示时间选择器
     */
    public static void showTimerPickerDialog(Context context, boolean themeLight, String title, int hourOfDay, int minute, boolean is24HourView, final OnTimerPickerListener onTimerPickerListener) {
        int themeId = AlertDialog.THEME_HOLO_LIGHT;//默认白色背景
        if (!themeLight) {
            themeId = AlertDialog.THEME_HOLO_DARK;//黑色背景
        }
        showTimerPickerDialog(context, themeId, title, hourOfDay, minute, is24HourView, onTimerPickerListener);
    }

    /**
     * 显示时间选择器, 默认白色背景
     */
    public static void showTimerPickerDialog(Context context, String title, int hourOfDay, int minute, boolean is24HourView, final OnTimerPickerListener onTimerPickerListener) {
        showTimerPickerDialog(context, AlertDialog.THEME_HOLO_LIGHT, title, hourOfDay, minute, is24HourView, onTimerPickerListener);
    }

    /**
     * 显示时间选择器
     */
    public static void showTimerPickerDialog(Context context, int themeId, String title, int hourOfDay, int minute, boolean is24HourView, final OnTimerPickerListener onTimerPickerListener) {
        TimePickerDialog dialog = new TimePickerDialog(context, themeId, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if (onTimerPickerListener != null) {
                    onTimerPickerListener.onConfirm(hourOfDay, minute);
                }
            }
        }, hourOfDay, minute, is24HourView);

        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                if (onTimerPickerListener != null) {
                    onTimerPickerListener.onCancel();
                }
            }
        });

        if (!TextUtils.isEmpty(title)) {
            dialog.setTitle(title);
        }
        dialog.show();
    }

    /**
     * 日期选择器监听
     */
    public interface OnDatePickerListener {
        void onConfirm(int year, int month, int dayOfMonth);

        void onCancel();
    }

    /**
     * 时间选择器监听
     */
    public interface OnTimerPickerListener {
        void onConfirm(int hourOfDay, int minute);

        void onCancel();
    }
}
