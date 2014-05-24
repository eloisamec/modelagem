package utils;


// Ver possibilidade de alterar esse nome!
public class Estatisticas {
	
	public int nrChamadasChegandoNoSistema;
	public double tempoEntreChegadas;
	private Integer nrChamadasFinalizadas;
	private Integer nrChamadasPerdidas;
	
	public void setNrChamadasChegandoNoSistema(double tec) {
		nrChamadasChegandoNoSistema = Maths.Poisson(tec); 
	}
	
	public int getNrChamadasChegandoNoSistema() {
		return nrChamadasChegandoNoSistema;
	}
	
	public void setTempoEntreChegadas(int expo) {
		tempoEntreChegadas = Maths.Expo(expo);
	}
	
	public double getTempoEntreChegadas() {
		return tempoEntreChegadas;
	}
	
	public int getNrChamadasFinalizadas() {
		return nrChamadasFinalizadas;
	}

	public void setNrChamadasFinalizadas(int nrChamadasFinalizdas) {
		this.nrChamadasFinalizadas = nrChamadasFinalizdas;
	}

	public int getNrChamadasPerdidas() {
		return nrChamadasPerdidas;
	}

	public void setNrChamadasPerdidas(int nrChamadasPerdidas) {
		this.nrChamadasPerdidas = nrChamadasPerdidas;
	}
	
	public void increaseNrChamadaFinalizada(){
		this.nrChamadasFinalizadas++;
	}
	
	public void increaseNrChamadaPerdida(){
		this.nrChamadasPerdidas++;
	}
	
	public int getNrTotalChamadas(){
		return this.nrChamadasFinalizadas + this.nrChamadasPerdidas;
	}

}
