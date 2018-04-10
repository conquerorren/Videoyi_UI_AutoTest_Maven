/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.framework.utility.base
 * @author:Ren Qiang
 * @date:Mar 7, 2018
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.framework.utility.base;

/**
 * @ClassName: IWebdriverFactory
 * @Description: 工厂接口
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
public interface IWebdriverFactory {

    /**
     * @Title: setDriver
     * @Description: 设置浏览器引擎
     * @param driver
     * @throws Exception
     * @return void
     */
    public <T> void setDriver(T driver) throws Exception;

    /**
     * @Title: getDriver
     * @Description: 获取浏览器引擎
     * @param classPackageName
     * @return
     * @throws Exception
     * @return T
     */
    public <T> T getDriver(String classPackageName) throws Exception;
}