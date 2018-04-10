/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.pageobject
 * @author Ren Qiang
 * @date:Mar 15, 2018
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.pageobject;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ai.qa.autotest.ui.constants.VideoyiConstants;
import ai.qa.autotest.ui.custom.annotation.PageObject;
import ai.qa.autotest.ui.framework.constants.CommonConstants;
import ai.qa.autotest.ui.framework.utility.CommonUtil;
import ai.qa.autotest.ui.testbase.TestBase;

/**
 * @ClassName: WorkOrderManagerPage
 * @Description: 投放计划管理页面
 * @author: Ren Qiang
 * @date: Mar 15, 2018
 */
@PageObject
public class WorkOrderManagerPage {

    // Logger信息
    private static Logger logger = LogManager.getLogger(AdminPortalLoginPage.class.getName());

    // 团队筛选
    @FindBy(how = How.NAME, using = "team_id")
    private WebElement teamIDSelect;

    // 客户筛选
    @FindBy(how = How.NAME, using = "member_id")
    private WebElement memberIDSelect;

    // 状态筛选
    @FindBy(how = How.NAME, using = "work_state")
    private WebElement workStateSelect;

    // 平台筛选
    @FindBy(how = How.NAME, using = "platform")
    private WebElement platformSelect;

    // 开始时间
    @FindBy(how = How.NAME, using = "start_time_val")
    private WebElement startTimeValInputBox;

    // 结束时间
    @FindBy(how = How.NAME, using = "end_time_val")
    private WebElement endTimeValInputBox;

    // 关键字过滤
    @FindBy(how = How.NAME, using = "search_key")
    private WebElement searchKeyInutBox;

    // 关键字按钮
    @FindBy(how = How.ID, using = "search")
    private WebElement searchButton;

    // 点击导出按钮
    @FindBy(how = How.ID, using = "export_work")
    private WebElement exportWorkButton;

    // 新建投放计划按钮
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div[1]/div[2]/div[9]/input")
    private WebElement createWorkOrderButton;

    // 投放计划名称详情按钮
    @FindBy(how = How.CLASS_NAME, using = "detail")
    private WebElement workOrderNameLink;

    // 编辑投放计划按钮
    @FindBy(how = How.CLASS_NAME, using = "edit")
    private WebElement editWorkOrderButton;

    // 终止投放计划按钮
    @FindBy(how = How.CLASS_NAME, using = "termina")
    private WebElement terminaWorkOrderButton;

    // 删除投放计划按钮
    @FindBy(how = How.CLASS_NAME, using = "del")
    private WebElement delWorkOrderButton;

    // 监控按钮
    @FindBy(how = How.CLASS_NAME, using = "mon")
    private WebElement monitorButton;

    // 关联计划按钮
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div[2]/table/tbody/tr[2]/td[20]/span/img")
    private WebElement assocPlanButton;

    // 内外网上下线按钮
    @FindBy(how = How.CLASS_NAME, using = "online")
    private WebElement onlineWorkOrderButton;

    // 编辑计划信息：计划名称
    @FindBy(how = How.NAME, using = "work_video_name_val")
    private WebElement workVideoNameValInputBox;

    // 编辑计划信息：创建时间
    @FindBy(how = How.NAME, using = "create_time")
    private WebElement createTimeInputBox;

    // 编辑计划信息：关联计划
    @FindBy(how = How.ID, using = "assoc_work_id")
    private WebElement assocWorkIdSelect;

    // 编辑计划信息：确定
    @FindBy(how = How.ID, using = "MonSubmitBtn")
    private WebElement monSubmitButton;

    /**
     * WorkOrderManagerPage
     * 
     * @Description 初始化加载所有元素
     */
    public WorkOrderManagerPage() {
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
     * @Title: setMemberIDContent
     * @Description: 设置客户筛选
     * @param memberID
     * @return void
     */
    public void setMemberIDContent(String memberID) {
        new Select(memberIDSelect).selectByVisibleText(memberID);
    }

    /**
     * @Title: setworkStateContent
     * @Description: 设置状态筛选
     * @param state
     * @return void
     */
    public void setworkStateContent(String state) {
        new Select(workStateSelect).selectByVisibleText(state);
    }

    /**
     * @Title: setPlatformContent
     * @Description: 设置平台筛选
     * @param platform
     * @return void
     */
    public void setPlatformContent(String platform) {
        new Select(platformSelect).selectByVisibleText(platform);
    }

    /**
     * @Title: startTimeValContent
     * @Description: 设置开始时间
     * @param name
     * @return void
     */
    public void setStartTimeValContent(String startTime) {
        startTimeValInputBox.clear();
        startTimeValInputBox.click();
        startTimeValInputBox.sendKeys(startTime);
    }

    /**
     * @Title: setEndTimeValContent
     * @Description: 设置结束时间
     * @param name
     * @return void
     */
    public void setEndTimeValContent(String endTime) {
        endTimeValInputBox.clear();
        endTimeValInputBox.click();
        endTimeValInputBox.sendKeys(endTime);
    }

    /**
     * @Title: setSearchKeyContent
     * @Description: 设置关键字
     * @param name
     * @return void
     */
    public void setSearchKeyContent(String keyWord) {
        searchKeyInutBox.clear();
        searchKeyInutBox.click();
        searchKeyInutBox.sendKeys(keyWord);
    }

    /**
     * @Title: clickExportWorkButton
     * @Description: 点击检索按钮
     * @return void
     */
    public void clickSearchButton() {
        searchButton.click();
    }

    /**
     * @Title: clickExportWorkButton
     * @Description: 点击导出按钮
     * @return void
     */
    public void clickExportWorkButton() {
        exportWorkButton.click();
    }

    /**
     * @Title: clickWorkOrderNameLink
     * @Description: 点击投放计划详情按钮
     * @return void
     * @throws Exception
     */
    public void clickWorkOrderNameLink() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 点击计划名称链接
            workOrderNameLink.click();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击计划名称链接: OK.-----");

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
     * @Title: clickEditWorkOrderButton
     * @Description: 点击编辑按钮
     * @return void
     */
    public void clickEditWorkOrderButton() {
        editWorkOrderButton.click();
    }

    /**
     * @Title: clickTerminaWorkOrderButton
     * @Description: 点击终止按钮
     * @return void
     */
    public void clickTerminaWorkOrderButton() {
        terminaWorkOrderButton.click();
    }

    /**
     * @Title: clickDelWorkOrderButton
     * @Description: 点击删除按钮
     * @return void
     */
    public void clickDelWorkOrderButton() {
        delWorkOrderButton.click();
    }

    /**
     * @Title: clickMonitorButton
     * @Description: 点击监控按钮
     * @return void
     */
    public void clickMonitorButton() {
        monitorButton.click();
    }

    /**
     * @Title: clickAssocPlanButton
     * @Description: 点击关联按钮
     * @return void
     */
    public void clickAssocPlanButton() {
        assocPlanButton.click();
    }

    /**
     * @Title: clickOnlineWorkOrderButton
     * @Description: 点击内外网上下线按钮
     * @return void
     */
    public void clickOnlineWorkOrderButton() {
        onlineWorkOrderButton.click();
    }

    /**
     * @Title: setWorkVideoNameContent
     * @Description: 设置计划名称
     * @param name
     * @return void
     */
    public void setWorkVideoNameContent(String workVideoName) {
        workVideoNameValInputBox.clear();
        workVideoNameValInputBox.click();
        workVideoNameValInputBox.sendKeys(workVideoName);
    }

    /**
     * @Title: setCreateTimeContent
     * @Description: 设置创建时间
     * @param name
     * @return void
     */
    public void setCreateTimeContent(String createTime) {
        createTimeInputBox.clear();
        createTimeInputBox.click();
        createTimeInputBox.sendKeys(createTime);
    }

    /**
     * @Title: setAssocWorkIdContent
     * @Description: 设置关联计划内容
     * @param type
     * @return void
     */
    public void setAssocWorkIdContent(String assocWorkId) {
        new Select(assocWorkIdSelect).selectByVisibleText(assocWorkId);
    }

    /**
     * @Title: clickMonSubmitButton
     * @Description: 点击编辑确认按钮
     * @return void
     */
    public void clickMonSubmitButton() {
        monSubmitButton.click();
    }

    /**
     * @Title: clickCreateWorkOrderButton
     * @Description: 点击新建投放计划按钮
     * @return void
     * @throws Exception
     */
    public void clickCreateWorkOrderButton() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            createWorkOrderButton.click();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击新建投放计划 OK.-----");
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
     * @Title: testSearchWorkorder
     * @Description: 点击测试检索功能
     * @param strTeamID
     * @param strMemberID
     * @param strPlatform
     * @param strStartTime
     * @param strEndTime
     * @param strKeyword
     * @throws Exception
     * @return void
     */
    public void testSearchWorkorder(String strTeamID, String strMemberID, String strPlatform, String strStartTime,
            String strEndTime, String strKeyword) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 选择团队过滤
            setTeamIDContent(strTeamID);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 选择团队过滤 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SelectTeam_SearchResult");

            // 选择客户过滤
            setMemberIDContent(strMemberID);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 选择客户过滤 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SelectCustomer_SearchResult");

            // 取消选择客户过滤
            setMemberIDContent("全部客户");
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 取消客户过滤 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_CancelSelectCustom_SearchResult");

            // 取消选择团队过滤
            setTeamIDContent("全部团队");
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 取消团队过滤 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_CancelSelectTeam_SearchResult");

            // 选择状态过滤:已完成
            setworkStateContent("已完成");
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 选择状态：已完成 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SelectStatus_1_SearchResult");

            // 选择状态过滤:投放中
            setworkStateContent("投放中");
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 选择状态：投放中 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SelectStatus_2_SearchResult");

            // 取消选择状态过滤:全部状态
            setworkStateContent("全部状态");
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 取消选择状态：全部状态 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SelectStatus_Default_SearchResult");

            // 选择平台过滤
            setPlatformContent(strPlatform);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 选择平台过滤：芒果TV OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SelectPlatform_mgtv_SearchResult");

            // 取消选择平台过滤
            setPlatformContent("全部平台");
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 选择平台过滤：全部平台 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SelectPlatform_All_SearchResult");

            // 开始时间
            setStartTimeValContent(strStartTime);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 开始时间过滤 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_StartTime_SearchResult");

            // 结束时间
            setEndTimeValContent(strEndTime);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 结束时间过滤 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_EndTime_SearchResult");

            // 取消开始时间过滤
            setStartTimeValContent("");
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 取消开始时间过滤 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_CancelStartTime_SearchResult");

            // 关键字过滤
            setSearchKeyContent(strKeyword);
            clickSearchButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 关键字过滤 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Keyword_SearchResult");

            // 取消关键字过滤
            setSearchKeyContent("");
            clickSearchButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 取消关键字过滤 OK.-----");

            // 点击导出按钮
            clickExportWorkButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " 点击导出按钮 OK.-----");

            Thread.sleep(CommonConstants.THREAD_SLEEP_DOWNLOAD_TIME);
            // 关闭下载窗口
            CommonUtil.closeSubWindow();

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
     * @Title: testClickWorkOrderNameLink
     * @Description: 点击投放计划名称链接
     * @return void
     * @throws Exception
     */
    public void testClickWorkOrderNameLink() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 点击投放计划名称链接
            workOrderNameLink.click();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击投放计划名称链接 OK.-----");

            // 点击投放计划详情返回按钮
            logger.info("-----" + strMethodName + " 投放计划页面显示 OK.-----");
            TestBase.navigateToBack();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 返回投放管理页面 OK.-----");

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
     * @Title: testEditWorkorder
     * @Description: 编辑投放计划
     * @param strWorkOrderName
     * @param strCreateTime
     * @throws Exception
     * @return void
     */
    public void testEditWorkorder(String strWorkOrderName, String strCreateTime) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 点击投放计划编辑按钮
            clickEditWorkOrderButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " 点击投放计划编辑按钮 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 计划名称
            setWorkVideoNameContent("AutoTest_计划名称修改");
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 计划名称修改 OK.-----");

            // 创建时间
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strTimeStampFileName = dateFormat.format(now);
            setCreateTimeContent(strTimeStampFileName);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 时间：创建时间 OK.-----");

            // 关联计划修改
            // setAssocWorkIdContent("不关联");
            // Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            // logger.info("-----" + strMethodName + " 关联计划修改 OK.-----");

            // 确定
            clickMonSubmitButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 确定 OK.-----");

            // 点击确定
            CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_ACCEPT);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击确定 OK.-----");

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
     * @Title: testAbortWorkorderCancel
     * @Description: 点击终止计划：取消按钮
     * @throws Exception
     * @return void
     */
    public void testAbortWorkorderCancel() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 点击终止计划完成按钮
            clickTerminaWorkOrderButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " 点击计划完成按钮 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击取消
            CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_DISMISS);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击取消 OK.-----");

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
     * @Title: testAbortWorkorderOK
     * @Description: 点击终止计划：确认按钮
     * @throws Exception
     * @return void
     */
    public void testAbortWorkorderOK() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 点击终止计划完成按钮
            clickTerminaWorkOrderButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " 点击计划完成按钮 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击确定
            CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_ACCEPT);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击确定 OK.-----");

            // 点击确定：二次确定
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_ACCEPT);
            logger.info("-----" + strMethodName + " 点击完成：二次确定 OK.-----");

            boolean isAbortExist = terminaWorkOrderButton.isDisplayed();
            logger.info("-----" + strMethodName + " 完成按钮的显示状态：" + isAbortExist + ".-----");

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
     * @Title: testDeleteWorkorderCancel
     * @Description: 点击删除计划：取消按钮
     * @throws Exception
     * @return void
     */
    public void testDeleteWorkorderCancel() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 点击计划删除按钮
            clickDelWorkOrderButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " 点击计划删除按钮 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击取消
            CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_DISMISS);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击取消 OK.-----");

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
     * @Title: testDeleteWorkorderOK
     * @Description: 点击删除计划：确认按钮
     * @throws Exception
     * @return void
     */
    public void testDeleteWorkorderOK() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 点击计划删除按钮
            clickDelWorkOrderButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " 点击计划删除按钮 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击确定
            CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_ACCEPT);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击确定 OK.-----");

            // 点击确定：二次确定
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_ACCEPT);
            logger.info("-----" + strMethodName + " 点击完成：二次确定 OK.-----");

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
     * @Title: testMonitorWorkorder
     * @Description: 点击监控按钮
     * @throws Exception
     * @return void
     */
    public void testMonitorWorkorder(boolean isBack) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 点击监控按钮
            clickMonitorButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " 点击监控按钮 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            if (isBack) {
                // 点击返回按钮
                TestBase.navigateToBack();
                Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
                logger.info("-----" + strMethodName + "点击返回按钮 OK.-----");
                CommonUtil.TakeScreenShot(strMethodName + "_Init");

                // 验证：跳转后URL
                String strURL = TestBase.getWebDriver().getCurrentUrl();
                Assert.assertEquals(TestBase.getTestWebSite() + VideoyiConstants.URL_WORKORDER_MANAGER, strURL);
                logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");
            }

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
     * @Title: testAssocWorkorder
     * @Description: 点击关联计划
     * @throws Exception
     * @return void
     */
    public void testAssocWorkorder() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            if (assocPlanButton.isEnabled()) {
                Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
                logger.info("-----" + strMethodName + " Start.-----");

                // 点击关联按钮
                clickAssocPlanButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
                logger.info("-----" + strMethodName + " 点击关联按钮 OK.-----");
                CommonUtil.TakeScreenShot(strMethodName + "_Init");

                // 查看是否跳转到关联，点击返回按钮
                if (!TestBase.getWebDriver().getCurrentUrl()
                        .equals(TestBase.getTestWebSite() + VideoyiConstants.URL_WORKORDER_MANAGER)) {
                    TestBase.navigateToBack();
                    Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);

                    // 验证：跳转后URL
                    String strURL = TestBase.getWebDriver().getCurrentUrl();
                    Assert.assertEquals(TestBase.getTestWebSite() + VideoyiConstants.URL_WORKORDER_MANAGER, strURL);
                    logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");
                }

                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                CommonUtil.TakeScreenShot(strMethodName + "_Success");
                logger.info("-----" + strMethodName + " Success.-----");
            }
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
     * @Title: testWholeNetWorkOnLine
     * @Description: 点击全网上下线按钮
     * @throws Exception
     * @return void
     */
    public void testWholeNetWorkOnLine() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 点击全网上线按钮
            clickOnlineWorkOrderButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " 点击全网上线按钮 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击确定
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_ACCEPT);
            logger.info("-----" + strMethodName + " 点击完成：二次确定 OK.-----");

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
