package com.github.angelsaul27.conversor.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Temperatura extends JPanel {

	private static final long serialVersionUID = 1L;

    public Temperatura() {
        setBackground(Color.decode("#F9F9F9"));
        
        setLayout(null);
        
        JLabel build = new JLabel("En construcción.");
        build.setBounds(120, 70, 400, 100);
        build.setFont(new Font("Arial", Font.PLAIN, 50));
        add(build);
    }

}
