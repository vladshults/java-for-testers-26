package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
// import com.example.tests.TestBase;

public class GroupHelper extends WebDriverHelperBase {
	
	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void createGroup(GroupData group) {
		initNewGroupCreation();
		fillGroupForm(group);
		submitGroupCreation();
	}
	
	public void modificationGroup(int index, GroupData group) {
		initGroupModification(index);
	    fillGroupForm(group);
	    submitGroupModification();
	}
	
	public GroupHelper initNewGroupCreation() {
		click(By.name("new"));
		// cachedGroups = null;
		return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.getName());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		cachedGroups = null;
		return this;
	}

	public GroupHelper returnToGroupsPage() {
		click(By.linkText("group page"));
		return this;
	}

	public GroupHelper deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));
		cachedGroups = null;
		return this;
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
		}

	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		cachedGroups = null;
		return this;
	}

	private List<GroupData> cachedGroups = new ArrayList<GroupData>();
	
	public List<GroupData> getGroups() {
		if (cachedGroups == null || cachedGroups.size() < 2) {
			rebuildCache();
		}
		return cachedGroups;
	}

	public void rebuildCache() {
		manager.navigateTo().mainPage();
	    manager.navigateTo().groupsPage();
		cachedGroups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@name='selected[]']"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length() - ")".length());
			cachedGroups.add(new GroupData().withName(name));
		}
	}

	
}
