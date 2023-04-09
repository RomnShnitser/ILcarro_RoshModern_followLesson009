package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperCar extends Helper_Base {
	public HelperCar (WebDriver driver) {
		super(driver);
	}

	public void openCarForm () {
		pauseThreadSleep(2000);
		mouseClick(By.xpath("(//a[@id='1'])[1]"));
	}

	public boolean isCarFormPresent() {

		return new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.textToBePresentInElement(
						driver.findElement(By.xpath("//h1[normalize-space()='Let the car work']"))
						,"Let the car work"
				));

	}

}
