package com.selenium.testcase;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GithubTestCases {
	
	WebDriver driver;
	
	@BeforeClass
	public void initDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://github.com/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void test001_login() throws Exception{
		try {
			driver.findElement(By.id("login_field")).sendKeys("test");
			driver.findElement(By.id("password")).sendKeys("ABC28789");
			driver.findElement(By.className("commit")).click();
			
			if(driver.getPageSource().contains("Learn Git and GitHub without any code")) {
				System.out.println("登录成功");
			}else {
				System.out.println("登录失败");
			}
		}catch{
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file,new File("images/testfanloginfailure.png"));
			Reporter.log("<a href=../images/testfanloginfailure.png target-_blank>失败</a>");
			Reporter.log("<img src=../images/testfanloginfailure.png style=witdth:30,>失败</a>");
		}
		
	}
	
	@Test(dependsOnMethods = "test001_login")
	public void test002_create() throws Exception{
		
		// 先获取现有的
		driver.get("https://github.com/shamotest?tab=repositories");
		List<WebElement> repositories = driver.findElements(By.cssSelector("a[itemp]"));
		List<String> respositories_name = new ArrayList<String>();
		for(WebElement w:repositories) {
			respositories_name.add(w.getText().trim());
		}
		
		driver.findElement(By.className("oction-plus")).click();
		driver.findElement(By.partialLinkText("New repository")).click();
		
		// 随机生成一个相应库名称
		String name = "";
		int i = 10;
		while(i>0) {
			int j=(int)(Math.random()*100);
			name = "testabc"+j;
			if(repositories_names.contains(name)) {
				i--;
			}else {
				break;
			}
		}
		
		driver.findElement(By.id("repository_name")).sendKeys("name");
		driver.findElement(By.className("btn btn-primary first-in-line")).click();
		String url = "https://github.com/shamotest/t"+name;
		Thread.sleep(3000);
		String currentUrl = driver.getCurrentUrl();
		if(url.equals(currentUrl)) {
			System.out.println("创建成功");
		}else {
			System.out.println("创建失败");
		}
	}
	
	@Test(dependsOnMethods = "test001_login")
	public void test003_change() {
		driver.get("https://github.com/");
		driver.findElement(By.className("dashboard-underlined-link")).click();
		driver.findElement(By.partialLinkText("Settings")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,20);	// 显示等待
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("new_name")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("new_name")));
		
		int k = (int)(Math.random()*repositories_names.size());
		
		driver.findElement(By.name("new_name")).clear();
		driver.findElement(By.name("new_name")).sendKeys(repositories_names.get(k));
		WebElement error = driver.findElement(By.className("error"));
		Thread.sleep(5000);   // 线程等待
		String text = error.getText();
		if(text.equals("The repository"+ repositories_names.get(k)+" already exists on this account")) {
			System.out.println("重复验证提示正确");
		}else {
			System.out.println("重复验证提示失败");
		}
		
		// 随机生成一个相应库名称
				String name = "";
				int i = 10;
				while(i>0) {
					int j=(int)(Math.random()*100);
					name = "testabc"+j;
					if(repositories_names.contains(name)) {
						i--;
					}else {
						break;
					}
				}
		
		driver.findElement(By.name("new_name")).sendKeys("testabc8");
		driver.findElement(By.name("flex-self-end")).click();
		String title = driver.getTitle();
		if(title.equals("shamotest/testabc8")) {
			System.out.println("修改正确");
		}
			System.out.println("修改失败");
	}
	Assert.assertEquals(title.equals("shamotest/"+name),true);
	
	@AfterClass
	public void quit() {
		driver.quit();
	}

}
