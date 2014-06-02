package utils;

public class Utils {

	public static int filterByInteger(String text) {
		String number = "";
		for (int index = 0; index < text.length(); index++) {
			char digit = text.charAt(index);
			if (Character.isDigit(digit)) {
				number += digit + "";
			}
		}
		if (number.length() >= (Integer.MAX_VALUE + "").length()) {
			return Integer.MAX_VALUE;
		}
		return number.length() == 0 ? 0 : Integer.parseInt(number);
	}
}
