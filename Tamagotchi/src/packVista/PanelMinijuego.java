package packVista;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import packModelo.Minijuego;
import packModelo.BloquesMinijuego.BloqueMinijuego;

public class PanelMinijuego extends JLabel implements Observer {

    private static final long serialVersionUID = 1L;
    private int pos;
    private ControladorDureza controladorDureza = null;

    /**
     * Create the panel.
     */
    public PanelMinijuego(int pPos) {
        this.pos = pPos;

        this.setOpaque(true);
        this.setBackground(Color.BLACK);
        this.addMouseListener(getControladorDureza());
    }

    private int getPos() {
        return this.pos;
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        // TODO Auto-generated method stub
        if (arg0 instanceof BloqueMinijuego) {
            if (arg1 instanceof Object[]) {
                Object[] array = (Object[]) arg1;
                if ((int) array[0] == 1) {
                    this.setBackground(Color.decode("#e28743"));
                } else if ((int) array[0] == 2) {
                    this.setBackground(Color.decode("#873e23"));
                } else if ((int) array[0] == 3) {
                    this.setBackground(Color.decode("#2c0500"));
                } else {
                    this.setBackground(Color.BLACK);
                    if ((boolean) array[1]) {
                        this.setIcon(new ImageIcon(this.getClass().getResource(
                                "/imagenes/MarutchiMini1.png")));
                    }else{
                        this.setIcon(null);
                    }

                    if ((boolean) array[2]) {
                        this.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/dorayakiSmall.png")));
                    }
                }
            }
        }
    }

    private ControladorDureza getControladorDureza(){
        if(controladorDureza == null){
            controladorDureza = new ControladorDureza();
        }
        return controladorDureza;
    }

    private class ControladorDureza implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
            // TODO Auto-generated method stub
            Minijuego.getMinijuego().getListaBloques().get(getPos()).quitarDureza();
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
