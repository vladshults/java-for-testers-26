package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoHomePage();
		
		// save old state
	    List<UserData> oldList = app.getContactHelper().getContacts();
		
	    // actions
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
	    
		app.getContactHelper().deleteContact(index);
		app.getNavigationHelper().gotoHomePage();
		
		// save new state
	    List<UserData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(oldList, newList);
	}
}
