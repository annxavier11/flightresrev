package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.LoggerFactory;

import page.Abstractpage;
import page.Flightvalidation;


public class Flightvalidation extends Abstractpage {
	private static final org.slf4j.Logger log=LoggerFactory.getLogger(Flightvalidation.class);
	
	@FindBy(css="#flights-confirmation-section > div > div > div > form > div > div > div:nth-child(1) > div:nth-child(1)")
    WebElement flightconfirm;
    @FindBy(css="#flights-confirmation-section > div > div > div > form > div > div > div:nth-child(3) > div:nth-child(2) > p")
    WebElement totalprice;

	public Flightvalidation(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public boolean isAt() {
	
	this.wait.until(ExpectedConditions.visibilityOf(this.totalprice));
	return this.totalprice.isDisplayed();
	}
	public String getprice() throws Exception
	{
		String confirmation=this.flightconfirm.getText();
		String totalprice=this.totalprice.getText();
		log.info("flight confirmation : {}", confirmation );
		log.info("flight totalprice : {}", totalprice );
		//return this.totalprice.getText();
	return totalprice;
		
	}


}
