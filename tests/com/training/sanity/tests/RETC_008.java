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

import com.training.pom.MortgageCalculate;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_008 {
	private WebDriver driver;
	private String baseUrl;
	private MortgageCalculate Morgage;
	private static Properties properties;
	//private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		Morgage = new MortgageCalculate(driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
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
		Morgage.Mouseover();
		Morgage.ClickNewLaunch();
		Morgage.SalesPriceInput("400000");
		Morgage.DownPaymentInput("60000");
		Morgage.LongTermInput("20");
		Morgage.InterestRateInput("7.25");
		Morgage.clickSubmitBtn(); 
		String ActualResults=Morgage.getwarningmessage();
		String ExpectedResults = "Monthly Payment: 2687.28 Rs.";
		//String ExpectedResults = "There was an error trying to send your message. Please try again later.";
		Assert.assertEquals(ActualResults, ExpectedResults);
		//screenShot.captureScreenShot("First");
	}
}
