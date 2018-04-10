/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.constants
 * @author Ren Qiang
 * @date:Mar 29, 2018
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.constants;

/**
 * @ClassName: PointStatusConstants
 * @Description: 智点的状态
 * @author: Ren Qiang
 * @date: Mar 29, 2018
 */
public class PointStatusConstants {
    /**
     * 智点的状态.
     */
    public static enum PointStatus {
        // 全部
        ALL(POINT_STATUS_ALL),
        // 审核中
        REVIEWING(POINT_STATUS_REVIEWING),
        // 被驳回
        DISMISSED(POINT_STATUS_DISMISSED),
        // 已完成
        COMPLETED(POINT_STATUS_COMPLETED),
        // 上线
        ONLINE(POINT_STATUS_ONLINE),
        // 下线
        OFFLINE(POINT_STATUS_OFFLINE);

        private String value;

        private PointStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * 智点的状态：全部.
     */
    public static final String POINT_STATUS_ALL = "全部";

    /**
     * 智点的状态：审核中.
     */
    public static final String POINT_STATUS_REVIEWING = "审核中";

    /**
     * 智点的状态：被驳回.
     */
    public static final String POINT_STATUS_DISMISSED = "被驳回";

    /**
     * 智点的状态：已完成.
     */
    public static final String POINT_STATUS_COMPLETED = "已完成";

    /**
     * 智点的状态：上线.
     */
    public static final String POINT_STATUS_ONLINE = "上线";

    /**
     * 智点的状态：下线.
     */
    public static final String POINT_STATUS_OFFLINE = "下线";
}
