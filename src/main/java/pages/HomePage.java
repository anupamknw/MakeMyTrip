package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DateUtil;

public class HomePage {
	@FindBy(xpath = "//a[@href='//www.makemytrip.com/flights/']")
	private WebElement flightLink;

	@FindBy(xpath = "//li[.='Round Trip']")
	private WebElement roundTrip;

	@FindBy(id = "fromCity")
	private WebElement fromCity;

	@FindBy(id = "toCity")
	private WebElement toCity;

	@FindBy(id = "departure")
	WebElement departureDate;

	@FindBy(id = "return")
	WebElement returnDate;

	@FindBy(xpath = "//a[contains(@class,'primaryBtn font24 latoBlack widgetSearchBtn')]")
	WebElement searchBtn;

	WebDriver driver = null;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage clickOnFlightLink() {
		flightLink.click();
		return this;
	}

	public HomePage clickOnRoundTrip() {
		roundTrip.click();
		return this;
	}

	public void selectFrom(String from) {
		fromCity.click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(from);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
	}

	public void selectTo(String to) {
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(to);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
	}

	public void selectDeparture() {
        driver.findElement(By.xpath("//div[contains(@aria-label,'"+DateUtil.getTodayDate()+"')]")).click();
	}

	public void selectReturnDate() {
		driver.findElement(By.xpath("//div[contains(@aria-label,'"+DateUtil.getDateAfter7Days()+"')]")).click();
	}

	public SearchResultPage clickOnSearchBtn() {
		searchBtn.click();
		return new SearchResultPage(driver);
	}
}
