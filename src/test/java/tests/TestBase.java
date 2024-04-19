package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.*;


//Subclasses will inherit PER_CLASS behavior.
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBase {
	// Shared between all tests in the class.
	Playwright playwright;
	Browser browser;

	@BeforeAll
	void launchBrowser() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setSlowMo(1000));
	}

	@AfterAll
	void closeBrowser() {
		playwright.close();
	}

	// New instance for each test method.
	protected BrowserContext context;
	protected Page page;

	@BeforeEach
	void createContextAndPage() {
		context = browser.newContext();
		page = context.newPage();
	}

	@AfterEach
	void closeContext() {
		context.close();
	}
}
