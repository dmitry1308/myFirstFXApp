package dshepin.myFirstFxApp.logic.dataCreatorForFile;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Arrays;
import java.util.List;

import static dshepin.myFirstFxApp.constants.HeadingsInTableExcel.*;

public class ExcelDataCreator<Data> implements FileDataCreator<Data> {
	private XSSFSheet sheet;

	@Override
	public XSSFWorkbook create(Data data) {
		// todo сделать проверку, если файл создан, то вычитать его.
		return createExcelBookWithHeading();
	}


	private XSSFWorkbook createExcelBookWithHeading() {
		XSSFWorkbook workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Service");
		List<String> heading = createHeading();
		addHeadingToSheet(heading);
		addTestData();
		return workbook;
	}

	private void addHeadingToSheet(List<String> heading) {
		int row = 0;
		sheet.createRow(row);
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

	private void addTestData(){
		int[] indication = {50,60,70};
		int row = 1;
		sheet.createRow(row);
		for (int i = 0; i < indication.length; i++) {
			XSSFRow excelRow = sheet.getRow(row);
			XSSFCell cell = excelRow.createCell(i);
			cell.setCellValue(indication[i]);
		}
	}

	public Workbook writeRowWithDataToBook(Workbook book, dshepin.myFirstFxApp.data.Data newData){
		Sheet sheet = book.getSheetAt(0);
		int lastRowNum = sheet.getLastRowNum();
		Row row = sheet.createRow(lastRowNum + 1);
		row.createCell(0);
		row.createCell(1);
		row.createCell(2);
		row.getCell(0).setCellValue(Integer.parseInt(newData.getInputColdWater()));
		row.getCell(1).setCellValue(Integer.parseInt(newData.getInputHotWater()));
		row.getCell(2).setCellValue(Integer.parseInt(newData.getInputElectricityWater()));
		return book;
	}
}