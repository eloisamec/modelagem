package models;

import models.enums.TipoChamada;

public class Chamada {

	private int duracao;
	private TipoChamada tipoChamada;

	public Chamada() {
	}

	public Chamada(int duracao, TipoChamada tipoChamada) {
		this.setTipoChamada(tipoChamada);
		this.duracao = duracao;
	}

	public int getDuracao() {
		return this.duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public TipoChamada getTipoChamada() {
		return tipoChamada;
	}

	public void setTipoChamada(TipoChamada tipo) {
		this.tipoChamada = tipo;
	}

	@Override
	public String toString() {
		return ("\nTipo de Chamada: " + this.getTipoChamada() + "\nDuração da chamada: " + this.getDuracao() + " segundos");
	}
}
