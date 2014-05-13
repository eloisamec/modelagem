package structure;

public class Celulas {

	private String name;
	private int canais;
	
	public Celulas(String name, int canais) {
		this.setName(name);
		this.setCanais(canais);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCanais() {
		return canais;
	}

	public void setCanais(int canais) {
		this.canais = canais;
	}
}
