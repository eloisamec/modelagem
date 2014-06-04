package views.validation;

import utils.Utils;
import views.MainInterface;

public class ValidateTextFieldsOnlyDigits {

	public static void validate() {
		MainInterface.textFieldCanaisC1.setText(Utils.filterByInteger(MainInterface.textFieldCanaisC1.getText()) + "");
		MainInterface.textFieldCanaisC2.setText(Utils.filterByInteger(MainInterface.textFieldCanaisC2.getText()) + "");
		MainInterface.textFieldExpoC1.setText(Utils.filterByInteger(MainInterface.textFieldExpoC1.getText()) + "");
		MainInterface.textFieldExpoC2.setText(Utils.filterByInteger(MainInterface.textFieldExpoC2.getText()) + "");
		MainInterface.textFieldMinC1.setText(Utils.filterByInteger(MainInterface.textFieldMinC1.getText()) + "");
		MainInterface.textFieldMedC1.setText(Utils.filterByInteger(MainInterface.textFieldMedC1.getText()) + "");
		MainInterface.textFieldMaxC1.setText(Utils.filterByInteger(MainInterface.textFieldMaxC1.getText()) + "");
		MainInterface.textFieldMinC2.setText(Utils.filterByInteger(MainInterface.textFieldMinC2.getText()) + "");
		MainInterface.textFieldMedC2.setText(Utils.filterByInteger(MainInterface.textFieldMedC2.getText()) + "");
		MainInterface.textFieldMaxC2.setText(Utils.filterByInteger(MainInterface.textFieldMaxC2.getText()) + "");
		MainInterface.textFieldDuracaoSimulacao.setText(Utils.filterByInteger(MainInterface.textFieldDuracaoSimulacao.getText()) + "");
		MainInterface.textFieldC1C1ProbValue.setText(Utils.filterByInteger(MainInterface.textFieldC1C1ProbValue.getText()) + "");
		MainInterface.textFieldC1C2ProbValue.setText(Utils.filterByInteger(MainInterface.textFieldC1C2ProbValue.getText()) + "");
		MainInterface.textFieldC1FAProbValue.setText(Utils.filterByInteger(MainInterface.textFieldC1FAProbValue.getText()) + "");
		MainInterface.textFieldC2C2ProbValue.setText(Utils.filterByInteger(MainInterface.textFieldC2C2ProbValue.getText()) + "");
		MainInterface.textFieldC2C1ProbValue.setText(Utils.filterByInteger(MainInterface.textFieldC2C1ProbValue.getText()) + "");
		MainInterface.textFieldC2FAProbValue.setText(Utils.filterByInteger(MainInterface.textFieldC2FAProbValue.getText()) + "");
	
		// TODO Soma 100%?
	}
}
