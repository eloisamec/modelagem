package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.Celula;
import models.enums.TipoChamada;
import models.enums.TipoDuracao;
import models.generic.Evento;
import utils.Statistics;
import utils.Utils;
import views.MainInterface;

public class Simulador implements Runnable {

	private static int tempoAtual;
	private static ArrayList<Evento> eventos;
	private static Celula celula1;
	private static Celula celula2;
	private static int aC1;
	private static int bC1;
	private static int cC1;
	private static int aC2;
	private static int bC2;
	private static int cC2;
	private static TipoDuracao tipoDuracaoC1;
	private static TipoDuracao tipoDuracaoC2;
	public static boolean pausado;
	public static boolean rodando;
	public static int duracaoExecucao;

	public static void init() {
		// Atributos de controle; // TODO Poderia talvez criar um override pra
		// lista ordenar no add =]
		eventos = new ArrayList<Evento>();
		tempoAtual = 0;
		pausado = false;
		duracaoExecucao = Integer.parseInt(MainInterface.textFieldDuracaoSimulacao.getText()) * 60;
		rodando = true;

		// Criação das células;
		celula1 = new Celula(Integer.parseInt(MainInterface.textFieldCanaisC1.getText()));
		celula2 = new Celula(Integer.parseInt(MainInterface.textFieldCanaisC2.getText()));

		// TODO Comment -> Parâmetros; Escohler noem decentes;
		aC1 = Utils.filterByInteger(MainInterface.textFieldMinC1.getText());
		bC1 = Utils.filterByInteger(MainInterface.textFieldMedC1.getText());
		cC1 = Utils.filterByInteger(MainInterface.textFieldMaxC1.getText());
		aC2 = Utils.filterByInteger(MainInterface.textFieldMinC2.getText());
		bC2 = Utils.filterByInteger(MainInterface.textFieldMedC2.getText());
		cC2 = Utils.filterByInteger(MainInterface.textFieldMaxC2.getText());

		// Tipos da duração das células 1 e 2;
		String nomeTipoDuracaoC1 = MainInterface.comboBoxC1.getSelectedItem().toString();
		String nomeTipoDuracaoC2 = MainInterface.comboBoxC2.getSelectedItem().toString();
		tipoDuracaoC1 = TipoDuracao.get(nomeTipoDuracaoC1);
		tipoDuracaoC2 = TipoDuracao.get(nomeTipoDuracaoC2);

		// Cria dois novos eventos de chegada, um para cada célula;
		TipoChamada tipoChamadaC1 = ChamadaController.getTipoChamadaC1((int) Math.random() * 100);
		List<Evento> novosEventosC1 = EventoController.criarNovosEventosC1(tipoChamadaC1, tempoAtual, tipoDuracaoC1);

		TipoChamada tipoChamadaC2 = ChamadaController.getTipoChamadaC2((int) Math.random() * 100);
		List<Evento> novosEventosC2 = EventoController.criarNovosEventosC2(tipoChamadaC2, tempoAtual, tipoDuracaoC2);

		eventos.addAll(novosEventosC1);
		eventos.addAll(novosEventosC2);
		Collections.sort(eventos);
	}

	public void run() {
		init();

		while (rodando) {
			if (pausado) {
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
					criarNovosEventosC1(ChamadaController.getTipoChamadaC1((int) Math.random() * 100));
				}
				if (novoEventoC2) {
					criarNovosEventosC1(ChamadaController.getTipoChamadaC2((int) Math.random() * 100));
				}

				if (tempoAtual > duracaoExecucao) {
					rodando = false;
				}
			}
		}
	}

	private void setEventoTroca(int eventoId, TipoEvento tipoEvento, TipoChamada tipoChamada) {
		if (tipoChamada.name().equalsIgnoreCase("C1C2")) {
			celula1.setCanais(celula1.getCanais() + 1);
			if (celula2.getCanais() > 0) {
				celula2.setCanais(celula2.getCanais() - 1);
			} else {
				removeEventoById(eventoId);
				Statistics.getNrChamadasPerdidasC2();
			}
		} else if (tipoChamada.name().equalsIgnoreCase("C2C1")) {
			celula2.setCanais(celula2.getCanais() + 1);
			if (celula1.getCanais() > 0) {
				celula1.setCanais(celula1.getCanais() - 1);
			} else {
				removeEventoById(eventoId);
				Statistics.increaseNrChamadasPerdidasC1();
			}
		} else if (tipoChamada.name().equalsIgnoreCase("C1FA")) {
			celula1.setCanais(celula1.getCanais() + 1);
			Statistics.increaseNrChamadasPerdidasFA();
		} else if (tipoChamada.name().equalsIgnoreCase("C2FA")) {
			celula2.setCanais(celula2.getCanais() + 1);
			Statistics.increaseNrChamadasPerdidasFA();
		}
	}

	private void setEventoSaida(int eventoId, TipoEvento tipoEvento, TipoChamada tipoChamada) {
		if (tipoChamada.name().startsWith("C1")) {
			celula1.setCanais(celula1.getCanais() + 1);
		} else {
			celula2.setCanais(celula2.getCanais() + 1);
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
			if (celula1.getCanais() > 0) {
				celula1.setCanais(celula1.getCanais() - 1);
				Statistics.increaseNrChamadasChegandoNoSistema();
			} else {
				removeEventoById(eventoId);
				Statistics.increaseNrChamadasPerdidasC1();
			}
		} else {
			if (celula2.getCanais() > 0) {
				celula2.setCanais(celula2.getCanais() - 1);
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
