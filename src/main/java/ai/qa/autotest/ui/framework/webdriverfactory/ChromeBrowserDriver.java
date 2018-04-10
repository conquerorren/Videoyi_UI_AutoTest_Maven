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
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import ai.qa.autotest.ui.framework.constants.CommonConstants;
import ai.qa.autotest.ui.framework.utility.base.IBrowserDriverBase;

/**
 * @ClassName: ChromeBrowserDriver
 * @Description: 谷歌浏览器引擎
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
public class ChromeBrowserDriver implements IBrowserDriverBase {

    // private ChromeDriverService chromeService = null;
    private static Logger logger = LogManager.getLogger(ChromeBrowserDriver.class.getName());

    /**
     * (non Javadoc)
     *
     * @Title: configBrowser
     * @Description: 配置浏览器参数
     * @throws Exception
     * @see ai.qa.autotest.ui.framework.utility.base.IBrowserDriverBase#configBrowser()
     */
    public void configBrowser() throws Exception {
        System.setProperty(CommonConstants.CHROME_DRIVER_FIELD, CommonConstants.CHROME_DRIVER_SERVER);
        ChromeOptions options = new ChromeOptions();
        // set agruments not to display"data;"
        options.addArguments("--user-data-dir=C:/Users/Administrator/AppData/Local/Google/Chrome/UserData/Default");

        // chromeService = new ChromeDriverService.Builder()
        // .usingDriverExecutable(new
        // File(CommonConstants.CHROME_DRIVER_SERVER)).usingAnyFreePort().build();
        // chromeService.start();
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
            return (T) new ChromeDriver();
        } catch (Exception e1) {
            logger.error(e1);
            throw (e1);
        }
    }
}