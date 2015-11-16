package com.example.tests;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.AfterTest;
// import org.testng.annotations.BeforeClass;
// import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;


public class TestBase {

	protected static ApplicationManager app;
	

	@BeforeTest
	public void setUp() throws Exception {
		String configFile = System.getProperty("configFile", "application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager(properties);
		
	}

	@AfterTest
	public void tearDown() throws Exception {
	    app.stop();
		
	}

	@DataProvider
	public static Iterator<Object[]> randomValidGroupGenerator() {
	    return wrapGroupsForDataProvider(generateRandomGroups(5)).iterator();
	}

	public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[]{group});
		}
		return list;
	}
}
