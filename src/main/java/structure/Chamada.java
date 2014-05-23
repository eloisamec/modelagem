package structure;

import enumeration.TipoEnum;

public class Chamada {
	
	private double duracao;
	private TipoEnum tipo;
	
	public Chamada(double duracao, TipoEnum tipo) {
		this.duracao = duracao;
		this.tipo = tipo;
	}

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	public TipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}

}
