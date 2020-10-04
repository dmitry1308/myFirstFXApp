package dshepin.myFirstFxApp.logic.dataCreatorForFile;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface FileDataCreator<V> {
	XSSFWorkbook create(V data);
}
