package doubleNumberTest;

import java.math.BigDecimal;

public class DoubleTest {

	public static void main(String[] args) {
         /**
          * The double data type adheres to the IEEE 754 standard for floating-point arithmetic, 
		    using a finite number of bits (64 bits) to approximate real numbers.
		    double a=0.1,the binary representation of this value doesn't accurately represent the number 0.1, 
		    but the approximate representation= 0.1000000000000000055...
          */
		double a=0.1; // Actually 0.1000000000000000055511151231257827021181583404541015625
		double b = 0.2;// Actually ~0.2000000000000000111...
		double sum = a + b;  // Actually ~0.3000000000000000444...
		System.out.println("a = "+a); // prints 0.1 because Java uses toString() internally - which rounds for readability to 0.1
		System.out.println("b = "+b);
		System.out.println("sum(a+b) = "+sum);
		/**
		 * Double.toString() uses a clever algorithm that:
           1. Finds the shortest decimal string that uniquely identifies that binary floating-point value
           2. For 0.2, "0.2" is good enough
           3. For 0.1 + 0.2, the error is large enough that it needs "0.30000000000000004" to be accurate
		 */
		//When creating BigDecimal out of double always use valueOf()or string method of BigDecimal
		BigDecimal dec= new BigDecimal(0.1);// you are passing the actual double representation in binary representation of 0.1= 0.1000000000000000055511151231257827021181583404541015625
		System.out.println("BigDecimal from double dec = "+dec);
		
		BigDecimal dec1= new BigDecimal("0.1");// This is the right way "0.1" string literal
		System.out.println("from string dec1 = "+ dec1);
		
		/**
		 * BigDecimal.valueOf(double) uses Double.toString() internally, 
		 * which gives you the shortest decimal representation:
           So it converts 0.1--> "0.1" --> BigDecimal("0.1")
		 */
		BigDecimal dec2 = BigDecimal.valueOf(0.1);
		BigDecimal dec3 = BigDecimal.valueOf(0.1d); // Same thing as above
		
		System.out.println("BigDecimal from double using valueOf dec2 = "+dec2);
		System.out.println("BigDecimal from %d dec3 = "+dec3);
		
		BigDecimal dec4= BigDecimal.valueOf(0.2);
		System.out.println("BigDecimal from double using valueOf dec4 = "+dec4);
		System.out.println("BigDecimal dec3.add(dec4) = "+dec3.add(dec4));
		

	}
	
	public static void charAsciiConversion() {
		char letter='A';
		System.out.println(letter+1);
		char letter2='A';
		char letter3=(char)(letter2+1);
		System.out.println(letter3);
	}

}
