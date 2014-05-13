package structure;

public class Chamadas {
	
	private int chamadas;
	private double duracao;
	
	public Chamadas(int chamadas, double duracao) {
		this.setChamadas(chamadas);
		this.setDuracao(duracao);
	}

	public int getChamadas() {
		return chamadas;
	}

	public void setChamadas(int chamadas) {
		this.chamadas = chamadas;
	}

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

}
