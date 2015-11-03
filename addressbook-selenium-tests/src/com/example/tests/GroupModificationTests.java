package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	
	@Test
	public void modifySomeGroup() {
		app.navigateTo().mainPage();
		app.navigateTo().groupsPage();
		
		// save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
		
	    // actions
		app.getGroupHelper().initGroupModification(0);
		GroupData group = new GroupData();
		group.name = "modificated name";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.navigateTo().groupsPage();
		
		// save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    // compare states
	    oldList.remove(0);
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(oldList, newList);
	}
}
