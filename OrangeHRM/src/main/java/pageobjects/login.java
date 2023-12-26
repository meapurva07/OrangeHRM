package pageobjects;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import functions.Function;

public class login extends BaseClass {
	
	
	@FindBy(xpath = "//h5[contains(@class, 'oxd-text oxd-text--h5 orangehrm-login-title')]")
	public WebElement title;
	
	@FindBy(name = "username")
	private WebElement userInput;
	
	@FindBy(name = "password")
	private WebElement passInput;
	
	@FindBy(xpath = "//button[contains(@class, 'oxd-button oxd-button--medium oxd-button--main orangehrm-login-button')]")
	private WebElement loginButton;
	
	@FindBy(xpath = "//p[contains(@class, 'oxd-text oxd-text--p orangehrm-login-forgot-header')]")
	private WebElement forgotPasswordButton;
	
	@FindBy(xpath = "//p[contains(@class, 'oxd-text oxd-text--p oxd-alert-content-text')]")
	private WebElement errorNotification;
	
	@FindBy(xpath = "//span[contains(@class, 'oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message')]")
	private List<WebElement> errorText;
	
	public login() {
		PageFactory.initElements(driver,this);
		
	}
	
	public boolean validateTitle() {
		return Function.isDisplayed(driver, title);
	}
	
	public boolean validateForgotPswd() {
		return Function.isDisplayed(driver, forgotPasswordButton);
	}
	
	public void clickOnForgotPswd() {
		Function.click(driver, forgotPasswordButton);
	}
	
	public void clickOnLogin() {
		Function.click(driver, loginButton);
	}
	
	public boolean validateErrorNotif() {
		boolean err=Function.isDisplayed(driver, forgotPasswordButton);
		return err;
	}
	
	public String errNotifText() {
		String notifText = errorNotification.getText();
		return notifText;
	}
	
	public String errorText(int index) {
		String erText = errorText.get(index).getText();
		return erText;
	}
	
	public int errTextCount() {
		int errCount = errorText.size();
		return errCount;
	}
	
	
	public void loggingin(String uname, String pswd) throws Throwable {
		Function.type(userInput, uname);
		Function.type(passInput, pswd);
		Function.click(driver, loginButton);
		Thread.sleep(2000);
//		Dashboard dashboard=new Dashboard();
//		return dashboard;
	}
	

}
