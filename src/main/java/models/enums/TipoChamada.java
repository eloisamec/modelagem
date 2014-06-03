package models.enums;

public enum TipoChamada {

	C1C1(1), C1C2(1), C1FA(1), C2C1(2), C2C2(2), C2FA(2);

	private int tipoOrigemChamada;

	private TipoChamada(int tipo) {
		tipoOrigemChamada = tipo;
	}

	public static TipoChamada get(String tipoExterno) {
		TipoChamada tipoChamada = null;

		for (TipoChamada tipo : values()) {
			if (tipo.toString().equals(tipoExterno.toUpperCase())) {
				tipoChamada = tipo;
				break;
			}
		}
		return tipoChamada;
	}

	public int getTipoOrigemChamada() {
		return tipoOrigemChamada;
	}

}
