package models;

import models.generic.Evento;

public class EventoSaida extends Evento {

	private int id;

	public EventoSaida(int tempoSaida, Chamada chamada, int id) {
		super(tempoSaida, chamada);
		this.id = id;
	}

	@Override
	public String toString() {
		return "Saída <ID: " + id + "; Tempo chegada: " + tempoChegada + ">";
	}

	public int getId() {
		return id;
	}

}
