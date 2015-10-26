package com.example.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {
  
  @DataProvider
  public Iterator<Object[]> randomValidGroupGenerator() {
    List<Object[]> list = new ArrayList<Object[]>();
      for (int i = 0; i < 5; i++) {
		GroupData group = new GroupData();
		group.name = generateRandomString();
		group.header = generateRandomString();
		group.footer = generateRandomString();
	  }
	return list.iterator();
  }
  
  public String generateRandomString() {
	  Random rnd = new Random();
	  if (rnd.nextInt(3) == 0) {
		  return "";
	  } else {
		  return "test" + rnd.nextInt();
	  }
  }

  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    
    // save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    // actions
    app.getGroupHelper().initNewGroupCreation();
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().gotoGroupsPage();
    
    // save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    // compare states
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(oldList, newList);
    
  }
}
