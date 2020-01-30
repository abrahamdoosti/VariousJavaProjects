

public class Application {

	public static void main(String[] args) {
		long num=100000000;
		//System.out.println(Collatz.computeTime(47));
		CollatzObject myCollatz=Collatz.getLongestCollatzTime(num);
		System.out.println("Longest Collatz series for numbers less than "+num+" is "+
		myCollatz.getCollatzLength()+" for the number "+myCollatz.getNum());
		
		long[] myList=Collatz.getCollatzSeries(myCollatz.getNum());
		for(long i:myList){
			
			System.out.print(i+" ");
		}
		
		System.out.println("\ntotal steps="+myList.length);
	}

}
