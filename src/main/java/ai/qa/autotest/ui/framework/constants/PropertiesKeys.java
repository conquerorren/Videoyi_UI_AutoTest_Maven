/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.framework.constants
 * @author:Ren Qiang
 * @date:Mar 7, 2018
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.framework.constants;

/**
 * Property constants.This class defines all types of the command.
 * 
 * @author Ren Qiang
 * 
 * @date 2018/03/02
 */
public class PropertiesKeys {

    /**
     * 启动目标浏览器驱动运行测试 .
     */
    public static final String BROWSER_TYPE = "Browser.Type";

    /**
     * 用例失败重试次数 .
     */
    public static final String TESTCASE_FAILEDCASE_RETRYCOUN = "testcase.failedcase.retrycoun";

    /**
     * 开启用例失败自动截图功能.
     */
    public static final String TESTCASE_FAILEDCASE_SCREENSHOTENABLED = "testcase.failedcase.screenShotEnabled";

    /**
     * 失败截图保存的目录.
     */
    public static final String TESTCASE_FAILEDCASE_SCREENSHOTPATH = "testcase.failedcase.screenShotPath";

    /**
     * 是否生成自定义HTML报告 .
     */
    public static final String TESTCASE_REPORTER_HTMLREPORT = "testcase.reporter.htmlreport";

    /**
     * 自定义HTML报告存放路径 .
     */
    public static final String TESTCASE_REPORTER_HTMLREPORT_PATH = "testcase.reporter.htmlreport.path";

    /**
     * 测试数据文件夹地址 .
     */
    public static final String TESTCASE_TESTDATA_PATH = "testcase.testdata.path";

    /**
     * 测试图片文件夹地址 .
     */
    public static final String TESTCASE_TESTRESOURCE_PATH = "testcase.testresource.path";

    /**
     * 扫描page对象的包将页面对象自动注入到用力中 .
     */
    public static final String INIT_PAGEOBJ_PACKAGE = "init.pageobj.Package";

    /**
     * 页面加载时间 .
     */
    public static final String INITDRIVER_WEBDRIVER_PAGELOADTIME = "initDriver.webdriver.pageloadtime";

    /**
     * 查找元素时间（全局） .
     */
    public static final String INITDRIVER_WEBDRIVER_SEARCHELEMENTTIME = "initDriver.webdriver.searchelementtime";

    /**
     * 登录页面加载时间 .
     */
    // public static final String ADMIN_PORTAL_PAGELOAD_TIME =
    // "admin.portal.pageload.time";

    /**
     * AI登陆页面的网址 .
     */
    public static final String AI_ADMIN_PORTAL_AUTO_TEST_WEBSITE = "ai.admin.portal.auto.test.website";

    /**
     * Video易登陆页面的网址 .
     */
    public static final String VIDEOYI_ADMIN_PORTAL_AUTO_TEST_WEBSITE = "videoyi.admin.portal.auto.test.website";

    /**
     * 页面等待时间 .
     */
    // public static final String IMPLICITLYWAIT_TIME = "implicitlywait.time";

}
