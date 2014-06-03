package models;

public class Celula {

	private int capacidadeCanais;
	private int canaisOcupados;

	public Celula(int capacidadeCanais) {
		this.canaisOcupados = 0;
		this.capacidadeCanais = capacidadeCanais;
	}

	public boolean hasCanaisDisponiveis() {
		return canaisOcupados < capacidadeCanais;
	}

	public int getCapacidadeCanais() {
		return capacidadeCanais;
	}

	public void setCapacidadeCanais(int capacidadeCanais) {
		this.capacidadeCanais = capacidadeCanais;
	}

	public int getCanaisOcupados() {
		return canaisOcupados;
	}

	public void setCanaisOcupados(int canaisOcupados) {
		this.canaisOcupados = canaisOcupados;
	}

	public void incrementaCanaisOcupados() {
		this.canaisOcupados++;
	}

	public void decrementarCanaisOcupados() {
		this.canaisOcupados--;
	}

	public Integer getOcupacao() {
		double d1 = canaisOcupados;
		double d2 = capacidadeCanais;
		double ocupacao = (d1 / d2) * 100;
		return (int) ocupacao;
	}

}
