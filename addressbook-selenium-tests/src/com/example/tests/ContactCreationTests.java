package com.example.tests;

// 05_11_2015: to save state as it should be at HW#7

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
  
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
	    List<Object[]> list = new ArrayList<Object[]>();
	      for (int i = 0; i < 5; i++) {
			UserData contact = new UserData();
			contact = app.getContactHelper().getPseudoRandomContact();
			list.add(new Object[]{ contact });
		  }
		return list.iterator();
	}
	
	
    @Test(dataProvider = "randomValidContactGenerator")
    public void testValidUserCreation(UserData contact) throws Exception {
       app.getNavigationHelper().openMainPage ();
       app.getNavigationHelper().gotoHomePage ();
       
       // save old state
       List<UserData> oldList = app.getContactHelper().getContacts();
       
       // actions
       app.getContactHelper().initNewUserCreation();
       
       app.getContactHelper().fillUserForm(contact);
       app.getContactHelper().submitUserCreation();
       app.getNavigationHelper().gotoHomePage();
       
       // save new state
       List<UserData> newList = app.getContactHelper().getContacts();
       
       // compare states
       oldList.add(contact);
       Collections.sort(oldList);
       Collections.sort(newList);
       assertEquals(oldList, newList);
    }
}
