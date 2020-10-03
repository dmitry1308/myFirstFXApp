package dshepin.myFirstFxApp.logic;

import dshepin.myFirstFxApp.data.Data;

import static dshepin.myFirstFxApp.data.Price.*;

public class Calculator {
	private Data data;

	public Data calculate(Data data) {
		this.data = data;
		calculateExpense();
		calculateCost();
		return data;
	}

	private void calculateCost() {
		int expensiveColdWater = Integer.parseInt(data.getExpenseColdWater());
		double coldCost = expensiveColdWater * COLD_WATER_PRICE;
		data.setCostColdWater(String.valueOf(coldCost));

		int expensiveHotWater = Integer.parseInt(data.getExpenseHotWater());
		double hoCost = expensiveHotWater * HOT_WATER_PRICE;
		data.setCostHotWater(String.valueOf(hoCost));

		int shit = Integer.parseInt(data.getExpenseColdWater()) + Integer.parseInt(data.getExpenseHotWater());
		double shitCost = shit * SHIT;
		data.setShit(String.valueOf(shitCost));

		int electricity = Integer.parseInt(data.getExpenseElectricity());
		double electCost = electricity * ELECTRICITY_PRICE;
		data.setCostElectricity(String.valueOf(electCost));

		String summa = String.valueOf(coldCost + hoCost + shitCost + electCost);
		data.setSumCost(summa);

	}

	private void calculateExpense() {
		Integer hotWater = Integer.valueOf(data.getInputHotWater());
		Integer prevHotWater = Integer.valueOf(data.getInputPrevHotWater());
		data.setExpenseHotWater(String.valueOf(hotWater - prevHotWater));

		Integer ColdWater = Integer.valueOf(data.getInputColdWater());
		Integer prevColdWater = Integer.valueOf(data.getInputPrevColdWater());
		data.setExpenseColdWater(String.valueOf(ColdWater - prevColdWater));

		Integer electricity = Integer.valueOf(data.getInputElectricityWater());
		Integer prevElectricity = Integer.valueOf(data.getInputPrevElectricityWater());
		data.setExpenseElectricity(String.valueOf(electricity - prevElectricity));
	}
}
