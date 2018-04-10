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

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ai.qa.autotest.ui.custom.annotation.PageObject;
import ai.qa.autotest.ui.dataentity.MonitorInfo;
import ai.qa.autotest.ui.framework.constants.CommonConstants;
import ai.qa.autotest.ui.framework.utility.CommonUtil;
import ai.qa.autotest.ui.testbase.TestBase;

/**
 * @ClassName: WorkOrderMonitorPage
 * @Description: 监控页面测试用例
 * @author: Ren Qiang
 * @date: Mar 15, 2018
 */
@PageObject
public class WorkOrderMonitorPage {
    // Logger信息
    private static Logger logger = LogManager.getLogger(AdminPortalLoginPage.class.getName());

    // 选择终端
    @FindBy(how = How.ID, using = "terminal")
    private WebElement chooseTerminal;

    // 监控名称
    @FindBy(how = How.NAME, using = "monitor_name")
    private WebElement monitorNameInputBox;

    // 点击监控代码
    @FindBy(how = How.NAME, using = "monitor_click_code")
    private WebElement monitorClickCodeInputBox;

    // 展示监控代码
    @FindBy(how = How.NAME, using = "monitor_code")
    private WebElement monitorDisplayCodeInputBox;

    // 确定添加
    @FindBy(how = How.ID, using = "submit")
    private WebElement submitButton;

    // 返回
    @FindBy(how = How.CLASS_NAME, using = "up_yb-monitor")
    private WebElement backButton;

    // 删除按钮
    @FindBy(how = How.CLASS_NAME, using = "del-monitor")
    private WebElement deleteMonitorButton;

    // 编辑按钮
    @FindBy(how = How.CLASS_NAME, using = "eidt-monitor")
    private WebElement editMonitorButton;

    // 编辑监控代码：选择终端
    @FindBy(how = How.ID, using = "terminal_val")
    private WebElement editChooseTerminal;

    // 编辑监控代码：监控名称
    @FindBy(how = How.NAME, using = "monitor_name_val")
    private WebElement editMonitorNameInputBox;

    // 编辑监控代码：点击监控代码
    @FindBy(how = How.NAME, using = "monitor_click_code_val")
    private WebElement editMonitorClickCodeInputBox;

    // 编辑监控代码：展示监控代码
    @FindBy(how = How.NAME, using = "monitor_code_val")
    private WebElement editMonitorDisplayCodeInputBox;

    // 编辑监控代码：确定添加
    @FindBy(how = How.ID, using = "MonSubmitBtn")
    private WebElement submitOfEditButton;

    // 编辑监控代码：取消按钮
    @FindBy(how = How.ID, using = "MonCancelBtn")
    private WebElement cancelOfEditButton;

    /**
     * WorkOrderMonitorPage
     * 
     * @Description 初始化加载所有元素
     */
    public WorkOrderMonitorPage() {
        PageFactory.initElements(TestBase.getWebDriver(), this);
    }

    /**
     * @Title: setChooseTerminalContent
     * @Description: 选择终端
     * @return void
     */
    public void setChooseTerminalContent(String terminal, boolean isEdit) {
        if (isEdit) {
            Select userSelect = new Select(editChooseTerminal);
            userSelect.selectByVisibleText(terminal);
        } else {
            Select userSelect = new Select(chooseTerminal);
            userSelect.selectByVisibleText(terminal);
        }
    }

    /**
     * @Title: setMonitorNameContent
     * @Description: 监控名称
     * @return void
     */
    public void setMonitorNameContent(String monitorName, boolean isEdit) {
        if (isEdit) {
            editMonitorNameInputBox.clear();
            editMonitorNameInputBox.click();
            editMonitorNameInputBox.sendKeys(monitorName);
        } else {
            monitorNameInputBox.clear();
            monitorNameInputBox.click();
            monitorNameInputBox.sendKeys(monitorName);
        }
    }

    /**
     * @Title: setMonitorClickCodeContent
     * @Description: 点击监控代码
     * @return void
     */
    public void setMonitorClickCodeContent(String monitorClickCode, boolean isEdit) {
        if (isEdit) {
            editMonitorClickCodeInputBox.clear();
            editMonitorClickCodeInputBox.click();
            editMonitorClickCodeInputBox.sendKeys(monitorClickCode);
        } else {
            monitorClickCodeInputBox.clear();
            monitorClickCodeInputBox.click();
            monitorClickCodeInputBox.sendKeys(monitorClickCode);
        }
    }

    /**
     * @Title: setMonitorClickCodeContent
     * @Description: 展示监控代码
     * @return void
     */
    public void setMonitorDisplayCodeContent(String monitorcode, boolean isEdit) {
        if (isEdit) {
            editMonitorDisplayCodeInputBox.clear();
            editMonitorDisplayCodeInputBox.click();
            editMonitorDisplayCodeInputBox.sendKeys(monitorcode);
        } else {
            monitorDisplayCodeInputBox.clear();
            monitorDisplayCodeInputBox.click();
            monitorDisplayCodeInputBox.sendKeys(monitorcode);
        }
    }

    /**
     * @Title: clickSubmitButton
     * @Description: 点击确定按钮
     * @return void
     */
    public void clickSubmitButton() {
        submitButton.click();
    }

    /**
     * @Title: clickEditMonitorButton
     * @Description: 点击编辑按钮
     * @return void
     */
    public void clickEditMonitorButton() {
        editMonitorButton.click();
    }

    /**
     * @Title: clickDeleteMonitorButton
     * @Description: 点击删除按钮
     * @return void
     */
    public void clickDeleteMonitorButton() {
        deleteMonitorButton.click();
    }

    /**
     * @Title: clickBackButton
     * @Description: 点击返回按钮
     * @return void
     */
    public void clickBackButton() {
        backButton.click();
    }

    /**
     * @Title: clickSubmitOfEditButton
     * @Description: 点击编辑的确定按钮
     * @return void
     */
    public void clickSubmitOfEditButton() {
        submitOfEditButton.click();
    }

    /**
     * @Title: clickSubmitOfEditButton
     * @Description: 点击编辑的确定按钮
     * @return void
     */
    public void clickCancelOfEditButton() {
        cancelOfEditButton.click();
    }

    /**
     * @Title: testAllPointsOffline
     * @Description: 全部下线操作
     * @throws Exception
     * @return void
     */
    public void testAddMonitor(MonitorInfo monitorInfo) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 选择终端
            setChooseTerminalContent(monitorInfo.terminalType, false);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击选择终端  OK.-----");

            // 监控名称
            setMonitorNameContent(monitorInfo.monitorName, false);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 设置监控名称 OK.-----");

            // 点击监控代码
            setMonitorClickCodeContent(monitorInfo.monitorClickCode, false);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 设置点击监控代码 OK.-----");

            // 展示监控代码
            setMonitorDisplayCodeContent(monitorInfo.monitorDisplayCode, false);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 设置展示监控代码 OK.-----");

            // 点击添加
            clickSubmitButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击确认添加监控代码按钮 OK.-----");

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
     * @Title: testAllPointsOffline
     * @Description: 全部下线操作
     * @throws Exception
     * @return void
     */
    public void testEditMonitor(MonitorInfo monitorInfo) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 编辑监控信息
            clickEditMonitorButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击编辑监控信息  OK.-----");

            // 选择终端
            setChooseTerminalContent(monitorInfo.terminalType, true);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击选择终端  OK.-----");

            // 监控名称
            setMonitorNameContent(monitorInfo.monitorName, true);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 设置监控名称 OK.-----");

            // 点击监控代码
            setMonitorClickCodeContent(monitorInfo.monitorClickCode, true);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 设置点击监控代码 OK.-----");

            // 展示监控代码
            setMonitorDisplayCodeContent(monitorInfo.monitorDisplayCode, true);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 设置展示监控代码 OK.-----");

            // 点击确定按钮
            clickSubmitOfEditButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击编辑的确认按钮 OK.-----");

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
     * @Title: testDeleteMonitor
     * @Description: 删除当前集列表
     * @throws Exception
     * @return void
     */
    public void testDeleteMonitor(boolean isDelete) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击删除集按钮
            clickDeleteMonitorButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击删除集按钮 OK.-----");

            if (isDelete) {
                // 点击删除确定
                CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_ACCEPT);
                logger.info("-----" + strMethodName + " 点击删除确定OK.-----");

                // 点击删除：二次确定
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_ACCEPT);
                logger.info("-----" + strMethodName + " 点击删除：二次确定 OK.-----");
            } else {
                // 点击取消删除
                CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_DISMISS);
                logger.info("-----" + strMethodName + " 点击删除取消 OK.-----");
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

}
