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
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlTest;

import ai.qa.autotest.ui.framework.constants.CommonConstants;
import ai.qa.autotest.ui.framework.constants.PropertiesKeys;
import ai.qa.autotest.ui.framework.utility.CommonUtil;
import ai.qa.autotest.ui.framework.utility.CookiesUtil;
import ai.qa.autotest.ui.framework.utility.InitPageObject;
import ai.qa.autotest.ui.framework.utility.InitPropertiesUtil;
import ai.qa.autotest.ui.framework.utility.PageObjectUtil;
import ai.qa.autotest.ui.framework.utility.PropertiesUtil;
import ai.qa.autotest.ui.framework.utility.base.ITestBase;
import ai.qa.autotest.ui.framework.utility.base.IWebdriverFactory;
import ai.qa.autotest.ui.framework.webdriverfactory.DriverFactory;

/**
 * @ClassName: TestBase
 * @Description: 测试基类
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
public abstract class TestBase implements ITestBase {
    // WebDriver
    protected static RemoteWebDriver webDriver;

    // 浏览器类型
    protected static String browserType;

    // 是否成功Flag
    public static boolean success = true;

    // 重试的最大次数
    protected static int retryMaxCount = 2;// RetryToRunCase.getMaxRetryCount();

    // 重试的次数
    protected static int reTryCount = 1;

    // 测试用例声明类
    private static String testCaseDeclaringClass = null;

    // Logger信息
    private static Logger logger = LogManager.getLogger(TestBase.class.getName());

    /**
     * (non Javadoc)
     *
     * @Title: initTest
     * @Description: 在测试集运行前确定要运行测试的浏览器类型
     * @param xt
     * @param tc
     * @throws Exception
     * @see ai.qa.autotest.ui.framework.utility.base.ITestBase#initTest(org.testng.xml.XmlTest,
     *      org.testng.ITestContext)
     */
    @BeforeSuite(alwaysRun = true)
    public void initTest(XmlTest xt, ITestContext tc) throws Exception {
        // 初始化log4J信息
        DOMConfigurator.configure("config-log4j\\log4j.xml");

        logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # ");
        logger.info("# # # # # # # # # #TEST Has Started# # # # # # # # # #");

        // 初始化录屏功能
        CommonUtil.InitScreenRecorder();
        // 开始录屏功能
        CommonUtil.startScreenRecorder();

        // 初始化Property文件键值对
        System.setProperty(CommonConstants.CONFIG_FOLDER_PATH_KEY, CommonConstants.CONFIG_FOLDER_PATH_VALUE);
        new InitPropertiesUtil();
        if (null == PropertiesUtil.getPropertyKVMap()) {
            throw new IllegalArgumentException("Property File get failed!");
        }
        // PictureUtil.setBaseUrl(System.getProperty("user.dir") +
        // PropertiesUtil.getProValue("testcase.testpic.path"));
        browserType = PropertiesUtil.getPropertyValue(PropertiesKeys.BROWSER_TYPE).toString();
    }

    /**
     * (non Javadoc)
     * 
     * @Title: terminTestSuite
     * @Description: 在测试集运行后关闭浏览器等设置
     * @param xt
     * @param tc
     * @throws Exception
     * @see ai.qa.autotest.ui.framework.utility.base.ITestBase#terminTestSuite(org.testng.xml.XmlTest,
     *      org.testng.ITestContext)
     */
    @AfterSuite(alwaysRun = true)
    public void terminTestSuite(XmlTest xt, ITestContext tc) throws Exception {
        try {
            // 清空pageObject
            PageObjectUtil.setPageObjMap(null);

            // 关闭录屏功能
            // Output Path:C:\Users\Administrator\Videos
            CommonUtil.stopScreenRecorder();

            // // 关闭浏览器
            // if (null != webDriver) {
            // webDriver.close();
            // webDriver.quit();
            // }

            logger.info("# # # # # # # #Close Test Application Browser# # # # # # # #");
            logger.info("# # # # # # # # # #TEST Has Ended# # # # # # # # # #");
            logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // ExcuteDOSCommand.excuteBATFile(CommonConstants.KILL_DRIVER_PROCESS_BAT);
        }
    }

    /**
     * (non Javadoc)
     * 
     * @Title: cleanEnv
     * @Description: 测试方法执行结束后清理测试环境
     * @param rs
     * @param xt
     * @param m
     * @param tc
     * @throws Exception
     * @see ai.qa.autotest.ui.framework.utility.base.ITestBase#cleanEnv(org.testng.ITestResult,
     *      org.testng.xml.XmlTest, java.lang.reflect.Method,
     *      org.testng.ITestContext)
     */
    @AfterMethod
    public void cleanEnv(ITestResult rs, XmlTest xt, Method m, ITestContext tc) throws Exception {
        try {
            // 清空pageObject
            PageObjectUtil.setPageObjMap(null);

            if (!rs.isSuccess()) {
                if (reTryCount <= retryMaxCount) {
                    success = false;
                }
                Throwable throwable = rs.getThrowable();
                logger.info("-----测试用例: " + rs.getMethod().getMethodName() + " 运行失败，原因：" + throwable.getMessage()
                        + "-----");
                StackTraceElement[] se = throwable.getStackTrace();
                logger.info("-----堆栈信息:-----");
                for (StackTraceElement e : se) {
                    logger.info(e.toString());
                }
            } else {
                reTryCount = 1;
                logger.info("-----测试用例: " + rs.getMethod().getMethodName() + " 运行成功-----");
            }

            // 关闭浏览器
            if (null != webDriver) {
                webDriver.close();
                webDriver.quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // ExcuteDOSCommand.excuteBATFile(CommonConstants.KILL_DRIVER_PROCESS_BAT);
        }
    }

    /**
     * @Title: preCondition
     * @Description: 执行测试方法前预先处理的内容
     * @param cp
     * @throws Exception
     * @return void
     */
    public void preCondition(ConfigDriverParameters cp) throws Exception {
        // 获得当前执行方法名称
        testCaseDeclaringClass = cp.getTestMethod().getDeclaringClass().getName();
        // 获得被测试的网址
        String website = cp.getTargetWebSite();
        // 显示被测基础信息
        displayTipInfo(website, cp.getTestMethod());
        // 配置浏览器
        configDriver(cp);
        // 打开目标网址
        openTargetWebSit(website);
    }

    /**
     * @Title: configDriver
     * @Description: 配置测试的浏览器信息
     * @param cp
     * @throws Exception
     * @return void
     */
    private void configDriver(ConfigDriverParameters cp) throws Exception {
        // if (null == webDriver)
        // {
        IWebdriverFactory iw = new DriverFactory();
        webDriver = iw.getDriver(browserType);
        // 将当前对象传给注入功能类 对此实例中标有@AutoInject的类成员进行注入
        new InitPageObject(this);
        webDriver.manage().timeouts().implicitlyWait(cp.getSearchElementTime(), TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(cp.getPageLoadTime(), TimeUnit.SECONDS);
        // }
    }

    /**
     * @Title: displayTipInfo
     * @Description: 打印测试提示信息
     * @param website
     * @param m
     * @return void
     */
    private void displayTipInfo(String website, Method m) {
        if (!success) {
            logger.info("-----测试用例准备重试-----");
            reTryCount++;
            success = true;
        }

        logger.info("-----测试用例：" + m.getName() + " 开始执行-----");
        logger.info("-----测试用例运行的浏览器类型：" + browserType + "-----");
        logger.info("-----测试网站地址：" + website + "-----");
    }

    /**
     * @Title: getTestCaseDeclaringClass
     * @Description: 获取测试声明类
     * @return
     * @return String
     */
    public static String getTestCaseDeclaringClass() {
        return testCaseDeclaringClass;
    }

    /**
     * @Title: openTargetWebSit
     * @Description: 打开目标测试网址
     * @param website
     * @throws Exception
     * @return void
     */
    private void openTargetWebSit(String website) throws Exception {
        if (CookiesUtil.getCookie() != null) {
            webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
            try {
                webDriver.get(website);
            } catch (Exception e1) {
                logger.error(e1);
                throw (e1);
            }
            webDriver.manage().addCookie(CookiesUtil.getCookie());
        } else {
            try {
                webDriver.get(website);
            } catch (Exception e1) {
                logger.error(e1);
                throw (e1);
            }
            webDriver.manage().timeouts().pageLoadTimeout(-1, TimeUnit.SECONDS);
        }
    }

    /**
     * @Title: getWebDriver
     * @Description: 获取webdriver对象实例
     * @return RemoteWebDriver
     */
    public static RemoteWebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * @Title: getBrowserType
     * @Description: 获得浏览器的类型
     * @return browser type {Chrome|Firefox|InternetExplorer|Safari}
     */
    public static String getBrowserType() {
        String browser = "";

        if (webDriver.toString().equalsIgnoreCase("ChromeDriver")) {
            browser = "Chrome";
        } else if (webDriver.toString().equalsIgnoreCase("FirefoxDriver")) {
            browser = "Firefox";
        } else if (webDriver.toString().equalsIgnoreCase("InternetExplorerDriver")) {
            browser = "InternetExplorer";
        } else if (webDriver.toString().equalsIgnoreCase("SafariDriver")) {
            browser = "Safari";
        } else {
            browser = "Chrome";
        }

        return browser;
    }

    /**
     * @Title: getTestWebSite
     * @Description: 获取测试网址
     * @return String
     */
    public static String getTestWebSite() {
        String strTestURL = PropertiesUtil.getPropertyValue(PropertiesKeys.VIDEOYI_ADMIN_PORTAL_AUTO_TEST_WEBSITE);
        return strTestURL;
    }

    /**
     * @Title: navigateToBack
     * @Description: 点击返回浏览器上一页
     * @return void
     */
    public static void navigateToBack() {
        webDriver.navigate().back();
    }

    /**
     * @Title: refreshPage
     * @Description: 点击刷新页面
     * @return void
     */
    public static void refreshPage() {
        webDriver.navigate().refresh();
    }
}