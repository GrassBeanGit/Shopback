package actions.lowLevelActions;

import org.openqa.selenium.WebElement;

public class GetActions {

	public static String getText(WebElement element) {
		String text = element.getText();
		return text;
	}
}
