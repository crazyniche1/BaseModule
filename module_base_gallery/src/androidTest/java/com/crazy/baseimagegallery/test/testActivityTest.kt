package com.crazy.baseimagegallery.test

import com.crazy.baseimagegallery.util.CommonUtil
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: testActivityTest
 * Author: zy
 * Date: 2021/7/26 11:04
 * Description:
 * History:
 *
 */
class testActivityTest : TestCase() {

    public override fun setUp() {
        super.setUp()
    }

    public override fun tearDown() {}

    @Test
    fun testTest1() {
        var str = CommonUtil.buildStringNotNull("test_statement")
        Assert.assertTrue(str,true)
    }
}