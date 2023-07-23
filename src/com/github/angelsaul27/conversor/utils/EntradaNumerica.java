package com.github.angelsaul27.conversor.utils;

import javax.swing.*;
import javax.swing.text.*;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;

public class EntradaNumerica extends JTextField {
	
	private static final long serialVersionUID = 1L;
    private final NumberFormat currencyFormat;

    public EntradaNumerica() {
        currencyFormat = NumberFormat.getCurrencyInstance();
        DecimalFormat decimalFormat = (DecimalFormat) currencyFormat;
        DecimalFormatSymbols symbols = decimalFormat.getDecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');
        decimalFormat.setDecimalFormatSymbols(symbols);
        setHorizontalAlignment(RIGHT);
        setDocument(new CurrencyDocument());
    }

    private class CurrencyDocument extends PlainDocument {
    	private static final long serialVersionUID = 1L;
        private final String regex = "\\d+(\\.\\d{0,2})?"; // Regex

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (str == null) {
                return;
            }

            String newStr = getCurrentText() + str;

            if (newStr.matches(regex)) {
                super.insertString(offs, str, a);
            }
        }

        private String getCurrentText() throws BadLocationException {
            return getText(0, getLength());
        }
    }

    public double getValue() throws ParseException {
        return currencyFormat.parse(getText()).doubleValue();
    }
}
