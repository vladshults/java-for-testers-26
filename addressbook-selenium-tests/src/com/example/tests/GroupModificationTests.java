package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	
	@Test
	public void modifySomeGroup() {
		app.getGroupHelper().rebuildCache();
	    
	    // save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
		
	    // Get Random index
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
	    
	    // actions
		app.getGroupHelper().initGroupModification(index);
		GroupData group = new GroupData();
		group.name = "modificated name";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.navigateTo().groupsPage();
		
		// save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    // compare states
	    oldList.remove(index);
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(oldList, newList);
	}
}
