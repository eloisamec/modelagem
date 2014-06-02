package models;

import models.enums.TipoEvento;

public class Evento implements Comparable {

	private int tempo;
	private TipoEvento tipoEvento;
	private Chamada chamada;
	private int id;

	public Evento(TipoEvento tipoEvento, int tempo, Chamada chamada, int id) {
		this.tipoEvento = tipoEvento;
		this.tempo = tempo;
		this.chamada = chamada;
		this.setId(id);
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public TipoEvento getTipo() {
		return tipoEvento;
	}

	public void setTipo(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Chamada getChamada() {
		return chamada;
	}

	public void setChamada(Chamada chamada) {
		this.chamada = chamada;
	}

	public int compareTo(Object o) {
		Evento evento = (Evento) o;

		return (this.tempo < evento.tempo) ? -1 : (this.tempo > evento.tempo) ? 1 : 0;
	}

	@Override
	public String toString() {
		return ("Evento: \nTipo do Evento: " + this.tipoEvento + " \nId do evento: " + this.id + chamada.toString());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
