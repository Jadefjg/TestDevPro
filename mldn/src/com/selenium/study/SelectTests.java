package com.selenium.study;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;


public class SelectTests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		// 下拉框处理
		driver.get("https://www.w3school.com.cn/tiy/t.asp?f=html_select");
		driver.switchTo().frame("iframeResult");
		WebElement selectEle = driver.findElement(By.tagName("Select"));
		Select select = new Select(selectEle);	// 转为 select 对象
		select.selectByVisibleText("Opel");
//		Thread.sleep(2000);
		select.selectByIndex(0);
//		Thread.sleep(2000);
		select.selectByValue("audio");
//		Thread.sleep(2000);
		
		driver.get("https://www.w3school.com.cn/tiy/t.asp?f=html_select_multiple");
		
		// 下拉框处理
		driver.get("https://www.jqueryui.org.cn/demo/5621.html");

	}

}
