package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {
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
}
