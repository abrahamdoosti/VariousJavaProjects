package com.abraham;

public class CharStarPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] answer=getDistinctElements(new char[] { 'a', 'b', 'c', 'a', 'a', 'b' });
		getStarElements(new char[] { 'a', 'b', 'c', 'a', 'a', 'b' });

	}

	public static int computeLength(char[] chars) {
		int count = 0;
		for (int i = 0; i < chars.length; i++) {
			boolean dupFound = false;
			for (int j = 0; j < i && dupFound == false; j++) {
				if (chars[i] == chars[j]) {
					dupFound = true;
				}
			}
			if (!dupFound)
				count++;

		}
		return count;
	}

	public static char[] getDistinctElements(char[] chars) {
		char[] myChars = new char[computeLength(chars)];
		int index = 0;
		for (int i = 0; i < chars.length; i++) {
			boolean dupFound = false;
			for (int j = 0; j <i && dupFound == false; j++) {
				if (chars[i] == chars[j]) {
					dupFound = true;
				}
			}
			if (!dupFound) {
				myChars[index] = chars[i];
				index++;
			}

		}
		return myChars;

	}
	
	public static void getStarElements(char[] chars) {
		char[] myChars=getDistinctElements(chars);
//		int[] repetition=new int[myChars.length];
		int count=0;
		int index=0;
		for(int i=0;i<myChars.length;i++){	
			System.out.print(myChars[i]+"--");
			for(int j=0;j<chars.length;j++){
				if(chars[j]==myChars[i])
					System.out.print("*");
			}
			System.out.println();
			
			
		}
		
	}
	

}
