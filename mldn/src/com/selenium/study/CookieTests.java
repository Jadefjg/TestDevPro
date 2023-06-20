package com.selenium.study;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieTests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();  // 浏览器的最大化
		
		// cookie 处理
		/*cookie绕过登录
			http://www.yang-baba.net
			1. 先手动登录
			2. 使用chrome开发者工具获取cookie信息
			3. 将获取的cookie信息使用脚本添加
			4. 访问登录后页面，登录成功
		  */
		
		driver.get("http://www.yang-baba.net/");
		Cookie cookie1 = new Cookie("","");
		Cookie cookie2 = new Cookie("","");

		driver.manage().addCookie(cookie1);
		driver.manage().addCookie(cookie2);
		
		driver.get("http://www.yang-baba.net/people/xxx");

	}

}
