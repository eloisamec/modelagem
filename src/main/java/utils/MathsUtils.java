package utils;

public class MathsUtils {

	public static double Rand() {
		return Math.random();
	}

	public static int Expo(int lambda) {
		double r = Rand();
		double x = (-lambda) * (Math.log(1 - r));
		System.out.println(x);
		return (int) x;
	}

	public static int Normal(int a, int b) {
		double r1 = Rand();
		double r2 = Rand();

		double z1 = Math.pow((-2 * Math.log(r1)), 0.5) * Math.cos(r2);
		double x1 = b + (a * z1);

		return (int) x1;
	}

	public static int Uniforme(int a, int b) {
		double uniforme = a + ((b - a) * Rand());

		return (int) uniforme;
	}

	public static int Triangular(int a, int b, int c) {
		double x = 0;
		double random = Rand();
		double dist = (b - a) / (c - a);
		if (random >= 0 && random <= dist) {
			x = a + (Math.sqrt(random * (b - a) * (c - a)));
		}
		if (random > dist && random <= 1) {
			x = c - (Math.sqrt((1 - random) * (c - b) * (c - a)));
		}

		return (int) x;
	}

}
