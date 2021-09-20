package actions.highLevelActions;

import org.openqa.selenium.WebDriver;

import constants.UrlsConstants;
import objects.NavigationBarObject;

public class NavigationBarActions {

	public static String getHelloAccountString(WebDriver driver) {
		NavigationBarObject navigationBarObject = new NavigationBarObject(driver);
		return navigationBarObject.getHelloSignInString();
	}

	public static void clickAccountListLink(WebDriver driver) {
		NavigationBarObject navigationBarObject = new NavigationBarObject(driver);
		navigationBarObject.clickAccountListLink();
	}

	public static void clickSignOutLink(WebDriver driver) {

		String url = driver.getCurrentUrl();
		if (url.equals(UrlsConstants.SIGN_IN)) {
			NavigationBarObject navigationBarObject = new NavigationBarObject(driver);
			navigationBarObject.clickSignOutLink();
		}
	}

	public static boolean verifyValidLogInResult(WebDriver driver, String expectedString) {
		NavigationBarObject navigationBarObject = new NavigationBarObject(driver);
		String loginResult = navigationBarObject.getHelloSignInString();
		if (loginResult.equals(expectedString)) {
			return true;
		} else {
			return false;
		}
	}

}