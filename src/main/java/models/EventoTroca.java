package models;

import models.generic.Evento;

public class EventoTroca extends Evento {

	private int tempoTroca;

	public EventoTroca(int tempoChegada, int tempoTroca, Chamada chamada, int id) {
		super(tempoChegada, chamada, id);
		this.setTempoTroca(tempoTroca);
	}

	public int getTempoTroca() {
		return tempoTroca;
	}

	public void setTempoTroca(int tempoTroca) {
		this.tempoTroca = tempoTroca;
	}

}
