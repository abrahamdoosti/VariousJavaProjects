import java.util.concurrent.atomic.AtomicInteger;

public class ThreadMain extends Thread{
	public static int amount = 0;
	public AtomicInteger aInt=new AtomicInteger();

	public static void main(String[] args) {
		ThreadMain thread = new ThreadMain();
		thread.start();
		System.out.println(amount);
		amount++;
		System.out.println(amount);

	}
	
	public void run() {
		amount++;
	}

}
