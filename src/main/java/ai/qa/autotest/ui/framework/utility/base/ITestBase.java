/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.framework.utility.base
 * @author:Ren Qiang
 * @date:Mar 7, 2018
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.framework.utility.base;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlTest;

/**
 * @ClassName: ITestBase
 * @Description: 测试基类接口
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
public interface ITestBase {

    /**
     * @Title: initTest
     * @Description: 所有测试套件执行前执行
     * @param xt
     * @param tc
     * @throws Exception
     * @return void
     */
    @BeforeSuite
    public void initTest(XmlTest xt, ITestContext tc) throws Exception;

    /**
     * @Title: terminTestSuite
     * @Description: 所有测试套件执行完后执行
     * @param xt
     * @param tc
     * @throws Exception
     * @return void
     */
    @AfterSuite
    public void terminTestSuite(XmlTest xt, ITestContext tc) throws Exception;

    /**
     * @Title: beforeClass
     * @Description: 测试类执行前执行
     * @param xt
     * @param tc
     * @throws Exception
     * @return void
     */
    @BeforeClass
    public void beforeClass(XmlTest xt, ITestContext tc) throws Exception;

    /**
     * @Title: afterClass
     * @Description: 测试类执行完后执行
     * @param xt
     * @param tc
     * @throws Exception
     * @return void
     */
    @AfterClass
    public void afterClass(XmlTest xt, ITestContext tc) throws Exception;

    /**
     * @Title: beforeTest
     * @Description: 测试执行前执行
     * @param xt
     * @param tc
     * @throws Exception
     * @return void
     */
    @BeforeTest
    public void beforeTest(XmlTest xt, ITestContext tc) throws Exception;

    /**
     * @Title: afterTest
     * @Description: 测试执行完后执行
     * @param xt
     * @param tc
     * @throws Exception
     * @return void
     */
    @AfterTest
    public void afterTest(XmlTest xt, ITestContext tc) throws Exception;

    /**
     * @Title: initDriver
     * @Description: 测试方法执行前配置和启动浏览器
     * @param tc
     * @param m
     * @param xt
     * @throws Exception
     * @return void
     */
    @BeforeMethod
    public void initDriver(ITestContext tc, Method m, XmlTest xt) throws Exception;

    /**
     * @Title: cleanEnv
     * @Description: 清理当前测试环境
     * @param rs
     * @param xt
     * @param m
     * @param tc
     * @throws Exception
     * @return void
     */
    @AfterMethod
    public void cleanEnv(ITestResult rs, XmlTest xt, Method m, ITestContext tc) throws Exception;
}