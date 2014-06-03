package models;

import models.generic.Evento;

public class EventoChegada extends Evento {

	private int idChegada;

	public EventoChegada(int tempoChegada, Chamada chamada) {
		super(tempoChegada, chamada);
		idChegada = id++;
	}

	public int getIdChegada() {
		return idChegada;
	}

}
