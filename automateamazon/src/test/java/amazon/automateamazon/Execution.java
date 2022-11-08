package amazon.automateamazon;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AmazonSignup;

public class Execution extends DriverH{
	AmazonSignup amazon;
	@BeforeTest
	public void beforepre() {
		drivermethod();
		 amazon = new AmazonSignup();
	}
	
	@Test
	public void siginpage() {
		amazon.siginin();
	}
}
