package dshepin.myFirstFxApp.logic.writer;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

import static dshepin.myFirstFxApp.constants.File.FILE_NAME;

public class ExcelWriter implements FileWriter<XSSFWorkbook> {

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