package testModules;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import actions.common.ExcelUtils;
import actions.highLevelActions.LogInActions;
import actions.highLevelActions.NavigationBarActions;
import actions.lowLevelActions.CloseActions;
import actions.lowLevelActions.OpenActions;
import constants.LogInExcelConstants;
import constants.UrlsConstants;

public class LogInTest {

	private String testDataFilePath = "./src/test/java/dataAndTestResult/LogInTestDataAndTestResult.xlsx";

	@Parameters("usageBrowserName")
	@Test
	public void verifyLogInFeatureWithValidEmailAndPassword(String usageBrowserName) throws Exception {

		XSSFSheet workSheet = ExcelUtils.getDataSheet(testDataFilePath, LogInExcelConstants.VALID_SHEET);
		int rowAmount = ExcelUtils.getTotalRow(workSheet);
		for (int i = 1; i < rowAmount; i++) {

			WebDriver driver = OpenActions.openWebsite(usageBrowserName, UrlsConstants.HOME);

			String email = ExcelUtils.getCellData(workSheet, i, LogInExcelConstants.VALID_SHEET_EMAIL);
			String password = ExcelUtils.getCellData(workSheet, i, LogInExcelConstants.VALID_SHEET_PASSWORD);
			String expectation = ExcelUtils.getCellData(workSheet, i, LogInExcelConstants.VALID_SHEET_EXPECTATION);

			LogInActions.doLogIn(driver, email, password);
			boolean testResult = NavigationBarActions.verifyValidLogInResult(driver, expectation);

			ExcelUtils.writeTestResultToTestSheet(testDataFilePath, workSheet, testResult, i,
					LogInExcelConstants.VALID_SHEET_RESULT);

			CloseActions.closeAllOfBrowsers(driver);
		}
	}

	@Parameters("usageBrowserName")
	@Test
	public void verifyUserCanNotLoginWithInvalidEmail(String usageBrowserName) throws Exception {

		XSSFSheet sheet = ExcelUtils.getDataSheet(testDataFilePath, LogInExcelConstants.INVALID_EMAIL_SHEET);
		int rowAmount = ExcelUtils.getTotalRow(sheet);
		for (int i = 1; i < rowAmount; i++) {

			WebDriver driver = OpenActions.openWebsite(usageBrowserName, UrlsConstants.HOME);

			String email = ExcelUtils.getCellData(sheet, i, LogInExcelConstants.INVALID_EMAIL_SHEET_EMAIL);
			String expectation = ExcelUtils.getCellData(sheet, i, LogInExcelConstants.INVALID_EMAIL_SHEET_EXPECTATION);

			LogInActions.doLogInWithInvalidEmail(driver, email);
			boolean testResult = LogInActions.verifyInvalidEmailPasswordMessage(driver, expectation);

			ExcelUtils.writeTestResultToTestSheet(testDataFilePath, sheet, testResult, i,
					LogInExcelConstants.INVALID_EMAIL_SHEET_RESULT);

			CloseActions.closeAllOfBrowsers(driver);
		}
	}

	@Parameters("usageBrowserName")
	@Test
	public void verifyUserCanNotLoginWithInvalidPassword(String usageBrowserName) throws Exception {

		XSSFSheet sheet = ExcelUtils.getDataSheet(testDataFilePath, LogInExcelConstants.INVALID_PASSWORD_SHEET);
		int rowAmount = ExcelUtils.getTotalRow(sheet);
		for (int i = 1; i < rowAmount; i++) {

			WebDriver driver = OpenActions.openWebsite(usageBrowserName, UrlsConstants.HOME);

			String email = ExcelUtils.getCellData(sheet, i, LogInExcelConstants.INVALID_PASSWORD_SHEET_EMAIL);
			String password = ExcelUtils.getCellData(sheet, i, LogInExcelConstants.INVALID_PASSWORD_SHEET_PASSWORD);
			String expectation = ExcelUtils.getCellData(sheet, i,
					LogInExcelConstants.INVALID_PASSWORD_SHEET_EXPECTATION);

			LogInActions.doLogInWithInvalidPassword(driver, email, password);
			boolean testResult = LogInActions.verifyInvalidEmailPasswordMessage(driver, expectation);

			ExcelUtils.writeTestResultToTestSheet(testDataFilePath, sheet, testResult, i,
					LogInExcelConstants.INVALID_PASSWORD_SHEET_RESULT);

			CloseActions.closeAllOfBrowsers(driver);
		}
	}
}
