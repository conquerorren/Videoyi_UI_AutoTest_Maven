/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.framework.constants
 * @author:Ren Qiang
 * @date:2017/07/14
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.framework.constants;

/**
 * Command constants.This class defines all types of the command.
 * 
 * @author Ren Qiang
 * 
 * @date 2017/07/14
 */
public class CommonConstants {
    /**
     * TEST Base URL Path.
     */
    // public static final String TEST_BASE_URL = "http://218.241.154.233:8088";

    /**
     * Current workspace path.
     */
    public static final String WORKSPACE_DIR_PATH = System.getProperty("user.dir");

    /**
     * IE Driver Server FIELD.
     */
    public static final String IE_DRIVER_FIELD = "webdriver.ie.driver";

    /**
     * Chrome Driver Server FIELD.
     */
    public static final String CHROME_DRIVER_FIELD = "webdriver.chrome.driver";

    /**
     * Firefox Driver Server FIELD.
     */
    public static final String FIREFOX_DRIVER_FIELD = "webdriver.firefox.bin";

    /**
     * IE Driver Server Path.
     */
    public static final String IE_DRIVER_SERVER = WORKSPACE_DIR_PATH + "\\browserDriver\\IEDriverServer.exe";

    /**
     * Chrome Driver Server Path.
     */
    public static final String CHROME_DRIVER_SERVER = WORKSPACE_DIR_PATH + "\\browserDriver\\chromedriver.exe";

    /**
     * Firefox Driver Server Path.
     */
    public static final String FIREFOX_DRIVER_SERVER = WORKSPACE_DIR_PATH + "\\browserDriver\\firefox43\\firefox.exe";

    /**
     * Upload Image File Exe Path.
     */
    public static final String UPLOAD_FILE_EXE_PATH = CommonConstants.WORKSPACE_DIR_PATH
            + "\\browserDriver\\uploadFile.exe";

    /**
     * Upload Image File Exe Path For Firefox.
     */
    public static final String UPLOAD_FILE_EXE_PATH_FIREFOX = CommonConstants.WORKSPACE_DIR_PATH
            + "\\browserDriver\\uploadFile_FireFox.exe";

    /**
     * Thread Sleep Time.
     */
    public static final int THREAD_SLEEP_SHORT_TIME = 1000;

    /**
     * Thread Sleep Time.
     */
    public static final int THREAD_SLEEP_LONG_TIME = 3000;

    /**
     * Thread Sleep Time.
     */
    public static final int THREAD_SLEEP_DOWNLOAD_TIME = 10000;

    /**
     * Screen shot Flag on/off.
     */
    public static final boolean SCREEN_SHORT_FLAG = false;

    /**
     * Screen recorder Flag on/off.
     */
    public static final boolean SCREEN_RECORDER_FLAG = false;

    /**
     * File Screen Shot Path.
     */
    public static final String SCREENSHOT_PATH = WORKSPACE_DIR_PATH + "\\test-output\\screen-shot\\";

    /**
     * Alert Accept.
     */
    public static final int ALERT_ACCEPT = 1;

    /**
     * Alert Dismiss.
     */
    public static final int ALERT_DISMISS = 2;

    /**
     * Config Folder path key.
     */
    public static final String CONFIG_FOLDER_PATH_KEY = "config.property";

    /**
     * Config Folder path key.
     */
    public static final String CONFIG_FOLDER_PATH_VALUE = WORKSPACE_DIR_PATH + "\\config\\";

    /**
     * Config Folder suffix key.
     */
    public static final String CONFIG_FILE_SUFFIX = ".properties";

    /**
     * XML Folder suffix key.
     */
    public static final String XML_FILE_SUFFIX = ".xml";
}
