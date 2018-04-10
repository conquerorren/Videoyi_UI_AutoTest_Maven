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

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import ai.qa.autotest.ui.custom.annotation.AutoInject;
import ai.qa.autotest.ui.custom.annotation.PageObject;
import ai.qa.autotest.ui.framework.constants.PropertiesKeys;
import ai.qa.autotest.ui.testbase.TestBase;

/**
 * @ClassName: InitPageObject
 * @Description: 1.模拟IOC容器 通过反射扫描配置好的pageobject包并将 pageobject实例存放到全局静态MAP中。
 *               2.实现了依赖注入功能 DI
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
public class InitPageObject {
    // 声明的Fields集合
    private static Field[] fields = null;
    // page对象
    private Object pageobj;
    // 扫描的路径
    private String packAgePref = "src\\main\\java\\";

    /**
     * @Title:InitPageObject
     * @Description: 初始化对象
     * @param obj
     */
    public InitPageObject(Object obj) {
        this.pageobj = obj;
        // 将页面对象存放到MAP中，MAP充当一个bean容器
        PageObjectUtil.setPageObjMap(initPageObjMap());
    }

    /**
     * @Title: initPageObjMap
     * @Description: 初始化page对象集合
     * @return
     * @return HashMap<String,Object>
     */
    private HashMap<String, Object> initPageObjMap() {
        HashMap<String, Object> pageobjs = new HashMap<String, Object>();
        HashSet<String> fieldSet = new HashSet<String>();
        String curClassName = TestBase.getTestCaseDeclaringClass();

        try {
            String[] packagePath = PropertiesUtil.getPropertyValue(PropertiesKeys.INIT_PAGEOBJ_PACKAGE).split(",");
            fields = Class.forName(curClassName).getDeclaredFields();
            fillFieldNameSet(fields, fieldSet);
            for (int i = 0; i < packagePath.length; i++) {
                String pPath = packagePath[i];
                ArrayList<String> classNames = new ArrayList<String>();
                getClassName(packAgePref + pPath.replace(".", "\\"), classNames, pPath);
                for (int j = 0; j < classNames.size(); j++) {
                    String className = classNames.get(j);
                    Class<?> classObj = Class.forName(className);
                    if (classObj.getAnnotation(PageObject.class) != null
                            && fieldSet.contains(classObj.getSimpleName())) {
                        pageobjs.put(classObj.getSimpleName(), classObj.newInstance());
                    }
                }
            }

            injectPageObj(fields, pageobjs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageobjs;
    }

    /**
     * @Title: injectPageObj
     * @Description: 实现向测试用例类自动注入页面对象的功能
     * @param fields
     * @param pageobjs
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @return void
     */
    private void injectPageObj(Field[] fields, HashMap<String, Object> pageobjs)
            throws IllegalArgumentException, IllegalAccessException {
        for (Field f : fields) {
            f.setAccessible(true);
            f.set(pageobj, pageobjs.get(f.getType().getSimpleName()));
            f.setAccessible(false);
        }
    }

    /**
     * @Title: fillFieldNameSet
     * @Description: 填充字段集合
     * @param fields
     * @param fieldSet
     * @return void
     */
    private void fillFieldNameSet(Field[] fields, HashSet<String> fieldSet) {
        for (Field f : fields) {
            if (f.getAnnotation(AutoInject.class) != null) {
                fieldSet.add(f.getType().getSimpleName());
            }
        }
    }

    /**
     * @Title: getClassName
     * @Description: 获得类名
     * @param folderPath
     * @param className
     * @param packageName
     * @return
     * @throws Exception
     * @return ArrayList<String>
     */
    private ArrayList<String> getClassName(String folderPath, ArrayList<String> className, String packageName)
            throws Exception {
        File files = new File(folderPath);
        for (File f : files.listFiles()) {
            if (f.isFile() && f.getName().endsWith(".java")) {
                className.add(packageName + "." + f.getName().substring(0, f.getName().indexOf(".")));
            }
        }
        return null;
    }
}