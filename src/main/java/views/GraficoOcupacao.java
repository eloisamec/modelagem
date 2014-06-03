package views;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import models.Simulacao;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraficoOcupacao {

	static Simulacao simulacao;

	public GraficoOcupacao(Simulacao sim) {
		GraficoOcupacao.simulacao = sim;
		inicializarUI();
	}

	private void inicializarUI() {
		JFrame framePosition = new JFrame("");
		framePosition.setTitle("Gr\u00E1fico de Estat\u00EDsticas: " + simulacao.getNome() + " - ID: " + simulacao.getIdSimulacao());
		framePosition.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		framePosition.setSize(900, 650);
		framePosition.setLocationRelativeTo(null);
		framePosition.setResizable(false);

		framePosition.getContentPane().add(createGraphPosition());
		framePosition.setVisible(true);
	}

	private static JPanel createGraphPosition() {

		JPanel panel = new JPanel();

		XYSeries seriesOcupacaoC1 = new XYSeries("Ocupação da Célula 1(%)", false);
		XYSeries seriesOcupacaoC2 = new XYSeries("Ocupação da Célula 2(%)", false);

		ArrayList<Integer> listaOcupacaoC1 = simulacao.getEstatistica().getListaocupacaoC1Estatistica();
		ArrayList<Integer> listaOcupacaoC2 = simulacao.getEstatistica().getListaocupacaoC2Estatistica();

		for (int i = 0; i < listaOcupacaoC1.size(); i++) {
			seriesOcupacaoC1.add(i, listaOcupacaoC1.get(i));
		}

		for (int i = 0; i < listaOcupacaoC2.size(); i++) {
			seriesOcupacaoC2.add(i, listaOcupacaoC2.get(i));
		}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(seriesOcupacaoC1);
		dataset.addSeries(seriesOcupacaoC2);

		JFreeChart chart = ChartFactory.createScatterPlot(
				"Estat\u00EDsticas - " + simulacao.getNome() + " - ID: " + simulacao.getIdSimulacao(), "Tempo(s)", "Ocupação (%)", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		chart.getXYPlot().setRenderer(new XYLineAndShapeRenderer());

		XYPlot plot = (XYPlot) chart.getPlot();
		plot.getRenderer().setSeriesPaint(1, new Color(235, 100, 0));
		plot.getRenderer().setSeriesPaint(0, new Color(0, 15, 100));
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(850, 600));
		panel.add(chartPanel);

		return panel;
	}
}
