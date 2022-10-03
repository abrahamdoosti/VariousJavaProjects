import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start=System.currentTimeMillis();
       CompletableFuture<Integer> result1=computeFactorial(10);
       CompletableFuture<Integer> result2=computeFactorial(10);
       CompletableFuture<Integer> result3=computeFactorial(10);
       CompletableFuture<Integer> result4=computeFactorial(10);
       CompletableFuture<Integer> result5=computeFactorial(10);
      
       try {
    	   //List<Integer> ints=new ArrayList<>();
		Integer int1=result1.get();	
		Integer int2=result2.get();
		Integer int3=result3.get();
		Integer int4=result4.get();
		Integer int5=result5.get();

		System.out.println(int1);
		System.out.println(int2);
		System.out.println(int3);
		System.out.println(int4);
		System.out.println(int5);
		System.out.println("time taken "+ (System.currentTimeMillis()-start));
		
		 start=System.currentTimeMillis();
			System.out.println(MyMath.factorial(10));
			System.out.println(MyMath.factorial(10));
			System.out.println(MyMath.factorial(10));
			System.out.println(MyMath.factorial(10));
			System.out.println(MyMath.factorial(10));
			System.out.println("time taken "+ (System.currentTimeMillis()-start));
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	private static CompletableFuture<Integer>  computeFactorial(int number){
		CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> MyMath.factorial(number));
		/*
		 * while (!completableFuture.isDone()) {
		 * System.out.println("CompletableFuture is not finished yet..."); }
		 */
		return completableFuture;
	}

	
	
	

}
