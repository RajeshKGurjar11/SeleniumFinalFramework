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


import com.training.pom.NewLaunch;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_007  {
	private WebDriver driver;
	private String baseUrl;
	private NewLaunch launch;
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
		launch = new NewLaunch(driver); 
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
		launch.Mouseover();
		launch.ClickNewLaunch();
		launch.sendUserName("Rajesh");
		launch.sendYouremail("gurjarrajesh@gmail.com");
		launch.sendYoursubject("Maths");
		launch.sendyourmessage("Hello I am in Class");
		launch.clickSubmitBtn(); 
		String ActualResults=launch.getwarningmessage();
		//String ExpectedResults = "Thank you for your message. It has been sent";
		String ExpectedResults = "There was an error trying to send your message. Please try again later.";
		Assert.assertEquals(ActualResults, ExpectedResults);
		//screenShot.captureScreenShot("First");
	}
}
