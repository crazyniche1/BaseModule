package com.crazy.baseimagegallery.util.persistentStorage

import com.tencent.mmkv.MMKV

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: Mmkv
 * Author: zy
 * Date: 2021/7/26 15:35
 * Description: 创建本地持久化xml文件
 * History:

 */
class PersistentStorage {

    constructor(){
        initMMKV()
    }

    /**
     * 禁止销毁的key，在ondestroy中 需要单独取出，去比较
     */
    private var notDestroyStr = arrayOf("","")

    private var kv: MMKV ?=null

    //静态
    companion object{
        /**
         * sp 名称
         * 规则：包名+user.data
          */
//        final
        const val mmapID = "user_info"

    }

    /**
     * 创建，支持多进程
     */
    fun initMMKV ( ){
        kv = MMKV.mmkvWithID(mmapID, MMKV.MULTI_PROCESS_MODE)
    }

    //crud
    fun enCodeString (k:String,v:String){
        kv?.let {
            it.encode(k,v)
        }

    }

    fun enCodeBoolean (k:String,v:Boolean){
        kv?.let {
            it.encode(k,v)
        }
        print("bool: " + kv?.decodeBool(k))
    }
    fun enCodeInt (k:String,v:Int){
        kv?.let {
            it.encode(k,v)
        }
    }
    fun enCodeLong (k:String,v:Long){
        kv?.let {
            it.encode(k,v)
        }
    }
    fun enCodeDouble (k:String,v:Double){
        kv?.let {
            it.encode(k,v)
        }
    }

    fun deCodeString (k:String): String {
        kv?.let {
             if (!it.decodeString(k).isNullOrEmpty()){
                 return it.decodeString(k).toString()
            }
        }
        return ""
    }

    /**
     * 新增除false true 之外的状态 ：null，
     *
     */
    fun deCodeBoolean(k:String): Boolean? {
        kv?.let {
            return it.decodeBool(k)
        }
        print("bool: " + kv?.decodeBool(k))
        return null
    }

    /**
     * 销毁
     * des：退出账号销毁信息
     * 个别字段不需要注销 ，需单独处理
     */
    fun onDestroy () {

        kv?.let {
            var st = it.allKeys()

            if (st != null) {
                for (element  in st){
                    if (element.equals(notDestroyStr[0]))continue
                    it.removeValueForKey(element)
                }
            }
        }
    }

}