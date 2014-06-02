package controllers;

import java.util.ArrayList;

import models.Chamada;
import models.EventoChegada;
import models.enums.TipoChamada;
import models.enums.TipoDuracao;
import models.generic.Evento;
import utils.MathsUtils;
import utils.Utils;
import views.MainInterface;

public class EventoController {

	public static ArrayList<Evento> criarNovosEventosC1(TipoChamada tipoChamada, int tempoAtual, TipoDuracao tipoDuracaoC1) {
		ArrayList<Evento> eventos = new ArrayList<Evento>();

		Evento eventoChegada = criarNovaChegada(Utils.filterByInteger(MainInterface.textFieldExpoC1.getText()), tempoAtual, tipoDuracaoC1, tipoChamada, 1);
		eventos.add(eventoChegada);

		if (!tipoChamada.equals(TipoChamada.C1FA)) {
			Evento eventoSaida = EventoController.getNovaSaida(eventoChegada);
			eventos.add(eventoSaida);
		}

		if (tipoChamada.equals(TipoChamada.C1C2) || tipoChamada.equals(TipoChamada.C1FA)) {
			Evento eventoTroca = EventoController.getNovaTroca(eventoChegada);
			eventos.add(eventoTroca);
		}

		return eventos;
	}

	public static ArrayList<Evento> criarNovosEventosC2(TipoChamada tipoChamada, int tempoAtual, TipoDuracao tipoDuracaoC2) {
		ArrayList<Evento> eventos = new ArrayList<Evento>();

		Evento eventoChegada = EventoController.criarNovaChegada(Utils.filterByInteger(MainInterface.textFieldExpoC2.getText()),
				tempoAtual, tipoDuracaoC2, tipoChamada, 2);
		eventos.add(eventoChegada);
		if (!tipoChamada.equals(TipoChamada.C2FA)) {
			Evento eventoSaida = EventoController.getNovaSaida(eventoChegada);
			eventos.add(eventoSaida);
		}
		if (tipoChamada.equals(TipoChamada.C2FA) || tipoChamada.equals(TipoChamada.C2C1)) {
			Evento eventoTroca = EventoController.getNovaTroca(eventoChegada);
			eventos.add(eventoTroca);
		}

		return eventos;
	}

	private static Evento criarNovaChegada(int lambda, int tempoAtual, TipoDuracao tipoDuracao, TipoChamada tipoChamada, int tipoCelula) {
		int tempoChegada = MathsUtils.expo(lambda) + tempoAtual;
		int duracaoChamada = ChamadaController.getDuracaoChamada(tipoDuracao, tipoCelula);

		Chamada chamada = new Chamada((duracaoChamada * 60), tipoChamada);
		EventoChegada chegada = new EventoChegada(tempoChegada, chamada, id);

		return chegada;
	}

	private static Evento getNovaSaida(Evento eventoChegada) {
		TipoEvento tipoEvento = TipoEvento.SAIDA;
		Chamada chamada = eventoChegada.getChamada();
		int tempoSaida = eventoChegada.getTempo() + chamada.getDuracao();
		Evento evento = new Evento(tipoEvento, tempoSaida, chamada, eventoChegada.getId());

		return evento;
	}

	private static Evento getNovaTroca(Evento eventoChegada) {
		TipoEvento tipoEvento = TipoEvento.TROCA;
		Chamada chamada = eventoChegada.getChamada();
		int tempoTroca = (eventoChegada.getTempo() + chamada.getDuracao()) / 2;
		Evento evento = new Evento(tipoEvento, tempoTroca, chamada, eventoChegada.getId());

		return evento;
	}
}
