package com.selenium.study;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaiduTest {
	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.baidu.com");
		Thread.sleep(2000);
		driver.findElement(By.id("kw")).sendKeys("Selenium官网");
		Thread.sleep(2000);
		driver.findElement(By.id("su")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
