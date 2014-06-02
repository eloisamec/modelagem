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
			tipoChamada = testaTipoChamadaC1(celulaChegada);
		} else {
			tipoChamada = testaTipoChamadaC2(celulaChegada);
		}

		return tipoChamada;
	}

	public static TipoChamada testaTipoChamadaC2(int celulaChegada) {
		int probabilidadeC2C2 = Utils.filterByInteger(MainInterface.textField_3.getText());
		int probabilidadeC2C1 = Utils.filterByInteger(MainInterface.textField_4.getText()) + probabilidadeC2C2;

		if (celulaChegada <= probabilidadeC2C2) {
			return TipoChamada.C2C2;
		}
		if (celulaChegada > probabilidadeC2C2 && celulaChegada <= probabilidadeC2C1) {
			return TipoChamada.C2C1;
		}
		return TipoChamada.C2FA;
	}

	public static TipoChamada testaTipoChamadaC1(int celulaChegada) {
		int probabilidadeC1C1 = Utils.filterByInteger(MainInterface.textField.getText());
		int probabilidadeC1C2 = Utils.filterByInteger(MainInterface.textField_1.getText()) + probabilidadeC1C1;

		if (celulaChegada <= probabilidadeC1C1) {
			return TipoChamada.C1C1;
		}
		if (celulaChegada > probabilidadeC1C1 && celulaChegada <= probabilidadeC1C2) {
			return TipoChamada.C1C2;
		}
		return TipoChamada.C1FA;
	}

}
