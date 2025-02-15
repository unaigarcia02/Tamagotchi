package packVista;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import packModelo.BloqueTresEnRaya;
import packModelo.TresEnRaya;
import packModelo.Fichas.FichaJugador;
import packModelo.Fichas.FichaTamagotchi;

public class PanelTresEnRaya extends JLabel implements Observer {

    private int pos;
    private ControladorPaneles controlador = null;

    public PanelTresEnRaya(int pPos) {
        this.pos = pPos;

        this.setBackground(Color.BLACK);
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.addMouseListener(getControladorPaneles());
        this.setOpaque(true);
    }

    private int getPos() {
        return this.pos;
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        // TODO Auto-generated method stub
        if (arg0 instanceof BloqueTresEnRaya) {
            if(arg1 instanceof FichaJugador){
                this.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/x.png")));
            }else if (arg1 instanceof FichaTamagotchi) {
                this.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/Marutchi1.png")));
            }else{
                this.setIcon(null);
            }
        }
    }

    private ControladorPaneles getControladorPaneles() {
        if (controlador == null) {
            controlador = new ControladorPaneles();
        }
        return controlador;
    }

    private class ControladorPaneles implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent arg0) {
            Object panel = arg0.getComponent();
            PanelTresEnRaya panelClicado = (PanelTresEnRaya) panel;
            // TODO Auto-generated method stub
            TresEnRaya.getTresEnRaya().ponerFicha(panelClicado.getPos());
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mousePressed(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

    }
}
