import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {
	

	public void serialize(Student student,String file) {
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new FileOutputStream(file))) {
			objectOutputStream.writeObject(student);
			System.out.println("Student has been Serialized");

		} catch (Exception e) {
			System.out.println("Serialization failed");
			System.out.println(e.getMessage());
		}
	}
	
	public Student deSerialize(String file) {
		Student student=null;
		try (ObjectInputStream objectInputStream = new ObjectInputStream(
				new FileInputStream(file))) {
			student= (Student) objectInputStream.readObject();
			System.out.println("Student has been DeSerialized");			

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("A problem occured during Deserialization");
			System.out.println(e.getMessage());
		}
		return student;
	}
}
