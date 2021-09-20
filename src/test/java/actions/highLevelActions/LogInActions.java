package actions.highLevelActions;

import org.openqa.selenium.WebDriver;

import constants.UrlsConstants;
import objects.SignInPageObject;

public class LogInActions {

	public static void doLogIn(WebDriver driver, String email, String password) {

		goToSignInPage(driver);

		SignInPageObject signInPageObject = new SignInPageObject(driver);
		signInPageObject.setEmail(email);
		signInPageObject.clickContinueButton();
		signInPageObject.setPassword(password);
		signInPageObject.clickSignInButton();
	}

	public static void doLogInWithInvalidEmail(WebDriver driver, String email) {

		goToSignInPage(driver);

		SignInPageObject signInPageObject = new SignInPageObject(driver);
		signInPageObject.setEmail(email);
		signInPageObject.clickContinueButton();
	}

	public static void doLogInWithInvalidPassword(WebDriver driver, String email, String password) {
		doLogIn(driver, email, password);
	}

	private static void goToSignInPage(WebDriver driver) {
		String url = driver.getCurrentUrl();

		if (url.equals(UrlsConstants.HOME)) {
			String helloAccountString = NavigationBarActions.getHelloAccountString(driver);
			if (helloAccountString.contains("Sign in") == false) {
				NavigationBarActions.clickSignOutLink(driver);
			}
			NavigationBarActions.clickAccountListLink(driver);
		}
	}

	public static boolean verifyInvalidEmailPasswordMessage(WebDriver driver, String expectedMessage) {
		SignInPageObject signInPageObject = new SignInPageObject(driver);
		String message = signInPageObject.getInvalidEmailPasswordMessage();
		message = message.trim();
		if (message.equals(expectedMessage)) {
			return true;
		} else {
			return false;
		}
	}
}
