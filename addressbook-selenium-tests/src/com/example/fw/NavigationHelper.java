package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends WebDriverHelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void mainPage() {
		driver.get(manager.baseUrl);
	}

	public void groupsPage() {
		click(By.linkText("groups"));
	}
	
	public void gotoHomePage() {
		click(By.linkText("home"));
	}
	
}
