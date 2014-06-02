package models.enums;

// enum que define o tipo de duracao da chamada
public enum TipoDuracao {

	CONSTANTE, NORMAL, TRIANGULAR, UNIFORME, EXPONENCIAL;

	public static TipoDuracao get(String tipoExterno) {
		TipoDuracao tipoDuracao = null;

		for (TipoDuracao tipo : values()) {
			if (tipo.toString().equals(tipoExterno.toUpperCase())) {
				tipoDuracao = tipo;
				break;
			}
		}
		return tipoDuracao;
	}
}
