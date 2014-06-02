package controllers;

import models.enums.TipoChamada;
import models.enums.TipoDuracao;
import utils.MathsUtils;
import utils.Utils;
import views.MainInterface;

public class ChamadaController {

	public static int getDuracaoChamada(TipoDuracao duracao, int a, int b, int c) {
		int duracaoChamada;
		if (duracao.equals(TipoDuracao.CONSTANTE)) {
			duracaoChamada = a;
		} else if (duracao.equals(TipoDuracao.NORMAL)) {
			duracaoChamada = MathsUtils.Normal(a, b);
		} else if (duracao.equals(TipoDuracao.TRIANGULAR)) {
			duracaoChamada = MathsUtils.Triangular(a, b, c);
		} else if (duracao.equals(TipoDuracao.UNIFORME)) {
			duracaoChamada = MathsUtils.Uniforme(a, b);
		} else {
			duracaoChamada = MathsUtils.Expo(a);
		}

		return duracaoChamada;
	}

	public static TipoChamada getTipoChamada() {
		int celulaPartida = (int) (Math.random() * 100);
		int celulaChegada = (int) (Math.random() * 100);

		TipoChamada tipoChamada;

		if (celulaPartida <= 50) {
			tipoChamada = getTipoChamadaC1(celulaChegada);
		} else {
			tipoChamada = getTipoChamadaC2(celulaChegada);
		}

		return tipoChamada;
	}

	public static TipoChamada getTipoChamadaC1(int celulaChegada) {
		int probabilidadeC1C1 = Utils.filterByInteger(MainInterface.textFieldC1C1ProbValue.getText());
		int probabilidadeC1C2 = Utils.filterByInteger(MainInterface.textFieldC1C2ProbValue.getText()) + probabilidadeC1C1;

		if (celulaChegada <= probabilidadeC1C1) {
			return TipoChamada.C1C1;
		}
		if (celulaChegada > probabilidadeC1C1 && celulaChegada <= probabilidadeC1C2) {
			return TipoChamada.C1C2;
		}
		return TipoChamada.C1FA;
	}

	public static TipoChamada getTipoChamadaC2(int celulaChegada) {
		int probabilidadeC2C2 = Utils.filterByInteger(MainInterface.textFieldC2C2ProbValue.getText());
		int probabilidadeC2C1 = Utils.filterByInteger(MainInterface.textFieldC2C1ProbValue.getText()) + probabilidadeC2C2;

		if (celulaChegada <= probabilidadeC2C2) {
			return TipoChamada.C2C2;
		}
		if (celulaChegada > probabilidadeC2C2 && celulaChegada <= probabilidadeC2C1) {
			return TipoChamada.C2C1;
		}
		return TipoChamada.C2FA;
	}

}
