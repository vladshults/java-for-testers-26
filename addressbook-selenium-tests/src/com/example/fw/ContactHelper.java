package com.example.fw;

import org.openqa.selenium.By;
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

	public void gotoHomePage() {
		click(By.linkText("home"));
	}

}
