package com.github.angelsaul27.conversor.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.swing.JOptionPane;

import com.github.angelsaul27.conversor.functions.ListaMonedasConvertibles;
import com.github.angelsaul27.conversor.functions.Monedas;

public class ConectarAPI {

    String Key = "";

    public ConectarAPI(String Key) {
        this.Key = Key;
    }

    public void Conectar() {
        try {
            @SuppressWarnings("deprecation")
			URL url = new URL("https://openexchangerates.org/api/latest.json?app_id=" + Key);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder respuesta = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                respuesta.append(line);
            }
            reader.close();

            ProcesarDatos(respuesta.toString());

            JOptionPane.showMessageDialog(null, "CONEXIÓN EXITOSA", "API FUNCIONAL", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Llave incorrecta", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void ProcesarDatos(String jsonString) {
        String contenidoRates = extraerContenidoRates(jsonString);

        String[] paresMoneda = contenidoRates.split(",");

        Map<String, Monedas> monedas = ListaMonedasConvertibles.getCurrencies();

        for (String parMoneda : paresMoneda) {
            String[] keyValue = parMoneda.trim().split(":");
            String codigoMoneda = keyValue[0].replace("\"", "").trim();
            String valorTipoCambioString = keyValue[1].trim();

            double valorTipoCambio = parsearValorTipoCambio(valorTipoCambioString);

            if (monedas.containsKey(codigoMoneda)) {
                Monedas moneda = monedas.get(codigoMoneda);
                moneda.setValue(valorTipoCambio); // Establecer el tipo de cambio actualizado
            }
        }
    }

    private String extraerContenidoRates(String jsonString) {
        int inicioRates = jsonString.indexOf("\"rates\": {");
        int finRates = jsonString.lastIndexOf("}");
        return jsonString.substring(inicioRates + 9, finRates);
    }

    private double parsearValorTipoCambio(String valorTipoCambioString) {
        StringBuilder valorLimpio = new StringBuilder();
        for (int i = 0; i < valorTipoCambioString.length(); i++) {
            char c = valorTipoCambioString.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                valorLimpio.append(c);
            }
        }
        return Double.parseDouble(valorLimpio.toString());
    }
}