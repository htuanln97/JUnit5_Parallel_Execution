package core;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	Playwright playwright;
	Page page;
	Browser browser;
	BrowserType browserType;
	BrowserContext browserContext;

	public Page getPage(String sBrowserType) {
		playwright = Playwright.create();
		LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500);
		switch (sBrowserType) {
		case "chromium":
			browserType = playwright.chromium();
			break;
		case "chrome":
			browserType = playwright.chromium();
			launchOptions.setChannel("chrome");
			break;
		case "edge":
			browserType = playwright.chromium();
			launchOptions.setChannel("msedge");
			break;
		case "firefox":
			browserType = playwright.firefox();
			break;
		case "webkit":
			browserType = playwright.webkit();
			break;
		default:
			throw new IllegalArgumentException(String.format("Unsupported browser type as: '%s'", sBrowserType));
		}
		browser = browserType.launch(launchOptions);
		browserContext = browser.newContext();
		page = browserContext.newPage();
		return page;
	}
	
	public Page getPage(String sBrowserType, String sURL) {
		getPage(sBrowserType).navigate(sURL);
		return page;
	}
	
	public void closePlaywright() {
		playwright.close();
	}
}
