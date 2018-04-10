/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.dataentity
 * @author Ren Qiang
 * @date:Mar 7, 2018
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.dataentity;

/**
 * @ClassName: ProductInfo
 * @Description: TODO
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
public class ProductInfo {
    // 共通：团队归属
    public String teamID;

    // 共通：客户筛选
    public String memberID;

    // 共通：归属平台
    public String platform;

    // 共通：物料名称
    public String productName;

    // 共通：物料分类
    public String category;

    // 共通：按钮文案
    public String productText;

    // 活动说明
    public String activityDescription;

    // 红包：红包口令
    public String redPacket;

    // 红包：兑换说明
    public String convertDescription;

    // 优惠码：结束说明
    public String endDescription;

    // 详细描述
    public String productDescriptionText;

    // 共通：跳转链接
    public String clickLink;

    // 红包：价格
    public String productMinPrice;

    // 优惠码：优惠码口令
    public String convertCode;

    // 投票：选择版式:上下版式 OR 左右版式（参考常量）
    public String formatUpDownOrLeftRight;

    // 投票：投票提问
    public String voteProblem;

    // 投票：投票选项1：创建
    public String voteOption1Text;

    // 投票：投票选项2：创建
    public String voteOption2Text;

    // 投票：投票选项2:编辑
    public String voteOption2Edit;

    // 投票：投票选项3
    public String voteOption3Text;

    // 神字幕：选择版式:基础类
    public String formatIDSelete;

    // 神字幕：选择版式:样式一
    public String styleIDSelete;

    // 共通：客户LOGO
    public String clientLogoImg;

    // 共通：广告图片
    public String templateImg;

    // 百科 ，购物：展示图片:0
    public String showImgDiv0Img;

    // 百科 ，购物：展示图片:1
    public String showImgDiv1Img;

    // 百科 ，购物：删除展示图片
    public String deleteShowImgImg;

    // 共通：选择自定义图标的图片
    public String customizeIconImg;

    // 百科：选择 Video易默认图标
    public String defaultBaike;

    // 购物：选择 Video易默认图标
    public String defaultGouwu;

    // 红包：选择 Video易默认图标
    public String defaultHongbao;

    // 优惠码：选择 Video易默认图标
    public String defaultYouhuima;

    // 投票：选择 Video易默认图标
    public String defaultToupiao;

    // 百科：选择颜色
    public String colorBaike;

    // 购物：选择颜色
    public String colorGouwu;

    // 百科：选择颜色:默认
    public String defaultColorBaike;

    // 百科：选择颜色:蓝色
    public String blueColorBaike;

    // 百科：选择颜色:紫色
    public String pinkColorBaike;

    // 百科：选择颜色:自定义颜色
    public String customizeColorBaike;

    // 百科：选择颜色:自定义颜色:R
    public String customizeRColorBaike;

    // 百科：选择颜色:自定义颜色:G
    public String customizeGColorBaike;

    // 百科：选择颜色:自定义颜色:B
    public String customizeBColorBaike;

    // 购物：选择颜色:默认
    public String defaultColorGouwu;

    // 购物：选择颜色:蓝色
    public String blueColorGouwu;

    // 购物：选择颜色:紫色
    public String pinkColorGouwu;

    // 购物：选择颜色:自定义颜色
    public String customizeColorGouwu;

    // 购物：选择颜色:自定义颜色:R
    public String customizeRColorGouwu;

    // 购物：选择颜色:自定义颜色:G
    public String customizeGColorGouwu;

    // 购物：选择颜色:自定义颜色:B
    public String customizeBColorGouwu;

    // 百科，购物：选择边框
    public String imgValBorderImg;

    // 百科，购物：选择边框:删除边框
    public String imgValBorderDelete;

    // 百科：logo位置一，编辑
    public String logo1Edit;

    // 购物：logo位置一，创建
    public String logo1Create;

    // 百科：logo位置二，创建
    public String logo2Create;

    // 购物：logo位置二，编辑
    public String logo2Edit;

    // 百科，购物：logo图片
    public String logoImgBorderImg;

    // 神字幕：点击效果：选择无,浮层,外链（参加常量）
    public String clickEffectSelect;

    // 神字幕:跳转链接
    public String jumpLine;

    // 添加易植贴
    public String yztImg;

    // 动态视窗素材上传
    public String videoUpForm;

    /**
     * Constructor without fields.
     */
    public ProductInfo() {
        super();
    }

    /**
     * @Title: setHongbaoProductInfo
     * @Description: 设置红包物料信息
     * @param teamID
     * @param memberID
     * @param platform
     * @param productName
     * @param category
     * @param productText
     * @param activityDescription
     * @param redPacket
     * @param convertDescription
     * @param clientLogoImg
     * @param templateImg
     * @param customizeIconImg
     * @return void
     */
    public void setHongbaoProductInfo(String teamID, String memberID, String platform, String productName,
            String category, String productText, String activityDescription, String redPacket,
            String convertDescription, String clientLogoImg, String templateImg, String customizeIconImg) {
        this.teamID = teamID;
        this.memberID = memberID;
        this.platform = platform;
        this.productName = productName;
        this.category = category;
        this.productText = productText;
        this.activityDescription = activityDescription;
        this.redPacket = redPacket;
        this.convertDescription = convertDescription;
        this.clientLogoImg = clientLogoImg;
        this.templateImg = templateImg;
        this.customizeIconImg = customizeIconImg;
    }

    /**
     * @Title: setYouhuimaProductInfo
     * @Description: 设置优惠码物料信息
     * @param teamID
     * @param memberID
     * @param platform
     * @param productName
     * @param category
     * @param productText
     * @param activityDescription
     * @param convertCode
     * @param convertDescription
     * @param endDescription
     * @param clientLogoImg
     * @param templateImg
     * @return void
     */
    public void setYouhuimaProductInfo(String teamID, String memberID, String platform, String productName,
            String category, String productText, String activityDescription, String convertCode,
            String convertDescription, String endDescription, String clientLogoImg, String templateImg,
            String customizeIconImg) {
        this.teamID = teamID;
        this.memberID = memberID;
        this.platform = platform;
        this.productName = productName;
        this.category = category;
        this.productText = productText;
        this.activityDescription = activityDescription;
        this.convertCode = convertCode;
        this.convertDescription = convertDescription;
        this.endDescription = endDescription;
        this.clientLogoImg = clientLogoImg;
        this.templateImg = templateImg;
        this.customizeIconImg = customizeIconImg;
    }

    /**
     * @Title: setYizhitieProductInfo
     * @Description: 设置易植贴物料信息
     * @param teamID
     * @param memberID
     * @param platform
     * @param productName
     * @param category
     * @param clickLink
     * @param yztImg
     * @return void
     */
    public void setYizhitieProductInfo(String teamID, String memberID, String platform, String productName,
            String category, String clickLink, String yztImg) {
        this.teamID = teamID;
        this.memberID = memberID;
        this.platform = platform;
        this.productName = productName;
        this.category = category;
        this.clickLink = clickLink;
        this.yztImg = yztImg;
    }

    /**
     * @Title: setDtscProductInfo
     * @Description: 设置动态视窗物料信息
     * @param teamID
     * @param memberID
     * @param platform
     * @param productName
     * @param category
     * @param clickLink
     * @param videoUpForm
     * @return void
     */
    public void setDtscProductInfo(String teamID, String memberID, String platform, String productName, String category,
            String clickLink, String videoUpForm) {
        this.teamID = teamID;
        this.memberID = memberID;
        this.platform = platform;
        this.productName = productName;
        this.category = category;
        this.clickLink = clickLink;
        this.videoUpForm = videoUpForm;
    }
}