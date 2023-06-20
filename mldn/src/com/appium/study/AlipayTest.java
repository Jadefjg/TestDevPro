package com.appium.study;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class AlipayTest {
	
	AndroidDriver<AndroidElement> driver;
	
	@BeforeClass
	public void initDriver() throws Excepton{
		// com.eg.andorid.AlipayGphone/com.eg.android.AlipayGphone.AlipayLogin
		driver = InitDriver.initDriver('JFFYGIY5EYZDQOTO',"com.eg.andorid.AlipayGphone","com.eg.android.AlipayGphone.AlipayLogin")
	}

	@Test
	public void unlock(){
//		setting - 开发者 - 开启指针位置，获取坐标
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(240,822))
		.moveTo(PointOption.point(544,822))
		.moveTo(PointOption.point(544,1122))
		.moveTo(PointOption.point(544,1422))
		.release().perform();
	}
	
	@AfterClass
	public void quit(){
		driver.quit();
	}
}
