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
 * @ClassName: PropertiesUtil
 * @Description: 获取配置文件的值
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
public class PropertiesUtil {
    // 属性集合
    private static HashMap<String, String> PropertyKeyValus = null;

    /**
     * @Title: setKeyValueMap
     * @Description: 设置所有属性值
     * @param map
     * @return void
     */
    public static void setKeyValueMap(HashMap<String, String> map) {
        PropertyKeyValus = map;
    }

    /**
     * @Title: getPropertyValue
     * @Description: 获取指定的属性值
     * @param Key
     * @return
     * @return String
     */
    public static String getPropertyValue(String Key) {
        return PropertyKeyValus.get(Key);
    }

    /**
     * @Title: getPropertyKVMap
     * @Description: 获取所有属性值
     * @return
     * @return HashMap<String,String>
     */
    public static HashMap<String, String> getPropertyKVMap() {
        return PropertyKeyValus;
    }
}