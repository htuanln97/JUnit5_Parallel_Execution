package tests.multiple_classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import tests.TestBase;

class D extends TestBase {
	@Test
	void test01() {
		System.out.println("D.test01() start => " + Thread.currentThread().getName());
		page.navigate("data:text/html,<script>var result;</script><button onclick='result=\"Clicked\"'>Go</button>");
		page.locator("button").click();
		assertEquals("Clicked", page.evaluate("result"));
		System.out.println("D.test01() end => " + Thread.currentThread().getName());
	}

	@Test
	void test02() {
		System.out.println("D.test02() start => " + Thread.currentThread().getName());
		page.setContent("<input id='checkbox' type='checkbox'></input>");
		page.locator("input").check();
		assertTrue((Boolean) page.evaluate("() => window['checkbox'].checked"));
		System.out.println("D.test02() end => " + Thread.currentThread().getName());
	}

	@Test
	void test03() {
		System.out.println("D.test03() start => " + Thread.currentThread().getName());
		page.navigate("https://www.wikipedia.org/");
		page.locator("input[name=\"search\"]").click();
		page.locator("input[name=\"search\"]").fill("playwright");
		page.locator("input[name=\"search\"]").press("Enter");
		assertEquals("https://en.wikipedia.org/wiki/Playwright", page.url());
		System.out.println("D.test03() end => " + Thread.currentThread().getName());
	}
}