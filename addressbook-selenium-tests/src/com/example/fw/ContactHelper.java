package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//import com.example.tests.GroupData;
import com.example.tests.UserData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initNewUserCreation() {
		click(By.linkText("add new"));
	}

	public void fillUserForm(UserData user) {
		type(By.name("firstname"), user.firstname);
		type(By.name("lastname"), user.lastname);
	    type(By.name("address"), user.firstaddr);
	    type(By.name("mobile"), user.mobilephone);
	    type(By.name("home"), user.homephone);
	    type(By.name("work"), user.jobphone);
	    type(By.name("email"), user.firstmail);
	    type(By.name("email2"), user.secondmail);
	    selectByText(By.name("bday"), user.selectbdate);
	    selectByText(By.name("bmonth"), user.selectbmonth);
	    type(By.name("byear"), user.byear);
	    selectByText(By.name("new_group"), user.selectgroup);
	    type(By.name("address2"), user.secondaddr);
	    type(By.name("phone2"), user.secondphone);
	}

	public void submitUserCreation() {
		click(By.name("submit"));
	}

	//private void selectContactByFirstElement() {
	//	click(By.xpath("//input[@name='selected[]']"));
	//}

	public void submitUserModification() {
		click(By.name("update"));
	}

	public void submitContactDeletion() {
		click(By.xpath("//form[2]/input[2]"));
	}
	
	public List<UserData> getContacts() {
		List<UserData> contacts = new ArrayList<UserData>();
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@name='selected[]']"));
		for (WebElement checkbox : checkboxes) {
			UserData user = new UserData();
			String title = checkbox.getAttribute("title");
			// user.firstname = title.substring("Select (".length(), title.length() - ")".length());
			String str = title.substring("Select (".length(), title.length() - ")".length());
			String[] splitted = str.split("\\s+");
			if (splitted.length > 1) {
				user.lastname = splitted[1];
			} else {
				user.lastname = "";
			}
			contacts.add(user);
		}
		return contacts;
	}

	public void deleteContact(int index) {
		selectContactByIndex(index);
		submitContactDeletion();
	}

	public void selectContactByIndex(int index) {
		List<WebElement> rows = driver.findElements(By.name("entry"));
		List<WebElement> cells = rows.get(index).findElements(By.tagName("td"));
		cells.get(6).findElement(By.tagName("a")).click();
	}
}
