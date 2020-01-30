package com.abraham;

public class ClosestSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={13, 5, 3, -1, -9, 20, 5, -17, 20, -11, -6, 1, 17, 18, 20, -6, 11, 12, 3, -8};
		int[] b={1, 1, -18, -3, -9, 16, 5, 13, -2, 4, -9, -16, -20, 13, -3, 10, 20, -5, -20, 2};
		System.out.println(closestSequence2(a, b));

	}

	public static int closestSequence2(int[] a, int[] b) {
		int[] temp;
		int[] aCopy = a.clone();
		int[] bCopy = b.clone();
		if (aCopy.length > bCopy.length) {
			temp = aCopy;
			aCopy = bCopy;
			bCopy = temp;
		}
		int[] result = new int[aCopy.length];
		int totalDiff = 0;
		int resultIndex = 0;
		for (int i = 0; i < aCopy.length; i++) {
			int minDifference = -1, index = -1;
			for (int j = 0; j < bCopy.length; j++) {
				if (bCopy[j] <= 1000 && Math.abs(aCopy[i] - bCopy[j]) < minDifference && minDifference != -1) {
					minDifference = Math.abs(aCopy[i] - bCopy[j]);
					index = j;
				} else if (bCopy[j] <= 1000 && minDifference == -1) {
					minDifference = Math.abs(aCopy[i] - bCopy[j]);
					index = j;
				}

			}
			if (index != -1) {
				result[resultIndex] = bCopy[index];
				bCopy[index] = 1001;
				resultIndex++;
				totalDiff = totalDiff + minDifference;
			}

		}
		return totalDiff;
	}
	
	public double add(double a,int b){
		return 1;
	}
	public double add(int a,int b){
		return 1.0;
	}
	
	

}
