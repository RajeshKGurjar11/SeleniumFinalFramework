package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLaunch {
	private WebDriver driver; 
	
	public NewLaunch(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'New Launch')]")
	private WebElement Mouseover; 
	
	@FindBy(xpath="//div[@class='wpmm-post post-4505']//a[@title='prestige']")
	private WebElement NewLaunch; 
	
	@FindBy(xpath="//input[@name='your-name']")
	private WebElement userName; 
	
	@FindBy(xpath="//input[@name='your-email']")
	private WebElement youremail;
	
	@FindBy(xpath="//input[@name='your-subject']")
	private WebElement yoursubject;
	
	@FindBy(xpath="//textarea[@name='your-message']")
	private WebElement yourmessage; 
	
	@FindBy(xpath="//input[@class='wpcf7-form-control wpcf7-submit']")
	private WebElement SubmitBtn; 
	
	@FindBy(xpath="//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	private WebElement WarningMessage;
	
	
	public void Mouseover() {
		Actions act = new Actions(driver);
        act.moveToElement(Mouseover).build().perform();
        
	}
	
	public void ClickNewLaunch() {
		
        this.NewLaunch.click();
	}
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendYouremail(String youremail) {
		this.youremail.clear(); 
		this.youremail.sendKeys(youremail); 
	}
	
	public void sendYoursubject(String yoursubject) {
		this.yoursubject.clear(); 
		this.yoursubject.sendKeys(yoursubject); 
	}
	
	public void sendyourmessage(String yourmessage) {
		this.yourmessage.clear(); 
		this.yourmessage.sendKeys(yourmessage); 
	}
	
	public void clickSubmitBtn() {
		this.SubmitBtn.click(); 
		
	}
	public String getwarningmessage() {
		return this.WarningMessage.getText();
		
	}
	}

