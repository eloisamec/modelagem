package utils;


// Ver possibilidade de alterar esse nome!
public class Estatisticas {
	
	private int nrChamadasChegandoNoSistema;
	private double tempoEntreChegadas;
	private Integer nrChamadasFinalizadas;
	private Integer nrChamadasPerdidas;
	
	public void Estatisticas(){
		this.nrChamadasChegandoNoSistema = 0;
		this.nrChamadasFinalizadas = 0;
		this.nrChamadasPerdidas = 0;
		this.tempoEntreChegadas = 0;
	}
	
	public void setNrChamadasChegandoNoSistema() {
		nrChamadasChegandoNoSistema++; 
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
