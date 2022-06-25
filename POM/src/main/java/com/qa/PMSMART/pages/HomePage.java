package com.qa.PMSMART.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	
	private Page page;
	
	// 1. string locator -- object locator
	
	private String search = "input[name= 'search']"; 
	private String searchIcon = "div#search button"; 
	private String searchPageHeader = "div#content h1"; 
	
	// 2. page constructor
	public HomePage(Page page) {
		
		this.page=page;
	}
	
	// 3. page actions/ methods
	
	public String getHomePageTitle() {
		 String title = page.title();
		 System.out.println("Page title is:"+title);
		 return title;
	}
	
	public String getHomeURL() {
		String url = page.url();
		System.out.println("Url is "+url);
		return url;
	}
	
//	public String doSearch(String ProductName) {
//		page.fill(search, ProductName);
//		page.click(searchIcon);
//		 String headerContent = page.textContent(searchPageHeader);
//		 System.out.println("Search header is:"+headerContent);
//		 return headerContent;
//		//page.locator(searchPageHeader).wait();
		
//	}
	
}
