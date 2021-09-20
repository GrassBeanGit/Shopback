package actions.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFWorkbook workBook;
	private static XSSFCell cell;

	public static XSSFSheet getDataSheet(String filePath, String sheetName) throws Exception {
		FileInputStream inputFile = new FileInputStream(filePath);
		workBook = new XSSFWorkbook(inputFile);
		return workBook.getSheet(sheetName);
	}

	public static String getCellData(XSSFSheet workSheet, int rowIndex, int colIndex) throws Exception {
		cell = workSheet.getRow(rowIndex).getCell(colIndex);
        CellType cellType = cell.getCellType();
        String cellValue = "";
        
        if(cellType.toString() == "STRING") {
        	cellValue = cell.getStringCellValue();
        }
        
        if(cellType.toString() == "NUMERIC") {
        	cellValue = String.valueOf(cell.getNumericCellValue());
        }
		return cellValue;
	}

	public static int getTotalRow(XSSFSheet excelSheet) {
		return excelSheet.getPhysicalNumberOfRows();
	}

	public static void writeTestResultToTestSheet(String filePath, XSSFSheet workSheet, boolean result, int rowIndex,
			int columIndex) throws Exception {

		if (result == true) {
			workSheet.getRow(rowIndex).createCell(columIndex).setCellValue("Passed");
		} else {
			workSheet.getRow(rowIndex).createCell(columIndex).setCellValue("Failed");
		}

		FileOutputStream outputFile = new FileOutputStream(filePath);
		workBook.write(outputFile);
	}
}