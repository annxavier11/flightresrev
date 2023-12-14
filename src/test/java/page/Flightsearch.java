package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import page.Abstractpage;

public class Flightsearch extends Abstractpage {
	@FindBy(id="passengers")
    WebElement num;
    @FindBy(id="depart-from")
    WebElement depart;
    @FindBy(id="arrive-in")
    WebElement arrival;
    @FindBy(xpath="//button[@id=\"search-flights\"]")
    WebElement search;
	public Flightsearch(WebDriver driver) {
		super(driver);
	}

	public boolean isAt() {
		// TODO Auto-generated method stub
		this.wait.until(ExpectedConditions.visibilityOf(this.num));
		return this.num.isDisplayed();
	}

	public void  selectnum( String number)
	{
		Select numb=new Select(this.num);
		numb.selectByValue(number);
		
	}
	
	public void searchclick()
	{
		//this.driver.manage().window().maximize();
		
	   JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", search);
	}

}
