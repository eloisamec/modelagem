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

public class GraficoNumeroChamadas {

	static Simulacao simulacao;

	public GraficoNumeroChamadas(Simulacao sim) {
		GraficoNumeroChamadas.simulacao = sim;
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

		XYSeries seriesNumeroChamadas = new XYSeries("Número de Chamadas no Sistema", false);

		ArrayList<Integer> listaNumeroChamadas = simulacao.getEstatistica().getListaNumeroDeChamadasEstatistica();

		for (int i = 0; i < listaNumeroChamadas.size(); i++) {
			seriesNumeroChamadas.add(i, listaNumeroChamadas.get(i));
		}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(seriesNumeroChamadas);

		JFreeChart chart = ChartFactory.createScatterPlot(
				"Estat\u00EDsticas - " + simulacao.getNome() + " - ID: " + simulacao.getIdSimulacao(), "Tempo(s)", "Número de Chamadas",
				dataset, PlotOrientation.VERTICAL, true, true, false);
		chart.getXYPlot().setRenderer(new XYLineAndShapeRenderer());

		XYPlot plot = (XYPlot) chart.getPlot();
		plot.getRenderer().setSeriesPaint(0, new Color(35, 100, 0));
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(850, 600));
		panel.add(chartPanel);

		return panel;
	}
}
