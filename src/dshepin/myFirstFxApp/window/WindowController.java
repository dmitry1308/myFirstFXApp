package dshepin.myFirstFxApp.window;

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
		inputPrevColdWater.setText(newData.getInputColdWater());
		inputPrevHotWater.setText(newData.getInputHotWater());
		inputPrevElectricityWater.setText(newData.getInputElectricityWater());
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
	}
}
