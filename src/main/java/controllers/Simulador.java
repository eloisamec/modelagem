package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.Celula;
import models.EventoChegada;
import models.EventoSaida;
import models.EventoTroca;
import models.enums.TipoChamada;
import models.enums.TipoDuracao;
import models.generic.Evento;
import views.MainInterface;

public class Simulador implements Runnable {

	private static int tempoAtual;
	public static ArrayList<Evento> eventos;
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
		EventoController.setCelula1(new Celula(Integer.parseInt(MainInterface.textFieldCanaisC1.getText())));
		EventoController.setCelula2(new Celula(Integer.parseInt(MainInterface.textFieldCanaisC2.getText())));

		// Tipos da duração das células 1 e 2;
		String nomeTipoDuracaoC1 = MainInterface.comboBoxC1.getSelectedItem().toString();
		String nomeTipoDuracaoC2 = MainInterface.comboBoxC2.getSelectedItem().toString();
		tipoDuracaoC1 = TipoDuracao.get(nomeTipoDuracaoC1);
		tipoDuracaoC2 = TipoDuracao.get(nomeTipoDuracaoC2);

		// Cria novos eventos em C1 e em C2;
		criarEventosC1();
		criarEventosC2();
	}

	public void run() {
		init();

		// Loop principal da simulação;
		while (rodando) {
			// Testa se o sistema está pausado. Se estiver, dorme por 15ms para
			// não ocupar CPU;
			if (pausado) {
				try {
					Thread.sleep(15);
				} catch (InterruptedException e) {
					MainInterface.print("Problema na Thread de Simulação...");
					rodando = false;
					continue;
				}
			} else { // Próximo passo da Simulação;
				try {
					long sleepTime = MainInterface.sliderVelocidadePasso.getValue();
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// Incrementa o passo atual;
				tempoAtual++;

				// TODO Salvar isso aqui em algum lugar antes que atinjamos
				// 35Hz;
				MainInterface.print("Tempo atual de execução " + tempoAtual + " segundos");
				ArrayList<Evento> listaEventos = getEventosNoTempo(tempoAtual);

				for (Evento evento : listaEventos) {
					MainInterface.print(evento.toString());

					TipoChamada tipoChamada = evento.getChamada().getTipoChamada();

					// TODO Adicionar os eventos numa nova lista;
					if (evento instanceof EventoChegada) {
						EventoController.tratarEventoChegada(((EventoChegada) evento).getIdChegada(), tipoChamada);
						eventos.remove(evento);
					}
					if (evento instanceof EventoSaida) {
						EventoController.tratarEventoSaida(((EventoSaida) evento).getId(), tipoChamada);
						eventos.remove(evento);
					}
					if (evento instanceof EventoTroca) {
						EventoController.tratarEventoTroca(((EventoTroca) evento).getId(), tipoChamada);
						eventos.remove(evento);
					}
				}

				// Com base numa chance, cria novos eventos de chegada (caso não
				// exista nenhum);
				criarNovosEventos();

				// Teste de fim do tempo de simulação;
				if (tempoAtual > duracaoExecucao) {
					rodando = false;
				}
			}
		}
	}

	private void criarNovosEventos() {
		boolean novoEventoC1 = true;
		boolean novoEventoC2 = true;

		for (Evento evento : eventos) {
			if (evento instanceof EventoChegada) {
				if (evento.getChamada().getTipoChamada().getTipoOrigemChamada() == 1) {
					novoEventoC1 = false;
				} else if (evento.getChamada().getTipoChamada().getTipoOrigemChamada() == 2) {
					novoEventoC2 = false;
				}
			}
		}

		if (novoEventoC1) {
			criarEventosC1();
		}
		if (novoEventoC2) {
			criarEventosC2();
		}

	}

	private static void criarEventosC1() {
		TipoChamada tipoChamadaC1 = TipoChamadaController.getTipoChamadaC1((int) (Math.random() * 100));
		List<Evento> novosEventosC1 = EventoController.criarNovosEventosC1(tipoChamadaC1, tempoAtual, tipoDuracaoC1);

		eventos.addAll(novosEventosC1);

		Collections.sort(eventos);
	}

	private static void criarEventosC2() {
		TipoChamada tipoChamadaC2 = TipoChamadaController.getTipoChamadaC2((int) (Math.random() * 100));
		List<Evento> novosEventosC2 = EventoController.criarNovosEventosC2(tipoChamadaC2, tempoAtual, tipoDuracaoC2);

		eventos.addAll(novosEventosC2);

		Collections.sort(eventos);
	}

	private ArrayList<Evento> getEventosNoTempo(int tempoAtual) {
		ArrayList<Evento> eventosNoTempo = new ArrayList<Evento>();

		for (Evento evento : eventos) {
			if (evento.getTempo() == tempoAtual) {
				eventosNoTempo.add(evento);
			}
		}
		return eventosNoTempo;
	}

}
