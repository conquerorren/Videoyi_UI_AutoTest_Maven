/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.testcases
 * @author Ren Qiang
 * @date:Mar 15, 2018
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.testcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import ai.qa.autotest.ui.custom.annotation.AutoInject;
import ai.qa.autotest.ui.custom.annotation.DataObject;
import ai.qa.autotest.ui.dataentity.MonitorInfo;
import ai.qa.autotest.ui.dataentity.WorkOrderInfo;
import ai.qa.autotest.ui.pageobject.CreateWorkOrderPage;
import ai.qa.autotest.ui.pageobject.NavigationMenu;
import ai.qa.autotest.ui.pageobject.WorkOrderDramaListPage;
import ai.qa.autotest.ui.pageobject.WorkOrderManagerPage;
import ai.qa.autotest.ui.pageobject.WorkOrderMonitorPage;
import ai.qa.autotest.ui.pageobject.WorkOrderPointListPage;
import ai.qa.autotest.ui.testbase.AdminPortalTestBase;
import ai.qa.autotest.ui.testbase.TestBase;

/**
 * @ClassName: WorkOrderManagerTest
 * @Description: 投放计划管理页面测试用例
 * @author: Ren Qiang
 * @date: Mar 15, 2018
 */
public class WorkOrderManagerTest extends AdminPortalTestBase {
    // 导航菜单
    @AutoInject
    private NavigationMenu menu;

    // 创建投放管理页面
    @AutoInject
    private CreateWorkOrderPage createWorkOrderPage;

    // 投放管理页面
    @AutoInject
    private WorkOrderManagerPage workOrderManagerPage;

    // 投放计划详情页面
    @AutoInject
    private WorkOrderDramaListPage workOrderDramaListPage;

    // 投放视频详情页面
    @AutoInject
    private WorkOrderPointListPage workOrderPointListPage;

    // 投放监控页面
    @AutoInject
    private WorkOrderMonitorPage workOrderMonitorPage;

    // 创建投放测试数据
    @DataObject(DataNode = "SearchWorkOrderPage,CreateWorkOrderPage,EditWorkOrderPage,CreateDramaList,CreateYizhitiePoint,EditDramaPage,CreateMaterialYizhitiePoint,EditMaterialPage,AddMonitorPage,EditMonitorPage")
    private HashMap<String, String> dataMap;

    /**
     * @Title: testSearchWorkOrder
     * @Description: 模糊检索投放计划信息
     * @throws Exception
     * @return void
     */
    @Test
    public void testSearchWorkOrder() throws Exception {
        // 导航：投放管理
        menu.goToWorkorderPage();

        String strTeamID = dataMap.get("SearchWorkOrderTeamID");
        String strMemberID = dataMap.get("SearchWorkOrderMemberID");
        String strPlatform = dataMap.get("SearchWorkOrderPlatform");
        String strStartTime = dataMap.get("SearchWorkOrderStartTime");
        String strEndTime = dataMap.get("SearchWorkOrderEndTime");
        String strKeyword = dataMap.get("SearchWorkOrderKey");

        // 模糊检索物料信息：有该物料信息
        workOrderManagerPage.testSearchWorkorder(strTeamID, strMemberID, strPlatform, strStartTime, strEndTime,
                strKeyword);
    }

    /**
     * @Title: testCreateHongbaoProduct
     * @Description: 创建投放计划管理
     * @throws Exception
     * @return void
     */
    @Test
    public void testCreateWorkorder() throws Exception {
        // 导航：投放管理
        menu.goToWorkorderPage();
        WorkOrderInfo workOrderInfo = new WorkOrderInfo();
        workOrderInfo.setWorkOrderInfo(dataMap.get("WorkOrderName"), dataMap.get("WorkOrderTeamID"),
                dataMap.get("WorkOrderMemberID"), dataMap.get("WorkOrderBugdet"), dataMap.get("WorkOrderTerminal"),
                dataMap.get("WorkOrderShared"), dataMap.get("WorkOrderStartTime"), dataMap.get("WorkOrderEndTime"),
                dataMap.get("WorkOrderAdArea"), dataMap.get("WorkOrderAdWeekDate"), dataMap.get("WorkOrderAdTime"));

        // 点击创建投放计划按钮
        workOrderManagerPage.clickCreateWorkOrderButton();

        // 创建投放计划
        createWorkOrderPage.testCreateWorkorder(workOrderInfo);
    }

    /**
     * @Title: testWorkOrderManager
     * @Description: 投放计划管理页面测试
     * @throws Exception
     * @return void
     */
    @Test
    public void testWorkOrderManager() throws Exception {
        // 导航：投放管理
        menu.goToWorkorderPage();

        // 点击投放计划名称链接
        workOrderManagerPage.testClickWorkOrderNameLink();

        // 编辑投放计划信息
        String strWorkOrderName = dataMap.get("EditWorkOrderName");
        String strCreateTime = dataMap.get("EditWorkOrderCreateTime");
        workOrderManagerPage.testEditWorkorder(strWorkOrderName, strCreateTime);

        // 点击监控投放计划按钮
        workOrderManagerPage.testMonitorWorkorder(true);

        // 点击内外网上下线按钮：上线
        workOrderManagerPage.testWholeNetWorkOnLine();

        // 点击内外网上下线按钮：下线
        workOrderManagerPage.testWholeNetWorkOnLine();

        // 点击关联计划按钮
        workOrderManagerPage.testAssocWorkorder();

        // 点击终止投放计划，取消按钮
        workOrderManagerPage.testAbortWorkorderCancel();

        // 点击终止投放计划，确认按钮
        workOrderManagerPage.testAbortWorkorderOK();

        // 点击删除投放计划，取消按钮
        workOrderManagerPage.testDeleteWorkorderCancel();

        // 点击删除投放计划，取消按钮
        workOrderManagerPage.testDeleteWorkorderOK();
    }

    /**
     * @Title: testWorkorderCreateDrama
     * @Description: 计划详情页面-选择媒资测试用例
     * @throws Exception
     * @return void
     */
    @Test
    public void testWorkorderCreateDrama() throws Exception {
        // 导航：投放管理
        menu.goToWorkorderPage();

        // 点击投放计划名称链接
        workOrderManagerPage.clickWorkOrderNameLink();

        // 点击投放计划详情选择媒资
        String strSearchDrama = dataMap.get("SearchDramaName");
        workOrderDramaListPage.testCreateDrama(strSearchDrama);
    }

    /**
     * @Title: testWorkorderDramaList
     * @Description: 计划详情页面测试用例
     * @throws Exception
     * @return void
     */
    @Test
    public void testWorkorderDramaList() throws Exception {
        // 导航：投放管理
        menu.goToWorkorderPage();

        // 点击投放计划名称链接
        workOrderManagerPage.clickWorkOrderNameLink();

        WorkOrderInfo workOrderInfo = new WorkOrderInfo();
        workOrderInfo.setYizhitieInfo(dataMap.get("AdPointType"), dataMap.get("YztPointMode"),
                dataMap.get("YztPointStartMin"), dataMap.get("YztPointStartSecond"), dataMap.get("YztPointEndMin"),
                dataMap.get("YztPointEndSecond"), dataMap.get("YztPointDisplayTime"),
                dataMap.get("YztPointDisplayCount"), dataMap.get("YztPointProductName"), dataMap.get("YztPointEffect"),
                dataMap.get("YztPointPosition"));
        // 添加易植贴智点
        workOrderDramaListPage.testCreateYizhitiePoint(workOrderInfo);

        TestBase.refreshPage();

        // 添加集页面
        workOrderDramaListPage.testInsMaterialPage();

        TestBase.refreshPage();

        // 编辑剧页面
        workOrderDramaListPage.testEditDramaButton(dataMap.get("EditDramaName"));

        TestBase.refreshPage();

        // 删除剧操作：取消操作
        workOrderDramaListPage.testDeleteDramaButton(false);

        TestBase.refreshPage();

        // 展开集列表页面
        workOrderDramaListPage.clickExpandOpeningDramaButton();

        // 集智点数据
        workOrderInfo.setYizhitieInfo(dataMap.get("AdMaterialPointType"), dataMap.get("YztMaterialPointMode"),
                dataMap.get("YztMaterialPointStartMin"), dataMap.get("YztMaterialPointStartSecond"),
                dataMap.get("YztMaterialPointEndMin"), dataMap.get("YztMaterialPointEndSecond"),
                dataMap.get("YztMaterialPointDisplayTime"), dataMap.get("YztMaterialPointDisplayCount"),
                dataMap.get("YztMaterialPointProductName"), dataMap.get("YztMaterialPointEffect"),
                dataMap.get("YztMaterialPointPosition"));
        // 添加集智点
        workOrderDramaListPage.testInsMaterialPoint(workOrderInfo);

        TestBase.refreshPage();

        // 展开集列表页面
        workOrderDramaListPage.clickExpandOpeningDramaButton();

        // 编辑集页面
        String materialText = dataMap.get("EditMaterialName");
        workOrderDramaListPage.testEditMaterialButton(materialText);

        TestBase.refreshPage();

        // 展开集列表页面
        workOrderDramaListPage.clickExpandOpeningDramaButton();

        // 删除所有智点按钮
        workOrderDramaListPage.testDeleteAllPoints(false);

        TestBase.refreshPage();

        // 展开集列表页面
        workOrderDramaListPage.clickExpandOpeningDramaButton();

        // 删除当前集信息
        workOrderDramaListPage.testDeleteCurrentMaterial(false);

        TestBase.refreshPage();

        // 展开集列表页面
        workOrderDramaListPage.clickExpandOpeningDramaButton();

        // 全部上线操作
        workOrderDramaListPage.testAllPointsOnline(true);

        TestBase.refreshPage();

        // 展开集列表页面
        workOrderDramaListPage.clickExpandOpeningDramaButton();

        // 全部下线操作
        workOrderDramaListPage.testAllPointsOffline(true);

        TestBase.refreshPage();

        // 展开集列表页面
        workOrderDramaListPage.clickExpandOpeningDramaButton();

        // 设置集监控信息
        workOrderDramaListPage.testMaterialMonitor(true);

        TestBase.refreshPage();

        // 展开集列表页面
        workOrderDramaListPage.clickExpandOpeningDramaButton();

        // 删除所有智点按钮
        workOrderDramaListPage.testDeleteAllPoints(true);

        TestBase.refreshPage();

        // 展开集列表页面
        workOrderDramaListPage.clickExpandOpeningDramaButton();

        // 收起集列表页面
        workOrderDramaListPage.clickExpandFodingDramaButton();
    }

    /**
     * @Title: testWorkorderMaterialList
     * @Description: 智点详情页面测试用例
     * @throws Exception
     * @return void
     */
    @Test
    public void testWorkorderPointList() throws Exception {
        // 导航：投放管理
        menu.goToWorkorderPage();

        // 点击投放计划名称链接
        workOrderManagerPage.clickWorkOrderNameLink();

        // 展开集列表页面
        workOrderDramaListPage.clickExpandOpeningDramaButton();

        // 点击进入智点详情页面
        workOrderDramaListPage.clickMaterialNameLink();

        WorkOrderInfo workOrderInfo = new WorkOrderInfo();
        // 集智点数据
        workOrderInfo.setYizhitieInfo(dataMap.get("AdMaterialPointType"), dataMap.get("YztMaterialPointMode"),
                dataMap.get("YztMaterialPointStartMin"), dataMap.get("YztMaterialPointStartSecond"),
                dataMap.get("YztMaterialPointEndMin"), dataMap.get("YztMaterialPointEndSecond"),
                dataMap.get("YztMaterialPointDisplayTime"), dataMap.get("YztMaterialPointDisplayCount"),
                dataMap.get("YztMaterialPointProductName"), dataMap.get("YztMaterialPointEffect"),
                dataMap.get("YztMaterialPointPosition"));
        // 添加集智点
        workOrderPointListPage.testInsMaterialPoint(workOrderInfo);

        TestBase.refreshPage();

        // 编辑集页面
        String materialText = dataMap.get("EditMaterialName");
        workOrderPointListPage.testEditMaterialButton(materialText);

        TestBase.refreshPage();

        // 删除所有智点按钮
        workOrderPointListPage.testDeleteAllPoints(false);

        TestBase.refreshPage();

        // 删除当前集信息
        workOrderPointListPage.testDeleteCurrentMaterial(false);

        TestBase.refreshPage();

        // 全部上线操作
        workOrderPointListPage.testAllPointsOnline(true);

        TestBase.refreshPage();

        // 全部下线操作
        workOrderPointListPage.testAllPointsOffline(true);

        TestBase.refreshPage();

        // 设置集监控信息
        workOrderPointListPage.testMaterialMonitor(true);

        TestBase.refreshPage();

        // 删除当前智点信息
        workOrderPointListPage.testDeleteCurrentPoint(false);

        TestBase.refreshPage();

        // 设置集编辑信息
        workOrderInfo.setYizhitieInfo(dataMap.get("AdPointType"), dataMap.get("YztPointMode"),
                dataMap.get("YztPointStartMin"), dataMap.get("YztPointStartSecond"), dataMap.get("YztPointEndMin"),
                dataMap.get("YztPointEndSecond"), dataMap.get("YztPointDisplayTime"),
                dataMap.get("YztPointDisplayCount"), dataMap.get("YztPointProductName"), dataMap.get("YztPointEffect"),
                dataMap.get("YztPointPosition"));
        // 编辑当前智点
        workOrderPointListPage.testEditPointButton(workOrderInfo);

        TestBase.refreshPage();

        // 上线当前智点信息
        workOrderPointListPage.testOnlinePoint(true, true);

        TestBase.refreshPage();

        // 上线当前智点信息
        workOrderPointListPage.testOnlinePoint(false, true);

        TestBase.refreshPage();

        // 设置智点监控信息
        workOrderPointListPage.testPointMonitor(true);
    }

    /**
     * @Title: testWorkorderMonitorList
     * @Description: 监控页面测试用例
     * @throws Exception
     * @return void
     */
    @Test
    public void testWorkorderMonitorList() throws Exception {
        // 导航：投放管理
        menu.goToWorkorderPage();

        // 点击监控投放计划按钮
        workOrderManagerPage.testMonitorWorkorder(false);

        MonitorInfo monitorInfo = new MonitorInfo();
        monitorInfo.setMonitorInfo(dataMap.get("AddMonitorTerminal"), dataMap.get("AddMonitorName"),
                dataMap.get("AddMonitorClickCode"), dataMap.get("AddMonitorDisplay"));
        // 添加监控信息
        workOrderMonitorPage.testAddMonitor(monitorInfo);

        monitorInfo.setMonitorInfo(dataMap.get("EditMonitorTerminal"), dataMap.get("EditMonitorName"),
                dataMap.get("EditMonitorClickCode"), dataMap.get("EditMonitorDisplay"));
        // 编辑监控信息
        workOrderMonitorPage.testEditMonitor(monitorInfo);

        // 删除取消监控信息
        workOrderMonitorPage.testDeleteMonitor(false);

        // 删除确定监控信息
        workOrderMonitorPage.testDeleteMonitor(true);

        // // 设置集监控信息
        // workOrderDramaListPage.testMaterialMonitor(false);
        //
        // // 设置智点监控信息
        // workOrderPointListPage.testPointMonitor(false);

    }
}
