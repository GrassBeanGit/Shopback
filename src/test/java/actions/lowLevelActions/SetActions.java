package actions.lowLevelActions;

import org.openqa.selenium.WebElement;

public class SetActions {

	public static void setValue(WebElement element, String value) {
		element.sendKeys(value);
	}
}
