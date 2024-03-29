package com.qa.PMSMART.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;

	public Page initBrowser(String browserName) {

		System.out.println("browser name is:" + browserName);

		playwright = Playwright.create();

		switch (browserName) {
		case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "webkit":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "chrome":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
		case "msedge":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
			break;

		default:
			System.out.println("please pass the right browser name.. ");
			break;
		}
		browserContext = browser.newContext();
		page = browserContext.newPage();
		page.navigate("https://pmsstg.hcl.com/pmsmart/Request?Key=login");
		
		return page;
		

	}

}
