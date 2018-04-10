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

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ai.qa.autotest.ui.framework.constants.CommonConstants;
import ai.qa.autotest.ui.framework.constants.PropertiesKeys;
import ai.qa.autotest.ui.testbase.TestBase;

/**
 * @ClassName: CommonUtil
 * @Description: TODO
 * @author: Ren Qiang
 * @date: Mar 7, 2018
 */
public class CommonUtil {
    private static ScreenRecorder screenRecorder;
    private static Logger logger = LogManager.getLogger(CommonUtil.class.getName());

    /**
     * @Title: isElementPresent
     * @Description: 判断元素是否存在
     * @param driver
     * @param by
     * @return
     * @return boolean
     */
    public static boolean isElementPresent(By by) {
        try {
            WebDriver driver = TestBase.getWebDriver();
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * @Title: isAlertPresent
     * @Description: Alert是否存在
     * @param driver
     * @return
     * @return boolean
     */
    @SuppressWarnings("unused")
    private boolean isAlertPresent() {
        try {
            WebDriver driver = TestBase.getWebDriver();
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    /**
     * @Title: closeAlertAndGetItsText
     * @Description: 关闭Alert框并获得文本信息
     * @param nAcceptFlag
     * @return void
     */
    public static void closeAlertAndGetItsText(int nAcceptFlag) {
        WebDriver driver = TestBase.getWebDriver();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        if (CommonConstants.ALERT_ACCEPT == nAcceptFlag) {
            alert.accept();
        } else if (CommonConstants.ALERT_DISMISS == nAcceptFlag) {
            alert.dismiss();
        }

        logger.info("----- Alert Text: " + alertText + "-----");
    }

    /**
     * @Title: TakeScreenShot
     * @Description: 截图功能
     * @param strFileName
     * @throws IOException
     * @return void
     */
    public static void TakeScreenShot(String strFileName) throws IOException {
        if (CommonConstants.SCREEN_SHORT_FLAG) {
            WebDriver driver = TestBase.getWebDriver();
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // get local system time
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String strTimeStampFileName = dateFormat.format(now) + "_" + strFileName;
            // Use timestamp file name
            String strFilePath = CommonConstants.SCREENSHOT_PATH + strTimeStampFileName + ".jpg";
            FileUtils.copyFile(screenshot, new File(strFilePath));
        }
    }

    /**
     * @Title: InitScreenRecorder
     * @Description: 初始化录屏
     * @throws IOException
     * @throws AWTException
     * @return void
     */
    public static void InitScreenRecorder() throws IOException, AWTException {
        if (CommonConstants.SCREEN_RECORDER_FLAG) {
            // video Save Path:C:users<<UserName>>Videos
            GraphicsConfiguration gconfig = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
                    .getDefaultConfiguration();
            org.monte.media.Format fileFormat = new org.monte.media.Format(MediaTypeKey, MediaType.FILE, MimeTypeKey,
                    MIME_AVI);
            org.monte.media.Format screenFormat = new org.monte.media.Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,
                    ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                    DepthKey, (int) 24, FrameRateKey, Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey,
                    (int) (15 * 60));
            org.monte.media.Format mouseFormat = new org.monte.media.Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,
                    "black", FrameRateKey, Rational.valueOf(30));
            screenRecorder = new ScreenRecorder(gconfig, fileFormat, screenFormat, mouseFormat, null);
        }
    }

    /**
     * @Title: startScreenRecorder
     * @Description: 开始录屏
     * @throws IOException
     * @return void
     */
    public static void startScreenRecorder() throws IOException {
        if (CommonConstants.SCREEN_RECORDER_FLAG) {
            // Start Capturing the Video
            screenRecorder.start();
        }
    }

    /**
     * @Title: stopScreenRecorder
     * @Description: 停止录屏
     * @throws IOException
     * @return void
     */
    public static void stopScreenRecorder() throws IOException {
        if (CommonConstants.SCREEN_RECORDER_FLAG) {
            // Stop the ScreenRecorder
            screenRecorder.stop();
        }
    }

    /**
     * @Title: uploadImageFile
     * @Description: 上传图片
     * @param strImageFile
     * @throws IOException
     * @return void
     */
    public static void uploadImageFile(String strImageFile) throws IOException {
        String strUploadExePath = CommonConstants.UPLOAD_FILE_EXE_PATH;
        if ("Firefox" == TestBase.getBrowserType()) {
            strUploadExePath = CommonConstants.UPLOAD_FILE_EXE_PATH_FIREFOX;
        }
        strUploadExePath = "cmd.exe /c start " + strUploadExePath.replaceAll(" ", "\" \"");

        String strDisplayImgPath = CommonConstants.WORKSPACE_DIR_PATH
                + PropertiesUtil.getPropertyValue(PropertiesKeys.TESTCASE_TESTRESOURCE_PATH) + strImageFile;
        strDisplayImgPath = strDisplayImgPath.replaceAll(" ", "\" \"");
        Runtime.getRuntime().exec(strUploadExePath + " " + strDisplayImgPath);
    }

    /**
     * @Title: uploadImageForFile
     * @Description: 从文件上传图片
     * @param driver
     * @param webElement
     * @param strImageFile
     * @throws IOException
     * @throws InterruptedException
     * @return void
     */
    public static void uploadImageForFile(WebElement webElement, String strImageFile)
            throws IOException, InterruptedException {
        webElement.click();
        Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
        uploadImageFile(strImageFile);
        Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
    }

    /**
     * @Title: uploadImageForPopup
     * @Description: 从弹出窗口中上传图片
     * @param driver
     * @param strElement
     * @param strImageFile
     * @throws IOException
     * @throws InterruptedException
     * @return void
     */
    public static void uploadImageForPopup(WebElement webElement, String strImageFile)
            throws IOException, InterruptedException {
        WebDriver driver = TestBase.getWebDriver();
        webElement.click();
        Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
        uploadImageFile(strImageFile);
        Thread.sleep(CommonConstants.THREAD_SLEEP_LONG_TIME);
        driver.findElement(By.id("confirm_crop")).click();
        Thread.sleep(CommonConstants.THREAD_SLEEP_SHORT_TIME);
    }

    /**
     * @Title: closeSubWindow
     * @Description: 关闭子窗口
     * @param driver
     * @return void
     */
    public static void closeSubWindow() {
        WebDriver driver = TestBase.getWebDriver();
        // Get all window handles
        Set<String> handles = driver.getWindowHandles();
        // Save main Window
        String mainWindowhandle = driver.getWindowHandle();
        // sub window hanlde
        String subWindowHandle = null;
        // Get sub window hanlde
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (mainWindowhandle.equals(key)) {
                continue;
            }
            subWindowHandle = key;
        }

        if (null == subWindowHandle) {
            return;
        }

        // Find subWindow and close
        WebDriver subWindow = driver.switchTo().window(subWindowHandle);
        subWindow.close();
        handles.remove(subWindowHandle);
        // switch to main window
        driver = driver.switchTo().window(mainWindowhandle);
    }

    /**
     * @Title: scrollToBottom
     * @Description: 将页面滚动到最底部
     * @return void
     */
    public static void scrollToDocumentBottom() {
        JavascriptExecutor jse = (JavascriptExecutor) TestBase.getWebDriver();
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
