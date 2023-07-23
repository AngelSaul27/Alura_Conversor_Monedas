package com.github.angelsaul27.conversor;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.github.angelsaul27.conversor.functions.AccionesVentana;
import com.github.angelsaul27.conversor.ui.BarraMenu;
import com.github.angelsaul27.conversor.ui.Navegacion;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanels = new JPanel(); // CONTENDOR DE PANELS
	private final JPanel contentParent = new JPanel(); // CONTENDOR CENTRAL
	private final Image icono = getIcon("./resources/favicon.png");
	
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setSize(600, 300);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		if(icono != null) { setIconImage(icono); }
		addComponetsIntoJFrame();
	}

	private Image getIcon(String URL) {
		Image imagen = new ImageIcon(getClass().getResource(URL)).getImage();
        return (imagen);
    }
	
	private void addComponetsIntoJFrame(){
		add(new BarraMenu(), BorderLayout.NORTH); // HEADER MENU
		contentParent.setLayout(new BorderLayout());
		contentParent.add(new Navegacion(contentPanels), BorderLayout.NORTH);// 320 x 600
		contentParent.add(contentPanels, BorderLayout.CENTER);
		add(contentParent, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		Main windows = new Main();
		AccionesVentana listener = new AccionesVentana(windows);
		windows.addMouseListener(listener.mouseListener);
		windows.addMouseMotionListener(listener.mouseMotionListener);
		windows.setVisible(true);
	}
}