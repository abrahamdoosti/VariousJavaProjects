import java.io.IOException;

public class RunTimeApp {

	public static void main(String[] args) {
		try {
			System.out.println("Executing notepad.exe");
			Process process = Runtime.getRuntime().exec("notepad.exe");			
			System.out.println("Notepad should be open now");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
