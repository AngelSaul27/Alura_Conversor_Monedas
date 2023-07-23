package com.github.angelsaul27.conversor.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.github.angelsaul27.conversor.utils.ConectarAPI;

public class BarraMenu extends JPanel {

	private static final long serialVersionUID = 1L;

	public BarraMenu() {
        setBackground(Color.decode("#2f2f2f"));
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        loadMenuOptions();
    }

    private void loadMenuOptions() {
        JButton bAPI = new JButton();
        JButton bOption = new JButton();
        JButton bClose = new JButton();

        ImageIcon iconApi = getIcon("../resources/stack.png");
        ImageIcon iconOption = getIcon("../resources/gear.png");
        ImageIcon iconClose = getIcon("../resources/cross.png");

        setDefaultOptions(bAPI, iconApi, apiListener);
        setDefaultOptions(bOption, iconOption, optionsListener);
        setDefaultOptions(bClose, iconClose, closeListener);

        add(bAPI);
        add(bOption);
        add(bClose);
    }

    private JButton setDefaultOptions(JButton button, ImageIcon icon, ActionListener listener) {
        button.setBorder(null);
        button.setFocusable(false);
        button.setBackground(Color.decode("#2f2f2f"));
        button.setIcon(icon);
        button.addActionListener(listener);

        return button;
    }

    private ImageIcon getIcon(String URL) {
        Image imagen = new ImageIcon(getClass().getResource(URL)).getImage();
        Image scaled = imagen.getScaledInstance(17, 17, Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }

    ActionListener optionsListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("OPTIONS");
        }
    };

    ActionListener apiListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String message = "Si tiene una KEY de Open Exchange Rates, agregela aquí: ";
            String KEY_API = JOptionPane.showInputDialog(null, message, "KEY API", JOptionPane.PLAIN_MESSAGE);
            
            ConectarAPI API = new ConectarAPI(KEY_API);
            API.Conectar();
        }
    };

    ActionListener closeListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame Window = (JFrame) getTopLevelAncestor();
            Window.dispose();
        }
    };

}
