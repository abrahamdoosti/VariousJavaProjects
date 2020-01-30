
public class AdderThread extends Thread {
	
	private Counter counter;
	
	public AdderThread(Counter counter){
		this.counter=counter;
	}
	
	public void run(){
		//System.out.println("Starting thread "+ this.getName());
		counter.add(1);		
		//System.out.println(this.getName()+" is complete");
		
		
	}

}
