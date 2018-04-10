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

import org.openqa.selenium.Cookie;

/**
 * @ClassName: CookiesUtil
 * @Description: TODO
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
public class CookiesUtil {
    private static Cookie cookie;

    /**
     * @Title: getCookie
     * @Description: 获得Cookie
     * @return
     * @return Cookie
     */
    public static Cookie getCookie() {
        return cookie;
    }

    /**
     * @Title: setCookie
     * @Description: 设置Cookie
     * @param cookieData
     * @return void
     */
    public static void setCookie(Cookie cookieData) {
        cookie = cookieData;
    }
}
