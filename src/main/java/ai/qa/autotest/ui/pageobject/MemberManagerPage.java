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
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ai.qa.autotest.ui.custom.annotation.PageObject;
import ai.qa.autotest.ui.framework.constants.CommonConstants;
import ai.qa.autotest.ui.framework.utility.CommonUtil;
import ai.qa.autotest.ui.testbase.TestBase;

/**
 * @ClassName: MemberManagerPage
 * @Description: 成员管理页面
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
@PageObject
public class MemberManagerPage {
    // Logger信息
    private static Logger logger = LogManager.getLogger(AdminPortalLoginPage.class.getName());

    // 团队筛选
    @FindBy(how = How.NAME, using = "team_id")
    private WebElement teamIDSelect;

    // 关键字过滤
    @FindBy(how = How.ID, using = "username")
    private WebElement keyWordInputBox;

    // 检索按钮
    @FindBy(how = How.ID, using = "search")
    private WebElement searchButton;

    // 新建客户按钮
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div[2]/div[3]/input")
    private WebElement createMemberButton;

    // 编辑客户按钮
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/table/tbody/tr[2]/td[9]/input")
    private WebElement editMemberButton;

    // 删除按钮
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/table/tbody/tr[2]/td[10]/input")
    private WebElement deleteButton;

    /**
     * @Title:MemberManagerPage
     * @Description 初始化加载所有元素
     */
    public MemberManagerPage() {
        PageFactory.initElements(TestBase.getWebDriver(), this);
    }

    /**
     * @Title: setTeamIDContent
     * @Description: 设置团队筛选
     * @param teamID
     * @return void
     */
    public void setTeamIDContent(String teamID) {
        new Select(teamIDSelect).selectByVisibleText(teamID);
    }

    /**
     * @Title: setKeyWordContent
     * @Description: 设置搜索关键字
     * @param pwd
     * @return void
     */
    public void setKeyWordContent(String pwd) {
        keyWordInputBox.clear();
        keyWordInputBox.click();
        keyWordInputBox.sendKeys(pwd);
    }

    /**
     * @Title: clickSearchButton
     * @Description: 点击检索按钮
     * @return void
     */
    public void clickSearchButton() {
        searchButton.click();
    }

    /**
     * @Title: clickDeleteButton
     * @Description: 点击删除按钮
     * @return void
     */
    public void clickDeleteButton() {
        deleteButton.click();
    }

    /**
     * @Title: clickCreateMemeber
     * @Description: 点击创建成员
     * @throws Exception
     * @return void
     */
    public void clickCreateMemeber() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            createMemberButton.click();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击新建客户 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");
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
     * @Title: clickEditMemeber
     * @Description: 点击编辑成员
     * @throws Exception
     * @return void
     */
    public void clickEditMemeber() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            editMemberButton.click();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击编辑客户 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");
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
     * @Title: testSearchMember
     * @Description: 成员过滤筛选
     * @param strTeamID
     * @param strKeyWord
     * @throws Exception
     * @return void
     */
    public void testSearchMember(String strTeamID, String strKeyWord) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 团队筛选
            setTeamIDContent(strTeamID);
            // 关键字过滤
            setKeyWordContent(strKeyWord);
            // 点击检索按钮
            clickSearchButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 关键字过滤 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SearchResult");

            // 取消关键字过滤
            setTeamIDContent("全部团队");
            setKeyWordContent("");
            clickSearchButton();
            logger.info("-----" + strMethodName + " 取消关键字过滤 OK.-----");

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
     * @Title: testDeleteMemberCancel
     * @Description: 删除成员： 点击取消按钮
     * @throws Exception
     * @return void
     */
    public void testDeleteMemberCancel() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击删除
            clickDeleteButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            // 点击取消删除
            CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_DISMISS);
            logger.info("-----" + strMethodName + " 点击删除取消 OK.-----");

            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            CommonUtil.TakeScreenShot(strMethodName + "_Success");
            logger.info("-----" + strMethodName + " Success.-----");
        } catch (UnhandledAlertException e1) {
            CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_DISMISS);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----Handle UnhandledAlertException-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Exception_Success");
            logger.info("-----" + strMethodName + " Exception Success.-----");
        }
    }

    /**
     * @Title: testDeleteMemberOK
     * @Description: 删除成员： 点击确定按钮
     * @throws Exception
     * @return void
     */
    public void testDeleteMemberOK() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击删除：确定
            clickDeleteButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_ACCEPT);
            logger.info("-----" + strMethodName + " 点击删除确定OK.-----");

            // 点击删除：二次确定
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_ACCEPT);
            logger.info("-----" + strMethodName + " 点击删除：二次确定 OK.-----");

            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            CommonUtil.TakeScreenShot(strMethodName + "_Success");
            logger.info("-----" + strMethodName + " Success.-----");
        } catch (UnhandledAlertException e1) {
            CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_ACCEPT);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);

            CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_ACCEPT);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);

            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----Handle UnhandledAlertException-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Exception_Success");
            logger.info("-----" + strMethodName + " Exception Success.-----");
        }
    }
}
