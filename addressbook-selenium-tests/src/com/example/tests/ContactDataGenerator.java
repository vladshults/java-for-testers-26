package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.fw.ApplicationManager;
import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {
	
	protected static ApplicationManager app;

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
		xstream.alias("contact", GroupData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}

	private static void saveContactsToCsvFile(List<UserData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (UserData contact : contacts) {
			writer.write(contact.getFirstName() + "," +
						 contact.getLastName() + "," +
						 contact.getFirstAddr() + "," +
						 contact.getMobilePhone() + "," +
						 contact.getHomePhone() + "," +
						 contact.getJobPhone() + "," +
						 contact.getFirstMail() + "," +
						 contact.getSecondMail() + "," +
						 contact.getBDate() + "," +
						 contact.getBMonth() + "," +
						 contact.getBYear() + "," +
						 contact.getGroup() + "," +
						 contact.getSecondAddr() + "," +
						 contact.getSecondPhone() +  ",!" + "\n");
		}
		writer.close();
	}

	public static List<GroupData> loadGroupsFromCsvFile (File file) throws IOException {
		List<GroupData> list = new ArrayList<GroupData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		// todo: add readlines here
		bufferedReader.close();
		return list;
	}

	public static List<UserData> generateRandomContacts(int amount) {
		List<UserData> list = new ArrayList<UserData>();
	      for (int i = 0; i < amount; i++) {
			UserData contact =  new UserData();
			app.getContactHelper().getPseudoRandomContact();
			list.add(contact);
			}
	    return list;
	}      
}
