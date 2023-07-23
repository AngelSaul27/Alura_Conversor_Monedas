package com.github.angelsaul27.conversor.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.github.angelsaul27.conversor.functions.AccionesNavegacion;

public class Navegacion extends JPanel {

	private static final long serialVersionUID = 1L;

    private final AccionesNavegacion utils = new AccionesNavegacion();;
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel contentParent;
    private final JPanel panelCoin = new Divisas();
    private final JPanel panelTemperature = new Temperatura();
    private final JButton changueCoin = new JButton("Divisas");
    private final JButton changueTemperature = new JButton("Temperaturas");
    private final String currentPanel = "coins";

    public Navegacion(JPanel contentParent) {
        this.contentParent = contentParent;

        utils.setContentParent(contentParent);
        utils.setCurrentPanel(currentPanel);
        utils.setChangueCoin(changueCoin);
        utils.setChangueTemperature(changueTemperature);

        this.configureNavigation();
        this.configureCardLayout();

        utils.setCardLayout(cardLayout);
    }

    private void configureNavigation() {
        setBackground(Color.decode("#3e76a6"));
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setDefaultOptions(changueCoin, "coins");
        setDefaultOptions(changueTemperature, "temperature");

        add(changueCoin);
        add(changueTemperature);
    }

    private void configureCardLayout() {
        contentParent.setLayout(cardLayout);
        contentParent.add(panelCoin, "coins");
        contentParent.add(panelTemperature, "temperature");

        cardLayout.show(contentParent, currentPanel);
    }

    private void setDefaultOptions(JButton button, String panelName) {
        button.setPreferredSize(new Dimension(150, 30));
        button.setFocusable(false);
        button.setBorder(null);
        button.setActionCommand(panelName);
        button.addActionListener(utils.changePanel);
        utils.setPropertyTextButton(panelName, button);
    }
}
