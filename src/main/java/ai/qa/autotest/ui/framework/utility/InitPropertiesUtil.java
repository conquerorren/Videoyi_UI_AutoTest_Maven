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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import ai.qa.autotest.ui.framework.constants.CommonConstants;

/**
 * @ClassName: InitPropertiesUtil
 * @Description: 配置文件工具类
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
public class InitPropertiesUtil {
    /**
     * @Title:InitPropertiesUtil
     * @Description: 将config下的所有配置文件的内容加载到MAP中，方便快速获取配置文件的值
     */
    public InitPropertiesUtil() {
        PropertiesUtil.setKeyValueMap(initKeyValueMap(System.getProperty(CommonConstants.CONFIG_FOLDER_PATH_KEY)));
    }

    /**
     * @Title: initKeyValueMap
     * @Description: 将config下的所有配置文件的内容加载到MAP中，方便快速获取配置文件的值
     * @param floderPath
     * @return
     * @return HashMap<String,String>
     */
    public HashMap<String, String> initKeyValueMap(String floderPath) {
        HashMap<String, String> propertyKeyValus = new HashMap<String, String>();
        ArrayList<File> propertyFiles = getConfigFiles(new File(floderPath), CommonConstants.CONFIG_FILE_SUFFIX);
        try {
            for (File f : propertyFiles) {
                setKeyValueToMap(f, propertyKeyValus);
            }
            if (propertyKeyValus.isEmpty()) {
                throw new Exception("have no properties files or properties files have no key-value");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propertyKeyValus;
    }

    /**
     * @Title: setKeyValueToMap
     * @Description: 将所有properties文件的key,value存入到map中，实现properties值的跨文件读取和快速读取
     * @param f
     * @param propertyKeyValus
     * @throws Exception
     * @return void
     */
    private void setKeyValueToMap(File f, HashMap<String, String> propertyKeyValus) throws Exception {
        Enumeration<?> en = gePropertyObj(f.getAbsolutePath()).propertyNames();
        while (en.hasMoreElements()) {
            String key = (String) en.nextElement();
            String Property = gePropertyObj(f.getAbsolutePath()).getProperty(key);
            propertyKeyValus.put(key, Property);
        }
    }

    /**
     * @Title: getConfigFiles
     * @Description: 递归获取此文件夹下的所有配置文件
     * @param floderPath：文件夹在工程中的路径
     * @param files：存放文件的列表对象
     * @return
     * @return ArrayList<File>
     */
    public static ArrayList<File> getConfigFiles(File floderPath, ArrayList<File> files, String fileSuffix) {
        for (File f : floderPath.listFiles()) {
            // 获取路径不是.svn路径
            if (f.isDirectory() && f.getName().equals(".svn")) {
                continue;
            }
            if (f.isFile()) {
                if (f.getName().endsWith(fileSuffix)) {
                    files.add(f);
                    continue;
                }
            } else {
                getConfigFiles(f, files, fileSuffix);
            }
        }
        return files;
    }

    /**
     * @Title: getConfigFiles
     * @Description: 获取此文件夹下的所有配置文件
     * @param floderPath
     * @return
     * @return ArrayList<File>
     */
    public static ArrayList<File> getConfigFiles(File floderPath, String fileSuffix) {
        ArrayList<File> files = new ArrayList<File>();
        return getConfigFiles(floderPath, files, fileSuffix);
    }

    /**
     * @Title: gePropertyObj
     * @Description: 初始化properties文件的对象
     * @param FilePath
     * @return
     * @throws Exception
     * @return Properties
     */
    private Properties gePropertyObj(String FilePath) throws Exception {
        Properties p = new Properties();
        InputStream ins = null;
        try {
            ins = new BufferedInputStream(new FileInputStream(FilePath));
            p.load(ins);
            ins.close();
        } catch (Exception e) {
            throw new Exception("can not find the properties file : " + FilePath);
        }
        return p;
    }
}