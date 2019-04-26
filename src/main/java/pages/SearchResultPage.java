package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	WebDriver driver = null;

	@FindBy(xpath = "//div[@id='ow_domrt-jrny']//div[@class='fli-list splitVw-listing']")
	private List<WebElement> departureFlights;

	@FindBy(xpath = "//div[@id='rt-domrt-jrny']//div[@class='fli-list splitVw-listing']")
	private List<WebElement> returnFlights;

	@FindBy(css = "span.splitVw-total-fare")
	private WebElement totalPrice;

	@FindBy(className = "slashed-price")
	private List<WebElement> slashedPrice;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public int getDepartureFlightsCount() {

		return departureFlights.size();
	}

	public int getReturnFlightsCount() {
		return returnFlights.size();
	}

	public void selectStopsFilter(String filter) {
		WebElement ele = driver.findElement(By.xpath("//span[text()='" + filter + "']"));
		if (!ele.isSelected())
			ele.click();
	}

	public void deselectStopsFilter(String filter) {
		WebElement ele = driver.findElement(By.xpath("//span[text()='" + filter + "']"));
		if (ele.isSelected())
			ele.click();
	}

	public int selectDepartureFlightAndGetPrice(int departureFlightIndex) {
		departureFlights.get(departureFlightIndex - 1).click();
		String s = driver.findElement(By.xpath("(//div[@id='ow_domrt-jrny']//div[@class='fli-list splitVw-listing'])["
				+ departureFlightIndex + "]//p[@class='actual-price']")).getText();
		int amt = Integer.parseInt(s.replace(",", "").split("[ ]")[1]);
		return amt;
	}

	public int getDepartureFlightPriceAtBottom(int departureFlightIndex) {
		String s = driver
				.findElement(By.xpath("(//div[@class='splitVw-footer  slideUp']//p[@class='actual-price'])[1]"))
				.getText();
		int amt = Integer.parseInt(s.replace(",", "").split("[ ]")[1]);
		return amt;
	}

	public int selectReturnFlightAndGetPrice(int returnFlightIndex) {
		returnFlights.get(returnFlightIndex - 1).click();
		String s = driver.findElement(By.xpath("(//div[@id='rt-domrt-jrny']//div[@class='fli-list splitVw-listing'])["
				+ returnFlightIndex + "]//p[@class='actual-price']")).getText();
		int amt = Integer.parseInt(s.replace(",", "").split("[ ]")[1]);
		return amt;
	}

	public int getReturnFlightPriceAtBottom(int returnFlightIndex) {
		String s = driver
				.findElement(By.xpath("(//div[@class='splitVw-footer  slideUp']//p[@class='actual-price'])[2]"))
				.getText();
		int amt = Integer.parseInt(s.replace(",", "").split("[ ]")[1]);
		return amt;
	}

	public int getTotalFightPriceAtBottom() {
		String s = null;
		if (slashedPrice.size() > 0)
			s = slashedPrice.get(0).getText();
		else
			s = totalPrice.getText();

		int amt = Integer.parseInt(s.replace(",", "").split("[ ]")[1]);
		return amt;
	}

}
