package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	
	@Test
	public void modifySomeGroup() {
		//app.getGroupHelper().rebuildCache();
	    
	    // save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
		
	    // Get Random index
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
	    
	    // actions
	    GroupData group = new GroupData()
	    .withName("ModifName")
	    .withHeader("ModifHeader")
	    .withFooter("ModifFooter");
		
	    app.getGroupHelper().modificationGroup(index, group);
	    	    
	    // save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    // compare states
	    oldList.remove(index);
	    oldList.add(group);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertThat(oldList, equalTo(newList));
	  }
}
