package tests.multiple_classes;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;

import tests.TestBase;

public class G extends TestBase{
	@Test
	public void test01() {
		System.out.println("G.test01() start => " + Thread.currentThread().getName());
		page.navigate("https://junit.org/junit5/");

		// Expect a title "to contain" a substring.
		assertThat(page).hasTitle(Pattern.compile("JUnit 5"));

		// Create a locator
		Locator userGuide = page.locator("li a[href='/junit5/docs/current/user-guide'][role='button']");

		// Expect an attribute "to be strictly equal" to the value.
		assertThat(userGuide).isVisible();

		// Click the get started link.
		userGuide.click();

		// Expects page to have a heading with the name of Installation.
		assertThat(page).hasURL("https://junit.org/junit5/docs/current/user-guide/");
		
		System.out.println("G.test01() end => " + Thread.currentThread().getName());

	}
	
	@Test
	public void test02() {
		System.out.println("G.test02() start => " + Thread.currentThread().getName());
		// Navigate to "https://junit.org/junit5/docs/current/user-guide/"
		page.navigate("https://junit.org/junit5/docs/current/user-guide/");
		
		// Verify header of page as "JUnit 5 User Guide"
		Locator junit5UserGuideHeader = page.locator("//h1");
		assertThat(junit5UserGuideHeader).hasText("JUnit 5 User Guide");
		
		System.out.println("G.test02() end => " + Thread.currentThread().getName());
		
	}
}
