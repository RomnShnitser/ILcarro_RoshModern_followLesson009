package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {
	//===========================================================================================
	WebDriver driver;
	HelperUser user;

	/*#########################################################################################*/
	public void initialization () {
		System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");

		//- - - - - - - - - - - - - - - - - - - - - - -
		driver = new ChromeDriver();
		user = new HelperUser(driver);

		//- - - - - - - - - - - - - - - - - - - - - - -
		driver.manage().window().maximize();
		driver.navigate().to("https://ilcarro.web.app/search");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
	}
	/*#########################################################################################*/

	public void stop () {
		driver.quit();
	}

	//===========================================================================================

	public HelperUser user () {
		return user;
	}
}
