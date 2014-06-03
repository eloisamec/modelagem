package models;

import models.generic.Evento;

public class EventoTroca extends Evento {

	private int tempoTroca;
	private int id;

	public EventoTroca(int tempoTroca, Chamada chamada, int id) {
		super(tempoTroca, chamada);
		this.id = id;
		this.tempoTroca = tempoTroca;
	}

	public int getTempoTroca() {
		return tempoTroca;
	}

	public int getId() {
		return id;
	}

}
