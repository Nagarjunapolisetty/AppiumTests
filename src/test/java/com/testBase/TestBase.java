package com.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestBase {
	public  AppiumDriver<MobileElement> driver;
	FileInputStream ip;
	Properties prop;
	
	public TestBase() throws IOException {
		try {
			prop = new Properties();
			ip = new FileInputStream(System.getProperty("user.dir") + "\\resources\\config.properties");
			prop.load(ip);
			System.out.println("ip:" + prop.getProperty("url"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public void setUp(){
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", prop.getProperty("deviceName"));
		cap.setCapability("udid", prop.getProperty("udid"));
		cap.setCapability("platformName", prop.getProperty("platformName"));
		cap.setCapability("platformVersion", prop.getProperty("platformVersion"));
		cap.setCapability("appPackage", prop.getProperty("appPackage"));
		cap.setCapability("appActivity", prop.getProperty("appActivity"));
		
		URL url = null;
		try {
			url = new URL("http://0.0.0.0:4723/wd/hub");
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver =new AppiumDriver<MobileElement>(url,cap);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
