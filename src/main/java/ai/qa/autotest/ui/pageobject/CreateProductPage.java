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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ai.qa.autotest.ui.constants.ProductTypeConstants.ProductType;
import ai.qa.autotest.ui.constants.VideoyiConstants;
import ai.qa.autotest.ui.custom.annotation.PageObject;
import ai.qa.autotest.ui.dataentity.ProductInfo;
import ai.qa.autotest.ui.framework.constants.CommonConstants;
import ai.qa.autotest.ui.framework.utility.CommonUtil;
import ai.qa.autotest.ui.testbase.TestBase;

/*
 * 
 * @ClassName: CreateProductPage 
 * @Description: 创建物料页面
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
@PageObject
public class CreateProductPage {
    // Logger信息
    private static Logger logger = LogManager.getLogger(AdminPortalLoginPage.class.getName());

    // TODO：百科信息按钮
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div[2]/div/label[1]")
    private WebElement baikeButton;

    // TODO:购物信息按钮
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div[2]/div/label[2]")
    private WebElement gouwuButton;

    // 红包信息按钮
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div[2]/div/label[1]")
    private WebElement hongbaoButton;

    // 优惠码信息按钮
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div[2]/div/label[2]")
    private WebElement youhuimaButton;

    // TODO：投票信息按钮
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div[2]/div/label[5]")
    private WebElement toupiaoButton;

    // TODO：神字幕信息按钮
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div[2]/div/label[6]")
    private WebElement shenzimuButton;

    // 易植贴信息按钮
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div[2]/div/label[3]")
    private WebElement yizhitieButton;

    // 动态视窗信息按钮
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div[2]/div/label[4]")
    private WebElement dtscButton;

    // 共通：物料提示语
    @FindBy(how = How.ID, using = "case_tip")
    private WebElement caseTipLabel;

    // 共通：团队归属
    @FindBy(how = How.ID, using = "team_id")
    private WebElement teamIDSelect;

    // 共通：客户筛选
    @FindBy(how = How.ID, using = "member_id")
    private WebElement memberIDSelect;

    // 共通：归属平台
    @FindBy(how = How.ID, using = "platform")
    private WebElement platformSelect;

    // 共通：物料名称
    @FindBy(how = How.NAME, using = "product_name")
    private WebElement productNameInputBox;

    // 共通：物料分类
    @FindBy(how = How.ID, using = "category")
    private WebElement categorySelect;

    // 共通：按钮文案
    @FindBy(how = How.NAME, using = "product_text")
    private WebElement productTextInputBox;

    // 活动说明
    @FindBy(how = How.NAME, using = "activity_description")
    private WebElement activityDescriptionInputBox;

    // 红包：红包口令
    @FindBy(how = How.NAME, using = "red_packet")
    private WebElement redPacketInputBox;

    // 红包：兑换说明
    @FindBy(how = How.NAME, using = "convert_description")
    private WebElement convertDescriptionInputBox;

    // 优惠码：结束说明
    @FindBy(how = How.NAME, using = "end_description")
    private WebElement endDescriptionInputBox;

    // 详细描述
    @FindBy(how = How.ID, using = "product_description_text")
    private WebElement productDescriptionTextInputBox;

    // 共通：跳转链接
    @FindBy(how = How.NAME, using = "click_link")
    private WebElement clickLinkInputBox;

    // 红包：价格
    @FindBy(how = How.NAME, using = "product_min_price")
    private WebElement productMinPriceInputBox;

    // 优惠码：追加按钮
    @FindBy(how = How.ID, using = "addition")
    private WebElement additionButton;

    // 优惠码：优惠码口令
    @FindBy(how = How.NAME, using = "convert_code")
    private WebElement convertCodeInputBox;

    // 投票：选择版式:上下版式
    @FindBy(how = How.XPATH, using = "//*[@id='format_border']/label[1]")
    private WebElement formatUpDownButton;

    // 投票：选择版式:左右版式
    @FindBy(how = How.XPATH, using = "//*[@id='format_border']/label[2]")
    private WebElement formatLeftRightButton;

    // 投票：投票提问
    @FindBy(how = How.ID, using = "vote_problem")
    private WebElement voteProblemInputBox;

    // 投票：投票选项1：创建
    @FindBy(how = How.XPATH, using = "//*[@id='option_val']/div[1]/input")
    private WebElement voteOption1InputBox;

    // 投票：投票选项1:编辑
    @FindBy(how = How.XPATH, using = "//*[@id='option_val']/div[1]/input[1]")
    private WebElement voteOption1EditInputBox;

    // 投票：投票选项2：创建
    @FindBy(how = How.XPATH, using = "//*[@id='option_val']/div[2]/input")
    private WebElement voteOption2InputBox;

    // 投票：投票选项2:编辑
    @FindBy(how = How.XPATH, using = "//*[@id='option_val']/div[2]/input[1]")
    private WebElement voteOption2EditInputBox;

    // 投票：添加选项
    @FindBy(how = How.ID, using = "add_option")
    private WebElement addOptionButton;

    // 投票：投票选项3
    @FindBy(how = How.XPATH, using = "//*[@id='option_val']/div[3]/input")
    private WebElement voteOption3InputBox;

    // 投票：删除投票选项3
    @FindBy(how = How.XPATH, using = "//*[@id='option_val']/div[3]/button")
    private WebElement detelteVoteOption3Button;

    // 神字幕：选择版式:基础类
    @FindBy(how = How.ID, using = "format_id")
    private WebElement formatIDSelete;

    // 神字幕：选择版式:样式一
    @FindBy(how = How.ID, using = "style_id")
    private WebElement styleIDSelete;

    // 共通：客户LOGO
    @FindBy(how = How.ID, using = "client_logo_border")
    private WebElement clientLogoImgBox;

    // 共通：广告图片
    @FindBy(how = How.ID, using = "template_img_border")
    private WebElement templateImgBox;

    // 百科 ，购物：展示图片:0
    @FindBy(how = How.ID, using = "show_img_div_0")
    private WebElement showImgDiv0ImgBox;

    // 百科 ，购物：展示图片:1
    @FindBy(how = How.ID, using = "show_img_div_1")
    private WebElement showImgDiv1ImgBox;

    // 百科 ，购物：删除展示图片
    @FindBy(how = How.XPATH, using = "//*[@id='show_img_add']/div[1]/div[1]")
    private WebElement deleteShowImgImgBox;

    // 选择图标:Video易默认图标（百科，购物，红包，优惠码，投票）
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div[30]/div/label[1]")
    private WebElement defaultIconSelectButton;

    // TODO:百科：选择图标：自定义图标：编辑
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[12]/div/label[2]")
    private WebElement customizeBaikeIconButton;

    // TODO:购物：选择图标：自定义图标：编辑
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[13]/div/label[2]")
    private WebElement customizeGouwuIconButton;

    // TODO:投票：选择图标：自定义图标：编辑
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[14]/div/label[2]")
    private WebElement customizeToupiaoIconButton;

    // 红包：选择图标：自定义图标：编辑
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[17]/div/label[2]")
    private WebElement customizeHongbaoIconButton;

    // 优惠码：选择图标：自定义图标：编辑
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[18]/div/label[2]")
    private WebElement customizeYouhuimaIconButton;

    // 共通：选择自定义图标的图片
    @FindBy(how = How.ID, using = "customize_div")
    private WebElement customizeIconImgBox;

    // 百科：选择 Video易默认图标
    @FindBy(how = How.ID, using = "icon_id61")
    private WebElement defaultBaikeButton;

    // 购物：选择 Video易默认图标
    @FindBy(how = How.ID, using = "icon_id71")
    private WebElement defaultGouwuButton;

    // 红包：选择 Video易默认图标
    @FindBy(how = How.ID, using = "icon_id81")
    private WebElement defaultHongbaoButton;

    // 优惠码：选择 Video易默认图标
    @FindBy(how = How.ID, using = "icon_id91")
    private WebElement defaultYouhuimaButton;

    // 投票：选择 Video易默认图标
    @FindBy(how = How.ID, using = "icon_id101")
    private WebElement defaultToupiaoButton;

    // 百科：选择颜色
    @FindBy(how = How.XPATH, using = "//*[@id='style']/div[3]/div/label[2]")
    private WebElement colorBaikeSelectButton;

    // 购物：选择颜色
    @FindBy(how = How.XPATH, using = "//*[@id='style']/div[3]/div/label[3]")
    private WebElement colorGouwuSelectButton;

    // 百科：选择颜色:默认
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[17]/div/label[1]")
    private WebElement defaultColorBaikeButton;

    // 百科：选择颜色:蓝色
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[17]/div/label[2]")
    private WebElement blueColorBaikeButton;

    // 百科：选择颜色:紫色
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[17]/div/label[3]")
    private WebElement pinkColorBaikeButton;

    // 百科：选择颜色:自定义颜色
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[17]/div/label[4]")
    private WebElement customizeColorBaikeButton;

    // 百科：选择颜色:自定义颜色:R
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[17]/div/div/input[1]")
    private WebElement customizeRColorBaikeInputBox;

    // 百科：选择颜色:自定义颜色:G
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[17]/div/div/input[2]")
    private WebElement customizeGColorBaikeInputBox;

    // 百科：选择颜色:自定义颜色:B
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[17]/div/div/input[3]")
    private WebElement customizeBColorBaikeInputBox;

    // 购物：选择颜色:默认
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[18]/div/label[1]")
    private WebElement defaultColorGouwuButton;

    // 购物：选择颜色:蓝色
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[18]/div/label[2]")
    private WebElement blueColorGouwuButton;

    // 购物：选择颜色:紫色
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[18]/div/label[3]")
    private WebElement pinkColorGouwuButton;

    // 购物：选择颜色:自定义颜色
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[18]/div/label[4]")
    private WebElement customizeColorGouwuButton;

    // 购物：选择颜色:自定义颜色:R
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[18]/div/div/input[1]")
    private WebElement customizeRColorGouwuInputBox;

    // 购物：选择颜色:自定义颜色:G
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[18]/div/div/input[2]")
    private WebElement customizeGColorGouwuInputBox;

    // 购物：选择颜色:自定义颜色:B
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[18]/div/div/input[3]")
    private WebElement customizeBColorGouwuInputBox;

    // 百科，购物：选择边框
    @FindBy(how = How.ID, using = "img_val_border")
    private WebElement imgValBorderImgBox;

    // 百科，购物：选择边框:删除边框
    @FindBy(how = How.XPATH, using = "//*[@id='img_val_border']/div")
    private WebElement imgValBorderDeleteButton;

    // 百科：logo位置一，编辑
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[21]/div/label[1]")
    private WebElement logo1EditSelectButton;

    // 购物：logo位置一，创建
    @FindBy(how = How.XPATH, using = "//*[@id='style']/div[7]/div/label[1]")
    private WebElement logo1CreateSelectButton;

    // 百科：logo位置二，创建
    @FindBy(how = How.XPATH, using = "//*[@id='style']/div[7]/div/label[2]")
    private WebElement logo2CreateSelectButton;

    // 购物：logo位置二，编辑
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[22]/div/label[2]")
    private WebElement logo2EditSelectButton;

    // 百科，购物：logo图片
    @FindBy(how = How.ID, using = "logo_img_border")
    private WebElement logoImgBorderImgBox;

    // 神字幕：点击效果：选择无
    @FindBy(how = How.XPATH, using = "//*[@id='click_effect']/div[1]/div[2]/label[1]")
    private WebElement clickEffectNoneButton;

    // 神字幕：点击效果：浮层
    @FindBy(how = How.XPATH, using = "//*[@id='click_effect']/div[1]/div[2]/label[2]")
    private WebElement clickEffectPopupButton;

    // 神字幕：点击效果：外链
    @FindBy(how = How.XPATH, using = "//*[@id='click_effect']/div[1]/div[2]/label[3]")
    private WebElement clickEffectLinkButton;

    // 神字幕:跳转链接
    @FindBy(how = How.NAME, using = "jump_link")
    private WebElement jumpLineInputBox;

    // 神字幕:点击选择浮层物料
    @FindBy(how = How.ID, using = "sel_float_pro_but")
    private WebElement floatProductButton;

    // 神字幕：弹出框选择浮层物料：第一条
    @FindBy(how = How.XPATH, using = "//*[@id='product_list']/table/tbody/tr[2]")
    private WebElement floatProSelectButton;

    // 添加易植贴
    @FindBy(how = How.ID, using = "img_val_corner")
    private WebElement yztImgButton;

    // 添加易植贴提示语1
    @FindBy(how = How.CSS, using = "#corner_img > div:nth-child(1)")
    private WebElement yztTipLabel;

    // 添加易植贴提示语自定义
    @FindBy(how = How.ID, using = "easy_prompt")
    private WebElement yztCustomizeTipLabel;

    // 动态视窗素材上传
    @FindBy(how = How.XPATH, using = "//*[@id='video_up_form']/div/div[2]/a")
    private WebElement videoUpFormButton;

    // 确定
    @FindBy(how = How.ID, using = "submit")
    private WebElement submitButton;

    // 取消
    @FindBy(how = How.CLASS_NAME, using = "up_yb")
    private WebElement cancelButton;

    // 隐藏展示效果面板:百科
    @FindBy(how = How.XPATH, using = "//*[@id='baike_l2']/div[1]/span")
    private WebElement hideBaikeDisplayPanel;

    // 显示展示效果面板：百科
    @FindBy(how = How.ID, using = "baike_l1")
    private WebElement showBaikeDisplayPanel;

    // 隐藏展示效果面板:购物
    @FindBy(how = How.XPATH, using = "//*[@id='Gouwu2']/div[1]/span")
    private WebElement hideGouwuDisplayPanel;

    // 显示展示效果面板：购物
    @FindBy(how = How.ID, using = "Gouwu12")
    private WebElement showGouwuDisplayPanel;

    /**
     * CreateProductPage
     * 
     * @Description 初始化加载所有元素
     */
    public CreateProductPage() {
        PageFactory.initElements(TestBase.getWebDriver(), this);
    }

    /**
     * @Title: clickBaikeButton
     * @Description: 点击创建百科物料
     * @return void
     */
    public void clickBaikeButton() {
        baikeButton.click();
    }

    /**
     * @Title: clickGouwuButton
     * @Description: 点击创建购物物料
     * @return void
     */
    public void clickGouwuButton() {
        gouwuButton.click();
    }

    /**
     * @Title: clickHongbaoButton
     * @Description: 点击创建红包物料
     * @return void
     */
    public void clickHongbaoButton() {
        hongbaoButton.click();
    }

    /**
     * @Title: clickYouhuimaButton
     * @Description: 点击创建优惠码物料
     * @return void
     */
    public void clickYouhuimaButton() {
        youhuimaButton.click();
    }

    /**
     * @Title: clickToupiaoButton
     * @Description: 点击创建投票物料
     * @return void
     */
    public void clickToupiaoButton() {
        toupiaoButton.click();
    }

    /**
     * @Title: clickShenzimuButton
     * @Description: 点击创建神字幕物料
     * @return void
     */
    public void clickShenzimuButton() {
        shenzimuButton.click();
    }

    /**
     * @Title: clickYizhitieButton
     * @Description: 点击创建易植贴物料
     * @return void
     */
    public void clickYizhitieButton() {
        yizhitieButton.click();
    }

    /**
     * @Title: clickDtscButton
     * @Description: 点击创建动态视窗物料
     * @return void
     */
    public void clickDtscButton() {
        dtscButton.click();
    }

    /**
     * @Title: getCaseTipText
     * @Description: 获得物料提示语
     * @return string
     */
    public String getCaseTipText() {
        return caseTipLabel.getText();
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
     * @Title: setPlatformContent
     * @Description: 归属平台
     * @param platformID
     * @return void
     */
    public void setPlatformContent(String platformID) {
        new Select(platformSelect).selectByVisibleText(platformID);
    }

    /**
     * @Title: setProductNameContent
     * @Description: 设置物料名称
     * @param productName
     * @return void
     */
    public void setProductNameContent(String productName) {
        productNameInputBox.clear();
        productNameInputBox.click();
        productNameInputBox.sendKeys(productName);
    }

    /**
     * @Title: setCategorySelectContent
     * @Description: 设置物料分类
     * @param category
     * @return void
     */
    public void setCategorySelectContent(String category) {
        new Select(categorySelect).selectByVisibleText(category);
    }

    /**
     * @Title: setProductTextContent
     * @Description: 设置按钮文案
     * @param productText
     * @return void
     */
    public void setProductTextContent(String productText) {
        productTextInputBox.clear();
        productTextInputBox.click();
        productTextInputBox.sendKeys(productText);
    }

    /**
     * @Title: setActivityDescriptionContent
     * @Description: 设置活动说明
     * @param activityDescription
     * @return void
     */
    public void setActivityDescriptionContent(String activityDescription) {
        activityDescriptionInputBox.clear();
        activityDescriptionInputBox.click();
        activityDescriptionInputBox.sendKeys(activityDescription);
    }

    /**
     * @Title: setRedPacketContent
     * @Description: 设置红包口令
     * @param redPacket
     * @return void
     */
    public void setRedPacketContent(String redPacket) {
        redPacketInputBox.clear();
        redPacketInputBox.click();
        redPacketInputBox.sendKeys(redPacket);
    }

    /**
     * @Title: setConvertDescriptionContent
     * @Description: 设置红包兑换说明
     * @param convertDescription
     * @return void
     */
    public void setConvertDescriptionContent(String convertDescription) {
        convertDescriptionInputBox.clear();
        convertDescriptionInputBox.click();
        convertDescriptionInputBox.sendKeys(convertDescription);
    }

    /**
     * @Title: setEndDescriptionContent
     * @Description: 设置红包结束说明
     * @param endDescription
     * @return void
     */
    public void setEndDescriptionContent(String endDescription) {
        endDescriptionInputBox.clear();
        endDescriptionInputBox.click();
        endDescriptionInputBox.sendKeys(endDescription);
    }

    /**
     * @Title: setProductDescriptionTextContent
     * @Description: 设置详细描述
     * @param productDescriptionText
     * @return void
     */
    public void setProductDescriptionTextContent(String productDescriptionText) {
        productDescriptionTextInputBox.clear();
        productDescriptionTextInputBox.click();
        productDescriptionTextInputBox.sendKeys(productDescriptionText);
    }

    /**
     * @Title: setClickLinkContent
     * @Description: 设置跳转链接
     * @param linkText
     * @return void
     */
    public void setClickLinkContent(String linkText) {
        clickLinkInputBox.clear();
        clickLinkInputBox.click();
        clickLinkInputBox.sendKeys(linkText);
    }

    /**
     * @Title: setProductMinPriceContent
     * @Description: 设置红包价格
     * @param productMinPrice
     * @return void
     */
    public void setProductMinPriceContent(String productMinPrice) {
        productMinPriceInputBox.clear();
        productMinPriceInputBox.click();
        productMinPriceInputBox.sendKeys(productMinPrice);
    }

    /**
     * @Title: clickAdditionButton
     * @Description: 优惠码：追加按钮
     * @return void
     */
    public void clickAdditionButton() {
        additionButton.click();
    }

    /**
     * @Title: setConvertCodeContent
     * @Description: 设置优惠码口令
     * @param convertCode
     * @return void
     */
    public void setConvertCodeContent(String convertCode) {
        convertCodeInputBox.clear();
        convertCodeInputBox.click();
        convertCodeInputBox.sendKeys(convertCode);
    }

    /**
     * @Title: clickFormatUpDownButton
     * @Description: 投票：选择版式:上下版式
     * @return void
     */
    public void clickFormatUpDownButton() {
        formatUpDownButton.click();
    }

    /**
     * @Title: clickFormatLeftRightButton
     * @Description: 投票：选择版式:左右版式
     * @return void
     */
    public void clickFormatLeftRightButton() {
        formatLeftRightButton.click();
    }

    /**
     * @Title: setVoteProblemContent
     * @Description: 设置投票提问
     * @param voteProblem
     * @return void
     */
    public void setVoteProblemContent(String voteProblem) {
        voteProblemInputBox.clear();
        voteProblemInputBox.click();
        voteProblemInputBox.sendKeys(voteProblem);
    }

    /**
     * @Title: setVoteOption1Content
     * @Description: 设置投票选项1：创建
     * @param voteOption1
     * @return void
     */
    public void setVoteOption1Content(String voteOption1) {
        voteOption1InputBox.clear();
        voteOption1InputBox.click();
        voteOption1InputBox.sendKeys(voteOption1);
    }

    /**
     * @Title: setVoteOption1EditContent
     * @Description: 设置投票选项1：编辑
     * @param voteOption1
     * @return void
     */
    public void setVoteOption1EditContent(String voteOption1) {
        voteOption1EditInputBox.clear();
        voteOption1EditInputBox.click();
        voteOption1EditInputBox.sendKeys(voteOption1);
    }

    /**
     * @Title: setVoteOption2Content
     * @Description: 设置投票选项2：创建
     * @param voteOption2
     * @return void
     */
    public void setVoteOption2Content(String voteOption2) {
        voteOption2InputBox.clear();
        voteOption2InputBox.click();
        voteOption2InputBox.sendKeys(voteOption2);
    }

    /**
     * @Title: setVoteOption1Content
     * @Description: 设置投票选项2：编辑
     * @param voteOption2
     * @return void
     */
    public void setVoteOption2EditContent(String voteOption2) {
        voteOption2EditInputBox.clear();
        voteOption2EditInputBox.click();
        voteOption2EditInputBox.sendKeys(voteOption2);
    }

    /**
     * @Title: clickAddOptionButton
     * @Description: 投票：添加选项
     * @return void
     */
    public void clickAddOptionButton() {
        addOptionButton.click();
    }

    /**
     * @Title: setVoteOption3Content
     * @Description: 设置投票选项3：创建
     * @param voteOption3
     * @return void
     */
    public void setVoteOption3Content(String voteOption3) {
        voteOption3InputBox.clear();
        voteOption3InputBox.click();
        voteOption3InputBox.sendKeys(voteOption3);
    }

    /**
     * @Title: clickDetelteVoteOption3Button
     * @Description: 投票：删除投票选项3
     * @return void
     */
    public void clickDetelteVoteOption3Button() {
        detelteVoteOption3Button.click();
    }

    /**
     * @Title: setFormatIDSelect
     * @Description: 设置神字幕：选择版式:基础类
     * @param formatID
     * @return void
     */
    public void setFormatIDSelect(String formatID) {
        new Select(formatIDSelete).selectByVisibleText(formatID);
    }

    /**
     * @Title: setStyleIDSelect
     * @Description: 设置神字幕：选择版式:样式一
     * @param styleID
     * @return void
     */
    public void setStyleIDSelect(String styleID) {
        new Select(styleIDSelete).selectByVisibleText(styleID);
    }

    /**
     * @Title: clickClientLogoImgBox
     * @Description: 点击客户LOGO
     * @return void
     */
    public void clickClientLogoImgBox() {
        clientLogoImgBox.click();
    }

    /**
     * @Title: clickTemplateImgBox
     * @Description: 点击广告图片
     * @return void
     */
    public void clickTemplateImgBox() {
        templateImgBox.click();
    }

    /**
     * @Title: clickshowImgDiv0ImgBox
     * @Description: 点击百科 ，购物：展示图片:0
     * @return void
     */
    public void clickshowImgDiv0ImgBox() {
        showImgDiv0ImgBox.click();
    }

    /**
     * @Title: clickshowImgDiv1ImgBox
     * @Description: 点击百科 ，购物：展示图片:1
     * @return void
     */
    public void clickshowImgDiv1ImgBox() {
        showImgDiv1ImgBox.click();
    }

    /**
     * @Title: clickDeleteShowImgImgBox
     * @Description: 点击百科 ，购物：删除展示图片
     * @return void
     */
    public void clickDeleteShowImgImgBox() {
        deleteShowImgImgBox.click();
    }

    /**
     * @Title: clickDefaultIconSelectButton
     * @Description: 点击选择图标:Video易默认图标（百科，购物，红包，优惠码，投票）
     * @return void
     */
    public void clickDefaultIconSelectButton() {
        defaultIconSelectButton.click();
    }

    /**
     * @Title: clickCustomizeIconButton
     * @Description: 点击选择自定义图标:百科，购物，红包，优惠码，投票
     * @param productType
     * @return void
     */
    public void clickCustomizeIconButton(ProductType productType) {
        // 点击物料关闭按钮
        switch (productType) {
        case BAIKE:
            customizeBaikeIconButton.click();
            break;

        case GOUWU:
            customizeGouwuIconButton.click();
            break;

        case HONGBAO:
            customizeHongbaoIconButton.click();
            break;

        case YOUHUIMA:
            customizeYouhuimaIconButton.click();
            break;

        case TOUPIAO:
            customizeToupiaoIconButton.click();
            break;

        default:
            break;
        }
    }

    /**
     * @Title: clickCustomizeIconImgBox
     * @Description: 点击选择自定义图标的图片
     * @return void
     */
    public void clickCustomizeIconImgBox() {
        customizeIconImgBox.click();
    }

    /**
     * @Title: clickDefaultBaikeButton
     * @Description: 点击百科：选择默认图标
     * @return void
     */
    public void clickDefaultBaikeButton() {
        defaultBaikeButton.click();
    }

    /**
     * @Title: clickDefaultGouwuButton
     * @Description: 点击购物：选择默认图标
     * @return void
     */
    public void clickDefaultGouwuButton() {
        defaultGouwuButton.click();
    }

    /**
     * @Title: clickDefaultHongbaoButton
     * @Description: 点击红包：选择默认图标
     * @return void
     */
    public void clickDefaultHongbaoButton() {
        defaultHongbaoButton.click();
    }

    /**
     * @Title: clickDefaultYouhuimaButton
     * @Description: 点击优惠码：选择默认图标
     * @return void
     */
    public void clickDefaultYouhuimaButton() {
        defaultYouhuimaButton.click();
    }

    /**
     * @Title: clickDefaultToupiaoButton
     * @Description: 点击投票：选择默认图标
     * @return void
     */
    public void clickDefaultToupiaoButton() {
        defaultToupiaoButton.click();
    }

    /**
     * @Title: clickColorBaikeSelectButton
     * @Description: 点击百科选择颜色
     * @return void
     */
    public void clickColorBaikeSelectButton() {
        colorBaikeSelectButton.click();
    }

    /**
     * @Title: clickColorGouwuSelectButton
     * @Description: 设置购物选择颜色
     * @return void
     */
    public void clickColorGouwuSelectButton() {
        colorGouwuSelectButton.click();
    }

    /**
     * @Title: clickDefaultColorBaikeButton
     * @Description: 设置百科选择颜色:默认
     * @return void
     */
    public void clickDefaultColorBaikeButton() {
        defaultColorBaikeButton.click();
    }

    /**
     * @Title: clickBlueColorBaikeButton
     * @Description: 设置百科选择颜色:蓝色
     * @return void
     */
    public void clickBlueColorBaikeButton() {
        blueColorBaikeButton.click();
    }

    /**
     * @Title: clickPinkColorBaikeButton
     * @Description: 点设置百科选择颜色:紫色
     * @return void
     */
    public void clickPinkColorBaikeButton() {
        pinkColorBaikeButton.click();
    }

    /**
     * @Title: clickCustomizeColorBaikeButton
     * @Description: 设置百科选择颜色:自定义颜色
     * @return void
     */
    public void clickCustomizeColorBaikeButton() {
        customizeColorBaikeButton.click();
    }

    /**
     * @Title: setCustomizeRColorBaikeInputBoxt
     * @Description: 设置百科：选择颜色:自定义颜色:R
     * @param color
     * @return void
     */
    public void setCustomizeRColorBaikeInputBoxt(String color) {
        customizeRColorBaikeInputBox.clear();
        customizeRColorBaikeInputBox.click();
        customizeRColorBaikeInputBox.sendKeys(color);
    }

    /**
     * @Title: setCustomizeGColorBaikeInputBoxt
     * @Description: 设置百科：选择颜色:自定义颜色:R
     * @param color
     * @return void
     */
    public void setCustomizeGColorBaikeInputBoxt(String color) {
        customizeGColorBaikeInputBox.clear();
        customizeGColorBaikeInputBox.click();
        customizeGColorBaikeInputBox.sendKeys(color);
    }

    /**
     * @Title: setCustomizeBColorBaikeInputBoxt
     * @Description: 设置百科：选择颜色:自定义颜色:R
     * @param color
     * @return void
     */
    public void setCustomizeBColorBaikeInputBoxt(String color) {
        customizeBColorBaikeInputBox.clear();
        customizeBColorBaikeInputBox.click();
        customizeBColorBaikeInputBox.sendKeys(color);
    }

    /**
     * @Title: clickDefaultColorGouwuButton
     * @Description: 设置购物选择颜色:默认
     * @return void
     */
    public void clickDefaultColorGouwuButton() {
        defaultColorGouwuButton.click();
    }

    /**
     * @Title: clickBlueColorGouwuButton
     * @Description: 设置购物选择颜色:蓝色
     * @return void
     */
    public void clickBlueColorGouwuButton() {
        blueColorGouwuButton.click();
    }

    /**
     * @Title: clickPinkColorGouwuButton
     * @Description: 点设置购物选择颜色:紫色
     * @return void
     */
    public void clickPinkColorGouwuButton() {
        pinkColorGouwuButton.click();
    }

    /**
     * @Title: clickCustomizeColorGouwuButton
     * @Description: 设置购物选择颜色:自定义颜色
     * @return void
     */
    public void clickCustomizeColorGouwuButton() {
        customizeColorGouwuButton.click();
    }

    /**
     * @Title: setCustomizeRColorGouwuInputBoxt
     * @Description: 设置购物：选择颜色:自定义颜色:R
     * @param color
     * @return void
     */
    public void setCustomizeRColorGouwuInputBoxt(String color) {
        customizeRColorGouwuInputBox.clear();
        customizeRColorGouwuInputBox.click();
        customizeRColorGouwuInputBox.sendKeys(color);
    }

    /**
     * @Title: setCustomizeGColorGouwuInputBoxt
     * @Description: 设置购物：选择颜色:自定义颜色:R
     * @param color
     * @return void
     */
    public void setCustomizeGColorGouwuInputBoxt(String color) {
        customizeGColorGouwuInputBox.clear();
        customizeGColorGouwuInputBox.click();
        customizeGColorGouwuInputBox.sendKeys(color);
    }

    /**
     * @Title: setCustomizeBColorGouwuInputBoxt
     * @Description: 设置购物：选择颜色:自定义颜色:R
     * @param color
     * @return void
     */
    public void setCustomizeBColorGouwuInputBoxt(String color) {
        customizeBColorGouwuInputBox.clear();
        customizeBColorGouwuInputBox.click();
        customizeBColorGouwuInputBox.sendKeys(color);
    }

    /**
     * @Title: clickImgValBorderImgBox
     * @Description: 设置百科，购物：选择边框
     * @return void
     */
    public void clickImgValBorderImgBox() {
        imgValBorderImgBox.click();
    }

    /**
     * @Title: clickImgValBorderDeleteButton
     * @Description: 设置百科，购物：选择边框:删除边框
     * @return void
     */
    public void clickImgValBorderDeleteButton() {
        imgValBorderDeleteButton.click();
    }

    /**
     * @Title: clickLogo11CreateSelectButton
     * @Description: 购物：logo位置一，创建
     * @return void
     */
    public void clickLogo11CreateSelectButton() {
        logo1CreateSelectButton.click();
    }

    /**
     * @Title: clickLogo1EditSelectButton
     * @Description: 百科：logo位置一，编辑
     * @return void
     */
    public void clickLogo1EditSelectButton() {
        logo1EditSelectButton.click();
    }

    /**
     * @Title: clickLogo22CreateSelectButton
     * @Description: 百科：logo位置二，创建
     * @return void
     */
    public void clickLogo22CreateSelectButton() {
        logo2CreateSelectButton.click();
    }

    /**
     * @Title: clickLogo2EditSelectButton
     * @Description: 购物：logo位置二，编辑
     * @return void
     */
    public void clickLogo2EditSelectButton() {
        logo2EditSelectButton.click();
    }

    /**
     * @Title: clickLogoImgBorderImgBox
     * @Description: 百科，购物：logo图片
     * @return void
     */
    public void clickLogoImgBorderImgBox() {
        logoImgBorderImgBox.click();
    }

    /**
     * @Title: clickEffectNoneButton
     * @Description: 神字幕：点击效果：选择无
     * @return void
     */
    public void clickEffectNoneButton() {
        clickEffectNoneButton.click();
    }

    /**
     * @Title: clickEffectPopupButton
     * @Description: 神字幕：点击效果：选择浮层
     * @return void
     */
    public void clickEffectPopupButton() {
        clickEffectPopupButton.click();
    }

    /**
     * @Title: clickEffectLinkButton
     * @Description: 神字幕：点击效果：选择外链
     * @return void
     */
    public void clickEffectLinkButton() {
        clickEffectLinkButton.click();
    }

    /**
     * @Title: setJumpLineContent
     * @Description: 设置神字幕:跳转链接
     * @param jumpLine
     * @return void
     */
    public void setJumpLineContent(String jumpLine) {
        jumpLineInputBox.clear();
        jumpLineInputBox.click();
        jumpLineInputBox.sendKeys(jumpLine);
    }

    /**
     * @Title: clickFloatProductButton
     * @Description: 神字幕:点击选择浮层物料
     * @return void
     */
    public void clickFloatProductButton() {
        floatProductButton.click();
    }

    /**
     * @Title: clickFloatProSelectButton
     * @Description: 神字幕:点击选择浮层物料：第一条
     * @return void
     */
    public void clickFloatProSelectButton() {
        floatProSelectButton.click();
    }

    /**
     * @Title: clickYztImgButton
     * @Description: 点击添加易植贴
     * @return void
     */
    public void clickYztImgButton() {
        yztImgButton.click();
    }

    /**
     * @Title: getYztTipText
     * @Description: 获得易植贴文字
     * @return void
     */
    public void getYztTipText() {
        yztTipLabel.getText();
    }

    /**
     * @Title: getYztCustomizeTipText
     * @Description: 获得易植贴自定义文字
     * @return void
     */
    public void getYztCustomizeTipText() {
        yztCustomizeTipLabel.getText();
    }

    /**
     * @Title: clickVideoUpFormButton
     * @Description: 点击动态视窗素材上传
     * @return void
     */
    public void clickVideoUpFormButton() {
        videoUpFormButton.click();
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
     * @Title: clickHideBaikeDisplayPanel
     * @Description: 点击隐藏展示效果面板:百科
     * @return void
     */
    public void clickHideBaikeDisplayPanel() {
        hideBaikeDisplayPanel.click();
    }

    /**
     * @Title: clickShowBaikeDisplayPanel
     * @Description: 点击显示展示效果面板:百科
     * @return void
     */
    public void clickShowBaikeDisplayPanel() {
        showBaikeDisplayPanel.click();
    }

    /**
     * @Title: clickHideGouwuDisplayPanel
     * @Description: 点击隐藏展示效果面板:购物
     * @return void
     */
    public void clickHideGouwuDisplayPanel() {
        hideGouwuDisplayPanel.click();
    }

    /**
     * @Title: clickShowGouwuDisplayPanel
     * @Description: 点击显示展示效果面板:购物
     * @return void
     */
    public void clickShowGouwuDisplayPanel() {
        showGouwuDisplayPanel.click();
    }

    /**
     * @Title: testCreateHongbaoProduct
     * @Description: 创建红包物料
     * @param isEdit
     * @throws Exception
     * @return void
     */
    public void testCreateHongbaoProduct(ProductInfo productInfo, Boolean isEdit) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();
        if (isEdit) {
            strMethodName = strMethodName + "编辑";
        }

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            if (!isEdit) {
                // 页面跳转到红包信息
                clickHongbaoButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 红包信息页显示 OK.-----");
                CommonUtil.TakeScreenShot(strMethodName + "_Init");

                // 红包Tip
                String strTipText = getCaseTipText();
                Assert.assertEquals(strTipText, VideoyiConstants.PRODUCT_CASE_TIP_HONGBAO);

                // 团队归属
                setTeamIDContent(productInfo.teamID);
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 团队归属 OK.-----");

                // 客户归属
                setMemberIDContent(productInfo.memberID);
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 客户归属 OK.-----");

                // 归属平台
                setPlatformContent(productInfo.platform);
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 归属平台 OK.-----");
            }

            // 物料名称
            setProductNameContent(productInfo.productName);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 物料名称 OK.-----");

            // 物料分类
            setCategorySelectContent(productInfo.category);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 物料分类 OK.-----");

            // 按钮文案
            setProductTextContent(productInfo.productText);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 按钮文案 OK.-----");

            // 活动说明
            setActivityDescriptionContent(productInfo.activityDescription);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 活动说明 OK.-----");

            // 红包口令
            setRedPacketContent(productInfo.redPacket);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 红包口令 OK.-----");

            // 兑换说明
            setConvertDescriptionContent(productInfo.convertDescription);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 兑换说明 OK.-----");

            // 客户LOGO
            CommonUtil.uploadImageForPopup(clientLogoImgBox, productInfo.clientLogoImg);
            logger.info("-----" + strMethodName + " 客户LOGO OK.-----");

            // 广告图片
            CommonUtil.uploadImageForPopup(templateImgBox, productInfo.templateImg);
            logger.info("-----" + strMethodName + " 广告图片 OK.-----");

            // 创建时
            if (!isEdit) {
                // 选择图标:Video易默认图标
                clickDefaultIconSelectButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 选择图标:Video易默认图标 OK.-----");

                // 点击红包图标
                clickDefaultHongbaoButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 点击红包图标 OK.-----");

            } else {
                // 编辑时
                // 选择图标:自定义图标
                clickCustomizeIconButton(ProductType.HONGBAO);
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 选择图标:自定义图标 OK.-----");

                // 选择图标:自定义图标
                CommonUtil.uploadImageForPopup(customizeIconImgBox, productInfo.customizeIconImg);
                logger.info("-----" + strMethodName + " 自定义图标:图片修改 OK.-----");
            }

            // 将页面滚动条拖到底部
            CommonUtil.scrollToDocumentBottom();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 滚动条拖到底部  OK.-----");

            // 确定
            clickSubmitButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 确定 OK.-----");

            // 点击确定
            CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_ACCEPT);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击确定 OK.-----");

            // 验证：跳转后URL
            String strURL = TestBase.getWebDriver().getCurrentUrl();
            Assert.assertEquals(TestBase.getTestWebSite() + VideoyiConstants.URL_PRODUCT_MANAGER, strURL);
            logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

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

    /**
     * @Title: testCreateYouhuimaProduct
     * @Description: 创建优惠码物料
     * @param productInfo
     * @param isEdit
     * @throws Exception
     * @return void
     */
    public void testCreateYouhuimaProduct(ProductInfo productInfo, Boolean isEdit) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();
        if (isEdit) {
            strMethodName = strMethodName + "编辑";
        }

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            if (!isEdit) {
                // 页面跳转到 优惠码信息
                clickYouhuimaButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----testCreateGouwuProduct 优惠码信息页显示 OK.-----");
                CommonUtil.TakeScreenShot(strMethodName + "_Init");

                // 优惠码Tip
                String strTipText = getCaseTipText();
                Assert.assertEquals(strTipText, VideoyiConstants.PRODUCT_CASE_TIP_YOUHUIMA);

                // 团队归属
                setTeamIDContent(productInfo.teamID);
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 团队归属 OK.-----");

                // 客户归属
                setMemberIDContent(productInfo.memberID);
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 客户归属 OK.-----");

                // 归属平台
                setPlatformContent(productInfo.platform);
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 归属平台 OK.-----");
            }

            // 物料名称
            setProductNameContent(productInfo.productName);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 物料名称 OK.-----");

            // 物料分类
            setCategorySelectContent(productInfo.category);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 物料分类 OK.-----");

            // 按钮文案
            setProductTextContent(productInfo.productText);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 按钮文案 OK.-----");

            // 活动说明
            setActivityDescriptionContent(productInfo.activityDescription);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 活动说明 OK.-----");

            // 创建时使用
            if (!isEdit) {
                // 优惠码口令
                setConvertCodeContent(productInfo.convertCode);
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 优惠码口令 OK.-----");
            } else {
                // 优惠码追加按钮
                clickAdditionButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 点击优惠码追加按钮 OK.-----");

                // 优惠码口令增加
                setConvertCodeContent(productInfo.convertCode);
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 优惠码口令增加 OK.-----");
            }

            // 兑换说明
            setConvertDescriptionContent(productInfo.convertDescription);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 兑换说明 OK.-----");

            // 结束说明
            setEndDescriptionContent(productInfo.endDescription);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 结束说明 OK.-----");

            // 客户LOGO
            CommonUtil.uploadImageForPopup(clientLogoImgBox, productInfo.clientLogoImg);
            logger.info("-----" + strMethodName + " 客户LOGO OK.-----");

            // 广告图片
            CommonUtil.uploadImageForPopup(templateImgBox, productInfo.templateImg);
            logger.info("-----" + strMethodName + " 广告图片 OK.-----");

            // 创建时
            if (!isEdit) {
                // 选择图标:Video易默认图标
                clickDefaultIconSelectButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 选择图标:Video易默认图标 OK.-----");

                // 点击优惠码图标
                clickDefaultYouhuimaButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 点击优惠码图标 OK.-----");
            } else {
                // 编辑时
                // 选择图标:自定义图标
                clickCustomizeIconButton(ProductType.YOUHUIMA);
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 选择图标:自定义图标 OK.-----");

                // 选择优惠码自定义图标
                CommonUtil.uploadImageForPopup(customizeIconImgBox, productInfo.customizeIconImg);
                logger.info("-----" + strMethodName + " 自定义图标:图片修改 OK.-----");
            }

            // 将页面滚动条拖到底部
            CommonUtil.scrollToDocumentBottom();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 滚动条拖到底部  OK.-----");

            // 确定
            clickSubmitButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 确定 OK.-----");

            // 点击确定
            CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_ACCEPT);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击确定 OK.-----");
            // 验证：跳转后URL
            String strURL = TestBase.getWebDriver().getCurrentUrl();
            Assert.assertEquals(TestBase.getTestWebSite() + VideoyiConstants.URL_PRODUCT_MANAGER, strURL);
            logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

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

    /**
     * @Title: testCreateYizhitieProduct
     * @Description: 创建和编辑易植贴物料
     * @param productInfo
     * @param isEdit
     * @throws Exception
     * @return void
     */
    public void testCreateYizhitieProduct(ProductInfo productInfo, Boolean isEdit) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();
        if (isEdit) {
            strMethodName = strMethodName + "编辑";
        }

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            if (!isEdit) {
                // 点击跳转易植贴信息
                clickYizhitieButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 易植贴信息页显示 OK.-----");
                CommonUtil.TakeScreenShot(strMethodName + "_Init");

                // 易植贴Tip
                String strTipText = getCaseTipText();
                Assert.assertEquals(strTipText, VideoyiConstants.PRODUCT_CASE_TIP_YIZHITIE);

                // 团队归属
                setTeamIDContent(productInfo.teamID);
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 团队归属 OK.-----");

                // 客户归属
                setMemberIDContent(productInfo.memberID);
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 客户归属 OK.-----");

                // 归属平台
                setPlatformContent(productInfo.platform);
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 归属平台 OK.-----");
            }

            // 物料名称
            setProductNameContent(productInfo.productName);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 物料名称 OK.-----");

            // 物料分类
            setCategorySelectContent(productInfo.category);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 物料分类 OK.-----");

            // 跳转链接
            setClickLinkContent(productInfo.clickLink);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 跳转链接:空 OK.-----");

            // 添加易植贴
            CommonUtil.uploadImageForFile(yztImgButton, productInfo.yztImg);
            logger.info("-----" + strMethodName + " 添加易植贴 OK.-----");

            // 确定
            clickSubmitButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 确定 OK.-----");

            // 点击确定
            CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_ACCEPT);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击确定 OK.-----");

            // 验证：跳转后URL
            String strURL = TestBase.getWebDriver().getCurrentUrl();
            Assert.assertEquals(TestBase.getTestWebSite() + VideoyiConstants.URL_PRODUCT_MANAGER, strURL);
            logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

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

    public void testCreateDtscProduct(ProductInfo productInfo, Boolean isEdit) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();
        if (isEdit) {
            strMethodName = strMethodName + "编辑";
        }

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            if (!isEdit) {
                // 点击跳转动态视窗信息
                clickDtscButton();
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + "动态视窗信息页显示 OK.-----");
                CommonUtil.TakeScreenShot(strMethodName + "_Init");

                // 动态视窗Tip
                String strTipText = getCaseTipText();
                Assert.assertEquals(strTipText, VideoyiConstants.PRODUCT_CASE_TIP_DTSC);

                // 团队归属
                setTeamIDContent(productInfo.teamID);
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 团队归属 OK.-----");

                // 客户归属
                setMemberIDContent(productInfo.memberID);
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 客户归属 OK.-----");

                // 归属平台
                setPlatformContent(productInfo.platform);
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 归属平台 OK.-----");
            }

            // 物料名称
            setProductNameContent(productInfo.productName);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 物料名称 OK.-----");

            // 物料分类
            setCategorySelectContent(productInfo.category);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 物料分类 OK.-----");

            // 跳转链接
            setClickLinkContent(productInfo.clickLink);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 跳转链接:空 OK.-----");

            // 动态视窗素材上传
            clickVideoUpFormButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            CommonUtil.uploadImageFile(productInfo.videoUpForm);
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            logger.info("-----" + strMethodName + " 动态视窗素材上传 OK.-----");
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
            Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);

            // 确定
            clickSubmitButton();
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 确定 OK.-----");

            // 点击确定
            CommonUtil.closeAlertAndGetItsText(CommonConstants.ALERT_ACCEPT);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 点击确定 OK.-----");

            // 验证：跳转后URL
            String strURL = TestBase.getWebDriver().getCurrentUrl();
            Assert.assertEquals(TestBase.getTestWebSite() + VideoyiConstants.URL_PRODUCT_MANAGER, strURL);
            logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

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
