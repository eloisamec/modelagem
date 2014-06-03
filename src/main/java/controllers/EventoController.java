package controllers;

import java.util.ArrayList;

import models.Celula;
import models.Chamada;
import models.EventoChegada;
import models.EventoSaida;
import models.EventoTroca;
import models.enums.TipoChamada;
import models.enums.TipoDuracao;
import models.generic.Evento;
import utils.MathsUtils;
import utils.Utils;
import views.MainInterface;

public class EventoController {

	private static Celula celula1;
	private static Celula celula2;

	public static ArrayList<Evento> criarNovosEventosC1(TipoChamada tipoChamada, int tempoAtual, TipoDuracao tipoDuracaoC1) {
		ArrayList<Evento> eventos = new ArrayList<Evento>();

		EventoChegada eventoChegada = criarNovaChegada(Utils.filterByInteger(MainInterface.textFieldExpoC1.getText()), tempoAtual,
				tipoDuracaoC1, tipoChamada, 1);
		eventos.add(eventoChegada);

		if (!tipoChamada.equals(TipoChamada.C1FA)) {
			EventoSaida eventoSaida = EventoController.getNovaSaida(eventoChegada);
			eventos.add(eventoSaida);
		}

		if (tipoChamada.equals(TipoChamada.C1C2) || tipoChamada.equals(TipoChamada.C1FA)) {
			EventoTroca eventoTroca = EventoController.getNovaTroca(eventoChegada);
			eventos.add(eventoTroca);
		}

		return eventos;
	}

	public static ArrayList<Evento> criarNovosEventosC2(TipoChamada tipoChamada, int tempoAtual, TipoDuracao tipoDuracaoC2) {
		ArrayList<Evento> eventos = new ArrayList<Evento>();

		EventoChegada eventoChegada = EventoController.criarNovaChegada(Utils.filterByInteger(MainInterface.textFieldExpoC2.getText()),
				tempoAtual, tipoDuracaoC2, tipoChamada, 2);
		eventos.add(eventoChegada);

		if (!tipoChamada.equals(TipoChamada.C2FA)) {
			EventoSaida eventoSaida = EventoController.getNovaSaida(eventoChegada);
			eventos.add(eventoSaida);
		}

		if (tipoChamada.equals(TipoChamada.C2FA) || tipoChamada.equals(TipoChamada.C2C1)) {
			EventoTroca eventoTroca = EventoController.getNovaTroca(eventoChegada);
			eventos.add(eventoTroca);
		}

		return eventos;
	}

	public static void tratarEventoChegada(int eventoId, TipoChamada tipoChamada) {
		if (tipoChamada.getTipoOrigemChamada() == 1) {
			if (celula1.hasCanaisDisponiveis()) {
				celula1.incrementaCanaisOcupados();
			} else {
				removeEventoById(eventoId);
				Simulador.estatistica.increaseNrChamadasPerdidasC1();
			}
		} else if (tipoChamada.getTipoOrigemChamada() == 2) {
			if (celula2.hasCanaisDisponiveis()) {
				celula2.incrementaCanaisOcupados();
			} else {
				removeEventoById(eventoId);
				Simulador.estatistica.increaseNrChamadasPerdidasC2();
			}
		}
	}

	public static void tratarEventoTroca(int eventoId, TipoChamada tipoChamada) {
		if (tipoChamada.equals(TipoChamada.C1C2)) {
			celula1.decrementarCanaisOcupados();
			if (celula2.hasCanaisDisponiveis()) {
				celula2.incrementaCanaisOcupados();
			} else {
				removeEventoById(eventoId);
				Simulador.estatistica.getNrChamadasPerdidasC2();
			}
		} else if (tipoChamada.equals(TipoChamada.C2C1)) {
			celula2.decrementarCanaisOcupados();
			if (celula1.hasCanaisDisponiveis()) {
				celula1.incrementaCanaisOcupados();
			} else {
				removeEventoById(eventoId);
				Simulador.estatistica.increaseNrChamadasPerdidasC1();
			}
		} else if (tipoChamada.equals(TipoChamada.C1FA)) {
			celula1.decrementarCanaisOcupados();
			Simulador.estatistica.increaseNrChamadasPerdidasFA();
		} else if (tipoChamada.equals(TipoChamada.C2FA)) {
			celula2.decrementarCanaisOcupados();
			Simulador.estatistica.increaseNrChamadasPerdidasFA();
		}
	}

	public static void tratarEventoSaida(int eventoId, TipoChamada tipoChamada) {
		if (tipoChamada.getTipoOrigemChamada() == 1) {
			celula1.decrementarCanaisOcupados();
		} else if (tipoChamada.getTipoOrigemChamada() == 2) {
			celula2.decrementarCanaisOcupados();
		}
		Simulador.estatistica.increaseNrChamadasFinalizadas();
	}

	private static void removeEventoById(int eventoId) {
		ArrayList<Evento> eventosParaRemover = new ArrayList<Evento>();

		for (Evento evento : Simulador.eventos) {
			if (evento instanceof EventoChegada) {
				EventoChegada eventoChegada = (EventoChegada) evento;
				if (eventoChegada.getIdChegada() == eventoId) {
					eventosParaRemover.add(eventoChegada);
				}
				eventosParaRemover.add(evento);
			} else if (evento instanceof EventoTroca) {
				EventoTroca eventoTroca = (EventoTroca) evento;
				if (eventoTroca.getId() == eventoId) {
					eventosParaRemover.add(eventoTroca);
				}
				eventosParaRemover.add(evento);
			}
		}

		Simulador.eventos.removeAll(eventosParaRemover);
		Simulador.chamadasAtivas.removeAll(eventosParaRemover);
	}

	private static EventoChegada criarNovaChegada(int lambda, int tempoAtual, TipoDuracao tipoDuracao, TipoChamada tipoChamada,
			int tipoCelula) {
		int tempoChegada = MathsUtils.expo(lambda) + tempoAtual;
		int duracaoChamada = ChamadaController.getDuracaoChamada(tipoDuracao, tipoCelula);

		Chamada chamada = new Chamada((duracaoChamada * 60), tipoChamada);
		EventoChegada chegada = new EventoChegada(tempoChegada, chamada);

		return chegada;
	}

	private static EventoSaida getNovaSaida(EventoChegada eventoChegada) {
		Chamada chamada = eventoChegada.getChamada();
		int tempoSaida = eventoChegada.getTempo() + chamada.getDuracao();

		EventoSaida eventoSaida = new EventoSaida(tempoSaida, chamada, eventoChegada.getIdChegada());

		return eventoSaida;
	}

	private static EventoTroca getNovaTroca(EventoChegada eventoChegada) {
		Chamada chamada = eventoChegada.getChamada();
		int tempoTroca = eventoChegada.getTempo() + (chamada.getDuracao() / 2);

		EventoTroca eventoTroca = new EventoTroca(tempoTroca, chamada, eventoChegada.getIdChegada());

		return eventoTroca;
	}

	public static void setCelula1(Celula celula1) {
		EventoController.celula1 = celula1;
	}

	public static void setCelula2(Celula celula2) {
		EventoController.celula2 = celula2;
	}

	public static Celula getCelula1() {
		return celula1;
	}

	public static Celula getCelula2() {
		return celula2;
	}
}
