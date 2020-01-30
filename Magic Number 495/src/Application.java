import java.util.Arrays;
import java.util.Collections;

public class Application {
	private static final Integer MAGIC_NUM = 495;
	
	public static void main(String[] args) {
		computeMagicNum();
		//Integer[] arr=convertToArray(99);
		Integer n=999;
		//System.out.println(arrayToString(convertToArray(n)));
		

	}	

	public static void computeMagicNum() {
		try {
			Integer number = 100;
			while (number < 999) {
				Integer[] digits = convertToArray(number,3);
				if (digits[0] == digits[1] || digits[0] == digits[2] || digits[1] == digits[2]) {
					number++;
					continue;
				} else {
					MagicNum magNum = isMagicReached(digits, new MagicNum());
					if (magNum.isMagic()) {
						System.out.println("This number converges to 495 after " + magNum.getIterations()
								+ " iterations " + digits[0] + " , " + digits[1] + " , " + digits[2]);
					}
					number++;

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Integer convertToInteger(Integer[] arr) {
		int exponent=arr.length-1;
		Integer number=0;
		for(int i=0;i<arr.length&&exponent>=0;i++) {
			number=(int) (number+arr[i]*Math.pow(10, exponent));
			exponent--;
		}
		return number;
		
	}
		/**
		 * This is when you want to specify length of array
		 * @param n
		 * @param length
		 * @return
		 */
	public static Integer[] convertToArray(Integer n,int length) {
		Integer[] digits=new Integer[length];
		Integer num=n;
		int i=2;
		while(num>0) {
			digits[i]=num%10;
			num=num/10;
			i--;
		}
		return digits;
	}
	
	public static Integer[] convertToArray(Integer n) {
		Integer num = n;
		int exp = 1;
		while ((num / ((int) Math.pow(10, exp))) > 0) {
			exp++;
			num = n;
		}
				
		Integer[] digits=new Integer[exp];
		
		int i=exp-1;
		while(num>0) {
			digits[i]=num%10;
			num=num/10;
			i--;
		}
		return digits;
	}
	
	
	/**
	 * rearrange the array elements in such a way it will give the smallest integer possible
	 * @param number
	 * @return
	 * @throws Exception
	 */
	public static Integer[] getSmallest(final Integer[] number) throws Exception {
		Integer[] num=number.clone();		
		if(number==null || number.length!=3) {
			throw new Exception("Number length is not three");
		}
		Arrays.sort(num);		
		return num;
		
	}
	
	/**
	 * rearrange the array elements in such a way it will give the largest integer possible
	 * @param number
	 * @return
	 * @throws Exception
	 */
	  public static Integer[] getLargest(Integer[] number) throws Exception {		  
			Integer[] num=number.clone();		
			if(number==null || number.length!=3) {
				throw new Exception("Number length is not three");
			}
			Arrays.sort(num,Collections.reverseOrder());
			return num;
	  
	  
	  }
	  /**
	   * check if maxnum-minnum is equal to 495 , if not call itself recursively until it converges to 495
	   * @param digits
	   * @param magicNum
	   * @return
	   * @throws Exception
	   */
	  public static MagicNum isMagicReached(Integer[] digits,MagicNum magicNum) throws Exception {
		    int iter=magicNum.getIterations();
		    magicNum.setIterations(++iter);
		    Integer[] max = getLargest(digits);
			Integer[] min = getSmallest(digits);
			//here we are hard coding for three digit numbers only 
			Integer maxnum=100*max[0]+10*max[1]+max[2];
			Integer minnum=100*min[0]+10*min[1]+min[2];
			if(maxnum-minnum==MAGIC_NUM) {
				magicNum.setMagic(true);
				return magicNum;
			}
			else {
			  return isMagicReached(convertToArray((maxnum-minnum),3),magicNum);
		  }
		  
	  }
	  
	  public static String arrayToString(Integer[] array) {
		  StringBuilder stringBuilder=new StringBuilder();
		  for(Integer integ:array) {
			  if(stringBuilder.length()>=1) {
				  stringBuilder.append(" , ");
			  }
			  stringBuilder.append(integ);
		  }
		  return stringBuilder.toString();
	  }

}
