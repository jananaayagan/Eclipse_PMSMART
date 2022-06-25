package com.qa.PMSMART.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.PMSMART.factory.PlaywrightFactory;
import com.qa.PMSMART.pages.HomePage;

public class HomePageTest {

	PlaywrightFactory pf;
	Page page;

	HomePage homepage;

	@BeforeTest
	public void setup() {

		pf = new PlaywrightFactory();
		pf.initBrowser("chromium");

		homepage = new HomePage(page);
	}

	@Test
	public void homePageTitleTest() {

		String actualTitle = homepage.getHomePageTitle();
		Assert.assertEquals(actualTitle, "Your Store");
	}

	@Test
	public void homePageURLTest() {

		String actualURL = homepage.getHomeURL();
		Assert.assertEquals(actualURL, "https://pmsstg.hcl.com/pmsmart/Request?Key=login");
	}

//	@Test
//	public void searchTest() {
//
//		String actualSearchHeader = homepage.doSearch("macbook");
//		Assert.assertEquals(actualSearchHeader, "Search - macbook");
//	}

	@AfterTest
	public void teardown() {

		page.context().browser().close();
	}
}
