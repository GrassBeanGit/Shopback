package actions.lowLevelActions;

import org.openqa.selenium.WebDriver;

public class CloseActions {

	public static void closeAllOfBrowsers(WebDriver driver) {
		driver.quit();
	}
}
