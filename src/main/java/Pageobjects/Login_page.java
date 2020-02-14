package Pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
	
	WebDriver ldriver;//initialie driver
	
	//Constructor of driver
	public Login_page(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);//Why we use this?
			}
	
	//Webelement in login page

	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement login_btn;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement Logout;
	
	public void setUserName(String uname) {
		username.sendKeys(uname);
	}
	
	public void setpassword(String pword) {
		password.sendKeys(pword);
	}
	
	public void clicksubmit() {
		login_btn.click();
	}
	
	public void click_logout() {
		Logout.click();
	}
}
