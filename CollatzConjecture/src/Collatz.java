
public class Collatz {
	/**
	 * This method computes the time taken for a number to converge to 1
	 */

	public static int computeTime(long num) {
		int counter = 1;
		while (num > 1) {
			num = getNext(num);
			counter++;
		}
		return counter;

	}

	public static long getNext(long num) {
		/**
		 * Collatz function definition
		 */
		if (num % 2 == 0) {
			num /= 2;

		} else {
			num = num * 3 + 1;
		}
		return num;
	}

	public static CollatzObject getLongestCollatzTime(long maxNum) {
		CollatzObject collatzObject = new CollatzObject();
//		collatzObject.setCollatzLength(1);
//		collatzObject.setNum(1);
		for (long i = 1; i <= maxNum; i++) {
			long time = computeTime(i);
			if (time > collatzObject.getCollatzLength()) {
				collatzObject.setCollatzLength(time);
				collatzObject.setNum(i);
			}
		}
		return collatzObject;

	}

	public static long[] getCollatzSeries(long num) {
		long[] series = new long[computeTime(num)];
		int index = 0;
		while (num > 1) {
			series[index] = num;
			index++;
			num = getNext(num);
			if(num==1) {				
				series[index] = num;
			}
		}
		return series;

	}

}
