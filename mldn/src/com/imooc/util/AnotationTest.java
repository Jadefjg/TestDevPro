package com.imooc.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnotationTest {

	/*
	 * @Test:将一个普通方法修饰成为一个测试方法
	 *     @Test(expected=XX.class)
	 *     @Test(timeout=毫秒)
	 * @BeforeClass:它会在所有哦的方法运行前被执行，static修饰
	 * @AfterClass:它会在所有的方法运行结束后被执行，static修饰
	 * @Before:会在每一个测试方法被运行前执行一次
	 * @After:会在每一个测试方法运行后被执行一次
	 * @Ignore:所修饰的测试方法会被测试运行器忽略
	 * @RunWith:可以更改测试运行器  orgjunit.runner.Runner
	 * 断言 机制
	 */
	
	@Test(expected=ArithmeticException.class)
	public void testDivide() {
		assertEquals(3,new Calculate().divide(6, 0));
	}
	
	
	@Test(timeout=2000)
	public void testWhile(){
		while(true){
			System.out.println("run forever...");
		}
	}
	
	@Test(timeout=3000)
	public void testReadFile(){
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
