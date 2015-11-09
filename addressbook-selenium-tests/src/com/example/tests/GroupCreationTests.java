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
      for (int i = 0; i < 2; i++) {
		GroupData group =  new GroupData()
		.withName(generateRandomString())
		.withHeader(generateRandomString())
		.withFooter(generateRandomString());
		list.add(new Object[]{ group });
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
    //
       
	//app.getGroupHelper().rebuildCache();
	  
    // save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
 
    // actions
    app.getGroupHelper().createGroup(group);
       
    // save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    // compare states
    oldList.add(group);
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals(oldList, newList);
    
  }
}
