package com.abraham;

public class SystematicallyIncreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("should return 1: " + isSystematicallyIncreasing(new int[] { 1 }));
		System.out.println("should return 1: " + isSystematicallyIncreasing(new int[] { 1, 1, 2 }));
		System.out.println("should return 1: " + isSystematicallyIncreasing(new int[] { 1, 1, 2, 1, 2, 3 }));
		System.out.println("should return 0: " + isSystematicallyIncreasing(new int[] { 1, 1, 2, 1, 2 }));
		System.out.println("should return 0: " + isSystematicallyIncreasing(new int[] { 1, 2, 2, 1, 2, 3 }));

	}

	public static int isSystematicallyIncreasing(int[] a) {
		int currentVal = 1, limit = 1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == currentVal && currentVal <= limit) {
				if (currentVal == limit) {
					currentVal = 1;
					limit++;
				} else
					currentVal++;
			} else
				return 0;

		}
		//This makes sure that there hasn't been a premature end in the array
		//e.g {1,1} this array is prematurely terminated
		if (currentVal != 1 || limit != (a[a.length - 1] + 1)) {
			return 0;
		}
		return 1;

	}

}
