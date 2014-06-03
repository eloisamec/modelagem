package controllers;

import models.enums.TipoDuracao;
import utils.MathsUtils;
import views.MainInterface;

public class ChamadaController {

	private static int a1;
	private static int b1;
	private static int c1;
	private static int a2;
	private static int b2;
	private static int c2;

	public static int getDuracaoChamada(TipoDuracao duracao, int tipoCelula) {
		a1 = Integer.parseInt(MainInterface.textFieldMinC1.getText());
		b1 = Integer.parseInt(MainInterface.textFieldMedC1.getText());
		c1 = Integer.parseInt(MainInterface.textFieldMaxC1.getText());
		a2 = Integer.parseInt(MainInterface.textFieldMinC2.getText());
		b2 = Integer.parseInt(MainInterface.textFieldMedC2.getText());
		c2 = Integer.parseInt(MainInterface.textFieldMaxC2.getText());

		int duracaoChamada = 0;

		switch (duracao) {
		case CONSTANTE:
			duracaoChamada = getDuracaoConstante(tipoCelula);
			break;
		case EXPONENCIAL:
			duracaoChamada = getDuracaoExponencial(tipoCelula);
			break;
		case NORMAL:
			duracaoChamada = getDuracaoNormal(tipoCelula);
			break;
		case TRIANGULAR:
			duracaoChamada = getDuracaoTriangular(tipoCelula);
			break;
		case UNIFORME:
			duracaoChamada = getDuracaoUniforme(tipoCelula);
			break;
		default:
			duracaoChamada = 1;
			break;
		}

		return duracaoChamada > 0 ? duracaoChamada : 1;
	}

	private static int getDuracaoConstante(int tipoCelula) {
		int duracaoChamada = 0;

		if (tipoCelula == 1) {
			duracaoChamada = a1;
		} else {
			duracaoChamada = a2;
		}

		return duracaoChamada;
	}

	private static int getDuracaoExponencial(int tipoCelula) {
		int duracaoChamada = 0;

		if (tipoCelula == 1) {
			duracaoChamada = MathsUtils.expo(a1);
		} else {
			duracaoChamada = MathsUtils.expo(a2);
		}

		return duracaoChamada;
	}

	private static int getDuracaoNormal(int tipoCelula) {
		int duracaoChamada = 0;

		if (tipoCelula == 1) {
			duracaoChamada = MathsUtils.normal(a1, b1);
		} else {
			duracaoChamada = MathsUtils.normal(a2, b2);
		}

		return duracaoChamada;
	}

	private static int getDuracaoTriangular(int tipoCelula) {
		int duracaoChamada = 0;

		if (tipoCelula == 1) {
			duracaoChamada = MathsUtils.triangular(a1, b1, c1);
		} else {
			duracaoChamada = MathsUtils.triangular(a2, b2, c2);
		}

		return duracaoChamada;
	}

	private static int getDuracaoUniforme(int tipoCelula) {
		int duracaoChamada = 0;

		if (tipoCelula == 1) {
			duracaoChamada = MathsUtils.uniforme(a1, b1);
		} else {
			duracaoChamada = MathsUtils.uniforme(a2, b2);
		}

		return duracaoChamada;
	}
}
