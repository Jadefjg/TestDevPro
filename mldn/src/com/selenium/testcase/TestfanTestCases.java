package com.selenium.testcase;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.study.Set;
import com.selenium.study.TestfanTests;
import com.selenium.study.Utils;

public class TestfanTestCases {
	
	WebDriver driver;
	TestfanTests testfan;
	
	@BeforeClass
	public void initDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://ask/testfan.cn/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		testfan = new TestfanTests(driver);
	}
	
	@BeforeMethod
	public void homepage() {
		driver.get("http://ask/testfan.cn/");
	}
	
	@Test
	public void test001_login() throws Exception{
		try {
			testfan.login();
			Boolean flag = Utils.elementIsExist(driver, By.cssSelector("#unread_messages"));
			Assert.assertEquals(true,flag);
		}catch(Exception | Error e){
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file,new File("images/testfanloginfailure.png"));
			Assert.fail(e.getMessage());
		}
	}
	
	// 修改用户信息
	@Test(dependsOnMethods = "test001_login")
	public void changePersonInfo() throws Exception{
		try{
			testfan.changePersonInfo();
		} catch (Exception | Error e) {
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file,new File("images/testfanchangepeosonInfofailure.png"));
			Assert.fail(e.getMessage());
		}	
	}
	
	// 修改评论
	@Test(dependsOnMethods = "test001_login")
	public void comment() throws Exception {
		try{
			testfan.comment();
		} catch (Exception | Error e) {
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file,new File("images/testfancommentfailure.png"));
			Assert.fail(e.getMessage());
		}
	}
	
	@AfterClass
	public void quit() {
		driver.quit();
	}

}
