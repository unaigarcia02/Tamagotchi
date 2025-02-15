package packVista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packModelo.Minijuego;
import packModelo.Partida;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PantallaTamaDigOut extends JFrame implements Observer {

	private static PantallaTamaDigOut pantalla = null;
	private JPanel contentPane;
	private JPanel panelArriba;
	private JLabel lblEvolucion;
	private JPanel panel;
	private JButton btnExit;
	private JLabel lblScore;
	private JLabel lblPuntos;
	private JPanel panelMedio;
	private JLabel lblTextoAbajo;
	private ControladorMovimiento controladorMovimiento = null;

	/**
	 * Create the frame.
	 */
	private PantallaTamaDigOut() {
		Partida.getPartida().addObserver(this);
		Minijuego.getMinijuego().iniciarTablero();
		for(int i = 0; i < Minijuego.getMinijuego().getListaBloques().size(); i++){
			PanelMinijuego pM = new PanelMinijuego(i);
			Minijuego.getMinijuego().getListaBloques().get(i).addObserver(pM);
			Minijuego.getMinijuego().getListaBloques().get(i).setDatos();
			getPanelMedio().add(pM);
			pM.setOpaque(true);
		}
		Minijuego.getMinijuego().iniciarMinijuego();

		setTitle("TamaDigOut");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelArriba(), BorderLayout.NORTH);
		contentPane.add(getPanelMedio(), BorderLayout.CENTER);
		contentPane.add(getLblTextoAbajo(), BorderLayout.SOUTH);

		addKeyListener(getControladorMovimiento());
		setFocusable(true);

	}

	public static PantallaTamaDigOut geTamaDigOut() {
		if (pantalla == null) {
			pantalla = new PantallaTamaDigOut();
		}
		return pantalla;
	}

	private JPanel getPanelArriba() {
		if (panelArriba == null) {
			panelArriba = new JPanel();
			panelArriba.setBackground(Color.BLACK);
			panelArriba.setLayout(new GridLayout(1, 3, 0, 0));
			panelArriba.add(getLblEvolucion());
			panelArriba.add(getPanel());
			panelArriba.add(getBtnExit());
		}
		return panelArriba;
	}

	private JLabel getLblEvolucion() {
		if (lblEvolucion == null) {
			lblEvolucion = new JLabel("");
			lblEvolucion.setHorizontalAlignment(SwingConstants.CENTER);
			lblEvolucion.setForeground(Color.WHITE);
			lblEvolucion.setText(Partida.getPartida().getTamagotchi().getEvolucion());
		}
		return lblEvolucion;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.BLACK);
			panel.setLayout(new GridLayout(0, 2, 0, 0));
			panel.add(getLblScore());
			panel.add(getLblPuntos());
		}
		return panel;
	}

	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("exit");
			btnExit.setHorizontalAlignment(SwingConstants.TRAILING);
			btnExit.setBackground(Color.BLACK);
			btnExit.setBorder(null);
		}
		return btnExit;
	}

	private JLabel getLblScore() {
		if (lblScore == null) {
			lblScore = new JLabel("Score: ");
			lblScore.setForeground(Color.WHITE);
			lblScore.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblScore;
	}

	private JLabel getLblPuntos() {
		if (lblPuntos == null) {
			lblPuntos = new JLabel("");
			lblPuntos.setForeground(Color.CYAN);
		}
		return lblPuntos;
	}

	private JPanel getPanelMedio() {
		if (panelMedio == null) {
			panelMedio = new JPanel();
			panelMedio.setBackground(Color.BLACK);
			panelMedio.setLayout(new GridLayout(8, 12, 2, 2));
		}
		return panelMedio;
	}

	private JLabel getLblTextoAbajo() {
		if (lblTextoAbajo == null) {
			lblTextoAbajo = new JLabel("ooh.. Still Far Away!");
			lblTextoAbajo.setForeground(Color.WHITE);
			lblTextoAbajo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblTextoAbajo;
	}

	public void reset() {
		pantalla = null;
	}

	private ControladorMovimiento getControladorMovimiento() {
		if (controladorMovimiento == null) {
			controladorMovimiento = new ControladorMovimiento();
		}
		return controladorMovimiento;
	}

	private class ControladorMovimiento implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			Minijuego.getMinijuego().moverTamagotchi(Character.toString(arg0.getKeyChar()));

		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		if (arg0 instanceof Partida) {
			getLblPuntos().setText(arg1 + "");
		}
	}
}