package dshepin.myFirstFxApp.controller;

import dshepin.myFirstFxApp.data.Data;
import dshepin.myFirstFxApp.fx.Window;
import dshepin.myFirstFxApp.logic.Calculator;
import dshepin.myFirstFxApp.logic.CheckParameters;

public class WindowController extends Window {
	private final CheckParameters checkParameters;
	private final Calculator calculator;
	private final Data data;
	private Data newData;


	public WindowController() {
		checkParameters = new CheckParameters();
		calculator = new Calculator();
		data = new Data();
		newData = new Data();
	}

	@Override
	public void calculate() {
		Data data = setInputData();
		boolean isGoodParameters = checkParameters.checkParameters(data);
		if (!isGoodParameters) {
			cleanAllParameter();
			return;
		}
		newData = calculator.calculate(data);
		setFXData(newData);
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
