package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.MortgageCalculate;
import com.training.pom.SelectProperty;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_009 {
	
	private WebDriver driver;
	private String baseUrl;
	private SelectProperty Property;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		Property = new SelectProperty(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test
	public void validLaunch() {
		Property.Mouseover();
		Property.SelectCityLocation();
		Property.EnterAddress("Electronic City");
		Property.PropertyType("Plots");
		Property.AnyRegions("Central Bangalore");
		Property.SearchBtn(); 
		
		screenShot.captureScreenShot("First");
	}

}
