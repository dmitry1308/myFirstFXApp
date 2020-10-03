package dshepin.myFirstFxApp.window;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Window {
	@FXML
	public Button calculateButton;

	@FXML
	public TextField inputHotWater;
	@FXML
	public TextField inputColdWater;
	@FXML
	public TextField inputElectricityWater;

	@FXML
	public abstract void calculate();
}
