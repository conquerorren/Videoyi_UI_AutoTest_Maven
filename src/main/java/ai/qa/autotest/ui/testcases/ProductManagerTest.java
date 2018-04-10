/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.testcases
 * @author Ren Qiang
 * @date:Mar 7, 2018
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.testcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import ai.qa.autotest.ui.constants.ProductTypeConstants.ProductType;
import ai.qa.autotest.ui.custom.annotation.AutoInject;
import ai.qa.autotest.ui.custom.annotation.DataObject;
import ai.qa.autotest.ui.dataentity.ProductInfo;
import ai.qa.autotest.ui.pageobject.CreateProductPage;
import ai.qa.autotest.ui.pageobject.NavigationMenu;
import ai.qa.autotest.ui.pageobject.ProductManagerPage;
import ai.qa.autotest.ui.testbase.AdminPortalTestBase;

/**
 * @ClassName: ProductManagerTest
 * @Description: 物料管理页面测试用例
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
public class ProductManagerTest extends AdminPortalTestBase {
    // 导航菜单
    @AutoInject
    private NavigationMenu menu;

    // 物料管理页面
    @AutoInject
    private ProductManagerPage productManagerPage;

    // 创建物料页面
    @AutoInject
    private CreateProductPage createProductPage;

    // 创建物料测试数据
    @DataObject(DataNode = "CreateHongbaoProduct,EditHongbaoProduct,CreateYouhuimaProduct,EditYouhuimaProduct,"
            + "CreateYizhitieProduct,EditYizhitieProduct,CreateDTSCProduct,EditDTSCProduct,SearchProductPage,CreateMgtvYizhitieProduct")
    private HashMap<String, String> dataMap;

    /**
     * @Title: testSearchProduct
     * @Description: 模糊检索物料信息
     * @throws Exception
     * @return void
     */
    @Test
    public void testSearchProduct() throws Exception {
        // 导航：物料管理
        menu.goToProductManagerPage();

        String strTeamID = dataMap.get("SearchProductTeamID");
        String strMemberID = dataMap.get("SearchProductMemberID");
        String strKeyword = dataMap.get("SearchProductKey");

        // 模糊检索物料信息：有该物料信息
        productManagerPage.testSearchProduct(strTeamID, strMemberID, strKeyword);
    }

    /**
     * @Title: testDeleteProductCancel
     * @Description: 删除物料:取消
     * @throws Exception
     * @return void
     */
    @Test
    public void testDeleteProductCancel() throws Exception {
        // 导航：物料管理
        menu.goToProductManagerPage();

        // 点击删除物料:取消
        productManagerPage.testDeleteProductCancel();
    }

    /**
     * @Title: testDeleteProductOK
     * @Description: 删除物料：确定
     * @throws Exception
     * @return void
     */
    @Test
    public void testDeleteProductOK() throws Exception {
        // 导航：物料管理
        menu.goToProductManagerPage();
        // 点击删除物料:确定
        productManagerPage.testDeleteProductOK();
    }

    /**
     * @Title: testCreateHongbaoProduct
     * @Description: 创建和编辑红包物料
     * @throws Exception
     * @return void
     */
    @Test
    public void testCreateHongbaoProduct() throws Exception {
        // 导航：物料管理
        menu.goToProductManagerPage();

        // 点击创建红包物料
        productManagerPage.clickCreateProduct();

        // 准备红包素材
        ProductInfo productInfo = new ProductInfo();
        productInfo.setHongbaoProductInfo(dataMap.get("HbTeamID"), dataMap.get("HbMemberID"), dataMap.get("HbPlatform"),
                dataMap.get("HbProductName"), dataMap.get("HbCategory"), dataMap.get("HbProductText"),
                dataMap.get("HbActivityDescription"), dataMap.get("HbRedPacket"), dataMap.get("HbConvertDescription"),
                dataMap.get("HbClientLogoImg"), dataMap.get("HbTemplateImg"), dataMap.get("HbCustomizeIconImg"));

        // 创建红包
        createProductPage.testCreateHongbaoProduct(productInfo, false);

        // 点击物料名称链接并返回物料管理
        productManagerPage.testClickProductNameLink();

        // 点击物料图片链接，关闭按钮
        productManagerPage.testClickProductImgLink(ProductType.HONGBAO);

        // 编辑物料按钮显示时
        if (productManagerPage.isEditPresent()) {
            productInfo.setHongbaoProductInfo(dataMap.get("HbEditTeamID"), dataMap.get("HbEditMemberID"),
                    dataMap.get("HbEditPlatform"), dataMap.get("HbEditProductName"), dataMap.get("HbEditCategory"),
                    dataMap.get("HbEditProductText"), dataMap.get("HbEditActivityDescription"),
                    dataMap.get("HbEditRedPacket"), dataMap.get("HbEditConvertDescription"),
                    dataMap.get("HbEditClientLogoImg"), dataMap.get("HbEditTemplateImg"),
                    dataMap.get("HbEditCustomizeIconImg"));
            productManagerPage.clickEditProduct();
            // 修改红包
            createProductPage.testCreateHongbaoProduct(productInfo, true);
        }

        // 点击删除物料:取消
        productManagerPage.testDeleteProductCancel();

        // // 点击删除物料:确定
        // productManagerPage.testDeleteProductOK();
    }

    /**
     * @Title: testCreateYouhuimaProduct
     * @Description: 创建和编辑优惠码物料
     * @throws Exception
     * @return void
     */
    @Test
    public void testCreateYouhuimaProduct() throws Exception {
        // 导航：物料管理
        menu.goToProductManagerPage();

        // 点击创建优惠码物料
        productManagerPage.clickCreateProduct();

        // 准备优惠码素材
        ProductInfo productInfo = new ProductInfo();
        productInfo.setYouhuimaProductInfo(dataMap.get("YhmTeamID"), dataMap.get("YhmMemberID"),
                dataMap.get("YhmPlatform"), dataMap.get("YhmProductName"), dataMap.get("YhmCategory"),
                dataMap.get("YhmProductText"), dataMap.get("YhmActivityDescription"), dataMap.get("YhmConvertCode"),
                dataMap.get("YhmConvertDescription"), dataMap.get("YhmEndDescription"), dataMap.get("YhmClientLogoImg"),
                dataMap.get("YhmTemplateImg"), dataMap.get("YhmCustomizeIconImg"));

        // 创建优惠码
        createProductPage.testCreateYouhuimaProduct(productInfo, false);

        // 点击物料名称链接并返回物料管理
        productManagerPage.testClickProductNameLink();

        // 点击物料图片链接，关闭按钮
        productManagerPage.testClickProductImgLink(ProductType.YOUHUIMA);

        // 编辑物料按钮显示时
        if (productManagerPage.isEditPresent()) {
            productInfo.setYouhuimaProductInfo(dataMap.get("YhmEditTeamID"), dataMap.get("YhmEditMemberID"),
                    dataMap.get("YhmEditPlatform"), dataMap.get("YhmEditProductName"), dataMap.get("YhmEditCategory"),
                    dataMap.get("YhmEditProductText"), dataMap.get("YhmEditActivityDescription"),
                    dataMap.get("YhmEditConvertCode"), dataMap.get("YhmEditConvertDescription"),
                    dataMap.get("YhmEditEndDescription"), dataMap.get("YhmEditClientLogoImg"),
                    dataMap.get("YhmEditTemplateImg"), dataMap.get("YhmEditCustomizeIconImg"));
            productManagerPage.clickEditProduct();
            // 修改优惠码
            createProductPage.testCreateYouhuimaProduct(productInfo, true);
        }

        // 点击删除物料:取消
        productManagerPage.testDeleteProductCancel();

        // // 点击删除物料:确定
        // productManagerPage.testDeleteProductOK();
    }

    /**
     * @Title: testCreateYizhitieProduct
     * @Description: 创建和编辑易植贴物料
     * @throws Exception
     * @return void
     */
    @Test
    public void testCreateYizhitieProduct() throws Exception {
        // 导航：物料管理
        menu.goToProductManagerPage();

        // 点击创建易植贴物料
        productManagerPage.clickCreateProduct();

        // 准备易植贴素材
        ProductInfo productInfo = new ProductInfo();
        productInfo.setYizhitieProductInfo(dataMap.get("YztTeamID"), dataMap.get("YztMemberID"),
                dataMap.get("YztPlatform"), dataMap.get("YztProductName"), dataMap.get("YztCategory"),
                dataMap.get("YztClickLink"), dataMap.get("YztYztImg"));

        // 创建易植贴
        createProductPage.testCreateYizhitieProduct(productInfo, false);

        // 点击物料名称链接并返回物料管理
        productManagerPage.testClickProductNameLink();

        // 点击物料图片链接，关闭按钮
        productManagerPage.testClickProductImgLink(ProductType.YIZHITIE);

        // 编辑物料按钮显示时
        if (productManagerPage.isEditPresent()) {
            productInfo.setYizhitieProductInfo(dataMap.get("YztTeamID"), dataMap.get("YztMemberID"),
                    dataMap.get("YztPlatform"), dataMap.get("YztProductName"), dataMap.get("YztCategory"),
                    dataMap.get("YztClickLink"), dataMap.get("YztYztImg"));
            productManagerPage.clickEditProduct();
            // 修改易植贴
            createProductPage.testCreateYizhitieProduct(productInfo, true);
        }

        // 点击删除物料:取消
        productManagerPage.testDeleteProductCancel();

        // // 点击删除物料:确定
        // productManagerPage.testDeleteProductOK();

        // 点击创建易植贴物料
        productManagerPage.clickCreateProduct();

        // 创建芒果平台的易植贴
        productInfo.setYizhitieProductInfo(dataMap.get("YztMgtvTeamID"), dataMap.get("YztMgtvMemberID"),
                dataMap.get("YztMgtvPlatform"), dataMap.get("YztMgtvProductName"), dataMap.get("YztMgtvCategory"),
                dataMap.get("YztMgtvClickLink"), dataMap.get("YztMgtvYztImg"));
        // 创建芒果TV易植贴
        createProductPage.testCreateYizhitieProduct(productInfo, false);
    }

    /**
     * @Title: testCreateDtscProduct
     * @Description: 创建和编辑动态视窗物料
     * @throws Exception
     * @return void
     */
    @Test
    public void testCreateDtscProduct() throws Exception {
        // 导航：物料管理
        menu.goToProductManagerPage();

        // 点击创建动态视窗物料
        productManagerPage.clickCreateProduct();

        // // 准备动态视窗素材
        ProductInfo productInfo = new ProductInfo();
        productInfo.setDtscProductInfo(dataMap.get("DtscTeamID"), dataMap.get("DtscMemberID"),
                dataMap.get("DtscPlatform"), dataMap.get("DtscProductName"), dataMap.get("DtscCategory"),
                dataMap.get("DtscClickLink"), dataMap.get("DtscVideoUpForm"));

        // 创建动态视窗
        createProductPage.testCreateDtscProduct(productInfo, false);

        // 点击物料名称链接并返回物料管理
        productManagerPage.testClickProductNameLink();

        // 点击物料图片链接，关闭按钮
        productManagerPage.testClickProductImgLink(ProductType.DONGTAISHICHUANG);

        // 编辑物料按钮显示时
        if (productManagerPage.isEditPresent()) {
            productInfo.setDtscProductInfo(dataMap.get("DtscEditTeamID"), dataMap.get("DtscEditMemberID"),
                    dataMap.get("DtscEditPlatform"), dataMap.get("DtscEditProductName"),
                    dataMap.get("DtscEditCategory"), dataMap.get("DtscEditClickLink"),
                    dataMap.get("DtscEditVideoUpForm"));
            productManagerPage.clickEditProduct();
            // 修改动态视窗
            createProductPage.testCreateDtscProduct(productInfo, true);
        }

        // 点击删除物料:取消
        productManagerPage.testDeleteProductCancel();

        // // 点击删除物料:确定
        // productManagerPage.testDeleteProductOK();
    }
}
