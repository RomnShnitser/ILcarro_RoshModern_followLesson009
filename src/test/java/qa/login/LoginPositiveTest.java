package qa.login;

import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.TestBase;

public class LoginPositiveTest extends TestBase {
	@BeforeMethod
	public void precondition () {
		if(app.user().isLogged()) {
			app.user().logout();
		}
	}

	@Test
	public void loginTest () {
		app.user().openLoginForm();
		app.user().fillLoginForm("asd@fgh.com", "$Asdf1234");
		app.user().submitLogin();
		app.user().pauseThreadSleep(1500);
		app.user().clickOkButtonOnLogin();
	}

	@Test
	public void loginTestModel () {
		User userData = new User().withEmail("asd@fgh.com").withPassword("$Asdf1234");
		app.user().openLoginForm();
		app.user().fillLoginForm(userData);
		app.user().submitLogin();
		app.user().pauseThreadSleep(1500);
		app.user().clickOkButtonOnLogin();
	}

	@AfterMethod
	public void postCondition () {
		app.user().pauseThreadSleep(1000);
		if(app.user().isLogged()){
			app.user().logout();
		}
		app.user().goHome();
	}
}
