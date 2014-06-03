package utils;

public class Estatistica {

	// a
	private int nrChamadasMinimoNoSistema = 0;
	private int nrChamadasMedioNoSistema = 0;
	private int nrChamadasMaximoNoSistema = 0;
	// b
	private int taxaOcupacaoCanaisC1 = 0;
	private int taxaOcupacaoCanaisC2 = 0;
	// c
	private int tempoMinimoChamada = 0;
	private int tempoMedioChamada = 0;
	private int tempoMaximoChamada = 0;
	// d
	private int nrChamadasFinalizadas = 0;
	// e
	private int nrChamadasPerdidasC1 = 0;
	private int nrChamadasPerdidasC2 = 0;
	// f
	private int nrChamadasPerdidasFA = 0;

	public Estatistica() {
	}

	public int getNrChamadasFinalizadas() {
		return nrChamadasFinalizadas;
	}

	public void setNrChamadasFinalizadas(int nrChamadasFinalizdas) {
		nrChamadasFinalizadas = nrChamadasFinalizdas;
	}

	public void increaseNrChamadasFinalizadas() {
		nrChamadasFinalizadas++;
	}

	public int getNrChamadasPerdidasC1() {
		return nrChamadasPerdidasC1;
	}

	public void setNrChamadasPerdidasC1(int nrChamadasPerdidas) {
		nrChamadasPerdidasC1 = nrChamadasPerdidas;
	}

	public void increaseNrChamadasPerdidasC1() {
		nrChamadasPerdidasC1++;
	}

	public int getNrChamadasPerdidasC2() {
		return nrChamadasPerdidasC2;
	}

	public void setNrChamadasPerdidasC2(int nrChamadasPerdidasC2) {
		this.nrChamadasPerdidasC2 = nrChamadasPerdidasC2;
	}

	public void increaseNrChamadasPerdidasC2() {
		nrChamadasPerdidasC2++;
	}

	public int getNrChamadasPerdidasFA() {
		return nrChamadasPerdidasFA;
	}

	public void setNrChamadasPerdidasFA(int nrChamadasPerdidasFA) {
		this.nrChamadasPerdidasFA = nrChamadasPerdidasFA;
	}

	public void increaseNrChamadasPerdidasFA() {
		nrChamadasPerdidasC2++;
	}

	public int getTempoMinimoChamada() {
		return tempoMinimoChamada;
	}

	public void setTempoMinimoChamada(int tempoMinimoChamada) {
		this.tempoMinimoChamada = tempoMinimoChamada;
	}

	public int getTempoMedioChamada() {
		return tempoMedioChamada;
	}

	public void setTempoMedioChamada(int tempoMedioChamada) {
		this.tempoMedioChamada = tempoMedioChamada;
	}

	public int getTempoMaximoChamada() {
		return tempoMaximoChamada;
	}

	public void setTempoMaximoChamada(int tempoMaximoChamada) {
		this.tempoMaximoChamada = tempoMaximoChamada;
	}

	public int getNrChamadasMinimoNoSistema() {
		return nrChamadasMinimoNoSistema;
	}

	public void setNrChamadasMinimoNoSistema(int nrChamadasMinimoNoSistema) {
		this.nrChamadasMinimoNoSistema = nrChamadasMinimoNoSistema;
	}

	public int getNrChamadasMedioNoSistema() {
		return nrChamadasMedioNoSistema;
	}

	public void setNrChamadasMedioNoSistema(int nrChamadasMedioNoSistema) {
		this.nrChamadasMedioNoSistema = nrChamadasMedioNoSistema;
	}

	public int getNrChamadasMaximoNoSistema() {
		return nrChamadasMaximoNoSistema;
	}

	public void setNrChamadasMaximoNoSistema(int nrChamadasMaximoNoSistema) {
		this.nrChamadasMaximoNoSistema = nrChamadasMaximoNoSistema;
	}

	public int getTaxaOcupacaoCanaisC1() {
		return taxaOcupacaoCanaisC1;
	}

	public void setTaxaOcupacaoCanaisC1(int taxaOcupacaoCanaisC1) {
		this.taxaOcupacaoCanaisC1 = taxaOcupacaoCanaisC1;
	}

	public int getTaxaOcupacaoCanaisC2() {
		return taxaOcupacaoCanaisC2;
	}

	public void setTaxaOcupacaoCanaisC2(int taxaOcupacaoCanaisC2) {
		this.taxaOcupacaoCanaisC2 = taxaOcupacaoCanaisC2;
	}
}
