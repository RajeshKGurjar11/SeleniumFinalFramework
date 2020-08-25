package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MortgageCalculate {

private WebDriver driver; 
	
	public MortgageCalculate(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'New Launch')]")
	private WebElement Mouseover; 
	
	@FindBy(xpath="//div[@class='wpmm-post post-4505']//a[@title='prestige']")
	private WebElement NewLaunch; 
	
	@FindBy(id="amount")
	private WebElement SalesPrice; 
	
	@FindBy(id="downpayment")
	private WebElement DownPayment;
	
	@FindBy(id="years")
	private WebElement LongTerm;
	
	@FindBy(id="interest")
	private WebElement InterestRate; 
	
	@FindBy(xpath="//button[@class='button calc-button']")
	private WebElement CalculateBtn; 
	
	@FindBy(xpath="//div[@class='notification success']")
	private WebElement WarningMessage;
	
	
	public void Mouseover() {
		Actions act = new Actions(driver);
        act.moveToElement(Mouseover).build().perform();
        
	}
	
	public void ClickNewLaunch() {
		
        this.NewLaunch.click();
	}
	
	public void SalesPriceInput(String SalesPrice) {
		this.SalesPrice.clear();
		this.SalesPrice.sendKeys(SalesPrice);
	}
	
	public void DownPaymentInput(String DownPayment) {
		this.DownPayment.clear(); 
		this.DownPayment.sendKeys(DownPayment); 
	}
	
	public void LongTermInput(String LongTerm) {
		this.LongTerm.clear(); 
		this.LongTerm.sendKeys(LongTerm); 
	}
	
	public void InterestRateInput(String InterestRate) {
		this.InterestRate.clear(); 
		this.InterestRate.sendKeys(InterestRate); 
	}
	
	public void clickSubmitBtn() {
		this.CalculateBtn.click(); 
		
	}
	public String getwarningmessage() {
		return this.WarningMessage.getText();
		
	}
	
	
}
