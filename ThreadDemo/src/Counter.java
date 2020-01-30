
public class Counter {

	long count = 0;

	public  void add(long value) {

		try {
			System.out.println("*** Method execution started by thread " + Thread.currentThread().getName());
			this.count += value;
			System.out.println("Sleeping for 5000 msec inside add method");
			Thread.sleep(5000);
			System.out.println("count= " + this.count);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("*** Method execution completed by thread " + Thread.currentThread().getName());
		}
	}

	public  void subtract(long value) {

		
		try {
			System.out.println("*** Method execution started by thread " + Thread.currentThread().getName());
			this.count -= value;
			System.out.println("Sleeping for 5000 msec inside subtract method");
			Thread.sleep(5000);
			System.out.println("count= " + this.count);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("*** Method execution completed by thread " + Thread.currentThread().getName());
		}

	}
}