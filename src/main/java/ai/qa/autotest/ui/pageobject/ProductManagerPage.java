/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.pageobject
 * @author Ren Qiang
 * @date:Mar 7, 2018
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.pageobject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ai.qa.autotest.ui.constants.ProductTypeConstants;
import ai.qa.autotest.ui.constants.ProductTypeConstants.ProductType;
import ai.qa.autotest.ui.custom.annotation.PageObject;
import ai.qa.autotest.ui.framework.constants.CommonConstants;
import ai.qa.autotest.ui.framework.utility.CommonUtil;
import ai.qa.autotest.ui.testbase.TestBase;

/**
 * @ClassName: ProductManagerPage
 * @Description: TODO
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
@PageObject
public class ProductManagerPage {
    // Logger信息
    private static Logger logger = LogManager.getLogger(AdminPortalLoginPage.class.getName());

    // 团队筛选
    @FindBy(how = How.NAME, using = "team_id")
    private WebElement teamIDSelect;

    // 客户筛选
    @FindBy(how = How.NAME, using = "member_id")
    private WebElement memberIDSelect;

    // 状态筛选
    @FindBy(how = How.NAME, using = "state")
    private WebElement stateSelect;

    // 类型筛选
    @FindBy(how = How.NAME, using = "product_type")
    private WebElement typeSelect;

    // 名称搜索
    @FindBy(how = How.NAME, using = "product_name")
    private WebElement nameInputBox;

    // 检索按钮
    @FindBy(how = How.ID, using = "search")
    private WebElement searchButton;

    // 新建物料按钮
    @FindBy(how = How.XPATH, using = "//*[@id='right_main_height']/div[2]/div[6]/input")
    private WebElement createProductButton;

    // 编辑物料按钮
    @FindBy(how = How.XPATH, using = "//*[@id='product_list']/table/tbody/tr[2]/td[8]/span/img")
    private WebElement editProductButton;

    // 删除按钮
    @FindBy(how = How.XPATH, using = "//*[@id='product_list']/table/tbody/tr[2]/td[9]/span/img")
    private WebElement deleteButton;

    // 物料名称链接
    @FindBy(how = How.CLASS_NAME, using = "detail")
    private WebElement productNameLink;

    // 物料详情页，返回按钮
    @FindBy(how = How.CLASS_NAME, using = "up_yb")
    private WebElement backButton;

    // 物料预览
    @FindBy(how = How.XPATH, using = "//*[@id='linktwo']/a")
    private WebElement productImgLink;

    // 物料预览关闭按钮：红包
    @FindBy(how = How.XPATH, using = "//*[@id='Hongbao2']/div[1]/span")
    private WebElement productImgHongbaoCloseButton;

    // 物料预览关闭按钮：优惠码
    @FindBy(how = How.XPATH, using = "//*[@id='Youhui2']/div[1]/span")
    private WebElement productImgYouhuimaCloseButton;

    // 物料预览关闭按钮：易植贴
    @FindBy(how = How.XPATH, using = "//*[@id='corner2']/div[1]/span")
    private WebElement productImgCornerCloseButton;

    // 物料预览关闭按钮：动态视窗
    @FindBy(how = How.CLASS_NAME, using = "tc_close")
    private WebElement productImgDTSCCloseButton;

    /**
     * ProductManagerPage
     * 
     * @Description 初始化加载所有元素
     */
    public ProductManagerPage() {
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
     * @Title: setStateContent
     * @Description: 设置状态筛选
     * @param state
     * @return void
     */
    public void setStateContent(String state) {
        new Select(stateSelect).selectByVisibleText(state);
    }

    /**
     * @Title: setTypeContent
     * @Description: 设置类型筛选
     * @param type
     * @return void
     */
    public void setTypeContent(String type) {
        new Select(typeSelect).selectByVisibleText(type);
    }

    /**
     * @Title: setNameContent
     * @Description: 设置名称搜索文字
     * @param name
     * @return void
     */
    public void setNameContent(String name) {
        nameInputBox.clear();
        nameInputBox.click();
        nameInputBox.sendKeys(name);
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
     * @Title: testClickProductNameLink
     * @Description: 点击物料名称链接
     * @return void
     * @throws Exception
     */
    public void testClickProductNameLink() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 点击物料名称链接
            productNameLink.click();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击物料名称链接 OK.-----");

            // 点击物料详情返回按钮
            logger.info("-----" + strMethodName + " 物料详情页面显示 OK.-----");
            clickBackButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 返回物料管理页面 OK.-----");

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
     * @Title: testClickProductImgLink
     * @Description: 点击物料图片链接且关闭物料预览
     * @return void
     * @throws Exception
     */
    public void testClickProductImgLink(ProductType productType) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 点击物料图片链接
            productImgLink.click();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击物料图片链接 OK.-----");

            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            // 点击物料关闭按钮
            switch (productType) {
            case BAIKE:

                break;

            case GOUWU:

                break;

            case HONGBAO:
                productImgHongbaoCloseButton.click();
                break;

            case YOUHUIMA:
                productImgYouhuimaCloseButton.click();
                break;

            case TOUPIAO:

                break;

            case SHENZIMU:

                break;

            case YIZHITIE:
                productImgCornerCloseButton.click();
                break;

            case DONGTAISHICHUANG:
                productImgDTSCCloseButton.click();
                break;

            default:
                productImgDTSCCloseButton.click();
                break;
            }
            logger.info("-----" + strMethodName + " 点击物料关闭按钮 OK.-----");

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
     * @Title: isEditPresent
     * @Description: 判断编辑按钮是否存在
     * @return
     * @return boolean
     */
    public boolean isEditPresent() {
        boolean isPresent = CommonUtil
                .isElementPresent(By.xpath("//*[@id='product_list']/table/tbody/tr[2]/td[8]/span/img"));
        return isPresent;
    }

    /**
     * @Title: clickCreateProduct
     * @Description: 点击创建物料
     * @throws Exception
     * @return void
     */
    public void clickCreateProduct() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            createProductButton.click();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击创建物料OK.-----");
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
     * @Title: clickEditProduct
     * @Description: 点击编辑物料
     * @throws Exception
     * @return void
     */
    public void clickEditProduct() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            editProductButton.click();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击编辑物料OK.-----");
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
     * @Title: testSearchProduct
     * @Description: 物料检索测试用例
     * @throws Exception
     * @return void
     */
    public void testSearchProduct(String strTeamID, String strMemberID, String strKeyword) throws Exception {
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

            // 选择状态过滤:生成中
            setStateContent("生成中");
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 选择状态：生成中 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SelectStatus_1_SearchResult");

            // 选择状态过滤:生成失败
            setStateContent("生成失败");
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 选择状态：生成失败 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SelectStatus_2_SearchResult");

            // 选择状态过滤:待审核
            setStateContent("待审核");
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 选择状态：审核中 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SelectStatus_3_SearchResult");

            // 选择状态过滤:审核中
            setStateContent("审核中");
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 选择状态：审核中 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SelectStatus_4_SearchResult");

            // 选择状态过滤:未通过
            setStateContent("未通过");
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 选择状态：未通过 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SelectStatus_5_SearchResult");

            // 选择状态过滤:已通过
            setStateContent("已通过");
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 选择状态：已通过 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SelectStatus_6_SearchResult");

            // 取消选择状态过滤:全部状态
            setStateContent("全部状态");
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 取消选择状态：全部状态 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SelectStatus_Default_SearchResult");

            // 选择类型过滤:百科信息
            // setTypeContent(ProductTypeConstants.PRODUCT_TYPE_BAIKE);
            // Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            // logger.info("-----" + strMethodName + " 选择类型：百科信息 OK.-----");
            // CommonUtil.TakeScreenShot(strMethodName +
            // "_SelectType_1_SearchResult");
            //
            // // 选择类型过滤:购物
            // setTypeContent(ProductTypeConstants.PRODUCT_TYPE_GOUWU);
            // Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            // logger.info("-----" + strMethodName + " 选择类型：购物 OK.-----");
            // CommonUtil.TakeScreenShot(strMethodName +
            // "_SelectType_2_SearchResult");
            //
            // 选择类型过滤:红包
            setTypeContent(ProductTypeConstants.PRODUCT_TYPE_HONGBAO);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 选择类型：红包 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SelectType_3_SearchResult");

            // 选择类型过滤:优惠码
            setTypeContent(ProductTypeConstants.PRODUCT_TYPE_YOUHUIMA);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 选择类型：优惠码 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SelectType_4_SearchResult");
            //
            // // 选择类型过滤:投票
            // setTypeContent(ProductTypeConstants.PRODUCT_TYPE_TOUPIAO);
            // Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            // logger.info("-----" + strMethodName + " 选择类型：投票 OK.-----");
            // CommonUtil.TakeScreenShot(strMethodName +
            // "_SelectType_5_SearchResult");
            //
            // // 选择类型过滤:神字幕
            // setTypeContent(ProductTypeConstants.PRODUCT_TYPE_SHENZIMU);
            // Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            // logger.info("-----" + strMethodName + " 选择类型：神字幕 OK.-----");
            // CommonUtil.TakeScreenShot(strMethodName +
            // "_SelectType_6_SearchResult");

            // 选择类型过滤:易植贴
            setTypeContent(ProductTypeConstants.PRODUCT_TYPE_YIZHITIE);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 选择类型：易植贴 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SelectType_7_SearchResult");

            // 选择类型过滤:动态视窗
            setTypeContent(ProductTypeConstants.PRODUCT_TYPE_DONGTAISHICHUANG);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 选择类型：动态视窗 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SelectType_8_SearchResult");

            // 取消选择类型过滤:全部类型
            setTypeContent("全部类型");
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 选择类型：全部类型 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SelectType_Default_SearchResult");

            // 名称搜索
            setNameContent(strKeyword);
            clickSearchButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 名称搜索 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SearchResult");

            // 取消名称搜索
            setNameContent("");
            clickSearchButton();
            logger.info("-----" + strMethodName + " 取消名称搜索 OK.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_SearchResult");

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
     * @Title: testDeleteProductCancel
     * @Description: 删除物料确认框，点击取消
     * @throws Exception
     * @return void
     */
    public void testDeleteProductCancel() throws Exception {
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
     * @Title: testDeleteProductOK
     * @Description: 删除物料确认框，点击OK
     * @throws Exception
     * @return void
     */
    public void testDeleteProductOK() throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " Start.-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Init");

            // 点击删除
            clickDeleteButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);

            // 点击删除确定
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
            CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_DISMISS);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----Handle UnhandledAlertException-----");
            CommonUtil.TakeScreenShot(strMethodName + "_Exception_Success");
            logger.info("-----" + strMethodName + " Exception Success.-----");
        }
    }
}
