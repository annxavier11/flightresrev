package page;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

	public abstract class Abstractpage {


		

		
		protected final WebDriver driver;
		protected final WebDriverWait wait;


		public Abstractpage(WebDriver driver)

		{
			this.driver=driver;
			this.wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);

		}

		public abstract boolean isAt();
		}


