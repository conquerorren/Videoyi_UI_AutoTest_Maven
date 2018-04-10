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

import ai.qa.autotest.ui.constants.PointStatusConstants;
import ai.qa.autotest.ui.constants.ProductTypeConstants;
import ai.qa.autotest.ui.constants.VideoyiConstants;
import ai.qa.autotest.ui.custom.annotation.PageObject;
import ai.qa.autotest.ui.dataentity.WorkOrderInfo;
import ai.qa.autotest.ui.framework.constants.CommonConstants;
import ai.qa.autotest.ui.framework.utility.CommonUtil;
import ai.qa.autotest.ui.testbase.TestBase;

/**
 * @ClassName: WorkPointListPage
 * @Description: 投放计划视频详情页面
 * @author: Ren Qiang
 * @date: Mar 15, 2018
 */
@PageObject
public class WorkOrderPointListPage {

    // Logger信息
    private static Logger logger = LogManager.getLogger(AdminPortalLoginPage.class.getName());

    // 集信息行的操作按钮
    @FindAll({ @FindBy(className = "ControlButton") })
    private List<WebElement> MaterialControlButton;

    // 集行：点击全部上线连接
    @FindBy(how = How.XPATH, using = "//*[@id='drama_detail']/div/div[3]/table/tbody/tr/td[8]/div/span")
    private WebElement allOnlineLink;

    // 集行：点击全部下线连接
    @FindBy(how = How.XPATH, using = "//*[@id='drama_detail']/div/div[3]/table/tbody/tr/td[9]/div/span")
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

    // 创建易植贴智点：选择类型
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form[1]/div/div/div/div[1]/input")
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
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form[4]/div/div[1]/div[1]/div/div/label[1]")
    private WebElement timesModeRadioButton;

    // 创建易植贴智点：选择模式-间隔模式
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form[4]/div/div[1]/div[1]/div/div/label[2]")
    private WebElement intervalModeRadioButton;

    // 创建易植贴智点：开始时间-分
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form[4]/div/div[1]/div[2]/div/div[1]/div/div[1]/input")
    private WebElement startMinInputBox;

    // 创建易植贴智点：开始时间-秒
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form[4]/div/div[1]/div[2]/div/div[2]/div/div[1]/input")
    private WebElement startSecondInputBox;

    // 创建易植贴智点：结束时间-分
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form[4]/div/div[1]/div[3]/div/div[1]/div/div[1]/input")
    private WebElement endMinInputBox;

    // 创建易植贴智点：结束时间-秒
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form[4]/div/div[1]/div[3]/div/div[2]/div/div[1]/input")
    private WebElement endSecondInputBox;

    // 创建易植贴智点：展现时长
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form[4]/div/div[1]/div[4]/div/div[1]/input")
    private WebElement displayTimeInputBox;

    // 创建易植贴智点：展现次数
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form[4]/div/div[1]/div[5]/div/div[1]/input")
    private WebElement displayCountInputBox;

    // 创建易植贴智点：选择物料
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form[4]/div/div[1]/div[6]/div/div/div[1]/input")
    private WebElement chooseProductSelect;

    // 创建易植贴智点：选择物料-下拉菜单
    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div[1]/ul/li")
    private WebElement chooseProductList;

    // 创建易植贴智点：选择坐标：左下（第一个）
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form[4]/div/div[2]/div/div/div/label[1]")
    private WebElement choosePositionRadioButton;

    // 创建易植贴智点：选择坐标：中下（第二个）
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form[4]/div/div[2]/div/div/div/label[2]")
    private WebElement choosePosition2RadioButton;

    // 创建易植贴智点：选择动效-无
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form[4]/div/div[1]/div[8]/div/div/label[1]")
    private WebElement effectNoRadioButton;

    // 创建易植贴智点：选择动效-晃动
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form[4]/div/div[1]/div[8]/div/div/label[2]")
    private WebElement effectShakeRadioButton;

    // 创建易植贴智点：选择动效-翻转
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form[4]/div/div[1]/div[8]/div/div/label[2]")
    private WebElement effectTurnRadioButton;

    // 创建易植贴智点：选择动效-缩放
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form[4]/div/div[1]/div[8]/div/div/label[2]")
    private WebElement effectZoomRadioButton;

    // 创建易植贴智点：继续添加按钮
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/div/button[1]")
    private WebElement coutinueAddPointButton;

    // 创建易植贴智点：确定按钮
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/div/button[2]")
    private WebElement submitPointOfMaterialButton;

    // 创建易植贴智点：取消按钮
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/div/button[3]")
    private WebElement cancelPointOfMaterialButton;

    // 编辑集页面：集名称
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form/div[1]/div/div/input")
    private WebElement editMaterialNameInputBox;

    // 编辑集页面：视频地址
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form/div[2]/div/div/input")
    private WebElement editMaterialURLInputBox;

    // 编辑集页面：创建时间
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form/div[3]/div/div/input")
    private WebElement editMaterialCreateTimeInputBox;

    // 编辑集页面：创建时间
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form/div[4]/div/div/input")
    private WebElement editMaterialCreateTimeOfPointInputBox;

    // 编辑集页面：确定按钮
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form/div[5]/div/button[1]")
    private WebElement submitEditMaterialButton;

    // 编辑集页面：取消按钮
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/div/div[2]/form/div[5]/div/button[2]")
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

    // 智点类型选择筛选框
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[5]/div[2]/div/label")
    private WebElement pointTypeCheckBox;

    // 智点状态选择下拉框
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[5]/div[4]/div/div[1]/input")
    private WebElement pointStatusSelectButton;

    // 智点状态选择下拉框内容：全部
    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div[1]/ul/li[1]")
    private WebElement pointStatusAllSelectItem;

    // 智点状态选择下拉框内容：审核中
    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div[1]/ul/li[2]")
    private WebElement pointStatusReviewingSelectItem;

    // 智点状态选择下拉框内容：被驳回
    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div[1]/ul/li[3]")
    private WebElement pointStatusDismissedSelectItem;

    // 智点状态选择下拉框内容：已完成
    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div[1]/ul/li[4]")
    private WebElement pointStatusCompletedSelectItem;

    // 智点状态选择下拉框内容：上线
    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div[1]/ul/li[5]")
    private WebElement pointStatusOnlineSelectItem;

    // 智点状态选择下拉框内容：下线
    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div[1]/ul/li[6]")
    private WebElement pointStatusOfflineSelectItem;

    // 智点列表：查看预览连接
    @FindBy(how = How.XPATH, using = "//*[@id='point_list']/div/div[3]/table/tbody/tr/td[7]/div/button")
    private WebElement viewPreviewLink;

    // 编辑易植贴智点：取消按钮
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[8]/div/div[3]/div/button[1]")
    private WebElement cancelOfYztEditButton;

    // 编辑易植贴智点：确定按钮
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[8]/div/div[3]/div/button[2]")
    private WebElement okOfYztEditButton;

    // 编辑易植贴智点：编辑创建时间
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[8]/div/div[2]/form/div/div[1]/div[1]/div/div/input")
    private WebElement createTimeOfYztEditInputBox;

    // 编辑易植贴智点：创建时间日历确认按钮
    @FindBy(how = How.XPATH, using = "/html/body/div[5]/div[2]/button")
    private WebElement confirmCalendarButton;

    // 编辑易植贴智点：日历此刻按钮
    @FindBy(how = How.XPATH, using = "/html/body/div[5]/div[2]/a")
    private WebElement nowCalendarLink;

    // 编辑易植贴智点：开始时间输入框
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[8]/div/div[2]/form/div/div[1]/div[2]/div/div[1]/div/div/div/input")
    private WebElement startMinInputBoxOfYztEditInputBox;

    // 编辑易植贴智点：结束时间输入框
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[8]/div/div[2]/form/div/div[1]/div[2]/div/div[1]/div/div/div/input")
    private WebElement startSecondInputBoxOfYztEditInputBox;

    // 编辑易植贴智点：展现时长输入框
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[8]/div/div[2]/form/div/div[1]/div[3]/div/div/input")
    private WebElement displayTimeOfYztEditInputBox;

    // 编辑易植贴智点：动效-无状态
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[8]/div/div[2]/form/div/div[1]/div[6]/div/div/label[1]")
    private WebElement effectNoneOfYztEditButton;

    // 编辑易植贴智点：坐标-左下状态
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[8]/div/div[2]/form/div/div[2]/div/div/div/label[1]")
    private WebElement leftPostionOfYztEditButton;

    // 智点行：全部上线/下线文字
    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[2]/div[2]/p")
    private WebElement onlineTipTextLabel;

    /**
     * WorkPointListPage
     * 
     * @Description 初始化加载所有元素
     */
    public WorkOrderPointListPage() {
        PageFactory.initElements(TestBase.getWebDriver(), this);
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
            // 每隔1秒去调用一下until中的函数，默认是0.5秒，如果等待20秒还没有找到元素 。则抛出异常。
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
     * @Title: getControlButtonByTitle
     * @Description: 获取操作控件
     * @param strTitle
     * @return
     * @return WebElement
     */
    private WebElement getControlButtonByTitle(String mode, String strTitle) {
        // 点击剧添加智点按钮
        int nIndex = -1;
        if (null != MaterialControlButton) {
            int nStartIndex = 0;
            if (mode.equals(VideoyiConstants.FUNCTION_MATERIAL_MODE)) {
                nStartIndex = 0;
            } else if (mode.equals(VideoyiConstants.FUNCTION_POINT_MODE)) {
                nStartIndex = 6;
            }

            for (int i = nStartIndex; i < MaterialControlButton.size(); i++) {
                String strTitleText = MaterialControlButton.get(i).getAttribute("title");
                if (strTitleText.equals(strTitle)) {
                    nIndex = i;
                    break;
                }
            }
        }

        if (nIndex != -1 && null != MaterialControlButton.get(nIndex)) {
            return MaterialControlButton.get(nIndex);
        }
        return null;
    }

    /**
     * @Title: clickInsPointOfMaterialButton
     * @Description: 点击添加智点按钮
     * @return void
     * @throws Exception
     */
    public void clickInsPointOfMaterialButton() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击集信息的添加智点按钮
            WebElement controlButton = getControlButtonByTitle(VideoyiConstants.FUNCTION_MATERIAL_MODE,
                    VideoyiConstants.FUNCTION_BUTTON_INSERT_TEXT);

            if (null != controlButton) {
                controlButton.click();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 点击集信息的添加智点按钮 OK.-----");
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
            WebElement controlButton = getControlButtonByTitle(VideoyiConstants.FUNCTION_MATERIAL_MODE,
                    VideoyiConstants.FUNCTION_BUTTON_EDIT_TEXT);

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
            WebElement controlButton = getControlButtonByTitle(VideoyiConstants.FUNCTION_MATERIAL_MODE,
                    VideoyiConstants.FUNCTION_BUTTON_DELETEALL_TEXT);

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
            WebElement controlButton = getControlButtonByTitle(VideoyiConstants.FUNCTION_MATERIAL_MODE,
                    VideoyiConstants.FUNCTION_BUTTON_DELETE_TEXT);

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
            WebElement controlButton = getControlButtonByTitle(VideoyiConstants.FUNCTION_MATERIAL_MODE,
                    VideoyiConstants.FUNCTION_BUTTON_MONITOR_TEXT);

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
     * @Title: clickEditPointButton
     * @Description: 点击编辑智点按钮
     * @return void
     */
    public void clickEditPointButton() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击编辑智点剧钮
            WebElement controlButton = getControlButtonByTitle(VideoyiConstants.FUNCTION_POINT_MODE,
                    VideoyiConstants.FUNCTION_BUTTON_EDIT_TEXT);

            if (null != controlButton) {
                controlButton.click();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 点击编辑智点按钮 OK.-----");
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
     * @Title: clickDeletePointButton
     * @Description: 点击删除智点按钮
     * @return void
     */
    public void clickDeletePointButton() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击删除智点剧钮
            WebElement controlButton = getControlButtonByTitle(VideoyiConstants.FUNCTION_POINT_MODE,
                    VideoyiConstants.FUNCTION_BUTTON_DELETE_TEXT);

            if (null != controlButton) {
                controlButton.click();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 点击删除智点按钮 OK.-----");
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
     * @Title: clickOnlinePointButton
     * @Description: 点击上线智点按钮
     * @return void
     */
    public void clickOnlinePointButton() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击上线智点剧钮
            WebElement controlButton = getControlButtonByTitle(VideoyiConstants.FUNCTION_POINT_MODE,
                    VideoyiConstants.FUNCTION_BUTTON_ONLINE_TEXT);

            if (null != controlButton) {
                controlButton.click();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 点击上线智点按钮 OK.-----");
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
     * @Title: clickOfflinePointButton
     * @Description: 点击下线智点按钮
     * @return void
     */
    public void clickOfflinePointButton() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击下线智点剧钮
            WebElement controlButton = getControlButtonByTitle(VideoyiConstants.FUNCTION_POINT_MODE,
                    VideoyiConstants.FUNCTION_BUTTON_OFFLINE_TEXT);

            if (null != controlButton) {
                controlButton.click();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 点击下线智点按钮 OK.-----");
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
     * @Title: clickMonitorPointButton
     * @Description: 点击监控智点按钮
     * @return void
     */
    public void clickMonitorPointButton() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击监控智点剧钮
            WebElement controlButton = getControlButtonByTitle(VideoyiConstants.FUNCTION_POINT_MODE,
                    VideoyiConstants.FUNCTION_BUTTON_MONITOR_TEXT);

            if (null != controlButton) {
                controlButton.click();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 点击监控智点按钮 OK.-----");
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
     * @Title: clickPointTypeCheckBox
     * @Description: 点击智点类型选择筛选框
     * @return void
     */
    public void clickPointTypeCheckBox() {
        pointTypeCheckBox.click();
    }

    /**
     * @Title: clickPointStatusSelectButton
     * @Description: 智点状态选择下拉框
     * @return void
     */
    public void clickPointStatusSelectButton() {
        pointStatusSelectButton.click();
    }

    /**
     * @Title: setChoosePointStatusContent
     * @Description: 点击智点状态选择
     * @return void
     * @throws Exception
     */
    public void setChoosePointStatusContent(final String strType) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            WebDriverWait wait = new WebDriverWait(TestBase.getWebDriver(), 10, 1);
            // 每隔1秒去调用一下until中的函数，默认是0.5秒，如果等待10秒还没有找到元素 。则抛出异常。
            wait.until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver driver) {
                    // 全部
                    if (strType.equals(PointStatusConstants.POINT_STATUS_ALL)) {
                        return pointStatusAllSelectItem;
                    } else if (strType.equals(PointStatusConstants.POINT_STATUS_REVIEWING)) {
                        // 审核中
                        return pointStatusReviewingSelectItem;
                    } else if (strType.equals(PointStatusConstants.POINT_STATUS_DISMISSED)) {
                        // 被驳回
                        return pointStatusDismissedSelectItem;
                    } else if (strType.equals(PointStatusConstants.POINT_STATUS_COMPLETED)) {
                        // 已完成
                        return pointStatusCompletedSelectItem;
                    } else if (strType.equals(PointStatusConstants.POINT_STATUS_ONLINE)) {
                        // 上线
                        return pointStatusOnlineSelectItem;
                    } else if (strType.equals(PointStatusConstants.POINT_STATUS_OFFLINE)) {
                        // 下线
                        return pointStatusOfflineSelectItem;
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
     * @Title: clickViewPreviewLink
     * @Description: 智点列表：查看预览连接
     * @return void
     */
    public void clickViewPreviewLink() {
        viewPreviewLink.click();
    }

    /**
     * @Title: clickCancelOfYztEditButton
     * @Description: 编辑易植贴智点：点击取消按钮
     * @return void
     */
    public void clickCancelOfYztEditButton() {
        cancelOfYztEditButton.click();
    }

    /**
     * @Title: clickOkOfYztEditButton
     * @Description: 编辑易植贴智点：点击确定按钮
     * @return void
     */
    public void clickOkOfYztEditButton() {
        okOfYztEditButton.click();
    }

    /**
     * @Title: setCreateTimeOfYztEditContent
     * @Description: 编辑易植贴智点：修改创建时间
     * @return void
     */
    public void setCreateTimeOfYztEditContent(String createTime) {
        createTimeOfYztEditInputBox.clear();
        createTimeOfYztEditInputBox.click();
        createTimeOfYztEditInputBox.sendKeys(createTime);
    }

    /**
     * @Title: setStartTimeOfYztEditContent
     * @Description: 编辑易植贴智点：修改开始时间
     * @return void
     */
    public void setStartMinOfYztEditContent(String startMin) {
        startMinInputBoxOfYztEditInputBox.clear();
        startMinInputBoxOfYztEditInputBox.click();
        startMinInputBoxOfYztEditInputBox.sendKeys(startMin);
    }

    /**
     * @Title: setEndTimeOfYztEditContent
     * @Description: 编辑易植贴智点：修改结束时间
     * @return void
     */
    public void setStartSecondOfYztEditContent(String startSecond) {
        startSecondInputBoxOfYztEditInputBox.clear();
        startSecondInputBoxOfYztEditInputBox.click();
        startSecondInputBoxOfYztEditInputBox.sendKeys(startSecond);
    }

    /**
     * @Title: setDisplayTimeOfYztEditContent
     * @Description: 编辑易植贴智点：修改展现时间
     * @return void
     */
    public void setDisplayTimeOfYztEditContent(String displayTime) {
        displayTimeOfYztEditInputBox.clear();
        displayTimeOfYztEditInputBox.click();
        displayTimeOfYztEditInputBox.sendKeys(displayTime);
    }

    /**
     * @Title: clickEffectNoneOfYztEditButton
     * @Description: 编辑易植贴智点：修改动效为无
     * @return void
     */
    public void clickEffectNoneOfYztEditButton() {
        effectNoneOfYztEditButton.click();
    }

    /**
     * @Title: clickEffectNoneOfYztEditButton
     * @Description: 编辑易植贴智点：修改坐标为左下
     * @return void
     */
    public void clickLeftPostionOfYztEditButton() {
        leftPostionOfYztEditButton.click();

    }

    /**
     * @Title: testInsMaterialPoint
     * @Description: 在集上添加智点
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
            logger.info("-----" + strMethodName + " 点击创建集的易植贴智点OK.-----");

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

    /**
     * @Title: testEditPointButton
     * @Description: 编辑智点信息
     * @param workOrderInfo
     * @throws Exception
     * @return void
     */
    public void testEditPointButton(WorkOrderInfo workOrderInfo) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击编辑智点按钮
            clickEditPointButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击编辑易植贴智点 OK.-----");

            // 开始时间-分
            setStartMinOfYztEditContent(workOrderInfo.startMin);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 编辑易植贴智点：开始时间-分 OK.-----");

            // 开始时间-秒
            setStartSecondOfYztEditContent(workOrderInfo.startSecond);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 编辑易植贴智点：开始时间-秒 OK.-----");

            // 展现时长
            setDisplayTimeOfYztEditContent(workOrderInfo.displayTime);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 编辑易植贴智点：展现时长 OK.-----");

            // 选择动效
            clickEffectNoneOfYztEditButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 编辑易植贴智点：选择动效" + workOrderInfo.effect + " OK.-----");

            // 选择坐标:中下
            clickLeftPostionOfYztEditButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 编辑易植贴智点：选择坐标 OK.-----");

            // 点击确定按钮
            clickOkOfYztEditButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " 编辑易植贴智点：点击确定按钮 OK.-----");

            // 点击取消按钮
            clickCancelOfYztEditButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 编辑易植贴智点：点击取消按钮 OK.-----");

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
     * @Title: testDeleteCurrentPoint
     * @Description: 删除当前智点信息
     * @throws Exception
     * @return void
     */
    public void testDeleteCurrentPoint(boolean isDelete) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击删除智点按钮
            clickDeletePointButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击删除智点按钮 OK.-----");

            // 获取弹出框提示文字
            getDeleteTipTextLabel();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 删除智点弹出框：获取提示文字 OK.-----");

            if (isDelete) {
                // 点击确定按钮
                clickDeleteOKAllPointButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 删除智点弹出框：点击确定按钮 OK.-----");
            } else {
                // 点击取消按钮
                clickDeleteCancelAllPointButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 删除智点弹出框：点击取消按钮 OK.-----");
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
     * @Title: testOnlinePoint
     * @Description: 上线/下线智点
     * @throws Exception
     * @return void
     */
    public void testOnlinePoint(boolean isOnline, boolean isDelete) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            if (isOnline) {
                // 点击上线按钮
                clickOnlinePointButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 点击上线智点 OK.-----");
            } else {
                // 点击下线按钮
                clickOfflinePointButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 点击下线智点 OK.-----");
            }

            // 获取弹出框提示文字
            getAllOnlineTipText();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 删除智点弹出框：获取提示文字 OK.-----");

            if (isDelete) {
                // 点击确定按钮
                clickDeleteOKAllPointButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 删除智点弹出框：点击确定按钮 OK.-----");
            } else {
                // 点击取消按钮
                clickDeleteCancelAllPointButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 删除智点弹出框：点击取消按钮 OK.-----");
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
     * @Title: testPointMonitor
     * @Description: 设置智点监控信息
     * @throws Exception
     * @return void
     */
    public void testPointMonitor(boolean isBack) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 设置智点监控信息
            clickMonitorPointButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " 智点监控：智点监控页面显示 OK.-----");

            if (isBack) {
                // 返回到智点详情页面
                TestBase.navigateToBack();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 智点监控：返回到智点详情 OK.-----");
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
