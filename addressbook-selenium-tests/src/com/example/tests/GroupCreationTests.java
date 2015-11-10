package com.example.tests;

import java.io.File;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;


public class GroupCreationTests extends TestBase {
  
  @DataProvider
  public Iterator<Object[]> groupsFromFile() throws IOException {
    //List<Object[]> list = new ArrayList<Object[]>();
    return wrapGroupsForDataProvider(loadGroupsFromCsvFile(new File("groups.txt"))).iterator();
  }
  
  
  @Test(dataProvider = "groupsFromFile")
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
    assertThat(oldList, equalTo(newList));
  }
}
