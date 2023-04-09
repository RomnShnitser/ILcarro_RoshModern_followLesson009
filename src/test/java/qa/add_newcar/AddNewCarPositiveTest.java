package qa.add_newcar;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.TestBase;

public class AddNewCarPositiveTest extends TestBase {
	@BeforeMethod
	public void precondition () {
		if(app.user().isLogged() == false) {
			app.user().login(new User()
					.withEmail("asd@fgh.com")
					.withPassword("$Asdf1234")
			);
		}
	}

	@Test
	public void addNewCarPositiveTest () {
		int i = (int) (System.currentTimeMillis() / 1000) % 3600;

		Car car = Car.builder()
				.address("Tel Aviv")
				.make("KIA")
				.model("Sportage")
				.year("2020")
				.fuel("Petrol")
				.seats("4")
				.carClass("5")
				.carRegNumber("100-200-" + i)
				.price("150")

				.build();
		app.car().openCarForm();
		Assert.assertTrue(app.car().isCarFormPresent());
		//app.getCar().fillCarForm();
		//	app.getCar().submitForm();
	}

	//	@AfterMethod
//	public void postCondition () {
//
//	}

}
