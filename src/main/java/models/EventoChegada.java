package models;

import models.generic.Evento;

public class EventoChegada extends Evento {

	private int idChegada;

	public EventoChegada(int tempoChegada, Chamada chamada) {
		super(tempoChegada, chamada);
		idChegada = id++;
	}

	@Override
	public String toString() {
		return "Chegada <ID: " + idChegada + "; Tempo chegada: " + tempoChegada + ">";
	}

	public int getIdChegada() {
		return idChegada;
	}

}
