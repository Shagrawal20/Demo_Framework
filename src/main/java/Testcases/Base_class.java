package Testcases;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Utilities.Readconfig;


public class Base_class {
	
	Readconfig readconfig=new Readconfig();

	public String base_URL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		//System.setProperty("webdriver.chrome.driver", "D:/Chrome Driver 79.0/chromedriver_win32/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C://Users//shubhi.agrawal//eclipse-workspace//demo2//Drivers//chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
				
		logger=Logger.getLogger("ebanking");
		BasicConfigurator.configure();
		
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
		}
		else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getChromePath());
			driver=new FirefoxDriver();
		}
		
		else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver",readconfig.getChromePath());
			driver=new InternetExplorerDriver();
		}	
		driver.get(base_URL);
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
