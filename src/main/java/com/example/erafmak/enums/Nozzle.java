package com.example.erafmak.enums;

public enum Nozzle {

	N0_8("0.8"),
	N1_0("1.0"),
	N1_2("1.2"),
	N1_3("1.3"),
	N1_4("1.4"),
	N1_5("1.5"),
	N1_6("1.6"),
	N1_8("1.8"),
	N2_0("2.0"),
	N2_5("2.5");
	
	private String displayValue;
	
	private Nozzle(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}
}
