package com.crazy.rapermission

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: onPermissonCall
 * Author: zy
 * Date: 2022/5/18 16:30
 * Description:
 * History:

 */
interface OnPermissionCall {
    //获取权限成功
    fun success ()
    //获取权限失败
    fun failed()

}