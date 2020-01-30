package com.abraham;

public class CharToInt {

	public static void main(String[] args) {
		System.out.println(charToDigit(new byte[] { '1', '2', '3' }));
		System.out.println(charToDigit(new byte[] { '1', '?', '3' }));
		System.out.println(charToDigit(new byte[] {}));
	}

	public static int charToDigit(byte[] chars) {
		int sum = 0;
		if (chars.length == 0) {
			return -1;
		}
		for (int i = chars.length - 1; i >= 0; i--) {
			if (isDigit(chars[i])) {
				int num = chars[i] - 48;
				int j = chars.length - 1 - i;
				while (j > 0) {
					num = num * 10;
					j--;
				}
				sum += num;

			} else {
				return -1;
			}
		}
		return sum;

	}

	public static boolean isDigit(byte a) {
		if (a >= 48 && a <= 57) {
			return true;
		}
		return false;

	}

}
