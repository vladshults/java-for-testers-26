package com.example.tests;

import org.testng.annotations.Test;

public class NonEmptyUserCreation extends TestBase {
  
  @Test
  public void testNonEmptyUserCreation() throws Exception {
    openMainPage ();
    initNewUserCreation();
    UserData user = new UserData();
    // "Ivan", "Ivanov", "125040\n5/2-228 Leningradsky av., Moscow,\nRussia", "011-7-9161214670", 
    // "011-7-4992576491", "8-495-644-31-30", "pomidoroff2000@rambler.ru", "groupv@rambler.ru", "2", 
    // "January", "1964", "Rob", "101000\n35, Myasnitskaya,\nMoscow,\nRussia", "????"
    user.firstname = "Ivan";
    user.lastname = "Ivanov";
    user.firstaddr = "125040\n5/2-228 Leningradsky av., Moscow,\nRussia";
    user.mobilephone = "011-7-9161214670";
    user.homephone = "011-7-4992576491";
    user.jobphone = "8-495-644-31-30";
    user.firstmail = "pomidoroff2000@rambler.ru";
    user.secondmail = "groupv@rambler.ru";
    user.selectbdate = "2";
    user.selectbmonth = "January";
    user.byear = "1964";
    user.selectgroup = "Rob";
    user.secondaddr = "101000\n35, Myasnitskaya,\nMoscow,\nRussia";
    user.secondphone = "????";
    fillUserForm(user);
    submitUserCreation();
    gotoHomePage();
  }
}
