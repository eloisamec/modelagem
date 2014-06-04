package controllers.persistence;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import models.Simulacao;
import views.MainInterface;

public class CarregarSimulacao {

	private static double x;
	private static double y;
	private static Dimension screen;

	public CarregarSimulacao() {
		screen = Toolkit.getDefaultToolkit().getScreenSize();
		x = screen.getWidth();
		y = screen.getHeight();
		this.inicializarUI();
	}

	private void inicializarUI() {
		final JFrame frameCarregar = new JFrame();
		frameCarregar.setSize(new Dimension((int) (x * 0.5), (int) (y * 0.6)));
		frameCarregar.setLocationRelativeTo(null);

		final JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Simulacoes", "simcco");
		fileChooser.setFileFilter(filtro);
		fileChooser.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String comando = e.getActionCommand();

				if (comando.equals("ApproveSelection")) {
					try {
						CarregarSimulacao.this.carregar(fileChooser.getSelectedFile());
						frameCarregar.setVisible(false);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				} else if (comando.equals("CancelSelection")) {
					frameCarregar.setVisible(false);
				}

			}
		});

		frameCarregar.add(fileChooser);
		frameCarregar.setVisible(true);
	}

	@SuppressWarnings("unchecked")
	private void carregar(File file) throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream oInputStream = new ObjectInputStream(fileInputStream);
		Object lista = oInputStream.readObject();
		MainInterface.simulacoes = (ArrayList<Simulacao>) lista;
		MainInterface.listaSimulacoesComponent.updateUI();
		MainInterface.listaSimulacoesComponent.setSelectedIndex(0);
		oInputStream.close();
	}
}
