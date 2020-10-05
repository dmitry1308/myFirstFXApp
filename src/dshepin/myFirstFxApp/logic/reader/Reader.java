package dshepin.myFirstFxApp.logic.reader;

import org.apache.poi.ss.usermodel.Sheet;

public interface Reader {
	Sheet read(String fileName);
}
