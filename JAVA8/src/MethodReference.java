import java.util.Comparator;

interface Sayable{
	void say();
}
public class MethodReference {
	public static void saySomething(){
		System.out.println("Hello, this is static method.");
	}
	public static void main(String[] args) {
		
		String str=new String("abebe");
		String str1=new String("abebe");
		System.out.println(str==str1);
		System.out.println(str.equals(str1));
		System.out.println( (str.compareTo("bbebe")));
		System.out.println( (str.compareTo("bekele")));
		System.out.println( (str.compareTo("a")));
	    // Referring static method
	    Sayable sayable = new Sayable() {

			@Override
			public void say() {
				System.out.println("Hello, this is static method.");
				
			}
	    	
	    };
	    Comparator<Product> myComparator=(Product p1, Product p2)->
	    {
	    	return p1.name.compareTo(p2.name);
	    };
	    
	    		//MethodReference::saySomething;
	    // Calling interface method
	    sayable.say();
	    Sayable sayable1=MethodReference1::saySomething;
	    
	    sayable1.say();
	    
	}
}

 class MethodReference1 {
	public static void saySomething(){
		System.out.println("Hello, this is static method1.");
	}
	
}
