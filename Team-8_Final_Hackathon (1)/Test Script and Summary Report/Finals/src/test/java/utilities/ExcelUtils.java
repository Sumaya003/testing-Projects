package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static void writeDataToExcel(String filePath,String sheetName,List<List<String>> data) throws IOException
	{

		Workbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = (XSSFSheet) workbook.createSheet(sheetName);
			
			for (int i = 0; i < data.size(); i++) {
				Row row = sheet.createRow(i);
				List<String> rowData = data.get(i);
				for (int j = 0; j < rowData.size(); j++) {
					row.createCell(j).setCellValue(rowData.get(j));
				}
			}
			FileOutputStream out = new FileOutputStream(filePath);
			{
				workbook.write(out);
			}
			workbook.close();
		}



	}
