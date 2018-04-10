/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.dataentity
 * @author Ren Qiang
 * @date:Mar 30, 2018
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.dataentity;

/**
 * @ClassName: MonitorInfo
 * @Description: 监控信息
 * @author: Ren Qiang
 * @date: Mar 30, 2018
 */
public class MonitorInfo {

    // 选择终端
    public String terminalType;

    // 监控名称
    public String monitorName;

    // 点击监控代码
    public String monitorClickCode;

    // 展示监控代码
    public String monitorDisplayCode;

    /**
     * Constructor without fields.
     */
    public MonitorInfo() {
        super();
    }

    public void setMonitorInfo(String terminalType, String monitorName, String monitorClickCode,
            String monitorDisplayCode) {
        this.terminalType = terminalType;
        this.monitorName = monitorName;
        this.monitorClickCode = monitorClickCode;
        this.monitorDisplayCode = monitorDisplayCode;

    }
}
