package controllers;

import models.enums.TipoChamada;
import utils.Utils;
import views.MainInterface;

public class TipoChamadaController {
	
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
