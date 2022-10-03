import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import com.sun.org.apache.xpath.internal.operations.Equals;

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
        
        UnaryOperator<String> quote = s -> "'" + s + "'";
        System.out.println(quote.apply("test"));
        
        //Two-Arity Function        
        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 40000);
        salaries.put("Freddy", 30000);
        salaries.put("Samuel", 50000);
        salaries.replaceAll((name, oldValue) -> 
          name.equals("Freddy") ? oldValue : oldValue + 10000);
        salaries.forEach((x,y)->System.out.println(x+" "+y));
        
        //Consumers
        Map<String, Integer> ages = new HashMap<>();
        ages.put("John", 25);
        ages.put("Freddy", 24);
        ages.put("Samuel", 30);
        //BiConsumer is one of the consumer Functional Interface
        ages.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));
        
        //Predicates
        List<String> names = Arrays.asList("Angela", "Aaron", "Bob", "Claire", "David");

        List<String> namesWithA = names.stream()
          .filter(name -> name.startsWith("A"))
          .collect(Collectors.toList());
        
        names.forEach(System.out::println);
        namesWithA.forEach(System.out::println);
        
        //Operators
        List<BigDecimal> decimals=new ArrayList<>();
        decimals.add(BigDecimal.valueOf(12.56));
        decimals.add(BigDecimal.valueOf(7.44));
        System.out.println(decimals.stream().reduce(BigDecimal.ZERO,BigDecimal::add));
        
        
        
    }  
} 

	
	

