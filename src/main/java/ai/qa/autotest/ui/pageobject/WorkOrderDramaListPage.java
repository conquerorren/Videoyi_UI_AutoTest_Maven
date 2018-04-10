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

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import ai.qa.autotest.ui.constants.ProductTypeConstants;
import ai.qa.autotest.ui.custom.annotation.PageObject;
import ai.qa.autotest.ui.dataentity.WorkOrderInfo;
import ai.qa.autotest.ui.framework.constants.CommonConstants;
import ai.qa.autotest.ui.framework.utility.CommonUtil;
import ai.qa.autotest.ui.testbase.TestBase;

/**
 * @ClassName: WorkDramaListPage
 * @Description: 投放计划详情页面
 * @author: Ren Qiang
 * @date: Mar 15, 2018
 */
@PageObject
public class WorkOrderDramaListPage {

    // Logger信息
    private static Logger logger = LogManager.getLogger(AdminPortalLoginPage.class.getName());

    // 选择媒资按钮
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[7]/button")
    private WebElement selectDramaButton;

    // 剧行和集行的操作按钮
    @FindAll({ @FindBy(className = "ControlButton") })
    private List<WebElement> dramaAndMaterialControlButton;

    // 剧行：删除剧弹出框，取消按钮
    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[3]/button[1]")
    private WebElement deleteCancelDramaButton;

    // 剧行：删除剧弹出框，确认按钮
    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[3]/button[2]")
    private WebElement deleteOKDramaButton;

    // 剧行：展开剧集按钮
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[8]/div[3]/table/tbody/tr/td[1]/div/div")
    private WebElement expandOpeningDramaButton;

    // 剧行：收合剧集按钮
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[8]/div[3]/table/tbody/tr[1]/td[1]/div/div")
    private WebElement expandFodingDramaButton;

    // 集行：点击集名称连接
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[8]/div[3]/table/tbody/tr[2]/td/div/div[3]/table/tbody/tr/td[1]/div/a")
    private WebElement materialNameLink;

    // 集行：点击全部上线连接
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[8]/div[3]/table/tbody/tr[2]/td/div/div[3]/table/tbody/tr/td[7]/div/span")
    private WebElement allOnlineLink;

    // 集行：点击全部下线连接
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[8]/div[3]/table/tbody/tr[2]/td/div/div[3]/table/tbody/tr/td[8]/div/span")
    private WebElement allOfflineLink;

    // 集行：全部上线/下线文字
    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[2]/div[2]/p")
    private WebElement allOnlineTipTextLabel;

    // 集行：全部上线/下线弹出框，取消按钮
    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[3]/button[1]")
    private WebElement cancelAllOnlineButton;

    // 集行：全部上线/下线弹出框，确认按钮
    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[3]/button[2]")
    private WebElement okAllOnlineButton;

    // 选择页面剧：搜索框
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/div[1]/div[3]/input")
    private WebElement searchInputBox;

    // 选择页面剧：搜索按钮
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/div[1]/div[3]/i")
    private WebElement searchButton;

    // 选择页面剧：选择单选框
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[6]/div/label/span[1]/span")
    private WebElement chooseDramaRadioButton;

    // 选择页面剧：点击选择集按钮
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[3]/div/button[3]")
    private WebElement chooseMaterialButton;

    // 选择集页面：点击选择集复选框
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[5]/div/div[2]/div/div[3]/table/tbody/tr/td[4]/div/label/span")
    private WebElement chooseMaterialCheckButton;

    // 选择集页面：点击选择集确认
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[5]/div/div[3]/div/button[2]")
    private WebElement materialSumbitButton;

    // 创建易植贴智点：选择类型
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/form[1]/div/div/div/div[1]/input")
    private WebElement chooseTypeSelect;

    // 创建易植贴智点：选择类型-红包
    @FindBy(how = How.XPATH, using = "/html/body/div[5]/div/div[1]/ul/li[1]")
    private WebElement chooseHongbaoTypeSelect;

    // 创建易植贴智点：选择类型-优惠码
    @FindBy(how = How.XPATH, using = "/html/body/div[5]/div/div[1]/ul/li[2]")
    private WebElement chooseYouhuimaTypeSelect;

    // 创建易植贴智点：选择类型-易植贴
    @FindBy(how = How.XPATH, using = "/html/body/div[5]/div/div[1]/ul/li[3]")
    private WebElement chooseYztTypeSelect;

    // 创建易植贴智点：选择类型-动态视窗
    @FindBy(how = How.XPATH, using = "/html/body/div[5]/div/div[1]/ul/li[4]")
    private WebElement chooseDtscTypeSelect;

    // 创建易植贴智点：选择模式-次数模式
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/form[4]/div/div[1]/div[1]/div/div/label[1]/span[1]/input")
    private WebElement timesModeRadioButton;

    // 创建易植贴智点：选择模式-间隔模式
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/form[4]/div/div[1]/div[1]/div/div/label[2]/span[1]/input")
    private WebElement intervalModeRadioButton;

    // 创建易植贴智点：开始时间-分
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/form[4]/div/div[1]/div[2]/div/div[1]/div/div[1]/input")
    private WebElement startMinInputBox;

    // 创建易植贴智点：开始时间-秒
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/form[4]/div/div[1]/div[2]/div/div[2]/div/div[1]/input")
    private WebElement startSecondInputBox;

    // 创建易植贴智点：结束时间-分
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/form[4]/div/div[1]/div[3]/div/div[1]/div/div[1]/input")
    private WebElement endMinInputBox;

    // 创建易植贴智点：结束时间-秒
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/form[4]/div/div[1]/div[3]/div/div[2]/div/div[1]/input")
    private WebElement endSecondInputBox;

    // 创建易植贴智点：展现时长
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/form[4]/div/div[1]/div[4]/div/div[1]/input")
    private WebElement displayTimeInputBox;

    // 创建易植贴智点：展现次数
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/form[4]/div/div[1]/div[5]/div/div[1]/input")
    private WebElement displayCountInputBox;

    // 创建易植贴智点：选择物料//*[@id='app']/div[2]/div/div[2]/form[4]/div/div[1]/div[6]/div/div/div[1]/input
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/form[4]/div/div[1]/div[6]/div/div")
    private WebElement chooseProductSelect;

    // 创建易植贴智点：选择物料-下拉菜单
    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div[1]/ul/li[1]")
    // @FindBy(how = How.LINK_TEXT, using = "AutoTest_易植贴修改")
    private WebElement chooseProductList;

    // 创建易植贴智点：选择坐标：左下（第一个）
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/form[4]/div/div[2]/div/div/div/label[1]")
    private WebElement choosePositionRadioButton;

    // 创建易植贴智点：选择坐标：中下（第二个）
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/form[4]/div/div[2]/div/div/div/label[2]")
    private WebElement choosePosition2RadioButton;

    // 创建易植贴智点：选择动效-无
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/form[4]/div/div[1]/div[8]/div/div/label[1]")
    private WebElement effectNoRadioButton;

    // 创建易植贴智点：选择动效-晃动
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/form[4]/div/div[1]/div[8]/div/div/label[2]")
    private WebElement effectShakeRadioButton;

    // 创建易植贴智点：选择动效-翻转
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/form[4]/div/div[1]/div[8]/div/div/label[3]")
    private WebElement effectTurnRadioButton;

    // 创建易植贴智点：选择动效-缩放
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/form[4]/div/div[1]/div[8]/div/div/label[4]")
    private WebElement effectZoomRadioButton;

    // 创建易植贴智点：确定按钮
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/div/button[1]")
    private WebElement submitPointButton;

    // 创建易植贴智点：取消按钮
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/div/button[2]")
    private WebElement cancelPointButton;

    // 创建易植贴智点：继续添加按钮
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/div/button[1]")
    private WebElement coutinueAddPointButton;

    // 创建易植贴智点：确定按钮
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/div/button[2]")
    private WebElement submitPointOfMaterialButton;

    // 创建易植贴智点：取消按钮
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[2]/div/div[2]/div/button[3]")
    private WebElement cancelPointOfMaterialButton;

    // 添加集页面：确定按钮
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[5]/div/div[3]/div/button[2]")
    private WebElement submitMaterialButton;

    // 添加集页面：取消按钮
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[5]/div/div[3]/div/button[1]")
    private WebElement cancelMaterialButton;

    // 编辑剧页面：剧名称
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[3]/div/div[2]/form/div[1]/div/div/input")
    private WebElement editDramaNameInputBox;

    // 编辑剧页面：修改集时间
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[3]/div/div[2]/form/div[2]/div/div/input")
    private WebElement modifyMaterialTimeInputBox;

    // 编辑剧页面：修改智点时间
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[3]/div/div[2]/form/div[3]/div/div/input")
    private WebElement modifyPointTimeInputBox;

    // 编辑剧页面：日历选择时间
    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div[2]/button")
    private WebElement submitTimeCalendarButton;

    // 编辑剧页面：确定按钮
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[3]/div/div[2]/form/div[4]/div/button[1]")
    private WebElement submitEditDramaButton;

    // 编辑剧页面：取消按钮
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[3]/div/div[2]/form/div[4]/div/button[2]")
    private WebElement cancelEditDramaButton;

    // 编辑集页面：集名称
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[4]/div/div[2]/form/div[1]/div/div/input")
    private WebElement editMaterialNameInputBox;

    // 编辑集页面：视频地址
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[4]/div/div[2]/form/div[2]/div/div/input")
    private WebElement editMaterialURLInputBox;

    // 编辑集页面：创建时间
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[4]/div/div[2]/form/div[3]/div/div/input")
    private WebElement editMaterialCreateTimeInputBox;

    // 编辑集页面：创建时间
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[4]/div/div[2]/form/div[4]/div/div/input")
    private WebElement editMaterialCreateTimeOfPointInputBox;

    // 编辑集页面：确定按钮
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[4]/div/div[2]/form/div[5]/div/button[1]")
    private WebElement submitEditMaterialButton;

    // 编辑集页面：取消按钮
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[4]/div/div[2]/form/div[5]/div/button[2]")
    private WebElement cancelEditMaterialButton;

    // 集行：删除所有智点、删除集弹出框，取消按钮
    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[3]/button[1]")
    private WebElement deleteCancelAllPointButton;

    // 集行：删除所有智点、删除集弹出框，确认按钮
    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[3]/button[2]")
    private WebElement deleteOKAllPointButton;

    // 集行：删除所有智点、删除集弹出框的文字部分
    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[2]/div[2]/p")
    private WebElement deleteTipTextLabel;

    /**
     * WorkDramaListPage
     * 
     * @Description 初始化加载所有元素
     */
    public WorkOrderDramaListPage() {
        PageFactory.initElements(TestBase.getWebDriver(), this);
    }

    /**
     * @Title: clickSelectDramaButton
     * @Description: 点击选择媒资按钮
     * @return void
     */
    public void clickSelectDramaButton() {
        selectDramaButton.click();
    }

    /**
     * @Title: getControlButtonByTitle
     * @Description: 获取操作控件
     * @param strTitle
     * @return
     * @return WebElement
     */
    private WebElement getControlButtonByTitle(String mode, String strTitle) {
        // 点击剧添加智点按钮
        int nIndex = -1;
        if (null != dramaAndMaterialControlButton) {
            int nStartIndex = 0;
            if (mode.equals("MaterialMode")) {
                nStartIndex = 4;
            } else if (mode.equals("DramaMode")) {
                nStartIndex = 0;
            }

            for (int i = nStartIndex; i < dramaAndMaterialControlButton.size(); i++) {
                String strTitleText = dramaAndMaterialControlButton.get(i).getAttribute("title");
                if (strTitleText.equals(strTitle)) {
                    nIndex = i;
                    break;
                }
            }
        }

        if (nIndex != -1 && null != dramaAndMaterialControlButton.get(nIndex)) {
            return dramaAndMaterialControlButton.get(nIndex);
        }
        return null;
    }

    /**
     * @Title: clickInsPointOfDramaButton
     * @Description: 点击添加剧智点按钮
     * @return void
     * @throws Exception
     */
    public void clickInsPointOfDramaButton() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击剧添加智点按钮
            WebElement controlButton = getControlButtonByTitle("DramaMode", "添加智点");

            if (null != controlButton) {
                controlButton.click();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 点击剧添加智点按钮 OK.-----");
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
     * @Title: clickInsMaterialButton
     * @Description: 点击添加集按钮
     * @return void
     * @throws Exception
     */
    public void clickInsMaterialButton() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击剧添加集按钮
            WebElement controlButton = getControlButtonByTitle("DramaMode", "添加集");

            if (null != controlButton) {
                controlButton.click();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 点击添加集按钮 OK.-----");
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
     * @Title: clickEditDramaButton
     * @Description: 点击编辑剧按钮
     * @return void
     * @throws Exception
     */
    public void clickEditDramaButton() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击编辑剧钮
            WebElement controlButton = getControlButtonByTitle("DramaMode", "编辑");

            if (null != controlButton) {
                controlButton.click();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 点击编辑剧按钮 OK.-----");
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
     * @Title: setEditMaterialNameContent
     * @Description: 编辑集名称
     * @return void
     */
    public void setEditMaterialNameContent(String materialText) {
        editMaterialNameInputBox.clear();
        editMaterialNameInputBox.click();
        editMaterialNameInputBox.sendKeys(materialText);
    }

    /**
     * @Title: setEditMaterialURLContent
     * @Description: 编辑视频地址
     * @return void
     */
    public void setEditMaterialURLContent(String URL) {
        editMaterialURLInputBox.clear();
        editMaterialURLInputBox.click();
        editMaterialURLInputBox.sendKeys(URL);
    }

    /**
     * @Title: setEditMaterialCreateTimeContent
     * @Description: 编辑创建时间
     * @return void
     */
    public void setEditMaterialCreateTimeContent(String CreateTime) {
        editMaterialCreateTimeInputBox.clear();
        editMaterialCreateTimeInputBox.click();
        editMaterialCreateTimeInputBox.sendKeys(CreateTime);
    }

    /**
     * @Title: setEditMaterialCreateTimeOfPointContent
     * @Description: 编辑智点创建时间
     * @return void
     */
    public void setEditMaterialCreateTimeOfPointContent(String CreateTimeOfPoint) {
        editMaterialCreateTimeOfPointInputBox.clear();
        editMaterialCreateTimeOfPointInputBox.click();
        editMaterialCreateTimeOfPointInputBox.sendKeys(CreateTimeOfPoint);
    }

    /**
     * @Title: clickCancelEditMaterialButton
     * @Description: 点击编辑集取消按钮
     * @return void
     */
    public void clickCancelEditMaterialButton() {
        cancelEditMaterialButton.click();
    }

    /**
     * @Title: clickSubmitEditMaterialButton
     * @Description: 点击编辑集确定按钮
     * @return void
     */
    public void clickSubmitEditMaterialButton() {
        submitEditMaterialButton.click();
    }

    /**
     * @Title: clickDeleteDramaButton
     * @Description: 点击删除剧按钮
     * @return void
     * @throws Exception
     */
    public void clickDeleteDramaButton() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击删除剧钮
            WebElement controlButton = getControlButtonByTitle("DramaMode", "删除");

            if (null != controlButton) {
                controlButton.click();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 点击删除剧按钮 OK.-----");
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
     * @Title: clickDeleteCancelDramaButton
     * @Description: 删除剧弹出框，取消按钮
     * @return void
     */
    public void clickDeleteCancelDramaButton() {
        deleteCancelDramaButton.click();
    }

    /**
     * @Title: clickDeleteOKDramaButton
     * @Description: 删除剧弹出框，确定按钮
     * @return void
     */
    public void clickDeleteOKDramaButton() {
        deleteOKDramaButton.click();
    }

    /**
     * @Title: clickExpandOpeningDramaButton
     * @Description: 点击展开剧列表按钮
     * @return void
     * @throws Exception
     */
    public void clickExpandOpeningDramaButton() throws Exception {

        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 点击展开剧列表
            expandOpeningDramaButton.click();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击展开剧列表: OK.-----");

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
     * @Title: clickExpandFodingDramaButton
     * @Description: 点击收合剧列表按钮
     * @return void
     * @throws Exception
     */
    public void clickExpandFodingDramaButton() throws Exception {

        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 点击收合剧列表
            expandFodingDramaButton.click();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击收合剧列表: OK.-----");

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
     * @Title: clickMaterialNameLink
     * @Description: 点击集名称连接
     * @return void
     * @throws Exception
     */
    public void clickMaterialNameLink() throws Exception {

        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 点击集名称链接
            materialNameLink.click();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击集名称链接，智点详情页面显示: OK.-----");

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
     * @Title: clickAllOnlineLink
     * @Description: 点击全部上线连接
     * @return void
     */
    public void clickAllOnlineLink() {
        allOnlineLink.click();
    }

    /**
     * @Title: clickAllOfflineLink
     * @Description: 点击全部下线连接
     * @return void
     */
    public void clickAllOfflineLink() {
        allOfflineLink.click();
    }

    /**
     * @Title: getAllOnlineTipText
     * @Description: 获取弹出提示框文字
     * @return
     * @return String
     */
    public String getAllOnlineTipText() {
        return allOnlineTipTextLabel.getText();
    }

    /**
     * @Title: clickCancelAllOnlineButton
     * @Description: 点击弹出框取消按钮
     * @return void
     */
    public void clickCancelAllOnlineButton() {
        cancelAllOnlineButton.click();
    }

    /**
     * @Title: clickOKAllOnlineButton
     * @Description: 点击弹出框确定按钮
     * @return void
     */
    public void clickOKAllOnlineButton() {
        okAllOnlineButton.click();
    }

    /**
     * @Title: clickInsPointOfMaterialButton
     * @Description: 点击添加集智点按钮
     * @return void
     * @throws Exception
     */
    public void clickInsPointOfMaterialButton() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击集添加智点剧钮
            WebElement controlButton = getControlButtonByTitle("MaterialMode", "添加智点");

            if (null != controlButton) {
                controlButton.click();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 点击集添加智点按钮 OK.-----");
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
     * @Title: clickEditMaterialButton
     * @Description: 点击编辑集按钮
     * @return void
     */
    public void clickEditMaterialButton() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击编辑集剧钮
            WebElement controlButton = getControlButtonByTitle("MaterialMode", "编辑");

            if (null != controlButton) {
                controlButton.click();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 点击编辑集按钮 OK.-----");
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
     * @Title: clickDeleteAllPointButton
     * @Description: 点击删除集所有智点按钮
     * @return void
     */
    public void clickDeleteAllPointButton() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击删除所有智点剧钮
            WebElement controlButton = getControlButtonByTitle("MaterialMode", "删除智点");

            if (null != controlButton) {
                controlButton.click();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 点击删除所有智点按钮 OK.-----");
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
     * @Title: clickDeleteCancelAllPointButton
     * @Description: 点击删除集所有智点按钮，取消按钮
     * @return void
     */
    public void clickDeleteCancelAllPointButton() {
        deleteCancelAllPointButton.click();
    }

    /**
     * @Title: clickDeleteOKAllPointButton
     * @Description: 点击删除集所有智点按钮，确定按钮
     * @return void
     */
    public void clickDeleteOKAllPointButton() {
        deleteOKAllPointButton.click();
    }

    /**
     * @Title: getDeleteTipTextLabel
     * @Description: 获取删除弹出框的文本文字
     * @return
     * @return String
     */
    public String getDeleteTipTextLabel() {
        return deleteTipTextLabel.getText();
    }

    /**
     * @Title: clickDeleteMaterialButton
     * @Description: 点击删除集按钮
     * @return void
     */
    public void clickDeleteMaterialButton() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击删除集剧钮
            WebElement controlButton = getControlButtonByTitle("MaterialMode", "删除");

            if (null != controlButton) {
                controlButton.click();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 点击删除集按钮 OK.-----");
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
     * @Title: clickMonitorMaterialButton
     * @Description: 点击监控集按钮
     * @return void
     */
    public void clickMonitorMaterialButton() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击监控集剧钮
            WebElement controlButton = getControlButtonByTitle("MaterialMode", "监控");

            if (null != controlButton) {
                controlButton.click();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 点击监控集按钮 OK.-----");
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
     * @Title: setSearchContent
     * @Description: 设置搜索框的文本
     * @param name
     * @return void
     */
    public void setSearchContent(String searchText) {
        searchInputBox.clear();
        searchInputBox.click();
        searchInputBox.sendKeys(searchText);
    }

    /**
     * @Title: clickSearchButton
     * @Description: 点击搜索按钮
     * @return void
     */
    public void clickSearchButton() {
        searchButton.click();
    }

    /**
     * @Title: clickChooseDramaRadioButton
     * @Description: 点击选择剧单选按钮
     * @return void
     */
    public void clickChooseDramaRadioButton() {
        chooseDramaRadioButton.click();
    }

    /**
     * @Title: clickChooseMaterialButton
     * @Description: 点击选择集按钮
     * @return void
     */
    public void clickChooseMaterialButton() {
        chooseMaterialButton.click();
    }

    /**
     * @Title: clickChooseMaterialCheckButton
     * @Description: 点击选择集复选框
     * @return void
     */
    public void clickChooseMaterialCheckButton() {
        chooseMaterialCheckButton.click();
    }

    /**
     * @Title: clickMaterialSumbitButton
     * @Description: 点击选择集确认按钮
     * @return void
     */
    public void clickMaterialSumbitButton() {
        materialSumbitButton.click();
    }

    /**
     * @Title: clickChooseTypeSelect
     * @Description: 点击选择类型下拉列表单
     * @return void
     */
    public void clickChooseTypeSelect() {
        chooseTypeSelect.click();
    }

    /**
     * @Title: setChooseTypeContent
     * @Description: 点击选择类型
     * @return void
     * @throws Exception
     */
    public void setChooseTypeContent(final String strType) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            WebDriverWait wait = new WebDriverWait(TestBase.getWebDriver(), 10, 1);
            // 每隔1秒去调用一下until中的函数，默认是0.5秒，如果等待10秒还没有找到元素 。则抛出异常。
            wait.until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver driver) {
                    // 易植贴类型
                    if (strType.equals(ProductTypeConstants.PRODUCT_TYPE_YIZHITIE)) {
                        return chooseYztTypeSelect;
                    } else if (strType.equals(ProductTypeConstants.PRODUCT_TYPE_HONGBAO)) {
                        // 红包类型
                        return chooseHongbaoTypeSelect;
                    } else if (strType.equals(ProductTypeConstants.PRODUCT_TYPE_YOUHUIMA)) {
                        // 优惠码类型
                        return chooseYouhuimaTypeSelect;
                    } else if (strType.equals(ProductTypeConstants.PRODUCT_TYPE_DONGTAISHICHUANG)) {
                        // 动态视窗类型
                        return chooseDtscTypeSelect;
                    }
                    return null;
                }
            }).click();
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
     * @Title: clickTimesModeRadioButton
     * @Description: 点击选择模式-次数模式
     * @return void
     */
    public void clickTimesModeRadioButton() {
        timesModeRadioButton.click();
    }

    /**
     * @Title: clickSelectDramaButton
     * @Description: 点击选择模式-间隔模式
     * @return void
     */
    public void clickIntervalModeRadioButton() {
        intervalModeRadioButton.click();
    }

    /**
     * @Title: setStartMinContent
     * @Description: 设置开始时间分钟
     * @param startMin
     * @return void
     */
    public void setStartMinContent(String startMin) {
        startMinInputBox.clear();
        startMinInputBox.click();
        startMinInputBox.sendKeys(startMin);
    }

    /**
     * @Title: setStartSecondContent
     * @Description: 设置开始时间秒
     * @param startSecond
     * @return void
     */
    public void setStartSecondContent(String startSecond) {
        startSecondInputBox.clear();
        startSecondInputBox.click();
        startSecondInputBox.sendKeys(startSecond);
    }

    /**
     * @Title: setEndMinContent
     * @Description: 设置结束时间分钟
     * @param endMin
     * @return void
     */
    public void setEndMinContent(String endMin) {
        endMinInputBox.clear();
        endMinInputBox.click();
        endMinInputBox.sendKeys(endMin);
    }

    /**
     * @Title: setEndSecondContent
     * @Description: 设置结束时间秒
     * @param endSecond
     * @return void
     */
    public void setEndSecondContent(String endSecond) {
        endSecondInputBox.clear();
        endSecondInputBox.click();
        endSecondInputBox.sendKeys(endSecond);
    }

    /**
     * @Title: setDisplayTimeContent
     * @Description: 设置展现时长
     * @param displayTime
     * @return void
     */
    public void setDisplayTimeContent(String displayTime) {
        displayTimeInputBox.clear();
        displayTimeInputBox.click();
        displayTimeInputBox.sendKeys(displayTime);
    }

    /**
     * @Title: setDisplayCountContent
     * @Description: 设置展现时长
     * @param displayTime
     * @return void
     */
    public void setDisplayCountContent(String displayCount) {
        displayCountInputBox.clear();
        displayCountInputBox.click();
        displayCountInputBox.sendKeys(displayCount);
    }

    /**
     * @Title: clickChooseProductSelect
     * @Description: 点击选择物料列表单
     * @param displayTime
     * @return void
     */
    public void clickChooseProductSelect() {
        chooseProductSelect.click();
    }

    /**
     * @Title: SetChooseProductList
     * @Description: 选择物料列表内容
     * @param
     * @return void
     * @throws Exception
     */
    public void SetChooseProductList(String strProductName) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            WebDriverWait wait = new WebDriverWait(TestBase.getWebDriver(), 10, 1);
            // 每隔1秒去调用一下until中的函数，默认是0.5秒，如果等待10秒还没有找到元素 。则抛出异常。
            wait.until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return chooseProductList;
                }
            }).click();
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
     * @Title: clickChoosePositionRadioButton
     * @Description: 选择坐标
     * @param
     * @return void
     */
    public void clickChoosePositionRadioButton() {
        choosePositionRadioButton.click();
    }

    /**
     * @Title: clickChoosePosition2RadioButton
     * @Description: 选择坐标
     * @param
     * @return void
     */
    public void clickChoosePosition2RadioButton() {
        choosePosition2RadioButton.click();
    }

    /**
     * @Title: clickEffectRadioButton
     * @Description: 选择动效
     * @param effectType
     * @return void
     */
    public void clickEffectRadioButton(String effectType) {
        // 动效为无
        if (effectType.equals("0")) {
            effectNoRadioButton.click();
        } else if (effectType.equals("1")) {
            effectShakeRadioButton.click();
        } else if (effectType.equals("2")) {
            effectTurnRadioButton.click();
        } else if (effectType.equals("3")) {
            effectZoomRadioButton.equals("4");
        } else {
            effectNoRadioButton.click();
        }
    }

    /**
     * @Title: clickSubmitPointButton
     * @Description: 添加智点确定按钮
     * @param
     * @return void
     */
    public void clickSubmitPointButton() {
        submitPointButton.click();
    }

    /**
     * @Title: clickCancelMaterialButton
     * @Description: 添加集页面的取消按钮
     * @param
     * @return void
     */
    public void clickCancelMaterialButton() {
        cancelMaterialButton.click();
    }

    /**
     * @Title: clickCoutinueAddPointButton
     * @Description: 点击继续添加按钮
     * @return void
     */
    public void clickCoutinueAddPointButton() {
        coutinueAddPointButton.click();
    }

    /**
     * @Title: clickSubmitPointOfMaterialButton
     * @Description: 添加智点确定按钮，集列表
     * @param
     * @return void
     */
    public void clickSubmitPointOfMaterialButton() {
        submitPointOfMaterialButton.click();
    }

    /**
     * @Title: clickCancelPointOfMaterialButton
     * @Description: 添加集页面的取消按钮，集列表
     * @param
     * @return void
     */
    public void clickCancelPointOfMaterialButton() {
        cancelPointOfMaterialButton.click();
    }

    /**
     * @Title: setEditDramaNameContent
     * @Description: 编辑剧页面的剧名称
     * @param
     * @return void
     */
    public void setEditDramaNameContent(String strDramaName) {
        editDramaNameInputBox.clear();
        editDramaNameInputBox.click();
        editDramaNameInputBox.sendKeys(strDramaName);
    }

    /**
     * @Title: clickSubmitEditDramaButton
     * @Description: 编辑剧页面的确定按钮
     * @param
     * @return void
     */
    public void clickSubmitEditDramaButton() {
        submitEditDramaButton.click();
    }

    /**
     * @Title: clickCancelEditDramaButton
     * @Description: 编辑剧页面的取消按钮
     * @param
     * @return void
     */
    public void clickCancelEditDramaButton() {
        cancelEditDramaButton.click();
    }

    /**
     * @Title: testCreateDrama
     * @Description: 选择媒资
     * @param strDramaName
     * @throws Exception
     * @return void
     */
    public void testCreateDrama(String strDramaName) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击选择媒资
            clickSelectDramaButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " 点击选择媒资 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_DramaList");

            // // 选择平台：芒果
            // driver.findElement(By.xpath("//*[@id='app']/div[2]/div/div[2]/div[1]/div[1]/div[1]/input")).click();
            // Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            // logger.info("-----" + strMethodName + " 选择平台：下拉菜单 OK.-----");
            //
            // driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/ul/li[2]")).click();
            // Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            // logger.info("-----" + strMethodName + " 选择平台：影谱 OK.-----");

            // 测试剧目：芒果TV2016招商片
            setSearchContent(strDramaName);
            clickSearchButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 选择平台：影谱剧 OK.-----");

            // 选择芒果测试剧目
            clickChooseDramaRadioButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 选择芒果测试剧目 OK.-----");

            // 点击选择集按钮
            clickChooseMaterialButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击选择集按钮 OK.-----");

            // 选择集画面：选择复选框
            clickChooseMaterialCheckButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 选择集画面：选择复选框 OK.-----");

            // 点击选择集确定按钮
            clickMaterialSumbitButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击选择集确定按钮 OK.-----");

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
     * @Title: testCreateYizhitiePoint
     * @Description: 创建易植贴智点
     * @param workOrderInfo
     * @throws Exception
     * @return void
     */
    public void testCreateYizhitiePoint(WorkOrderInfo workOrderInfo) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击添加智点按钮
            clickInsPointOfDramaButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建易植贴智点：选择类型 OK.-----");

            // 创建易植贴智点
            // 选择类型
            clickChooseTypeSelect();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            setChooseTypeContent(workOrderInfo.adType);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建易植贴智点：选择类型 OK.-----");

            // 选择模式-次数模式
            // clickTimesModeRadioButton();
            // Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            // logger.info("-----" + strMethodName + " 创建易植贴智点：选择模式-次数模式
            // OK.-----");

            // 开始时间-分
            setStartMinContent(workOrderInfo.startMin);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建易植贴智点：开始时间-分 OK.-----");

            // 开始时间-秒
            setStartSecondContent(workOrderInfo.startSecond);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建易植贴智点：开始时间-秒 OK.-----");

            // 结束时间-分
            setEndMinContent(workOrderInfo.endMin);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建易植贴智点：结束时间-分 OK.-----");

            // 结束时间-秒
            setEndSecondContent(workOrderInfo.endSecond);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建易植贴智点：结束时间-秒 OK.-----");

            // 展现时长
            setDisplayTimeContent(workOrderInfo.displayTime);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建易植贴智点：展现时长 OK.-----");

            // 展现次数
            setDisplayCountContent(workOrderInfo.displayCount);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建易植贴智点：展现次数 OK.-----");

            // 选择物料
            clickChooseProductSelect();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            SetChooseProductList(workOrderInfo.productName);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建易植贴智点：物料选择 OK.-----");

            // 选择动效-无
            clickEffectRadioButton(workOrderInfo.effect);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建易植贴智点：选择动效-无 OK.-----");

            // 选择坐标
            clickChoosePositionRadioButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建易植贴智点：选择坐标 OK.-----");

            // 确定按钮
            clickSubmitPointButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建易植贴智点：确定按钮 OK.-----");

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
     * @Title: testInsMaterialButton
     * @Description: 添加集测试用例
     * @throws Exception
     * @return void
     */
    public void testInsMaterialPage() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击添加集按钮
            clickInsMaterialButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 添加集页面显示 OK.-----");

            // 点击取消按钮
            clickCancelMaterialButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 添加集：点击取消按钮 OK.-----");

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
     * @Title: testEditDramaButton
     * @Description: 编辑剧测试用例
     * @param strDramaName
     * @throws Exception
     * @return void
     */
    public void testEditDramaButton(String strDramaName) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击编辑剧按钮
            clickEditDramaButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 编辑剧页面显示 OK.-----");

            // 点击取消按钮
            clickCancelEditDramaButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 编辑剧：点击取消按钮 OK.-----");

            // 点击编辑剧按钮
            clickEditDramaButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " 编辑剧页面显示 OK.-----");

            // 设置编辑剧名称
            setEditDramaNameContent(strDramaName);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 编辑剧：设置剧名称 OK.-----");

            // 点击确定按钮
            clickSubmitEditDramaButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 编辑剧：点击确定按钮 OK.-----");

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
     * @Title: testDeleteDramaButton
     * @Description: 点击删除剧按钮的操作
     * @param isDelete
     * @throws Exception
     * @return void
     */
    public void testDeleteDramaButton(boolean isDelete) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击删除剧按钮
            clickDeleteDramaButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 删除剧弹出框显示 OK.-----");

            if (isDelete) {
                // 点击确定按钮
                clickDeleteOKDramaButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 删除剧弹出框：点击确定按钮 OK.-----");
            } else {
                // 点击取消按钮
                clickDeleteCancelDramaButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 删除剧弹出框：点击取消按钮 OK.-----");
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
     * @Title: testInsMaterialPoint
     * @Description: 在集上添加指点
     * @param workOrderInfo
     * @throws Exception
     * @return void
     */
    public void testInsMaterialPoint(WorkOrderInfo workOrderInfo) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击添加智点按钮
            clickInsPointOfMaterialButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建集的易植贴智点：选择类型 OK.-----");

            // 创建易植贴智点
            // 选择类型
            clickChooseTypeSelect();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            setChooseTypeContent(workOrderInfo.adType);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建集的易植贴智点：选择类型 OK.-----");

            // 选择模式-次数模式
            // clickTimesModeRadioButton();
            // Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            // logger.info("-----" + strMethodName + " 创建易植贴智点：选择模式-次数模式
            // OK.-----");

            // 开始时间-分
            setStartMinContent(workOrderInfo.startMin);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建集的易植贴智点：开始时间-分 OK.-----");

            // 开始时间-秒
            setStartSecondContent(workOrderInfo.startSecond);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建集的易植贴智点：开始时间-秒 OK.-----");

            // 结束时间-分
            setEndMinContent(workOrderInfo.endMin);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建集的易植贴智点：结束时间-分 OK.-----");

            // 结束时间-秒
            setEndSecondContent(workOrderInfo.endSecond);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建集的易植贴智点：结束时间-秒 OK.-----");

            // 展现时长
            setDisplayTimeContent(workOrderInfo.displayTime);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建集的易植贴智点：展现时长 OK.-----");

            // 展现次数
            setDisplayCountContent(workOrderInfo.displayCount);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建集的易植贴智点：展现次数 OK.-----");

            // 选择物料
            clickChooseProductSelect();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            SetChooseProductList(workOrderInfo.productName);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建集的易植贴智点：物料选择 OK.-----");

            // 选择动效
            clickEffectRadioButton(workOrderInfo.effect);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建集的易植贴智点：选择动效" + workOrderInfo.effect + " OK.-----");

            // 选择坐标:中下
            clickChoosePosition2RadioButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建集的易植贴智点：选择坐标 OK.-----");

            // 点击继续添加按钮
            clickCoutinueAddPointButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " 创建集的易植贴智点：继续添加按钮 OK.-----");

            // 点击取消按钮
            clickCancelPointOfMaterialButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 创建集的易植贴智点：点击取消按钮 OK.-----");

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
     * @Title: testEditMaterialButton
     * @Description: 编辑集信息
     * @throws Exception
     * @return void
     */
    public void testEditMaterialButton(String materialText) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 编辑集信息
            clickEditMaterialButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 编辑集信息页面展示 OK.-----");

            // 点击取消按钮
            clickCancelEditMaterialButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 编辑集：点击取消按钮 OK.-----");

            // 编辑集信息
            clickEditMaterialButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 编辑集信息页面展示 OK.-----");

            // 编辑集名称
            setEditMaterialNameContent(materialText);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 编辑集：集名称 OK.-----");

            // 点击确定按钮
            clickSubmitEditMaterialButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 编辑集：点击确定按钮 OK.-----");

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
     * @Title: testDeleteAllPoints
     * @Description: 删除所有智点
     * @throws Exception
     * @return void
     */
    public void testDeleteAllPoints(boolean isDelete) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击删除所有智点
            clickDeleteAllPointButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击删除所有智点 OK.-----");

            // 获取弹出框提示文字
            getDeleteTipTextLabel();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 删除所有智点弹出框：获取提示文字 OK.-----");

            if (isDelete) {
                // 点击确定按钮
                clickDeleteOKAllPointButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 删除所有智点弹出框：点击确定按钮 OK.-----");
            } else {
                // 点击取消按钮
                clickDeleteCancelAllPointButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 删除所有智点弹出框：点击取消按钮 OK.-----");
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
     * @Title: testDeleteCurrentMaterial
     * @Description: 删除当前集列表
     * @throws Exception
     * @return void
     */
    public void testDeleteCurrentMaterial(boolean isDelete) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击删除集按钮
            clickDeleteMaterialButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击删除集按钮 OK.-----");

            // 获取弹出框提示文字
            getDeleteTipTextLabel();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 删除集弹出框：获取提示文字 OK.-----");

            if (isDelete) {
                // 点击确定按钮
                clickDeleteOKAllPointButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 删除集弹出框：点击确定按钮 OK.-----");
            } else {
                // 点击取消按钮
                clickDeleteCancelAllPointButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 删除集弹出框：点击取消按钮 OK.-----");
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
     * @Title: testMaterialMonitor
     * @Description: 设置集监控信息
     * @throws Exception
     * @return void
     */
    public void testMaterialMonitor(boolean isBack) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 设置集监控信息
            clickMonitorMaterialButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " 集监控：集监控页面显示 OK.-----");

            if (isBack) {
                // 返回到视频详情页面
                TestBase.navigateToBack();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 集监控：返回到视频详情 OK.-----");
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
     * @Title: testAllPointsOnline
     * @Description: 全部上线操作
     * @throws Exception
     * @return void
     */
    public void testAllPointsOnline(boolean isSelectOK) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击全部上线按钮
            clickAllOnlineLink();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击全部上线按钮 OK.-----");

            // 获取弹出框提示文字
            getAllOnlineTipText();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 全部上线弹出框：获取提示文字 OK.-----");

            if (isSelectOK) {
                // 点击确定按钮
                clickOKAllOnlineButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 全部上线弹出框：点击确定按钮 OK.-----");
            } else {
                // 点击取消按钮
                clickCancelAllOnlineButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 全部上线弹出框：点击取消按钮 OK.-----");
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
     * @Title: testAllPointsOffline
     * @Description: 全部下线操作
     * @throws Exception
     * @return void
     */
    public void testAllPointsOffline(boolean isSelectOK) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击全部上线按钮
            clickAllOfflineLink();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击全部下线按钮 OK.-----");

            // 获取弹出框提示文字
            getAllOnlineTipText();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 全部下线弹出框：获取提示文字 OK.-----");

            if (isSelectOK) {
                // 点击确定按钮
                clickOKAllOnlineButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 全部下线弹出框：点击确定按钮 OK.-----");
            } else {
                // 点击取消按钮
                clickCancelAllOnlineButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 全部下线弹出框：点击取消按钮 OK.-----");
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
