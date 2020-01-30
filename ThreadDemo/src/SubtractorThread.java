
public class SubtractorThread extends Thread {

	private Counter counter;

	public SubtractorThread(Counter counter) {
		this.counter = counter;
	}

	public void run() {
		//System.out.println("Starting thread "+ this.getName());
		counter.subtract(1);
		//System.out.println(this.getName()+" is complete");
		
	}
}
