

public class MyMath {
	
	public static void main(String[] args) {
		int i=5;
		System.out.println(factorial(i));
	}
 public static int factorial(int number) {
	 try {
		Thread.sleep(10);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 if(number==0|| number==1) {
		 return 1;
	 }
	 else {
		 return factorial(number-1)*number;
	 }
 }


}
