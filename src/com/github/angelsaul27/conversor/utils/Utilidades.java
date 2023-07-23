package com.github.angelsaul27.conversor.utils;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Utilidades {
    
    // Intercambiar las selecciones
    public void intercambiar_entradas(JComboBox<String> select1, JComboBox<String> select2){
        String auxSelect1 = (String) select1.getSelectedItem();
        String auxSelect2 = (String) select2.getSelectedItem();
        
        if(!auxSelect1.equalsIgnoreCase(auxSelect2)) {
        	select1.setSelectedItem(auxSelect2);
            select2.setSelectedItem(auxSelect1);
        }else {
        	JOptionPane.showMessageDialog(null, "Instrucción Invalida.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public Boolean validar_seleccion(String select1, String select2) {
    	if(select1.equalsIgnoreCase(select2)) {
    		JOptionPane.showMessageDialog(null, "Seleccione monedas diferentes.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);	
    		return false;
    	}
    	
    	return true;
    }

    public String getSelectItem(JComboBox<String> select) {
    	return (String) select.getSelectedItem();
    }

}
