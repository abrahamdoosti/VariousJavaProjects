
public class ExceptionMain {

	public static void main(String[] args) {
		try {
			//throw new NumberFormatException();
			//throw new ArithmeticException();
			throw new NullPointerException();

		} catch (NumberFormatException e) {
			System.out.println("Number Format exception");
			throw new ArithmeticException();
		} catch (Exception e) {
			System.out.println("Just exception");
		}
	}

}
