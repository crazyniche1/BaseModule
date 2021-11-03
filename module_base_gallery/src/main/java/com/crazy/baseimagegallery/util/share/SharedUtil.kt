package com.crazy.baseimagegallery.util.share

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.LabeledIntent
import android.net.Uri
import com.beyondsoft.smarthome.utils.logs.LogTag
import com.crazy.baseimagegallery.util.text.TextUtil


/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: SharedUtil
 * Author: zy
 * Date: 2021/11/1 17:23
 * Description: 一键分享
 * History:

 */
  class SharedUtil<T>(var activity: Context) {

    private val targetIntents= arrayListOf<Intent>()
    private val noAppDesc = "没有可以分享的应用"
    private val title = "选择分享应用"
    enum class ShareType(var string: String) {
        TEXT("text/plain"),
        IMAGE("image/*"),
    }



        //基类
    private fun shareIntent(type:String) :Intent {
       val mIntent =  Intent()
        mIntent.action = Intent.ACTION_SEND
        mIntent.type = type
            //发送邮件添加的主题
//        mIntent.putExtra(Intent.EXTRA_SUBJECT,"Intent.EXTRA_SUBJECT")
//        LogTag.d("shareText_type: ${ShareType.TEXT.string}")
        return mIntent
    }

    //支持更改title 的文字类

    fun shareTextAndTitle (content: String,title: String){
        val mc = TextUtil().isEmpty(content)
        val mi =  shareIntent(ShareType.TEXT.string)
        mi.putExtra(Intent.EXTRA_TEXT,content)
        activity.startActivity(Intent.createChooser(mi,title))
    }

    fun shareText (content: String){
        val mi =  shareIntent(ShareType.TEXT.string)
        mi.putExtra(Intent.EXTRA_TEXT,content)
        activity.startActivity(mi)
    }

    //图片类
    fun image (uri: String){
        val mUri = TextUtil().isEmpty(uri)
        val uri = Uri.parse(String.format("file://%s",mUri))
        val mi =  shareIntent(ShareType.IMAGE.string)
        mi.putExtra(Intent.EXTRA_STREAM, uri)
        activity.startActivity(Intent.createChooser(mi, title))
    }

    /**
     * 分享应用的过滤
     * 根据不同的业务需求 去 过滤筛选
     */
    fun imageAPP(uri: String){
        val mUri = TextUtil().isEmpty(uri)

        val uri = Uri.parse(String.format("file://%s",mUri))
        val mi =  shareIntent(ShareType.IMAGE.string)
        mi.putExtra(Intent.EXTRA_STREAM, uri)
        mi.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        mi.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        getImageApps(mi,uri)


        val cci = Intent.createChooser(targetIntents.removeAt(targetIntents.size - 1), title)
        val labeledIntents: Array<Intent> = targetIntents.toTypedArray()
        if (cci==null){
            LogTag.d("没有可以分享的应用")
            return
        }
        cci.putExtra(Intent.EXTRA_INITIAL_INTENTS,labeledIntents)
        activity.startActivity(cci)
    }

    //获取匹配图片类型的应用信息列表：
    private fun getImageApps(im:Intent, uri:Uri){
        val resInfo  = activity.packageManager.queryIntentActivities(im,0)
        if(resInfo.isEmpty()){
            LogTag.d(noAppDesc)
            return
        }

        for ((i,e) in  resInfo.withIndex()){
            val apm = activity.packageManager;
            val icon = e.loadIcon(apm)
            val label = e.loadLabel(apm)
            val ai = e.activityInfo

            if (ai.packageName.contains("com.tencent.mm")){
               break
            }
            val target = shareIntent(ShareType.IMAGE.string)
            target.putExtra(Intent.EXTRA_STREAM,uri)
            target.component = ComponentName(ai.packageName,ai.name)
            LogTag.d("icon:$icon $label ${ ai.packageName}")
            targetIntents.add(LabeledIntent(target,ai.packageName,label,ai.icon))

        }

        if (targetIntents.size <= 0){
            LogTag.d(noAppDesc)
            return
        }
    }

    fun images (){
        val list =  arrayListOf<Uri>()
        val mi =  shareIntent(ShareType.IMAGE.string)
        mi.putParcelableArrayListExtra(Intent.EXTRA_STREAM,list)
        activity.startActivity(Intent.createChooser(mi,title))
    }

    fun build(content: T){
    }
}