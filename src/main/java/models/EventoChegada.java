package models;

import models.generic.Evento;

public class EventoChegada extends Evento {

	public EventoChegada(int tempoChegada, Chamada chamada, int id) {
		super(tempoChegada, chamada, id);
	}

}
