package BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public abstract class PageBase {

	public static AppiumDriver<MobileElement> driver;
	private final WebDriverWait maxWaitTime;

	public PageBase(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		maxWaitTime = new WebDriverWait(driver, 50);
	}

	// Explicit wait to wait for element to be clickable
	
	public void waitForElementClickable(MobileElement element) {
		try {
			maxWaitTime.until(ExpectedConditions.elementToBeClickable(element));
		} catch (TimeoutException e) {
			System.out.println("Message is :" + e.getMessage());
			e.printStackTrace();
		}
	}

	// Explicit wait to wait for element to be visible
	
	public void waitForElementVisible(MobileElement element) {
		try {
			maxWaitTime.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			System.out.println("Message is :" + e.getMessage());
			e.printStackTrace();
		}
	}

	// To read values from excel sheet
	
	public String readExcel(String SheetName, String TestCaseName, String ColumnName) throws IOException {

		FileInputStream Input = new FileInputStream("DataSheet.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(Input);
		XSSFSheet Sheet = wb.getSheet(SheetName);
		int Row = Sheet.getLastRowNum();
		String CellValue, data = null;
		int RowIndex = 0;
		int ColumnIndex = 0;
		for (int i = 1; i <= Row; i++) {
			CellValue = Sheet.getRow(i).getCell(0).getStringCellValue();
			if (CellValue.equalsIgnoreCase(TestCaseName)) {
				RowIndex = i;
				break;
			}
		}
		for (int i = 1; i < 15; i++) {
			CellValue = Sheet.getRow(0).getCell(i).getStringCellValue();
			if (CellValue.equalsIgnoreCase(ColumnName)) {
				ColumnIndex = i;
				break;
			}

		}
		if (RowIndex != 0 && ColumnIndex != 0) {
			data = Sheet.getRow(RowIndex).getCell(ColumnIndex).getStringCellValue();
		}
		return data;
	}
}
