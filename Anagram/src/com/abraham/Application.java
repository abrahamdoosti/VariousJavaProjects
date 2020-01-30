package com.abraham;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		String hayStack = "cacaccc";
		String needle = "acc";
		List<Integer> myList = getAnagramIndexList(hayStack, needle);
		System.out.println(myList.toString());

	}

	public static List<Integer> getAnagramIndexList(String hayStack, String needle) {

		char[] hayStackChars = hayStack.toCharArray();
		char[] needleChars = needle.toCharArray();
		List<Integer> indexList = new ArrayList<>();
		for (int i = 0; i <= hayStackChars.length - needle.length(); i++) {
			if (isMatch(hayStackChars, needleChars, i))
				indexList.add(i);
		}

		return indexList;

	}

	public static boolean isMatch(char[] hayStackChars, char[] needleChars, int index) {

		char[] myNeedle = needleChars.clone();
		
		boolean found = false;
		//in this for loop for every hayStack element check if there is only one corresponding needle element
		for (int hayIndex = index; hayIndex < needleChars.length + index; hayIndex++) {
			found = false;			
			//exit the loop when the first myNeedle element is found and replace that needle element with white 
			//space so that it will not be matched with the next element from hayStack 
			for (int j = 0; j < myNeedle.length; j++) {
				if (hayStackChars[hayIndex] == myNeedle[j]) {
					myNeedle[j] = ' ';					
					found = true;
					break;
				}
			}
			if (found == false)
				return found;
		}
		return found;

	}
}
