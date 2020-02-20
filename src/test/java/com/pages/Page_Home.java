package com.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Page_Home {
	AppiumDriver<MobileElement> driver;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='Selling button']")
    AndroidElement titleText;
	
	public Page_Home(AppiumDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
