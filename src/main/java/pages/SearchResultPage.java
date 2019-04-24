package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	WebDriver driver = null;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public int getDepartureFlightsCount()
	{

		return driver.findElements(By.xpath("//div[@id='ow_domrt-jrny']//div[@class='fli-list splitVw-listing']")).size();
	}
	
	public int getReturnFlightsCount()
	{
		return driver.findElements(By.xpath("//div[@id='rt-domrt-jrny']//div[@class='fli-list splitVw-listing']")).size();
	}
	
	public void selectStopsFilter(String filter)
	{
		driver.findElement(By.xpath("//span[text()='"+filter+"']")).click();
	}
	
	public void selectFlightRadioButton(int sequence)
	{
		
	}
	
	public void getDepartureFlightPrice()
	{
		
	}
	
	public void getReturnFlightPrice()
	{
		
	}
	
	
}
