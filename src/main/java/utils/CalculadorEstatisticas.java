package utils;

import java.util.ArrayList;

public class CalculadorEstatisticas {

	public static void calcularEstatisticas(Estatistica estatistica) {
		int[] estatisticasNumeroChamadas = calcularMinMedMax(estatistica.getListaNumeroDeChamadasEstatistica());
		estatistica.setNrChamadasMinimoNoSistema(estatisticasNumeroChamadas[0]);
		estatistica.setNrChamadasMedioNoSistema(estatisticasNumeroChamadas[1]);
		estatistica.setNrChamadasMaximoNoSistema(estatisticasNumeroChamadas[2]);

		int[] estatisticasDuracaoChamadas = calcularMinMedMax(estatistica.getListaDuracaoChamadasEstatistica());
		estatistica.setTempoMinimoChamada(estatisticasDuracaoChamadas[0]);
		estatistica.setTempoMedioChamada(estatisticasDuracaoChamadas[1]);
		estatistica.setTempoMaximoChamada(estatisticasDuracaoChamadas[2]);

		int ocupacaoMediaC1 = calcularOcupacaoMedia(estatistica.getListaocupacaoC1Estatistica());
		estatistica.setTaxaOcupacaoCanaisC1(ocupacaoMediaC1);

		int ocupacaoMediaC2 = calcularOcupacaoMedia(estatistica.getListaocupacaoC2Estatistica());
		estatistica.setTaxaOcupacaoCanaisC2(ocupacaoMediaC2);
	}

	private static int calcularOcupacaoMedia(ArrayList<Integer> lista) {
		if (lista.size() == 0) {
			return 0;
		}

		int soma = 0, qtd = 0;

		for (int valor : lista) {
			qtd++;
			soma += valor;
		}

		int media = soma / qtd;
		return media;
	}

	private static int[] calcularMinMedMax(ArrayList<Integer> lista) {
		if (lista.size() == 0) {
			return null;
		}

		int min = Integer.MAX_VALUE;
		int max = 0;
		int soma = 0, qtd = 0;

		for (int valor : lista) {
			if (valor < min) {
				min = valor;
			}
			if (valor > max) {
				max = valor;
			}
			soma += valor;
			qtd++;
		}

		int[] valores = new int[3];

		valores[0] = min;
		valores[1] = soma / qtd;
		valores[2] = max;

		return valores;
	}
}
