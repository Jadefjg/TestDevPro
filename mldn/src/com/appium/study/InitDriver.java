package com.appium.study;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public class InitDriver {
	
	public static AndroidDriver<AndroidElement> initDriver(String udid,String appPackage,String appActivity){
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability(MobileCapabilityType.DEVICE_NAME,"XXX");
		caps.setCapability(MobileCapabilityType.UDID,udid);
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,600);
		caps.setCapability(AndroidMobileCapability.UNICODE_KEYBOARD,true);
		caps.setCapability(AndroidMobileCapability.RESET_COMMAND_TIMEOUT,true);
		caps.setCapability(MobileCapabilityType.NO_RESET,true);
		caps.setCapability(AndroidMobileCapability.No_SIGN,true);
		caps.setCapability(AndroidMobileCapability.APP_PACKAGE,appPackage);
		caps.setCapability(AndroidMobileCapability.APP_ACTIVITY,appActivity);
		caps.setCapability(AndroidMobileCapability.AUTO_GRANT_PERMISSIONS,true);
		caps.setCapability(AndroidMobileCapability.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub",caps));
		driver.manage().timeouts().implicitylyWait(20,TimeUnit.SECONDS);
		return driver;
	}
	
	// 向上滑动
	public void swipeToUp(AndroidDriver<AndroidElement> driver){
		int x = driver.manage().window().getSize().getWidth();
		int y = driver.manage().window().getSize().getHeight();
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(x/2,8*y/10)).moveTo(PointOption.point(x/2,8*y/10);
	}
	
	//  九宫格解锁
	public static void getUnlock(AndroidDriver<AndroidElement> driver,By by){
		int start_x = lockview.getLocation.getX();	//起始点X
		int start_y = lockview.getLocation.getY();	//起始点Y

		int w = lockview.getSize().getWidth();
		int h = lockview.getSize().getHeight();
		
		List<PointOption> corList = new ArrayList<PointOption>();
		
		for(int i=0;i<3;i++){	// 行
			for(int j=0;j<3;j++){	// 列
				int x_center = start_x + ((2*j+1)*w)/6;
				int y_center = start_y + ((2*j+1)*h)/6;
				corList.add(PointOption.point(x_center,y_center));
			}
		}

		TouchAction<TouchAction<T>> action = new TouchAction(driver);
		action.press(pressOptions.point(x/2,))
	}

}
