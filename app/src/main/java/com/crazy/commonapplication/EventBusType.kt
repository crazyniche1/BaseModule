package com.crazy.commonapplication

import java.util.concurrent.ConcurrentHashMap

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: EventBusType
 * Author: zy
 * Date: 2022/4/20 10:34
 * Description: Tett
 * History:

 */
class EventBusType {
     var map = HashMap<String, Any>()
    var list=ArrayList<String>()

    constructor(map:HashMap<String, Any>){
        this.map = map
    }

    constructor(list:ArrayList<String>){
        this.list = list
    }
}