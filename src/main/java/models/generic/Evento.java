package models.generic;

import models.Chamada;

public abstract class Evento implements Comparable<Evento> {

	private int tempoChegada;
	private Chamada chamada;
	private int id;

	public Evento(int tempoChegada, Chamada chamada, int id) {
		this.tempoChegada = tempoChegada;
		this.chamada = chamada;
		this.setId(id);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
