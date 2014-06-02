package utils;

public class MathsUtils {

	public static double rand() {
		return Math.random();
	}

	public static int expo(int lambda) {
		double r = rand();
		double x = (-lambda) * (Math.log(1 - r));
		System.out.println(x);
		return (int) x;
	}

	public static int normal(int a, int b) {
		double r1 = rand();
		double r2 = rand();

		double z1 = Math.pow((-2 * Math.log(r1)), 0.5) * Math.cos(r2);
		double x1 = b + (a * z1);

		return (int) x1;
	}

	public static int uniforme(int a, int b) {
		double uniforme = a + ((b - a) * rand());

		return (int) uniforme;
	}

	public static int triangular(int a, int b, int c) {
		double x = 0;
		double random = rand();
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
