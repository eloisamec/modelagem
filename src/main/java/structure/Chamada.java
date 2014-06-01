package structure;

import enumeration.TipoChamada;

public class Chamada {

	private double duracao;
	private TipoChamada tipoChamada;

	public Chamada(){
	}
	
	
	public Chamada(double duracao, TipoChamada tipoChamada) {
		this.setTipoChamada(tipoChamada);
		this.duracao = duracao;
	}

	public double getDuracao() {
		return this.duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	public TipoChamada getTipoChamada() {
		return tipoChamada;
	}

	public void setTipoChamada(TipoChamada tipo) {
		this.tipoChamada = tipo;
	}

	

}
