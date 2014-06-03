package models.generic;

import models.Chamada;

public abstract class Evento implements Comparable<Evento> {

	private int tempoChegada;
	private Chamada chamada;
	protected static int id = 0;

	public Evento(int tempoChegada, Chamada chamada) {
		this.tempoChegada = tempoChegada;
		this.chamada = chamada;
	}

	public int getTempo() {
		return tempoChegada;
	}

	public void setTempo(int tempo) {
		this.tempoChegada = tempo;
	}

	public Chamada getChamada() {
		return chamada;
	}

	public void setChamada(Chamada chamada) {
		this.chamada = chamada;
	}

	public int compareTo(Evento evento) {
		return (this.tempoChegada < evento.tempoChegada) ? -1 : (this.tempoChegada > evento.tempoChegada) ? 1 : 0;
	}

}
