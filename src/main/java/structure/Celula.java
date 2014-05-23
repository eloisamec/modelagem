package structure;

public class Celula {

	private String name;
	private Integer canais;
	
	//para estatisticas
	private Integer nrChamadasFinalizdas;
	private Integer nrChamadasPerdidas;
	
	public Celula(String name, Integer canais) {
		this.name = name;
		this.canais = canais;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCanais() {
		return canais;
	}

	public void setCanais(Integer canais) {
		this.canais = canais;
	}

	public Integer getNrChamadasFinalizdas() {
		return nrChamadasFinalizdas;
	}

	public void setNrChamadasFinalizdas(Integer nrChamadasFinalizdas) {
		this.nrChamadasFinalizdas = nrChamadasFinalizdas;
	}

	public Integer getNrChamadasPerdidas() {
		return nrChamadasPerdidas;
	}

	public void setNrChamadasPerdidas(Integer nrChamadasPerdidas) {
		this.nrChamadasPerdidas = nrChamadasPerdidas;
	}
	
	public void increaseNrChamadaFinalizada(){
		this.nrChamadasFinalizdas++;
	}
	
	public void increaseNrChamadaPerdida(){
		this.nrChamadasPerdidas++;
	}
	
	public Integer getNrTotalChamadas(){
		return this.nrChamadasFinalizdas + this.nrChamadasPerdidas;
	}
}
