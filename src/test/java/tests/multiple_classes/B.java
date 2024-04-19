package tests.multiple_classes;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Page;

import tests.TestBase;

class B extends TestBase {
	@Test
	void test01() {
		System.out.println("B.test01() start => " + Thread.currentThread().getName());
		page.setContent("<div>hello</div>");
		assertEquals("hello", page.innerHTML("css=div"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("B.test01() end => " + Thread.currentThread().getName());
	}

	@Test
	void test02() {
		System.out.println("B.test02() start => " + Thread.currentThread().getName());
		Page popup = page.waitForPopup(() -> {
			page.evaluate("window.open('about:blank');");
		});
		assertEquals("about:blank", popup.url());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("B.test02() end => " + Thread.currentThread().getName());
	}
}