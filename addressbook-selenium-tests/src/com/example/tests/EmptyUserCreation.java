package com.example.tests;

import org.testng.annotations.Test;

public class EmptyUserCreation extends TestBase {
  
  @Test
  public void testEmptyUserCreation() throws Exception {
    app.getNavigationHelper().openMainPage ();
    app.getContactHelper().initNewUserCreation();
    UserData user = new UserData();
   
    user.firstname = "SomeEmptyUser";
    user.lastname = "";
    user.firstaddr = "";
    user.mobilephone = "";
    user.homephone = "";
    user.jobphone = "";
    user.firstmail = "";
    user.secondmail = "";
    user.selectbdate = "1";
    user.selectbmonth = "January";
    user.byear = "";
    user.selectgroup = "Rob";
    user.secondaddr = "";
    user.secondphone = "";
    
    app.getContactHelper().fillUserForm(user);
    app.getContactHelper().submitUserCreation();
    app.getNavigationHelper().gotoHomePage();
  }
}
