package com.github.angelsaul27.conversor.functions;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

public class AccionesVentana {

    private JFrame windows;
    private static int initialX;
    private static int initialY;

    public AccionesVentana(JFrame windows){
        this.windows = windows;
    }

    public MouseListener mouseListener = new MouseListener() {
        @Override
        public void mousePressed(MouseEvent e) {
            initialX = e.getX();
            initialY = e.getY();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    };

    public MouseMotionListener mouseMotionListener = new MouseMotionListener() {
        private int offsetX;
        private int offsetY;

        @Override
        public void mouseDragged(MouseEvent e) {
            int currentX = e.getXOnScreen();
            int currentY = e.getYOnScreen();
            int frameX = currentX - initialX - offsetX;
            int frameY = currentY - initialY - offsetY;
            windows.setLocation(frameX, frameY);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    };

}
