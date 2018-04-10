package ai.qa.autotest.ui.AI_UI_AutoTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

public class MavenTestNGDemo {
	WebDriver driver;
  @Test
  public void f() {
	  String WORKSPACE_DIR_PATH = System.getProperty("user.dir");
	  String Chrome_DRIVER_SERVER = WORKSPACE_DIR_PATH + "\\browserDriver\\chromedriver.exe";
		// Chrome Driver
		System.setProperty("webdriver.chrome.driver", Chrome_DRIVER_SERVER);				
		ChromeOptions options = new ChromeOptions();
		// set agruments not to display"data;"
		options.addArguments("--user-data-dir=C:/Users/Administrator/AppData/Local/Google/Chrome/UserData/Default");
	   driver = new ChromeDriver();

	   driver.get("http://www.baidu.com");

	   WebElement element = driver.findElement(By.id("kw"));

	   element.sendKeys("hello Selenium!");

	   element.submit();
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Page title is: " + driver.getTitle());

	   driver.quit();
  }

}
