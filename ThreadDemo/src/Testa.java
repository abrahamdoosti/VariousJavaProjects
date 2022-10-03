public class Testa {

	public synchronized void m1() {
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(2000);
			
		} catch (InterruptedException ie) {
		}
	}

	public synchronized void m2() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ie) {
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final Testa t = new Testa();
		Thread t1 = new Thread() {
			public void run() {
				t.m1();
				
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				t.m1();
			}
		};

		t1.start();
		//Thread.sleep(500);
		//System.out.println(t1.getState());
		t2.start();
		Thread.sleep(1);

		System.out.println(t2.getState());
	}
}
