package controllers;

import models.Chamada;
import models.Evento;
import models.enums.TipoChamada;
import models.enums.TipoDuracao;
import models.enums.TipoEvento;
import utils.MathsUtils;

public class EventoController {

	private static int id = 0;

	public static Evento getNovaChegada(int lambda, TipoDuracao duracao, int a, int b, int c, int tempoAtual) {
		int tempoChegada = MathsUtils.Expo(lambda);
		TipoEvento tipoEvento = TipoEvento.CHEGADA;
		int duracaoChamada = ChamadaController.getDuracaoChamada(duracao, a, b, c);
		TipoChamada tipoChamada = ChamadaController.getTipoChamada();
		Chamada chamada = new Chamada((duracaoChamada * 60) + tempoAtual, tipoChamada);
		Evento evento = new Evento(tipoEvento, tempoChegada, chamada, id);

		id++;
		return evento;
	}

	public static Evento getNovaSaida(Evento eventoChegada) {
		TipoEvento tipoEvento = TipoEvento.SAIDA;
		Chamada chamada = eventoChegada.getChamada();
		int tempoSaida = eventoChegada.getTempo() + chamada.getDuracao();
		Evento evento = new Evento(tipoEvento, tempoSaida, chamada, eventoChegada.getId());

		return evento;
	}

	public static Evento getNovaTroca(Evento eventoChegada) {
		TipoEvento tipoEvento = TipoEvento.TROCA;
		Chamada chamada = eventoChegada.getChamada();
		int tempoTroca = (eventoChegada.getTempo() + chamada.getDuracao()) / 2;
		Evento evento = new Evento(tipoEvento, tempoTroca, chamada, eventoChegada.getId());

		return evento;
	}
}
