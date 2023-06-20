package com.appium.study;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import dev.failsafe.internal.util.Assert;

public class ZhihuTests {
	
	AndroidDriver<AndroidElement> driver;
	
	@BeforeClass
	public void initDriver() throws Exception {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		
//		caps.setCapability(MobileCapabilityType.DEVICE_NAME,"XXX");
//		caps.setCapability(MobileCapabilityType.UDID,"127.0.01:60021");
//		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,600);
//		caps.setCapability(AndroidMobileCapability.UNICODE_KEYBOARD,true);
//		caps.setCapability(AndroidMobileCapability.RESET_COMMAND_TIMEOUT,true);
//		caps.setCapability(MobileCapabilityType.NO_RESET,true);
//		caps.setCapability(AndroidMobileCapability.No_SIGN,true);
//		caps.setCapability(AndroidMobileCapability.APP_PACKAGE,"com.zhihu.android");
//		caps.setCapability(AndroidMobileCapability.APP_ACTIVITY,"com.zhihu.android.app.ui.activity");
//		caps.setCapability(AndroidMobileCapability.AUTO_GRANT_PERMISSIONS,true);
//		caps.setCapability(AndroidMobileCapability.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
//		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub",caps));
//		driver.manage().timeouts().implicitylyWait(20,TimeUnit.SECONDS);
		InitDriver("127.0.0.1:62001","com.zhihu.android","com.zhihu.app.ui.activity.LauncherActivity")
	}
	
	@Test
	public void login() throws Exception {
		try{
			driver.findElement(MobileBy.AndroidUIAutomator("text(\"未登录\")")).click();
			driver.findElement(By.id("login_other")).click();
			driver.findElement(By.id("email_input_view")).sendkeys("yangyangzhuangye@163.com");
			driver.findElement(By.id("password")).sendKeys("abc12345");
			driver.findElement(By.id("btn_progress")).click();
			Thread.sleep(6000);
			Assert.assertEqual(driver.getPageSource().contains("沙漠"),true);
		} catch (Exception | Error e){
			File file = ((TakeScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file,new File("image/zhihuloginfailure.pmg"));
			Reporter.log("<a href=../images/zhihuloginfailure.png target=_blank>失败截图</a>");
			Reporter.log("<img src=../images/zhihuloginfailure.png style=width:30px;heght:30px,target=_blank>");
			Assert.fail(e.getMessage());
		}
		
	}
	
	@Test
	public void comment() throws Exception{
		try{
			driver.findElement(By.id("com.zhihu.android:id/title")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("text(\"写回答\")")).click();
			driver.findElement(By.className("android.widget.EditText")).sendkeys("我也不知道");
			Thread.sleep(5000);
			driver.findElement(MobileBy.AccessibilityId("发布")).click();
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.unitl(ExcepedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text,"发布成功")]")));
			Assert.assertTrue(true);
		} catch (Exception | Error e){
			File file = ((TakeScreenshot)driver).getScreenshotAs();
			FileUtils.copyFile(file,new File("image/commentfailure.pmg"));
			Reporter.log("<a href=../images/commentfailure.png target=_blank>失败截图</a>");");
			Reporter.log("<img src=../images/commentfailure.png style=width,target=_blank>");
			Assert.fail(e.getMessage());
		}
		
	}
	
	
	@Test
	public void logout throws Exception{
		try{
			//  (//android.support.v7.app.a.c)[8]   我的
			//  //*[@text='设置']   设置
			//  *[@resource-id='com.zhihu.android:id/func_text']   退出
			// *[@text='确定']
			
			driver.findElement(By.xpath(//android.support.v7.app.a.c)[8])).click();
			driver.findElement(By.xpath("//*[@text='设置']")).click();
//			(new TouchAction(driver)).press({x:"299",y:1161}).moveTo({x:"309",y:203})
//			.release()
//			.perform()
			
			TouchAction action = new TouchAction(driver);
			
			for(int i=0,i<10,i++){
				Thread.sleep(10);
				action.point(PointOption<T>>.point(500,1200)).moveTo(PointOption<PointOption<T>>.point(500,300)).release().perform();
				try{
					driver.findElement(By.xpath("//*[@resource-id='com.zhihu.android:id/func_text'] "));
				} catch (Exception e){
					driver.findElement(By.xpath("//*[@text='确定']")).click();
					Thread.sleep(5000);
					Assert.assertEquals(driver.getPageSource().contains("沙漠"),true);
				}
			}
			
		} catch (Exception | Error e){
			File file = ((TakeScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file,new File("image/zhihulogoutfailure.pmg"));
			Reporter.log("<a href=../images/zhihulogoutfailure.png target=_blank>失败截图</a>");
			Reporter.log("<img src=../images/zhihulogoutfailure.png style=width:30px;heght:30px,target=_blank>");
			Assert.fail(e.getMessage());
		}
	}
	
	
	@AfterClass
	public void quit(){
		driver.quit();
	}
}
