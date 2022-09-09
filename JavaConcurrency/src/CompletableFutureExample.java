import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;
//Source: https://ducmanhphan.github.io/2020-02-10-How-to-use-CompletableFuture-Callable-in-Java/ 

public class CompletableFutureExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService service=Executors.newSingleThreadExecutor();
		
		//using runAsyc() method
		Runnable task=()->System.out.println("Hello World");
		//Future<?> future=service.submit(task);
		CompletableFuture<Void> compeletableFuture=CompletableFuture.runAsync(task,service);

		//using spplyAsync()
		Supplier<String> supplier = () -> readPage("https://google.com");		
		CompletableFuture<String> completableFuture2=CompletableFuture.supplyAsync(supplier,service);
		
		/*Be careful that a supplier cannot throw any checked exceptions 
		because the supplier’s signature does not declare any checked exception, 
		this is the main difference between callable and supplier. 
		So if our Callable is throwing a checked exception, we cannot make it a supplier.

		Then we have two pattern for working with CompletableFuture:

		runAsync() method that takes a Runnable interface.
		supplyAsync() method that takes a Supplier.*/
	}

	private static String readPage(String string) {
		// TODO Auto-generated method stub
		return "https://google.com";
	}

}
