
  public class Test {

    public static void main(String[] args) throws InterruptedException{
      Counter counter = new Counter();
      Thread  threadA = new AdderThread(counter);
      Thread  threadB = new SubtractorThread(counter);
      //Example example=new Example();

      threadA.start();
      //threadA.sleep(100);       
      threadB.start(); 
      //example.start();
      //threadB.sleep(100);
     // System.out.println("The State of "+threadB.getName()+" is "+threadB.getState());
    }
  }