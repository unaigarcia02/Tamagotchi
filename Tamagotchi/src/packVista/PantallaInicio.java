package packVista;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packModelo.Juego;
import packModelo.Jugador;
import packModelo.ListaJugadores;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PantallaInicio extends JFrame implements Observer {

	private static PantallaInicio pantallaInicio = null;
	private JPanel contentPane;
	private JPanel panelArriba;
	private JLabel lblImagen;
	private JPanel panelMedio;
	private JLabel lblNombre;
	private JTextField textFieldNombre;
	private JButton btnPlay;
	private JButton btnExit;
	private JPanel panelAbajo;
	private JPanel panelLeaderBoard;
	private JLabel lblLeaderBoard;
	private JPanel panelFotos;
	private JPanel panelTitulos;
	private JLabel lblRank;
	private JLabel lblName;
	private JLabel lblScore;
	private JPanel panelRecords;
	private JPanel panelImagenPequeña;
	private JLabel lblImagenGrande;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblImagenPequeña;
	private JLabel lbl1st;
	private JLabel lblName1;
	private JLabel lblScore1;
	private JLabel lbl2nd;
	private JLabel lblName2;
	private JLabel lblScore2;
	private JLabel lbl3rd;
	private JLabel lblName3;
	private JLabel lblScore3;
	private JLabel lbl4th;
	private JLabel lblName4;
	private JLabel lblScore4;
	private JLabel lbl5th;
	private JLabel lblName5;
	private JLabel lblScore5;
	private ControladorBtnPlay controladorPlay;

	/**
	 * Create the frame.
	 */
	private PantallaInicio() {
		ListaJugadores.getListaJugadores().addObserver(this);
		Juego.getJuego().addObserver(this);

		setTitle("Tamagotchi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelArriba(), BorderLayout.NORTH);
		contentPane.setBackground(Color.BLACK);
		contentPane.add(getPanelMedio(), BorderLayout.CENTER);
		contentPane.add(getPanelAbajo(), BorderLayout.SOUTH);
		this.llenarRecords();
		setVisible(true);
	}

	public static PantallaInicio getPantallaInicio() {
		if (pantallaInicio == null) {
			pantallaInicio = new PantallaInicio();
		}
		return pantallaInicio;
	}

	private JPanel getPanelArriba() {
		if (panelArriba == null) {
			panelArriba = new JPanel();
			panelArriba.setBackground(Color.BLACK);
			panelArriba.add(getLblImagen());
		}
		return panelArriba;
	}

	private JLabel getLblImagen() {
		if (lblImagen == null) {
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/MainTitle.png"));
			lblImagen = new JLabel(img);
		}
		return lblImagen;
	}

	private JPanel getPanelMedio() {
		if (panelMedio == null) {
			panelMedio = new JPanel();
			panelMedio.setBackground(Color.BLACK);
			panelMedio.setLayout(new GridLayout(1, 4, 0, 0));
			panelMedio.add(getLblNombre());
			panelMedio.add(getTextFieldNombre());
			panelMedio.add(getBtnPlay());
			panelMedio.add(getBtnExit());
		}
		return panelMedio;
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Your Name:");
			lblNombre.setBackground(Color.BLACK);
			lblNombre.setForeground(Color.RED);
			lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNombre;
	}

	public JTextField getTextFieldNombre() {
		if (textFieldNombre == null) {
			textFieldNombre = new JTextField();
			textFieldNombre.setBackground(Color.GRAY);
			textFieldNombre.setForeground(Color.WHITE);
			textFieldNombre.setFont(textFieldNombre.getFont().deriveFont(Font.BOLD));
			textFieldNombre.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return textFieldNombre;
	}

	private JButton getBtnPlay() {
		if (btnPlay == null) {
			btnPlay = new JButton("play");
			btnPlay.setBackground(Color.RED);
			btnPlay.setForeground(Color.BLACK);
			btnPlay.addActionListener(this.getControladorBtnPlay());
		}
		return btnPlay;
	}

	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("exit");
			btnExit.setBackground(Color.RED);
			btnExit.setForeground(Color.BLACK);
			btnExit.addActionListener(this.getControladorBtnPlay());
		}
		return btnExit;
	}

	private JPanel getPanelAbajo() {
		if (panelAbajo == null) {
			panelAbajo = new JPanel();
			panelAbajo.setBackground(Color.BLACK);
			panelAbajo.setLayout(new GridLayout(1, 2, 0, 0));
			panelAbajo.add(getPanelLeaderBoard());
			panelAbajo.add(getPanelFotos());
		}
		return panelAbajo;
	}

	private JPanel getPanelLeaderBoard() {
		if (panelLeaderBoard == null) {
			panelLeaderBoard = new JPanel();
			panelLeaderBoard.setBackground(Color.BLACK);
			panelLeaderBoard.setLayout(new GridLayout(3, 1, 0, 0));
			panelLeaderBoard.add(getLblLeaderBoard());
			panelLeaderBoard.add(getPanelTitulos());
			panelLeaderBoard.add(getPanelRecords());
		}
		return panelLeaderBoard;
	}

	private JLabel getLblLeaderBoard() {
		if (lblLeaderBoard == null) {
			lblLeaderBoard = new JLabel("LeaderBoard");
			lblLeaderBoard.setVerticalAlignment(SwingConstants.BOTTOM);
			lblLeaderBoard.setHorizontalAlignment(SwingConstants.CENTER);
			lblLeaderBoard.setForeground(Color.WHITE);
		}
		return lblLeaderBoard;
	}

	private JPanel getPanelFotos() {
		if (panelFotos == null) {
			panelFotos = new JPanel();
			panelFotos.setBackground(Color.BLACK);
			panelFotos.setLayout(new GridLayout(0, 2, 0, 0));
			panelFotos.add(getPanelImagenPequeña());
			panelFotos.add(getLblImagenGrande());
		}
		return panelFotos;
	}

	private JPanel getPanelTitulos() {
		if (panelTitulos == null) {
			panelTitulos = new JPanel();
			panelTitulos.setBackground(Color.BLACK);
			panelTitulos.setLayout(new GridLayout(0, 3, 0, 0));
			panelTitulos.add(getLblRank());
			panelTitulos.add(getLblName());
			panelTitulos.add(getLblScore());
		}
		return panelTitulos;
	}

	private JLabel getLblRank() {
		if (lblRank == null) {
			lblRank = new JLabel("Rank");
			lblRank.setHorizontalAlignment(SwingConstants.CENTER);
			lblRank.setForeground(Color.RED);
		}
		return lblRank;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name");
			lblName.setForeground(Color.RED);
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblName;
	}

	private JLabel getLblScore() {
		if (lblScore == null) {
			lblScore = new JLabel("Score");
			lblScore.setHorizontalAlignment(SwingConstants.CENTER);
			lblScore.setForeground(Color.RED);
		}
		return lblScore;
	}

	private JPanel getPanelRecords() {
		if (panelRecords == null) {
			panelRecords = new JPanel();
			panelRecords.setLayout(new GridLayout(5, 3, 5, 5));
			panelRecords.setBackground(Color.BLACK);
			panelRecords.add(getLbl1st());
			panelRecords.add(getLblName1());
			panelRecords.add(getLblScore1());
			panelRecords.add(getLbl2nd());
			panelRecords.add(getLblName2());
			panelRecords.add(getLblScore2());
			panelRecords.add(getLbl3rd());
			panelRecords.add(getLblName3());
			panelRecords.add(getLblScore3());
			panelRecords.add(getLbl4th());
			panelRecords.add(getLblName4());
			panelRecords.add(getLblScore4());
			panelRecords.add(getLbl5th());
			panelRecords.add(getLblName5());
			panelRecords.add(getLblScore5());
		}
		return panelRecords;
	}

	private JPanel getPanelImagenPequeña() {
		if (panelImagenPequeña == null) {
			panelImagenPequeña = new JPanel();
			panelImagenPequeña.setBackground(Color.BLACK);
			panelImagenPequeña.setLayout(new GridLayout(2, 2, 0, 0));
			panelImagenPequeña.add(getLblNewLabel_1());
			panelImagenPequeña.add(getLblNewLabel_2());
			panelImagenPequeña.add(getLblNewLabel_3());
			panelImagenPequeña.add(getLblImagenPequeña());
		}
		return panelImagenPequeña;
	}

	private JLabel getLblImagenGrande() {
		if (lblImagenGrande == null) {
			lblImagenGrande = new JLabel("");
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/Marutchi1.png"));
			lblImagenGrande.setIcon(img);
		}
		return lblImagenGrande;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
		}
		return lblNewLabel_3;
	}

	private JLabel getLblImagenPequeña() {
		if (lblImagenPequeña == null) {
			lblImagenPequeña = new JLabel("");
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/gudetama1.gif"));
			lblImagenPequeña.setIcon(img);
		}
		return lblImagenPequeña;
	}

	private JLabel getLbl1st() {
		if (lbl1st == null) {
			lbl1st = new JLabel("1st");
			lbl1st.setForeground(Color.GREEN);
			lbl1st.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbl1st;
	}

	private JLabel getLblName1() {
		if (lblName1 == null) {
			lblName1 = new JLabel("");
			lblName1.setForeground(Color.GREEN);
			lblName1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblName1;
	}

	private JLabel getLblScore1() {
		if (lblScore1 == null) {
			lblScore1 = new JLabel("");
			lblScore1.setForeground(Color.GREEN);
			lblScore1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblScore1;
	}

	private JLabel getLbl2nd() {
		if (lbl2nd == null) {
			lbl2nd = new JLabel("2nd");
			lbl2nd.setForeground(Color.BLUE);
			lbl2nd.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbl2nd;
	}

	private JLabel getLblName2() {
		if (lblName2 == null) {
			lblName2 = new JLabel("");
			lblName2.setForeground(Color.BLUE);
			lblName2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblName2;
	}

	private JLabel getLblScore2() {
		if (lblScore2 == null) {
			lblScore2 = new JLabel("");
			lblScore2.setForeground(Color.BLUE);
			lblScore2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblScore2;
	}

	private JLabel getLbl3rd() {
		if (lbl3rd == null) {
			lbl3rd = new JLabel("3rd");
			lbl3rd.setForeground(Color.LIGHT_GRAY);
			lbl3rd.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbl3rd;
	}

	private JLabel getLblName3() {
		if (lblName3 == null) {
			lblName3 = new JLabel("");
			lblName3.setForeground(Color.LIGHT_GRAY);
			lblName3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblName3;
	}

	private JLabel getLblScore3() {
		if (lblScore3 == null) {
			lblScore3 = new JLabel("");
			lblScore3.setForeground(Color.LIGHT_GRAY);
			lblScore3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblScore3;
	}

	private JLabel getLbl4th() {
		if (lbl4th == null) {
			lbl4th = new JLabel("4th");
			lbl4th.setForeground(Color.PINK);
			lbl4th.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbl4th;
	}

	private JLabel getLblName4() {
		if (lblName4 == null) {
			lblName4 = new JLabel("");
			lblName4.setHorizontalAlignment(SwingConstants.CENTER);
			lblName4.setForeground(Color.PINK);
		}
		return lblName4;
	}

	private JLabel getLblScore4() {
		if (lblScore4 == null) {
			lblScore4 = new JLabel("");
			lblScore4.setHorizontalAlignment(SwingConstants.CENTER);
			lblScore4.setForeground(Color.PINK);
		}
		return lblScore4;
	}

	private JLabel getLbl5th() {
		if (lbl5th == null) {
			lbl5th = new JLabel("5th");
			lbl5th.setForeground(Color.MAGENTA);
			lbl5th.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbl5th;
	}

	private JLabel getLblName5() {
		if (lblName5 == null) {
			lblName5 = new JLabel("");
			lblName5.setForeground(Color.MAGENTA);
			lblName5.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblName5;
	}

	private JLabel getLblScore5() {
		if (lblScore5 == null) {
			lblScore5 = new JLabel("");
			lblScore5.setHorizontalAlignment(SwingConstants.CENTER);
			lblScore5.setForeground(Color.MAGENTA);
		}
		return lblScore5;
	}

	private void llenarRecords() {
		for (int i = 0; i < 5; i++) {
			if (i < ListaJugadores.getListaJugadores().getLista().size()) {
				Jugador jg = ListaJugadores.getListaJugadores().getLista().get(i);
				if (jg != null) {
					switch (i) {
						case 0:
							lblName1.setText(jg.getNombre());
							lblScore1.setText(String.valueOf(jg.getScore()));
							break;
						case 1:
							lblName2.setText(jg.getNombre());
							lblScore2.setText(String.valueOf(jg.getScore()));
							break;
						case 2:
							lblName3.setText(jg.getNombre());
							lblScore3.setText(String.valueOf(jg.getScore()));
							break;
						case 3:
							lblName4.setText(jg.getNombre());
							lblScore4.setText(String.valueOf(jg.getScore()));
							break;
						case 4:
							lblName5.setText(jg.getNombre());
							lblScore5.setText(String.valueOf(jg.getScore()));
							break;
					}
				}
			}
		}
	}

	private ControladorBtnPlay getControladorBtnPlay() {
		if (controladorPlay == null) {
			controladorPlay = new ControladorBtnPlay();
		}
		return controladorPlay;
	}

	private class ControladorBtnPlay implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (arg0.getSource().equals(btnPlay)) {
				Juego.getJuego().iniciarPartida(getTextFieldNombre().getText());
			}
		}

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg0 instanceof ListaJugadores) {// TODO Auto-generated method stub
			if (arg1 instanceof Jugador[]) {
				Jugador[] jugadores = (Jugador[]) arg1;
				for (int i = 0; i < jugadores.length; i++) {
					Jugador jugador = jugadores[i];
					if (jugador != null) {
						switch (i) {
							case 0:
								getLblName1().setText(jugador.getNombre());
								getLblScore1().setText(String.valueOf(jugador.getScore()));
								break;
							case 1:
								getLblName2().setText(jugador.getNombre());
								getLblScore2().setText(String.valueOf(jugador.getScore()));
								break;
							case 2:
								getLblName3().setText(jugador.getNombre());
								getLblScore3().setText(String.valueOf(jugador.getScore()));
								break;
							case 3:
								getLblName4().setText(jugador.getNombre());
								getLblScore4().setText(String.valueOf(jugador.getScore()));
								break;
							case 4:
								getLblName5().setText(jugador.getNombre());
								getLblScore5().setText(String.valueOf(jugador.getScore()));
								break;
						}
					}
				}
			}
		}
		if (arg0 instanceof Juego) {
			PantallaPrincipal.getPantalla().setVisible(true);
			this.setVisible(false);
		}
	}
}
