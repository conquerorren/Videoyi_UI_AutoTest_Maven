/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.dataentity
 * @author:Ren Qiang
 * @date:Mar 7, 2018
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.dataentity;

/**
 * @ClassName: MemberInfo
 * @Description: 客户管理信息
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
public class MemberInfo {
    // 客户名称
    public String memberName;

    // 归属团队
    public String teamID;

    // 公司名称
    public String companyName;

    // 公司行业
    public String memberTrade;

    // 公司地区
    public String memberArea;

    // 城市
    public String memberAreaCity;

    // 区县
    public String memberAreaSection;

    // 客户姓名
    public String memberContactName;

    // 客户电话
    public String memberContactMobile;

    // 客户职务
    public String memberContactPosition;

    /**
     * Constructor without fields.
     */
    public MemberInfo() {
        super();
    }

    /**
     * Set MemberInfo.
     */
    public void setMemberInfo(String memberName, String teamID, String companyName, String memberTrade,
            String memberArea, String memberAreaCity, String memberAreaSection, String memberContactName,
            String memberContactMobile, String memberContactPosition) {
        this.memberName = memberName;
        this.teamID = teamID;
        this.companyName = companyName;
        this.memberTrade = memberTrade;
        this.memberArea = memberArea;
        this.memberAreaCity = memberAreaCity;
        this.memberAreaSection = memberAreaSection;
        this.memberContactName = memberContactName;
        this.memberContactMobile = memberContactMobile;
        this.memberContactPosition = memberContactPosition;
    }
}
