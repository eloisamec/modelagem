package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class UI {

	public JFrame mainFrame;
	public static JTextArea textAreaResultado = null;
	public static JButton buttonAnalisarSimulaoSelecionada;
	public static JList listaEventos;
	public static DecimalFormat formaterDecimal = new DecimalFormat("#.####");
	public static DecimalFormat formaterDecimalIteracoes = new DecimalFormat();
	private JTextField textFieldNome;
	private JButton buttonGerarEstatisticas;
	private JButton buttonExcluirSimulacaoSelecionada;
	public static JLabel labelIteracoes;
	static JButton buttonGerarGraficoDistancia;
	private JTextField textFieldNomeC1;
	private JTextField textFieldCanaisC1;
	private JTextField textFieldNomeC2;
	private JTextField textFieldCanaisC2;
	private JTextField textFieldConstante;
	private JTextField textFieldNormalMax;
	private JTextField textFieldNormalMin;
	
	
	public UI() {
		initialize();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setTitle("Projeto e programa\u00E7\u00E3o de um simulador em linguagem de propósito geral");
		mainFrame.setBounds(100, 100, 1100, 657);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		mainFrame.setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem menuNovo = new JMenuItem("Novo");
		menuNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((JOptionPane.showConfirmDialog(null, "Iniciar nova sess\u00E3o?", "Iniciar", 1)) == 0) {
					//eventos = new ArrayList<Eventos>();
					listaEventos.clearSelection();
					listaEventos.updateUI();
					textAreaResultado.setText("");
					//Simulador.numeroTotalIteracoes = 0;
					//Simulador.id = 1;
					//labelIteracoes.setText("0/2.000.000 itera\u00E7\u00F5es.");
				}
			}
		});
		mnArquivo.add(menuNovo);
		
		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mnArquivo.add(mntmSalvar);
		
		JMenuItem mntmCarregar = new JMenuItem("Carregar");
		mnArquivo.add(mntmCarregar);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnArquivo.add(mntmSair);
		
		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);
		
		JMenuItem menu_help = new JMenuItem("Simulador de Propósito Geral");
		menu_help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String about = "Projeto e programação de um simulador em linguagem de propósito geral: Simulador de chamadas.\n\nAlunos:\nMaria Eloisa Costa.\nMathias Antonio Mortari.";
				JOptionPane.showMessageDialog(null, about, "Simulador", 1);
			}
		});
		mnSobre.add(menu_help);
		mainFrame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 6, 457, 591);
		mainFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(10, 11, 437, 569);
		panel.add(scrollPane_1);

		textAreaResultado = new JTextArea();
		textAreaResultado.setForeground(new Color(0, 0, 205));
		textAreaResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaResultado.setEditable(false);
		scrollPane_1.setViewportView(textAreaResultado);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Simulador de Chamadas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(473, 6, 611, 591);
		mainFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(10, 22, 591, 162);
		panel_1.add(scrollPane);

		listaEventos = new JList();
		listaEventos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setViewportView(listaEventos);

		listaEventos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		listaEventos.setModel(new javax.swing.AbstractListModel() {
			private static final long serialVersionUID = 1L;

			public int getSize() {
				return 0;//simulacoes.size();
			}

			public Object getElementAt(int i) {
				return 0;//simulacoes.get(i).toString();
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Simula\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 285, 591, 295);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		final JButton buttonSimulacao = new JButton("Criar Nova Simula\u00E7\u00E3o com os Seguintes Par\u00E2metros:");
		buttonSimulacao.setBounds(149, 11, 289, 23);
		panel_2.add(buttonSimulacao);
		buttonSimulacao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonSimulacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				if (Simulador.numeroTotalIteracoes < 2000000) {
//					textFieldIteracoes.setText(filter(textFieldIteracoes.getText()));
//					int iteracoes = Integer.parseInt(textFieldIteracoes.getText());
//					if (iteracoes > 500) {
//						iteracoes = 500;
//						textFieldIteracoes.setText(500 + "");
//					}
//					if (iteracoes < 5) {
//						iteracoes = 5;
//						textFieldIteracoes.setText(5 + "");
//					}
//
//					Simulador sim = Simulador.iniciarSimulacao(iteracoes, textFieldNome.getText());
//					textFieldNome.setText("Simula\u00E7\u00E3o " + Simulador.id);
//					simulacoes.add(sim);
//					listaEventos.updateUI();
//					listaEventos.setSelectedIndex(simulacoes.size() - 1);
//					listaEventos.ensureIndexIsVisible(simulacoes.size() - 1);
//					buttonAnalisarSimulaoSelecionada.doClick();
//					labelIteracoes.setText(formaterDecimalIteracoes.format(Simulador.numeroTotalIteracoes) + "/2.000.000 itera\u00E7\u00F5es.");
//					if (Simulador.numeroTotalIteracoes > 2000000)
//						labelIteracoes.setForeground(Color.RED);
//				}
			}
		});
		buttonSimulacao.setForeground(new Color(0, 100, 0));

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 43, 48, 14);
		panel_2.add(lblNome);
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));

		textFieldNome = new JTextField();
		textFieldNome.setBounds(68, 40, 124, 20);
		panel_2.add(textFieldNome);
		textFieldNome.setText("Simula\u00E7\u00E3o 1");
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldNome.setColumns(10);

		labelIteracoes = new JLabel("0/2.000.000 itera\u00E7\u00F5es.");
		labelIteracoes.setBounds(292, 43, 289, 14);
		panel_2.add(labelIteracoes);
		labelIteracoes.setFont(new Font("Tahoma", Font.PLAIN, 9));
		labelIteracoes.setHorizontalAlignment(SwingConstants.CENTER);
		
		final JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 68, 279, 216);
		panel_2.add(panel_6);
		panel_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "C\u00E9lula 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setLayout(null);
		
		JLabel c1Nome = new JLabel("Nome:");
		c1Nome.setBounds(16, 23, 38, 14);
		panel_6.add(c1Nome);
		c1Nome.setHorizontalAlignment(SwingConstants.RIGHT);
		c1Nome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textFieldNomeC1 = new JTextField();
		textFieldNomeC1.setBounds(58, 20, 66, 20);
		panel_6.add(textFieldNomeC1);
		textFieldNomeC1.setText("C1");
		textFieldNomeC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldNomeC1.setColumns(10);
		
		JLabel c1Canais = new JLabel("Canais:");
		c1Canais.setBounds(155, 23, 38, 14);
		panel_6.add(c1Canais);
		c1Canais.setHorizontalAlignment(SwingConstants.RIGHT);
		c1Canais.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textFieldCanaisC1 = new JTextField();
		textFieldCanaisC1.setBounds(203, 20, 66, 20);
		panel_6.add(textFieldCanaisC1);
		textFieldCanaisC1.setText("15");
		textFieldCanaisC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldCanaisC1.setColumns(10);
		
		JLabel lblDuracao = new JLabel("Duração:");
		lblDuracao.setBounds(10, 48, 44, 14);
		panel_6.add(lblDuracao);
		lblDuracao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuracao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textFieldConstante = new JTextField();
		textFieldConstante.setText("15");
		textFieldConstante.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldConstante.setColumns(10);
		textFieldConstante.setBounds(58, 70, 66, 20);
		panel_6.add(textFieldConstante);
		
		final JLabel lblValor = new JLabel("Valor:");
		lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblValor.setBounds(26, 73, 28, 14);
		panel_6.add(lblValor);
		
		textFieldNormalMax = new JTextField();
		textFieldNormalMax.setText("10");
		textFieldNormalMax.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldNormalMax.setColumns(10);
		textFieldNormalMax.setBounds(127, 70, 66, 20);
		panel_6.add(textFieldNormalMax);
		textFieldNormalMax.setVisible(false);
		
		textFieldNormalMin = new JTextField();
		textFieldNormalMin.setText("2");
		textFieldNormalMin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldNormalMin.setColumns(10);
		textFieldNormalMin.setBounds(58, 70, 66, 20);
		panel_6.add(textFieldNormalMin);
		textFieldNormalMin.setVisible(false);
		
		final JLabel lblValores = new JLabel("Valores:");
		lblValores.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValores.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblValores.setBounds(16, 73, 39, 14);
		panel_6.add(lblValores);
		lblValores.setVisible(false);
		
		final JLabel labelMinimo = new JLabel("mínimo");
		labelMinimo.setHorizontalAlignment(SwingConstants.RIGHT);
		labelMinimo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelMinimo.setBounds(68, 98, 32, 14);
		panel_6.add(labelMinimo);
		labelMinimo.setVisible(false);
		
		final JLabel labelMaximo = new JLabel("máximo");
		labelMaximo.setHorizontalAlignment(SwingConstants.RIGHT);
		labelMaximo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelMaximo.setBounds(137, 98, 36, 14);
		panel_6.add(labelMaximo);
		labelMaximo.setVisible(false);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(58, 45, 117, 20);
		panel_6.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Constante", "Normal", "Triangular", "Uniforme", "Exponencial"}));
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (comboBox.getSelectedItem().toString().equals("Constante")) {
					textFieldConstante.setVisible(true);
					textFieldNormalMax.setVisible(false);
					textFieldNormalMin.setVisible(false);
					lblValor.setVisible(true);
					lblValores.setVisible(false);
					labelMinimo.setVisible(false);
					labelMaximo.setVisible(false);
					
				} else if (comboBox.getSelectedItem().toString().equals("Normal")) {
					textFieldConstante.setVisible(false);
					textFieldNormalMax.setVisible(true);
					textFieldNormalMin.setVisible(true);
					lblValor.setVisible(false);
					lblValores.setVisible(true);
					labelMinimo.setVisible(true);
					labelMaximo.setVisible(true);
					
				} else if (comboBox.getSelectedItem().toString().equals("Triangular")) {
				
				} else if (comboBox.getSelectedItem().toString().equals("Uniforme")) {
					
				} else if (comboBox.getSelectedItem().toString().equals("Exponencial")) {
					
				}
			}
		});
		
		JLabel lblTipoDeChamada = new JLabel("Tipo de Chamada:");
		lblTipoDeChamada.setBounds(10, 148, 87, 14);
		panel_6.add(lblTipoDeChamada);
		lblTipoDeChamada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeChamada.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(307, 68, 274, 216);
		panel_2.add(panel_7);
		panel_7.setLayout(null);
		panel_7.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "C\u00E9lula 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel c2Nome = new JLabel("Nome:");
		c2Nome.setHorizontalAlignment(SwingConstants.RIGHT);
		c2Nome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		c2Nome.setBounds(10, 23, 38, 14);
		panel_7.add(c2Nome);
		
		textFieldNomeC2 = new JTextField();
		textFieldNomeC2.setText("C2");
		textFieldNomeC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldNomeC2.setColumns(10);
		textFieldNomeC2.setBounds(58, 20, 66, 20);
		panel_7.add(textFieldNomeC2);
		
		JLabel c2Canais = new JLabel("Canais:");
		c2Canais.setHorizontalAlignment(SwingConstants.RIGHT);
		c2Canais.setFont(new Font("Tahoma", Font.PLAIN, 11));
		c2Canais.setBounds(150, 23, 38, 14);
		panel_7.add(c2Canais);
		
		textFieldCanaisC2 = new JTextField();
		textFieldCanaisC2.setText("30");
		textFieldCanaisC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldCanaisC2.setColumns(10);
		textFieldCanaisC2.setBounds(198, 20, 66, 20);
		panel_7.add(textFieldCanaisC2);
		
		JLabel label = new JLabel("Duração:");
		label.setBounds(10, 51, 44, 14);
		panel_7.add(label);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(64, 48, 117, 20);
		panel_7.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Constante", "Normal", "Triangular", "Uniforme", "Exponencial"}));
		
		JLabel label_1 = new JLabel("Tipo de Chamada:");
		label_1.setBounds(21, 110, 87, 14);
		panel_7.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Edi\u00E7\u00E3o e An\u00E1lise", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 195, 296, 91);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		buttonAnalisarSimulaoSelecionada = new JButton("Analisar Simula\u00E7\u00E3o Selecionada");
		buttonAnalisarSimulaoSelecionada.setBounds(10, 21, 276, 23);
		panel_3.add(buttonAnalisarSimulaoSelecionada);
		buttonAnalisarSimulaoSelecionada.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonAnalisarSimulaoSelecionada.setForeground(Color.BLUE);

		buttonExcluirSimulacaoSelecionada = new JButton("Excluir Simula\u00E7\u00E3o Selecionada");
		buttonExcluirSimulacaoSelecionada.setBounds(10, 55, 276, 23);
		panel_3.add(buttonExcluirSimulacaoSelecionada);
		buttonExcluirSimulacaoSelecionada.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonExcluirSimulacaoSelecionada.setForeground(Color.BLUE);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Gr\u00E1ficos e Estat\u00EDsticas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(305, 195, 296, 91);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		buttonGerarGraficoDistancia = new JButton("Gerar Gr\u00E1fico de Dist\u00E2ncia");
		buttonGerarGraficoDistancia.setBounds(10, 21, 275, 23);
		panel_4.add(buttonGerarGraficoDistancia);
		buttonGerarGraficoDistancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = listaEventos.getSelectedIndex();
				if (index == -1)
					JOptionPane.showMessageDialog(null, "Nenhuma Simula\u00E7\u00E3o est\u00E1 Selecionada!", "Erro!", 1);
//				else {
//					new GraficoDistancia(simulacoes.get(index));
//				}
			}
		});
		buttonGerarGraficoDistancia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonGerarGraficoDistancia.setForeground(new Color(128, 0, 0));
		buttonGerarGraficoDistancia.setName("Create GR");

		buttonGerarEstatisticas = new JButton("Gerar Estatísticas");
		buttonGerarEstatisticas.setBounds(10, 55, 275, 23);
		panel_4.add(buttonGerarEstatisticas);
		buttonGerarEstatisticas.setName("Gerar Estat\u00EDsticas");
		buttonGerarEstatisticas.setForeground(new Color(128, 0, 0));
		buttonGerarEstatisticas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonGerarEstatisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				if (simulacoes.size() <= 1)
//					JOptionPane.showMessageDialog(null, "Devem existir pelo menos duas simula\u00E7\u00F5es!", "Erro!", 1);
//				else {
//					new Estatisticas();
//				}
			}
		});
	}

	private String filter(String str) {
		String filtered = "";

		for (int i = 0; i < str.length(); i++)
			if (Character.isDigit(str.charAt(i)))
				filtered += str.charAt(i);

		return filtered;
	}
}
