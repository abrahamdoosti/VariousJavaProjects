import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService service=Executors.newFixedThreadPool(10);
		
		//submit task and accept a placeholder object for return value
		Future<Integer> future=service.submit(()->{
			System.out.println("inside task, Thread");
			return new Random().nextInt();
			});
		System.out.println("after task is submitted");
		
		try {
			Integer result=future.get();//blocking 
			System.out.println("Result from the task is "+result);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	//we can also create a Task class that implements Callable inerface, Functional Interface
	static class Task implements Callable<Integer>{
		@Override
		public Integer call() throws Exception {
			// TODO Auto-generated method stub
			return new Random().nextInt();
		}
		
	}

}
