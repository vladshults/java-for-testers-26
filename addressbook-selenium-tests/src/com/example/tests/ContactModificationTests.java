package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModification();
		UserData user = new UserData();
		user.firstname = "ModificatedUserName";
	    user.lastname = "ModificatedIvanov";
	    // user.firstaddr = "125040\n5/2-228 Leningradsky av., Moscow,\nRussia";
	    // user.mobilephone = "011-7-9161214670";
	    // user.homephone = "011-7-4992576491";
	    // user.jobphone = "8-495-644-31-30";
	    user.firstmail = "modificated@rambler.ru";
	    // user.secondmail = "groupv@rambler.ru";
	    user.selectbdate = "2";
	    user.selectbmonth = "January";
	    user.byear = "1964";
	    // user.selectgroup = "Rob";
	    // user.secondaddr = "101000\n35, Myasnitskaya,\nMoscow,\nRussia";
	    // user.secondphone = "????";
	    app.getContactHelper().fillUserForm(user);
		app.getContactHelper().submitUserModification();
		app.getNavigationHelper().gotoHomePage();
	}
}
