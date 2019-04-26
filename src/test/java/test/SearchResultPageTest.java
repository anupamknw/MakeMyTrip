package test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.SearchResultPage;
import utils.CommonUtils;

public class SearchResultPageTest extends BaseClass {
	HomePage homepage = null;
	SearchResultPage searchResultPage = null;
	int depFlightPriceAtBottom = 0;
	int retFlightPriceAtBottom = 0;

	@BeforeClass
	public void setUp() {
		super.setUp(getBrowser());
		driver.get(getUrl());
		driver.manage().deleteAllCookies();
		homepage = new HomePage(driver);
		searchResultPage = new SearchResultPage(driver);
		homepage.clickOnFlightLink().clickOnRoundTrip();
		homepage.selectFrom(getFrom());
		homepage.selectTo(getTo());
		homepage.selectDeparture();
		homepage.selectReturnDate();
		homepage.clickOnSearchBtn();
		CommonUtils.deleteAllCookie(driver);
	}

	@Test
	public void printTotNoOfDepartureAndReturnFlight() {
		CommonUtils.scrollTillEnd(driver);

		System.out.println("total departure flights: " + searchResultPage.getDepartureFlightsCount());
		System.out.println("total return flights: " + searchResultPage.getReturnFlightsCount());

		CommonUtils.deleteAllCookie(driver);

		driver.navigate().refresh();

		searchResultPage.selectStopsFilter("Non Stop");

		CommonUtils.scrollTillEnd(driver);

		System.out.println(
				"total departure flights after selecting non-stop: " + searchResultPage.getDepartureFlightsCount());
		System.out
				.println("total return flights after selecting non-stop: " + searchResultPage.getReturnFlightsCount());

		CommonUtils.deleteAllCookie(driver);
		driver.navigate().refresh();

		searchResultPage.deselectStopsFilter("Non Stop");
		searchResultPage.selectStopsFilter("1 Stop");

		CommonUtils.scrollTillEnd(driver);

		System.out.println(
				"total departure flights after selecting 1 stop: " + searchResultPage.getDepartureFlightsCount());
		System.out.println("total return flights after selecting 1 stop: " + searchResultPage.getReturnFlightsCount());

		CommonUtils.deleteAllCookie(driver);

		driver.navigate().refresh();
	}

	@Test
	public void testThatDepartureFlightPriceAndReturnPriceReflectedSameAtBottom() {

		int departureFlightIndex = 3;
		int returnFlightIndex = 4;

		int depFlightPrice = searchResultPage.selectDepartureFlightAndGetPrice(departureFlightIndex);
		depFlightPriceAtBottom = searchResultPage.getDepartureFlightPriceAtBottom(departureFlightIndex);

		int retFlightPrice = searchResultPage.selectReturnFlightAndGetPrice(returnFlightIndex);
		retFlightPriceAtBottom = searchResultPage.getReturnFlightPriceAtBottom(returnFlightIndex);

		Assert.assertEquals(depFlightPrice, depFlightPriceAtBottom);
		Assert.assertEquals(retFlightPrice, retFlightPriceAtBottom);

	}

	@Test(dependsOnMethods = "testThatDepartureFlightPriceAndReturnPriceReflectedSameAtBottom")
	public void testThatCorrectTotalAmountReflectedCorrectlyAtTheBottom() {
		Assert.assertEquals(depFlightPriceAtBottom + retFlightPriceAtBottom,
				searchResultPage.getTotalFightPriceAtBottom());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
