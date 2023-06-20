package com.selenium.study;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Utils {

	public static Boolean elementIsExist(WebDriver driver, By by) {
		// TODO Auto-generated method stub
		Boolean flag = false;
		try{
			driver.findElement(by);
			flag = true;
		}catch (Exception e) {
			
		}
		return flag;
	}

}
