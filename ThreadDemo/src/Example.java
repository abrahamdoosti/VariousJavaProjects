public class Example extends Thread {

	public Example() {
		setDaemon(true);
	}

	@Override
	public void run() {
		int i = 0;
		while (i < 100) {
			try {
				i++;
				System.out.println("Inside run method of Thread");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	 public static void main(String[] args) throws InterruptedException {
	 Example thread = new Example();
	 thread.start();
	 Thread.currentThread().sleep(10000);
	 }
}