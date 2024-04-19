package pages;

import com.microsoft.playwright.Page;

public class HomePage {
	Page page;

	private String id = "id=email";
	private String pw = "id=pass";

	public HomePage(Page page) {
		this.page = page;
	}

	public HomePage Login(String userName, String password) {
		try {
			page.locator(id).clear();
			page.locator(id).fill(userName);
			page.locator(pw).clear();
			page.locator(pw).fill(password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return new HomePage(page);
	}
}
