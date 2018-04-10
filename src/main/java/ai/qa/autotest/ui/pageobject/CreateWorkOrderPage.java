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

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ai.qa.autotest.ui.constants.VideoyiConstants;
import ai.qa.autotest.ui.custom.annotation.PageObject;
import ai.qa.autotest.ui.dataentity.WorkOrderInfo;
import ai.qa.autotest.ui.framework.constants.CommonConstants;
import ai.qa.autotest.ui.framework.utility.CommonUtil;
import ai.qa.autotest.ui.testbase.TestBase;

/**
 * @ClassName: CreateWorkOrderPage
 * @Description: 创建投放计划页面
 * @author: Ren Qiang
 * @date: Mar 15, 2018
 */
@PageObject
public class CreateWorkOrderPage {
    // Logger信息
    private static Logger logger = LogManager.getLogger(AdminPortalLoginPage.class.getName());

    // 计划名称
    @FindBy(how = How.NAME, using = "work_video_name")
    private WebElement workVideoNameInputBox;

    // 共通：团队归属
    @FindBy(how = How.ID, using = "team_id")
    private WebElement teamIDSelect;

    // 共通：客户筛选
    @FindBy(how = How.ID, using = "member_id")
    private WebElement memberIDSelect;

    // 费用
    @FindBy(how = How.NAME, using = "budget")
    private WebElement budgetInputBox;

    // 终端：PC，移动端，OTT
    @FindAll({ @FindBy(name = "terminal[]") })
    private List<WebElement> terminalListCheckBox;

    // 是否共享：否
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div[6]/div[2]/label[1]")
    private WebElement shareNoRadio;

    // 是否共享：是
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div[6]/div[2]/label[2]")
    private WebElement shareYESRadio;

    // 时间：开始时间
    @FindBy(how = How.NAME, using = "start_time")
    private WebElement startTimeInputBox;

    // 时间：结束时间
    @FindBy(how = How.NAME, using = "end_time")
    private WebElement endTimeInputBox;

    // 投放日期：全部
    @FindBy(how = How.ID, using = "days")
    private WebElement weekDayAllCheckBox;

    // 投放日期：星期一~星期日
    @FindAll({ @FindBy(className = "days") })
    private List<WebElement> weekDayEveryListCheckBox;

    // 投放日期：星期一~星期日文字
    @FindAll({ @FindBy(className = "wi_list") })
    private List<WebElement> weekDayEveryListLabel;

    // 投放时段：全部
    @FindBy(how = How.ID, using = "hours")
    private WebElement timeAllCheckBox;

    // 投放时段：00-08-00
    @FindAll({ @FindBy(className = "hours") })
    private List<WebElement> timeEveryListCheckBox;

    // 投放时段：00-08-00文字
    @FindAll({ @FindBy(className = "wi_list") })
    private List<WebElement> timeEveryListLabel;

    // 点击确定
    @FindBy(how = How.ID, using = "submit")
    private WebElement submitButton;

    // 点击取消
    @FindBy(how = How.CLASS_NAME, using = "up_yb")
    private WebElement cancelButton;

    /**
     * CreateWorkOrderPage
     * 
     * @Description 初始化加载所有元素
     */
    public CreateWorkOrderPage() {
        PageFactory.initElements(TestBase.getWebDriver(), this);
    }

    /**
     * @Title: setWorkVideoNameContent
     * @Description: 计划名称
     * @return void
     */
    public void setWorkVideoNameContent(String workVideoName) {
        workVideoNameInputBox.clear();
        workVideoNameInputBox.click();
        workVideoNameInputBox.sendKeys(workVideoName);
    }

    /**
     * @Title: setTeamIDContent
     * @Description: 归属团队
     * @param TeamID
     * @return void
     */
    public void setTeamIDContent(String TeamID) {
        new Select(teamIDSelect).selectByVisibleText(TeamID);
    }

    /**
     * @Title: setMemberIDContent
     * @Description: 客户筛选
     * @param memberID
     * @return void
     */
    public void setMemberIDContent(String memberID) {
        new Select(memberIDSelect).selectByVisibleText(memberID);
    }

    /**
     * @Title: setBudgetContent
     * @Description: 费用
     * @return void
     */
    public void setBudgetContent(String budget) {
        budgetInputBox.clear();
        budgetInputBox.click();
        budgetInputBox.sendKeys(budget);
    }

    /**
     * @Title: clickShareNoRadion
     * @Description: 点击是否分享：否
     * @return void
     */
    public void clickShareNoRadion() {
        shareNoRadio.click();
    }

    /**
     * @Title: clickShareYESRadion
     * @Description: 点击是否分享：是
     * @return void
     */
    public void clickShareYESRadion() {
        shareYESRadio.click();
    }

    /**
     * @Title: setStartTimeContent
     * @Description: 时间：开始时间
     * @return void
     */
    public void setStartTimeContent(String startTime) {
        startTimeInputBox.clear();
        startTimeInputBox.click();
        startTimeInputBox.sendKeys(startTime);
    }

    /**
     * @Title: setEndTimeContent
     * @Description: 时间：结束时间
     * @return void
     */
    public void setEndTimeContent(String endTime) {
        endTimeInputBox.clear();
        endTimeInputBox.click();
        endTimeInputBox.sendKeys(endTime);
    }

    /**
     * @Title: clickWeekDayAllCheckBox
     * @Description: 点击投放日期全部按钮
     * @return void
     */
    public void clickWeekDayAllCheckBox() {
        weekDayAllCheckBox.click();
    }

    /**
     * @Title: clickTimeAllCheckBox
     * @Description: 点击投放时段全部按钮
     * @return void
     */
    public void clickTimeAllCheckBox() {
        timeAllCheckBox.click();
    }

    /**
     * @Title: clickSubmitButton
     * @Description: 点击确定
     * @return void
     */
    public void clickSubmitButton() {
        submitButton.click();
    }

    /**
     * @Title: clickCancelButton
     * @Description: 点击取消
     * @return void
     */
    public void clickCancelButton() {
        cancelButton.click();
    }

    /**
     * @Title: testCreateWorkorder
     * @Description: 创建投放计划
     * @param workOrderInfo
     * @throws Exception
     * @return void
     */
    public void testCreateWorkorder(WorkOrderInfo workOrderInfo) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 计划名称
            setWorkVideoNameContent(workOrderInfo.workVideoName);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 计划名称 OK.-----");

            // 团队归属
            setTeamIDContent(workOrderInfo.teamID);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 团队归属 OK.-----");

            // 客户归属
            setMemberIDContent(workOrderInfo.memberID);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 客户归属 OK.-----");

            // 费用
            setBudgetContent(workOrderInfo.budget);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 费用 OK.-----");

            // 终端
            String[] arrTerminal = workOrderInfo.terminal.split(",");
            HashMap<String, Boolean> dataMapTerminal = new HashMap<String, Boolean>();
            for (String strTerminal : arrTerminal) {
                dataMapTerminal.put(strTerminal, true);
                logger.info("-----" + strMethodName + " 终端选择：" + strTerminal + ".-----");
            }

            // 设置选中
            if (null != terminalListCheckBox) {
                for (int i = 0; i < terminalListCheckBox.size(); i++) {
                    String strTerminalText = terminalListCheckBox.get(i).getAttribute("value");
                    if (dataMapTerminal.containsKey(strTerminalText)) {
                        if (!terminalListCheckBox.get(i).isSelected()) {
                            terminalListCheckBox.get(i).click();
                        }
                    } else {
                        if (terminalListCheckBox.get(i).isSelected()) {
                            terminalListCheckBox.get(i).click();
                        }
                    }
                }
            }
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 终端选择结束OK.-----");

            // 是否共享
            if (workOrderInfo.isShared.equals(VideoyiConstants.WORKORDER_SHARE_NO)) {
                clickShareNoRadion();
            } else if (workOrderInfo.isShared.equals(VideoyiConstants.WORKORDER_SHARE_YES)) {
                clickShareYESRadion();
            } else {
                clickShareNoRadion();
            }
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 共享选择" + workOrderInfo.isShared + "OK.-----");

            // 时间：开始时间（默认）
            // if (workOrderInfo.startTime.isEmpty()) {
            // Date now = new Date();
            // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            // String strTimeStampFileName = dateFormat.format(now);
            // setStartTimeContent(strTimeStampFileName);
            // } else {
            // setStartTimeContent(workOrderInfo.startTime);
            // }
            // Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            // logger.info("-----" + strMethodName + " 时间：开始时间 OK.-----");

            // 时间：结束时间（默认）
            // setEndTimeContent("");
            // Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            // logger.info("-----" + strMethodName + " 时间：结束时间 OK.-----");

            // 地区定向
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 地区定向选择OK.-----");

            // 投放日期
            String[] arrWeekDate = workOrderInfo.adWeekDate.split(",");
            HashMap<String, Boolean> dataMap = new HashMap<String, Boolean>();

            for (String strWeekDate : arrWeekDate) {
                dataMap.put(strWeekDate, true);
                logger.info("-----" + strMethodName + " 投放日期选择：" + strWeekDate + ".-----");
            }

            // 投放日期：选择全部时
            if (dataMap.containsKey(VideoyiConstants.WORKORDER_ADWEEKDATE_ALL)) {
                // 设置为全部选中
                if (!weekDayAllCheckBox.isSelected()) {
                    clickWeekDayAllCheckBox();
                }

                // 设置星期一~星期日为未选中
                for (int i = 0; i < weekDayEveryListCheckBox.size(); i++) {
                    if (weekDayEveryListCheckBox.get(i).isSelected()) {
                        weekDayEveryListCheckBox.get(i).click();
                    }
                }
            } else {
                // 设置为全部未选中
                if (weekDayAllCheckBox.isSelected()) {
                    clickWeekDayAllCheckBox();
                }

                // 设置星期一~星期日为选择
                weekDayEveryListLabel = weekDayEveryListLabel.subList(1, 8);
                if (weekDayEveryListCheckBox.size() == weekDayEveryListLabel.size()) {
                    for (int i = 0; i < weekDayEveryListLabel.size(); i++) {
                        WebElement strWeekDateLabel = weekDayEveryListLabel.get(i);
                        if (dataMap.containsKey(strWeekDateLabel.getText())) {
                            if (!weekDayEveryListCheckBox.get(i).isSelected()) {
                                weekDayEveryListCheckBox.get(i).click();
                            }
                        }
                    }
                }
            }
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 投放日期选择OK.-----");

            // 投放时段
            String[] arrTimes = workOrderInfo.adTime.split(",");
            HashMap<String, Boolean> dataMapTime = new HashMap<String, Boolean>();
            for (String strTime : arrTimes) {
                dataMapTime.put(strTime, true);
                logger.info("-----" + strMethodName + " 投放时段选择：" + strTime + ".-----");
            }
            // 投放时段：选择全部时
            if (dataMapTime.containsKey(VideoyiConstants.WORKORDER_ADTIME_ALL)) {
                // 设置为全部选中
                if (!timeAllCheckBox.isSelected()) {
                    clickTimeAllCheckBox();
                }

                // 设置00-08-00为未选中
                for (int i = 0; i < timeEveryListCheckBox.size(); i++) {
                    if (timeEveryListCheckBox.get(i).isSelected()) {
                        timeEveryListCheckBox.get(i).click();
                    }
                }
            } else {
                // 设置为全部未选中
                if (timeAllCheckBox.isSelected()) {
                    clickTimeAllCheckBox();
                }

                // 设置00-21-00为选择
                timeEveryListLabel = timeEveryListLabel.subList(9, 15);
                if (timeEveryListCheckBox.size() == timeEveryListLabel.size()) {
                    for (int i = 0; i < timeEveryListLabel.size(); i++) {
                        WebElement strWeekDateLabel = timeEveryListLabel.get(i);
                        if (dataMapTime.containsKey(strWeekDateLabel.getText())) {
                            if (!timeEveryListCheckBox.get(i).isSelected()) {
                                timeEveryListCheckBox.get(i).click();
                            }
                        }
                    }
                }
            }
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 投放时段选择OK.-----");

            // 不需要关联操作时
            // // 点击更多按钮
            // driver.findElement(By.id("more_button")).click();
            // Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            // logger.info("-----" + strMethodName + " 时间：点击更多按钮 OK.-----");
            //
            // // 关联植入易计划
            // new
            // Select(driver.findElement(By.id("assoc_work_id"))).selectByVisibleText("rq芒果SDK性能测试计划");
            // Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            // logger.info("-----" + strMethodName + " 关联植入易计划 OK.-----");
            //
            // // 刊例单价
            // driver.findElement(By.name("unit_price")).clear();
            // driver.findElement(By.name("unit_price")).sendKeys("122");
            // Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            // logger.info("-----" + strMethodName + " 刊例单价 OK.-----");
            //
            // // 折扣比例
            // driver.findElement(By.name("discount_ratio")).clear();
            // driver.findElement(By.name("discount_ratio")).sendKeys("10");
            // Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            // logger.info("-----" + strMethodName + " 折扣比例 OK.-----");
            //
            // // 折让单价
            // driver.findElement(By.name("discount_price")).clear();
            // driver.findElement(By.name("discount_price")).sendKeys("142");
            // Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            // logger.info("-----" + strMethodName + " 折让单价 OK.-----");
            //
            // // 时长
            // driver.findElement(By.name("duration")).clear();
            // driver.findElement(By.name("duration")).sendKeys("2390");
            // Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            // logger.info("-----" + strMethodName + " 时长 OK.-----");
            //
            // // 周期
            // driver.findElement(By.name("cycle")).clear();
            // driver.findElement(By.name("cycle")).sendKeys("3月");
            // Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            // logger.info("-----" + strMethodName + " 周期 OK.-----");

            // 点击确定
            clickSubmitButton();
            logger.info("-----" + strMethodName + " 点击确定 OK.-----");

            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
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
