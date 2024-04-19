package tests.two_classes;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByRoleOptions;
import com.microsoft.playwright.options.AriaRole;

import tests.TestBase;

public class PlaywrightTest extends TestBase{
	private final GetByRoleOptions roleOptionsLocator = new Page.GetByRoleOptions();
	
	@Test
	public void test01() {
		System.out.println("PlaywrightTest test01() start => " + Thread.currentThread().getName());
		page.navigate("http://playwright.dev");

		// Expect a title "to contain" a substring.
		assertThat(page).hasTitle(Pattern.compile("Playwright"));

		// Create a locator
		Locator getStarted = page.getByRole(AriaRole.LINK, roleOptionsLocator.setName("Get Started"));

		// Expect an attribute "to be strictly equal" to the value.
		assertThat(getStarted).hasAttribute("href", "/docs/intro");

		// Click the get started link.
		getStarted.click();

		// Expects page to have a heading with the name of Installation.
		assertThat(page.getByRole(AriaRole.HEADING, roleOptionsLocator.setName("Installation"))).isVisible();

		// Hover to drop-down list language and select 'Java'
		Locator dropDownListLanguage = page.locator("//a[@class='navbar__link']");
		dropDownListLanguage.hover();
		Locator laguageOptions = page.locator(String.format("//li[./a[text()='%s']]", "Java"));
		laguageOptions.click();
		
		// Expect an attribute "to be strictly equal" to the value.
		String expectedPlaywrightJavaDocument = "https://playwright.dev/java/docs/intro";
		assertThat(page).hasURL(expectedPlaywrightJavaDocument);
		
		System.out.println("PlaywrightTest test01() end => " + Thread.currentThread().getName());
	}
	
	
	@Test
	public void test02() {
		System.out.println("PlaywrightTest test02() start => " + Thread.currentThread().getName());
		
		// Navigate to "https://playwright.dev/java/docs/intro";
		page.navigate("https://playwright.dev/java/docs/intro");
		
		// Click on Test Runners at left menu 'Get Started'
		Locator testRunners = page.locator("a[href='/java/docs/test-runners']");
		testRunners.click();
		
		// Verify header of page
		Locator testRunnersHeader = page.locator("//h1");
		assertThat(testRunnersHeader).hasText("Test Runners");
		
		System.out.println("PlaywrightTest test02() end => " + Thread.currentThread().getName());
	}
	
	@Test
	public void  test03() {
		System.out.println("PlaywrightTest test03() start => " + Thread.currentThread().getName());
		//Navigate to "https://playwright.dev/java/docs/test-runners#junit"
		page.navigate("https://playwright.dev/java/docs/test-runners#junit");
		
		// Click on 'JUnit' at right table of contents
		Locator junitContents = page.locator("//ul[contains(@class, 'table-of-contents')]//a[@href='#introduction']");
		junitContents.click();
		
		Locator junitTitle = page.locator("h2#junit");
		assertThat(junitTitle).hasAttribute("id", "junit");
		
		System.out.println("PlaywrightTest test03() end => " + Thread.currentThread().getName());
	}
}
