package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.DateUtils;

public class HomePage {
	@FindBy(xpath = "//a[@href='//www.makemytrip.com/flights/']")
	private WebElement flightLink;

	@FindBy(xpath = "//li[.='Round Trip']")
	private WebElement roundTrip;

	@FindBy(id = "fromCity")
	private WebElement fromCity;

	@FindBy(xpath = "//input[@placeholder='From']")
	private WebElement fromInputBox;

	@FindBy(xpath = "//input[@placeholder='To']")
	private WebElement toTextBox;

	@FindBy(id = "toCity")
	private WebElement toCity;

	@FindBy(xpath = "//a[contains(@class,'primaryBtn font24 latoBlack widgetSearchBtn')]")
	private WebElement searchBtn;
	
	@FindBy(className="react-autosuggest__suggestions-list")
	private List<WebElement> autosuggestionList;

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
		fromInputBox.sendKeys(from);
		CommonUtils.waitForSeconds(3);
		fromInputBox.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
	}

	public void selectTo(String to) {
		toTextBox.sendKeys(to);
		CommonUtils.waitForSeconds(4);
		toTextBox.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
	}

	public void selectDeparture() {
		driver.findElement(By.xpath("//div[contains(@aria-label,'" + DateUtils.getTodayDate() + "')]")).click();
	}

	public void selectReturnDate() {
		driver.findElement(By.xpath("//div[contains(@aria-label,'" + DateUtils.getDateAfter7Days() + "')]")).click();
	}

	public void clickOnSearchBtn() {
		searchBtn.click();
	}
}
