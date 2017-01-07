package com.lsf.twnb.utils;

import org.junit.Assert;
import org.junit.Test;


/**
 * @Author liusf13201
 * @Date 2016/11/28
 * @Description
 */
public class StringUtilTest {


    @Test
    public void isBlank() throws Exception {
        Assert.assertEquals(true,StringUtil.isNotBlank(""));
        Assert.assertEquals(true,StringUtil.isNotBlank(null));
        Assert.assertEquals(true,StringUtil.isNotBlank("   "));
        Assert.assertEquals(true,StringUtil.isNotBlank("\n"));
        Assert.assertEquals(true,StringUtil.isNotBlank("\r"));
        Assert.assertEquals(true,StringUtil.isNotBlank("\t"));
        Assert.assertEquals(false,StringUtil.isNotBlank("abcdefg"));
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