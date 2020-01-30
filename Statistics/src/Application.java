import java.util.Scanner;

import com.abraham.dao.FileDAO;
import com.abraham.util.Statistics;

public class Application {
	private static String fileName = "J:\\inputfile.txt";

	public static void main(String[] args) {
		System.out.println("Please enter \n 1 for Mode\n 2 for Median \n 3 for Mode");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			System.out.println("Mean: " + Statistics.getMean(FileDAO.getFloatList(fileName)));
			break;
		case 2:
			System.out.println("Median: " + Statistics.getMedian(FileDAO.getFloatList(fileName)));
			break;
		case 3:
			System.out.println("Mode: " + Statistics.getMode(FileDAO.getFloatList(fileName)));
			break;
		default:
			System.out.println("Please enter \n 1 for Mode\n 2 for Median \n 3 for Mode");
			break;
		}

	}
}