package com.crazy.rapermission;

import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: TestRaPermission
 * Author: zy
 * Date: 2022/5/20 11:21
 * Description:
 * History:
 */
public class TestRaPermission extends RaPermission {


    public void finishTest() {
        Toast.makeText(this,"test",LENGTH_SHORT).show();
    }
}
