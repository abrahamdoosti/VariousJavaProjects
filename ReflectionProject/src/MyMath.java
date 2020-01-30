
public class MyMath {
	
	/**
	 * Adds two integers and gives back the result
	 * @param n1
	 * @param n2
	 * @return
	 */
	private int adderMethod(int n1,int n2){
		return n1+n2;
		
	}
	public int subMethod(int n1,int n2){
		return n1-n2;
		
	}
	public int mulrMethod(int n1,int n2){
		return n1*n2;
		
	}
	/**
	 * Divides two integers and gives back the result
	 * @param n1
	 * @param n2
	 * @return
	 */
	public double divMethod (int n1,int n2){
		if(n2==0)
			throw new ArithmeticException();
		return n1/n2;
		
	}

}
