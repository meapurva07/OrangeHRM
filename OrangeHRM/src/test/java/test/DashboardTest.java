package test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.Dashboard;
import pageobjects.login;

public class DashboardTest extends BaseClass{
	login Login;
	Dashboard db;
	

	@Test(priority=1, description="verify dashboard title")
	public void verifyDashboardTitle() throws InterruptedException {	
		db= new Dashboard();
		Thread.sleep(4000);
		boolean dbHader= db.dashboardHeader();
		Assert.assertTrue(dbHader);
		
	}

	@Test(priority=2, description="verify user drop down")
	public void userDropDown()throws Throwable {
		try {
		db= new Dashboard();
		db.clickOnUserDD();
		
		//Assert
		Assert.assertTrue(db.aboutVisible());
		Assert.assertTrue(db.supportVisible());
		Assert.assertTrue(db.changeVisible());
		Assert.assertTrue(db.logoutVisible());
		
		}
		catch(Throwable t) {
			System.out.println(t.getMessage());
			System.out.println(t.getCause());
		}
		
	}
	
	@Test(priority=3, description="validate click on support on user drop down")
	public void userDropDownSupport()throws Throwable {
		try {
		db= new Dashboard();
		db.clickOnSupport();
		Assert.assertTrue(db.supportpageVisible());
		
		}
		catch(Throwable t) {
			System.out.println(t.getMessage());
			System.out.println(t.getCause());
		}
		driver.navigate().back();
		
	}
	
	
	@Test(priority=4, description="validate 1st my action component")
      public void VerifyMyActions1()throws Throwable {
		try {
		db= new Dashboard();
		String tsText = db.TodoText1();
		System.out.println(tsText);
		int tsNum = db.getNumFromStr(tsText);
		System.out.println(tsNum);
		db.clickOndiv1();
		Thread.sleep(3000);
		
		String rf= db.recordFoundTextDiv1();
		System.out.println(rf);
		int rfNum = db.getNumFromStr(rf);
		System.out.println(rfNum);
		
		if(rfNum != tsNum) {
			Assert.fail("number of record found are not same");
		} else {
			Assert.assertTrue(true);
		}
		}
		catch(Throwable t) {
			System.out.println(t.getMessage());
			System.out.println(t.getCause());
		}
		
		
		driver.navigate().back();
		
		
	}
	
	@Test(priority=5, description="validate 2nd my action component")
    public void VerifyMyActions2()throws Throwable {
		try {
		db= new Dashboard();
		String tdText = db.TodoText2();
		System.out.println(tdText);
		int tdNum = db.getNumFromStr(tdText);
		System.out.println(tdNum);
		db.clickOndiv2();
		Thread.sleep(3000);

		
		String rf2= db.recordFoundTextDiv2();
		System.out.println(rf2);
		int rfNum2 = db.getNumFromStr(rf2);
		System.out.println(rfNum2);
		
		if(rfNum2 != tdNum) {
			Assert.fail("number of record found are not same");
		} else {
			Assert.assertTrue(true);
		}
	}catch(Throwable t) {
		System.out.println(t.getMessage());
		System.out.println(t.getCause());
	}
		driver.navigate().back();
		
		
	}
	
	@Test(priority=6, description="validate time at work section")
    public void VerifyTimeAtWork()throws Throwable {
		try {
			db= new Dashboard();
			Assert.assertTrue(db.displayedtawTittle());
			Assert.assertTrue(db.displayedTimeBTN());
			db.clickOnTimeBTN();
			Assert.assertTrue(db.displayedAttendenceText());
			
			if(!db.verifyAttendenceHeader().equalsIgnoreCase("Attendance")){
				Assert.fail("text doesn't match: " + db.verifyAttendenceHeader());
			}  else {
				Assert.assertTrue(true);
			}
		}catch(Throwable t) {
			System.out.println(t.getMessage());
			System.out.println(t.getCause());
		}
			driver.navigate().back();	
			
	}		
			
	

	
	@Test(priority=7, description="validate Quick Launch title and assign leave in quick launch section")
    public void VerifyAssignLeaveQL()throws Throwable {
		try {
			db= new Dashboard();
			Assert.assertTrue(db.displayedQLHeader());
			Assert.assertTrue(db.assignLeaveDisplayed());
			
			db.clickOnQLassignLeave();
			Assert.assertTrue(db.leaveHeaderDisplayed());
			
			if(!db.leaveHeaderText().equalsIgnoreCase("Leave")){
				Assert.fail("text doesn't match: " + db.leaveHeaderText());
			}  else {
				Assert.assertTrue(true);
			}
		}catch(Throwable t) {
			System.out.println(t.getMessage());
			System.out.println(t.getCause());
		}
			driver.navigate().back();	
			
			
			
		}
	
	@Test(priority=8, description="validate Leave List in quick launch section")
    public void VerifyLeaveList()throws Throwable {
		try {
			db= new Dashboard();
			Assert.assertTrue(db.leaveListDisplayed());
			db.clickOnQLleaveList();
			Assert.assertTrue(db.leaveHeaderDisplayed());
			
			
			if(!db.leaveHeaderText().equalsIgnoreCase("Leave")){
				Assert.fail("text doesn't match: " + db.leaveHeaderText());
			}  else {
				Assert.assertTrue(true);
			}
			
		}catch(Throwable t) {
			System.out.println(t.getMessage());
			System.out.println(t.getCause());
		}
			driver.navigate().back();	
			
			
			
		}
	
	@Test(priority=9, description="validate Apply Leave in quick launch section")
    public void VerifyApplyLeave()throws Throwable {
		try {
			Assert.assertTrue(db.qlApplyLeaveDisplayed());
			db.clickOnQLqlApplyLeave();
			Assert.assertTrue(db.leaveHeaderDisplayed());
			
			if(!db.leaveHeaderText().equalsIgnoreCase("Leave")){
				Assert.fail("text doesn't match: " + db.leaveHeaderText());
			}  else {
				Assert.assertTrue(true);
			}
			
		}catch(Throwable t) {
			System.out.println(t.getMessage());
			System.out.println(t.getCause());
		}
			driver.navigate().back();	
			
			
			
		}
	
	@Test(priority=10, description="validate Timesheet in quick launch section")
    public void VerifyTimesheet()throws Throwable {
		try {
			Assert.assertTrue(db.qlTimesheetsDisplayed());
			db.clickOnQLqlTimesheets();
			Assert.assertTrue(db.timesheetHeaderDisplayed());
			
			if(!db.timesheetHeaderText().equalsIgnoreCase("Leave")){
				Assert.fail("text doesn't match: " + db.timesheetHeaderText());
			}  else {
				Assert.assertTrue(true);
			}
			
		}catch(Throwable t) {
			System.out.println(t.getMessage());
			System.out.println(t.getCause());
		}
			driver.navigate().back();	
			
			
			
		}

			
			
			
			
			
			
			
			
			
			
			
			
	
	
}	
