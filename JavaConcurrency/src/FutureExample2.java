import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureExample2 {

	public static void main(String[] args) {
		// TODO Future with exception
		ExecutorService service = Executors.newFixedThreadPool(10);

		Callable<Integer> task = () -> {
			Thread.sleep(300);
			System.out.println("This is Thread " + Thread.currentThread().getName());
			return new Random().nextInt();
		};
		
		Callable<String> task1=()->{
			throw new IllegalStateException("Throw exception in Thread "+Thread.currentThread().getName());
		};

		// submit task and accept a placeholder object for return value
		Future<Integer> future = service.submit(task);
		Future<String> future1 = service.submit(task1);

		try {
			//Integer result = future.get(100, TimeUnit.MILLISECONDS);// blocking
			//System.out.println("Result from the task is " + result);
			System.out.println("The result is "+future1.get(100,TimeUnit.MILLISECONDS));
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			service.shutdown();
		}

	}	

}
