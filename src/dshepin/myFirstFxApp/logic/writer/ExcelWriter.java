package dshepin.myFirstFxApp.logic.writer;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter implements FileWriter {
	private static final String FILE_NAME = "DataService.xlsx";

	@Override
	public void write(XSSFWorkbook book) {
		try {
			FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
			book.write(outputStream);
			book.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}