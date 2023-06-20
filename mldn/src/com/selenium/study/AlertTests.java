package com.selenium.study;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AlertTests {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		// Alert弹框处理:只有确定的弹框
		driver.get("https://www.w3school.com.cn/tiy/t.asp?f=js_alert");
		driver.switchTo().frame("iframeResult");	// 切换至 iframe ，再根据iframe的 id 定位
		driver.findElement(By.tagName("button")).clear(); //  根据 button 定位
		Alert alert = driver.switchTo().alert();
		alert.accept();		// 切换后定确定
		
		// Alert弹框处理:有确定和取消的弹框
		driver.get("https://www.w3school.com.cn/tiy/t.asp?f=js_confirm");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.tagName("button")).clear();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();	// 切换后定确定
		driver.findElement(By.tagName("button")).click();
		alert1.dismiss();	// 切换后点取消
		
		// Alert弹框处理t:有输入框的弹框
		driver.get("https://www.w3school.com.cn/tiy/t.asp?f=js_prompt");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.tagName("button")).click();
		Alert alert2 = driver.switchTo().alert();
		alert2.sendKeys("哈哈哈");	// 输入信息
		alert2.accept();
		
		
		// Alert弹框处理:有提醒语的弹框
		driver.get("https://www.w3school.com.cn/tiy/t.asp?f=js_alert_2");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.tagName("button")).click();
		Alert alert3 = driver.switchTo().alert();
		System.out.println(alert3.getText());
		
		// 单选框处理
		driver.get("https://www.w3school.com.cn/tiy/t.asp?f=html_input_radio");
		// 复选框处理
		driver.get("https://www.w3school.com.cn/tiy/t.asp?f=html_input_checkbox");
		// 下拉框处理
		driver.get("https://www.w3school.com.cn/tiy/t.asp?f=html_select");
		driver.get("https://www.w3school.com.cn/tiy/t.asp?f=html_select_multiple");
		// 下拉框处理
		driver.get("https://www.jqueryui.org.cn/demo/5621.html");

	}

}



