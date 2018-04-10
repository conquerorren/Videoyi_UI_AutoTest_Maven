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

import ai.qa.autotest.ui.custom.annotation.PageObject;
import ai.qa.autotest.ui.dataentity.MemberInfo;
import ai.qa.autotest.ui.framework.constants.CommonConstants;
import ai.qa.autotest.ui.framework.utility.CommonUtil;
import ai.qa.autotest.ui.testbase.TestBase;

/**
 * @ClassName: CreateMemberPage
 * @Description: 创建成员页面
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
@PageObject
public class CreateMemberPage {
    // Logger信息
    private static Logger logger = LogManager.getLogger(AdminPortalLoginPage.class.getName());

    // 新建客户按钮
    @FindBy(how = How.XPATH, using = "//*[@id='mainzsy']/tbody/tr/td[2]/div/div[2]/div[3]/input")
    private WebElement createMemberButton;

    // 编辑客户按钮
    @FindBy(how = How.XPATH, using = "//*[@id='right_middle_a']/div[1]/table/tbody/tr[2]/td[9]/input")
    private WebElement editMemberButton;

    // 客户名称
    @FindBy(how = How.ID, using = "username")
    private WebElement memberNameInputBox;

    // 归属团队
    @FindBy(how = How.ID, using = "team_id")
    private WebElement teamIDSelect;

    // 公司名称
    @FindBy(how = How.ID, using = "member_company_name")
    private WebElement companyNameInputBox;

    // 公司行业
    @FindBy(how = How.ID, using = "member_trade")
    private WebElement memberTradeSelect;

    // 公司地区
    @FindBy(how = How.ID, using = "member_area")
    private WebElement memberAreaSelect;

    // 城市
    @FindBy(how = How.ID, using = "member_area_city")
    private WebElement memberAreaCitySelect;

    // 区县
    @FindBy(how = How.ID, using = "member_area_section")
    private WebElement memberAreaSectionSelect;

    // 客户姓名
    @FindBy(how = How.ID, using = "member_contacts_name")
    private WebElement memberContactNameInputBox;

    // 客户电话
    @FindBy(how = How.ID, using = "member_contacts_mobile")
    private WebElement memberContactMobileInputBox;

    // 客户职务
    @FindBy(how = How.ID, using = "member_contacts_position")
    private WebElement memberContactPositionInputBox;

    // 确定
    @FindBy(how = How.ID, using = "submit")
    private WebElement submitButton;

    /**
     * @Title:CreateMemberPage
     * @Description:初始化加载所有元素
     */
    public CreateMemberPage() {
        PageFactory.initElements(TestBase.getWebDriver(), this);
    }

    /**
     * @Title: clickCreateMemeber
     * @Description: 点击创建成员
     * @return void
     */
    public void clickCreateMemeber() {
        createMemberButton.click();
    }

    /**
     * @Title: clickEditMemeber
     * @Description: 点击编辑成员
     * @return void
     */
    public void clickEditMemeber() {
        editMemberButton.click();
    }

    /**
     * @Title: setMemberNameContent
     * @Description: 客户名称
     * @param memberName
     * @return void
     */
    public void setMemberNameContent(String memberName) {
        memberNameInputBox.clear();
        memberNameInputBox.click();
        memberNameInputBox.sendKeys(memberName);
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
     * @Title: setCompanyNameContent
     * @Description: 公司名称
     * @param companyName
     * @return void
     */
    public void setCompanyNameContent(String companyName) {
        companyNameInputBox.clear();
        companyNameInputBox.click();
        companyNameInputBox.sendKeys(companyName);
    }

    /**
     * @Title: setMemberTradeContent
     * @Description: 公司行业
     * @param memberTrade
     * @return void
     */
    public void setMemberTradeContent(String memberTrade) {
        new Select(memberTradeSelect).selectByVisibleText(memberTrade);
    }

    /**
     * @Title: setMemberAreaContent
     * @Description: 公司地区
     * @param memberArea
     * @return void
     */
    public void setMemberAreaContent(String memberArea) {
        new Select(memberAreaSelect).selectByVisibleText(memberArea);
    }

    /**
     * @Title: setMemberAreaCityContent
     * @Description: 城市
     * @param memberAreaCity
     * @return void
     */
    public void setMemberAreaCityContent(String memberAreaCity) {
        new Select(memberAreaCitySelect).selectByVisibleText(memberAreaCity);
    }

    /**
     * @Title: setMemberAreaSectionContent
     * @Description: 区县
     * @param memberAreaSection
     * @return void
     */
    public void setMemberAreaSectionContent(String memberAreaSection) {
        new Select(memberAreaSectionSelect).selectByVisibleText(memberAreaSection);
    }

    /**
     * @Title: setMemberContactNameContent
     * @Description: 客户姓名
     * @param memberContactName
     * @return void
     */
    public void setMemberContactNameContent(String memberContactName) {
        memberContactNameInputBox.clear();
        memberContactNameInputBox.click();
        memberContactNameInputBox.sendKeys(memberContactName);
    }

    /**
     * @Title: setMemberContactMobileContent
     * @Description: 客户电话
     * @param memberContactMobile
     * @return void
     */
    public void setMemberContactMobileContent(String memberContactMobile) {
        memberContactMobileInputBox.clear();
        memberContactMobileInputBox.click();
        memberContactMobileInputBox.sendKeys(memberContactMobile);
    }

    /**
     * @Title: setMemberContactPositionContent
     * @Description: 客户职务
     * @param memberContactPosition
     * @return void
     */
    public void setMemberContactPositionContent(String memberContactPosition) {
        memberContactPositionInputBox.clear();
        memberContactPositionInputBox.click();
        memberContactPositionInputBox.sendKeys(memberContactPosition);
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
     * @Title: testCreateMemberPage
     * @Description: 创建成员信息
     * @param memberInfo
     * @param isEdit
     * @throws Exception
     * @return void
     */
    public void testCreateMemberPage(MemberInfo memberInfo, boolean isEdit) throws Exception {
        String strMethodName = new Exception().getStackTrace()[0].getMethodName();
        if (isEdit) {
            strMethodName = strMethodName + "编辑";
        }

        try {
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " Start.-----");

            // 客户名称
            setMemberNameContent(memberInfo.memberName);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 客户名称 OK.-----");

            if (!isEdit) {
                // 归属团队
                setTeamIDContent(memberInfo.teamID);
                Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
                logger.info("-----" + strMethodName + " 归属团队 OK.-----");
            }

            // 公司名称
            setCompanyNameContent(memberInfo.companyName);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 公司名称 OK.-----");

            // 公司行业
            setMemberTradeContent(memberInfo.memberTrade);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 公司行业 OK.-----");

            // 公司地区
            setMemberAreaContent(memberInfo.memberArea);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 公司地区 OK.-----");

            // 城市
            setMemberAreaCityContent(memberInfo.memberAreaCity);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 城市 OK.-----");

            // 区县
            setMemberAreaSectionContent(memberInfo.memberAreaSection);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 区县 OK.-----");

            // 客户姓名
            setMemberContactNameContent(memberInfo.memberContactName);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 客户姓名 OK.-----");

            // 客户电话
            setMemberContactMobileContent(memberInfo.memberContactMobile);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 客户电话 OK.-----");

            // 客户职务
            setMemberContactPositionContent(memberInfo.memberContactPosition);
            Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
            logger.info("-----" + strMethodName + " 客户职务 OK.-----");

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
