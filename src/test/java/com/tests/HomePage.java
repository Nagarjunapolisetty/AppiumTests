package com.tests;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.testBase.TestBase;

public class HomePage extends TestBase{
	
	public HomePage() throws IOException {
		super();
	}

	@Test
	public void tc() throws InterruptedException{	
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Selling button']")).click();
		Thread.sleep(2000);
	}
}
