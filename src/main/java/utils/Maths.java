package utils;

public class Maths {

	public static double Rand() {
		return Math.random();
	}

	public static double Expo(double lambda) {
		double r = Rand();
		double x = (-lambda) * (Math.log(1 - r));

		return x;
	}

	public static double Normal(double a, double b) {
		double r1 = Rand();
		double r2 = Rand();

		double z1 = Math.pow((-2 * Math.log(r1)), 0.5) * Math.cos(r2);
		// double z2 = Math.pow((-2 * Math.log(r1)), 0.5) * Math.sin(r2);

		double x1 = b + (a * z1);
		// double x2 = max + (min * z2);

		return x1;
	}

	public static double Uniforme(double a, double b) {
		return a + ((b - a) * Rand());
	}

	public static double Triangular(double a, double b, double c) {
		double x = 0;
		double random = Rand();
		double dist = (b - a) / (c - a);
		if (random >= 0 && random <= dist) {
			x = a + (Math.sqrt(random * (b - a) * (c - a)));
		}
		if (random > dist && random <= 1) {
			x = c - (Math.sqrt((1 - random) * (c - b) * (c - a)));
		}

		return x;
	}

}
