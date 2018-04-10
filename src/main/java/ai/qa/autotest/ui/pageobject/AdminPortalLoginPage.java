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

import ai.qa.autotest.ui.custom.annotation.PageObject;
import ai.qa.autotest.ui.framework.constants.CommonConstants;
import ai.qa.autotest.ui.framework.constants.PropertiesKeys;
import ai.qa.autotest.ui.framework.utility.CommonUtil;
import ai.qa.autotest.ui.framework.utility.PropertiesUtil;
import ai.qa.autotest.ui.testbase.TestBase;

/**
 * @ClassName: AdminPortalLoginPage
 * @Description: 登录页面
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
@PageObject
public class AdminPortalLoginPage {
    // @Fields : Logger信息
    private static Logger logger = LogManager.getLogger(AdminPortalLoginPage.class.getName());

    // @Fields : 用户名
    @FindBy(how = How.ID, using = "video_email")
    private WebElement userNameInputBox;

    // @Fields : 密码
    @FindBy(how = How.ID, using = "video_password")
    private WebElement passwordInputBox;

    // @Fields : 登录
    @FindBy(how = How.CSS, using = "input[type=\"submit\"]")
    private WebElement submitButton;

    /**
     * @Title:AdminPortalLoginPage
     * @Description:初始化加载所有元素
     */
    public AdminPortalLoginPage() {
        PageFactory.initElements(TestBase.getWebDriver(), this);
    }

    /**
     * @Title: setUserNameContent
     * @Description: 设置用户名
     * @param username
     * @return void
     */
    public void setUserNameContent(String username) {
        userNameInputBox.clear();
        userNameInputBox.click();
        userNameInputBox.sendKeys(username);
    }

    /**
     * @Title: setPwdContent
     * @Description: 设置密码
     * @param pwd
     * @return void
     */
    public void setPwdContent(String pwd) {
        passwordInputBox.clear();
        passwordInputBox.click();
        passwordInputBox.sendKeys(pwd);
    }

    /**
     * @Title: getUserNameContent
     * @Description: 获取用户名信息
     * @return
     * @return String
     */
    public String getUserNameContent() {
        return userNameInputBox.getText();
    }

    /**
     * @Title: clickSummitButton
     * @Description: 点击登录按钮
     * @return void
     */
    public void clickSummitButton() {
        submitButton.submit();
    }

    /**
     * @Title: testLoginAdminPortal
     * @Description: 登录后台管理系统
     * @param username
     * @param pwd
     * @throws Exception
     * @return void
     */
    public void testLoginAdminPortal(String username, String pwd) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 输入用户名
            setUserNameContent(username);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 输入用户名 OK.-----");

            // 输入密码
            setPwdContent(pwd);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 输入密码 OK.-----");

            // 点击登录
            clickSummitButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击登录 OK.-----");

            // 验证：跳转后URL
            String strURL = TestBase.getWebDriver().getCurrentUrl();
            Assert.assertEquals(PropertiesUtil.getPropertyValue(PropertiesKeys.VIDEOYI_ADMIN_PORTAL_AUTO_TEST_WEBSITE)
                    + "workorder/index", strURL);
            logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

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