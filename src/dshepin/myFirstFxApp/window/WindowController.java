package dshepin.myFirstFxApp.window;

public class WindowController extends Window {
	private final CheckParameters checkParameters;
	private final DataCleaner dataCleaner;
	private final Calculator calculator;
	private final Data data;


	public WindowController() {
		checkParameters = new CheckParameters();
		dataCleaner = new DataCleaner();
		calculator = new Calculator();
		data = new Data();
	}

	@Override
	public void calculate() {
		Data data = setData();
		boolean isGoodParameters = checkParameters.checkParameters(data);
		if (!isGoodParameters) {
			dataCleaner.cleanAllParameter();
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
}
