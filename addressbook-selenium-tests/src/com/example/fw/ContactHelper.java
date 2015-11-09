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

	public void createContact(UserData contact) {
		 initNewUserCreation();
	     fillUserForm(contact);
	     submitUserCreation();
	}
	
	public void modifyContact(int index, UserData contact) {
		initUserModification(index);
	    fillUserForm(contact);
	    submitUserModification();
	}
	
	public ContactHelper initNewUserCreation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillUserForm(UserData user) {
		type(By.name("firstname"), user.getFirstName());
		type(By.name("lastname"), user.getLastName());
	    type(By.name("address"), user.getFirstAddr());
	    type(By.name("mobile"), user.getMobilePhone());
	    type(By.name("home"), user.getHomePhone());
	    type(By.name("work"), user.getJobPhone());
	    type(By.name("email"), user.getFirsMail());
	    type(By.name("email2"), user.getSecondMail());
	    selectByText(By.name("bday"), user.getBDate());
	    selectByText(By.name("bmonth"), user.getBMonth());
	    type(By.name("byear"), user.getBYear());
	    selectByText(By.name("new_group"), user.getGroup());
	    type(By.name("address2"), user.getSecondAddr());
	    type(By.name("phone2"), user.getSecondPhone());
	    return this;
	}

	public ContactHelper submitUserCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper initUserModification(int index) {
		selectContactByIndex(index);
		return this;
	}

	public ContactHelper submitUserModification() {
		click(By.name("update"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper submitContactDeletion() {
		click(By.xpath("//form[2]/input[2]"));
		cachedContacts = null;
		return this;
	}
	
	List<UserData> cachedContacts = new ArrayList<UserData>();
	
	public List<UserData> getContacts() {
		if (cachedContacts == null || cachedContacts.size() < 2) {
			rebuildContsCache();
		}
		return cachedContacts;
	}
	
	public void rebuildContsCache() {
		cachedContacts = new ArrayList<UserData>();
		manager.navigateTo().mainPage ();
	    manager.navigateTo().gotoHomePage ();
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
			cachedContacts.add(user);
		}
	}

	public ContactHelper deleteContact(int index) {
		selectContactByIndex(index);
		submitContactDeletion();
		cachedContacts = null;
		return this;
	}

	public ContactHelper selectContactByIndex(int index) {
		List<WebElement> rows = driver.findElements(By.name("entry"));
		List<WebElement> cells = rows.get(index).findElements(By.tagName("td"));
		cells.get(6).findElement(By.tagName("a")).click();
		return this;
	}

	public UserData getPseudoRandomContact() {
		
		UserData randomContact = new UserData()
		.withFirstName(getPseudoRandomFirstname())
		.withLastName(getPseudoRandomLastname())
		.withFirstAddr(getPseudoRandomAddr())
		.withMobilePhone(getPseudoRandomPhone())
		.withHomePhone(getPseudoRandomPhone())
		.withJobPhone(getPseudoRandomPhone())
		.withFirstMail(getPseudoRandomMail())
		.withSecondMail(getPseudoRandomMail())
		.withBdate(getPseudoRandomSelectBdate())
		.withBmonth(getPseudoRandomSelectBmonth())
		.withByear(getPseudoRandomByear())
		.withGroup(getPseudoRandomGroupName())
		.withSecondAddr(getPseudoRandomAddr())
		.withSecondPhone(getPseudoRandomPhone())
		;
		
		return randomContact;
	}

	private String getPseudoRandomGroupName() {
		String str = "[none]";
		return str;
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
		String strArray[] = {"", "", "", "", "", "125040 Москва Ленинградский проспект 5/2-228", "156000, Кострома, ул. Молочная Гора, 2", 
				             "4970 El Camino Real #110 Los Altos CA 94022 USA", "na_derevnyu_dedushke", "pseudoaddress", 
				             "125040 5/2-228 Leningradsky av. Moscow Russia", "1", "@"};
		String str = getStringFromArrayByRandomIndex(strArray);
		return str;
	}

	private String getPseudoRandomLastname() {
		String strArray[] = {"", "", "", "", "Ivanko", "Ivanovsky", "Ivanidze", "Ivanter", "Иванов", 
				             "Ivansker", "Ivashov", "_Iv_", "Iv", "I", "-Ivann-"};
		String str = getStringFromArrayByRandomIndex(strArray);
		return str;
	}

	private String getPseudoRandomFirstname() {
		String strArray[] = {"", "", "", "", "Ivan", "Ivani", "Ivanna", "Ivashka", "Иван", "Вано", "Iva", "_Iv_", "Iv", "I", "-Ivanna-"};
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
