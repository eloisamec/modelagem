package structure;

//representa um evento
//existem dois tipos de evento, um quando uma nova chamda é criado e a outr para liberar a linha de uma célula, indicando que
//a chamda acabou
//  chegada  tipo = 0
//  saida tipo  = 1
// trocar de celula tipo = 2
public class Evento {

	private double tempo;
	private int tipo;
	private Chamada chamada;
	private Long id;

	public Evento(int tipo, double tempo, Long id, Chamada chamada) {
		this.tipo = tipo;
		this.tempo = tempo;
		this.id = id;
		this.chamada = chamada;
	}

	public double getTempo() {
		return tempo;
	}

	public void setTempo(double tempo) {
		this.tempo = tempo;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Chamada getChamada() {
		return chamada;
	}

	public void setChamada(Chamada chamada) {
		this.chamada = chamada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
