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
	private JTextField textFieldCanaisC1;
	private JTextField textFieldCanaisC2;
	private JTextField textFieldConstanteC1;
	private JTextField textFieldConstanteC2;
	private JTextField textFieldNormalMaxC1;
	private JTextField textFieldNormalMaxC2;
	private JTextField textFieldNormalMinC1;
	private JTextField textFieldNormalMinC2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textFieldExpoC2;
	private JTextField textFieldExpoC1;
	private JPanel panelCelula2;
	private JPanel panelCelula1;
	private JPanel panelTeCC2;
	private JPanel panelTeCC1;
	private JPanel panelDuracaoC1;
	private JPanel panelDuracaoC2;
	private JLabel lblSegundosC1;
	private JLabel lblSegundosC2;
	private JLabel labelCanaisC1;
	JComboBox comboBoxC1;
	JComboBox comboBoxC2;
	private JTextField textFieldTriaMaxC2;
	private JTextField textFieldTriaMaxC1;
	private JTextField textFieldTriaMedC2;
	private JTextField textFieldTriaMinC2;
	private JTextField textFieldTriaMedC1;
	private JTextField textFieldTriaMinC1;
	
	public UI() {
		initialize();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setTitle("Projeto e programa\u00E7\u00E3o de um simulador em linguagem de propósito geral");
		mainFrame.setBounds(100, 100, 1110, 657);
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

		JPanel panelDados = new JPanel();
		panelDados.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Simulador de Chamadas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDados.setBounds(473, 6, 621, 591);
		mainFrame.getContentPane().add(panelDados);
		panelDados.setLayout(null);

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(10, 22, 601, 162);
		panelDados.add(scrollPane);

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

		JPanel panelSimulacoes = new JPanel();
		panelSimulacoes.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Simula\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSimulacoes.setBounds(10, 285, 601, 295);
		panelDados.add(panelSimulacoes);
		panelSimulacoes.setLayout(null);

		final JButton buttonSimulacao = new JButton("Criar Nova Simula\u00E7\u00E3o com os Seguintes Par\u00E2metros:");
		buttonSimulacao.setBounds(160, 11, 289, 23);
		panelSimulacoes.add(buttonSimulacao);
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
		panelSimulacoes.add(lblNome);
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));

		textFieldNome = new JTextField();
		textFieldNome.setBounds(68, 40, 124, 20);
		panelSimulacoes.add(textFieldNome);
		textFieldNome.setText("Simula\u00E7\u00E3o 1");
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldNome.setColumns(10);

		labelIteracoes = new JLabel("0/2.000.000 itera\u00E7\u00F5es.");
		labelIteracoes.setBounds(184, 45, 289, 14);
		panelSimulacoes.add(labelIteracoes);
		labelIteracoes.setFont(new Font("Tahoma", Font.PLAIN, 9));
		labelIteracoes.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelCelula1 = new JPanel();
		panelCelula1.setBounds(10, 68, 202, 216);
		panelSimulacoes.add(panelCelula1);
		panelCelula1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "C\u00E9lula 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCelula1.setLayout(null);
		
		labelCanaisC1 = new JLabel("Número de Canais:");
		labelCanaisC1.setBounds(10, 20, 91, 14);
		panelCelula1.add(labelCanaisC1);
		labelCanaisC1.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCanaisC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textFieldCanaisC1 = new JTextField();
		textFieldCanaisC1.setBounds(127, 17, 66, 20);
		panelCelula1.add(textFieldCanaisC1);
		textFieldCanaisC1.setText("15");
		textFieldCanaisC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldCanaisC1.setColumns(10);
		
		panelTeCC1 = new JPanel();
		panelTeCC1.setBounds(10, 45, 183, 51);
		panelCelula1.add(panelTeCC1);
		panelTeCC1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Tempo entre Chegadas", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 11), null));
		panelTeCC1.setLayout(null);
		
		JLabel lblExpoC1 = new JLabel("EXPO( ");
		lblExpoC1.setBounds(10, 20, 33, 14);
		panelTeCC1.add(lblExpoC1);
		lblExpoC1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExpoC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textFieldExpoC1 = new JTextField();
		textFieldExpoC1.setBounds(39, 17, 33, 20);
		panelTeCC1.add(textFieldExpoC1);
		textFieldExpoC1.setText("15");
		textFieldExpoC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldExpoC1.setColumns(10);
		
		lblSegundosC1 = new JLabel(")   segundos");
		lblSegundosC1.setBounds(72, 20, 59, 14);
		panelTeCC1.add(lblSegundosC1);
		lblSegundosC1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSegundosC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		panelDuracaoC1 = new JPanel();
		panelDuracaoC1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Dura\u00E7\u00E3o das Chamadas", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 11), null));
		panelDuracaoC1.setBounds(10, 100, 183, 105);
		panelCelula1.add(panelDuracaoC1);
		panelDuracaoC1.setLayout(null);
		
		JLabel lblDuracaoC1 = new JLabel("Função:");
		lblDuracaoC1.setBounds(10, 22, 39, 14);
		panelDuracaoC1.add(lblDuracaoC1);
		lblDuracaoC1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuracaoC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		comboBoxC1 = new JComboBox();
		comboBoxC1.setBounds(56, 19, 117, 20);
		panelDuracaoC1.add(comboBoxC1);
		comboBoxC1.setModel(new DefaultComboBoxModel(new String[] {"Constante", "Normal", "Triangular", "Uniforme", "Exponencial"}));
		
		final JLabel lblValorC1 = new JLabel("Valor:");
		lblValorC1.setBounds(20, 47, 28, 14);
		panelDuracaoC1.add(lblValorC1);
		lblValorC1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textFieldNormalMinC1 = new JTextField();
		textFieldNormalMinC1.setBounds(56, 44, 28, 20);
		panelDuracaoC1.add(textFieldNormalMinC1);
		textFieldNormalMinC1.setText("2");
		textFieldNormalMinC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldNormalMinC1.setColumns(10);
		
		JLabel lblMinutosC1 = new JLabel("min.");
		lblMinutosC1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMinutosC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMinutosC1.setBounds(155, 47, 20, 14);
		panelDuracaoC1.add(lblMinutosC1);
		
		final JLabel lblValoresC1 = new JLabel("Valores:");
		lblValoresC1.setBounds(10, 47, 39, 14);
		panelDuracaoC1.add(lblValoresC1);
		lblValoresC1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValoresC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textFieldConstanteC1 = new JTextField();
		textFieldConstanteC1.setBounds(56, 44, 28, 20);
		panelDuracaoC1.add(textFieldConstanteC1);
		textFieldConstanteC1.setText("15");
		textFieldConstanteC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldConstanteC1.setColumns(10);
		
		textFieldNormalMaxC1 = new JTextField();
		textFieldNormalMaxC1.setBounds(88, 44, 28, 20);
		panelDuracaoC1.add(textFieldNormalMaxC1);
		textFieldNormalMaxC1.setText("10");
		textFieldNormalMaxC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldNormalMaxC1.setColumns(10);
		
		final JLabel labelMinimoC1 = new JLabel("mín.");
		labelMinimoC1.setBounds(60, 72, 20, 14);
		panelDuracaoC1.add(labelMinimoC1);
		labelMinimoC1.setHorizontalAlignment(SwingConstants.RIGHT);
		labelMinimoC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		final JLabel labelMaximoC1 = new JLabel("máx.");
		labelMaximoC1.setBounds(90, 72, 24, 14);
		panelDuracaoC1.add(labelMaximoC1);
		labelMaximoC1.setHorizontalAlignment(SwingConstants.RIGHT);
		labelMaximoC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textFieldTriaMaxC1 = new JTextField();
		textFieldTriaMaxC1.setColumns(10);
		textFieldTriaMaxC1.setBounds(120, 44, 28, 20);
		panelDuracaoC1.add(textFieldTriaMaxC1);
		
		final JLabel labelTriaMaxC1 = new JLabel("máx.");
		labelTriaMaxC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelTriaMaxC1.setBounds(124, 72, 24, 14);
		panelDuracaoC1.add(labelTriaMaxC1);
		
		final JLabel labelTriaMedC1 = new JLabel("med.");
		labelTriaMedC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelTriaMedC1.setBounds(88, 72, 24, 14);
		panelDuracaoC1.add(labelTriaMedC1);
		
		textFieldTriaMedC1 = new JTextField();
		textFieldTriaMedC1.setColumns(10);
		textFieldTriaMedC1.setBounds(88, 44, 28, 20);
		panelDuracaoC1.add(textFieldTriaMedC1);
		
		textFieldTriaMinC1 = new JTextField();
		textFieldTriaMinC1.setColumns(10);
		textFieldTriaMinC1.setBounds(56, 44, 28, 20);
		panelDuracaoC1.add(textFieldTriaMinC1);
		
		labelMaximoC1.setVisible(false);
		labelMinimoC1.setVisible(false);
		textFieldNormalMaxC1.setVisible(false);
		textFieldNormalMinC1.setVisible(false);
		textFieldTriaMaxC1.setVisible(false);
		textFieldTriaMedC1.setVisible(false);
		textFieldTriaMinC1.setVisible(false);
		lblValoresC1.setVisible(false);
		labelTriaMaxC1.setVisible(false);
		labelTriaMedC1.setVisible(false);;
		comboBoxC1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (comboBoxC1.getSelectedItem().toString().equals("Constante")) {
					textFieldConstanteC1.setVisible(true);
					textFieldNormalMaxC1.setVisible(false);
					textFieldNormalMinC1.setVisible(false);
					textFieldTriaMaxC1.setVisible(false);
					textFieldTriaMedC1.setVisible(false);
					textFieldTriaMinC1.setVisible(false);
					lblValorC1.setVisible(true);
					lblValoresC1.setVisible(false);
					labelMinimoC1.setVisible(false);
					labelMaximoC1.setVisible(false);
					labelTriaMaxC1.setVisible(false);
					labelTriaMedC1.setVisible(false);
					
				} else if (comboBoxC1.getSelectedItem().toString().equals("Normal")) {
					textFieldConstanteC1.setVisible(false);
					textFieldNormalMaxC1.setVisible(true);
					textFieldNormalMinC1.setVisible(true);
					textFieldTriaMaxC1.setVisible(false);
					textFieldTriaMedC1.setVisible(false);
					textFieldTriaMinC1.setVisible(false);
					lblValorC1.setVisible(false);
					lblValoresC1.setVisible(true);
					labelMinimoC1.setVisible(true);
					labelMaximoC1.setVisible(true);
					labelTriaMaxC1.setVisible(false);
					labelTriaMedC1.setVisible(false);
					
				} else if (comboBoxC1.getSelectedItem().toString().equals("Triangular")) {
					textFieldConstanteC1.setVisible(false);
					textFieldNormalMaxC1.setVisible(false);
					textFieldNormalMinC1.setVisible(false);
					textFieldTriaMaxC1.setVisible(true);
					textFieldTriaMedC1.setVisible(true);
					textFieldTriaMinC1.setVisible(true);
					lblValorC1.setVisible(false);
					lblValoresC1.setVisible(true);
					labelMaximoC1.setVisible(false);
					labelTriaMaxC1.setVisible(true);
					labelTriaMedC1.setVisible(true);
					
					
				} else if (comboBoxC1.getSelectedItem().toString().equals("Uniforme")) {
					textFieldConstanteC1.setVisible(false);
					textFieldNormalMaxC1.setVisible(false);
					textFieldNormalMinC1.setVisible(false);
					textFieldTriaMaxC1.setVisible(false);
					textFieldTriaMedC1.setVisible(false);
					textFieldTriaMinC1.setVisible(false);
					labelTriaMaxC1.setVisible(false);
					labelTriaMaxC1.setVisible(false);
					labelTriaMedC1.setVisible(false);
					
				} else if (comboBoxC1.getSelectedItem().toString().equals("Exponencial")) {
					textFieldConstanteC1.setVisible(false);
					textFieldNormalMaxC1.setVisible(false);
					textFieldNormalMinC1.setVisible(false);
					textFieldTriaMaxC1.setVisible(false);
					textFieldTriaMedC1.setVisible(false);
					textFieldTriaMinC1.setVisible(false);
					labelTriaMaxC1.setVisible(false);
					labelTriaMaxC1.setVisible(false);
					labelTriaMedC1.setVisible(false);
				}
			}
		});
		
		panelCelula2 = new JPanel();
		panelCelula2.setBounds(218, 68, 202, 216);
		panelSimulacoes.add(panelCelula2);
		panelCelula2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "C\u00E9lula 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCelula2.setLayout(null);
		
		JLabel labelCanalC2 = new JLabel("Número de Canais:");
		labelCanalC2.setBounds(10, 20, 91, 14);
		panelCelula2.add(labelCanalC2);
		labelCanalC2.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCanalC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textFieldCanaisC2 = new JTextField();
		textFieldCanaisC2.setBounds(127, 17, 66, 20);
		panelCelula2.add(textFieldCanaisC2);
		textFieldCanaisC2.setText("30");
		textFieldCanaisC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldCanaisC2.setColumns(10);
		
		panelTeCC2 = new JPanel();
		panelTeCC2.setBounds(10, 45, 183, 51);
		panelCelula2.add(panelTeCC2);
		panelTeCC2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Tempo entre Chegadas", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 11), null));
		panelTeCC2.setLayout(null);
		
		JLabel lblExpoC2 = new JLabel("EXPO( ");
		lblExpoC2.setBounds(10, 20, 33, 14);
		panelTeCC2.add(lblExpoC2);
		lblExpoC2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExpoC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textFieldExpoC2 = new JTextField();
		textFieldExpoC2.setBounds(39, 17, 33, 20);
		panelTeCC2.add(textFieldExpoC2);
		textFieldExpoC2.setText("15");
		textFieldExpoC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldExpoC2.setColumns(10);
		
		lblSegundosC2 = new JLabel(")   segundos");
		lblSegundosC2.setBounds(72, 20, 59, 14);
		panelTeCC2.add(lblSegundosC2);
		lblSegundosC2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSegundosC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		panelDuracaoC2 = new JPanel();
		panelDuracaoC2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Dura\u00E7\u00E3o das Chamadas", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 11), null));
		panelDuracaoC2.setBounds(10, 100, 183, 105);
		panelDuracaoC2.setLayout(null);
		panelCelula2.add(panelDuracaoC2);
		
		JLabel lblDuracaoC2 = new JLabel("Função:");
		lblDuracaoC2.setBounds(10, 22, 39, 14);
		panelDuracaoC2.add(lblDuracaoC2);
		lblDuracaoC2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuracaoC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		final JLabel lblValorC2 = new JLabel("Valor:");
		lblValorC2.setBounds(20, 47, 28, 14);
		panelDuracaoC2.add(lblValorC2);
		lblValorC2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textFieldNormalMinC2 = new JTextField();
		textFieldNormalMinC2.setBounds(56, 44, 28, 20);
		panelDuracaoC2.add(textFieldNormalMinC2);
		textFieldNormalMinC2.setText("2");
		textFieldNormalMinC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldNormalMinC2.setColumns(10);
		
		JLabel lblMinutosC2 = new JLabel("min.");
		lblMinutosC2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMinutosC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMinutosC2.setBounds(155, 47, 20, 14);
		panelDuracaoC2.add(lblMinutosC2);
		
		final JLabel lblValoresC2 = new JLabel("Valores:");
		lblValoresC2.setBounds(10, 47, 39, 14);
		panelDuracaoC2.add(lblValoresC2);
		lblValoresC2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValoresC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textFieldConstanteC2 = new JTextField();
		textFieldConstanteC2.setBounds(56, 44, 28, 20);
		panelDuracaoC2.add(textFieldConstanteC2);
		textFieldConstanteC2.setText("15");
		textFieldConstanteC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldConstanteC2.setColumns(10);
		
		textFieldNormalMaxC2 = new JTextField();
		textFieldNormalMaxC2.setBounds(88, 44, 28, 20);
		panelDuracaoC2.add(textFieldNormalMaxC2);
		textFieldNormalMaxC2.setText("10");
		textFieldNormalMaxC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldNormalMaxC2.setColumns(10);
		
		final JLabel labelMinimoC2 = new JLabel("mín.");
		labelMinimoC2.setBounds(60, 72, 20, 14);
		panelDuracaoC2.add(labelMinimoC2);
		labelMinimoC2.setHorizontalAlignment(SwingConstants.RIGHT);
		labelMinimoC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		final JLabel labelMaximoC2 = new JLabel("máx.");
		labelMaximoC2.setBounds(90, 72, 24, 14);
		panelDuracaoC2.add(labelMaximoC2);
		labelMaximoC2.setHorizontalAlignment(SwingConstants.RIGHT);
		labelMaximoC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelMaximoC2.setVisible(false);
		labelMinimoC2.setVisible(false);
		textFieldNormalMaxC2.setVisible(false);
		lblValoresC2.setVisible(false);
		textFieldNormalMinC2.setVisible(false);
		
		comboBoxC2 = new JComboBox();
		comboBoxC2.setBounds(56, 19, 117, 20);
		panelDuracaoC2.add(comboBoxC2);
		comboBoxC2.setModel(new DefaultComboBoxModel(new String[] {"Constante", "Normal", "Triangular", "Uniforme", "Exponencial"}));
		
		textFieldTriaMaxC2 = new JTextField();
		textFieldTriaMaxC2.setBounds(120, 44, 28, 20);
		panelDuracaoC2.add(textFieldTriaMaxC2);
		textFieldTriaMaxC2.setColumns(10);
		
		JLabel lblTriaMaxC2 = new JLabel("máx.");
		lblTriaMaxC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTriaMaxC2.setBounds(124, 72, 24, 14);
		panelDuracaoC2.add(lblTriaMaxC2);
		
		JLabel lblTriaMedC2 = new JLabel("med.");
		lblTriaMedC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTriaMedC2.setBounds(88, 72, 24, 14);
		panelDuracaoC2.add(lblTriaMedC2);
		
		textFieldTriaMedC2 = new JTextField();
		textFieldTriaMedC2.setColumns(10);
		textFieldTriaMedC2.setBounds(88, 44, 28, 20);
		panelDuracaoC2.add(textFieldTriaMedC2);
		
		textFieldTriaMinC2 = new JTextField();
		textFieldTriaMinC2.setColumns(10);
		textFieldTriaMinC2.setBounds(56, 44, 28, 20);
		panelDuracaoC2.add(textFieldTriaMinC2);
		
		comboBoxC2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (comboBoxC2.getSelectedItem().toString().equals("Constante")) {
					textFieldConstanteC2.setVisible(true);
					textFieldNormalMaxC2.setVisible(false);
					textFieldNormalMinC2.setVisible(false);
					lblValorC2.setVisible(true);
					lblValoresC2.setVisible(false);
					labelMinimoC2.setVisible(false);
					labelMaximoC2.setVisible(false);
					
				} else if (comboBoxC2.getSelectedItem().toString().equals("Normal")) {
					textFieldConstanteC2.setVisible(false);
					textFieldNormalMaxC2.setVisible(true);
					textFieldNormalMinC2.setVisible(true);
					lblValorC2.setVisible(false);
					lblValoresC2.setVisible(true);
					labelMinimoC2.setVisible(true);
					labelMaximoC2.setVisible(true);
					
				} else if (comboBoxC2.getSelectedItem().toString().equals("Triangular")) {
				
				} else if (comboBoxC2.getSelectedItem().toString().equals("Uniforme")) {
					
				} else if (comboBoxC2.getSelectedItem().toString().equals("Exponencial")) {
					
				}
			}
		});
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Probabilidades", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(423, 45, 168, 239);
		panelSimulacoes.add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setForeground(new Color(0, 100, 0));
		panel_7.setBounds(10, 21, 148, 106);
		panel_5.add(panel_7);
		panel_7.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "In\u00EDcio em C1", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 11), null));
		panel_7.setLayout(null);
		
		JLabel lblCC = new JLabel("C1 -> C1:");
		lblCC.setBounds(10, 24, 48, 14);
		panel_7.add(lblCC);
		lblCC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCC.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblCC_1 = new JLabel("C1 -> C2:");
		lblCC_1.setBounds(10, 49, 48, 14);
		panel_7.add(lblCC_1);
		lblCC_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCC_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblCFa = new JLabel("C1 -> FA:");
		lblCFa.setBounds(10, 74, 48, 14);
		panel_7.add(lblCFa);
		lblCFa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCFa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_2.setBounds(68, 71, 48, 20);
		panel_7.add(textField_2);
		textField_2.setText("20");
		textField_2.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_1.setBounds(68, 46, 48, 20);
		panel_7.add(textField_1);
		textField_1.setText("30");
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setBounds(68, 21, 48, 20);
		panel_7.add(textField);
		textField.setText("50");
		textField.setColumns(10);
		
		JLabel label = new JLabel("%");
		label.setBounds(121, 24, 11, 14);
		panel_7.add(label);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel label_1 = new JLabel("%");
		label_1.setBounds(121, 49, 11, 14);
		panel_7.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel label_2 = new JLabel("%");
		label_2.setBounds(121, 74, 11, 14);
		panel_7.add(label_2);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JPanel panel_8 = new JPanel();
		panel_8.setForeground(new Color(0, 100, 0));
		panel_8.setBounds(10, 127, 148, 101);
		panel_5.add(panel_8);
		panel_8.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "In\u00EDcio em C2", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 11), null));
		panel_8.setLayout(null);
		
		JLabel lblCC_2 = new JLabel("C2 -> C2:");
		lblCC_2.setBounds(10, 23, 48, 14);
		panel_8.add(lblCC_2);
		lblCC_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCC_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblCC_3 = new JLabel("C2 -> C1:");
		lblCC_3.setBounds(10, 48, 48, 14);
		panel_8.add(lblCC_3);
		lblCC_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCC_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblCFa_1 = new JLabel("C2 -> FA:");
		lblCFa_1.setBounds(10, 73, 48, 14);
		panel_8.add(lblCFa_1);
		lblCFa_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCFa_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_3.setBounds(68, 20, 48, 20);
		panel_8.add(textField_3);
		textField_3.setText("50");
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_4.setBounds(68, 45, 48, 20);
		panel_8.add(textField_4);
		textField_4.setText("30");
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_5.setBounds(68, 70, 48, 20);
		panel_8.add(textField_5);
		textField_5.setText("20");
		textField_5.setColumns(10);
		
		JLabel label_5 = new JLabel("%");
		label_5.setBounds(121, 73, 11, 14);
		panel_8.add(label_5);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel label_4 = new JLabel("%");
		label_4.setBounds(121, 48, 11, 14);
		panel_8.add(label_4);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel label_3 = new JLabel("%");
		label_3.setBounds(121, 23, 11, 14);
		panel_8.add(label_3);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Edi\u00E7\u00E3o e An\u00E1lise", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 195, 296, 91);
		panelDados.add(panel_3);
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
		panel_4.setBounds(316, 195, 296, 91);
		panelDados.add(panel_4);
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
