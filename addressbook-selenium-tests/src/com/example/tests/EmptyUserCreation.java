package com.example.tests;

import org.testng.annotations.Test;

public class EmptyUserCreation extends TestBase {
  
  @Test
  public void testEmptyUserCreation() throws Exception {
    openMainPage ();
    initNewUserCreation();
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
    
    fillUserForm(user);
    submitUserCreation();
    gotoHomePage();
  }
}
