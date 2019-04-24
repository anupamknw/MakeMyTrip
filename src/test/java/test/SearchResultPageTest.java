package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.SearchResultPage;
import utils.WaitUtil;

public class SearchResultPageTest extends BaseClass {
	HomePage homepage = null;
	SearchResultPage searchResultPage = null;

	@BeforeClass
	public void setUp() {
		super.setUp(getBrowser());
		_driver.get(getUrl());
		homepage = new HomePage(_driver);
		searchResultPage = new SearchResultPage(_driver);
	}

	@Test
	public void printTotNoOfDepartureAndReturnFlight() {
		homepage.clickOnFlightLink().clickOnRoundTrip();
		homepage.selectFrom("Delhi");
		homepage.selectTo("Bangalore");
		homepage.selectDeparture();
		homepage.selectReturnDate();
		homepage.clickOnSearchBtn();
		WaitUtil.scrollTillEnd(_driver);
		System.out.println("total departure flights: " + searchResultPage.getDepartureFlightsCount());
		System.out.println("total return flights: " + searchResultPage.getReturnFlightsCount());
		_driver.navigate().refresh();
		searchResultPage.selectStopsFilter("Non Stop");
		WaitUtil.scrollTillEnd(_driver);
		System.out.println(
				"total departure flights after selecting non-stop: " + searchResultPage.getDepartureFlightsCount());
		System.out
				.println("total return flights after selecting non-stop: " + searchResultPage.getReturnFlightsCount());
		/*
		 * unselectNonStop(); select1stop();
		 * 
		 * System.out.println("total departure flights: ");
		 * System.out.println("total return flights");
		 * 
		 * unselectNonStop(); unselect1stop();
		 */
	}

	@Test
	public void testThatDepartureFlightPriceAndReturnPriceReflectedSameAtBottom() {

	}

	@Test
	public void testThatCorrectTotalAmountReflectedCorrectlyAtTheBottom() {

	}

	@AfterClass
	public void tearDown() {

	}
}
