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
 * @ClassName: IBrowserDriverBase
 * @Description: 实例化目标浏览器接口
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
public interface IBrowserDriverBase {
    /**
     * @Title: configBrowser
     * @Description: 配置浏览器参数
     * @throws Exception
     * @return void
     */
    public void configBrowser() throws Exception;

    /**
     * @Title: getWebDriver
     * @Description: 获取WebDriver
     * @return
     * @throws Exception
     * @return T
     */
    public <T> T getWebDriver() throws Exception;
}