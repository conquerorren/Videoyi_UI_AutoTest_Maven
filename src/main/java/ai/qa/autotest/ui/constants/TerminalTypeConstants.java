/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.constants
 * @author Ren Qiang
 * @date:Mar 15, 2018
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.constants;

/**
 * @ClassName: TerminalTypeConstants
 * @Description: TODO
 * @author: Ren Qiang
 * @date: Mar 15, 2018
 */
public class TerminalTypeConstants {
    /**
     * 终端的类型.
     */
    public static enum TerminalType {
        // 全部终端
        ALL(TERMINAL_ALL),
        // PC端
        PC(TERMINAL_PC),
        // 移动端
        MOBILE(TERMINAL_MOBILE),
        // 移动Android端
        MOBILE_ANDROID(TERMINAL_MOBILE_ANDROID),
        // 移动IOS端
        MOBILE_IOS(TERMINAL_MOBILE_IOS),
        // OTT端
        OTT(TERMINAL_OTT);

        private String value;

        private TerminalType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * 终端：全部终端.
     */
    public static final String TERMINAL_ALL = "全部终端";

    /**
     * 终端：PC端.
     */
    public static final String TERMINAL_PC = "PC端";

    /**
     * 终端：移动APP端.
     */
    public static final String TERMINAL_MOBILE = "移动APP";

    /**
     * 终端：Android端.
     */
    public static final String TERMINAL_MOBILE_ANDROID = "Android端";

    /**
     * 终端：IOS端.
     */
    public static final String TERMINAL_MOBILE_IOS = "IOS端";

    /**
     * 终端：OTT端.
     */
    public static final String TERMINAL_OTT = "OTT";
}
