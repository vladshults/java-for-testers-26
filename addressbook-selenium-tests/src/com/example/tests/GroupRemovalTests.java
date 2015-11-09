package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {

	@Test
	public void deleteSomeGroup() {
		app.getGroupHelper().rebuildCache();
		
		// save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
		
		app.getGroupHelper().deleteGroup(index);
		//app.navigateTo().groupsPage();
		
		// save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    // compare states
	    oldList.remove(index);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertThat(oldList, equalTo(newList));
	  }
	
}
