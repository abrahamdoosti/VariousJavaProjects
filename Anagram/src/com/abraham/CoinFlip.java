package com.abraham;

import java.util.Random;

public class CoinFlip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		boolean[] myArray = new boolean[] { false, true, false };
		while (!flipAdjCoins(myArray)) {
			System.out.println(i + "th trial");
			i++;
		}
		for(boolean b:myArray ){
			System.out.print(b+" ");
		}

	}

	public static boolean flipAdjCoins(boolean[] myArr) {

		int index = new Random().nextInt(myArr.length-1);
		myArr[index] = !(myArr[index]);
		myArr[index + 1] = !(myArr[index + 1]);
		for (boolean b : myArr) {
			if (b == false) {
				return false;
			}
		}
		return true;
	}

}
