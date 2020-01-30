public class Application {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Student student = new Student("Abraham", 30, 3.86);
		Serializer serializer = new Serializer();
		serializer.serialize(student, "src/serialize.txt");

		Student deSerializedStudent = serializer
				.deSerialize("src/serialize.txt");
		if (deSerializedStudent != null) {
			System.out.println(deSerializedStudent.toString());
		}
	}

}
