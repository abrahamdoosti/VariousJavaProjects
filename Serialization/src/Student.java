import java.io.Serializable;


public class Student implements Serializable {
	

	private String name;
	private int age;
	private double gpa;
	public Student(String name, int age, double gpa) {
		super();
		this.name = name;
		this.age = age;
		this.gpa = gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public double getGpa() {
		return gpa;
	}
	
//	public String toString(){
//		return "Name "+name+" Age "+age+" GPA= "+gpa;
//	}
	

}
