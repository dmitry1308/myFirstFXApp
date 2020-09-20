package dshepin.myFirstFxApp.window;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public abstract class Window {
	@FXML
	public Button button1;

	@FXML
	public Button button2;

	@FXML
	public Button button3;


	@FXML
	public abstract void click();
}
