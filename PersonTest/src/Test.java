
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Person p=new Person();
      p.setName("TestName");
      changeName(p);
     System.out.println( p.getName());
     }
	public static void changeName(Person p) {
		Person p1=new Person();
		p1.setName("Other");
		p=p1;
	}

}
