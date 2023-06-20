package com.selenium.study;


import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;


public class TestfanTests{
	WebDriver driver;
	public TestfanTests(WebDrvier driver) {
		this.driver = driver;
	}
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://ask/testfan.cn/");
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  // 隐式等待，后面查找元素都遵循该机制
	}
	
	// 第三方登录 frame：id、name、iframe索引、元素对象
	public void login(){
		driver.findElement(By.linkText("登录")).click();
		driver.findElement(By.cssSelector(".btn.btn-default.btn-sm.btn-sn-qq"));
		driver.switchTo().frame(0);	// 多个frame时候，使用索引切换frame
		
		// 先定位 iframe 元素
//		WebElement iframe163 = driver.findElements(By.cssSelector("iframe[frameborder=]")).click();
//		driver.switchTo().frame(iframe163);  // 切换至 163
//		
//		driver.switchTo().defaultContent();	// 回到初始的 frame
		
		driver.findElement(By.cssSelector("#img_out_2879897713")).click();
		if(Utils.elementIsExist(driver, By.cssSelector("#unread_message"))){
			System.out.println("登录成功");
		}else{
			System.out.println("登录失败");
		}
	}
	
	// 修改用户信息
	public void changePersonInfo(){
		driver.findElement(By.cssSelector(".dropdown.user-avatar")).clear();
		driver.findElement(By.linkText("哈哈哈")).clear();
		driver.findElement(By.cssSelector("input[name='name']")).clear();
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("大神");
		
		// 选性别
		List<WebElement> genders = driver.findElement(By.cssSelector("input[name='gender]"));
		for(WebElement w:genders){
			if(!w.isSelected()){
				w.click();
				break;
			}
		}
		
		// 使用 js 开取消输入框点击绑定事件，然后输入相关日期数据
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("$('#birthday').unbind();");
		
		// 
//		driver.findElement(By.cssSelector("#birthday")).sendKeys("1993-10-23");
		WebElement birthday = driver.findElement(By.cssSelector("#birthday"));
		birthday.clear();
		birthday.sendKeys("1993-10-23");
		
		// 选省份
		Select province = new Select(driver.findElement(By.cssSelector("#province")));
		province.selectByVisibleText("山西");
		
		
		// 城市
		Select city = new Select(driver.findElement(By.cssSelector("#city")));
		city.selectByVisibleText("太原");
		
		// 提交
		driver.findElement(By.cssSelector(".btn.btn-xl.btn-primary.profile-sub")).click();
		
		Select province1 = new Select(driver.findElement(By.cssSelector("#province")));
		System.out.println(province1.getFirstSelectedOption().getText());
	}
	
	
	// 修改评论
	public void comment(){
		String currentHandle = driver.getWindowHandle();	// 获取当前 handle
		driver.findElement(By.linkText("如何 appium 设置设备的网络状态")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		
		for(String s:windowHandles){
			if(!s.equals(currentHandle)){
				driver.switchTo().window(s);
				break;
			}
		}
		driver.findElement(By.cssSelector("#comment-article-content-3")).sendkeys("这篇文章已经过时");
		driver.findElement(By.cssSelector("#article-comment-3-btn")).click();
		
		// 验证֤
		List<WebElement> comments = driver.findElements(By.cssSelector(".content>p"));
		String text = comments.get(comments.size()-1).getText();
		if("这篇文章已经过时".equals(text)){
			System.out.println("评论成功");
		}else{
			System.out.println("评论失败");
		}
	}
	
	
	public static void main(String[] args){
		TestfanTests testfan = new TestfanTests();
		testfan.login();
		testfan.changePersonInfo();
		testfan.comment();
	}
	
}
