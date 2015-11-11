package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {
	
	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please specify parameters: <amount of test data> <file> <format>");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = new String(args[2]);
		
		if (file.exists()) {
			System.out.println("File exists, please remove it manually: " + file);
			return;
		}
		
		List<UserData> contacts = generateRandomContacts(amount);
		
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format " + format);
			return;
		}
	}

	private static void saveContactsToXmlFile(List<UserData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", UserData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}

	private static void saveContactsToCsvFile(List<UserData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (UserData contact : contacts) {
			writer.write(getPseudoRandomFirstname() + ";" +
						 contact.getLastName() + ";" +
						 contact.getFirstAddr() + ";" +
						 contact.getMobilePhone() + ";" +
						 contact.getHomePhone() + ";" +
						 contact.getJobPhone() + ";" +
						 contact.getFirstMail() + ";" +
						 contact.getSecondMail() + ";" +
						 contact.getBDate() + ";" +
						 contact.getBMonth() + ";" +
						 contact.getBYear() + ";" +
						 contact.getGroup() + ";" +
						 contact.getSecondAddr() + ";" +
						 contact.getSecondPhone() +  ";!" + "\n");
		}
		writer.close();
	}

	public static List<UserData> loadContactsFromCsvFile (File file) throws IOException {
		List<UserData> list = new ArrayList<UserData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(";");
			UserData contact = new UserData()
					.withFirstName(part[0])
					.withLastName(part[1])
					.withFirstAddr(part[2])
					.withMobilePhone(part[3])
					.withHomePhone(part[4])
					.withJobPhone(part[5])
					.withFirstMail(part[6])
					.withSecondMail(part[7])
					.withBdate(part[8])
					.withBmonth(part[9])
					.withByear(part[10])
					.withGroup(part[11])
					.withSecondAddr(part[12])
					.withSecondPhone(part[13])
			;
			//System.out.println(line);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}

	public static List<UserData> loadContactsFromXmlFile(File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", UserData.class);
		return (List<UserData>) xstream.fromXML(file);
	}
	
	
	public static List<UserData> generateRandomContacts(int amount) {
		List<UserData> list = new ArrayList<UserData>();
	      for (int i = 0; i < amount; i++) {
			UserData contact =  new UserData()
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
			list.add(contact);
			}
	    return list;
	}

	/*
	private static String generateRandomString() {
		Random rnd = new Random();
		  if (rnd.nextInt(3) == 0) {
			  return "";
		  } else {
			  return "test" + rnd.nextInt();
		  }	
	}
*/

	private static String getPseudoRandomGroupName() {
		String str = new String("[none]");
		return str;
	}
	
	private static String getPseudoRandomPhone() {
		String strArray[] = {"", "", "", "+1 650 961 2044", "111111111", "999-999-999-999", "+7-495-444-77-77", "011-7-499-257-66-91", 
							 "123456789", "987654321", "8-495-667-4682", "8-916-1214580", "+7-903-2123698", "011_7_926_1234562", "7-903-2123698"};
		String str = getStringFromArrayByRandomIndex(strArray);
		return str;
	}

	private static String getPseudoRandomByear() {
		String strArray[] = {"", "", "", "", "1964", "2016", "1900", "1920", "2000", "1999", "1972", "1973", "1950", "1947", "2001", "-"};
		String str = getStringFromArrayByRandomIndex(strArray);
		return str;
	}

	private static String getPseudoRandomSelectBmonth() {
		String strArray[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", 
				             "October", "November", "December", "-"};
		String str = getStringFromArrayByRandomIndex(strArray);
		return str;
	}

	private static String getPseudoRandomSelectBdate() {
		String strArray[] = {"-", "1", "11", "22", "31", "7", "8", "16", "19", 
	                         "30", "20", "21", "3"};
		String str = getStringFromArrayByRandomIndex(strArray);
		return str;
	}

	private static String getPseudoRandomMail() {
		String strArray[] = {"", "", "", "", "pupsik@yahoo.com", "mamba@rambler.ru", "tester@mail.ru", "QA@gmail.com", "admin@lexpr.ru", 
                             "pseudo@1.us", "vakh@222.com.uk", "1@rambler.ru", "@"};
		String str = getStringFromArrayByRandomIndex(strArray);
		return str;
	}

	private static String getPseudoRandomAddr() {
		String strArray[] = {"", "", "", "", "", "125040 Moscow, Leningradsky av. 5/2-228", "156000, Kostroma, Molochnaya gora str., b. 2", 
	             "4970 El Camino Real #110 Los Altos CA 94022 USA", "na_derevnyu_dedushke", "pseudoaddress", 
	             "125040 5/2-228 Leningradsky av. Moscow Russia", "1", "@"};
		String str = getStringFromArrayByRandomIndex(strArray);
		return str;

	}

	private static String getPseudoRandomLastname() {
		String strArray[] = {"", "", "", "", "Ivanko", "Ivanovsky", "Ivanidze", "Ivanter", "Ivanov", 
	             "Ivansker", "Ivashov", "_Iv_", "Iv", "I", "-Ivann-"};
		String str = getStringFromArrayByRandomIndex(strArray);
		return str;
	}

	private static String getPseudoRandomFirstname() {
		String strArray[] = {"", "", "", "", "Ivan", "Ivani", "Ivanna", "Ivashka", "Vanya", "Rodger", "Iva", "_Iv_", "Iv", "I", "-Ivanna-"};
		String str = getStringFromArrayByRandomIndex(strArray);
		return str;
	}
	
	public static String getStringFromArrayByRandomIndex(String[] strArray) {
		Random rnd = new Random();
		int index = rnd.nextInt(strArray.length - 1);
		String str = strArray[index];
		return str;
	}
}      

