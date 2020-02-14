package Testcases;



import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import Pageobjects.Login_page;

import Utilities.XLUtils;

public class TC_logintest_excel extends Base_class{

	String sheetName = "Sheet1";
			
		@Test(dataProvider="LoginData")
		public void loginDDT(String user,String pwd) throws InterruptedException
		{
			Login_page lp=new Login_page(driver);
			lp.setUserName(user);
			logger.info("user name provided");
			lp.setpassword(pwd);
			logger.info("password provided");
			lp.clicksubmit();
			
			Thread.sleep(3000);
			
			if(isAlertPresent()==true)
			{
				driver.switchTo().alert().accept();//close alert
				driver.switchTo().defaultContent();
				Assert.assertFalse(false);
				logger.warn("Login failed");
			}
			else
			{
				Assert.assertTrue(true);
				logger.info("Login passed");
				lp.click_logout();
				Thread.sleep(3000);
				driver.switchTo().alert().accept();//close logout alert
				driver.switchTo().defaultContent();
				
			}
			
			
		}
		
		
		public boolean isAlertPresent() //user defined method created to check alert is presetn or not
		{
			try
			{
			driver.switchTo().alert();
			return true;
			}
			catch(NoAlertPresentException e)
			{
				return false;
			}
			
		}
		
		
		
		@DataProvider
		public Object[][] LoginData(){
			Object data[][] = XLUtils.getTestData(sheetName);
		return data ;
		}
	

	}

