package test;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public abstract class Abstracttest {

	protected WebDriver driver;
	@BeforeTest

	public void setup(String numofpassengers, String expectedprice)
	{ driver =new ChromeDriver();
	
	
	}}
	


