package Crio.QTrip.TestCase;

import org.testng.annotations.Test;

import Crio.QTrip.PageObject.RegisterPage;

public class testCase_01 {
	
	@Test(description="Register and Login")
	public void TestCase_01() {
		 System.out.println("Testcase01 - started");
	        System.out.println("Username is : "+userName);
	        System.out.println("Password is : "+password);
	        RegisterPage reg = new RegisterPage(driver,mainURL);
	        SoftAssert soft = new SoftAssert();
	        String regURL = reg.navigateToRegisterPage();
	        soft.assertTrue(regURL.contains("register"), "Register navigation Failed");
	        Method methodObj = this.getClass().getMethod("TestCase01", String.class, String.class);
	        LoginPage login = reg.registerUser(methodObj, password);
	        soft.assertTrue(driver.getCurrentUrl().contains("login"), "Login navigation Failed");
	        HomePage home = login.loginUser();
	        WebElement logoutButton = home.verifyUserLoggedIn();
	        soft.assertTrue(logoutButton.getText().equalsIgnoreCase("logout"), "User not logged in");
	        WebElement loginhereButton = home.logoutUser();
	        soft.assertTrue(loginhereButton.getText().equalsIgnoreCase("Login Here"),
	                "User not logged out");

	        System.out.println("Testcase01 - Completed");
	        soft.assertAll();
	    }
	}

}
