package com.example.erafmak.enums;

public enum Weigth {

	L1("1 Liter."),
	L1_5("1.5 Liters."),
	L2_5("2.5 Liters."),
	L3_0("3.0 Liters."),
	L3_5("3.5 Liters."),
	FIVE("5 liters.");
	
private final String displayValue;
    
    private Weigth(String displayValue) {
        this.displayValue = displayValue;
    }
    
    public String getDisplayValue() {
        return displayValue;
    }

}
