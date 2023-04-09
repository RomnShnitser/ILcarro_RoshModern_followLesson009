package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperUser extends Helper_Base {
	//- - - - - - - - - - - - - - - - - - - - - - -
	public HelperUser (WebDriver driver) {
		super(driver);
	}

	public boolean isLogged () {
		return isElementPresent(By.xpath("//a[normalize-space()='Logout']"));
	}

	public void logout () {
		mouseClick(By.xpath("//a[normalize-space()='Logout']"));
	}

	public boolean isLoggedSuccess() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement element = driver.findElement(By.cssSelector(".dialog-container"));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText().contains("success");
	}

	public void openLoginForm () {
		mouseClick(By.xpath("//a[@class='navigation-link'][normalize-space()='Log in']"));
	}

	public void fillLoginForm (String mail, String password) {
		type(By.xpath("//input[@id='email']"), mail);
		type(By.xpath("//input[@id='password']"), password);
	}

	public void submitLogin () {
		mouseClick(By.xpath("//button[@type='submit']"));
	}

	public void clickOkButtonOnLogin () {
		mouseClick(By.xpath("//button[@type='button']"));
	}

	public void fillLoginForm (User userData) {
		type(By.xpath("//input[@id='email']"), userData.getEmail());
		type(By.xpath("//input[@id='password']"), userData.getPassword());
	}

	public void login (User user) {
		openLoginForm();
		fillLoginForm(user);
		submitLogin();
		pauseThreadSleep(2000);
		clickOkButtonOnLogin();
	}
}
