package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import page.Flightsearch;
import page.Flightselect;
import page.Flightvalidation;
import page.Registrationconfirm;
import page.Registrationpage;

public class Flightreservationtest {
 private String numofpassengers;
 private String expectedprice;
	private WebDriver driver;
	@BeforeTest
	@Parameters({"numofpassengers","expectedprice"})
	
	public void setup(String numofpassengers, String expectedprice) throws Exception
	{ this.numofpassengers=numofpassengers;
	 this.expectedprice=expectedprice;
		//driver initialisation
	 System.out.println(Boolean.getBoolean("selenium.grid.enabled"));
	 if(Boolean.getBoolean("selenium.grid.enabled"))

			{this.driver = getRemoteDriver();
			}
		else
		{
			this.driver = getLocalWebdriver();	
		}
		}
		private WebDriver getRemoteDriver() throws Exception
		{ //DesiredCapabilities capabilities;
			Capabilities capabilities;
		if(System.getProperty("browser").equalsIgnoreCase("chrome"))
				{
			capabilities =new ChromeOptions();
			//driver =new ChromeDriver();
				}
		else
		{
			capabilities= new FirefoxOptions();
			//driver =new ChromeDriver();
		}
			return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}
		
		
		/*{driver=new ChromeDriver();
			DesiredCapabilities capability = new DesiredCapabilities().chrome();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
    
		}*/
		

		private WebDriver getLocalWebdriver()
		{  driver =new ChromeDriver();
			return driver;
			
			
		}
		//driver =new ChromeDriver();
	// this.numofpassengers=numofpassengers;
	// this.expectedprice=expectedprice;
		//WebDriverManager.chromedriver().setup();
		//this.driver=new ChromeDriver();
	
	@Test
	public void userregistration()
	{
		Registrationpage regpage= new Registrationpage(driver);
		regpage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
		Assert.assertTrue(regpage.isAt());
		regpage.enterdetails("annn","xavier");
		regpage.addcred("aneesha@gmail.com", "ansjf678");
		regpage.enteradd("epuzha", "ekm", "76895");
		regpage.clicki();

	}
	@Test(dependsOnMethods="userregistration")
	public void regconfirmation()
	{
		Registrationconfirm regconfirm=new Registrationconfirm(driver);
		Assert.assertTrue(regconfirm.isAt());
		regconfirm.confirmclick();
	}
	@Test(dependsOnMethods="regconfirmation")
	public void flightsearch()
	{
		Flightsearch fsearch= new Flightsearch(driver);
		Assert.assertTrue(fsearch.isAt());
		fsearch.selectnum(numofpassengers);
		fsearch.searchclick();
		
	}
	@Test(dependsOnMethods="flightsearch")
	public void flightselect()
	{
		Flightselect fselect=new Flightselect(driver);
		Assert.assertTrue(fselect.isAt());
		fselect.selecting();
		fselect.confirmflight();
	}
	@Test(dependsOnMethods="flightselect")
	public void validation() throws Exception
	{
	Flightvalidation fvalidation=new Flightvalidation(driver);
	Assert.assertTrue(fvalidation.isAt());
	Assert.assertEquals(fvalidation.getprice(), expectedprice);
		
		
	}
@AfterTest
	public void teardown()
	{
		
		this.driver.close();
	}
}
