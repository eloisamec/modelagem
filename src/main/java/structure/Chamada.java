package structure;

import enumeration.TipoChamada;
import enumeration.TipoDuracao;

public class Chamada {
	
	private int duracao;
	private TipoChamada tipoChamada;
	private TipoDuracao tipoDuracao;
	private double probabilidadeDeOcorrencia;
	
	public Chamada(int duracao, double probabilidadeDeOcorrencia, TipoChamada tipoChamada, TipoDuracao tipoDuracao) {
		this.setTipoChamada(tipoChamada);
		this.setProbabilidadeDeOcorrencia(probabilidadeDeOcorrencia);
		this.setDuracao(duracao, tipoDuracao);
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao, TipoDuracao tipoDuracao) {
		this.duracao = duracao;
	}

	public TipoChamada getTipoChamada() {
		return tipoChamada;
	}

	public void setTipoChamada(TipoChamada tipo) {
		this.tipoChamada = tipo;
	}

	public double getProbabilidadeDeOcorrencia() {
		return probabilidadeDeOcorrencia;
	}

	public void setProbabilidadeDeOcorrencia(double probabilidadeDeOcorrencia) {
		this.probabilidadeDeOcorrencia = probabilidadeDeOcorrencia;
	}

	public TipoDuracao getTipoDuracao() {
		return tipoDuracao;
	}

	public void setTipoDuracao(TipoDuracao tipoDuracao) {
		this.tipoDuracao = tipoDuracao;
	}

}
