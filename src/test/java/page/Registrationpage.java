package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import page.Abstractpage;

public class Registrationpage extends Abstractpage{



	
	
	
	@FindBy(id="firstName")
	WebElement first;
	@FindBy(id="lastName")
	WebElement last;
	@FindBy(id="email")
	WebElement email;
	@FindBy(name="street")
	WebElement street;

	@FindBy(id="password")
	WebElement pass;
	@FindBy(name="city")
	WebElement city;
	@FindBy(name="zip")
	WebElement zip ;
	@FindBy(xpath="//button[@id=\"register-btn\"]")
	WebElement registerbutton;
	
	public Registrationpage(WebDriver driver)
	{
		super(driver);
	}
	
	public void goTo(String url)
	{
		driver.get(url);
		
	}
	
	public void enterdetails(String first,String last)
	{this.driver.manage().window().maximize();
		this.first.sendKeys(first);
		this.last.sendKeys(last);
		
		
	}
	public void addcred(String email,String pass)
	{
	this.email.sendKeys(email);	
	this.pass.sendKeys(pass);
		
	}
	
	public void enteradd(String street,String city,String zip)
	{ 
		this.street.sendKeys(street);
		this.city.sendKeys(city);
		this.zip.sendKeys(zip);

		//this.registerbutton.click();
	}
	public void clicki()
	{
		this.registerbutton.click();
	}

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		this.wait.until(ExpectedConditions.visibilityOf(this.first));
		return this.first.isDisplayed();
	}
}
