package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContact() {
		
		//app.getContactHelper().rebuildContsCache();
	       
	    // save old state
	    List<UserData> oldList = app.getContactHelper().getContacts();
		
	    
	    // actions
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
	    
		UserData contact = new UserData()
		.withFirstName("ModificatedUserName")
		.withLastName("ModificatedIvanov")
		.withFirstMail("modificated@rambler.ru");
				
		 app.getContactHelper().modifyContact(index, contact);
	     		
		// save new state
	    List<UserData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    oldList.remove(index);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertThat(oldList, equalTo(newList));
	  }
}
