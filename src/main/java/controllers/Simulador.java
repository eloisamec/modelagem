package controllers;

import java.util.ArrayList;
import java.util.Collections;

import models.Celula;
import models.Evento;
import models.enums.TipoChamada;
import models.enums.TipoDuracao;
import models.enums.TipoEvento;
import utils.Statistics;
import utils.Utils;
import views.MainInterface;

public class Simulador implements Runnable {

	private static int tempoAtual = 0;
	private static ArrayList<Evento> eventos;
	private Celula c1;
	private Celula c2;
	private static int aC1 = Utils.filterByInteger(MainInterface.textFieldMinC1.getText());
	private static int bC1 = Utils.filterByInteger(MainInterface.textFieldMedC1.getText());
	private static int cC1 = Utils.filterByInteger(MainInterface.textFieldMaxC1.getText());
	private static TipoDuracao tipoDuracaoC1;
	private static int aC2 = Utils.filterByInteger(MainInterface.textFieldMinC2.getText());
	private static int bC2 = Utils.filterByInteger(MainInterface.textFieldMedC2.getText());
	private static int cC2 = Utils.filterByInteger(MainInterface.textFieldMaxC2.getText());
	private static TipoDuracao tipoDuracaoC2;
	public static boolean paused = false;

	@SuppressWarnings("unchecked")
	public static void init() {
		eventos = new ArrayList<Evento>();

		String nomeTipoDuracaoC1 = MainInterface.comboBoxC1.getSelectedItem().toString();
		String nomeTipoDuracaoC2 = MainInterface.comboBoxC2.getSelectedItem().toString();
		tipoDuracaoC1 = TipoDuracao.get(nomeTipoDuracaoC1);
		tipoDuracaoC2 = TipoDuracao.get(nomeTipoDuracaoC2);

		TipoChamada tipoChamada = ChamadaController.testaTipoChamadaC1((int) Math.random() * 100);
		getNovoEvento(tipoChamada);
		ChamadaController.testaTipoChamadaC2((int) Math.random() * 100);
		getNovoEvento(tipoChamada);

		Collections.sort(eventos);
	}

	private static void getNovoEvento(TipoChamada tipoChamada) {
		if (tipoChamada.toString().startsWith("C1")) {
			Evento eventoChegada = EventoController.getNovaChegada(Utils.filterByInteger(MainInterface.textFieldExpoC1.getText()), tipoDuracaoC1, aC1,
					bC1, cC1, tempoAtual);
			eventos.add(eventoChegada);
			if (!tipoChamada.equals(TipoChamada.C1FA)) {
				Evento eventoSaida = EventoController.getNovaSaida(eventoChegada);
				eventos.add(eventoSaida);
			}
			if (tipoChamada.equals(TipoChamada.C1C2) || tipoChamada.equals(TipoChamada.C1FA)) {
				Evento eventoTroca = EventoController.getNovaTroca(eventoChegada);
				eventos.add(eventoTroca);
			}
		} else {
			Evento eventoChegada = EventoController.getNovaChegada(Utils.filterByInteger(MainInterface.textFieldExpoC2.getText()), tipoDuracaoC2, aC2,
					bC2, cC2, tempoAtual);
			eventos.add(eventoChegada);
			if (!tipoChamada.equals(TipoChamada.C2FA)) {
				Evento eventoSaida = EventoController.getNovaSaida(eventoChegada);
				eventos.add(eventoSaida);
			}
			if (tipoChamada.equals(TipoChamada.C2FA) || tipoChamada.equals(TipoChamada.C2C1)) {
				Evento eventoTroca = EventoController.getNovaTroca(eventoChegada);
				eventos.add(eventoTroca);
			}
		}
	}

	public void run() {
		c1 = new Celula(Integer.parseInt(MainInterface.textFieldCanaisC1.getText()));
		c2 = new Celula(Integer.parseInt(MainInterface.textFieldCanaisC2.getText()));
		int duracaoExecucao = Integer.parseInt(MainInterface.textFieldDuracaoSimulacao.getText()) * 60;
		boolean isRunning = true;

		init();

		while (isRunning) {
			if (paused) {
				try {
					Thread.sleep(15);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				tempoAtual++;
				MainInterface.print("Tempo atual de execução " + tempoAtual + " segundos");
				ArrayList<Evento> listaEventos = getEventosNoTempo(tempoAtual);
				for (Evento evento : listaEventos) {
					MainInterface.print(evento.toString());
					System.out.println(evento.toString());
					TipoEvento tipoEvento = evento.getTipo();
					TipoChamada tipoChamada = evento.getChamada().getTipoChamada();

					if (tipoEvento.name().equalsIgnoreCase("chegada")) {
						setEventoChegada(evento.getId(), tipoEvento, tipoChamada);
						eventos.remove(evento);
					}
					if (tipoEvento.name().equalsIgnoreCase("saida")) {
						setEventoSaida(evento.getId(), tipoEvento, tipoChamada);
						eventos.remove(evento);
					}
					if (tipoEvento.name().equalsIgnoreCase("troca")) {
						setEventoTroca(evento.getId(), tipoEvento, tipoChamada);
						eventos.remove(evento);
					}
				}

				boolean novoEventoC1 = true;
				boolean novoEventoC2 = true;
				for (Evento evento : eventos) {
					if (evento.getTipo().equals(TipoEvento.CHEGADA) && evento.getChamada().getTipoChamada().toString().startsWith("C1")) {
						novoEventoC1 = false;
					}
					if (evento.getTipo().equals(TipoEvento.CHEGADA) && evento.getChamada().getTipoChamada().toString().startsWith("C2")) {
						novoEventoC2 = false;
					}
				}
				if (novoEventoC1) {
					getNovoEvento(ChamadaController.testaTipoChamadaC1((int) Math.random() * 100));
				}
				if (novoEventoC2) {
					getNovoEvento(ChamadaController.testaTipoChamadaC2((int) Math.random() * 100));
				}

				if (tempoAtual > duracaoExecucao) {
					isRunning = false;
				}
			}
		}
	}

	private void setEventoTroca(int eventoId, TipoEvento tipoEvento, TipoChamada tipoChamada) {
		if (tipoChamada.name().equalsIgnoreCase("C1C2")) {
			c1.setCanais(c1.getCanais() + 1);
			if (c2.getCanais() > 0) {
				c2.setCanais(c2.getCanais() - 1);
			} else {
				removeEventoById(eventoId);
				Statistics.getNrChamadasPerdidasC2();
			}
		} else if (tipoChamada.name().equalsIgnoreCase("C2C1")) {
			c2.setCanais(c2.getCanais() + 1);
			if (c1.getCanais() > 0) {
				c1.setCanais(c1.getCanais() - 1);
			} else {
				removeEventoById(eventoId);
				Statistics.increaseNrChamadasPerdidasC1();
			}
		} else if (tipoChamada.name().equalsIgnoreCase("C1FA")) {
			c1.setCanais(c1.getCanais() + 1);
			Statistics.increaseNrChamadasPerdidasFA();
		} else if (tipoChamada.name().equalsIgnoreCase("C2FA")) {
			c2.setCanais(c2.getCanais() + 1);
			Statistics.increaseNrChamadasPerdidasFA();
		}
	}

	private void setEventoSaida(int eventoId, TipoEvento tipoEvento, TipoChamada tipoChamada) {
		if (tipoChamada.name().startsWith("C1")) {
			c1.setCanais(c1.getCanais() + 1);
		} else {
			c2.setCanais(c2.getCanais() + 1);
		}
		Statistics.increaseNrChamadasFinalizadas();
	}

	public ArrayList<Evento> getEventosNoTempo(int tempoAtual) {
		ArrayList<Evento> novaLista = new ArrayList<Evento>();

		for (Evento evento : eventos) {
			if (evento.getTempo() == tempoAtual) {
				novaLista.add(evento);
			}
		}
		return novaLista;
	}

	public void setEventoChegada(int eventoId, TipoEvento tipoEvento, TipoChamada tipoChamada) {
		if (tipoChamada.name().startsWith("C1")) {
			if (c1.getCanais() > 0) {
				c1.setCanais(c1.getCanais() - 1);
				Statistics.increaseNrChamadasChegandoNoSistema();
			} else {
				removeEventoById(eventoId);
				Statistics.increaseNrChamadasPerdidasC1();
			}
		} else {
			if (c2.getCanais() > 0) {
				c2.setCanais(c2.getCanais() - 1);
				Statistics.increaseNrChamadasChegandoNoSistema();
			} else {
				removeEventoById(eventoId);
				Statistics.increaseNrChamadasPerdidasC2();
			}
		}
	}

	private void removeEventoById(int eventoId) {
		for (Evento evento : eventos) {
			if (evento.getId() == eventoId) {
				eventos.remove(evento);
			}
		}
	}
}
