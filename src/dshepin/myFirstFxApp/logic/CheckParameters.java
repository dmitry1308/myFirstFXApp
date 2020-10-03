package dshepin.myFirstFxApp.logic;

import dshepin.myFirstFxApp.data.Data;

public class CheckParameters {
	public boolean checkParameters(Data data) {
		if (data.getInputColdWater().equals("")) {
			return false;
		}
		if (data.getInputHotWater().equals("")) {
			return false;
		}
		if (data.getInputElectricityWater().equals("")) {
			return false;
		}
		return true;
	}
}
