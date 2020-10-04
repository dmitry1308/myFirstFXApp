package dshepin.myFirstFxApp.controller;

import dshepin.myFirstFxApp.data.Data;
import dshepin.myFirstFxApp.fx.Window;
import dshepin.myFirstFxApp.logic.Calculator;
import dshepin.myFirstFxApp.logic.processor.DataProcesser;
import dshepin.myFirstFxApp.logic.dataCreatorForFile.ExcelDataCreator;
import dshepin.myFirstFxApp.logic.writer.ExcelWriter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WindowController extends Window {
	private final DataProcesser dataProcesser;
	private final Calculator calculator;


	public WindowController() {
		dataProcesser = new DataProcesser();
		calculator = new Calculator();
	}

	@Override
	public void calculate() {
		Data data = setInputData();

		Data processedData = dataProcesser.process(data);
		if (isFailData(data, processedData)) return;

		Data newData = calculator.calculate(processedData);
		setFXData(newData);

		XSSFWorkbook book = new ExcelDataCreator<>().create(newData);
		new ExcelWriter().write(book);
	}

	private boolean isFailData(Data data, Data checkedData) {
		if (checkedData.isFail()) {
			cleanCalculateData();
			correctFailedParametrs(checkedData);
			data.setFail(false);
			return true;
		}
		return false;
	}

	private void correctFailedParametrs(Data checkedData) {
		inputHotWater.setText(checkedData.getInputHotWater());
		inputColdWater.setText(checkedData.getInputColdWater());
		inputElectricityWater.setText(checkedData.getInputElectricityWater());
		inputPrevHotWater.setText(checkedData.getInputPrevHotWater());
		inputPrevColdWater.setText(checkedData.getInputPrevColdWater());
		inputPrevElectricityWater.setText(checkedData.getInputPrevElectricityWater());
	}

	private void setFXData(Data newData) {
		expenseColdWater.setText(newData.getExpenseColdWater());
		expenseHotWater.setText(newData.getExpenseHotWater());
		expenseElectricity.setText(newData.getExpenseElectricity());

		costColdWater.setText(newData.getCostColdWater());
		costHotWater.setText(newData.getCostHotWater());
		costElectricity.setText(newData.getCostElectricity());
		shit.setText(newData.getShit());
		sumCost.setText(newData.getSumCost());
	}

	private Data setInputData() {
		Data data = new Data();
		data.setInputColdWater(inputColdWater.getText());
		data.setInputHotWater(inputHotWater.getText());
		data.setInputElectricityWater(inputElectricityWater.getText());

		data.setInputPrevColdWater(inputPrevColdWater.getText());
		data.setInputPrevHotWater(inputPrevHotWater.getText());
		data.setInputPrevElectricityWater(inputPrevElectricityWater.getText());

		return data;
	}

	public void cleanAllParameter() {
		inputColdWater.clear();
		inputHotWater.clear();
		inputElectricityWater.clear();

		inputPrevHotWater.clear();
		inputPrevColdWater.clear();
		inputPrevElectricityWater.clear();

		cleanCalculateData();
	}

	private void cleanCalculateData() {
		expenseHotWater.clear();
		expenseColdWater.clear();
		expenseElectricity.clear();

		costHotWater.clear();
		costColdWater.clear();
		costElectricity.clear();
		shit.clear();

		sumCost.setText("");
	}
}
