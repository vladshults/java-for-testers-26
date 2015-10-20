package com.example.tests;

import org.testng.annotations.Test;

public class EmptyGroupCreationTests extends TestBase {
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    app.getGroupHelper().initNewGroupCreation();
    GroupData group = new GroupData();
    group.name = "";
    group.header = "";
    group.footer = "";
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().gotoGroupsPage();
  }
}
