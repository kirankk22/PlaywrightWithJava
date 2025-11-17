package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page; 
	private final String UsernameTextBox = "//input[@placeholder='Username']";
	private final String PasswordTextBox = "//input[@placeholder='Password']";
	private final String LoginButton = "//button[normalize-space()='Login']";
	
	public LoginPage(Page page) {
		this.page = page;
	}
	
	public void navigateToLoginPage() {
		page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	public void addUsername(String username) {
		page.fill(UsernameTextBox,  username);
	}
	
	public void addPassword(String password) {
		page.fill(PasswordTextBox,  password);
	}
	
	public void clickLogin() {
		page.click(LoginButton);
	}
	
	public void loginToApplication(String username, String password) {
		addUsername(username);
		addPassword(password);
		clickLogin();
	}
	
	

}
