package com.github.angelsaul27.conversor;

import java.text.DecimalFormat;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import com.github.angelsaul27.conversor.utils.EntradaNumerica;
import com.github.angelsaul27.conversor.utils.Utilidades;
import com.github.angelsaul27.conversor.functions.ListaMonedasConvertibles;
import com.github.angelsaul27.conversor.functions.Monedas;

public class ConversorDivisas implements Conversor {

	private final Utilidades utils = new Utilidades();
	private final Map<String, Monedas> monedas = ListaMonedasConvertibles.getCurrencies();
	private EntradaNumerica importe;
	private JComboBox<String> divisa_base;
	private JComboBox<String> divisa_contraria;
	private String itemBase = "";
	private String itemLateral = "";
	private JLabel resultado;
	    
    public ConversorDivisas(EntradaNumerica importe, 
        JComboBox<String> divisa_base, JComboBox<String> divisa_contraria, 
        JButton convertir, JButton intercambiar, JLabel resultado)
    {
    	this.importe = importe;
        this.divisa_base = divisa_base;
        this.divisa_contraria = divisa_contraria;    	
        this.resultado = resultado;
    	
    	convertir(convertir);
    	intercambiar_entradas(intercambiar);
    	rellenar_JComboBox();
    }
    
    private void rellenar_JComboBox() {
        for (Monedas moneda : monedas.values()) {
            String abbreviation = moneda.getAbbreviation();
            String name = moneda.getName();
            String option = abbreviation + " : " + name;

            divisa_base.addItem(option);
            divisa_contraria.addItem(option);
        }
        divisa_contraria.setSelectedIndex(5);
        divisa_base.setSelectedIndex(2);
    }
    
    @Override
    public void convertir(JButton button) {
        button.addActionListener(e -> {
        	itemBase = utils.getSelectItem(divisa_base);
        	itemLateral = utils.getSelectItem(divisa_contraria);
            
        	String coinBase = "", coinLateral = "";
        	coinBase = itemBase.substring(0, itemBase.indexOf(":")-1);
            coinLateral = itemLateral.substring(0, itemLateral.indexOf(":")-1);
            
            
            if(!(utils.validar_seleccion(coinBase, coinLateral))) 
            return;
                        
            try {
            	Double coinAmount = Double.parseDouble(importe.getText());
            	
            	if(coinAmount < 0) 
            	return;
            	
            	Double result = 0.0;
            	
            	if(coinBase.equalsIgnoreCase("USD")) {
            		result = monedas.get(coinLateral).getValue() * coinAmount;
            	}else {
            		//(LATERAL * AMOUNT (MATH)) => MATH USD / BASE
            		result = (monedas.get(coinLateral).getValue() * coinAmount) 
            		/ (monedas.get(coinBase).getValue()); 
            	}
            	
            	DecimalFormat df = new DecimalFormat("#.##");
                String resultadoDF = df.format(result);
                
            	resultado.setText("Resultado: "+resultadoDF.toString() + " "+ coinLateral);
            }catch(NumberFormatException error) {
            	System.out.println("Ingrese un importe.");
            }
        });
    }

    @Override
    public void intercambiar_entradas(JButton button) {
        button.addActionListener(e -> {
        	utils.intercambiar_entradas(divisa_contraria, divisa_base);
        });
    }
    
}
