package page;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import page.Abstractpage;

public class Flightselect extends Abstractpage {
	@FindBy(name="departure-flight")
	List<WebElement> depflights;
	@FindBy(name="arrival-flight")
	List<WebElement> arraivals;
	
	@FindBy(id="confirm-flights")
	WebElement confirmflight;
	
	@FindBy(id="arr-qatar-business")
	WebElement qatrbuis;
	public Flightselect(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		this.wait.until(ExpectedConditions.visibilityOf(this.confirmflight));
		return this.confirmflight.isDisplayed();
	}
	public void selecting()
	{
	int random=ThreadLocalRandom.current().nextInt(0,depflights.size());//here it will select any value in the index  btw 0 and 9
	//int random1=ThreadLocalRandom.current().nextInt(0,arraivals.size());
	this.depflights.get(random).click();
	//this.arraivals.get(random).click();
	//this.qatrbuis.click();
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", qatrbuis);	
	}
	public void confirmflight()
	{
		
		//this.confirmflight.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", confirmflight);
	}
	


}
