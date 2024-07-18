package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class IntegrationWIthTC {
	
	public static String[][] readExcel(String dataFile) throws IOException {

		
		XSSFWorkbook wb=new XSSFWorkbook("./data/"+dataFile+".xlsx");
			
		XSSFSheet sheet = wb.getSheetAt(0); //sheet index number
			
		int rowCount = sheet.getLastRowNum();
		
		int cellCount = sheet.getRow(1).getLastCellNum();
		

		
		String[][] value=new String[rowCount][cellCount];
		
		
		for (int i = 1; i <=rowCount; i++) {
			
			for (int j = 0; j < cellCount; j++) {
				
				String data = sheet.getRow(i).getCell(j).getStringCellValue();
				
				
				value[i-1][j]=data;
				
			}
		}
		
		wb.close();
		
		
		return value;
	}

}
