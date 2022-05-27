package com.crazy.rapermission

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import pub.devrel.easypermissions.PermissionRequest

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: RaPermission
 * Author: zy
 * Date: 2022/5/18 16:19
 * Description:
 * History:

 */
open class RaPermission:EasyPermissions.PermissionCallbacks, Activity() {

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        onPermissionCall.success()
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            onPermissionCall.failed()
//            AppSettingsDialog.Builder(this).build().show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    private lateinit var onPermissionCall:OnPermissionCall

//    val mContext =
    fun init(requestCode:Int,mContext:Context):RaPermission{

        var dialog :PermissionRequest?=null
        if (mContext is Activity) {
            dialog = PermissionRequest.Builder(mContext as Activity,requestCode,android.Manifest.permission.CAMERA).build()
        } else {
            if(mContext is Fragment) {
                dialog=  PermissionRequest.Builder(mContext as Fragment,requestCode,android.Manifest.permission.CAMERA).build()
            }else{
                Exception("class is error")
            }
        }
        dialog.let {
            EasyPermissions.requestPermissions(it )
        }

        return this

    }

    fun getPermission(onPermissionCall:OnPermissionCall) {
        this.onPermissionCall = onPermissionCall
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    fun test(): Unit {

    }

}