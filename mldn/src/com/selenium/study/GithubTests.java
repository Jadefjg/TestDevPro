package com.selenium.study;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GithubTests {
	
	WebDriver driver;

	public void GithuTests() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://github.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	// 隐式等待，后面查找元素都遵循该机制
	}
	
	// Github 登录
	public void login() {
		driver.findElement(By.id("login_field")).sendKeys("test");
		driver.findElement(By.id("password")).sendKeys("ABC28789");
		driver.findElement(By.className("commit")).click();
		
		if(driver.getPageSource().contains("Learn Git and GitHub without any code")) {
			System.out.println("登录成功");
		}else {
			System.out.println("登录失败");
		}
	}
	
	// 创建库
	public void create() {
		driver.findElement(By.className("oction-plus")).click();
		driver.findElement(By.partialLinkText("New repository")).click();
		driver.findElement(By.id("repository_name")).sendKeys("testabc7");
		driver.findElement(By.className("btn btn-primary first-in-line")).click();
		String url = "https://github.com/shamotest/testabc7";
		String currentUrl = driver.getCurrentUrl();
		if(url.equals(currentUrl)) {
			System.out.println("创建成功");
		}else {
			System.out.println("创建失败");
		}
	}
	
	// 改变用户信息
	public void change() {
		driver.get("https://github.com/");
		driver.findElement(By.className("dashboard-underlined-link")).click();
		driver.findElement(By.partialLinkText("Settings")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,20);	// 显示等待
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("new_name")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("new_name")));
		
		driver.findElement(By.name("new_name")).clear();
		driver.findElement(By.name("new_name")).sendKeys("testabc6");
		WebElement error = driver.findElement(By.className("error"));
		Thread.sleep(5000);   // 线程等待
		String text = error.getText();
		if(text.equals("The repository testabc6 already exists on this account")) {
			System.out.println("重复验证提示正确");
		}else {
			System.out.println("重复验证提示失败");
		}
		driver.findElement(By.name("new_name")).sendKeys("testabc8");
		driver.findElement(By.name("flex-self-end")).click();
		String title = driver.getTitle();
		if(title.equals("shamotest/testabc8")) {
			System.out.println("修改正确");
		}
			System.out.println("修改失败");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GithubTests github = new GithubTests();
		github.login();
		github.create();
		github.change();

	}

}


