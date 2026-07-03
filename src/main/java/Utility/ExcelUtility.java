package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility{
	
		
		private static final String EXCEL_PATH = "./src/test/resources/TestScriptData.xlsx";
	
			
		public String getExcelData(String sheetName, int rowNum, int cellNum) {

	        String value = "";

	        try {
	            FileInputStream fis = new FileInputStream(EXCEL_PATH);

	            Workbook wb = WorkbookFactory.create(fis);

	            Sheet sheet = wb.getSheet(sheetName);

	            Row row = sheet.getRow(rowNum);

	            Cell cell = row.getCell(cellNum);

	            value = cell.getStringCellValue();

	            wb.close();
	            fis.close();

	        } catch (EncryptedDocumentException | IOException e) {
	            e.printStackTrace();
	        }

	        return value;
	    }
	
		
}
