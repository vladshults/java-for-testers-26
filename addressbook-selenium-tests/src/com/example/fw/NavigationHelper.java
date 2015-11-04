package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void mainPage() {
		driver.get(manager.baseUrl + "/addressbookv4.1.4/");
	}

	public void groupsPage() {
		click(By.linkText("groups"));
	}
	
	public void gotoHomePage() {
		click(By.linkText("home"));
	}
	
}