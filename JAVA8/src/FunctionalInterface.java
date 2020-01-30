//a functionalInterface can extend other other interface,
//as long as that other interface doesn't have abstract method.
//@FunctionalInterface
interface Sayablee extends Doable{  
    abstract void say(String msg);   // abstract method  
}  

public class FunctionalInterface implements Sayablee{  
    public void say(String msg){  
        System.out.println(msg);  
    }  
    public static void main(String[] args) {  
    	FunctionalInterface fie = new FunctionalInterface();  
        fie.say("Hello there");  
        fie.doIt();  
    }  
} 

	
	

