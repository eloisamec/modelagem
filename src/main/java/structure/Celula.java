package structure;

public class Celula {

	private String name;
	private Integer canais;
	
	public Celula(String name, Integer canais) {
		this.setName(name);
		this.setCanais(canais);
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
}
