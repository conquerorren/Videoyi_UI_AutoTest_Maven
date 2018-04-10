/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.framework.webdriverfactory
 * @author:Ren Qiang
 * @date:Mar 7, 2018
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.framework.webdriverfactory;

import ai.qa.autotest.ui.framework.utility.base.IBrowserDriverBase;
import ai.qa.autotest.ui.framework.utility.base.IWebdriverFactory;

/**
 * @ClassName: DriverFactory
 * @Description: 用于配置和生产基于不同浏览器的webdriver
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
public class DriverFactory implements IWebdriverFactory {
    /**
     * (non Javadoc)
     *
     * @Title: getDriver
     * @Description: 根据指定的浏览器获取并初始化webdriver对象实例
     * @param classPackageName：浏览器类型
     * @return
     * @throws Exception
     * @see ai.qa.autotest.ui.framework.utility.base.IWebdriverFactory#getDriver(java.lang.String)
     */
    public <T> T getDriver(String classPackageName) throws Exception {
        try {
            Class<?> driverClass = Class.forName(classPackageName);
            Object obj = driverClass.newInstance();
            return ((IBrowserDriverBase) obj).getWebDriver();
        } catch (Exception ex) {
            throw (ex);
        }
    }

    /**
     * (non Javadoc)
     *
     * @Title: setDriver
     * @Description: 设置浏览器
     * @param driver
     * @see ai.qa.autotest.ui.framework.utility.base.IWebdriverFactory#setDriver(java.lang.Object)
     */
    public <T> void setDriver(T driver) {
        // TODO Auto-generated method stub
    }
}