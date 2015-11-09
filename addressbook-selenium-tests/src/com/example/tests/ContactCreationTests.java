package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

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
	      for (int i = 0; i < 4; i++) {
			UserData contact = new UserData();
			contact = app.getContactHelper().getPseudoRandomContact();
			list.add(new Object[]{ contact });
		  }
		return list.iterator();
	}
	
	
    @Test(dataProvider = "randomValidContactGenerator")
    public void testValidUserCreation(UserData contact) throws Exception {
              
       //app.getContactHelper().rebuildContsCache();
       
       // save old state
       List<UserData> oldList = app.getContactHelper().getContacts();
       
       // actions
       app.getContactHelper().createContact(contact);
             
       // save new state
       List<UserData> newList = app.getContactHelper().getContacts();
       
       // compare states
    // compare states
       oldList.add(contact);
       Collections.sort(oldList);
       Collections.sort(newList);
       assertThat(oldList, equalTo(newList));
     }
}
