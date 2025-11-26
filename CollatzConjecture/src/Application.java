

public class Application {

	public static void main(String[] args) {
		long maxStartingNumber=1000;

		CollatzObject[] maxValues=Collatz.getLongestCollatzIteration(maxStartingNumber);
		System.out.println("Longest Collatz series for numbers less than "+maxStartingNumber+" is "+
				maxValues[0].getCollatzLength()+" for the starting number "+maxValues[0].getStartingNumber()+" and maxValue reached for this starting number is "+maxValues[0].getHighestValue());
		System.out.println("Highest Value reached for starting numbers less than "+maxStartingNumber+" is "+
				maxValues[1].getHighestValue()+" for the starting number "+maxValues[1].getStartingNumber()+" and the series length was "+maxValues[1].getSeries().size());
		/*
		 * System.out.println("Longest Collatz series for numbers less than "
		 * +maxStartingNumber+" is "+
		 * maxValues[0].getCollatzLength()+" for the number "+maxValues[0].
		 * getStartingNumber()+" and the series is "+maxValues[0].getSeries().toString()
		 * +" series length is "+maxValues[0].getSeries().size());
		 */

	}

}
