/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.framework.utility
 * @author:Ren Qiang
 * @date:Mar 7, 2018
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.framework.utility;

import java.util.HashMap;

/**
 * @ClassName: PageObjectUtil
 * @Description: 获取页面对象的工具类
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
public class PageObjectUtil {

    // 页面对象集合
    private static HashMap<String, Object> pageobjs = null;

    /**
     * @Title: setPageObjMap
     * @Description: 设置页面对象
     * @param Map
     * @return void
     */
    public static void setPageObjMap(HashMap<String, Object> Map) {
        pageobjs = Map;
    }

    /**
     * @Title: getPageObject
     * @Description: 获得页面对象
     * @param pageObjectClassName
     * @return
     * @return T
     */
    @SuppressWarnings("unchecked")
    public static <T> T getPageObject(String pageObjectClassName) {
        return (T) pageobjs.get(pageObjectClassName);
    }

}