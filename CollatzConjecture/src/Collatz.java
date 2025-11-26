import java.util.ArrayList;
import java.util.List;

public class Collatz {
	/**
	 * This method computes the Collatz Object for any starting number.
	 */

	public static CollatzObject computeCollatz(long startingNumber) {
		if (startingNumber < 1) {
			throw new IllegalArgumentException("The starting number has to be a positive integer!");
		}
		List<Long> series = new ArrayList();
		long iterations = 0;
		long highestValue = startingNumber;
		long currentNumber = startingNumber;
		while (currentNumber > 1) {
			currentNumber = getNext(currentNumber);
			if (currentNumber > highestValue) {
				highestValue = currentNumber;
			}
			iterations++;
			series.add(currentNumber);
		}

		return new CollatzObject(startingNumber, iterations, highestValue,series);

	}

	public static long getNext(long num) {
		/**
		 * Collatz function definition
		 */
		if (num % 2 == 0) {
			num /= 2;

		} else {
			if ((num - 1) / 3 > Long.MAX_VALUE) {
				throw new ArithmeticException("Overflow detected while computing");
			}
			num = num * 3 + 1;
		}
		return num;
	}

	public static CollatzObject[] getLongestCollatzIteration(long maxNum) {

		CollatzObject maxIterationCollatz = computeCollatz(1);

		CollatzObject maxValueCollatz = computeCollatz(1);
		for (long i = 1; i <= maxNum; i++) {
			CollatzObject collatzObject = computeCollatz(i);

			if (collatzObject.getCollatzLength() > maxIterationCollatz.getCollatzLength()) {
				maxIterationCollatz = collatzObject;
			}
			if (collatzObject.getHighestValue() > maxValueCollatz.getHighestValue()) {
				maxValueCollatz = collatzObject;
			}
		}
		return new CollatzObject[] { maxIterationCollatz, maxValueCollatz };

	}
	
	  
	/*
	 * public static long[] getCollatzSeries(long num) { long[] series = new
	 * long[computeTime(num)]; int index = 0; while (num > 1) { series[index] = num;
	 * index++; num = getNext(num); if (num == 1) { series[index] = num; } } return
	 * series;
	 * 
	 * }
	 */
	  
	 
}
