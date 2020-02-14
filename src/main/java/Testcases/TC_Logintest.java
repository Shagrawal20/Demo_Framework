package Testcases;



import org.testng.Assert;
import org.testng.annotations.Test;
import Pageobjects.Login_page;


public class TC_Logintest extends Base_class{
	
		
	@Test
	public void Logintest() {
				
		logger.info("URL is opened");
		
		Login_page lp=new Login_page(driver);
		lp.setUserName(username);
		logger.info("Username entered");
		
		lp.setpassword(password);
		logger.info("Password entered");
		
		lp.clicksubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("TC pass");
			
		}
		
		else {
			Assert.assertTrue(false);
			logger.info("TC fail");
			
		}
		
	}
	
}
