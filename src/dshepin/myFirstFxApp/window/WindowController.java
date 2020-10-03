package dshepin.myFirstFxApp.window;

public class WindowController extends Window {
	private final CheckParameters checkParameters;
	private final Calculator calculator;
	private final Data data;


	public WindowController() {
		checkParameters = new CheckParameters();
		calculator = new Calculator();
		data = new Data();
	}

	@Override
	public void calculate() {
		Data data = setData();
		boolean isGoodParameters = checkParameters.checkParameters(data);
		if (!isGoodParameters) {
			cleanAllParameter();
			return;
		}
		calculator.calculate();
	}

	private Data setData() {
		data.setInputColdWater(inputColdWater.getText());
		data.setInputHotWater(inputHotWater.getText());
		data.setInputElectricityWater(inputElectricityWater.getText());
		return data;
	}

	public void cleanAllParameter() {
		inputColdWater.clear();
		inputHotWater.clear();
		inputElectricityWater.clear();
	}
}
