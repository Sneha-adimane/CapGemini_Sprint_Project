package genric_utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

    private static final String EXCEL_PATH = "./src/test/resources/TestData.xlsx";

    // DataProvider 1: Login details from sheet1
    @DataProvider(name = "loginDetails")
    public static Object[][] loginDetails()throws EncryptedDocumentException, IOException {
        
    	return readRows("sheet1", 2, false);
    }

    // DataProvider 2: Checkout information from sheet2
    @DataProvider(name = "yourInformation")
    public static Object[][] yourInformation()throws EncryptedDocumentException, IOException {

        return readRows("sheet2", 3, false);
    }

    // Helper: Read a specific Excel row (zero-based index)
    private static Object[][] readInformationRow(int excelRow)throws EncryptedDocumentException, IOException {

        try (FileInputStream fis = new FileInputStream(EXCEL_PATH);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet("sheet2");

            if (sheet == null) {
            	throw new IllegalArgumentException("Sheet 'sheet2' not found in TestData.xlsx");
            }

            Row row = sheet.getRow(excelRow);

            if (row == null) {
                throw new IllegalArgumentException("Excel row " + (excelRow + 1)+ " is missing in sheet2");
            }

            Object[][] data = new Object[1][3];
            DataFormatter formatter = new DataFormatter();

            for (int col = 0; col < 3; col++) {
                if (row.getCell(col) == null) {
                    data[0][col] = "";
                } else {
                    data[0][col] = formatter.formatCellValue(row.getCell(col)).trim();
                }
            }

            return data;
        }
    }

    // DataProvider 3: All checkout fields empty
    @DataProvider(name = "emptyAllFields")
    public static Object[][] emptyAllFields()throws EncryptedDocumentException, IOException {

        return readInformationRow(1); // Excel row 2
    }

    // DataProvider 4: First Name empty
    @DataProvider(name = "emptyFirstName")
    public static Object[][] emptyFirstName()throws EncryptedDocumentException, IOException {

        return readInformationRow(2); // Excel row 3
    }

    // DataProvider 5: Last Name empty
    @DataProvider(name = "emptyLastName")
    public static Object[][] emptyLastName()throws EncryptedDocumentException, IOException {

        return readInformationRow(3); // Excel row 4
    }

    // DataProvider 6: Non-empty login details from Sheet3
    @DataProvider(name = "loginDetailsxlx")
    public static Object[][] loginDetailsxlx()throws EncryptedDocumentException, IOException {

        List<Object[]> data = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(EXCEL_PATH);
            Workbook workbook = WorkbookFactory.create(fis)) {
            Sheet sheet = workbook.getSheet("Sheet3");
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet 'Sheet3' not found in TestData.xlsx");
            }
            DataFormatter formatter = new DataFormatter();

            // Skip header row
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                String username = row.getCell(0) == null? "": formatter.formatCellValue(row.getCell(0)).trim();
                String password = row.getCell(1) == null? "": formatter.formatCellValue(row.getCell(1)).trim();
                // Skip rows with missing username or password
                if (!username.isEmpty() && !password.isEmpty()) {
                    data.add(new Object[] { username, password });
                }
            }
        }

        return data.toArray(new Object[0][]);
    }

    // Common helper: Read rows from an Excel sheet
    private static Object[][] readRows(String sheetName, int columnCount, boolean skipEmptyRows)throws EncryptedDocumentException, IOException {

        try (FileInputStream fis = new FileInputStream(EXCEL_PATH);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new IllegalArgumentException("Sheet '" + sheetName+ "' not found in TestData.xlsx");
            }

            DataFormatter formatter = new DataFormatter();
            List<Object[]> data = new ArrayList<>();

            // Start at row 1 to skip the header
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Object[] values = new Object[columnCount];
                boolean allEmpty = true;

                for (int col = 0; col < columnCount; col++) {
                    String value = "";
                    if (row != null && row.getCell(col) != null) {
                        value = formatter.formatCellValue(row.getCell(col)).trim();
                    }
                    values[col] = value;
                    if (!value.isEmpty()) {
                        allEmpty = false;
                    }
                }
                if (!skipEmptyRows || !allEmpty) {
                    data.add(values);
                }
            }
            return data.toArray(new Object[0][]);
        }
    }
}
