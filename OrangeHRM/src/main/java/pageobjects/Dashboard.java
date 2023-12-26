package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import functions.Function;

public class Dashboard extends BaseClass {
	
	@FindBy(xpath = "//h6[contains(@class, 'oxd-topbar-header-title')]")
	public WebElement topBar;
	
	@FindBy(xpath = "//h6[contains(@class, 'oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module')]")
	public WebElement header;
	
	@FindBy(xpath = "//*[contains(@class, 'oxd-userdropdown')]")
	private WebElement userDropDown;
	
	@FindBy(xpath = "//a[contains(text(), 'About')]")
	private WebElement aboutDD;
	
	@FindBy(xpath = "//a[contains(text(), 'Support')]")
	private WebElement supportDD;
	
	@FindBy(xpath = "//a[contains(text(), 'Change Password')]")
	private WebElement changeDD;
	
	@FindBy(xpath = "//a[contains(text(), 'Logout')]")
	private WebElement logoutDD;
	
	@FindBy(xpath = "//h6[contains(@class, 'oxd-text oxd-text--h6 orangehrm-main-title')]")
	public WebElement supportPage;
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p' and text()='Time at Work']")
	public WebElement tawTittle;
	
	@FindBy(xpath = "//span[contains(@class, 'oxd-text oxd-text--span orangehrm-attendance-card-fulltime')]")
	public WebElement timeToday;
	
	@FindBy(xpath = "//button[contains(@class, 'oxd-icon-button oxd-icon-button--solid-main orangehrm-attendance-card-action')]")
	private WebElement timeBTN;
	
	@FindBy(xpath = "//h6[contains(@class, 'oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module')]")
	private WebElement attendence;
	
	@FindBy(xpath = "//div[contains(@class, 'orangehrm-dashboard-widget-name')]")
	private WebElement actionHeader;
	
	@FindBy(xpath = "//p[contains(@class, 'oxd-text oxd-text--p')]")
	private WebElement actionToDo;
	
	@FindBy(className = "orangehrm-todo-list")
	private List<WebElement> actionToDoList;
	
	@FindBy(xpath = "//*[@class= 'orangehrm-todo-list']/div[1]/p")
	private WebElement div1;
	
	@FindBy(xpath = "//*[@class= 'orangehrm-todo-list']/div[2]/p")
	private WebElement div2;
	
	@FindBy(xpath = "//*[@class= 'orangehrm-todo-list']/div[3]/p")
	private WebElement div3;
	
	@FindBy(xpath = "//*[@class= 'orangehrm-todo-list']/div[4]/p")
	private WebElement interviewToDo;
	
	@FindBy(xpath = "//*[@class= 'orangehrm-header-container']/span")
	private WebElement recordFoundDiv1;
	
	@FindBy(xpath = "//*[@class= 'orangehrm-horizontal-padding orangehrm-vertical-padding']/span")
	private WebElement recordFoundDiv2;
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p' and text()='Quick Launch']")
	private WebElement quiclaunchHeader;
	
	@FindBy(xpath = "//button[@title='Assign Leave']")
	private WebElement assignLeave;
	
	@FindBy(xpath = "//button[@title='Leave List']")
	private WebElement leaveList;
	
	@FindBy(xpath = "//button[@title='Timesheets']")
	private WebElement qlTimesheets;
	
	@FindBy(xpath = "//button[@title='Apply Leave']")
	private WebElement qlApplyLeave;
	
	@FindBy(xpath = "//button[@title='My Leave']")
	private WebElement qlMyLeave;
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p' and text()='Buzz Latest Posts']")
	private WebElement feedHeader;
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-buzz-widget-body' and text()='#TOD ']")
	private WebElement post;
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p' and text()='Employees on Leave Today']")
	private WebElement empsOnLeave;
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-gear-fill orangehrm-leave-card-icon']")
	private WebElement empOnLeaveicon;
	
	@FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module' and text()='Leave']")
	private WebElement leaveHeader;
	
	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb' ]/h6[2]")
	private WebElement timesheetHeader;
	
//	@FindBy(xpath = "//p[contains(@class, 'oxd-text oxd-text--p')]")
//	private List<WebElement> actionHeader;
	
	
	public Dashboard() {
		PageFactory.initElements(driver,this);	
	}
	
	public void clickOnTopBar() {
		Function.click(driver, topBar);
	}
	
	
	public boolean dashboardHeader() {
		return Function.isDisplayed(driver, header);
	}
	
	public boolean userDDvisible() {
		return Function.isDisplayed(driver, userDropDown);
	}
	
	public boolean userDropdown() {
		return Function.isEnabled(driver, userDropDown);
	}
	
	public void clickOnUserDD() {
		Function.click(driver, userDropDown);
	}
	
	public boolean supportpageVisible() {
		return Function.isDisplayed(driver, supportPage);
	}
	
	public boolean aboutVisible() {
		return Function.isDisplayed(driver, aboutDD);
	}
	public boolean changeVisible() {
		return Function.isDisplayed(driver, changeDD);
	}
	public boolean logoutVisible() {
		return Function.isDisplayed(driver, logoutDD);
	}
	public boolean supportVisible() {
		return Function.isDisplayed(driver, supportDD);
	}
	
	public String aboutText() {
		String aText = aboutDD.getText();
		return aText;
	}
	
	public String logoutText() {
		String lText = logoutDD.getText();
		return lText;
	}
	
	public String changeText() {
		String cText = changeDD.getText();
		return cText;
	}
	
	public String supportText() {
		String sText = supportDD.getText();
		return sText;
	}
	
	public void clickOnSupport() {
		Function.click(driver, supportDD);
	}
	
	public boolean displayedtawTittle() {
		return Function.isDisplayed(driver, tawTittle);
	}
	
	public String verifytawTittle() {
		String tawText = tawTittle.getText();
		return tawText;
	}
	
	public boolean displayedTimeBTN() {
		return Function.isDisplayed(driver, timeBTN);
	}
	
	public void clickOnTimeBTN() {
		Function.click(driver, timeBTN);
	}
	
	public boolean displayedAttendenceText() {
		return Function.isDisplayed(driver, attendence);
	}
	
	public String verifyAttendenceHeader() {
		String atText = attendence.getText();
		return atText;
	}
	
	
	public String TodoText1() {
		String tsText = div1.getText();
		return tsText;
	}
	
	public String TodoText2() {
		String tsText = div2.getText();
		return tsText;
	}
	
	public void clickOndiv1() {
		Function.click(driver, div1);
	}
	
	public void clickOndiv2() {
		Function.click(driver, div2);
	}
	
	public String recordFoundTextDiv1() {
		String recordText = recordFoundDiv1.getText();
		return recordText;
	}
	public String recordFoundTextDiv2() {
		String recordText = recordFoundDiv2.getText();
		return recordText;
	}
	
	public int getNumFromStr(String str) {
		int a = Integer.parseInt(str.replaceAll("[^0-9]",""));
		return a;
	}
	
	public boolean displayedQLHeader() {
		return Function.isDisplayed(driver, quiclaunchHeader);
	}
	
	public boolean assignLeaveDisplayed() {
		return Function.isDisplayed(driver, assignLeave);
	}
	
	public void clickOnQLassignLeave() {
		Function.click(driver, assignLeave);
	}
	
	public boolean leaveListDisplayed() {
		return Function.isDisplayed(driver, leaveList);
	}

	public void clickOnQLleaveList() {
		Function.click(driver, leaveList);
	}
	
	public boolean qlTimesheetsDisplayed() {
		return Function.isDisplayed(driver, qlTimesheets);
	}
	
	public void clickOnQLqlTimesheets() {
		Function.click(driver, qlTimesheets);
	}
	
	public boolean qlApplyLeaveDisplayed() {
		return Function.isDisplayed(driver, qlApplyLeave);
	}
	
	public void clickOnQLqlApplyLeave() {
		Function.click(driver, qlApplyLeave);
	}
	
	public boolean leaveHeaderDisplayed() {
		return Function.isDisplayed(driver, leaveHeader);
	}
	
	public String leaveHeaderText() {
		String lhText = leaveHeader.getText();
		return lhText;
	}
	
	public boolean timesheetHeaderDisplayed() {
		return Function.isDisplayed(driver, timesheetHeader);
	}
	
	public String timesheetHeaderText() {
		String timeText = timesheetHeader.getText();
		return timeText;
	}
	
	public void clickOnQLqlMyLeave() {
		Function.click(driver, qlMyLeave);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
