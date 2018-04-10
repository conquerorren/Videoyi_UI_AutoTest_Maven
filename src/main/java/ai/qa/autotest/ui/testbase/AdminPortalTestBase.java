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

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.xml.XmlTest;

import ai.qa.autotest.ui.framework.constants.PropertiesKeys;
import ai.qa.autotest.ui.framework.utility.InitDataObject;
import ai.qa.autotest.ui.framework.utility.PropertiesUtil;
import ai.qa.autotest.ui.pageobject.AdminPortalLoginPage;

/**
 * @ClassName: AdminPortalTestBase
 * @Description: Login登录页面入口
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
public class AdminPortalTestBase extends TestBase {

    // // 登录信息测试数据
    // @DataObject(DataNode = "AdminPortalLoginPage")
    // private HashMap<String, String> dataMap;

    /**
     * (non Javadoc)
     *
     * @Title: initDriver
     * @Description: 初始化浏览器的参数并启动
     * @param tc
     * @param m
     * @param xt
     * @throws Exception
     * @see ai.qa.autotest.ui.framework.utility.base.ITestBase#initDriver(org.testng.ITestContext,
     *      java.lang.reflect.Method, org.testng.xml.XmlTest)
     */
    @BeforeMethod(alwaysRun = true)
    public void initDriver(ITestContext tc, Method m, XmlTest xt) throws Exception {
        ConfigDriverParameters cp = new ConfigDriverParameters();
        cp.setPageLoadTime(
                Long.parseLong(PropertiesUtil.getPropertyValue(PropertiesKeys.INITDRIVER_WEBDRIVER_PAGELOADTIME)));
        cp.setTargetWebSite(PropertiesUtil.getPropertyValue(PropertiesKeys.VIDEOYI_ADMIN_PORTAL_AUTO_TEST_WEBSITE));
        cp.setSearchElementTime(
                Long.parseLong(PropertiesUtil.getPropertyValue(PropertiesKeys.INITDRIVER_WEBDRIVER_SEARCHELEMENTTIME)));
        cp.setTestMethod(m);
        preCondition(cp);

        // 初始化数据
        new InitDataObject(this);

        // 登录页面
        AdminPortalLoginPage ecHomePage = PageFactory.initElements(TestBase.getWebDriver(), AdminPortalLoginPage.class);
        ecHomePage.testLoginAdminPortal("renqiang@zhiruyi.com", "moviebook");
        // ecHomePage.testLoginAdminPortal(dataMap.get("UserName"),
        // dataMap.get("PassWord"));
    }

    // @AfterSuite(alwaysRun = true)
    // public void terminTestSuite(XmlTest xt, ITestContext tc) throws Exception
    // {
    // CookiesUtil.setCookie(null);
    // }

    /**
     * (non Javadoc)
     *
     * @Title: beforeClass
     * @Description: TODO
     * @param xt
     * @param tc
     * @throws Exception
     * @see ai.qa.autotest.ui.framework.utility.base.ITestBase#beforeClass(org.testng.xml.XmlTest,
     *      org.testng.ITestContext)
     */
    public void beforeClass(XmlTest xt, ITestContext tc) throws Exception {
        // TODO Auto-generated method stub
    }

    /**
     * (non Javadoc)
     *
     * @Title: afterClass
     * @Description: TODO
     * @param xt
     * @param tc
     * @throws Exception
     * @see ai.qa.autotest.ui.framework.utility.base.ITestBase#afterClass(org.testng.xml.XmlTest,
     *      org.testng.ITestContext)
     */
    public void afterClass(XmlTest xt, ITestContext tc) throws Exception {
        // TODO Auto-generated method stub
    }

    /**
     * (non Javadoc)
     *
     * @Title: beforeTest
     * @Description: TODO
     * @param xt
     * @param tc
     * @throws Exception
     * @see ai.qa.autotest.ui.framework.utility.base.ITestBase#beforeTest(org.testng.xml.XmlTest,
     *      org.testng.ITestContext)
     */
    public void beforeTest(XmlTest xt, ITestContext tc) throws Exception {
        // TODO Auto-generated method stub
    }

    /**
     * (non Javadoc)
     *
     * @Title: afterTest
     * @Description: TODO
     * @param xt
     * @param tc
     * @throws Exception
     * @see ai.qa.autotest.ui.framework.utility.base.ITestBase#afterTest(org.testng.xml.XmlTest,
     *      org.testng.ITestContext)
     */
    public void afterTest(XmlTest xt, ITestContext tc) throws Exception {
        // TODO Auto-generated method stub
    }
}
