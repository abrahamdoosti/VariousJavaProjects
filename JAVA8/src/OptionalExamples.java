import java.util.Optional;

import org.slf4j.LoggerFactory;

public class OptionalExamples {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(OptionalExamples.class);
	private static final String TEXT_SAMPLE = "Text present";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String firstName = "fTest";
		String lastName = "lTest";
		boolean isStudentNull=true;
		
		//Optional<String> empty = Optional.empty();
		//empty.ifPresent(System.out::println);

		// Optional.of() throws NPE if you pass null
		Optional<String> sample = Optional.of("test");
		sample.ifPresent(System.out::println);
		
		// Optional.ofNullable() can take null as well
		Optional<String> sampleNullable = Optional.ofNullable(null);
		sampleNullable.ifPresent(System.out::println);

		
		
		Optional<Student> student = Optional.ofNullable(new Student());
		
		//make student null to see the other scenario.
		if (isStudentNull) {
			student = Optional.ofNullable(null);
		}
		if (!student.isPresent()) {
			logger.warn("can't find student with the following search criteria firstName:{}", firstName,
					lastName);
		}
		student.ifPresent(x -> {
			x.setFirstname("firstname");
			x.setLastname("lastname");
			System.out.println("with first and last name " + x.toString());
		});
		

		/// Default Value With orElse()
		String nullName = null;
		String sampleOrElse = Optional.ofNullable(nullName).orElse("john");
		System.out.println(sampleOrElse);

		// orElse vs orElseGet subtle diff when the value inside ofNullable() is not
		// null
		// For orElse() the default object is created whether the wrapped value is null
		// or not
		/*
		 * In this simple example, there is no significant cost to creating a default
		 * object, as the JVM knows how to deal with such. However, when a method such
		 * as getMyDefault() has to make a web service call or even query a database,
		 * the cost becomes very obvious.
		 */
//		String text = TEXT_SAMPLE;
//		System.out.println("Using orElseGet:");
//		String defaultText = Optional.ofNullable(text).orElseGet(OptionalExamples::getMyDefault);
//		System.out.println(TEXT_SAMPLE.equals(defaultText));
//
//		System.out.println("Using orElse:");
//		defaultText = Optional.ofNullable(text).orElse(getMyDefault());
//		System.out.println(TEXT_SAMPLE.equals(defaultText));

	}

	public static String getMyDefault() {
		System.out.println("Getting Default Value");
		return "Default Value";
	}

}

class Student {
	private String firstname;
	private String lastname;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Student [firstname=" + firstname + ", lastname=" + lastname + "]";
	}

}
