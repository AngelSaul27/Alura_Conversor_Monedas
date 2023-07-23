package com.github.angelsaul27.conversor.functions;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AccionesNavegacion {

    private String currentPanel;
    private CardLayout cardLayout;
    private JButton changueCoin, changueTemperature;
    private JPanel contentParent;

    public void setPropertyTextButton(String panelName, JButton button) {
        if (panelName == currentPanel) {
            button.setBackground(Color.decode("#006FE8"));
            button.setForeground(Color.decode("#FFFFFF"));
            button.setFont(new Font("Arial", Font.BOLD, 13));
        } else {
            button.setBackground(Color.decode("#3e76a6"));
            button.setForeground(Color.decode("#FFFFFF"));
            button.setFont(new Font("Arial", Font.PLAIN, 13));
        }
    }

    public JButton getButtonTriggerEvent(String panelName) {
        switch (panelName) {
            case "coins":
                return changueCoin;
            case "temperature":
                return changueTemperature;
        }
        return changueCoin;
    }

    public ActionListener changePanel = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String panelName = e.getActionCommand();

            if (panelName != currentPanel) {
                cardLayout.show(contentParent, panelName);
                setPropertyTextButton(currentPanel, getButtonTriggerEvent(panelName));
                setPropertyTextButton(panelName, getButtonTriggerEvent(currentPanel));
                currentPanel = panelName;
            }
        }
    };

    public void setCurrentPanel(String currentPanel) {
        this.currentPanel = currentPanel;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public void setChangueCoin(JButton changueCoin) {
        this.changueCoin = changueCoin;
    }

    public void setChangueTemperature(JButton changueTemperature) {
        this.changueTemperature = changueTemperature;
    }

    public void setContentParent(JPanel contentParent) {
        this.contentParent = contentParent;
    }

}
