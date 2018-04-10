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

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.firefox.FirefoxDriver;

import ai.qa.autotest.ui.framework.constants.CommonConstants;
import ai.qa.autotest.ui.framework.utility.base.IBrowserDriverBase;

/**
 * @ClassName: FireFoxBrowserDriver
 * @Description: 火狐浏览器引擎
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
public class FireFoxBrowserDriver implements IBrowserDriverBase {

    private static Logger logger = LogManager.getLogger(FireFoxBrowserDriver.class.getName());

    /**
     * (non Javadoc)
     *
     * @Title: configBrowser
     * @Description: 配置浏览器参数
     * @throws Exception
     * @see ai.qa.autotest.ui.framework.utility.base.IBrowserDriverBase#configBrowser()
     */
    public void configBrowser() throws Exception {
        System.setProperty(CommonConstants.FIREFOX_DRIVER_FIELD, CommonConstants.FIREFOX_DRIVER_SERVER);
    }

    /**
     * (non Javadoc)
     *
     * @Title: getWebDriver
     * @Description: 创建浏览器引擎
     * @return
     * @throws Exception
     * @see ai.qa.autotest.ui.framework.utility.base.IBrowserDriverBase#getWebDriver()
     */
    @SuppressWarnings("unchecked")
    public <T> T getWebDriver() throws Exception {
        try {
            configBrowser();
            return (T) new FirefoxDriver();
        } catch (Exception e1) {
            logger.error(e1);
            throw (e1);
        }
    }
}