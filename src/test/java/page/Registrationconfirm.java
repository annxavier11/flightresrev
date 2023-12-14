package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import page.Abstractpage;

public class Registrationconfirm extends Abstractpage{
	@FindBy(id="go-to-flights-search")
    WebElement confirm;
	
	public Registrationconfirm(WebDriver driver)
	{
		super(driver);
		
	}
	public void confirmclick()
	{
	confirm.click();
	}
	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(confirm));
		return this.confirm.isDisplayed();
	}

}
