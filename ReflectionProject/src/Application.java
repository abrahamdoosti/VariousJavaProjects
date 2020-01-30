import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Application {
	public static void main(String[] args) {

		/**
		 * 1. Below is the First method of analyzing the class using forName()
		 * method of Class class
		 */
		// Class c=null;
		// try {
		// c = Class.forName("MyMath");
		// } catch (ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// Method[] methods=c.getMethods();

		/**
		 * 2. using the getClass() method of Class class Below is the sample
		 * code how to do it
		 */
		 MyMath math=new MyMath();
		 Class c=math.getClass();
		 Method[] methods=c.getMethods();
		 Method adderMethod=methods[0];
		 adderMethod.setAccessible(true);
		 try {
			System.out.println(adderMethod.invoke(math, 1,2));
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
				 
		

		/**
		 * 3. using the .class syntax. If a type is available but there is no
		 * instance then it is possible to obtain a Class by appending ".class"
		 * to the name of the type.It can be used for primitive data type also.
		 */
		
//		Class c =MyMath.class;
//		Method[] methods=c.getMethods();
//		System.out.println("using the .class method");
//		for (Method m : methods) {		
//			System.out.println(m + " , ");
//		}

	}

}
