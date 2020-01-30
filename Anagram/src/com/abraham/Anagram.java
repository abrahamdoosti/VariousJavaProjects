package com.abraham;

public class Anagram {
	public static void main(String[] args) {
		System.out.println(isAnagram(new char[] { 's', 'i', 't' }, new char[] { 'i', 't', 's' }));
		System.out.println(isAnagram(new char[] { 'p', 'o', 'o','l' }, new char[] { 'l', 'o', 'o','p' }));
		System.out.println(isAnagram(new char[] { 'p', 'o', 'l','e' }, new char[] { 'p', 'o', 'o','l' }));
		System.out.println(isAnagram(new char[] { ' ', ' ', ' ',' ' }, new char[] { ' ', ' ', ' ' }));
	}

	public static boolean isAnagram(char[] a1, char[] a2) {
		//copy needed because we don't want to update the original array
		//so we need the copy so that we can modify it
		char[] myChars = new char[a2.length];
		for (int i = 0; i < a2.length; i++) {
			myChars[i] = a2[i];
		}
		
		if(a1.length!=a2.length)
			return false;

		for (int j = 0; j < a1.length; j++) {
			boolean found = false;
			for (int k = 0; k < myChars.length && found == false; k++) {
				if (a1[j] == myChars[k]) {
					myChars[k] = ' ';
					found = true;
				}
			}
			if (!found) {
				return false;
			} else {
				found = false;
			}
		}
		return true;
	}

}
