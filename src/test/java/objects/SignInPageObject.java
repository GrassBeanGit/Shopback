package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import actions.lowLevelActions.ClickActions;
import actions.lowLevelActions.GetActions;
import actions.lowLevelActions.SetActions;

public class SignInPageObject {

	public SignInPageObject(WebDriver driver) {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
	}

	@FindBy(xpath = "//input[@id='ap_email']")
	public WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='continue']")
	public WebElement btnContinue;

	@FindBy(xpath = "//input[@id='ap_password']")
	public WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='signInSubmit']")
	public WebElement btnSignIn;

	@FindBy(xpath = "//span[@class='a-list-item']")
	public WebElement msgInvalidEmailPasswordMessage;

	public void setEmail(String email) {
		SetActions.setValue(txtEmail, email);
	}
	
	public void setPassword(String password) {
		SetActions.setValue(txtPassword, password);
	}
	
	public void clickContinueButton() {
		ClickActions.clickOnElement(btnContinue);
	}
	
	public void clickSignInButton() {
		ClickActions.clickOnElement(btnSignIn);
	}
	
	public String getInvalidEmailPasswordMessage() {
		return GetActions.getText(msgInvalidEmailPasswordMessage);
	}
}
