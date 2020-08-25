package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectProperty {
	
private WebDriver driver; 
	
	public SelectProperty(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Plots ')]")
	private WebElement Mouseover; 
	
	@FindBy(xpath="//a[contains(text(),'Central Bangalore')]")
	private WebElement SelectCityLocation; 
	
	@FindBy(xpath="//span[text()='Plots']")
	private WebElement LaunchPlots; 
	
	@FindBy(id="keyword_search")
	private WebElement EnterAddress; 
	
	@FindBy(xpath="//span[text()='Property type']")
	private WebElement PropertyType;
	
	@FindBy(xpath="//span[text()='Any Regions']")
	private WebElement AnyRegions;
	
	
	@FindBy(xpath="//button[@class='button fullwidth']")
	private WebElement SearchBtn; 
	
	
	
	public void Mouseover() {
		Actions act = new Actions(driver);
        act.moveToElement(Mouseover).build().perform();
        
	}
	
	public void SelectCityLocation() {
		
        this.SelectCityLocation.click();
        this.LaunchPlots.click();
	}
	
	public void EnterAddress(String EnterAddress) {
		this.EnterAddress.clear();
		this.EnterAddress.sendKeys(EnterAddress);
	}
	
	public void PropertyType(String PropertyType) {
		
		this.PropertyType.click();
		//WebElement Propertype1=driver.findElement(By.xpath("//span[text()='Property type']"));
		Actions act = new Actions(driver);
        //act.moveToElement(Propertype1).build().perform();
      //  act.moveToElement(Propertype1).click().perform();
        
        WebElement Propertype2=driver.findElement(By.xpath("//ul[@class='chosen-results']//li[text()='Plots']"));
        act.moveToElement(Propertype2).click().perform();
      
		
		//this.PropertyType.sendKeys(PropertyType); 
	}
	
	public void AnyRegions(String AnyRegions) {
		this.AnyRegions.click();
		
		Actions act = new Actions(driver);
		
		WebElement anyRegions1=driver.findElement(By.xpath("//ul[@class='chosen-results']//li[text()='Central Bangalore']"));
		
        act.moveToElement(anyRegions1).click().perform();
		//this.AnyRegions1.sendKeys(AnyRegions); 
	}
	
	
	
	public void SearchBtn() {
		this.SearchBtn.click(); 
		
	}
	

}
