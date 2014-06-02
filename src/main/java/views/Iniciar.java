package views;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Iniciar {

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

	}
}
