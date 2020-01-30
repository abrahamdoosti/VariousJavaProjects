package com.abraham.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Statistics {

	public static Float getMean(List<Float> floatList) {
		Float total = 0f;
		if (floatList == null) {
			throw new NullPointerException();
		}
		for (Float fl : floatList) {
			total = total + fl;
		}
		return total / floatList.size();

	}

	public static Float getMedian(List<Float> floatList) {
		if (floatList == null) {
			throw new NullPointerException();
		}
		Collections.sort(floatList);
		int middleIndex = floatList.size() / 2;

		if (floatList.size() % 2 == 0) {
			return (floatList.get(middleIndex - 1) + floatList.get(middleIndex)) / 2.0f;
		} else
			return floatList.get(middleIndex);
	}

	public static Float getMode(List<Float> floatList) {
		if (floatList == null) {
			throw new NullPointerException();
		}

		List<Float> distinctElementList = new ArrayList<>();
		Float mode = 0f;
		int modeFreq = 0;

		for (float fl : floatList) {
			if (!distinctElementList.contains(fl))
				distinctElementList.add(fl);
		}
		/**
		 * There will be no mode when all the elements are unique
		 */
		if(floatList.size()==distinctElementList.size()){
			return null;
		}
		/**
		 * if there are two or more modes this will consider the first mode as the mode value
		 */
		for(Float fl:distinctElementList){
			int occurence=countOccurence(floatList,fl);
			if(occurence>modeFreq)
			{
				mode=fl;
				modeFreq=occurence;
			}
		}
		return mode;

	}

	private static int countOccurence(List<Float> floatList, Float flt) {
		int counter = 0;
		for (Float fl : floatList) {
			if (flt.equals(fl))
				counter++;
		}
		return counter;
	}

}
