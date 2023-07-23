package com.github.angelsaul27.conversor.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.github.angelsaul27.conversor.ConversorDivisas;
import com.github.angelsaul27.conversor.utils.EntradaNumerica;

public class Divisas extends JPanel {

	private static final long serialVersionUID = 1L;

    private final EntradaNumerica importe = new EntradaNumerica();
    private final JComboBox<String> divisa_base = new JComboBox<String>();
    private final JComboBox<String> divisa_contraria = new JComboBox<String>();
    private final JButton convertir = new JButton("Convertir");
    private final JButton intercambiar = new JButton();
    private final JLabel resultado = new JLabel("Esperando..");

    public Divisas() {
        setBackground(Color.decode("#F9F9F9"));
        setLayout(null);
        setUixForm();
        setInfoApiUsage();
        new ConversorDivisas(
        	importe, 
        	divisa_base, 
        	divisa_contraria, 
        	convertir, 
        	intercambiar,
        	resultado
        );
    }

    private void setUixForm() {
        final JLabel lbAmount = new JLabel("Importe");
        final JLabel lbCoinSelect = new JLabel("De: ");
        final JLabel lbCoinConvert = new JLabel("A: ");

        lbAmount.setBounds(45, 20, 100, 30);
        lbCoinSelect.setBounds(195, 20, 100, 30);
        lbCoinConvert.setBounds(415, 20, 100, 30);

        importe.setBounds(45, 50, 140, 30);
        divisa_base.setBounds(195, 50, 140, 30);
        divisa_contraria.setBounds(415, 50, 140, 30);
        resultado.setBounds(45, 90, 150, 30);
        
        Image imagen = new ImageIcon(getClass().getResource("swap.png")).getImage();
        Image scaled = imagen.getScaledInstance(17, 17, Image.SCALE_SMOOTH);

        intercambiar.setBounds(350, 50, 50, 30);
        intercambiar.setIcon(new ImageIcon(scaled));
        intercambiar.setBackground(Color.decode("#F9F9F9"));
        intercambiar.setFocusable(false);

        convertir.setBounds(250, 100, 100, 30);
        convertir.setBorder(null);
        convertir.setBackground(Color.decode("#3e76a6"));
        convertir.setForeground(Color.WHITE);
        convertir.setFocusable(false);

        add(lbAmount);
        add(lbCoinSelect);
        add(lbCoinConvert);
        add(importe);
        add(divisa_base);
        add(divisa_contraria);
        add(resultado);
        add(intercambiar);
        add(convertir);
    }

    private void setInfoApiUsage() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextPane message = new JTextPane();
        message.setText("Para mejores resultados le recomendamos usar los servicios "+
        "de Open Exchange Rates que proveen una KEY para usar su API misma que puede "+
        "ser añadida en la aplicación para tener datos más precisos.");
        
        message.setForeground(Color.decode("#758ba6"));
        message.setFont(new Font("Arial", Font.PLAIN, 13));
        message.setEditable(false);
        message.setOpaque(false);
        message.setPreferredSize(new Dimension(panel.getWidth(), panel.getHeight()));
        message.setBorder(new EmptyBorder(10, 10, 10, 10));

        panel.add(message);
        panel.setBounds(50, 150, 500, 70);
        add(panel);
    }
}