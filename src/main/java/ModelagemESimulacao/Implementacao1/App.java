package ModelagemESimulacao.Implementacao1;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import structure.Celula;
import structure.EventoControl;
import ui.UI;

public class App {
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
					UI window = new UI();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//get number of lines from ui
		Celula c1 = new Celula("c1", 15);
		Celula c2 = new Celula("c2", 30);
		EventoControl eventoControl = new EventoControl(c1, c2);
		
		eventoControl.fillListaEventos();
		
		eventoControl.run();
	
		
		

	}
}
