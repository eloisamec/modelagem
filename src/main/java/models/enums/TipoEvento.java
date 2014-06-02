package models.enums;

public enum TipoEvento {

	CHEGADA, SAIDA, TROCA;

	public static TipoEvento get(String tipoExterno) {
		TipoEvento tipoEvento = null;

		for (TipoEvento tipo : values()) {
			if (tipo.toString().equals(tipoExterno.toUpperCase())) {
				tipoEvento = tipo;
				break;
			}
		}
		return tipoEvento;
	}
}
