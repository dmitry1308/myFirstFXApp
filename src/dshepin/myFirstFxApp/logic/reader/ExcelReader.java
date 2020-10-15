package dshepin.myFirstFxApp.logic.reader;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ExcelReader implements Reader<Sheet,String>{
	@Override
	public Sheet read(String fileName) {
		try {
			FileInputStream excelFile = new FileInputStream(new File(fileName));
			Workbook workbook = new XSSFWorkbook(excelFile);
			return workbook.getSheetAt(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Workbook readBook(String fileName) {
		try {
			FileInputStream excelFile = new FileInputStream(new File(fileName));
			return new XSSFWorkbook(excelFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
