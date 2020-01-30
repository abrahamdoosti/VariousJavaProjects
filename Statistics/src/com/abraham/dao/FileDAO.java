package com.abraham.dao;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileDAO {
	public static List<Float> getFloatList(String fileName) {
		BufferedReader bufferedReader = null;
		StringTokenizer stringTokenizer = null;
		List<Float> floatList = new ArrayList<Float>();
		String lineData;
		try {
			bufferedReader = new BufferedReader(new FileReader(fileName));
			while ((lineData = bufferedReader.readLine()) != null) {
				stringTokenizer = new StringTokenizer(lineData, ",");
				while (stringTokenizer.hasMoreTokens()) {
					floatList.add(Float.valueOf(stringTokenizer.nextToken()));

				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

		finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return floatList;
	}
}
