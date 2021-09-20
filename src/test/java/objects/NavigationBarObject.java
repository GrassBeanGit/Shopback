package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import actions.lowLevelActions.ClickActions;
import actions.lowLevelActions.GetActions;

public class NavigationBarObject {

	private WebDriver driver;

	public NavigationBarObject(WebDriver driver) {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	public WebElement linkAccountList;

	@FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	public WebElement txtHelloSignIn;

	@FindBy(xpath = "//a[@id='nav-item-signout']")
	public WebElement linkSignOut;

	public void clickAccountListLink() {
		ClickActions.clickOnElement(linkAccountList);
	}

	public String getHelloSignInString() {
		return GetActions.getText(txtHelloSignIn);
	}

	public void clickSignOutLink() {
		moveToHelloSignInString();
		ClickActions.clickOnElement(linkSignOut);
	}

	public void moveToHelloSignInString() {
		Actions actions = new Actions(driver);
		actions.moveToElement(txtHelloSignIn).perform();
	}
}
