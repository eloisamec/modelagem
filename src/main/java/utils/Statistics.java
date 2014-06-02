package utils;

public class Statistics {

	private static int nrChamadasChegandoNoSistema;
	private static int nrChamadasFinalizadas;
	private static int nrChamadasPerdidasC1;
	private static int nrChamadasPerdidasC2;
	private static int nrChamadasPerdidasFA;
	private static int tempoMinimoChamada;
	private static int tempoMedioChamada;
	private static int tempoMaximoChamada;

	public Statistics() {
		setNrChamadasChegandoNoSistema(0);
		setNrChamadasFinalizadas(0);
		setNrChamadasPerdidasC1(0);
		setNrChamadasPerdidasC2(0);
		setNrChamadasPerdidasFA(0);
	}

	public static void setNrChamadasChegandoNoSistema(int nrChamadasChegandoNoSistema) {
		Statistics.nrChamadasChegandoNoSistema = nrChamadasChegandoNoSistema;
	}

	public static void increaseNrChamadasChegandoNoSistema() {
		nrChamadasChegandoNoSistema++;
	}

	public static int getNrChamadasChegandoNoSistema() {
		return nrChamadasChegandoNoSistema;
	}

	public static int getNrChamadasFinalizadas() {
		return nrChamadasFinalizadas;
	}

	public static void setNrChamadasFinalizadas(int nrChamadasFinalizdas) {
		nrChamadasFinalizadas = nrChamadasFinalizdas;
	}

	public static void increaseNrChamadasFinalizadas() {
		nrChamadasFinalizadas++;
	}

	public static int getNrChamadasPerdidasC1() {
		return nrChamadasPerdidasC1;
	}

	public static void setNrChamadasPerdidasC1(int nrChamadasPerdidas) {
		nrChamadasPerdidasC1 = nrChamadasPerdidas;
	}

	public static void increaseNrChamadasPerdidasC1() {
		nrChamadasPerdidasC1++;
	}

	public static int getNrChamadasPerdidasC2() {
		return nrChamadasPerdidasC2;
	}

	public static void setNrChamadasPerdidasC2(int nrChamadasPerdidasC2) {
		Statistics.nrChamadasPerdidasC2 = nrChamadasPerdidasC2;
	}

	public static void increaseNrChamadasPerdidasC2() {
		nrChamadasPerdidasC2++;
	}

	public static int getNrChamadasPerdidasFA() {
		return nrChamadasPerdidasFA;
	}

	public static void setNrChamadasPerdidasFA(int nrChamadasPerdidasFA) {
		Statistics.nrChamadasPerdidasFA = nrChamadasPerdidasFA;
	}

	public static void increaseNrChamadasPerdidasFA() {
		nrChamadasPerdidasC2++;
	}

	public static int getTempoMinimoChamada() {
		return tempoMinimoChamada;
	}

	public static void setTempoMinimoChamada(int tempoMinimoChamada) {
		Statistics.tempoMinimoChamada = tempoMinimoChamada;
	}

	public static int getTempoMedioChamada() {
		return tempoMedioChamada;
	}

	public static void setTempoMedioChamada(int tempoMedioChamada) {
		Statistics.tempoMedioChamada = tempoMedioChamada;
	}

	public static int getTempoMaximoChamada() {
		return tempoMaximoChamada;
	}

	public static void setTempoMaximoChamada(int tempoMaximoChamada) {
		Statistics.tempoMaximoChamada = tempoMaximoChamada;
	}
}
