/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.pageobject
 * @author:Ren Qiang
 * @date:Mar 7, 2018
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.pageobject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ai.qa.autotest.ui.constants.VideoyiConstants;
import ai.qa.autotest.ui.custom.annotation.PageObject;
import ai.qa.autotest.ui.framework.constants.CommonConstants;
import ai.qa.autotest.ui.framework.utility.CommonUtil;
import ai.qa.autotest.ui.testbase.TestBase;

/**
 * @ClassName: NavigationMenu
 * @Description: 导航菜单
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
@PageObject
public class NavigationMenu {
    // Logger信息
    private static Logger logger = LogManager.getLogger(AdminPortalLoginPage.class.getName());

    // 投放计划
    @FindBy(how = How.ID, using = "rightbg00000070")
    private WebElement workorderMenu;

    // 物料管理
    @FindBy(how = How.ID, using = "rightbg00000090")
    private WebElement productManagerMenu;

    // 客户管理
    @FindBy(how = How.ID, using = "rightbg00000100")
    private WebElement memberManagerMenu;

    // 平台配置
    @FindBy(how = How.ID, using = "rightbg00000200")
    private WebElement platconfigMenu;

    // 账号管理
    @FindBy(how = How.ID, using = "rightbg00000110")
    private WebElement accountManagerMenu;

    /**
     * @Title:NavigationMenu
     * @Description:初始化加载所有元素
     */
    public NavigationMenu() {
        PageFactory.initElements(TestBase.getWebDriver(), this);
    }

    /**
     * @Title: goToWorkorderPage
     * @Description: 投放计划
     * @throws Exception
     * @return void
     */
    public void goToWorkorderPage() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 点击导航：投放计划
            workorderMenu.click();
            logger.info("-----" + strMethodName + " 导航：投放计划 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 验证：跳转后URL
            String strURL = TestBase.getWebDriver().getCurrentUrl();
            Assert.assertEquals(TestBase.getTestWebSite() + VideoyiConstants.URL_WORKORDER_MANAGER, strURL);
            logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            CommonUtil.TakeScreenShot(strMethodName + "_Success");
            logger.info("-----" + strMethodName + " Success.-----");
        } catch (Exception e1) {
            // Add a message to your Log File to capture the error
            logger.error("-----" + strMethodName + " failed.-----");
            logger.error(e1);
            // Take a screenshot which will be helpful for analysis.
            CommonUtil.TakeScreenShot(strMethodName + "_Exception");
            throw (e1);
        }
    }

    /**
     * @Title: goToProductManagerPage
     * @Description: 物料管理
     * @throws Exception
     * @return void
     */
    public void goToProductManagerPage() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 点击导航：物料管理
            productManagerMenu.click();
            logger.info("-----" + strMethodName + " 导航：物料管理 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 验证：跳转后URL
            String strURL = TestBase.getWebDriver().getCurrentUrl();
            Assert.assertEquals(TestBase.getTestWebSite() + VideoyiConstants.URL_PRODUCT_MANAGER, strURL);
            logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            CommonUtil.TakeScreenShot(strMethodName + "_Success");
            logger.info("-----" + strMethodName + " Success.-----");
        } catch (Exception e1) {
            // Add a message to your Log File to capture the error
            logger.error("-----" + strMethodName + " failed.-----");
            logger.error(e1);
            // Take a screenshot which will be helpful for analysis.
            CommonUtil.TakeScreenShot(strMethodName + "_Exception");
            throw (e1);
        }
    }

    /**
     * @Title: goToMemberManagerPage
     * @Description: 客户管理
     * @throws Exception
     * @return void
     */
    public void goToMemberManagerPage() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 点击导航：客户管理
            memberManagerMenu.click();
            logger.info("-----" + strMethodName + " 导航：客户管理 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 验证：跳转后URL
            String strURL = TestBase.getWebDriver().getCurrentUrl();
            Assert.assertEquals(TestBase.getTestWebSite() + VideoyiConstants.URL_MEMBER_MANAGER, strURL);
            logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            CommonUtil.TakeScreenShot(strMethodName + "_Success");
            logger.info("-----" + strMethodName + " Success.-----");
        } catch (Exception e1) {
            // Add a message to your Log File to capture the error
            logger.error("-----" + strMethodName + " failed.-----");
            logger.error(e1);
            // Take a screenshot which will be helpful for analysis.
            CommonUtil.TakeScreenShot(strMethodName + "_Exception");
            throw (e1);
        }
    }

    /**
     * @Title: goToPlatconfigPage
     * @Description: 平台配置
     * @throws Exception
     * @return void
     */
    public void goToPlatconfigPage() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 点击导航：平台配置
            platconfigMenu.click();
            logger.info("-----" + strMethodName + " 导航：平台配置 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 验证：跳转后URL
            String strURL = TestBase.getWebDriver().getCurrentUrl();
            Assert.assertEquals(TestBase.getTestWebSite() + "platconfig/config", strURL);
            logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            CommonUtil.TakeScreenShot(strMethodName + "_Success");
            logger.info("-----" + strMethodName + " Success.-----");
        } catch (Exception e1) {
            // Add a message to your Log File to capture the error
            logger.error("-----" + strMethodName + " failed.-----");
            logger.error(e1);
            // Take a screenshot which will be helpful for analysis.
            CommonUtil.TakeScreenShot(strMethodName + "_Exception");
            throw (e1);
        }
    }

    /**
     * @Title: goToAccountManagerPage
     * @Description: 账号管理
     * @throws Exception
     * @return void
     */
    public void goToAccountManagerPage() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 点击导航：账号管理
            accountManagerMenu.click();
            logger.info("-----" + strMethodName + " 导航：账号管理 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 验证：跳转后URL
            String strURL = TestBase.getWebDriver().getCurrentUrl();
            Assert.assertEquals(TestBase.getTestWebSite() + "account/index", strURL);
            logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            CommonUtil.TakeScreenShot(strMethodName + "_Success");
            logger.info("-----" + strMethodName + " Success.-----");
        } catch (Exception e1) {
            // Add a message to your Log File to capture the error
            logger.error("-----" + strMethodName + " failed.-----");
            logger.error(e1);
            // Take a screenshot which will be helpful for analysis.
            CommonUtil.TakeScreenShot(strMethodName + "_Exception");
            throw (e1);
        }
    }
}
