package com.github.angelsaul27.conversor.functions;

import java.util.HashMap;
import java.util.Map;

public class ListaMonedasConvertibles {
	
	private static Map<String, Monedas> currencies;

    static {
        currencies = new HashMap<>();
        currencies.put("AUD", new Monedas("AUD", "Australian Dollar", 1.462202));
        currencies.put("BRL", new Monedas("BRL", "Brazilian Real", 4.802736));
        currencies.put("CAD", new Monedas("CAD", "Canadian Dollar", 1.32335));
        currencies.put("CHF", new Monedas("CHF", "Swiss Franc", 0.863265));
        currencies.put("CNY", new Monedas("CNY", "Chinese Yuan", 7.1411));
        currencies.put("EUR", new Monedas("EUR", "Euro", 0.889957));
        currencies.put("GBP", new Monedas("GBP", "British Pound Sterling", 0.763884));
        currencies.put("HKD", new Monedas("HKD", "Hong Kong Dollar", 7.8148));
        currencies.put("INR", new Monedas("INR", "Indian Rupee", 82.11625));
        currencies.put("JPY", new Monedas("JPY", "Japanese Yen", 138.69490883));
        currencies.put("KRW", new Monedas("KRW", "South Korean Won", 1269.33));
        currencies.put("MXN", new Monedas("MXN", "Mexican Peso", 16.745855));
        currencies.put("NZD", new Monedas("NZD", "New Zealand Dollar", 1.569982));
        currencies.put("RUB", new Monedas("RUB", "Russian Ruble", 90.252708));
        currencies.put("SEK", new Monedas("SEK", "Swedish Krona", 10.151125));
        currencies.put("SGD", new Monedas("SGD", "Singapore Dollar", 1.3209));
        currencies.put("TRY", new Monedas("TRY", "Turkish Lira", 26.1703));
        currencies.put("USD", new Monedas("USD", "United States Dollar", 1));
    }

    public static Map<String, Monedas> getCurrencies() {
        return currencies;
    }
}
