/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.framework.utility
 * @author Ren Qiang
 * @date:Mar 13, 2018
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.framework.utility;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;

import ai.qa.autotest.ui.custom.annotation.DataObject;
import ai.qa.autotest.ui.testbase.TestBase;

/**
 * @ClassName: InitDataObject
 * @Description: 数据集对象
 * @author: Ren Qiang
 * @date: Mar 13, 2018
 */
public class InitDataObject {
    // 反射字段
    protected static Field[] fields = null;
    // 数据节点名
    private String dataNodeFieldName;
    // page对象
    private Object pageobj;

    /**
     * @Title:InitDataObject
     * @Description: 定义类的构造方法
     * @param obj
     * @throws SecurityException
     * @throws ClassNotFoundException
     */
    public InitDataObject(Object obj) throws SecurityException, ClassNotFoundException {
        pageobj = obj;
        getCurClassFields();
        initPageObjMap();
    }

    /**
     * @Title: initPageObjMap
     * @Description: 主调方法
     * @return
     * @return HashMap<String,Object>
     */
    private HashMap<String, Object> initPageObjMap() {
        HashMap<String, Object> pageobjs = new HashMap<String, Object>();
        HashSet<String> fieldSet = new HashSet<String>();

        try {
            fillFieldNameSet(fields, fieldSet);
            if (getDataObjectAnnValues(fields) != null) {
                pageobjs.put(dataNodeFieldName, ParseDataXml.getDataNode(getDataObjectAnnValues(fields)));
            }
            injectDataObj(fields, pageobjs);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageobjs;
    }

    /**
     * @Title: injectDataObj
     * @Description: 注入方法
     * @param fields
     * @param pageobjs
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @return void
     */
    private void injectDataObj(Field[] fields, HashMap<String, Object> pageobjs)
            throws IllegalArgumentException, IllegalAccessException {
        for (Field f : fields) {
            if (f.getAnnotation(DataObject.class) != null) {
                f.setAccessible(true);
                f.set(pageobj, pageobjs.get(dataNodeFieldName));
                f.setAccessible(false);
            }
        }
    }

    /**
     * @Title: fillFieldNameSet
     * @Description: 填充Field
     * @param fields
     * @param fieldSet
     * @return void
     */
    private void fillFieldNameSet(Field[] fields, HashSet<String> fieldSet) {
        for (Field f : fields) {
            if (f.getAnnotation(DataObject.class) != null) {
                dataNodeFieldName = f.getType().getSimpleName();
                fieldSet.add(f.getType().getSimpleName());
            }
        }
    }

    /**
     * @Title: getDataObjectAnnValues
     * @Description: 获得测试类中声明的域的名字作为MAP的KEY
     * @param fields
     * @return
     * @return String
     */
    public String getDataObjectAnnValues(Field[] fields) {
        for (Field f : fields) {
            if (f.getAnnotation(DataObject.class) != null) {
                DataObject ao = f.getAnnotation(DataObject.class);
                return ao.DataNode();
            }
        }
        return null;
    }

    /**
     * @Title: getCurClassFields
     * @Description: 获得当前声明的类名和字段
     * @throws SecurityException
     * @throws ClassNotFoundException
     * @return void
     */
    private void getCurClassFields() throws SecurityException, ClassNotFoundException {
        String curClassName = TestBase.getTestCaseDeclaringClass();
        fields = Class.forName(curClassName).getDeclaredFields();
    }
}
