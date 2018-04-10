/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.framework.constants
 * @author Ren Qiang
 * @date:Mar 7, 2018
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.constants;

/**
 * @ClassName: ProductTypeConstants
 * @Description: 物料的类型常量
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
public class ProductTypeConstants {
    /**
     * 物料的类型.
     */
    public static enum ProductType {
        // 百科信息
        BAIKE(PRODUCT_TYPE_BAIKE),
        // 购物
        GOUWU(PRODUCT_TYPE_GOUWU),
        // 红包
        HONGBAO(PRODUCT_TYPE_HONGBAO),
        // 优惠码
        YOUHUIMA(PRODUCT_TYPE_YOUHUIMA),
        // 投票
        TOUPIAO(PRODUCT_TYPE_TOUPIAO),
        // 神字幕
        SHENZIMU(PRODUCT_TYPE_SHENZIMU),
        // 易植贴
        YIZHITIE(PRODUCT_TYPE_YIZHITIE),
        // 动态视窗
        DONGTAISHICHUANG(PRODUCT_TYPE_DONGTAISHICHUANG);

        private String value;

        private ProductType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * 物料类型：百科.
     */
    public static final String PRODUCT_TYPE_BAIKE = "百科信息";

    /**
     * 物料类型：购物.
     */
    public static final String PRODUCT_TYPE_GOUWU = "购物";

    /**
     * 物料类型：红包.
     */
    public static final String PRODUCT_TYPE_HONGBAO = "红包";

    /**
     * 物料类型：优惠码.
     */
    public static final String PRODUCT_TYPE_YOUHUIMA = "优惠码";

    /**
     * 物料类型：投票.
     */
    public static final String PRODUCT_TYPE_TOUPIAO = "投票";

    /**
     * 物料类型：神字幕.
     */
    public static final String PRODUCT_TYPE_SHENZIMU = "神字幕";

    /**
     * 物料类型：易植贴.
     */
    public static final String PRODUCT_TYPE_YIZHITIE = "易植贴";

    /**
     * 物料类型：动态视窗.
     */
    public static final String PRODUCT_TYPE_DONGTAISHICHUANG = "动态视窗";
}
