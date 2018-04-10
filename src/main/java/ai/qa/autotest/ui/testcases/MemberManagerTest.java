/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.testcases
 * @author:Ren Qiang
 * @date:Mar 7, 2018
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.testcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import ai.qa.autotest.ui.custom.annotation.AutoInject;
import ai.qa.autotest.ui.custom.annotation.DataObject;
import ai.qa.autotest.ui.dataentity.MemberInfo;
import ai.qa.autotest.ui.pageobject.CreateMemberPage;
import ai.qa.autotest.ui.pageobject.MemberManagerPage;
import ai.qa.autotest.ui.pageobject.NavigationMenu;
import ai.qa.autotest.ui.testbase.AdminPortalTestBase;

/**
 * @ClassName: MemberManagerTest
 * @Description: 客户管理页面测试用例
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
public class MemberManagerTest extends AdminPortalTestBase {
    // 导航菜单
    @AutoInject
    private NavigationMenu menu;

    // 客户管理页面
    @AutoInject
    private MemberManagerPage memberManagerPage;

    // 创建客户页面
    @AutoInject
    private CreateMemberPage createMemberPage;

    // 客户信息
    @AutoInject
    private static MemberInfo memberInfo;

    // 创建客户信息测试数据
    @DataObject(DataNode = "CreateMemberPage,EditMemberPage,SearchMemberPage")
    private HashMap<String, String> dataMap;

    /**
     * @Title: testMemberManager
     * @Description: 客户管理页面全流程测试
     * @throws Exception
     * @return void
     */
    @Test
    public void testMemberManager() throws Exception {
        // 导航：客户管理
        menu.goToMemberManagerPage();

        // 设置客户输入信息
        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setMemberInfo(dataMap.get("MemberName"), dataMap.get("TeamID"), dataMap.get("CompanyName"),
                dataMap.get("MemberTrade"), dataMap.get("MemberArea"), dataMap.get("MemberAreaCity"),
                dataMap.get("MemberAreaSection"), dataMap.get("MemberContactName"), dataMap.get("MemberContactMobile"),
                dataMap.get("MemberContactPosition"));

        // 点击新建客户
        memberManagerPage.clickCreateMemeber();
        // 输入客户信息
        createMemberPage.testCreateMemberPage(memberInfo, false);

        // 模糊检索客户信息
        memberManagerPage.testSearchMember(memberInfo.teamID, dataMap.get("SearchMemberKey"));

        // 模糊检索客户信息：无该客户信息
        memberManagerPage.testSearchMember(memberInfo.teamID, dataMap.get("SearchMemberKeyNone"));

        // 编辑客户的数据
        memberInfo.setMemberInfo(dataMap.get("EditMemberName"), dataMap.get("EditTeamID"),
                dataMap.get("EditCompanyName"), dataMap.get("EditMemberTrade"), dataMap.get("EditMemberArea"),
                dataMap.get("EditMemberAreaCity"), dataMap.get("EditMemberAreaSection"),
                dataMap.get("EditMemberContactName"), dataMap.get("EditMemberContactMobile"),
                dataMap.get("EditMemberContactPosition"));
        // 点击编辑客户
        memberManagerPage.clickEditMemeber();
        // 编辑客户信息
        createMemberPage.testCreateMemberPage(memberInfo, true);

        // 点击删除客户:取消
        memberManagerPage.testDeleteMemberCancel();
        // 点击删除客户:确定
        // memberManagerPage.testDeleteMemberOK();
    }

    /**
     * @Title: testCreateMember
     * @Description: 新建客户
     * @throws Exception
     * @return void
     */
    @Test
    public void testCreateMember() throws Exception {
        // 导航：客户管理
        menu.goToMemberManagerPage();

        // 设置客户输入信息
        memberInfo = new MemberInfo();
        memberInfo.setMemberInfo(dataMap.get("MemberName"), dataMap.get("TeamID"), dataMap.get("CompanyName"),
                dataMap.get("MemberTrade"), dataMap.get("MemberArea"), dataMap.get("MemberAreaCity"),
                dataMap.get("MemberAreaSection"), dataMap.get("MemberContactName"), dataMap.get("MemberContactMobile"),
                dataMap.get("MemberContactPosition"));

        // 点击新建客户
        memberManagerPage.clickCreateMemeber();
        // 输入客户信息
        createMemberPage.testCreateMemberPage(memberInfo, false);
    }

    /**
     * @Title: testSearchMember
     * @Description: 模糊检索客户信息
     * @throws Exception
     * @return void
     */
    @Test
    public void testSearchMember() throws Exception {
        // 导航：客户管理
        menu.goToMemberManagerPage();

        String strTeamID = dataMap.get("SearchMemberTeamID");
        if (null != memberInfo) {
            strTeamID = memberInfo.teamID;
        }
        // 模糊检索客户信息：有该客户信息
        memberManagerPage.testSearchMember(strTeamID, dataMap.get("SearchMemberKey"));

        // 模糊检索客户信息：无该客户信息
        memberManagerPage.testSearchMember(strTeamID, dataMap.get("SearchMemberKeyNone"));
    }

    /**
     * @Title: testEditMember
     * @Description: 编辑客户的数据
     * @throws Exception
     * @return void
     */
    @Test
    public void testEditMember() throws Exception {
        // 导航：客户管理
        menu.goToMemberManagerPage();

        if (null == memberInfo) {
            memberInfo = new MemberInfo();
        }
        // 编辑客户的数据
        memberInfo.setMemberInfo(dataMap.get("EditMemberName"), dataMap.get("EditTeamID"),
                dataMap.get("EditCompanyName"), dataMap.get("EditMemberTrade"), dataMap.get("EditMemberArea"),
                dataMap.get("EditMemberAreaCity"), dataMap.get("EditMemberAreaSection"),
                dataMap.get("EditMemberContactName"), dataMap.get("EditMemberContactMobile"),
                dataMap.get("EditMemberContactPosition"));
        // 点击编辑客户
        memberManagerPage.clickEditMemeber();
        // 编辑客户信息
        createMemberPage.testCreateMemberPage(memberInfo, true);
    }

    /**
     * @Title: testDeleteMemberCancel
     * @Description: 删除客户:取消
     * @throws Exception
     * @return void
     */
    @Test
    public void testDeleteMemberCancel() throws Exception {
        // 导航：客户管理
        menu.goToMemberManagerPage();

        // 点击删除客户:取消
        memberManagerPage.testDeleteMemberCancel();
    }

    /**
     * @Title: testDeleteMemberOK
     * @Description: 删除客户：确定
     * @throws Exception
     * @return void
     */
    @Test
    public void testDeleteMemberOK() throws Exception {
        // 导航：客户管理
        menu.goToMemberManagerPage();
        // 点击删除客户:确定
        memberManagerPage.testDeleteMemberOK();
    }
}
