package models.enums;

// enum quem define o tipo de chamada
public enum TipoChamada {

	C1C1, C1C2, C1FA, C2C1, C2C2, C2FA;

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
}
