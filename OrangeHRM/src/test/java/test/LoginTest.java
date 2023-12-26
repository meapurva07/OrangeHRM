package test;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.Dashboard;
import pageobjects.login;

public class LoginTest extends BaseClass {
	
	login Login;
	Dashboard db;
	
	
	@BeforeTest
	public void setup() {
		launchApp(); 
		
	}
	
	@Test( priority = 1)
	public void verifyTitle() throws Throwable {
		Login= new login();
		boolean result= Login.validateTitle();
		Assert.assertTrue(result);
	
	}
	
	@Test(priority = 2, description = "username invalid")
	public void LGN002()throws Throwable {
		Login= new login();
		Login.loggingin(prop.getProperty("invalid_UN"), prop.getProperty("valid_pswd"));
		
		
		// Assert
		String errtext = Login.errNotifText();
		
		
		if(!errtext.equalsIgnoreCase("Invalid credentials")) {
			Assert.fail("text doesn't match: " + errtext);
		} else if (Login.validateErrorNotif() == false) {
			Assert.fail("Error text is not shown");
		} else {
			Assert.assertTrue(true);
		}
	}
	
	@Test(priority = 3, description = "password invalid")
	public void LGN003() throws Throwable {
		Login= new login();
		Login.loggingin(prop.getProperty("valid_UN"), prop.getProperty("invalid_pswd"));
		
		// Assert
		String errtext = Login.errNotifText();
		
		if(!errtext.equalsIgnoreCase("Invalid credentials")) {
			Assert.fail("text doesn't match: " + errtext);
		} else if (Login.validateErrorNotif() == false) {
			Assert.fail("Error text is not shown");
		} else {
			Assert.assertTrue(true);
		}
	}
	
	@Test(priority = 5, description = "username null")
	public void LGN004() throws Throwable {
		Login= new login();
		Login.loggingin(prop.getProperty("null_UN"), prop.getProperty("valid_pswd"));
		
		int a= Login.errTextCount();
		System.out.println(a); 
		
		// Assert
		if(Login.errTextCount() == 0) {
			Assert.fail("No error text found");
		} else if(!Login.errorText(0).equalsIgnoreCase("Required")) {
			Assert.fail("Wrong text shown: " + Login.errorText(0));
		} else {
			Assert.assertTrue(true);
			Thread.sleep(3000);
			
		}
	}
	
	@Test(priority = 6, description = "password null")
	public void LGN005()throws Throwable {
		Login= new login();
		try {
		Login.loggingin(prop.getProperty("valid_UN"), prop.getProperty("null_pswd"));
		
		Thread.sleep(3000);
		int a= Login.errTextCount();
		System.out.println(a); 
			
		
		// Assert
		if(Login.errTextCount() == 0) {
			Assert.fail("No error text found");
		} else if(!Login.errorText(0).equalsIgnoreCase("Required")) {
			Assert.fail("Wrong text shown: " + Login.errorText(0));
		} else {
			Assert.assertTrue(true);
		}
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Thread.sleep(3000);
		}
	}
	
	@Test(priority = 4, description = "username and password null")
	public void LGN006() throws Throwable {
		Login= new login();
		Login.loggingin(prop.getProperty("null_UN"), prop.getProperty("null_pswd"));
		
		
		int a= Login.errTextCount();
		System.out.println(a); 
		
		// Assert
		if(Login.errTextCount() == 2) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("error text not shown twice");
		}
	}
	
	@Test(priority = 7, description = "valid username and password")
	public void loginTest7() throws Throwable{
		Login= new login();
		Login.loggingin(prop.getProperty("valid_UN"), prop.getProperty("valid_pswd"));
	}
	


}
