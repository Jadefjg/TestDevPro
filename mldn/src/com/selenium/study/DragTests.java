package com.selenium.study;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragTests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();  // 浏览器的最大化
		
		// driver.switchTo().frame("iframeResult");

		// 下拉框处理
		driver.get("https://www.jqueryui.org.cn/demo/5621.html");
		
//		String text = driver.findElement(By.className("ui-status-default")).getAttribute("text");
//		String text = driver.findElement(By.cssSelector(".ui-status-default")).getAttribute("text");
		
		
//		WebElement item1 = driver.findElement(By.cssSelector(".ui-status-default"));  // 元素对
//		Actions action = new Actions(driver);
//		action.dragAndDropBy(item1,0,50).perform();	// 出现鼠标越界错误
		
		driver.findElement(By.xpath("//h3[text()='源代码']")).click();
		List<WebElement> items = driver.findElements(By.cssSelector(".ui-state-deault"));
//		Thread.sleep(2000);
		Actions action = new Actions(driver);
//		action.dragAndDrop(items.get(0),items.get(1)).perform();
		for(int i=0;i<10;i++) {
//			Thread.sleep(1000);
			System.out.println(items.get(0).getText());
			action.dragAndDropBy(items.get(0), 0, 50).perform();
		}
	}
	
}
