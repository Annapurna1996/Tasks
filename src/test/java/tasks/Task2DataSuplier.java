package tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task2DataSuplier {
	
  @Test
  @DataProvider(name="SearchData")
	public String[][] method() throws IOException {
		
		File data_file = new File("C:\\Users\\HP\\eclipse-workspace Tasks\\Automation_Tasks\\ExcelFiles\\Book1.xlsx");
		FileInputStream fis = new FileInputStream(data_file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Opencart");
		int Rows_count = sheet.getPhysicalNumberOfRows();
		int Columns_count = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[Rows_count-1][Columns_count];
		
		for (int i = 0; i <Rows_count-1 ; i++) {
			for (int j = 0; j < Columns_count; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue( sheet.getRow(i+1).getCell(j));
			}
		}
		workbook.close();
		fis.close();
		return data;
	}

}
