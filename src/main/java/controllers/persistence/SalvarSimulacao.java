package controllers.persistence;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import views.MainInterface;

public class SalvarSimulacao {

	private static double x;
	private static double y;
	private static Dimension screen;

	public SalvarSimulacao() {
		screen = Toolkit.getDefaultToolkit().getScreenSize();
		x = screen.getWidth();
		y = screen.getHeight();
		this.inicializarUI();
	}

	private void inicializarUI() {
		final JFrame frameSalvar = new JFrame();
		frameSalvar.setResizable(false);
		frameSalvar.setSize(new Dimension((int) (x * 0.5), (int) (y * 0.6)));
		frameSalvar.setLocationRelativeTo(null);

		final JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Simulacoes", "simcco");
		fileChooser.setFileFilter(filtro);
		fileChooser.setApproveButtonText("Salvar");
		fileChooser.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String comando = e.getActionCommand();

				if (comando.equals("ApproveSelection")) {
					try {
						File arquivo = fileChooser.getSelectedFile();
						if (arquivo.exists()) {
							int resultado = JOptionPane.showConfirmDialog(null, "Deseja sobrescrever o arquivo?",
									"Arquivo j\u00E1 existente", JOptionPane.YES_NO_CANCEL_OPTION);
							switch (resultado) {
							case JOptionPane.YES_OPTION:
								SalvarSimulacao.this.salvar(arquivo);
								frameSalvar.setVisible(false);
								return;
							case JOptionPane.NO_OPTION:
								return;
							case JOptionPane.CLOSED_OPTION:
								return;
							case JOptionPane.CANCEL_OPTION:
								return;
							}
						} else {
							SalvarSimulacao.this.salvar(fileChooser.getSelectedFile());
							frameSalvar.setVisible(false);
						}
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				} else if (comando.equals("CancelSelection")) {
					frameSalvar.setVisible(false);
				}
			}
		});

		frameSalvar.add(fileChooser);
		frameSalvar.setVisible(true);
	}

	private void salvar(File file) throws IOException {
		if (!file.getName().endsWith(".simcco")) {
			file = new File(file.getAbsolutePath() + ".simcco");
		}

		FileOutputStream fileStream = new FileOutputStream(file);
		ObjectOutputStream os = new ObjectOutputStream(fileStream);
		try {
			os.writeObject(MainInterface.simulacoes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		os.close();
		return;
	}
}
