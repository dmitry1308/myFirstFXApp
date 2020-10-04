package dshepin.myFirstFxApp.logic.writer;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface FileWriter {
	void write(XSSFWorkbook book);
}
