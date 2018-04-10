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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import ai.qa.autotest.ui.framework.constants.CommonConstants;
import ai.qa.autotest.ui.framework.utility.base.IBrowserDriverBase;

/**
 * @ClassName: IEBrowserDriver
 * @Description: IE浏览器引擎
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
public class IEBrowserDriver implements IBrowserDriverBase {

    private DesiredCapabilities capabIE;
    private InternetExplorerDriverService internetExplorerService;
    private static Logger logger = LogManager.getLogger(IEBrowserDriver.class.getName());

    /**
     * (non Javadoc)
     *
     * @Title: configBrowser
     * @Description: 配置浏览器参数
     * @throws Exception
     * @see ai.qa.autotest.ui.framework.utility.base.IBrowserDriverBase#configBrowser()
     */
    public void configBrowser() throws Exception {
        // IE Driver
        System.setProperty(CommonConstants.IE_DRIVER_FIELD, CommonConstants.IE_DRIVER_SERVER);

        // set IE port
        InternetExplorerDriverService.Builder builder = new InternetExplorerDriverService.Builder();
        internetExplorerService = builder.usingPort(5678).withHost("127.0.0.1").build();

        // set IE protect Mode to Clean the dirty data of browser
        capabIE = DesiredCapabilities.internetExplorer();
        capabIE.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        capabIE.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabIE.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
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
            return (T) new InternetExplorerDriver(internetExplorerService, capabIE);
        } catch (Exception e1) {
            logger.error(e1);
            throw (e1);
        }
    }
}