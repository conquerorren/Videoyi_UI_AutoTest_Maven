/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.testbase
 * @author:Ren Qiang
 * @date:Mar 7, 2018
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.testbase;

import java.lang.reflect.Method;

/**
 * @ClassName: ConfigDriverParameters
 * @Description: 配置浏览器参数
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
public class ConfigDriverParameters {
    // 测试网址地址
    private String strTargetWebsite;
    // 页面加载时间
    private long pageLoadTime;
    // 搜索元素的时间
    private long searchElementTime;
    // 测试方法名称
    private Method method;

    /**
     * @Title: getTargetWebSite
     * @Description: 获取测试网址地址
     * @return
     * @return String
     */
    public String getTargetWebSite() {
        return strTargetWebsite;
    }

    /**
     * @Title: setTargetWebSite
     * @Description: 设置测试网址地址
     * @param strTargetWebSite
     * @return void
     */
    public void setTargetWebSite(String strTargetWebSite) {
        this.strTargetWebsite = strTargetWebSite;
    }

    /**
     * @Title: getSearchElementTime
     * @Description: 获取搜索元素的时间
     * @return long
     */
    public long getSearchElementTime() {
        return searchElementTime;
    }

    /**
     * @Title: setSearchElementTime
     * @Description: 设置搜索元素的时间
     * @param searchTime
     * @return void
     */
    public void setSearchElementTime(long searchTime) {
        this.searchElementTime = searchTime;
    }

    /**
     * @Title: getPageLoadTime
     * @Description: 获取页面加载时间
     * @return long
     */
    public long getPageLoadTime() {
        return pageLoadTime;
    }

    /**
     * @Title: setPageLoadTime
     * @Description: 设置页面加载时间
     * @param pageLoadTime
     * @return void
     */
    public void setPageLoadTime(long pageLoadTime) {
        this.pageLoadTime = pageLoadTime;
    }

    /**
     * @Title: getTestMethod
     * @Description: 获取测试方法名称
     * @return Method
     */
    public Method getTestMethod() {
        return method;
    }

    /**
     * @Title: setTestMethod
     * @Description: 设置测试方法名称
     * @param method
     * @return void
     */
    public void setTestMethod(Method method) {
        this.method = method;
    }
}
