package dshepin.myFirstFxApp.logic.dataCreatorForFile;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Arrays;
import java.util.List;

import static dshepin.myFirstFxApp.constants.HeadingsInTableExcel.*;

public class ExcelDataCreator<Data> implements FileDataCreator<Data> {
	@Override
	public XSSFWorkbook create(Data data) {
		// todo сделать проверку, если файл создан, то вычитать его.
		return createExcelBookWithHeading();
	}


	private XSSFWorkbook createExcelBookWithHeading() {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Service");
		List<String> heading = createHeading();
		addHeadingToSheet(heading, sheet);
		return workbook;
	}

	private void addHeadingToSheet(List<String> heading, XSSFSheet sheet) {
		int row = 0;
		sheet.createRow(0);
		for (int i = 0; i < heading.size(); i++) {
			XSSFRow excelRow = sheet.getRow(row);
			XSSFCell cell = excelRow.createCell(i);
			cell.setCellValue(heading.get(i));
		}
	}

	private List<String> createHeading() {
		String[] strings = {COLD_WATER, HOT_WATER, ELECTRICITY};
		return Arrays.asList(strings);
	}
}