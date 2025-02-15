package packVista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packModelo.Partida;
import packModelo.Elementos.Elemento;
import packModelo.Elementos.Piruleta;
import packModelo.Elementos.Sopa;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PantallaPrincipal extends JFrame implements Observer {

	private static PantallaPrincipal pantalla = null;
	private JPanel contentPane;
	private JPanel panelDatos;
	private JLabel lblEvolucion;
	private JLabel lblScore;
	private JPanel panel;
	private JLabel lblPuntos;
	private JButton btnExit;
	private JPanel panelMedio;
	private JLabel lblFoto;
	private JPanel panelCorazones;
	private JLabel lblCorazon1;
	private JLabel lblCorazon2;
	private JLabel lblCorazon3;
	private JLabel lblCorazon4;
	private JPanel panelComida;
	private JLabel lblComida1;
	private JLabel lblComida2;
	private JLabel lblComida3;
	private JLabel lblComida4;
	private JPanel panelAbajo;
	private JPanel panelIzda;
	private JPanel panelDer;
	private JButton btnCandy;
	private JPanel panelPiruletas;
	private JLabel lblPir1;
	private JLabel lblPir2;
	private JLabel lblPir3;
	private JButton btnSoup;
	private JPanel panelCucharas;
	private JLabel lblCu1;
	private JLabel lblCu2;
	private JLabel lblCu3;
	private ControladorBtnExit controladorExit;
	private JPanel panelFotoKk;
	private JLabel lblFotoKk;
	private JPanel panelFotoTamagotchi;
	private JPanel panelFotoVirus;
	private JLabel lblFotoVirus;
	private JLabel lblFotoJeringuilla;
	private JLabel lblFotoPapel;
	private ControladorBotones controlador = null;
	private ControladorEstados controladorEstados;

	/**
	 * Create the frame.
	 */
	private PantallaPrincipal() {
		Partida.getPartida().addObserver(this);

		setTitle("Tamagotchi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelDatos(), BorderLayout.NORTH);
		contentPane.add(getPanelMedio(), BorderLayout.CENTER);
		contentPane.add(getPanelCorazones(), BorderLayout.WEST);
		contentPane.add(getPanelComida(), BorderLayout.EAST);
		contentPane.add(getPanelAbajo(), BorderLayout.SOUTH);
	}

	public static PantallaPrincipal getPantalla() {
		if (pantalla == null) {
			pantalla = new PantallaPrincipal();
		}
		return pantalla;
	}

	private JPanel getPanelDatos() {
		if (panelDatos == null) {
			panelDatos = new JPanel();
			panelDatos.setBackground(Color.BLACK);
			panelDatos.setLayout(new GridLayout(0, 3, 0, 0));
			panelDatos.add(getLblEvolucion());
			panelDatos.add(getPanel());
			panelDatos.add(getBtnExit());
		}
		return panelDatos;
	}

	private JLabel getLblEvolucion() {
		if (lblEvolucion == null) {
			lblEvolucion = new JLabel("Egg");
			lblEvolucion.setHorizontalAlignment(SwingConstants.CENTER);
			lblEvolucion.setForeground(Color.WHITE);
			lblEvolucion.setBackground(Color.BLACK);
		}
		return lblEvolucion;
	}

	private JLabel getLblScore() {
		if (lblScore == null) {
			lblScore = new JLabel("Score: ");
			lblScore.setHorizontalAlignment(SwingConstants.TRAILING);
			lblScore.setForeground(Color.WHITE);
		}
		return lblScore;
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

	private JLabel getLblPuntos() {
		if (lblPuntos == null) {
			lblPuntos = new JLabel("0");
			lblPuntos.setForeground(Color.CYAN);
		}
		return lblPuntos;
	}

	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("exit");
			btnExit.setHorizontalAlignment(SwingConstants.TRAILING);
			btnExit.setBackground(Color.BLACK);
			btnExit.setForeground(Color.GRAY);
			btnExit.setBorder(null);
			btnExit.setBorderPainted(false);
			btnExit.addActionListener(this.getControladorBtnExit());
		}
		return btnExit;
	}

	private JPanel getPanelMedio() {
		if (panelMedio == null) {
			panelMedio = new JPanel();
			panelMedio.setBackground(Color.BLACK);
			panelMedio.setLayout(new BorderLayout(0, 0));
			panelMedio.add(getPanelFotoKk(), BorderLayout.SOUTH);
			panelMedio.add(getPanelFotoTamagotchi(), BorderLayout.CENTER);
			panelMedio.add(getPanelFotoVirus(), BorderLayout.WEST);
		}
		return panelMedio;
	}

	private JLabel getLblFoto() {
		if (lblFoto == null) {
			lblFoto = new JLabel("");
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/Egg1.png"));
			lblFoto.setIcon(img);
		}
		return lblFoto;
	}

	private JPanel getPanelCorazones() {
		if (panelCorazones == null) {
			panelCorazones = new JPanel();
			panelCorazones.setBackground(Color.BLACK);
			panelCorazones.setLayout(new GridLayout(0, 1, 0, 0));
			panelCorazones.add(getLblCorazon1());
			panelCorazones.add(getLblCorazon2());
			panelCorazones.add(getLblCorazon3());
			panelCorazones.add(getLblCorazon4());
		}
		return panelCorazones;
	}

	private JLabel getLblCorazon1() {
		if (lblCorazon1 == null) {
			lblCorazon1 = new JLabel("");
			lblCorazon1.setBackground(Color.BLACK);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/heart.png"));
			lblCorazon1.setIcon(img);
		}
		return lblCorazon1;
	}

	private JLabel getLblCorazon2() {
		if (lblCorazon2 == null) {
			lblCorazon2 = new JLabel("");
			lblCorazon2.setBackground(Color.BLACK);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/heart.png"));
			lblCorazon2.setIcon(img);
		}
		return lblCorazon2;
	}

	private JLabel getLblCorazon3() {
		if (lblCorazon3 == null) {
			lblCorazon3 = new JLabel("");
			lblCorazon3.setBackground(Color.BLACK);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/heart.png"));
			lblCorazon3.setIcon(img);
		}
		return lblCorazon3;
	}

	private JLabel getLblCorazon4() {
		if (lblCorazon4 == null) {
			lblCorazon4 = new JLabel("");
			lblCorazon4.setBackground(Color.BLACK);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/heart.png"));
			lblCorazon4.setIcon(img);
		}
		return lblCorazon4;
	}

	private JPanel getPanelComida() {
		if (panelComida == null) {
			panelComida = new JPanel();
			panelComida.setBackground(Color.BLACK);
			panelComida.setLayout(new GridLayout(4, 1, 0, 0));
			panelComida.add(getLblComida1());
			panelComida.add(getLblComida2());
			panelComida.add(getLblComida3());
			panelComida.add(getLblComida4());
		}
		return panelComida;
	}

	private JLabel getLblComida1() {
		if (lblComida1 == null) {
			lblComida1 = new JLabel("");
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/hungry.png"));
			lblComida1.setIcon(img);
		}
		return lblComida1;
	}

	private JLabel getLblComida2() {
		if (lblComida2 == null) {
			lblComida2 = new JLabel("");
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/hungry.png"));
			lblComida2.setIcon(img);
		}
		return lblComida2;
	}

	private JLabel getLblComida3() {
		if (lblComida3 == null) {
			lblComida3 = new JLabel("");
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/hungry.png"));
			lblComida3.setIcon(img);
		}
		return lblComida3;
	}

	private JLabel getLblComida4() {
		if (lblComida4 == null) {
			lblComida4 = new JLabel("");
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/hungry.png"));
			lblComida4.setIcon(img);
		}
		return lblComida4;
	}

	private JPanel getPanelAbajo() {
		if (panelAbajo == null) {
			panelAbajo = new JPanel();
			panelAbajo.setBackground(Color.BLACK);
			panelAbajo.setLayout(new GridLayout(0, 2, 0, 0));
			panelAbajo.add(getPanelIzda());
			panelAbajo.add(getPanelDer());
		}
		return panelAbajo;
	}

	private JPanel getPanelIzda() {
		if (panelIzda == null) {
			panelIzda = new JPanel();
			panelIzda.setBackground(Color.BLACK);
			panelIzda.setLayout(new GridLayout(2, 1, 0, 0));
			panelIzda.add(getBtnCandy());
			panelIzda.add(getPanelPiruletas());
		}
		return panelIzda;
	}

	private JPanel getPanelDer() {
		if (panelDer == null) {
			panelDer = new JPanel();
			panelDer.setBackground(Color.BLACK);
			panelDer.setLayout(new GridLayout(2, 1, 0, 0));
			panelDer.add(getBtnSoup());
			panelDer.add(getPanelCucharas());
		}
		return panelDer;
	}

	private JButton getBtnCandy() {
		if (btnCandy == null) {
			btnCandy = new JButton("Candy");
			btnCandy.setHorizontalAlignment(SwingConstants.CENTER);
			btnCandy.setForeground(Color.WHITE);
			btnCandy.setBackground(Color.BLACK);
			btnCandy.setBorder(null);
			btnCandy.addActionListener(getControlador());
		}
		return btnCandy;
	}

	private JPanel getPanelPiruletas() {
		if (panelPiruletas == null) {
			panelPiruletas = new JPanel();
			panelPiruletas.setBackground(Color.BLACK);
			panelPiruletas.setLayout(new GridLayout(0, 3, 0, 0));
			panelPiruletas.add(getLblPir1());
			panelPiruletas.add(getLblPir2());
			panelPiruletas.add(getLblPir3());
			panelPiruletas.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			panelPiruletas.setEnabled(false);
		}
		return panelPiruletas;
	}

	private JLabel getLblPir1() {
		if (lblPir1 == null) {
			lblPir1 = new JLabel("");
			lblPir1.setBackground(Color.BLACK);
		}
		return lblPir1;
	}

	private JLabel getLblPir2() {
		if (lblPir2 == null) {
			lblPir2 = new JLabel("");
			lblPir2.setBackground(Color.BLACK);
		}
		return lblPir2;
	}

	private JLabel getLblPir3() {
		if (lblPir3 == null) {
			lblPir3 = new JLabel("");
			lblPir3.setBackground(Color.BLACK);
		}
		return lblPir3;
	}

	private JButton getBtnSoup() {
		if (btnSoup == null) {
			btnSoup = new JButton("Soup");
			btnSoup.setHorizontalAlignment(SwingConstants.CENTER);
			btnSoup.setForeground(Color.WHITE);
			btnSoup.setBackground(Color.BLACK);
			btnSoup.setBorder(null);
			btnSoup.addActionListener(getControlador());
		}
		return btnSoup;
	}

	private JPanel getPanelCucharas() {
		if (panelCucharas == null) {
			panelCucharas = new JPanel();
			panelCucharas.setBackground(Color.BLACK);
			panelCucharas.setLayout(new GridLayout(1, 3, 0, 0));
			panelCucharas.add(getLblCu1());
			panelCucharas.add(getLblCu2());
			panelCucharas.add(getLblCu3());
			panelCucharas.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			panelCucharas.setEnabled(false);
		}
		return panelCucharas;
	}

	private JLabel getLblCu1() {
		if (lblCu1 == null) {
			lblCu1 = new JLabel("");
		}
		return lblCu1;
	}

	private JLabel getLblCu2() {
		if (lblCu2 == null) {
			lblCu2 = new JLabel("");
		}
		return lblCu2;
	}

	private JLabel getLblCu3() {
		if (lblCu3 == null) {
			lblCu3 = new JLabel("");
		}
		return lblCu3;
	}

	private JPanel getPanelFotoKk() {
		if (panelFotoKk == null) {
			panelFotoKk = new JPanel();
			panelFotoKk.setBackground(Color.BLACK);
			panelFotoKk.add(getLblFotoKk());
			panelFotoKk.add(getLblFotoPapel());
		}
		return panelFotoKk;
	}

	private JLabel getLblFotoKk() {
		if (lblFotoKk == null) {
			lblFotoKk = new JLabel("");
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/kk.png"));
			lblFotoKk.setIcon(img);
			lblFotoKk.setVisible(false);
			lblFotoKk.addMouseListener(getControladorEstados());
		}
		return lblFotoKk;
	}

	private JPanel getPanelFotoTamagotchi() {
		if (panelFotoTamagotchi == null) {
			panelFotoTamagotchi = new JPanel();
			panelFotoTamagotchi.setBackground(Color.BLACK);
			panelFotoTamagotchi.add(getLblFoto());
		}
		return panelFotoTamagotchi;
	}

	private JPanel getPanelFotoVirus() {
		if (panelFotoVirus == null) {
			panelFotoVirus = new JPanel();
			panelFotoVirus.setBackground(Color.BLACK);
			panelFotoVirus.add(getLblFotoVirus());
			panelFotoVirus.add(getLblFotoJeringuilla());
		}
		return panelFotoVirus;
	}

	private JLabel getLblFotoVirus() {
		if (lblFotoVirus == null) {
			lblFotoVirus = new JLabel("");
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/Virus.png"));
			lblFotoVirus.setIcon(img);
			lblFotoVirus.setVisible(false);
			lblFotoVirus.addMouseListener(getControladorEstados());
		}
		return lblFotoVirus;
	}

	private JLabel getLblFotoJeringuilla() {
		if (lblFotoJeringuilla == null) {
			lblFotoJeringuilla = new JLabel("");
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/shot.png"));
			lblFotoJeringuilla.setIcon(img);
			lblFotoJeringuilla.setVisible(false);
		}
		return lblFotoJeringuilla;
	}

	private JLabel getLblFotoPapel() {
		if (lblFotoPapel == null) {
			lblFotoPapel = new JLabel("");
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/paper.png"));
			lblFotoPapel.setIcon(img);
			lblFotoPapel.setVisible(false);
		}
		return lblFotoPapel;
	}

	public void reset() {
		pantalla = null;
	}

	private ControladorBtnExit getControladorBtnExit() {
		if (controladorExit == null) {
			controladorExit = new ControladorBtnExit();
		}
		return controladorExit;
	}

	private class ControladorBtnExit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (arg0.getSource().equals(btnExit)) {
				PantallaInicio.getPantallaInicio().setVisible(true);
				Partida.getPartida().terminarPartida(true);
				setVisible(false);
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		ImageIcon imgCorazonGris = new ImageIcon(this.getClass().getResource("/imagenes/CorazonGris.png"));
		ImageIcon imgCuencoGris = new ImageIcon(this.getClass().getResource("/imagenes/CuencoGris.png"));
		ImageIcon imgCorazonRojo = new ImageIcon(this.getClass().getResource("/imagenes/heart.png"));
		ImageIcon imgCuencoColor = new ImageIcon(this.getClass().getResource("/imagenes/hungry.png"));
		// TODO Auto-generated method stub
		if (arg0 instanceof Partida) {
			if (arg1 instanceof Object[]) {
				Object[] array1 = (Object[]) arg1;
				this.getLblPuntos().setText((int) array1[0] + "");
				if ((int) array1[1] <= 30) {
					getLblCorazon1().setIcon(imgCorazonGris);
				} else {
					getLblCorazon1().setIcon(imgCorazonRojo);
					getLblCorazon2().setIcon(imgCorazonRojo);
					getLblCorazon3().setIcon(imgCorazonRojo);
					getLblCorazon4().setIcon(imgCorazonRojo);
				}
				if ((int) array1[1] <= 20) {
					getLblCorazon2().setIcon(imgCorazonGris);
				} else {
					getLblCorazon2().setIcon(imgCorazonRojo);
					getLblCorazon3().setIcon(imgCorazonRojo);
					getLblCorazon4().setIcon(imgCorazonRojo);
				}
				if ((int) array1[1] <= 10) {
					getLblCorazon3().setIcon(imgCorazonGris);
				} else {
					getLblCorazon3().setIcon(imgCorazonRojo);
					getLblCorazon4().setIcon(imgCorazonRojo);
				}
				if ((int) array1[1] <= 0) {
					getLblCorazon4().setIcon(imgCorazonGris);
				} else {
					getLblCorazon4().setIcon(imgCorazonRojo);
				}

				if ((int) array1[2] <= 30) {
					getLblComida1().setIcon(imgCuencoGris);
				} else {
					getLblComida1().setIcon(imgCuencoColor);
					getLblComida2().setIcon(imgCuencoColor);
					getLblComida3().setIcon(imgCuencoColor);
					getLblComida4().setIcon(imgCuencoColor);
				}
				if ((int) array1[2] <= 20) {
					getLblComida2().setIcon(imgCuencoGris);
				} else {
					getLblComida2().setIcon(imgCuencoColor);
					getLblComida3().setIcon(imgCuencoColor);
					getLblComida4().setIcon(imgCuencoColor);
				}
				if ((int) array1[2] <= 10) {
					getLblComida3().setIcon(imgCuencoGris);
				} else {
					getLblComida3().setIcon(imgCuencoColor);
					getLblComida4().setIcon(imgCuencoColor);
				}
				if ((int) array1[2] <= 0) {
					getLblComida4().setIcon(imgCuencoGris);
				} else {
					getLblComida4().setIcon(imgCuencoColor);
				}
				if ((int) array1[1] >= 30 && (int) array1[2] >= 30) {
					ImageIcon imgTamagotchi = new ImageIcon(
							this.getClass().getResource("/imagenes/" + array1[3] + "1.png"));
					getLblFoto().setIcon(imgTamagotchi);
				} else if ((int) array1[1] >= 20 && (int) array1[2] >= 20) {
					ImageIcon imgTamagotchi = new ImageIcon(
							this.getClass().getResource("/imagenes/" + array1[3] + "2.png"));
					getLblFoto().setIcon(imgTamagotchi);
				} else if ((int) array1[1] >= 10 && (int) array1[2] >= 10) {
					ImageIcon imgTamagotchi = new ImageIcon(
							this.getClass().getResource("/imagenes/" + array1[3] + "3.png"));
					getLblFoto().setIcon(imgTamagotchi);
				} else {
					ImageIcon imgTamagotchi = new ImageIcon(
							this.getClass().getResource("/imagenes/" + array1[3] + "4.png"));
					getLblFoto().setIcon(imgTamagotchi);
				}

				getLblEvolucion().setText((String) array1[3]);
			}
			if (arg1 instanceof boolean[]) {
				boolean[] array2 = (boolean[]) arg1;
				if ((boolean) array2[0]) {
					getLblFotoKk().setVisible(true);
				} else {
					getLblFotoKk().setVisible(false);
					getLblFotoPapel().setVisible(false);
				}

				if ((boolean) array2[1]) {
					getLblFotoVirus().setVisible(true);
				} else {
					getLblFotoVirus().setVisible(false);
					getLblFotoJeringuilla().setVisible(false);
				}

				if ((boolean) array2[2]) {
					setVisible(false);
					PantallaTamaDigOut.geTamaDigOut().setVisible(true);
				}
				if ((boolean) array2[3]) {
					setVisible(false);
					PantallaTresEnRaya.gPantallaTresEnRaya().setVisible(true);
				}
			}

			if (arg1 instanceof ArrayList<?>) {
				ArrayList<?> arrayList = (ArrayList<?>) arg1;
				if (!arrayList.isEmpty() && arrayList.get(0) instanceof Elemento) {
					ArrayList<Elemento> elementos = (ArrayList<Elemento>) arrayList;
					actualizarImagenesElementos(elementos);
				} else {
					actualizarImagenesPiruletas(0);
					actualizarImagenesSopas(0);
				}
			}

		}
	}

	private void actualizarImagenesElementos(ArrayList<Elemento> elementos) {
		// Inicializamos contadores para cada tipo de elemento
		int countPiruleta = 0;
		int countSopa = 0;

		// Contamos cuántas veces aparece cada tipo de elemento en la lista
		for (Elemento elemento : elementos) {
			if (elemento instanceof Piruleta) {
				countPiruleta++;
			} else if (elemento instanceof Sopa) {
				countSopa++;
			}
		}

		// Actualizamos la cantidad de imágenes de cada tipo de elemento en la interfaz
		// gráfica
		actualizarImagenesPiruletas(countPiruleta);
		actualizarImagenesSopas(countSopa);
	}

	private void actualizarImagenesPiruletas(int cantidad) {
		ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/candy.png"));
		// Dependiendo de la cantidad de piruletas, actualizamos los JLabel
		// correspondientes
		switch (cantidad) {
			case 0:
				lblPir1.setIcon(null);
				lblPir2.setIcon(null);
				lblPir3.setIcon(null);
				break;
			case 1:
				lblPir1.setIcon(img);
				lblPir2.setIcon(null);
				lblPir3.setIcon(null);
				break;
			case 2:
				lblPir1.setIcon(img);
				lblPir2.setIcon(img);
				lblPir3.setIcon(null);
				break;
			case 3:
				lblPir1.setIcon(img);
				lblPir2.setIcon(img);
				lblPir3.setIcon(img);
				break;
		}
	}

	private void actualizarImagenesSopas(int cantidad) {
		ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/spoon.png"));
		// Dependiendo de la cantidad de piruletas, actualizamos los JLabel
		// correspondientes
		switch (cantidad) {
			case 0:
				lblCu1.setIcon(null);
				lblCu2.setIcon(null);
				lblCu3.setIcon(null);
				break;
			case 1:
				lblCu1.setIcon(img);
				lblCu2.setIcon(null);
				lblCu3.setIcon(null);
				break;
			case 2:
				lblCu1.setIcon(img);
				lblCu2.setIcon(img);
				lblCu3.setIcon(null);
				break;
			case 3:
				lblCu1.setIcon(img);
				lblCu2.setIcon(img);
				lblCu3.setIcon(img);
				break;
		}
	}

	private ControladorBotones getControlador() {
		if (controlador == null) {
			controlador = new ControladorBotones();
		}
		return controlador;
	}

	private class ControladorBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (arg0.getSource().equals(btnCandy)) {
				Partida.getPartida().addElemento(new Piruleta());
			} else if (arg0.getSource().equals(btnSoup)) {
				Partida.getPartida().addElemento(new Sopa());
			}
		}

	}

	private ControladorEstados getControladorEstados() {
		if (controladorEstados == null) {
			controladorEstados = new ControladorEstados();
		}
		return controladorEstados;
	}

	private class ControladorEstados implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if (arg0.getSource().equals(lblFotoVirus)) {
				getLblFotoJeringuilla().setVisible(true);
				Partida.getPartida().curar();
			} else if (arg0.getSource().equals(lblFotoKk)) {
				getLblFotoPapel().setVisible(true);
				Partida.getPartida().limpiar();
			}
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