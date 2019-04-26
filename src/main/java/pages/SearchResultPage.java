package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	WebDriver driver = null;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public int getDepartureFlightsCount() {

		return driver.findElements(By.xpath("//div[@id='ow_domrt-jrny']//div[@class='fli-list splitVw-listing']"))
				.size();
	}

	public int getReturnFlightsCount() {
		return driver.findElements(By.xpath("//div[@id='rt-domrt-jrny']//div[@class='fli-list splitVw-listing']"))
				.size();
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

	public void selectFlightRadioButton(int sequence) {

	}

	public int selectDepartureFlightAndGetPrice(int departureFlightIndex) {
		driver.findElements(By.xpath("//div[@id='ow_domrt-jrny']//div[@class='fli-list splitVw-listing']"))
				.get(departureFlightIndex - 1).click();
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
		driver.findElements(By.xpath("//div[@id='rt-domrt-jrny']//div[@class='fli-list splitVw-listing']"))
				.get(returnFlightIndex - 1).click();
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
		if (driver.findElements(By.className("slashed-price")).size() > 0)
			s = driver.findElement(By.className("slashed-price")).getText();
		else
			s = driver.findElement(By.cssSelector("span.splitVw-total-fare")).getText();

		int amt = Integer.parseInt(s.replace(",", "").split("[ ]")[1]);
		return amt;
	}

}
