package com.selenium.study;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioTests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		// 单选框处理
		driver.get("https://www.w3school.com.cn/tiy/t.asp?f=html_input_radio");
		driver.switchTo().frame("iframeResult");
		
		List<WebElement> radios = driver.findElements(By.name("sex"));
		for(WebElement w:radios) {
			if(!w.isSelected()) {
				w.click();
			}else {
				System.out.println(w.getText());
			}
		}
		
		// 复选框处理
		driver.get("https://www.w3school.com.cn/tiy/t.asp?f=html_input_checkbox");
		List<WebElement> checkBoxes = driver.findElements(By.name("vehicle"));
//		for(WebElement w:checkBoxes) {
//			if(!w.isSelected()) {
//				w.click();
//			}else {
//				System.out.println(w.getText());
//			}
//		}
		
		checkBoxes.get(0).click();    // 更具索引来选择第 N 项
		System.out.println(driver.findElement(By.tagName("form")).getText();
		
		// 下拉框处理
		driver.get("https://www.w3school.com.cn/tiy/t.asp?f=html_select");
		driver.get("https://www.w3school.com.cn/tiy/t.asp?f=html_select_multiple");
		
		// 下拉框处理
		driver.get("https://www.jqueryui.org.cn/demo/5621.html");

	}

}
