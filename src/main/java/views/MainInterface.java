package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

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
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;

import models.Simulacao;
import controllers.Simulador;

@SuppressWarnings("rawtypes")
public class MainInterface {

	public JFrame mainFrame;
	public static JComboBox comboBoxC1;
	public static JComboBox comboBoxC2;
	public static JTextField textFieldC1C1ProbValue;
	public static JTextField textFieldC1C2ProbValue;
	public static JTextField textFieldC1FAProbValue;
	public static JTextField textFieldC2C2ProbValue;
	public static JTextField textFieldC2C1ProbValue;
	public static JTextField textFieldC2FAProbValue;
	public static JTextField textFieldCanaisC1;
	public static JTextField textFieldCanaisC2;
	public static JTextField textFieldExpoC2;
	public static JTextField textFieldExpoC1;
	public static JTextField textFieldMaxC2;
	public static JTextField textFieldMaxC1;
	public static JTextField textFieldMedC2;
	public static JTextField textFieldMinC2;
	public static JTextField textFieldMedC1;
	public static JTextField textFieldMinC1;
	public static JTextField textFieldDuracaoSimulacao;
	public static JTextArea textAreaResultado;
	public static JButton buttonAnalisarSimulaoSelecionada;
	public static JList listaSimulacoesComponent;
	public static DecimalFormat formaterDecimal = new DecimalFormat("#.####");
	public static DecimalFormat formaterDecimalIteracoes = new DecimalFormat();

	static JButton buttonGerarGraficos;

	private Thread simulador;
	private JTextField textFieldNome;
	private JButton buttonGerarEstatisticas;
	private JButton buttonExcluirSimulacaoSelecionada;
	private JPanel panelCelula2;
	private JPanel panelCelula1;
	private JPanel panelTeCC2;
	private JPanel panelTeCC1;
	private JPanel panelDuracaoC1;
	private JPanel panelDuracaoC2;
	private JLabel lblSegundosC1;
	private JLabel lblSegundosC2;
	private JLabel labelCanaisC1;
	public static JButton buttonPausarSimulacao;
	public static JButton buttonSimulacao;
	public static JSlider sliderVelocidadePasso;

	private static ArrayList<Simulacao> simulacoes = new ArrayList<Simulacao>();
	private static int id;

	public MainInterface() {
		id = 1;
		initialize();
	}

	@SuppressWarnings({ "unchecked" })
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
					simulacoes = new ArrayList<Simulacao>();
					listaSimulacoesComponent.clearSelection();
					listaSimulacoesComponent.updateUI();
					textAreaResultado.setText("");
					id = 1;
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
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(6, 6, 457, 591);
		mainFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPaneTextArea = new JScrollPane((Component) null);
		scrollPaneTextArea.setBounds(10, 11, 437, 569);
		panel.add(scrollPaneTextArea);

		textAreaResultado = new JTextArea();
		DefaultCaret caret = (DefaultCaret) textAreaResultado.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		textAreaResultado.setForeground(new Color(0, 0, 205));
		textAreaResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaResultado.setEditable(false);
		scrollPaneTextArea.setViewportView(textAreaResultado);

		JPanel panelDados = new JPanel();
		panelDados.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Simulador de Chamadas",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDados.setBounds(473, 6, 621, 591);
		mainFrame.getContentPane().add(panelDados);
		panelDados.setLayout(null);

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(10, 22, 601, 130);
		panelDados.add(scrollPane);

		listaSimulacoesComponent = new JList();
		listaSimulacoesComponent.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setViewportView(listaSimulacoesComponent);

		listaSimulacoesComponent.setFont(new Font("Tahoma", Font.PLAIN, 10));
		listaSimulacoesComponent.setModel(new javax.swing.AbstractListModel() {
			private static final long serialVersionUID = 1L;

			public int getSize() {
				return simulacoes.size();
			}

			public Object getElementAt(int i) {
				return simulacoes.get(i).toString();
			}
		});

		JPanel panelSimulacoes = new JPanel();
		panelSimulacoes.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Configura\u00E7\u00F5es",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSimulacoes.setBounds(10, 253, 601, 327);
		panelDados.add(panelSimulacoes);
		panelSimulacoes.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 215, 31, 14);
		panelSimulacoes.add(lblNome);
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));

		textFieldNome = new JTextField();
		textFieldNome.setBounds(51, 212, 124, 20);
		panelSimulacoes.add(textFieldNome);
		textFieldNome.setText("Simula\u00E7\u00E3o 1");
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldNome.setColumns(10);

		panelCelula1 = new JPanel();
		panelCelula1.setBounds(10, 20, 202, 184);
		panelSimulacoes.add(panelCelula1);
		panelCelula1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "C\u00E9lula 1", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
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
		panelTeCC1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Tempo entre Chegadas",
				TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 11), null));
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
		panelDuracaoC1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Dura\u00E7\u00E3o das Chamadas",
				TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 11), null));
		panelDuracaoC1.setBounds(10, 100, 183, 73);
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
		comboBoxC1.setModel(new DefaultComboBoxModel(new String[] { "Constante", "Normal", "Triangular", "Uniforme", "Exponencial" }));

		final JLabel lblValorC1 = new JLabel("Valor:");
		lblValorC1.setBounds(20, 47, 28, 14);
		panelDuracaoC1.add(lblValorC1);
		lblValorC1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorC1.setFont(new Font("Tahoma", Font.PLAIN, 11));

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

		textFieldMaxC1 = new JTextField();
		textFieldMaxC1.setText("7");
		textFieldMaxC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldMaxC1.setColumns(10);
		textFieldMaxC1.setBounds(120, 44, 28, 20);
		panelDuracaoC1.add(textFieldMaxC1);

		textFieldMedC1 = new JTextField();
		textFieldMedC1.setText("5");
		textFieldMedC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldMedC1.setColumns(10);
		textFieldMedC1.setBounds(88, 44, 28, 20);
		panelDuracaoC1.add(textFieldMedC1);
		textFieldMedC1.setVisible(false);

		textFieldMinC1 = new JTextField();
		textFieldMinC1.setText("3");
		textFieldMinC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldMinC1.setColumns(10);
		textFieldMinC1.setBounds(56, 44, 28, 20);
		panelDuracaoC1.add(textFieldMinC1);
		textFieldMinC1.setVisible(true);

		lblValoresC1.setVisible(false);
		textFieldMaxC1.setVisible(false);
		textFieldMedC1.setVisible(false);

		comboBoxC1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (comboBoxC1.getSelectedItem().toString().equals("Constante")) {
					textFieldMaxC1.setVisible(false);
					textFieldMedC1.setVisible(false);
					lblValorC1.setVisible(true);
					lblValoresC1.setVisible(false);

				} else if (comboBoxC1.getSelectedItem().toString().equals("Normal")) {
					textFieldMaxC1.setVisible(false);
					textFieldMedC1.setVisible(true);
					lblValorC1.setVisible(false);
					lblValoresC1.setVisible(true);

				} else if (comboBoxC1.getSelectedItem().toString().equals("Triangular")) {
					textFieldMaxC1.setVisible(true);
					textFieldMedC1.setVisible(true);
					lblValorC1.setVisible(false);
					lblValoresC1.setVisible(true);

				} else if (comboBoxC1.getSelectedItem().toString().equals("Uniforme")) {
					textFieldMaxC1.setVisible(false);
					textFieldMedC1.setVisible(true);
					lblValorC1.setVisible(false);
					lblValoresC1.setVisible(true);

				} else if (comboBoxC1.getSelectedItem().toString().equals("Exponencial")) {
					textFieldMaxC1.setVisible(false);
					textFieldMedC1.setVisible(false);
					lblValorC1.setVisible(true);
					lblValoresC1.setVisible(false);
				}
			}
		});

		panelCelula2 = new JPanel();
		panelCelula2.setBounds(218, 20, 202, 184);
		panelSimulacoes.add(panelCelula2);
		panelCelula2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "C\u00E9lula 2", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
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
		panelTeCC2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Tempo entre Chegadas",
				TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 11), null));
		panelTeCC2.setLayout(null);

		JLabel lblExpoC2 = new JLabel("EXPO( ");
		lblExpoC2.setBounds(10, 20, 33, 14);
		panelTeCC2.add(lblExpoC2);
		lblExpoC2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExpoC2.setFont(new Font("Tahoma", Font.PLAIN, 11));

		textFieldExpoC2 = new JTextField();
		textFieldExpoC2.setBounds(39, 17, 33, 20);
		panelTeCC2.add(textFieldExpoC2);
		textFieldExpoC2.setText("20");
		textFieldExpoC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldExpoC2.setColumns(10);

		lblSegundosC2 = new JLabel(")   segundos");
		lblSegundosC2.setBounds(72, 20, 59, 14);
		panelTeCC2.add(lblSegundosC2);
		lblSegundosC2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSegundosC2.setFont(new Font("Tahoma", Font.PLAIN, 11));

		panelDuracaoC2 = new JPanel();
		panelDuracaoC2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Dura\u00E7\u00E3o das Chamadas",
				TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 11), null));
		panelDuracaoC2.setBounds(10, 100, 183, 73);
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
		lblValorC2.setVisible(true);

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
		lblValoresC2.setVisible(false);

		comboBoxC2 = new JComboBox();
		comboBoxC2.setBounds(56, 19, 117, 20);
		panelDuracaoC2.add(comboBoxC2);
		comboBoxC2.setModel(new DefaultComboBoxModel(new String[] { "Constante", "Normal", "Triangular", "Uniforme", "Exponencial" }));

		textFieldMaxC2 = new JTextField();
		textFieldMaxC2.setText("7");
		textFieldMaxC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldMaxC2.setBounds(120, 44, 28, 20);
		panelDuracaoC2.add(textFieldMaxC2);
		textFieldMaxC2.setColumns(10);

		textFieldMedC2 = new JTextField();
		textFieldMedC2.setText("5");
		textFieldMedC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldMedC2.setColumns(10);
		textFieldMedC2.setBounds(88, 44, 28, 20);
		panelDuracaoC2.add(textFieldMedC2);

		textFieldMinC2 = new JTextField();
		textFieldMinC2.setText("3");
		textFieldMinC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldMinC2.setColumns(10);
		textFieldMinC2.setBounds(56, 44, 28, 20);
		panelDuracaoC2.add(textFieldMinC2);

		textFieldMaxC2.setVisible(false);
		textFieldMedC2.setVisible(false);
		textFieldMinC2.setVisible(true);

		comboBoxC2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (comboBoxC2.getSelectedItem().toString().equals("Constante")) {
					textFieldMaxC2.setVisible(false);
					textFieldMedC2.setVisible(false);
					lblValorC2.setVisible(true);
					lblValoresC2.setVisible(false);
				} else if (comboBoxC2.getSelectedItem().toString().equals("Normal")) {
					textFieldMaxC2.setVisible(false);
					textFieldMedC2.setVisible(true);
					lblValorC2.setVisible(false);
					lblValoresC2.setVisible(true);
				} else if (comboBoxC2.getSelectedItem().toString().equals("Triangular")) {
					textFieldMaxC2.setVisible(true);
					textFieldMedC2.setVisible(true);
					lblValorC2.setVisible(false);
					lblValoresC2.setVisible(true);
				} else if (comboBoxC2.getSelectedItem().toString().equals("Uniforme")) {
					textFieldMaxC2.setVisible(false);
					textFieldMedC2.setVisible(true);
					lblValorC2.setVisible(false);
					lblValoresC2.setVisible(true);
				} else if (comboBoxC2.getSelectedItem().toString().equals("Exponencial")) {
					textFieldMaxC2.setVisible(false);
					textFieldMedC2.setVisible(false);
					lblValorC2.setVisible(true);
					lblValoresC2.setVisible(false);
				}
			}
		});

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Probabilidades", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_5.setBounds(423, 20, 168, 239);
		panelSimulacoes.add(panel_5);
		panel_5.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setForeground(new Color(0, 100, 0));
		panel_7.setBounds(10, 21, 148, 106);
		panel_5.add(panel_7);
		panel_7.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "In\u00EDcio em C1", TitledBorder.LEADING,
				TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 11), null));
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

		textFieldC1FAProbValue = new JTextField();
		textFieldC1FAProbValue.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldC1FAProbValue.setBounds(68, 71, 48, 20);
		panel_7.add(textFieldC1FAProbValue);
		textFieldC1FAProbValue.setText("20");
		textFieldC1FAProbValue.setColumns(10);

		textFieldC1C2ProbValue = new JTextField();
		textFieldC1C2ProbValue.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldC1C2ProbValue.setBounds(68, 46, 48, 20);
		panel_7.add(textFieldC1C2ProbValue);
		textFieldC1C2ProbValue.setText("30");
		textFieldC1C2ProbValue.setColumns(10);

		textFieldC1C1ProbValue = new JTextField();
		textFieldC1C1ProbValue.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldC1C1ProbValue.setBounds(68, 21, 48, 20);
		panel_7.add(textFieldC1C1ProbValue);
		textFieldC1C1ProbValue.setText("50");
		textFieldC1C1ProbValue.setColumns(10);

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
		panel_8.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "In\u00EDcio em C2", TitledBorder.LEADING,
				TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 11), null));
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

		textFieldC2C2ProbValue = new JTextField();
		textFieldC2C2ProbValue.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldC2C2ProbValue.setBounds(68, 20, 48, 20);
		panel_8.add(textFieldC2C2ProbValue);
		textFieldC2C2ProbValue.setText("50");
		textFieldC2C2ProbValue.setColumns(10);

		textFieldC2C1ProbValue = new JTextField();
		textFieldC2C1ProbValue.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldC2C1ProbValue.setBounds(68, 45, 48, 20);
		panel_8.add(textFieldC2C1ProbValue);
		textFieldC2C1ProbValue.setText("30");
		textFieldC2C1ProbValue.setColumns(10);

		textFieldC2FAProbValue = new JTextField();
		textFieldC2FAProbValue.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldC2FAProbValue.setBounds(68, 70, 48, 20);
		panel_8.add(textFieldC2FAProbValue);
		textFieldC2FAProbValue.setText("20");
		textFieldC2FAProbValue.setColumns(10);

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

		JLabel labelDuracaoSimulacao = new JLabel("Duração:");
		labelDuracaoSimulacao.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDuracaoSimulacao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelDuracaoSimulacao.setBounds(228, 215, 44, 14);
		panelSimulacoes.add(labelDuracaoSimulacao);

		textFieldDuracaoSimulacao = new JTextField();
		textFieldDuracaoSimulacao.setText("30");
		textFieldDuracaoSimulacao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldDuracaoSimulacao.setColumns(10);
		textFieldDuracaoSimulacao.setBounds(282, 212, 70, 20);
		panelSimulacoes.add(textFieldDuracaoSimulacao);

		JLabel lblMinutos = new JLabel("minutos");
		lblMinutos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMinutos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMinutos.setBounds(362, 215, 37, 14);
		panelSimulacoes.add(lblMinutos);

		sliderVelocidadePasso = new JSlider();
		sliderVelocidadePasso.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sliderVelocidadePasso.setMajorTickSpacing(100);
		sliderVelocidadePasso.setMaximum(1020);
		sliderVelocidadePasso.setMinimum(20);
		sliderVelocidadePasso.setSnapToTicks(true);
		sliderVelocidadePasso.setPaintTicks(true);
		sliderVelocidadePasso.setPaintLabels(true);
		sliderVelocidadePasso.setBounds(20, 263, 389, 45);
		panelSimulacoes.add(sliderVelocidadePasso);

		JLabel sliderLabel = new JLabel("Velocidade de execução por passo (ms):");
		sliderLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		sliderLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sliderLabel.setBounds(20, 245, 193, 14);
		panelSimulacoes.add(sliderLabel);

		JButton buttonFastForward = new JButton("Acelerar Passos (0 ms)");
		buttonFastForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Simulador.fastForward = true;
			}
		});
		buttonFastForward.setForeground(new Color(210, 105, 30));
		buttonFastForward.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonFastForward.setBounds(433, 275, 144, 23);
		panelSimulacoes.add(buttonFastForward);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Edi\u00E7\u00E3o e An\u00E1lise",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 163, 204, 91);
		panelDados.add(panel_3);
		panel_3.setLayout(null);

		buttonAnalisarSimulaoSelecionada = new JButton("Analisar Simula\u00E7\u00E3o Selecionada");
		buttonAnalisarSimulaoSelecionada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = listaSimulacoesComponent.getSelectedIndex();
				if (index == -1)
					JOptionPane.showMessageDialog(null, "Nenhuma Simula\u00E7\u00E3o est\u00E1 Selecionada!", "Erro!", 1);
				else {
					Simulacao simulacao = (Simulacao) simulacoes.get(index);

					String str = "";
					for (String string : simulacao.getLog()) {
						str += string + "\n";
					}
					textAreaResultado.setText(str);
				}
			}
		});
		buttonAnalisarSimulaoSelecionada.setBounds(10, 21, 181, 23);
		panel_3.add(buttonAnalisarSimulaoSelecionada);
		buttonAnalisarSimulaoSelecionada.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonAnalisarSimulaoSelecionada.setForeground(Color.BLUE);

		buttonExcluirSimulacaoSelecionada = new JButton("Excluir Simula\u00E7\u00E3o Selecionada");
		buttonExcluirSimulacaoSelecionada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = listaSimulacoesComponent.getSelectedIndex();
				if (index == -1)
					JOptionPane.showMessageDialog(null, "Nenhuma Simula\u00E7\u00E3o est\u00E1 Selecionada!", "Erro!", 1);
				else {
					int i = JOptionPane.showConfirmDialog(null, "Voc\u00EA deseja mesmo excluir as simula\u00E7\u00F5es selecionadas?");
					if (i == 0) {
						List names = MainInterface.listaSimulacoesComponent.getSelectedValuesList();

						for (int k = 0; k < names.size(); k++) {
							for (int j = 0; j < MainInterface.simulacoes.size(); j++) {
								if (MainInterface.simulacoes.get(j).toString().equals(names.get(k))) {
									MainInterface.simulacoes.remove(MainInterface.simulacoes.indexOf(simulacoes.get(j)));
									break;
								}
							}
						}

						MainInterface.listaSimulacoesComponent.clearSelection();
						MainInterface.listaSimulacoesComponent.updateUI();
						textAreaResultado.setText("");
					}
				}
			}
		});
		buttonExcluirSimulacaoSelecionada.setBounds(10, 55, 181, 23);
		panel_3.add(buttonExcluirSimulacaoSelecionada);
		buttonExcluirSimulacaoSelecionada.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonExcluirSimulacaoSelecionada.setForeground(Color.BLUE);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Gr\u00E1ficos e Estat\u00EDsticas",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(215, 163, 204, 91);
		panelDados.add(panel_4);
		panel_4.setLayout(null);

		buttonGerarEstatisticas = new JButton("Gerar Estatísticas");
		buttonGerarEstatisticas.setBounds(10, 55, 181, 23);
		panel_4.add(buttonGerarEstatisticas);
		buttonGerarEstatisticas.setName("Gerar Estat\u00EDsticas");
		buttonGerarEstatisticas.setForeground(new Color(128, 0, 0));
		buttonGerarEstatisticas.setFont(new Font("Tahoma", Font.PLAIN, 11));

		buttonGerarGraficos = new JButton("Gerar Gráfico");
		buttonGerarGraficos.setBounds(10, 21, 181, 23);
		panel_4.add(buttonGerarGraficos);
		buttonGerarGraficos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = listaSimulacoesComponent.getSelectedIndex();
				if (index == -1)
					JOptionPane.showMessageDialog(null, "Nenhuma Simula\u00E7\u00E3o est\u00E1 Selecionada!", "Erro!", 1);
				else {
					new GraficoOcupacao(simulacoes.get(index));
					new GraficoNumeroChamadas(simulacoes.get(index));
				}
			}
		});
		buttonGerarGraficos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonGerarGraficos.setForeground(new Color(128, 0, 0));
		buttonGerarGraficos.setName("Create GR");

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Gr\u00E1ficos e Estat\u00EDsticas",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(420, 163, 191, 91);
		panelDados.add(panel_1);

		buttonPausarSimulacao = new JButton("Pausar Simulação!");
		buttonPausarSimulacao.setBounds(10, 55, 171, 23);
		panel_1.add(buttonPausarSimulacao);
		buttonPausarSimulacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Simulador.pausado) {
					Simulador.pausado = false;
					buttonPausarSimulacao.setText("Pausar");
					buttonPausarSimulacao.setForeground(Color.RED);
				} else {
					Simulador.pausado = true;
					buttonPausarSimulacao.setText("Continuar");
					buttonPausarSimulacao.setForeground(Color.GREEN);
				}
			}
		});
		buttonPausarSimulacao.setForeground(Color.RED);
		buttonPausarSimulacao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonPausarSimulacao.setEnabled(false);

		buttonSimulacao = new JButton("Criar Nova Simulação");
		buttonSimulacao.setBounds(10, 23, 171, 23);
		panel_1.add(buttonSimulacao);
		buttonSimulacao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonSimulacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Simulacao simulacao = new Simulacao(textFieldNome.getText(), id++);
				simulacoes.add(simulacao);
				listaSimulacoesComponent.updateUI();

				Simulador.init(simulacao);
				simulador = new Thread(new Simulador());
				textAreaResultado.setText("");
				simulador.start();
				buttonPausarSimulacao.setEnabled(true);
				buttonSimulacao.setEnabled(false);
			}
		});
		buttonSimulacao.setForeground(new Color(0, 100, 0));

		buttonGerarEstatisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = listaSimulacoesComponent.getSelectedIndex();
				if (index == -1)
					JOptionPane.showMessageDialog(null, "Nenhuma Simula\u00E7\u00E3o est\u00E1 Selecionada!", "Erro!", 1);
				else {
					Simulacao simulacao = (Simulacao) simulacoes.get(index);
					textAreaResultado.setText(simulacao.getEstatistica().toStringInfo());
				}
			}
		});
	}

	public static void print(String str) {
		textAreaResultado.append(str + "\n");
	}
}
