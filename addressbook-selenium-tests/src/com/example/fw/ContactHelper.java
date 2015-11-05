package com.example.fw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//import com.example.tests.GroupData;
import com.example.tests.UserData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initNewUserCreation() {
		click(By.linkText("add new"));
	}

	public void fillUserForm(UserData user) {
		type(By.name("firstname"), user.firstname);
		type(By.name("lastname"), user.lastname);
	    type(By.name("address"), user.firstaddr);
	    type(By.name("mobile"), user.mobilephone);
	    type(By.name("home"), user.homephone);
	    type(By.name("work"), user.jobphone);
	    type(By.name("email"), user.firstmail);
	    type(By.name("email2"), user.secondmail);
	    selectByText(By.name("bday"), user.selectbdate);
	    selectByText(By.name("bmonth"), user.selectbmonth);
	    type(By.name("byear"), user.byear);
	    selectByText(By.name("new_group"), user.selectgroup);
	    type(By.name("address2"), user.secondaddr);
	    type(By.name("phone2"), user.secondphone);
	}

	public void submitUserCreation() {
		click(By.name("submit"));
	}

	//private void selectContactByFirstElement() {
	//	click(By.xpath("//input[@name='selected[]']"));
	//}

	public void submitUserModification() {
		click(By.name("update"));
	}

	public void submitContactDeletion() {
		click(By.xpath("//form[2]/input[2]"));
	}
	
	public void rebuildCache() {
		//
	}
	
	public List<UserData> getContacts() {
		List<UserData> contacts = new ArrayList<UserData>();
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@name='selected[]']"));
		for (WebElement checkbox : checkboxes) {
			UserData user = new UserData();
			String title = checkbox.getAttribute("title");
			// user.firstname = title.substring("Select (".length(), title.length() - ")".length());
			String str = title.substring("Select (".length(), title.length() - ")".length());
			String[] splitted = str.split("\\s+");
			if (splitted.length > 1) {
				user.lastname = splitted[1];
			} else {
				user.lastname = "";
			}
			contacts.add(user);
		}
		return contacts;
	}

	public void deleteContact(int index) {
		selectContactByIndex(index);
		submitContactDeletion();
	}

	public void selectContactByIndex(int index) {
		List<WebElement> rows = driver.findElements(By.name("entry"));
		List<WebElement> cells = rows.get(index).findElements(By.tagName("td"));
		cells.get(6).findElement(By.tagName("a")).click();
	}

	public UserData getPseudoRandomContact() {
		
		UserData randomContact = new UserData();
		randomContact.firstname = getPseudoRandomFirstname();
		randomContact.lastname = getPseudoRandomLastname();
		randomContact.firstaddr = getPseudoRandomAddr();
		randomContact.mobilephone = getPseudoRandomPhone();
		randomContact.homephone = getPseudoRandomPhone();
		randomContact.jobphone = getPseudoRandomPhone();
		randomContact.firstmail = getPseudoRandomMail();
		randomContact.secondmail = getPseudoRandomMail();
		randomContact.selectbdate = getPseudoRandomSelectBdate();
		randomContact.selectbmonth = getPseudoRandomSelectBmonth();
		randomContact.byear = getPseudoRandomByear();
		randomContact.selectgroup = "[none]";
		randomContact.secondaddr = getPseudoRandomAddr();
		randomContact.secondphone = getPseudoRandomPhone();
		
		return randomContact;
	}

	private String getPseudoRandomPhone() {
		String strArray[] = {"", "", "", "+1 650 961 2044", "111111111", "999-999-999-999", "+7-495-444-77-77", "011-7-499-257-66-91", 
							 "123456789", "987654321", "8-495-667-4682", "8-916-1214580", "+7-903-2123698", "011_7_926_1234562", "7-903-2123698"};
		String str = getStringFromArrayByRandomIndex(strArray);
		return str;
	}

	private String getPseudoRandomByear() {
		String strArray[] = {"", "", "", "", "1964", "2016", "1900", "1920", "2000", "1999", "1972", "1973", "1950", "1947", "2001", "-"};
		String str = getStringFromArrayByRandomIndex(strArray);
		return str;
	}

	private String getPseudoRandomSelectBmonth() {
		String strArray[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", 
				             "October", "November", "December", "-"};
		String str = getStringFromArrayByRandomIndex(strArray);
		return str;
	}

	private String getPseudoRandomSelectBdate() {
		String strArray[] = {"-", "1", "11", "22", "31", "7", "8", "16", "19", 
	                         "30", "20", "21", "3"};
		String str = getStringFromArrayByRandomIndex(strArray);
		return str;
	}

	private String getPseudoRandomMail() {
		String strArray[] = {"", "", "", "", "pupsik@yahoo.com", "mamba@rambler.ru", "tester@mail.ru", "QA@gmail.com", "admin@lexpr.ru", 
                             "pseudo@1.us", "vakh@222.com.uk", "1@rambler.ru", "@"};
		String str = getStringFromArrayByRandomIndex(strArray);
		return str;
	}

	private String getPseudoRandomAddr() {
		String strArray[] = {"", "", "", "", "", "125040 ������ ������������� �������� 5/2-228", "156000, ��������, ��. �������� ����, 2", 
				             "4970 El Camino Real #110 Los Altos CA 94022 USA", "na_derevnyu_dedushke", "pseudoaddress", 
				             "125040 5/2-228 Leningradsky av. Moscow Russia", "1", "@"};
		String str = getStringFromArrayByRandomIndex(strArray);
		return str;

	}

	private String getPseudoRandomLastname() {
		String strArray[] = {"", "", "", "", "Ivanko", "Ivanovsky", "Ivanidze", "Ivanter", "������", 
				             "Ivansker", "Ivashov", "_Iv_", "Iv", "I", "-Ivann-"};
		String str = getStringFromArrayByRandomIndex(strArray);
		return str;
	}

	private String getPseudoRandomFirstname() {
		String strArray[] = {"", "", "", "", "Ivan", "Ivani", "Ivanna", "Ivashka", "����", "����", "Iva", "_Iv_", "Iv", "I", "-Ivanna-"};
		String str = getStringFromArrayByRandomIndex(strArray);
		return str;
	}
	
	public String getStringFromArrayByRandomIndex(String[] strArray) {
		Random rnd = new Random();
		int index = rnd.nextInt(strArray.length - 1);
		String str = strArray[index];
		return str;
	}

	
}
