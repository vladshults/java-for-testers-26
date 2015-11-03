package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class EmptyGroupCreationTests extends TestBase {
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    app.navigateTo().mainPage();
    app.navigateTo().groupsPage();
    
    // save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    // actions
    app.getGroupHelper().initNewGroupCreation();
    GroupData group = new GroupData();
    group.name = "";
    group.header = "";
    group.footer = "";
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.navigateTo().groupsPage();
    
    // save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    // compare states
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(oldList, newList);
    }
}
