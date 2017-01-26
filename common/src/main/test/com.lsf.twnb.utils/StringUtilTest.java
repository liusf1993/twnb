package com.lsf.twnb.utils;

import org.junit.Assert;
import org.junit.Test;


/**
 * @Author liusf13201
 * @Date 2016/11/28
 * @Description string util 测试用例
 *
 */
public class StringUtilTest {


    @Test
    public void isBlank() throws Exception {
        Assert.assertEquals(true,StringUtil.isBlank(""));
        Assert.assertEquals(true,StringUtil.isBlank(null));
        Assert.assertEquals(true,StringUtil.isBlank("   "));
        Assert.assertEquals(true,StringUtil.isBlank("\n"));
        Assert.assertEquals(true,StringUtil.isBlank("\r"));
        Assert.assertEquals(true,StringUtil.isBlank("\t"));
        Assert.assertEquals(false,StringUtil.isBlank("abcdefg"));
    }

    @Test
    public void isNotBlank() throws Exception {
        Assert.assertEquals(false,StringUtil.isNotBlank(""));
        Assert.assertEquals(false,StringUtil.isNotBlank(null));
        Assert.assertEquals(false,StringUtil.isNotBlank("   "));
        Assert.assertEquals(false,StringUtil.isNotBlank("\n"));
        Assert.assertEquals(false,StringUtil.isNotBlank("\r"));
        Assert.assertEquals(false,StringUtil.isNotBlank("\t"));
        Assert.assertEquals(true,StringUtil.isNotBlank("abcdefg"));
    }

}