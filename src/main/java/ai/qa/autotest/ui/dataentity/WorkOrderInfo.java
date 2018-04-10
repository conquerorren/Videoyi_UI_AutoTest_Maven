/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.dataentity
 * @author Ren Qiang
 * @date:Mar 15, 2018
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.dataentity;

/**
 * @ClassName: WorkOrderInfo
 * @Description: TODO
 * @author: Ren Qiang
 * @date: Mar 15, 2018
 */
public class WorkOrderInfo {

    // 计划名称
    public String workVideoName;

    // 团队归属
    public String teamID;

    // 客户筛选
    public String memberID;

    // 费用
    public String budget;

    // 终端
    public String terminal;

    // 是否共享
    public String isShared;

    // 开始时间
    public String startTime;

    // 结束时间
    public String endTime;

    // 地区定向
    public String adArea;

    // 投放日期
    public String adWeekDate;

    // 投放时段
    public String adTime;

    // 创建易植贴智点：类型
    public String adType;

    // 创建易植贴智点：
    public String mode;

    // 开始时间：分
    public String startMin;

    // 开始时间：秒
    public String startSecond;

    // 结束时间：分
    public String endMin;

    // 结束时间：秒
    public String endSecond;

    // 展示时长
    public String displayTime;

    // 展示次数
    public String displayCount;

    // 选择物料
    public String productName;

    // 动效
    public String effect;

    // 坐标
    public String position;

    /**
     * Constructor without fields.
     */
    public WorkOrderInfo() {
        super();
    }

    /**
     * @Title: setWorkOrderInfo
     * @Description: 设置投放计划信息
     * @param workVideoName
     * @param teamID
     * @param memberID
     * @param budget
     * @param terminal
     * @param isShared
     * @param startTime
     * @param endTime
     * @return void
     */
    public void setWorkOrderInfo(String workVideoName, String teamID, String memberID, String budget, String terminal,
            String isShared, String startTime, String endTime, String adArea, String adWeekDate, String adTime) {
        this.workVideoName = workVideoName;
        this.teamID = teamID;
        this.memberID = memberID;
        this.budget = budget;
        this.terminal = terminal;
        this.isShared = isShared;
        this.startTime = startTime;
        this.endTime = endTime;
        this.adArea = adArea;
        this.adWeekDate = adWeekDate;
        this.adTime = adTime;
    }

    /**
     * @Title: setYizhitieInfo
     * @Description: 易植贴信息
     * @param adType
     * @param mode
     * @param startMin
     * @param startSecond
     * @param endMin
     * @param endSecond
     * @param displayTime
     * @param displayCount
     * @param productId
     * @param effect
     * @param position
     * @return void
     */
    public void setYizhitieInfo(String adType, String mode, String startMin, String startSecond, String endMin,
            String endSecond, String displayTime, String displayCount, String productName, String effect,
            String position) {
        this.adType = adType;
        this.mode = mode;
        this.startMin = startMin;
        this.startSecond = startSecond;
        this.endMin = endMin;
        this.endSecond = endSecond;
        this.displayTime = displayTime;
        this.displayCount = displayCount;
        this.productName = productName;
        this.effect = effect;
        this.position = position;

    }
}
