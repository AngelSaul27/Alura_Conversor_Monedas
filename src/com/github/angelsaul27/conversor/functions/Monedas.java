package com.github.angelsaul27.conversor.functions;

public class Monedas {
	private String abbreviation;
    private String name;
    private double value;

    public Monedas(String abbreviation, String name, double value) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.value = value;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
